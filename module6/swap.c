#include<stdio.h>

void swap(int *a, int *b);
void swap_doubles(double *a, double *b);
void swap_chars(char *a, char *b);
void broken_swap(int x, int y);

int main() {
    int x, y;
    double dx, dy;
    char cx, cy;

    printf("Enter first number: ");
    scanf("%d", &x);
    printf("Enter second number: ");
    scanf("%d", &y);
    
    printf("Before swap: x = %d, y = %d\n", x, y);
    swap(&x, &y);
    printf("After swap: x = %d, y = %d\n", x, y);
    
    // this is to demonstrate that the broken swap function does not work as intended. because it takes the values of x and y, not their addresses, it cannot modify the original variables in main.
    printf("\nDemonstrating broken swap function:\n");
    printf("Before broken swap: x = %d, y = %d\n", x, y);
    broken_swap(x, y);
    printf("After broken swap: x = %d, y = %d\n", x, y);

    // double swap
    printf("\nEnter first double: ");
    scanf("%lf", &dx);
    printf("Enter second double: ");
    scanf("%lf", &dy);

    printf("Before swap: dx = %g, dy = %g\n", dx, dy);
    swap_doubles(&dx, &dy);
    printf("After swap: dx = %g, dy = %g\n", dx, dy);

    // char swap
    printf("\nEnter first char: ");
    scanf(" %c", &cx);
    printf("Enter second char: ");
    scanf(" %c", &cy);

    printf("Before swap: cx = %c, cy = %c\n", cx, cy);
    swap_chars(&cx, &cy);
    printf("After swap: cx = %c, cy = %c\n", cx, cy);

    return 0;
}

void broken_swap(int x, int y) {
    int temp = x;
    x = y;
    y = temp;
}

void swap(int *x, int *y) {
    int temp = *x;
    *x = *y;
    *y = temp;
}

void swap_doubles(double *dx, double *dy) {
    double temp = *dx;
    *dx = *dy;
    *dy = temp;
}

void swap_chars(char *cx, char *cy) {
    char temp = *cx;
    *cx = *cy;
    *cy = temp;
}