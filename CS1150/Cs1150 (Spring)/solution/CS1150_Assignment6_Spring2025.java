// Solution Assignment #6 CS1150 Spring 2025
// Topic: While and for loops
//
// Note: 
// This solution code may not be copied, doing so will result in a grade of zero.
// This solution is not for distribution online or by any other means. Copyright M. Gonzalez UCCS

import java.util.Scanner;

public class CS1150_Assignment6_Spring2025 {

	public static void main(String[] args) {
		
		// Constants for use in program
		// STUDENT NOTE: use constants in your code so you don't litter your code with "magic numbers"
		// Using constants also increases code readability.
		final int UNLEADED = 1;
		final int PREMIUM = 2;
		final int DIESEL = 3;
		final double UNLEADED_FUEL_PRICE = 3.40;
		final double MIDGRADE_FUEL_PRICE = 3.65;
		final double DIESEL_FUEL_PRICE = 3.43;
		final int SHUT_DOWN_CODE = 99;
		
		// Create a scanner object to perform console input
		Scanner input = new Scanner(System.in);
		
		// Initialize variables to hold total number of gallons for all customer and 
		// the total sales for all customers
		int totalNumGallons = 0;
		double totalSales = 0;
		
		// To simulate a gas pump waiting for the next customer we create a loop that waits to be shut down.
		// To create loop that runs until the owner shuts down the pump use a boolean variable that will 
		// be changed at some point inside the loop to stop the processing.
		boolean pumpInService = true;
		while (pumpInService) {
			
			// Display message that simulates what a customer sees when using the pump.
			// Prompt customer to insert credit card and zip code to get things started
			System.out.println ("");
			System.out.println ("**********************************");
			System.out.println ("   Welcome to Gas Station 1150");
			System.out.println ("**********************************");
			System.out.println ();
			System.out.println ("   Unleaded  Midgrade  Diesel");
			System.out.printf ("   $%.2f     $%.2f     $%.2f\n", UNLEADED_FUEL_PRICE, MIDGRADE_FUEL_PRICE, DIESEL_FUEL_PRICE);		
			System.out.println ("----------------------------------");
			System.out.println ();
			System.out.print ("Insert credit card and enter zip code: ");
			
			// Read zip code and if the entered value is not the pump shutdown value then enter customer mode
			int zip = input.nextInt();			
			if (zip != SHUT_DOWN_CODE) {
				
				// Display a message that fakes the processing of the credit card and tells customer to 
				// pick a fuel grade
				System.out.println ("Please Wait ... Authorizing ... ... ...");
				System.out.println();
				System.out.print ("Lift nozzle and select fuel grade - Unleaded (1) or Midgrade (2) or Diesel (3): ");
				
				// Read fuel grade customer selected
				int fuelType = input.nextInt();

				// While fuel grade is invalid, prompt user to reenter
				// After this while loop, we know the fuel grade is valid
				while (fuelType != UNLEADED && fuelType != PREMIUM && fuelType != DIESEL) {
					System.out.print ("Invalid fuel type - reselect grade - Unleaded (1) or Midgrade (2) or Diesel (3): ");
					fuelType = input.nextInt();
				}
				
				// Based on fuel grade selection, set the current cost per gallon
				double costPerGallon = 0;
				if (fuelType == UNLEADED) {
					costPerGallon = UNLEADED_FUEL_PRICE;
				}
				else if (fuelType == PREMIUM) {
					costPerGallon = MIDGRADE_FUEL_PRICE;
				}
				else {
					costPerGallon = DIESEL_FUEL_PRICE;
				}
				
				// Generate a random number between 1 and 30 
				// This simulates different customers purchasing different amounts of fuel
				int numGallonsThisPurchase = 1 + (int)(Math.random() * 30);
				
				// Simulate the pumping of gas
				System.out.println();
				System.out.println ("************** Fueling **************");
				for (int gallons = 1; gallons <= numGallonsThisPurchase; gallons++) {
					System.out.printf("** $%.2f\t\t%d Gallons **\n", costPerGallon * gallons, gallons);
				}
				
				// Display the receipt for this purchase
				System.out.println ("************************************");
				System.out.println();
				System.out.println();
				System.out.println ("-------------------------------------");
				System.out.println ("-------------- Receipt --------------");
				System.out.println ("-------------------------------------");
				System.out.printf("\tGallons:      %d\n", numGallonsThisPurchase);
				System.out.printf("\tPrice/gallon: %.2f\n", costPerGallon);
				System.out.printf("\tFuel Cost:    %.2f\n", costPerGallon* numGallonsThisPurchase);
				System.out.println();
				System.out.println("     Thank you for your business!");
				System.out.println ("-------------------------------------");
				System.out.println();
				System.out.println();

				// Add this purchase to the grand totals
				totalNumGallons = totalNumGallons + numGallonsThisPurchase;
				totalSales = totalSales + (costPerGallon * numGallonsThisPurchase);
				
			} // customer mode - zip code is not pump shut down value
			
			else {
				// Enter mode to shutdown the pump
				// The station is closed and we need to stop the loop!
				pumpInService = false;
				System.out.println();
				System.out.println("Shutting down...");
			}

		} // while pump is in service
		
		// Display how many gallons were sold and the total cost for all customers
		System.out.println("Pump 17 was successfully shut down");
		System.out.printf("Total Gallons = %d\n", totalNumGallons);
		System.out.printf("Total Sales = $%.2f\n", totalSales);
		
		input.close();

	} // main

} // Assignment 6
