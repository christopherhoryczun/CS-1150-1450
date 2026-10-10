// Solution Assignment #3 CS1150 Spring 2025
// Topic: Nested If Statements
//
// Note: 
// This solution code may not be copied, doing so will result in a grade of zero.
// This solution is not for distribution online or by any other means. Copyright M. Gonzalez UCCS

import java.util.Scanner;

public class CS1150_Assignment3_Spring2025 {

	public static void main(String[] args) {
		
		// Declare constants for the fixed fare rates 
		// STUDENT NOTE: If the prices ever change then the developer only needs to change 
		// the price in one place when using constants. Using constants creates code that is
		// easier to maintain and increases readability.
		final double SYDNEY_FARE = 1450.00;
		final double LONDON_FARE = 1100.00;
		final double FRANKFURT_FARE = 1250.00;
		final double CANCUN_FARE = 500.00;
		final double CHECKED_BAG_FEE = 25.00;
		final double CARRYON_BAG_FEE = 35.00;

		// Declare constants that represent each city as a number in the menu	
		// STUDENT NOTE: You will see below where these constants are used in the if statements 
		// and increase the readability of the code. 
		final int SYDNEY = 1;
		final int LONDON = 2;
		final int FRANKFURT = 3;
		final int CANCUN = 4;

		// Declare constants for the min and max allowed bags	
		final int MIN_CHECKED_BAGS_ALLOWED = 0;
		final int MAX_CHECKED_BAGS_ALLOWED = 3;
		final int MIN_CARRYON_BAGS_ALLOWED = 0;
		final int MAX_CARRYON_BAGS_ALLOWED = 1;
		
		// Display the menu for the different destination cities
		// STUDENT NOTE: Notice how the constants for each fare cost are used in the print
		// statements to display the menu.  This removes numeric values (magic numbers) from 
		// the code and makes the code easier to read and change.
		System.out.println ("Welcome to CS1150 Airlines");
		System.out.println ();	
		System.out.println ("Option   City                      	Fare");
		System.out.println ("-------------------------------------------------");
		System.out.printf ("1        Sydney, Australia		$%7.2f \n", SYDNEY_FARE);
		System.out.printf ("2        London, England		$%7.2f \n", LONDON_FARE);
		System.out.printf ("3        Frankfurt, Germany		$%7.2f \n", FRANKFURT_FARE);
		System.out.printf ("4        Cancun, Mexico			$%7.2f \n", CANCUN_FARE);
		System.out.println ();
		
		// Create a scanner object to perform console input
		// STUDENT NOTE: Remember only ONE scanner is needed in your program!
		// You can use the one scanner over and over.  
		Scanner input = new Scanner(System.in);
	
		// Prompt user for the destination city
		// Read destination city selection from console 
		System.out.print ("Select a destination city: 1, 2, 3, or 4: ");
		int city = input.nextInt();

		// Ensure selected destination city is a valid selection
		// STUDENT NOTE: Notice that constants are used in the if statements. SYDNEY = 1 and CANCUN = 4 
		// The if statement tests if the value entered by the user is between 1 and 4.  
		if ((city >= SYDNEY) && (city <= CANCUN)) {
			
			// Destination city is valid
			// Prompt user for number of checked bags
			// Ensure user's entry is within the number of allowed checked bags 
			System.out.print ("How many bags do you want to check (0-3 bags, $25 per bag)? ");
			int checkedBags = input.nextInt();
			if ((checkedBags >= MIN_CHECKED_BAGS_ALLOWED) && (checkedBags <= MAX_CHECKED_BAGS_ALLOWED)) {
				
				// Prompt user for number of carry on bags
				// Ensure user's entry is 0 or 1
				System.out.print ("How many bags do you want to carry on (0-1 bags, $35 per bag)? ");
				int carryOnBag = input.nextInt();
				if ((carryOnBag >= MIN_CARRYON_BAGS_ALLOWED) && (carryOnBag <= MAX_CARRYON_BAGS_ALLOWED)) {		
					
					// Valid destination city, checked, and carry on bags, now determine total cost of trip
					// Declare and initialize variables related to costs 
					double flightCost = 0;
					String cityName = ""; 

					// Set flight cost and destination city name
					if (city == SYDNEY) {
						flightCost = SYDNEY_FARE;
						cityName = "Sydney, Australia";
					}
					else if (city == LONDON) {
						flightCost = LONDON_FARE;
						cityName = "London, England";
					}
					else if (city == FRANKFURT) {
						flightCost = FRANKFURT_FARE;
						cityName = "Frankfurt, Germany";
					}
					else if (city == CANCUN) {
						flightCost = CANCUN_FARE;
						cityName = "Cancun, Mexico";
					}
					
					// Calculate baggage cost
					double baggageCost = (checkedBags * CHECKED_BAG_FEE) + (carryOnBag * CARRYON_BAG_FEE);

					// Print break down of cost - flight, bags, total
					// STUDENT NOTE: Did you repeat the following code inside each of the above
					// if-statements?  When you find yourself repeating code, pull that code
					// out and use in one place. Redundant code is harder to maintain and debug.
					System.out.println();
					System.out.println ("-------------------------------------------------");
					System.out.printf ("Flight to\t %s\n", cityName);					
					System.out.printf ("Flight Cost\t $%.2f\n", flightCost);
					System.out.printf ("Baggage Cost\t $%.2f\n", baggageCost);
					System.out.println ("-------------------------------------------------");
					
					// Calculate and display the total cost
					double totalCost = flightCost + baggageCost;
					System.out.printf("%s\t $%5.2f \n", "Total Cost", totalCost);					
					
				}
				else {
					// Handle error for invalid number of carry on bags
					// STUDENT NOTE: If the user enters an invalid number of carry on bags the code 
					// displays an error message on the console.  The next line of code that is 
					// executed is input.close() which closes the scanner and then the program ends.
					System.out.println();
					System.out.println(carryOnBag + " carry on bags is not allowed (the limit is 1 carry on bag).");
					System.out.println("Please run program again, good bye!");
				} 				
				
			}  // valid number of checked and carry on bags
			else {
				// Handle error for invalid number of checked bags
				// STUDENT NOTE: If the user entered an invalid number of checked bags the code displays an
				// error message on the console.  The next line of code that is executed is 
				// input.close() which closes the scanner and then the program ends.
				System.out.println();
				System.out.println(checkedBags + " checked bags is not allowed (the limit is 3 checked bags).");
				System.out.println("Please run program again, good bye!");
			} 
			
		}  // valid flight selection
		else {
			// Handle error for invalid selection from destination city menu
			// STUDENT NOTE: If the user entered an invalid menu selection the code displays an
			// error message on the console.  The next line of code that is executed is 
			// input.close() which closes the scanner and then the program ends.
			System.out.println(city + " is not a valid menu item.  Please run program again, good bye!");
		} 
		   
		// Close the input stream
		input.close();

	} // main

} // Assignment 3
