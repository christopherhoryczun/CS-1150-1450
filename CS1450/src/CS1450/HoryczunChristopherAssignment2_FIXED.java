package CS1450;

/*
 * Name: Christopher Horyczun
 * Class: CS1450 (M/W or T/R)
 * Due Date: September 10, 2025 (MW)
 * Assignment #2
 * Description: Review of classes, objects, inheritance and polymorphism.
 *
 * Pseudocode for main:
 * 1. Open Vehicles.txt for reading
 * 2. Read the first int -> numVehicles
 * 3. Create Vehicle[] of size numVehicles
 * 4. For i from 0 to numVehicles-1:
 *      a. Read type with next()
 *      b. Read name with nextLine() and trim()
 *      c. Create correct subclass (Bus/Car/Motorcycle/Train)
 *      d. Store in array
 * 5. Print formatted table: Type | Name | Sound
 * 6. Create RepairShop
 * 7. Call fillRepairShop(vehicles)
 * 8. Call printRepairShopDetails()
 */

import java.io.*;
import java.util.*;

public class HoryczunChristopherAssignment2 {

    public static void main(String[] args) throws IOException {
        // Step 1: Open file
        File file = new File("Vehicles.txt");
        Scanner fileInput = new Scanner(file);

        // Step 2: Read number of vehicles
        int numVehicles = fileInput.nextInt();
        fileInput.nextLine(); // move to the next line

        // Step 3: Create the polymorphic array
        Vehicle[] vehicles = new Vehicle[numVehicles];

        // Step 4: Read vehicles and create specific objects
        for (int i = 0; i < numVehicles; i++) {
            String travelType = fileInput.next();           // type token
            String name = fileInput.nextLine().trim();      // rest of the line = name

            if (travelType.equalsIgnoreCase("bus")) {
                vehicles[i] = new Bus(name);
            } else if (travelType.equalsIgnoreCase("car")) {
                vehicles[i] = new Car(name);
            } else if (travelType.equalsIgnoreCase("motorcycle")) {
                vehicles[i] = new Motorcycle(name);
            } else if (travelType.equalsIgnoreCase("train")) {
                vehicles[i] = new Train(name);
            }
        }
        fileInput.close();

        // Step 5: Print the formatted table
        System.out.println("----------------------------------------------------------------------------");
        System.out.printf("%-12s %-20s %-25s%n", "Type", "Name", "Sound");
        System.out.println("----------------------------------------------------------------------------");
        for (int i = 0; i < vehicles.length; i++) {
            System.out.printf("%-12s %-20s %-25s%n",
                    vehicles[i].getType(),
                    vehicles[i].getName(),
                    vehicles[i].sound());
        }

        // Step 6: Create and fill the repair shop
        RepairShop shop = new RepairShop();
        shop.fillRepairShop(vehicles);

        // Step 7: Print repair shop details
        shop.printRepairShopDetails();
    }
}

// ========================== Vehicle Superclass ==============================
class Vehicle {
    private String type;   // bus, car, motorcycle, train
    private String name;   // vehicle's name

    public Vehicle(String type, String name) {
        this.type = type;
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public String sound() {
        return "Generic vehicle sound";
    }
}

// ========================== Subclasses ======================================
class Bus extends Vehicle {
    public Bus(String name) {
        super("Bus", name);
    }

    @Override
    public String sound() {
        return "Rum-rum-rum-rummm";
    }
}

class Car extends Vehicle {
    public Car(String name) {
        super("Car", name);
    }

    @Override
    public String sound() {
        return "Vroom-vroom-vroommm";
    }
}

class Motorcycle extends Vehicle {
    public Motorcycle(String name) {
        super("Motorcycle", name);
    }

    @Override
    public String sound() {
        return "Bom-bom-bom";
    }
}

class Train extends Vehicle {
    public Train(String name) {
        super("Train", name);
    }

    @Override
    public String sound() {
        return "Chooga-chooga-chooga";
    }
}

// ========================== RepairShop Class ================================
class RepairShop {
    private int numCars;
    private int numMotorcycles;
    private Vehicle[] vehiclesToRepair;

    public RepairShop() {
        numCars = 0;
        numMotorcycles = 0;
        vehiclesToRepair = new Vehicle[0];
    }

    // Fill with only cars and motorcycles using instanceof (per assignment)
    public void fillRepairShop(Vehicle[] vehicles) {
        // First pass: count
        for (int i = 0; i < vehicles.length; i++) {
            if (vehicles[i] instanceof Car) {
                numCars++;
            } else if (vehicles[i] instanceof Motorcycle) {
                numMotorcycles++;
            }
        }

        // Create array with exact size
        vehiclesToRepair = new Vehicle[numCars + numMotorcycles];

        // Second pass: add the right vehicles
        int idx = 0;
        for (int i = 0; i < vehicles.length; i++) {
            if (vehicles[i] instanceof Car || vehicles[i] instanceof Motorcycle) {
                vehiclesToRepair[idx] = vehicles[i];
                idx++;
            }
        }
    }

    public void printRepairShopDetails() {
        System.out.println();
        System.out.println("--------------------------------------------");
        System.out.println("Car and Motorcycle Repair Shop");
        System.out.println("--------------------------------------------");
        System.out.println("Number of Cars:        " + numCars);
        System.out.println("Number of Motorcycles: " + numMotorcycles);
        System.out.println();

        for (int i = 0; i < vehiclesToRepair.length; i++) {
            System.out.printf("%-12s --- %s%n",
                    vehiclesToRepair[i].getType(),
                    vehiclesToRepair[i].getName());
        }
    }
}
