#include <stdio.h>

int question3() {
	int num1;

	//Question 3
	printf("Please, enter a 5-digit postive integer number: ");
	scanf_s("%d", &num1);

	if (num1 >= 10000 && num1 <= 99999) {
		printf("%d   ", num1 / 10000);
		printf("%d   ", (num1 / 1000) % 10);
		printf("%d   ", (num1 / 100) % 10);
		printf("%d   ", (num1 / 10) % 10);
		printf("%d", num1 % 10);
	}
	else {
		printf("You entered an invalid number.");
	}
}