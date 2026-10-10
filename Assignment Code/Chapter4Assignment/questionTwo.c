#include <stdio.h>

int questionTwo(void) {

    //Needed Terms
    int numTerm;
    double pi = 0.0;
    
    //So we are alternating between +1 and -1
    int sign = 1;

    // Keep asking until user enters a positive integer
    while (1) {

        //Ask the Question
        printf("Please, enter the number of terms (positive integer): ");
        scanf_s("%d", &numTerm);

        //If invalid input
        if (numTerm <= 0) {
            printf("Invalid input.\n");
        }
        else {
            break; // valid input → exit loop
        }
    }

    // Calculate π using the Leibniz formula
    for (int i = 0; i < numTerm; i++) {
        pi += sign * (4.0 / (2 * i + 1));
        sign *= -1; // alternate sign
    }

    // Display result
    printf("After calculating %d term(s), the value of PI is %f\n", numTerm, pi);

    return 0;
}