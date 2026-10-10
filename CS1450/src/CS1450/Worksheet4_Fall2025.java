package CS1450;

// CS 1450 Assignment #6 Fall 2025
// Worksheet4: Priority Queue
//
// Note: 
// This solution code may not be copied, doing so will result in a grade of zero.
// This solution is not for distribution online or by any other means. Copyright M. Gonzalez UCCS

import java.util.LinkedList;
import java.util.Queue;

public class Worksheet4_Fall2025 {

	public static void main(String[] args) {
		
		// Setup some hard coded ships to use in the queue questions.
		// Create two hard coded ships - hard coding is the way to go when learning.
		// Of course we would not do this in an assignment!  I'm doing it for testing purposes.
		ShipW4 ship1 = new ShipW4("Sea Haul");  
		ShipW4 ship2 = new ShipW4("Queen Mary");    

		// Add some containers to each ship
		// Note this time I'm adding the containers with a call to addContainer method on the ship.
		// Create 2 hard coded container objects and add them to ship1's queue
		ship1.addContainer(new ContainerW4("AP8080"));
		ship1.addContainer(new ContainerW4("AP1234"));
		
		// Create 3 hard coded container objects and add them to ship2's queue
		ship2.addContainer(new ContainerW4("QM011"));
		ship2.addContainer(new ContainerW4("QM024"));
		ship2.addContainer(new ContainerW4("QM245"));

		// ***********************************
		// Worksheet4 Question 3a
		// Write the declaration for a priority queue of ships (ShipW4 objects)
		// ***********************************
		// ADD CODE HERE

		
	
		
		//********************************
		// Worksheet4 Question #3b
		// See Ship Class below
		//********************************


		// ***********************************
		// Worksheet4 Question #3c 
		// Write code to add ship1 and ship2 to the priority queue
		// ***********************************
		// ADD CODE HERE 

		
		
		
		System.out.println("Ship #1 is in priority queue");	
		System.out.println("Ship #2 is in priority queue");

	} // main

} // Worksheet4



class ContainerW4  {
	
	private String id;			
	
	public ContainerW4 (String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}
	
} // ContainerW4




class ShipW4  {

	private String name;  // Name of the ship
	
	// Queue of containers that will be loaded on ship
	private Queue<ContainerW4> containers = new LinkedList<>();  
	 														      
		
	// Create a ship
	public ShipW4(String name) {
		this.name = name;
	}
			
	public String getName() {
		return name;
	}
		
	// ***********************************
	// Worksheet4 Question #3b
	// Copy your answer from Worksheet3 here
	// ***********************************
	// Returns number of containers
	public int getContainersSize() {		
		// ADD CODE HERE
		
		
	}

	
	// ***********************************
	// Worksheet4 Question #3b
	// Copy your answer from Worksheet3 here
	// ***********************************	
	public void addContainer (ContainerW4 container) {
		// ADD CODE HERE
		
		
	}
	
	// ***********************************
	// Worksheet4 Question #3b
	// Copy your answer from Worksheet3 here
	// ***********************************	
	public ContainerW4 removeContainer() {
		// ADD CODE HERE
		
		
	}

	// ***********************************
	// Worksheet4 Question #3g 
	// Add the code from question 3g here
	// ***********************************
	// ADD CODE HERE
	
	
	
	
	
	
	
} // ShipW4
