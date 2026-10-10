#include <stdio.h>

int question1() {

	int num1;
	int num2;

	//Question 1

	printf("Please enter the first integer: ");
	scanf_s("%d", &num1);

	printf("Please enter the second integer: ");
	scanf_s("%d", &num2);

	if (num1 >= num2) {
		printf("The maximum number is: %d\n", num1);
	}
	else {
		printf("The maximum number is: %d\n", num2);
	}
	return 0;
}
