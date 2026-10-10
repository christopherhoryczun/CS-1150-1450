#include <stdio.h>

int question2() {
	int num1;
	int num2;

	printf("Please, enter the first integer number: ");
	scanf_s("%d", &num1);

	printf("Please, enter the second integer number: ");
	scanf_s("%d", &num2);

	if (num2 != 0 && num1 % num2 == 0) {
		printf("%d is multiple of %d\n", num1, num2);
	}
	else {
		printf("%d is not multiple of %d\n", num1, num2);
	}
}