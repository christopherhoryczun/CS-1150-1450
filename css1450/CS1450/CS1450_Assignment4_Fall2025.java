// CS 1450 Assignment #4 Solution Fall 2025
// Topic: Nested Objects, 2-dimensional Arrays, ArrayLists, Comparable, and Collections
//
// Note: 
// This solution code may not be copied, doing so will result in a grade of zero.
// This solution is not for distribution online or by any other means. Copyright M. Gonzalez UCCS

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class CS1450_Assignment4_Fall2025 {

	public static void main(String[] args) throws IOException {
		
		// Name of files to read from
		final String OCEAN_FILE_NAME = "Ocean.txt";	
		final String LAND_FILE_NAME = "Land.txt";	
		final String SHIP_FILE_NAME = "Ships.txt";	

		// Setup file reference variables to refer to each text file
		File oceanFileName = new File(OCEAN_FILE_NAME);
		File landFileName = new File(LAND_FILE_NAME);
		File shipsFileName = new File(SHIP_FILE_NAME);

		// Open the ocean file for reading by creating a scanner for the file.
		// The 1st line contains the name of the ocean
		// The 2nd line and 3rd line tell how many rows and columns are in ocean grid. 
		// Use the rows and columns to create a 2-D array that models the ocean's grid.
		Scanner oceanFile = new Scanner (oceanFileName);
		String oceanName = oceanFile.nextLine();
		int numberRows = oceanFile.nextInt();
		int numberColumns = oceanFile.nextInt();

		// Create the ocean object based on the values read from the file.
		OceanF25 atlanticOcean = new OceanF25(oceanName, numberRows, numberColumns);

		// Load the ocean with ships and land
		System.out.println("Loading " + oceanName + " Ocean grid with ships and land...");
		System.out.println();

		// Open the ships file for reading by creating a scanner for the file
		// Create the ship objects from the details provided in the file.
		// STUDENT NOTE: In this assignment the number of ships is not part of the file so you
		// need to use a while loop and the hasNext method on the Scanner to read ships until the
		// end of the file is reached.
		Scanner shipsFile = new Scanner (shipsFileName);
		while (shipsFile.hasNext()) {
			
			// Read ship information from the file into separate variables
			int rowNumber = shipsFile.nextInt();
			int columnNumber = shipsFile.nextInt();
			int capacity = shipsFile.nextInt();
			String classification = shipsFile.next();	// cruise, cargo, tanker, navy
			String name = shipsFile.nextLine().trim();
			
			// Create a ship object
			// Place ship object into its correct location in the ocean
			ShipF25 ship = new ShipF25(classification, capacity, name); 
			atlanticOcean.addElement(rowNumber, columnNumber, ship);
		
		} // while more ships

		// Open the land file for reading by creating a scanner for the file
		// Create the land objects from the details provided in the file.
		Scanner landFile = new Scanner (landFileName);
		while (landFile.hasNext()) {
			
			// Read land location from the file into separate variables
			int rowNumber = landFile.nextInt();
			int columnNumber = landFile.nextInt();
			
			// Create a land object
			// Place land object into its correct location in the ocean
			LandF25 land = new LandF25(); 
			atlanticOcean.addElement(rowNumber, columnNumber, land);
		
		} // while more land 

		// Close all the files
		oceanFile.close();
		landFile.close();
		shipsFile.close();

		// Display the ocean's grid
		atlanticOcean.displayOcean();

		// Print the list of ships in the ocean's grid from the highest to lowest capacity  
		printShipsReport(atlanticOcean);
		
	} // main

	
	// Display all ships in the ocean.  
	// Display ships based on the their capacity, from lowest to highest capacity.
	public static void printShipsReport(OceanF25 ocean) {
		
		// Create an array list to store each ship found in the ocean's grid
		ArrayList<ShipF25> ships = new ArrayList<>();
		
		// For each row in the grid
		for (int row = 0; row < ocean.getNumberRows(); row++) {
			
			// For each column in the current row
			for (int column = 0; column < ocean.getNumberColumns(); column++) {
				
				// Get the element at location [row, column]
				OceanElementF25 element = ocean.getElement(row, column);
				
				// If there is an element in this location and its a ship, place it into array list
				// STUDENT NOTE: the check for null is not needed but included for clarity.
				if (element != null && element instanceof ShipF25) {

					// Casting is necessary because the object in the 2D array is of type OceanElement
					// but the ArrayList only take Ship objects.  To handle this, code first determined if 
					// the element is a Ship, and if it is, it is safe to cast the element to a Ship and 
					// place in ArrayList.
					ships.add((ShipF25)element);
				}
			} // for each column
		} // for each row
		
		// Sort the ships stored in the array list based on capacity
		// -- We can use the sort method since the Ship class implements Comparable  
		// -- The compareTo method in the Ship class is based on the ship's capacity. 
		Collections.sort(ships);
	
		// Display the capacity for each ship from smallest capacity to largest capacity.  
		System.out.println("\n\n************************************************************************");
		System.out.println("\t\t           OCEAN SHIP REPORT");
		System.out.println("\t\t(From Smallest Capacity to Largest Capacity)");
		System.out.println("************************************************************************");
		System.out.printf ("Classification\t\tName\t\t\tCapacity\n");
		System.out.println("------------------------------------------------------------------------");

		for (int i = 0; i < ships.size(); i++) {
			// STUDENT NOTE: THis is an explicit call the toString method but the call is not needed.
			// Java calls toString automatically and since we overwrite it, the code we created is used.
			System.out.println(ships.get(i).toString());
		}
		
	} // printShipsReport
	
} // Assignment 4


