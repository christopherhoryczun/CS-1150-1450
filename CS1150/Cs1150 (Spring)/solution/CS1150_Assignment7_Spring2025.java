// Solution Assignment #7 CS1150 Spring 2025
// Topic: Methods
//
// Note: 
// This solution code may not be copied, doing so will result in a grade of zero.
// This solution is not for distribution online or by any other means. Copyright M. Gonzalez UCCS

import java.util.Scanner;

public class CS1150_Assignment7_Spring2025 {

	public static void main(String[] args) {
		
		// Constants for the different types of shapes program can compute area for
		final int CIRCLE = 1;
		final int PENTAGON = 2;
		final int HEXAGON = 3;
				
		// Create a scanner object to read input from user
		Scanner userInput = new Scanner(System.in);		
		System.out.println("*******************************");
		System.out.println("Welcome to the Geometry Program");
		System.out.println("*******************************");
		
		// Continue computing areas as long as the user desires.
		// STUDENT NOTE: A boolean variable is created outside the loop and set it to true or false
		// based on if user wants to compute areas.  The loop is entered if the user wants to compute 
		// areas.  When the user decides to stop, inside the loop the boolean is set to false which will 
		// cause the loop to end.
		boolean computing = continueComputing(userInput);
		while (computing) {
			
			// Prompt user for which shape to compute area for 
			int shape = getShape(userInput);
					
			// Compute the area of the shape selected by the user
			double area = 0;
			switch (shape) {
				case CIRCLE:
					System.out.print("Enter the radius of the circle: ");
				    double radius = userInput.nextDouble();
				    
				    // Compute area for a circle
					area = circleArea(radius);
					System.out.printf ("Circle Area =  %5.2f", area);
					break;
					
				case PENTAGON:
					System.out.print("Enter the length from the center to a vertex: ");
				    double centerToVertexLength = userInput.nextDouble();
				    
				    // Compute area for a pentagon
					area = pentagonArea(centerToVertexLength);
					System.out.printf ("Pentagon Area =  %5.2f", area);
					break;
					
				case HEXAGON:
					System.out.print("Enter the length of a side: ");
				    double side = userInput.nextDouble();
				    
				    // Compute area for a hexagon	
					area = hexagonArea(side);
					System.out.printf ("Hexagon Area = %5.2f", area);
					break;
				
			} // switch
						
			// Check if user wants to compute another area
			System.out.println();				
			computing = continueComputing(userInput);
			
		} // while computing
		
		System.out.println ("That was fun!  Goodbye!");
		
	} // main
			
			
	//************************************************************
	// Displays a menu and prompts user for which shape to compute area for. 
	// Validates user input allowing user to re-enter until menu option is correct.
	// Input: Scanner object
	// Return: Menu number of the shape to compute area for
	//************************************************************
	public static int getShape(Scanner userInput) {
			
		// Display menu options to user
		System.out.println();
		System.out.println ("Option   Shape");
		System.out.println ("-------------------");
		System.out.println (" 1       Circle");
		System.out.println (" 2       Pentagon");
		System.out.println (" 3       Hexagon");
		System.out.println();
		
		// Prompt user for which shape to compute area for
		System.out.print ("Select shape to compute area for. Select 1, 2, or 3: ");
		int shape = userInput.nextInt();
		
		// Determine if value entered by user is valid
		while ((shape < 1) || (shape > 3)) {
			System.out.println (shape + " is not a valid entry - try again\n");	
			System.out.println();
			System.out.println ("Option   Shape");
			System.out.println ("-------------------");
			System.out.println (" 1       Circle");
			System.out.println (" 2       Pentagon");
			System.out.println (" 3       Hexagon");
			System.out.println();
			
			System.out.print ("Select shape to compute area for. Select option 1, 2, or 3: ");
			shape = userInput.nextInt();
		}
		
		// Return shape user selected
		return shape;
		
	} // getShape

	
	//*******************************************************************************
	// Computes and returns the area of a circle of a given radius 
	// Input:  circle radius
	// Return: area of a circle
	//*******************************************************************************
	public static double circleArea(double radius) {
			    
	    return radius * radius * Math.PI;
		
	} // circleArea

	
	//*******************************************************************************
	// Computes and returns the area of a pentagon given the length from the center to a vertex  
	// Input:  length from center to vertex (the value r in the formula)  
	// Return: area of a pentagon
	//*******************************************************************************
	public static double pentagonArea(double length) {
			    
	    double side = 2 * length * Math.sin(Math.PI / 5);
	    double area = 5 * side * side / (4 * Math.tan(Math.PI / 5));
		
		return area;
		
	} // pentagonArea
	
	
	//**********************************************************************************
	// Computes and returns the area of a hexagon given the length of one side
	// Inputs: length of a side (the value s in the formula)
	// Return: area of a hexagon
	//**********************************************************************************
	public static double hexagonArea(double side) {
		
	    return 6 * side * side / (4 * Math.tan(Math.PI / 6));
		
	} // pentagonArea
			
	
	//************************************************************
	// Prompt user about continuing
	// Input: scanner object
	// Return: true if wish to continue, false if wish to stop
	//************************************************************
	public static boolean continueComputing(Scanner userInput) {
		
		// Initialize the return value
		boolean continuing = false;
		
		// Prompt user asking if they want to perform another area computation
		System.out.println();
		System.out.print("Compute Area (Y/N)? ");
		char check = userInput.next().charAt(0);
		
		// Determine if value entered by user is valid
		while ((check != 'N') && (check !=  'n') && (check != 'Y') && (check != 'y')) {
			
			// User entered an invalid value so ask them to retry
			System.out.println (check + " is not a valid entry - try again\n");	
			System.out.print("Compute Area?  Enter Y or N: ");
			check = userInput.next().charAt(0);
		}
		
		// Return true if user wants to continue  
		if (check == 'Y' || check == 'y') {
			continuing = true;
		}

		return continuing;
		
	} // continueComputing

} // Assignment 7
