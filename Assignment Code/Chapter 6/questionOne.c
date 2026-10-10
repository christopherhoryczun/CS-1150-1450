#include <stdio.h>
#include <stdlib.h>
#include <time.h>

#define MAX 1000

double calcMean(int arr[], int size);
double calcMedian(int arr[], int size);
void calcMode(int arr[], int size);
void sortArray(int arr[], int size);

int questionOne() {
    int size;

    do {
        printf("Please, enter the size of the array: ");
        scanf_s("%d", &size);

        if (size <= 0 || size > MAX) {
            printf("Invalid Input\n\n");
        }
    } while (size <= 0 || size > MAX);

    int arr[MAX];

    srand(time(NULL));
    for (int i = 0; i < size; i++) {
        arr[i] = (rand() % 10) + 1;
    }

    printf("The mean is: %.4f\n\n", calcMean(arr, size));

    printf("The unsorted array is:\n");
    for (int i = 0; i < size; i++)
        printf("%d ", arr[i]);
    printf("\n\n");

    sortArray(arr, size);

    printf("The sorted array is:\n");
    for (int i = 0; i < size; i++)
        printf("%d ", arr[i]);
    printf("\n\n");

    printf("The median is: %.4f\n\n", calcMedian(arr, size));

    calcMode(arr, size);

    return 0;
}

double calcMean(int arr[], int size) {
    int sum = 0;
    for (int i = 0; i < size; i++)
        sum += arr[i];
    return (double)sum / size;
}

double calcMedian(int arr[], int size) {
    if (size % 2 == 1)
        return arr[size / 2];
    return (arr[size / 2 - 1] + arr[size / 2]) / 2.0;
}

void sortArray(int arr[], int size) {
    for (int i = 0; i < size - 1; i++) {
        for (int j = 0; j < size - i - 1; j++) {
            if (arr[j] > arr[j + 1]) {
                int temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
            }
        }
    }
}

void calcMode(int arr[], int size) {
    int freq[11] = { 0 };
    int maxFreq = 0;

    for (int i = 0; i < size; i++) {
        freq[arr[i]]++;
        if (freq[arr[i]] > maxFreq)
            maxFreq = freq[arr[i]];
    }

    int count = 0;
    for (int i = 1; i <= 10; i++)
        if (freq[i] == maxFreq)
            count++;

    if (count == 1) {
        printf("The data is unimodal.\nThe value is: ");
    }
    else if (count == 2) {
        printf("The data is bimodal.\nThe values are: ");
    }
    else {
        printf("The data is multimodal.\nThe values are: ");
    }

    for (int i = 1; i <= 10; i++)
        if (freq[i] == maxFreq)
            printf("%d ", i);

    printf("\n");
}
