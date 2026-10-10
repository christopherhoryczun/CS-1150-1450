// CS1450 Assignment #6 Fall 2025
// Worksheet #3: Complicated Nested Objects
//
// Note: 
// This solution code may not be copied, doing so will result in a grade of zero.
// This solution is not for distribution online or by any other means. Copyright M. Gonzalez UCCS

import java.util.LinkedList;
import java.util.Queue;

public class Worksheet3_Fall2025 {

	public static void main(String[] args) {
		
		//**********************************
		// Worksheet3 Ocean Setup 
		//**********************************
		// Create an ocean and fill it with a bunch of ships by HARD CODING.
		// Hard code only to quickly test the code.
		
		// Create an ocean object that contains a grid.
		// Remember the grid is a 2D array and each slot represents a location where a ship may be.
		// This ocean's grid will have 3 rows (0-2) and 3 columns (0-2)
		int numberRows = 3;
		int numberColumns = 3;
		OceanW3 ocean = new OceanW3(numberRows, numberColumns);

		System.out.println();
		System.out.println("Hard coding 3 ships to test code");
		System.out.println("---------------------------------");
		System.out.println("Queen Mary contains 3 containers");
		System.out.println("Sea Haul contains 2 containers");
		System.out.println("Titan contains 2 containers");
		System.out.println();

		// Hard code 3 ships - hard coding is the way to go when doing this type of testing.
		// Of course we would not do this in an assignment!  Only doing this for testing purposes.
		ShipW3 queenMary = new ShipW3("Queen Mary");  
		ShipW3 seaHaul = new ShipW3("Sea Haul");    
		ShipW3 titan = new ShipW3("Titan");    
	
		// Add ships to the ocean - hard coding the row and column numbers for quick setup.
		// Of course we would not do this in a regular assignment - this is just for testing purposes
		ocean.addShip(0, 1, queenMary);
		ocean.addShip(1, 2, seaHaul);
		ocean.addShip(2, 0, titan);
		
		// Add some containers to each ship	
		// Create some containers and add them to Queen Mary that is in row 0, column 1
		ocean.addContainerToShip(0, 1, new ContainerW3("QM011"));
		ocean.addContainerToShip(0, 1, new ContainerW3("QM024"));
		ocean.addContainerToShip(0, 1, new ContainerW3("QM245"));

		// Create some containers and add them to Sea Haul that is in row 1, column 2
		ocean.addContainerToShip(1, 2, new ContainerW3("AP8080"));
		ocean.addContainerToShip(1, 2, new ContainerW3("AP1234"));

		// Create some containers and add them to Titan that is in row 2, column 0
		ocean.addContainerToShip(2, 0, new ContainerW3("AP1919"));
		ocean.addContainerToShip(2, 0, new ContainerW3("AP0404"));

		// Now the ocean is setup with ships and each ship has a queue of "containers"
		// Display some information to test the code 
		for (int row = 0; row < numberRows; row++) {
			
			for (int column = 0; column < numberColumns; column ++) {
				
				// Get a ship out of the array (row, column = array slot)
				ShipW3 ship = ocean.getShip(row, column);

				// If there was a ship in the array slot display the containers in the ship's queue
				if (ship != null) {
					
					System.out.print("Ship " + ship.getName() + " is in grid location [" + row + "," + column + "]");
					
					// Display number of containers in this ship's queue of containers
					int numContainers = ship.getContainersSize();
					System.out.println(" contains " + numContainers + " containers");

					// For each container in the queue, display it's id.  
					// Since the queue is inside the Ship object we first have to use the Ship's 
					// removeContainer method to obtain a Container object.  
					// After we have the container, we can then call the Container's getId method.
					for (int i = 0; i < numContainers; i++) {
						System.out.println("Container Id: " + ship.removeContainer().getId());
					}
					System.out.println();

				} // array slot not empty
			} // for each column
		} // for each row

	} //main

} // Worksheet3


class ContainerW3  {
	
	private String id;			
	
	public ContainerW3 (String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}
	
} // Container


//*******************************************
// Worksheet3 Question #1
// Write the code for each incomplete method
//*******************************************
class ShipW3 { 
	
	private String name;  // Name of the ship
	
	private Queue<ContainerW3> containers = new LinkedList<>();  // Queue of containers that  
	 														     // will be loaded on the ship
		
	// Create a ship
	public ShipW3 (String name) {
		this.name = name;
	}
			
	public String getName() {
		return name;
	}
	
	// Returns number of containers
	public int getContainersSize() {
		// ADD CODE HERE
		
		
	}
	
	public void addContainer(ContainerW3 container) {
		// ADD CODE HERE
		
		
	}
	
	public ContainerW3 removeContainer() {
		// ADD CODE HERE
		
		
	}
		
} // ShipW3


// Represents the Ocean - a little different from assignment 4, here the grid only holds ship objects.  
// The ocean contains a grid that is modeled using a 2D array.
// Each location in the grid contains a ship object or null. 
class OceanW3 {
	
	private ShipW3[][] grid;		// 2-D array of ocean 

	public OceanW3 (int numberRows, int numberColumns) {
		grid = new ShipW3[numberRows][numberColumns];		// Allocate memory for grid
	}

	
	// Add a ship to the grid in a specific row and column location
	public void addShip (int row, int column, ShipW3 ship) {
		grid[row][column] = ship; 
	}

	
	// Returns the ship in the specified row and column in the array.  
	// When a location does NOT contain a ship, returns null.
	public ShipW3 getShip(int row, int column) {
		return grid[row][column];
	}

	
	//********************************
	// Worksheet3 Question #3
	// For the ship at location [row, column] in the grid, add a container to ship's queue 
	//********************************
	public void addContainerToShip(int row, int column, ContainerW3 container) {
		// ADD CODE HERE
		
		
		
	}

} // OceanW3
