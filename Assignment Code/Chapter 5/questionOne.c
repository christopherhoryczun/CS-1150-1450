#include <stdio.h>

int questionOne() {
	int positiveInt, reverse = 0, remainder;
	
	//Question
	printf("Please, enter a positive integer number: ");
	scanf_s("%d", &positiveInt);

	//if positive Int it less than or equal to zero
	if (positiveInt <= 0) {
		puts("Invalid Input");
	}
	//if greater than 0
	else {
		while (positiveInt != 0) {
			//remove last digit
			remainder = positiveInt % 10;

			//build the reverse number
			reverse = reverse * 10 + remainder;

			//remove the last digit
			positiveInt = positiveInt / 10;
		}
		printf("The number after reverse its digit is : %d\n", reverse);
	}


	//return value
	return -1;
}