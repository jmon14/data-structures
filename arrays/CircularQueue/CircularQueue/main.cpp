#include<iostream>
#define QUEUE_LENGTH 10

using namespace std;

int cqueue[QUEUE_LENGTH];
int front = -1, rear = -1, n = QUEUE_LENGTH;

void insertCQ(int val) {
    if ((front == 0 && rear == n-1) || (front == rear+1)) {
       cout<<"Queue Overflow"<<endl;
       return;
    }
    if (front == -1) {
       front = 0;
       rear = 0;
    } else {
       if (rear == n - 1)
       rear = 0;
       else
       rear = rear + 1;
    }
    cqueue[rear] = val;
}

void deleteCQ() {
    if (front == -1) {
       cout<<"Queue Underflow"<<endl;
       return ;
    }
    cout<<"Element deleted from queue is : "<<cqueue[front]<<endl;

    if (front == rear) {
       front = -1;
       rear = -1;
    } else {
       if (front == n - 1)
       front = 0;
       else
       front = front + 1;
    }
}

void Print() {
    int f = front, r = rear;
    if (front == -1) {
       cout<<"Queue is empty"<<endl;
       return;
    }
    cout<<"Queue elements are:"<<endl;
    if (f <= r) {
       while (f <= r){
          cout<<cqueue[f]<<" ";
          f++;
       }
    } else {
       while (f <= n - 1) {
          cout<<cqueue[f]<<" ";
          f++;
       }
       f = 0;
       while (f <= r) {
          cout<<cqueue[f]<<" ";
          f++;
       }
    }
    cout<<endl;
}

int main() {
    int ch, val;
    cout<<"1)Insert"<<endl;
    cout<<"2)Delete"<<endl;
    cout<<"3)Display"<<endl;
    cout<<"4)Exit"<<endl;
    do {
       cout<<"Enter choice:"<<endl;
       if(!(cin >> ch))
       {
           cout << "Please enter numbers only:"<<endl;
           cin.clear();
           cin.ignore(10000, '\n');
       }
       switch(ch) {
          case 1:
               cout<<"Input for insertion:"<<endl;
               cin>>val;
               insertCQ(val);
               break;

          case 2:
               deleteCQ();
               break;

          case 3:
               Print();
               break;

          case 4:
               cout<<"Exit"<<endl;
               break;

          default: cout<<"Incorrect!"<<endl;
       }
    } while(ch != 4);
    return 0;
}
