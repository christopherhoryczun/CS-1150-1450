// Solution Assignment #4 CS1150 Spring 2025
//
// Note: 
// This solution code may not be copied, doing so will result in a grade of zero.
// This solution is not for distribution online or by any other means. Copyright M. Gonzalez UCCS

import java.util.Scanner;

public class CS1150_Assignment4_Spring2025 {

	public static void main(String[] args) {
		
		// Constants representing the gift card companies and dollar amounts.
		// STUDENT NOTE: Using constants in code increases readability as
		// you will see in the if-statements below that use these constants.
		final char SUBWAY = 'S';
		final char TACO_BELL = 'T';
		final char WENDYS = 'W';
		final int TEN_DOLLAR = '1';
		final int FIFTEEN_DOLLAR = '2';
		final int THREE_PAK_15_DOLLAR = '3';

		// Create a scanner object to perform console input
		Scanner input = new Scanner(System.in);
		
		// Prompt user for company and amount
		System.out.println ("Enter two characters");
		System.out.println ("S: Subway  T: Taco Bell  W: Wendys");		
		System.out.println ("1: $10 gift card  2: $15 gift card  3: 3-Pak of $15.00");

		// Read the characters entered by the user as one string
		// STUDENT NOTE: You are asked to do this so you can practice extracting information 
		// from a string with the charAt method.
		String companyAndAmount = input.nextLine();
		
		// Extract the company and amount from user input 
		// STUDENT NOTE: extract the character then convert it to an upper case letter so
		// now the constants (defined for upper case 'S', 'T', 'W') can be used in the if statements.
		char company = Character.toUpperCase(companyAndAmount.charAt(0));
		char amount = companyAndAmount.charAt(1);
		String giftCard = "";
		
		// Make sure company is valid 
		// STUDENT NOTE: The OR logical operator is used and all checks are placed into one
		// boolean expression since breaking these up into separate statements would create 
		// redundant code for each company.
		if (company == SUBWAY || company == TACO_BELL || company == WENDYS) { 
			
			// Make sure amount is valid
			if ((amount >= TEN_DOLLAR) && (amount <= THREE_PAK_15_DOLLAR)) {
				
				// Company and amount are both valid - build gift card and display
				// Generate the gift card based on which company was selected
				if (company == SUBWAY) {		
					
					// SUBWAY cards have 3 digits, a dash, 3 letters, a dash, 4 digits => ###-XXX-####
					// Use the random number generator to generate numbers and letters
					// STUDENT NOTE: the Math.random method below as a format of:
					//                a + (int)(Math.random() * b)
					// which generates a random value between a and a+b, excluding a + b
					
					// Use the random number generator to generate a 3 digit number
					// Student Note: This code will generate a number between 100 and 999
					// Here a = 100, b = 900, a + b = 1000
					int threeDigits = 100 + (int)(Math.random() * 900);
					
					// Use the random number generator to generate 3 letters between A and Z.
					// Upper case letters have ASCII code of 65 - 90
					// Need to force random method to generate numbers in the range 65 to 90
					// (int)(Math.random() * 26) - returns number between 0 and 25 
					// Adding 65 and will get numbers between 65 and 90
					char letter1 = (char)(65 + (int)(Math.random() * 26));
					char letter2 = (char)(65 + (int)(Math.random() * 26));
					char letter3 = (char)(65 + (int)(Math.random() * 26));
	
					// Use the random number generator to generate a 4 digit number
					// STUDENT NOTE: This code will generate a number between 1000 and 9999
					int fourDigits = 1000 + (int)(Math.random() * 9000  );

					// Build gift card
					giftCard = "SUBWAY: " + threeDigits + "-" + letter1 + letter2 + letter3 + "-" + fourDigits; 
				}
				else if (company == TACO_BELL) {
					// TACO_BELL gift cards have the letters "TB", 1 digit, a space, 2 digits, a space, 
					// and finally 3 digits => TB# ## ### 					
					// Use the random number generator to generate a 1 digit number between 1 and 9
					int oneDigit = 1 + (int)(Math.random() * 9);

					// Use the random number generator to generate a 2 digit number
					// STUDENT NOTE: This code will generate a number between 10 and 99
					int twoDigits = 10 + (int)(Math.random() * 90);
	
					// Use the random number generator to generate a 3 digit number
					// STUDENT NOTE: This code will generate a number between 100 and 990
					int threeDigits = 100 + (int)(Math.random() * 900);

					// Build gift card
					giftCard = "TACO_BELL: " + "TB" + oneDigit + " " + twoDigits + " " + threeDigits; 
				} 
				else if (company == WENDYS) {
					// WENDY'S gift cards have 4 letters, 2 digits, 2 letters => XXXX##XX
					// Use the random number generator to generate 4 letters between A and Z
					char letter1 = (char)(65 + (int)(Math.random() * 26));
					char letter2 = (char)(65 + (int)(Math.random() * 26));
					char letter3 = (char)(65 + (int)(Math.random() * 26));
					char letter4 = (char)(65 + (int)(Math.random() * 26));

					// Use the random number generator to generate a 2 digit number
					int twoDigits = 10 + (int)(Math.random() * 90);
					
					// Use the random number generator to generate 2 letters between A and Z
					char letter5 = (char)(65 + (int)(Math.random() * 26));
					char letter6 = (char)(65 + (int)(Math.random() * 26));
						
					// Build gift card
					giftCard = "WENDYS: " + letter1 + letter2 + letter3 + letter4 + twoDigits + 
								letter5 + letter6; 
				}
				
				// Display gift card with amount information added				
				switch (amount) {
					case TEN_DOLLAR: System.out.println(giftCard + " ($10.00 gift card)"); break;
					case FIFTEEN_DOLLAR: System.out.println(giftCard + " ($15.00 gift card)"); break;
					case THREE_PAK_15_DOLLAR: System.out.println(giftCard + " (3-pak with $15.00)"); break;
				}
				
			} // valid amount 
			else {
				System.out.println ("Invalid input for amount selected");
			}
		} // valid company
		else {
			System.out.println("Invalid input for company selected");
		}
		
		input.close();

	} // main	

} // Assignment 4
