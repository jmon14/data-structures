#include <iostream>

#define MAX_SIZE 100

int A[MAX_SIZE];
int top = -1;

void Push(int x) {
    if (top == MAX_SIZE - 1) {
        printf("Error: stack overflow\n");
        return;
    }
    A[++top] = x;
}

void Pop() {
    if (top == -1) {
        printf("Error: No element to pop\n");
    }
    top--;
}

int Top() {
    return A[top];
}

void Print() {
    printf("Stack: ");
    for(int i = 0; i <=top; i++){
        printf("%d ", A[i]);
    }
    printf("\n");
}

int main(int argc, const char * argv[]) {
    Push(2);
    Push(10);
    Push(5);
    Pop();
    Push(12);
    Print();
}