// Represents the Ocean.  
// The ocean contains a grid that is modeled using a 2D array.
// Each location in the grid contains an OceanElement object which is a ship or land. 
class OceanF25 {
	
	private String name;				// Name of ocean
	private int numberRows;				// Number of rows in the grid 
	private int numberColumns;			// Number of columns in the grid
	private OceanElementF25[][] grid;	// 2-D array of ocean entities (ship or land)
										// This is a HAS-A relationship - Ocean HAS-A grid

	public OceanF25 (String name, int numberRows, int numberColumns) {
		this.name = name;
		this.numberRows = numberRows;			
		this.numberColumns = numberColumns;	

		// Allocate memory for the grid
		// STUDENT NOTE: The 1st index is the number of rows, the 2nd index is number of columns
		grid = new OceanElementF25[numberRows][numberColumns];
	}


	// Returns the name of the ocean
	public String getName() {
		return name;
	}

	
	// Returns the number of rows in the grid
	public int getNumberRows() {
		return numberRows;
	}
		
	
	// Returns the number of columns in the grid
	public int getNumberColumns() {
		return numberColumns;
	}

	
	// Add an ocean element to the grid in a specific row and column location
	public void addElement(int row, int column, OceanElementF25 oceanElement) {
		grid[row][column] = oceanElement; 
	}

	
	// Returns the ocean element in the specified row and column in the array.  
	// When a location does NOT contain an ocean element, returns null.
	public OceanElementF25 getElement(int row, int column) {
		
		// Return the ocean element which can be null if the location is empty
		// STUDENT NOTE: When you created the array, Java initialized the array with null values
		return grid[row][column];
	}

	
	// Displays all elements in the ocean's grid
	public void displayOcean() {
		
		// Display header for the number of columns in the 2D array
		for (int column = 0; column < numberColumns; column++) {
			System.out.printf("\t%s %d", "Column", column);
		}
		System.out.printf("\n\n");
		
		// For each row print the elements in that row
		for (int row = 0; row < numberRows; row++) {
			
			System.out.printf("%s%d", "Row ", row);
	
			// For each column display the element type otherwise display "----" to represent null
			for (int column = 0; column < numberColumns; column ++) {
	
				// Get element in location [row,column]
				OceanElementF25 element = grid[row][column];
				
				// If there is an element in location [row,column] display its name if its a ship and 
				// type if it is land
				if (element != null) {
					if (element instanceof ShipF25) {
						System.out.printf ("\t%-8s", ((ShipF25)element).getName());
					}
					else {
						System.out.printf ("\t%-8s", element.getType());
					}
				}
				else {
					System.out.printf ("\t%-8s", "-------");				
				}
			} // for each column
			
			System.out.println();
			System.out.println();
			
		} // for each row
		
	} // displayOcean
	
} // Ocean


// Superclass for different types of objects in the ocean
// The main purpose of this class is to create the polymorphic array to represent the ocean
class OceanElementF25 {
	private String type;	// Type of ocean element (ship or land)

	public OceanElementF25 (String type) {
		this.type = type;
	}
	
	public String getType() {
		return type;
	}

} // OceanElement


// Represents a ship, ships must be comparable
class ShipF25 extends OceanElementF25 implements Comparable<ShipF25>{

	private String name;			// Ship's name
	private String classification; 	// Ship's classification - cruise, cargo, tanker, navy
	private int capacity; 			// Ship's capacity
	
	// Create a ship
	public ShipF25 (String classification, int capacity, String name) {
		// The type is in the super class, call the super class constructor to set type.
		// Because we are in the ship class, we know the type is "Ship" so no need to pass in.
		super("Ship");
		
		// The instance variables specific to a ship
		this.classification = classification;
		this.capacity = capacity;
		this.name = name;
	}

	// Returns name of ship
	public String getName() {
		return name;
	}

	// This method override the toString method in the Object class.
	// It creates a printable string to describe the ship
	@Override
	public String toString() {
		return String.format("%-10s\t\t%-10s\t\t%d", 
				classification, 
				name,  
				capacity);

	}
	
	@Override // This is where we write the code to compare two Ships.
	// In this assignment, compare two ships based on their capacity.
	// By writing this method, it is now possible to sort an array of ships 
	// by their capacity when calling the Collections.sort method
	public int compareTo(ShipF25 otherShip) {
		
		// STUDENT NOTE: capacity is a private data field for the Ship and because we are inside the Ship 
		// class it is perfectly fine to access capacity directly. Thus, there is no need to call the getter.
		if (this.capacity < otherShip.capacity) {
			return -1;
		}
		else if (this.capacity > otherShip.capacity) {
			return 1;
		}
		else {
			return 0;
		}
	}
	
} // Ship


// Represents land
class LandF25 extends OceanElementF25 {

	// Create land
	public LandF25 () {
		// Because we are in the land class, we know the elementType is "Land" so no need to pass in
		super("Land");  
	}
			
} // Land

