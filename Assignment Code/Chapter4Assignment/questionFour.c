#include <stdio.h>

int questionFour(void) {
	//use scanf_s() with a space before %c. The space in the format string tells scanf_s to skip any whitespace
	//characters (including newlines, tabs, and spaces) before reading a non-whitespace character.

	//int, char, for assignment
	char operation;
	int num1;
	int num2;

	//Intro Info
	puts("+ for addition\n- for sutraction\n* for multiplication\n/ for floating-point divison\nq to exit\n");

	//Operation Question
	printf("Please, enter the operations: ");
	scanf_s(" %c", &operation);

	if (operation == '+' || operation == '-' || operation == '*' || operation == '/') {
		int result;

		//Number 1
		printf("Please, enter the first operand: ");
		scanf_s("%d", &num1);

		//Number 2
		printf("Please, enter the second operand: ");
		scanf_s("%d", &num2);

		switch (operation) {
		case '+':
			result = num1 + num2;
			printf("%d %c %d = %d", num1, operation, num2, result);
			break;
		case '-':
			result = num1 - num2;
			printf("%d %c %d = %d", num1, operation, num2, result);
			break;
		case '*':
			result = num1 * num2;
			printf("%d %c %d = %d", num1, operation, num2, result);
			break;
		case '/':
			if (num2 == 0) {
				puts("Divison ny zero is not allowed");
			}
			else {
				result = num1 / num2;
				printf("%d %c %d = %d", num1, operation, num2, result);
			}
			break;
		default:
			puts("System Error");
			break;
		}

	} else 
		switch (operation) {
		case 'q':
			puts("Thank you");
			break;
		case 'Q':
			puts("Thank you");
			break;
		default:
			puts("Incorrect Operation");
		}

	return 0;
}