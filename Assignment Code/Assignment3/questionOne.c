#include <stdio.h>

int questionOne(void) {
	int numOfValues = 0;
	printf("Please, enter the number values (postive integer): ");
	scanf_s ("%d", &numOfValues);
	
	if (numOfValues > 0) {

		int integer = 0;
		int maxOne = 0;
		int maxTwo = 0;

		//no for loops
		int counter = 0;
		while (counter < numOfValues) {
			printf("Please, enter an integer value: ");
			scanf_s("%d", &integer);

			//find maxOne
			if (integer > maxOne) {
				maxTwo = maxOne;
				maxOne = integer;
			}
			else  if (integer > maxTwo && maxOne > integer) {
				maxTwo = integer;
			}//end of else if

			counter++;
		}//end of while loop

		if (maxOne == maxTwo) {
			printf("The maximum is: %d\n", maxOne);
			puts("There is no second maximum");
		}//end of if
		else {
			printf("The maximum is: %d\n", maxOne);
			printf("The second maximum is %d\n", maxTwo);
		}//end of else
		

	}//end of if statement
	else {
		puts("Invalid integer");
	}//end of else

	return 0;
}//end of main