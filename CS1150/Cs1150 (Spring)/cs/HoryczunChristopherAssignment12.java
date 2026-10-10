package cs;

/*Name: Christopher Horyczun
 * Class: CS1150 (M/W)
 * Due Date:April 30th,2025
 * Assignment: Assignment #12
 * Description: Giving the opportunity to work with objects using inheritance and polymorphism create a program that create one Superclass, several Subclass, and use polymorphism.
*/ 
	
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class HoryczunChristopherAssignment12 {
	
	public static void main(String[] args) throws IOException {
		
		//Setup for File reference variable
		File inputFileName = new File("Animals.txt");
		
		//Open the file for reading
		Scanner inputFile = new Scanner (inputFileName);
		
		//Reading the document
		int numOfAnimals = inputFile.nextInt();
		inputFile.nextLine();
		
		//Polymorphic array of Animal objects
		Animal[] animals = new Animal[numOfAnimals];
		
		//To read the document line by line and give the data need by order until done
		for (int i = 0; i < numOfAnimals; i++) {
			
			//To read the document line by line
			String line = inputFile.nextLine();
			Scanner lineScanner = new Scanner(line);
			
			//type of animal
			String type = lineScanner.next();
			
			//animal's name
			String name = lineScanner.next();
			
			//what the animal eats
			String food = lineScanner.next();
			
			//aniaml's weight
			int weight = lineScanner.nextInt();
			
			//how long the animal sleeps for
			int sleep = lineScanner.nextInt();
			
			//where does the animal live
			String location1 = lineScanner.next();
			String location2 = lineScanner.next();
			String location = location1 + " " + location2;
			
			//Creating the animal based on the type of animal
			Animal animal = null;
			switch (type.toLowerCase()) {
			
			//If its a bear
			case "bear":
				animal = new Bear(name, food, weight, sleep, location);
				break;
				
			//if its an elephant
			case "elephant":
				animal = new Elephant(name, food, weight, sleep, location);
				break;
				
			//if its a monkey	
			case "monkey":
				animal = new Monkey(name, food, weight, sleep, location);
				break;
				
			//if its a sloth	
			case "sloth":
				animal = new Sloth(name, food, weight, sleep, location);
				break;
				
			//Unknown animal	
			default:
				System.out.println("Unknown animal type: " + type);
				break;
				}
			
			//Save the data collected to animals for later
			if (animal != null) {
				animals[i] = animal;
				}
			
		}
		
		//Giving the data to the user
		for (int i = 0; i < animals.length; i++) {
			Animal animal = animals[i];
			
			//Find the type of animal
			if (animal != null) {
				String type = animal.getClass().getSimpleName();
				
				//Animal Number and type of animal
				System.out.println("Animal[" + i + "] is a " + type);
				
				//Animal details
				System.out.println(animals.getClass().getSimpleName() + " Name: " + animal.getName() 
						+ " - Weight: " + animal.getWeight() + " lbs - Sleeps: " + animal.getSleep() 
						+ " hours - Location: " + animal.getLocation());
				
				//Eating
				animal.eat();
				
				//Sleeping
				animal.sleep();
				
				//Swimming (if the animal swims
				animal.swim();
				System.out.println();
			}
			
		}
		
		//close the file
		inputFile.close();
		
	}//End of Main
	
}//Assignment 12

//Class Animal
class Animal {
	
	//Way the collect names
	private String name;
	
	//Way to collect what they will eat
	private String food;
	
	//weight Counter
	private int weight;
	
	//Sleep Schedule
	private int sleep;
	
	//Where do they live
	private String location;
	
	//Animal initializing
	public Animal (String name, String food, int weight, int sleep, String location) {
		this.name = name;
		this.food = food;
		this.weight = weight;
		this.sleep = sleep;
		this.location = location;
	}
	
	//Getters

	public String getName() {
		return name;
	}
	
	public String getFood() {
		return food;
	}
	
	public int getWeight() {
		return weight;
	}
	
	public int getSleep() {
		return sleep;
	}
	
	public String getLocation() {
		return location;
	}
	
	//void Methods
	
	public void eat() {
		//To tell us if the animal is eating
		System.out.println("Animal is eating");
	}
	
	public void sleep() {
		//To tell us if the animal is sleeping
		System.out.println("Animal is sleeping  - do not disturb");
	}
	
	public void swim() {
		//To tell us if the animal is swimming
		System.out.println("Animal is swimming");
	}
	
}

//Bear Class
class Bear extends Animal {
	
	public Bear (String name, String food, int weight, int sleep, String location) {
		super (name, food, weight, sleep, location);
	}
	
	//OverRide Code
	@Override
	public void eat() {
		System.out.println("Bear is eating " + getFood());
	}
	
	@Override
	public void sleep() {
		System.out.println("Bear is sleeping for " + getSleep() + " hours");
	}
	
	@Override
	public void swim() {
		System.out.println("Bear is swimming");
	}
	
}

//Elephant Class
class Elephant extends Animal {
	
	public Elephant (String name, String food, int weight, int sleep, String location) {
		super (name, food, weight, sleep, location);
	}
	
	//OverRide Code
	@Override
	public void sleep() {
		System.out.println("Elephant is sleeping for " + getSleep() + " hours");
	}
	
}

//Monkey class
class Monkey extends Animal {
	
	public Monkey (String name, String food, int weight, int sleep, String location) {
		super (name, food, weight, sleep, location);
	}
	
	//OverRide Code
	@Override
	public void eat() {
		System.out.println("Monkey is eating " + getFood());
	}
	
	@Override
	public void swim() {
		System.out.println("Monkey is swimming");
	}
	
}

//Sloth Class
class Sloth extends Animal {
	
	public Sloth (String name, String food, int weight, int sleep, String location) {
		super (name, food, weight, sleep, location);
	}
	
}
