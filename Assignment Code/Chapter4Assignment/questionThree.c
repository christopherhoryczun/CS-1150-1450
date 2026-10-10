#include <stdio.h>

int questionThree(void) {
    int number;

    while (1) {
        printf("Please, enter a number (from 1 to 28): ");
        scanf_s("%d", &number);

        if (number == 0) {
            printf("Thank you\n");
            break;
        }

        if (number < 1 || number > 28) {
            printf("Invalid input. Please enter a number from 1 to 28 (or 0 to stop).\n");
            continue;
        }

        if (number >= 1 && number <= 26) {
            // Reverse alphabet: a = 26, z = 1
            char letter = 'a' + (26 - number);
            printf("The character is: %c\n", letter);
        }
        else if (number == 27) {
            printf("The character is: !\n");
        }
        else if (number == 28) {
            printf("The character is: ?\n");
        }
    }

    return 0;
}