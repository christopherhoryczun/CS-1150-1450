#include <stdio.h>

// Function to compute GCD non-recursively
int gcdNonRecursive(int a, int b) {
    int temp;

    // Convert negative numbers to positive
    if (a < 0) a = -a;
    if (b < 0) b = -b;

    // Use Euclidean algorithm (iterative)
    while (b != 0) {
        temp = b;
        b = a % b;
        a = temp;
    }

    return a;
}

// Function to compute GCD recursively
int gcdRecursive(int a, int b) {
    // Convert negative numbers to positive
    if (a < 0) a = -a;
    if (b < 0) b = -b;

    if (b == 0)
        return a;
    else
        return gcdRecursive(b, a % b);
}

int questionTwo(void) {
    int num1, num2;

    printf("Please, enter two integer numbers: ");
    scanf_s("%d %d", &num1, &num2);

    printf("The greatest common divisor is (using a non-recursive function): %d\n",
        gcdNonRecursive(num1, num2));

    printf("The greatest common divisor is (using a recursive function): %d\n",
        gcdRecursive(num1, num2));

    return 0;
}
