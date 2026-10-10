package CS1450;

/*
 * Name: Christopher Horyczun
 * Class: CS1450 (M/W)
 * Due Date: October 1, 2025 (MW)
 * Assignment #4
 * Description: Create a program that models the ocean. Using grids and elements, where elements are either land or ship. The grid will be 2D array. Once all the land and ship are placed on the ocean, display the grid, and print a ship report. The report will be in order from smallest capacity to largest capacity.
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class HoryczunChristopherAssignment4 {

	public static void main(String[] args) throws FileNotFoundException {
		
		//Open  and read Ocean File
		Scanner ocean = new Scanner(new File("Ocean.txt"));
		String whatsMyName = ocean.nextLine();

		//sorting data into rows and columns
		int oceanRow = ocean.nextInt();
		int oceanColumn = ocean.nextInt();
		Ocean water = new Ocean (whatsMyName, oceanRow, oceanColumn);
		
		//close the ocean file
		ocean.close();
		
		//Open land file
		Scanner landHo = new Scanner(new File("Land.txt"));
		
		//Show me the land and remember where it is
		while (landHo.hasNextInt()) {
			int landRow = landHo.nextInt();
			int landColumn = landHo.nextInt();
			water.addElement(landRow, landColumn, new Land());
		}
		
		//close land file
		landHo.close();
		
		//open ship for reading
		Scanner ship = new Scanner(new File("Ships.txt"));
		
		//Shows me the ships are, information on the ships and remember that
		while (ship.hasNext()) {
			
			//gives me the row and columns of the ships
			int shipRow = ship.nextInt();
			int shipColumn = ship.nextInt();
			
			//Gives me the capacity, classification, and name of my ships
			int capacity = ship.nextInt();
			String classification = ship.next();
			String name = ship.nextLine().trim();
			water.addElement(shipRow, shipColumn, new Ship(classification, capacity, name));
		}//end of while loop
		
		//close ship file
		ship.close();
		
		//display the ocean
		System.out.println("\nLoading " + water.getName() + "Ocean grid with land and ships...\n");
		water.displayOcean();
		
		//open print ship reports
		printShipsReport(water);

	}//main

	private static void printShipsReport(Ocean water) {
		
		//Create the array
		ArrayList<Ship> boats = new ArrayList<>();
		
		
		//collect my ships for my ocean grid
		for (int i = 0; i < water.getNumRows(); i++) {
			for (int a = 0; a < water.getNumColumns(); a++) {
				OceanElement waterBender = water.getElement(i,a);
				if (waterBender instanceof Ship) {
					boats.add((Ship) waterBender);
				}
			}//end of for loop
		}//end of for loop
		
		//Sort by capacity
		Collections.sort(boats);
		
		//Print the head
		System.out.println("\n************************************************************************");
		System.out.println("\t\tOCEAN SHIP REPORT");
		System.out.println("\t(From Smallest Capacity to Largest Capacity)");
		System.out.println("\n************************************************************************");
		System.out.println("Classification\t\tName\t\t\tCapacity");
		System.out.println("------------------------------------------------------------------------");
		
		//Print my ships
		for (Ship whichShip : boats) {
			System.out.println(whichShip);
		}//end of for loop
			
	}//end of print Ship Report

}//Assignment 4

//Ocean Element class
class OceanElement {
	
	//private data fields
	private String type;
	
	//constructors
	public OceanElement(String type) {
		this.type = type;
	}//constructor
	
	//getter
	public String getType() {
		return type;
	}//get type
	
}//OceanElement

//Ship Class
class Ship extends OceanElement implements Comparable<Ship> {
	
	//private data fields
	private String name;
	private String classification;
	private int capacity;
	
	//Constructor
	public Ship (String classification, int capacity, String name) {
		super("Ship");
		this.classification = classification;
		this.capacity = capacity;
		this.name = name;
	}//Constructor
	
	//the getter for name
	public String getName() {
		return name;
	}//getName
	
	//override to string to print data
	@Override
	public String toString() {
		return String.format("%-23s %-20s %10d", classification, name, capacity);
	}

	@Override
	public int compareTo(Ship otherShip) {
		
		//comparing one ship to another
		if (this.capacity < otherShip.capacity) {
			return -1;
		} else if (this.capacity > otherShip.capacity) {
			return 1;
		}//end of if statement
		// TODO Auto-generated method stub
		return 0;
	}
	
}//class ship

//class land
class Land extends OceanElement {
	public Land() {
		super("Land");
	}
}//land class

//Ocean Class
class Ocean {
	
	//private data fields
	private String name;
	private int numRows;
	private int numColumns;
	private OceanElement[][] grid;
	
	//constructor
	public Ocean (String name, int numRows, int numColumns) {
		this.name = name;
		this.numRows = numRows;
		this.numColumns = numColumns;
		this.grid = new OceanElement [numRows] [numColumns];
	}//end of constructor
	
	//gets the name
	public String getName() {
		return name;
	}//end of get name
	
	//gets the rows
	public int getNumRows() {
		return numRows;
	}//end of get number of rows
	
	//gets the columns
	public int getNumColumns() {
		return numColumns;
	}//end of get number of columns
	
	//add elements method
	public void addElement (int rows, int columns, OceanElement element) {
		if (rows >= 0 && rows < numRows && columns >= 0 && columns <= numColumns) {
			this.grid[rows][columns] = element;
		} else {
			System.out.println("Error: Invalid Row or Column");
		}//end of if statement
		
	}//end of add Element
	
	public OceanElement getElement (int row, int column) {
		if (row >= 0 && row < grid.length && column >= 0 && column < grid.length) {
			return grid[row][column];
		} else {
			
			return null;
		}//end of if statement
		
	}//end of get element
		
		public void displayOcean() {
			//Print Header (for the Columns)
			System.out.print("\t");
			
			for (int giveColumn = 0; giveColumn < numColumns; giveColumn++) {
				//print column number
				System.out.print("Column " + giveColumn + "\t");
				
			}//end of for loop
			
			System.out.println();
			
			//Print the rows
			for (int i = 0; i < numRows; i++) {
				
				//print column number
				System.out.print("Row " + i + "\t\s\s\s");
				
				//build the table
				for (int c = 0; c < numColumns; c++) {
					OceanElement element = grid[i][c];
					
					//if nothing
					if (element == null) {
						System.out.printf("%-15s", "-------");
						
					//if land
					} else if (element instanceof Land) {
						System.out.printf("%-15s", "Land");
						
					//if Ship
					} else if (element instanceof Ship) {
						System.out.printf("%-15s", ((Ship) element).getName());
					}//end of if statement
					
				}//end of for loop
				
		        System.out.println();
		        
		    }//end of for loop
			
	}//end of display Ocean
	
}//Ocean Class