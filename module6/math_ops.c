#include <stdio.h>

void print_math(int a, int b);

int main() {
    int a, b;
    printf("Enter first number: ");
    scanf("%d", &a);
    printf("Enter second number: ");
    scanf("%d", &b);
    print_math(a, b);
    return 0;
}

void print_math(int a, int b) {
    printf("Sum of %d and %d: %d\n", a, b, a + b);
    printf("Product of %d and %d: %d\n", a, b, a * b);
}