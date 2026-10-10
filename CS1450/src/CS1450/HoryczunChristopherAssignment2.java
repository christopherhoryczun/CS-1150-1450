package CS1450;

/*
 * Name: Christopher Horyczun
 * Class: CS1450 (M/W or T/R)
 * Due Date: September 10, 2025 (MW)
 * Assignment #2
 * Description: To help review objects, inheritance, and polymorphism. Write code to create 
 * the following hierachy (vehicle --> bus,car,motorcycle,train) and have superclass and subclass.
 * Then create a repair shop to show what needs to be fixed. Make sure there is a sound section.
 */

//Extend
import java.io.*;
import java.util.*;

public class HoryczunChristopherAssignment2 {

	public static void main(String[] args) throws IOException {
		
		//file
		File file = new File("Vehicles.txt");
		Scanner fileInput = new Scanner(file);
		
		//read file
		int numVehicles = fileInput.nextInt();
		fileInput.nextLine();
		
		//Array
		Vehicle[] zoom = new Vehicle[numVehicles];
		
		//To read every line in the file
		for (int i = 0; i < numVehicles; i++) {
			String travelType = fileInput.next();     
            String name = fileInput.nextLine().trim();          

            // Decide which subclass to create
            if (travelType.equalsIgnoreCase("bus")) {
                zoom[i] = new Bus(name);
            } else if (travelType.equalsIgnoreCase("car")) {
                zoom[i] = new Car(name);
            } else if (travelType.equalsIgnoreCase("motorcycle")) {
                zoom[i] = new Motorcycle(name);
            } else if (travelType.equalsIgnoreCase("train")) {
                zoom[i] = new Train(name);
            }

		}//end of for loop
		
		fileInput.close();
		
		//Print the table
		System.out.println("----------------------------------------------------------------------------");
        System.out.printf("%-12s %-20s %-25s%n", "Type", "Name", "Sound");
        System.out.println("----------------------------------------------------------------------------");
        
        for (int i = 0; i < zoom.length; i++) {
        	System.out.printf("%-12s %-20s %-25s%n",
        			zoom[i].getType(),
        			zoom[i].getName(),
        			zoom[i].sound());
        }//end of for-loop
        
        //Who needs a repair
        RepairShop shop = new RepairShop();
        shop.fillRepairShop(zoom);
        shop.printRepairShopDetails();
        
	}//end of Main
}//end of Assignment #2

	class Vehicle {
		//Private Data field
		private String type;
		private String name;

	    //Public Methods
	    public Vehicle(String type, String name) {
	        this.type = type;
	        this.name = name;
	    }

	    //Getter
	    public String getType() {
	        return type;
	    }
	    public String getName() {
	        return name;
	    }

	    //Sound
	    public String sound() {
	        return "Generic vehicle sound";
	    }
	}//end of vehicle class
	
	class Bus extends Vehicle {
	    public Bus(String name) {
	        super("Bus", name);  // type first, then name
	    }
	    @Override
	    public String sound() {
	        return "Rum-rum-rum-rumm";
	    }
	}//end of bus

	class Car extends Vehicle {
		public Car(String name) {
			super("Car", name);
		}
		@Override
		public String sound() {
			return "Vroom-vroom-vroommm";
		}
	}//Car
	
	class Motorcycle extends Vehicle {
		public Motorcycle(String name) {
			super("Motorcycle", name);
		}
		@Override
		public String sound() {
			return "Bom-bom-bom";
		}
	}//Motorcycle
	
	class Train extends Vehicle {
		public Train(String name) {
			super("Train", name);
		}
		@Override
		public String sound() {
			return "Chooga-chooga-chooga";
		}
	}//Train
	
	class RepairShop {
		
		//Private Data Types
		private int numCars;
		private int numMotorcycles;
		private Vehicle[] vehiclesToRepair;
		
		//Constructor
		public RepairShop() {
			numCars = 0;
			numMotorcycles = 0;
			vehiclesToRepair = new Vehicle[0];
		}
		
		public void fillRepairShop (Vehicle[] vehicles) {
			
			//Get count of each vehicles
			for (int i = 0; i < vehicles.length; i++) {
				if (vehicles[i].getClass() == Car.class) {
					numCars++;
				} else if (vehicles[i].getClass() == Motorcycle.class) {
					numMotorcycles++;
				}//end of if-statement
				
			}//end of for loop
			
			//Get total Numbers
			int totalRepairs = numCars + numMotorcycles;
			vehiclesToRepair = new Vehicle[totalRepairs];
			
			//add to Array
			int count = 0;
			for (int i = 0; i < vehicles.length; i++) {
				if (vehicles[i].getClass() == Car.class || vehicles[i].getClass() == Motorcycle.class) {
					vehiclesToRepair[count] = vehicles[i];
					count++;
				}//end of if-statement
				
			}//end of for loop
			
		}//end of fillRepairShop
		
		public void printRepairShopDetails () {
			System.out.println("--------------------------------------------");
			System.out.println("Car and Motorcycle Repair Shop");
			System.out.println("--------------------------------------------");
			System.out.println();
			System.out.println("Number of Cars:\t\t" + numCars);
			System.out.println("Number of Motorcycles:\t" + numMotorcycles);
			
			
		}//end of printRepairShopDetails
		
	}//end of RepairShop
