// Solution Assignment #12 CS1150 Spring 2025
// Topic: Inheritance and Polymorphism
//
// Note: 
// This solution code may not be copied, doing so will result in a grade of zero.
// This solution is not for distribution online or by any other means. Copyright M. Gonzalez UCCS

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class CS1150_Assignment12_Spring2025 {

	public static void main(String[] args) throws IOException {
		
		// Name of file to read animals from
		final String FILE_NAME = "Animals.txt";

		// Setup the file reference variable to refer to the text file
		// Open the file for reading by creating a scanner for the file
		File inputFileName = new File(FILE_NAME);
		Scanner inputFile = new Scanner(inputFileName);

		// Create an array to hold Animal objects
		// The first value in the file is the size of the array
		int numAnimals = inputFile.nextInt();
		AnimalS25[] animals = new AnimalS25[numAnimals];

		// For each line in the file, create the correct object and place the object into array.
		for (int i = 0; i < animals.length; i++) {

			// Read information for the current animal
			String type = inputFile.next();
			String name = inputFile.next();
			String food = inputFile.next();
			int weight = inputFile.nextInt();
			int sleep = inputFile.nextInt();
			String location = inputFile.nextLine();

			// Determine which animal was read and create an object for that animal
			// Place animal object into the array
			switch (type) {
			  case "Bear":
				animals[i] = new BearS25(name, food, weight, sleep, location);
				break;
			  case "Elephant":
				animals[i] = new ElephantS25(name, food, weight, sleep, location);
				break;
			  case "Monkey":
				animals[i] = new MonkeyS25(name, food, weight, sleep, location);
				break;
			  case "Sloth": 
				  animals[i] = new SlothS25(name, food, weight, sleep, location);
				break;
			}
		} // for

		// Now demonstrate the power of polymorphism!
		for (int i = 0; i < animals.length; i++) {
			System.out.println();
			if (animals[i] instanceof BearS25) {
				System.out.println("Animal[" + i + "] is a Bear");
			} 
			else if (animals[i] instanceof ElephantS25) {
				System.out.println("Animal[" + i + "] is a Elephant");
			}
			else if (animals[i] instanceof MonkeyS25) {
				System.out.println("Animal[" + i + "] is a Monkey");
			} 
			else if (animals[i] instanceof SlothS25) {
				System.out.println("Animal[" + i + "] is a Sloth");
			} 

			// STUDENT NOTE: You can call the toString method explicitly but if you leave the call off, 
			// the toString method is called implicitly as shown in the code below.
			// Explicit call: System.out.println(animals[i].toString());
			// Implicit call: System.out.println(animals[i]);
			System.out.println(animals[i].toString());
			
			animals[i].eat();
			animals[i].sleep();
			animals[i].swim();

		} // for loop

		inputFile.close();		
	}

} // Assignment 12


class AnimalS25 {

	// Instance variables for an Animal
	private String name;
	private String food;
	private int weight;
	private int sleep;
	private String location;

	// STUDENT NOTE: There is NO NEED for a default constructor.
	// In this assignment it is never used and could be left off without hurting anything.
	// Developers many times include the default constructor because some Java libraries
	// require the existence of a default constructor such as libraries for serialization.
	// In any case, for this assignment the default constructor was left off.

	// Constructor that initializes the instance variables
	public AnimalS25(String name, String food, int weight, int sleep, String location) {
		this.name = name;
		this.food = food;
		this.weight = weight;
		this.sleep = sleep;
		this.location = location;
	}

	// Return animal's name
	public String getName() {
		return name;
	}

	// Return animal's food
	public String getFood() {
		return food;
	}
	
	// Return animal's weight
	public int getWeight() {
		return weight;
	}

	// Return animal's sleep time
	public int getSleep() {
		return sleep;
	}

	// Return animal's location
	public String getLocation() {
		return location;
	}

	// Make animal eat
	public void eat() {
		System.out.println("Animal is eating");
	}

	// Make animal sleep
	public void sleep() {
		System.out.println("Animal is sleeping - do not disturb");
	}

	// Make animal swim
	public void swim() {
		System.out.println("Animal is swimming");
	}

} // Animal


class BearS25 extends AnimalS25 {

	public BearS25(String name, String food, int weight, int sleep, String location) {
		// You could create setters in Animal and call them to set the values but calling
		// super is the way this assignment is handling setting the instance variables.
		// Both approaches are used in industry.
		super(name, food, weight, sleep, location);
	}

	@Override
	public void eat() {
		System.out.println("Bear is eating " + getFood());
	}

	@Override
	public void sleep() {
		System.out.println("Bear is sleeping " + getSleep() + " hours");
	}

	@Override
	public void swim() {
		System.out.println("Bear is swimming");
	}

	@Override
	public String toString() {
		return "Bear: Name: " + getName() + 
				" - Weighs: " + getWeight() + 
				" lbs - Sleeps: " + getSleep() +
				" hours - Location: " + getLocation();
	}

} // Bear


class ElephantS25 extends AnimalS25 {

	public ElephantS25(String name, String food, int weight, int sleep, String location) {
		super(name, food, weight, sleep, location);
	}

	@Override
	public void sleep() {
		System.out.println("Elephant is sleeping " + getSleep() + " hours");
	}
	
	@Override
	public String toString() {
		return "Elephant: Name: " + getName() + 
				" - Weighs: " + getWeight() + 
				" lbs - Sleeps: " + getSleep() +
				" hours - Location: " + getLocation();
	}

} // Elephant


class MonkeyS25 extends AnimalS25 {

	public MonkeyS25(String name, String food, int weight, int sleep, String location) {
		super(name, food, weight, sleep, location);
	}

	@Override
	public void eat() {
		System.out.println("Monkey is eating " + getFood());
	}

	@Override
	public void swim() {
		System.out.println("Monkey is swimming");
	}

	@Override
	public String toString() {
		return "Monkey Name: " + getName() + 
				" - Weighs: " + getWeight() + 
				" lbs - Sleeps: " + getSleep() +
				" hours - Location: " + getLocation();
	}

} // Monkey


class SlothS25 extends AnimalS25 {

	public SlothS25(String name, String food, int weight, int sleep, String location) {
		super(name, food, weight, sleep, location);
	}

	@Override
	public String toString() {
		return "Sloth: Name: " + getName() + 
				" - Weighs: " + getWeight() + 
				" lbs - Sleeps: " + getSleep() +
				" hours - Location: " + getLocation();
	}

} // Sloth


