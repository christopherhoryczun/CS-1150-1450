package CS1450;

/* CS1450 Assignment #6 Fall 2025
// Worksheet #1: Stacks
//
// Note: 
// This solution code may not be copied, doing so will result in a grade of zero.
// This solution is not for distribution online or by any other means. Copyright M. Gonzalez UCCS
*/

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Worksheet1_Fall2025 {

	public static void main(String[] args) throws IOException {
		
		// Name of file to read from
		final String CONTAINERS_FILE_NAME = "Worksheet1Containers.txt";	

		// Setup a file reference variable to refer to text file
		File containersFileName = new File(CONTAINERS_FILE_NAME);

		// First value in file is the number of containers in the file
		Scanner containersFile = new Scanner (containersFileName);
		int numContainersInFile = containersFile.nextInt();

		//****************************************
		// Worksheet1 Question #2: 
		// Write code to create a stack of containers
		//*****************************************
		// ADD YOUR CODE HERE

		
		
		
		// Create container objects from the details provided in the file
		for(int i = 0; i < numContainersInFile; i++) {
			
			// Read information from file and create a container
			String id = containersFile.next();
			String destination = containersFile.nextLine().trim();

			ContainerW1 container = new ContainerW1(id, destination);		

			// Print the container's details
			System.out.println("Container details: " + container.getId() + " " + container.getDestination());
			
			//****************************************
			// Worksheet1 Question #3: 
			// Write code to add the container to the stack
			//****************************************
			// ADD YOUR CODE HERE


			
			
		} // for each container
		
		
		//****************************************
		// Worksheet1 Question #4
		// Write code to print the destination of each container on the stack.  
		// Look in the file to see the destination of the container.
		// Use a while loop to perform this task.
		//****************************************
		// ADD YOUR CODE HERE
		System.out.println();
		System.out.println("Container Destinations");

		
		
		
		
		
		//****************************************
		// Worksheet1 Question #5
		// Write one line of code to examine the top element on the stack  
		//****************************************
		// ADD YOUR CODE HERE
		System.out.println();
		System.out.println();

		
		
		containersFile.close();

	} // main

} // Worksheet1

// Class representing the generic stack - named it GenericStackW1 to avoid name clashing issues
class GenericStackW1<E>  {

	private ArrayList<E> list;		// Storage for stack is provided by an ArrayList
	
	public GenericStackW1() {
		list = new ArrayList<>();	// Allocate memory
	}
	
	public boolean isEmpty (){
		return list.isEmpty();
	}
	
	public int getSize(){
		return list.size();
	}

	// Returns the top element on the top without removing it
	// Since using array list to store elements, this means getting the last element in the array
	public E peek(){
		return list.get(getSize() - 1);
	}
	
	// Removed and returns the top element on the stack 
	// Since using array list to store elements, this means removing the last element in the array
	public E pop(){		
		E value = list.remove(getSize() - 1);
		return value;
	}

	// Place a new element on the top of the stack
	// Since using array list to store elements, this means adding the element to the array
	public void push(E value){
		list.add(value); 
	}
	
} // GenericStackF20W1


//Represents a shipping container - named it ContainerW1 to name avoid clashing issues. 
class ContainerW1 { 
	private String id;			
	private String destination;
		
	public ContainerW1 (String id, String destination) {
		this.id = id;
		this.destination = destination;
	}

	public String getId() {
		return id;
	}

	public String getDestination() {
		return destination;
	}
	
} // Container




