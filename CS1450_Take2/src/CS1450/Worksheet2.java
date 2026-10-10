package CS1450;

import java.util.LinkedList;
import java.util.Queue;

public class Worksheet2 {

	public static void main(String[] args) {
		
		//*******************************************
		// Worksheet2 Question #1 
		// Queue in main - queue is NOT nested inside a class
		// Practice creating a queue and adding the values 68, 8, 17, 47
		//*******************************************
		// ADD CODE HERE
		// Name the queue -> queueNotNested
		Queue<Integer> queueNotNested = new LinkedList<>();

		queueNotNested.offer(68);
		queueNotNested.offer(8);
		queueNotNested.offer(17);
		queueNotNested.offer(47);
		
		
		
		// Test your non-nested queue by displaying the values in the queue
		System.out.println("Values in a queue that is not nested in a class");
		int queueLength = queueNotNested.size();
		for (int i = 0; i < queueLength; i++) {
			System.out.println("aQueue[" + i + "] = " + queueNotNested.remove());
		}

		//********************************
		// Worksheet2 Question #2
		// See IntegerQueue Class below
		//********************************

		
		//********************************
		// Worksheet2 Question #3a 
		// Use this code to test your IntegerQueue class
		// The queue is now nested inside a class called IntegerQueue
		// Create an object of type IntegerQueue and add the values 68, 8, 17, 47
		//********************************
		// ADD CODE HERE
		IntegerQueueW2 queueNested = new IntegerQueueW2();

		queueNested.offer(68);
		queueNested.offer(8);
		queueNested.offer(17);
		queueNested.offer(47);
		
		






		//********************************
		// Worksheet2 Question #3b
		// Test your nested queue by displaying the values in the queue
		//********************************
		// ADD CODE HERE		
		System.out.println();
		System.out.println("Values in a queue nested in a class");
		while(queueNested.size() > 0) {
		    System.out.println(queueNested.remove());
		}
		
		
		

		
	} // main

} // Worksheet2


//****************************************************
//Worksheet2 Question #2
//This class "contains" a queue of integers - HAS-A relationship
//The class will provide methods to access the queue
//Write the code for each method
//****************************************************
class IntegerQueueW2 {
	
	private Queue<Integer> numberQueue = new LinkedList<>();

	public int size() {
		// ADD CODE HERE
		return numberQueue.size();
	}
	
	public void offer(Integer value) {
		// ADD CODE HERE
		numberQueue.offer(value);
		
	}
	
	public Integer remove() {
		// ADD CODE HERE
		return numberQueue.remove();
		
		
	}
	
} // IntegerQueueW2


