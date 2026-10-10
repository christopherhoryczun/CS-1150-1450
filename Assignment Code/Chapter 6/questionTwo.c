#include <stdio.h>

void printArrayReverse(int arr[], int size) {
    if (size == 0)
        return;
    printf("%d ", arr[size - 1]);
    printArrayReverse(arr, size - 1);
}

int questionTwo() {
    int a[] = { 1,2,3,4,5,6,7,8,9,10 };
    int b[] = { -1,2,-5,9,-10 };

    int sizeA = sizeof(a) / sizeof(a[0]);
    int sizeB = sizeof(b) / sizeof(b[0]);

    printf("Array elements (in reverse order) are: ");
    printArrayReverse(a, sizeA);
    printf("\n\n");

    printf("Array elements (in reverse order) are: ");
    printArrayReverse(b, sizeB);
    printf("\n");

    return 0;
}
