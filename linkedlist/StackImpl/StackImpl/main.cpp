#include <iostream>

struct Node {
    int data;
    struct Node* link;
};

struct Node* top;

void Push(int x) {
    struct Node* temp = new Node();
    temp->data = x;
    temp->link = top;
    top = temp;
}

void Pop() {
    if (top == NULL) return;
    struct Node* temp = top;
    top = top->link;
    delete temp;
}

int main(int argc, const char * argv[]) {
    // insert code here...
    std::cout << "Hello, World!\n";
    return 0;
}
