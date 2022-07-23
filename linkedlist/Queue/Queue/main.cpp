#include <iostream>
using namespace std;

struct Node {
    int data;
    struct Node* next;
};

struct Node* front;
struct Node* rear;

void InsertQueue(int val) {
    struct Node* temp = new Node();
    temp->data = val;
    temp->next = NULL;
    if (front == NULL) {
        front = rear = temp;
        return;
    }
    rear->next = temp;
    rear = temp;
}

void DeleteQueue() {
    if (front == NULL) {
        cout<<"Queue is empty"<<endl;
        return;
    }
    if (front == rear) {
        front = rear = NULL;
        return;
    }
    struct Node* temp = front;
    front = front->next;
    delete temp;
}

void Print() {
    if (front == NULL) {
        cout<<"Queue is empty"<<endl;
        return;
    }
    cout<<"Queue elements are:"<<endl;
    struct Node* temp = front;
    while (temp != NULL) {
        cout<<temp->data<<" ";
        temp = temp->next;
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
           cin.ignore(100, '\n');
           continue;
       }
       switch(ch) {
          case 1:
               cout<<"Input for insertion:"<<endl;
               cin>>val;
               InsertQueue(val);
               break;

          case 2:
               DeleteQueue();
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
