#include <stdio.h>

int questionThree() {
	int number = 0;
	printf("Please enter a number (non-negative integer); ");
	scanf_s("%d", &number);

	if (number >= 0) {

		int sum = 0;
		int tempNumber = number;
		
		while (tempNumber > 0) {
			sum += tempNumber % 10;
			tempNumber = tempNumber / 10;
		}
		
		printf("The sum of digits is: %d\n", sum);
	}
	else {
		puts("Invalid Number");
	}//if statement

	return 0;

}//Question Three