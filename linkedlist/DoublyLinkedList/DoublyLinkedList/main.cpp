#include <iostream>

struct Node {
    int data;
    struct Node* next;
    struct Node* prev;
};

struct Node* head;
struct Node* tail;

struct Node* GetNewNode(int x) {
    struct Node* newNode = new Node();
    newNode->data = x;
    newNode->prev = NULL;
    newNode->next = NULL;
    return newNode;
}

void InsertAtHead(int x) {
    struct Node* newNode = GetNewNode(x);
    if (head == NULL) {
        head = newNode;
        tail = newNode;
        return;
    }
    head->prev = newNode;
    newNode->next = head;
    head = newNode;
}

void InsertAtEnd(int x) {
    struct Node* newNode = GetNewNode(x);
    if (tail == NULL) {
        tail = newNode;
        head = newNode;
        return;
    }
    tail->next = newNode;
    newNode->prev = tail;
    tail = newNode;
}

void Print(bool reverse) {
    struct Node* temp;
    if (reverse) {
        temp = tail;
        printf("Reverse: ");
    } else {
        temp = head;
        printf("Forward: ");
    }
    while(temp != NULL) {
        printf("%d", temp->data);
        if (reverse) {
            temp = temp->prev;
        } else {
            temp = temp->next;
        }
    }
    printf("\n");
}

int main(int argc, const char * argv[]) {
    InsertAtHead(2);
    InsertAtHead(4);
    InsertAtEnd(5);
    InsertAtEnd(6);
    Print(true);
    Print(false);
}
