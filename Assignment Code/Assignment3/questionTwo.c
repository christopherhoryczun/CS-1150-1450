#include <stdio.h>

int questionTwo(void) {

	int numOfLine = 0;
	printf("Please, enter the number of lines (positive integer): ");
	scanf_s("%d", &numOfLine);

	if (numOfLine > 0) {
		// print header 
		printf("\nNumber\t\tNumber^2\tNumber^3\n");
		// print values using while
		int n = 1;
		while (n <= numOfLine) {
			int square = n * n; 
			int cube = n * n * n;
			printf("%d\t\t%d\t\t%d\n", n, square, cube); n++; }
		
	}//end of if statement

	else {

		puts("Invalid Input");

	}//end of if else statement

}//Question Two
