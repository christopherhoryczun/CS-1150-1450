#include <stdio.h>

int questionOne(void) {
	int numLine = 0;
	printf("Please enter the number of lines (Postivie Integer) : ");
	scanf_s("%d", &numLine);

	if (numLine > 0) {
        //Group One
        for (int i = 1; i <= numLine; i++) {
            for (int j = 1; j <= i; j++) {
                printf("*");
            }
            printf("\n");
        }

        printf("\n");

        //Group Two
        for (int i = numLine; i >= 1; i--) {
            for (int j = 1; j <= i; j++) {
                printf("*");
            }
            printf("\n");
        }

        printf("\n");

        //Group Three
        for (int i = 1; i <= numLine; i++) {
            for (int j = 1; j <= i; j++) {
                printf("*");
            }
            printf("\n");
        }
        printf("\n");

        //Group Four
        for (int i = numLine; i >= 1; i--) {
            for (int j = 1; j <= i; j++) {
                printf("*");
            }
            printf("\n");
        }

	}
	else {
		puts("Invalid Input");
	}

	return 0;
}