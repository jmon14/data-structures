#include <iostream>
#include <queue>
using namespace std;

// BST node
struct Node {
    int data;
    Node* left;
    Node* right;
};

// BFS algorithm
void LevelOrder(Node* rootPtr) {
    if (rootPtr == NULL) return;
    queue<Node*> Q;
    Q.push(rootPtr);
    // While there is at least one discovered node
    while (!Q.empty()) {
        Node* current = Q.front();
        cout<<current->data<<" ";
        if (current->left != NULL) Q.push(current->left);
        if (current->right != NULL) Q.push(current->right);
        Q.pop();
    }
}

// Create a new node and return it
Node* GetNewNode(int data) {
    Node* newNode = new Node();
    newNode->data = data;
    newNode->left = newNode->right = NULL;
    return newNode;
}

// Insert node into BST
Node* Insert(Node* rootPtr, int data) {
    if (rootPtr == NULL) {
        rootPtr = GetNewNode(data);
    } else if (data <= rootPtr->data) {
        rootPtr->left = Insert(rootPtr->left, data);
    } else {
        rootPtr->right = Insert(rootPtr->right, data);
    }
    return rootPtr;
}

// Search for data in BST
bool Search(Node* rootPtr, int data) {
    if (rootPtr == NULL) return false;
    else if (rootPtr->data == data) return true;
    else if (data <= rootPtr->data) return Search(rootPtr->left, data);
    else return Search(rootPtr->right, data);
}

// Find minimum value in BST
int FindMin(Node* rootPtr) {
    if (rootPtr == NULL) {
        cout<<"Error: BST is empty"<<endl;
        return -1;
    } else if (rootPtr->left == NULL) {
        return rootPtr->data;
    }
    return FindMin(rootPtr->left);
}

// Find maximum value in BST
int FindMax(Node* rootPtr) {
    if (rootPtr == NULL) {
        cout<<"Error: BST is empty"<<endl;
        return -1;
    } else if (rootPtr->right == NULL) {
        return rootPtr->data;
    }
    return FindMax(rootPtr->right);
}

// Find height of BST
int FindHeight(Node* rootPtr) {
    if (rootPtr == NULL) {
        return -1;
    }
    return max(FindHeight(rootPtr->left), FindHeight(rootPtr->right)) + 1;
}

int main() {
    Node* root = NULL;
    root = Insert(root, 16);
    root = Insert(root, 4);
    root = Insert(root, 23);
    root = Insert(root, 8);
    root = Insert(root, 15);
    root = Insert(root, 42);
    
    int min = FindMin(root);
    
    cout<<"Minimum value in tree is: "<<min<<endl;
    cout<<"Height of tree is: "<<FindHeight(root)<<endl;
    
    return 0;
}
