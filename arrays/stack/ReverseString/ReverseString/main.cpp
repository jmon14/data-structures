#include<stack>

using namespace std;

void Reverse(char *C, size_t n){
    stack<char> S;
    for (int i = 0; i < n; i++) {
        S.push(C[i]);
    }
    for (int i = 0; i < n; i++) {
        C[i] = S.top();
        S.pop();
    }
};

int main(int argc, const char * argv[]) {
    char C[51];
    printf("Enter a string: ");
    scanf("%[^\n]%*c", C);
    Reverse(C, strlen(C));
    printf("Output: %s\n", C);
}
