#include <iostream>
#include <stack>
using namespace std;

bool isBalanced(string sample);

int main() {
    string code = "{()}[]";
    bool balanced = isBalanced(code);
    printf(balanced ? "Balanced\n" : "Unbalanced\n");
}

bool isBalanced(string sample) {
    stack<char> balancer;
    
    for (int i = 0; i < sample.length(); i++) {
        if (balancer.empty()) {
            balancer.push(sample[i]);
        } else if ((sample[i] == '}' && balancer.top() == '{') ||
                   (sample[i] == ']' && balancer.top() == '[') ||
                   (sample[i] == ')' && balancer.top() == '(')) {
            balancer.pop();
        } else {
            balancer.push(sample[i]);
        }
    }
    
    if (balancer.empty()) {
        return true;
    }
    return false;
}
