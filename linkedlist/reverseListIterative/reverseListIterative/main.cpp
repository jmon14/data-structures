#include <iostream>

struct Node {
    int data;
    Node* next;
};

Node* head;
void Insert(int data);
void Print();
void Reverse();

int main() {
    head = NULL;
    Insert(2);
    Insert(4);
    Insert(6);
    Insert(5);
    Print();
    Reverse();
    Print();
}

void Insert(int n) {
    Node* temp1 = head;
    Node* temp2 = new Node();
    temp2->data = n;
    temp2->next = NULL;
    if (head == NULL) {
        head = temp2;
        return;
    }
    while (temp1->next != NULL)
        temp1 = temp1->next;
    temp1->next = temp2;
}

void Print() {
    Node* temp1 = head;
    while (temp1->next != NULL) {
        printf("%d ", temp1->data);
        temp1 = temp1->next;
    }
    printf("%d\n", temp1->data);
}

void Reverse() {
    Node* last = NULL;
    Node* next = head->next;
    while (next != NULL) {
        head->next = last;
        last = head;
        head = next;
        next = next->next;
    }
    head->next = last;
}
