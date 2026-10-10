package CS1450;

/*
 * Name: Christopher Horyczun
 * Class Name: CS1450 (M/W)
 * Due Date: Feb 11th, 2026
 * Assignment #3
 * Description:
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class HoryczunChristopherAssignment3 {
	
	public static void main(String[] args) throws FileNotFoundException {
		
		// open the input file
		File whatAnimal = new File("Animals.txt");
		Scanner animalFile = new Scanner(whatAnimal);
		
		// first number tells us how many animals are in the file
		int NumAnimals = animalFile.nextInt();
		Animal[] animals = new Animal[NumAnimals];
		
		// read each animal and create the correct object
		for (int i = 0; i < NumAnimals; i++) {
			
			String name = animalFile.next();
			String species = animalFile.next().toLowerCase();
			int swimSpeed = animalFile.nextInt();
			int runSpeed = animalFile.nextInt();
			int climbSpeed = animalFile.nextInt();
			
			if (species.equals("alligator")) {
				animals[i] = new Alligator(name, swimSpeed, runSpeed);
            }
			else if (species.equals("bear")) {
				animals[i] = new Bear(name, swimSpeed, runSpeed, climbSpeed);
            } 
            else if (species.equals("giraffe")) {
                animals[i] = new Giraffe(name, runSpeed);
            } 
            else if (species.equals("monkey")) {
                animals[i] = new Monkey(name, runSpeed, climbSpeed);
            } 
            else if (species.equals("sloth")) {
                animals[i] = new Sloth(name, swimSpeed, climbSpeed);
            }
        }

        animalFile.close();

        System.out.println("----------------------------------------------------------");
        System.out.println("all animals in array");
        System.out.println("----------------------------------------------------------");

        for (Animal animal : animals) {
            displayAnimal(animal);
        }

        System.out.println("------------------------------------------------------------");
        System.out.println("animals that can climb");
        System.out.println("------------------------------------------------------------");
        System.out.println("name\t\tspecies\t\tclimbing speed");
        System.out.println("------------------------------------------------------------");

        ArrayList<Animal> climbers = findClimbers(animals);

        for (Animal animal : climbers) {
            Climber c = (Climber) animal;
            System.out.println(
                animal.getName() + "\t\t" +
                animal.getSpecies() + "\t\t" +
                c.climb()
            );
        }

        System.out.println("\n---------------------------");
        System.out.println("most skilled animal");
        System.out.println("---------------------------");

        int bestIndex = findMostSkilled(animals);
        displayAnimal(animals[bestIndex]);

        System.out.println("\ninteresting, a new sloth named slow-bie was born at the cheyenne mountain zoo on dec 18!");
    }

    // displays one animal's information
    public static void displayAnimal(Animal animal) {

        System.out.println(
            animal.getName() + " the " +
            animal.getSpecies() + " says " +
            animal.makeNoise() + " " +
            animal.makeNoise() + " " +
            animal.makeNoise() +
            (animal.getSpecies().equals("Bear") ||
             animal.getSpecies().equals("Giraffe") ||
             animal.getSpecies().equals("Monkey") ? "!!!" : "")
        );

        if (animal instanceof Swimmer) {
            System.out.println("swimming speed: " + ((Swimmer) animal).swim());
        }
        if (animal instanceof Runner) {
            System.out.println("running speed:  " + ((Runner) animal).run());
        }
        if (animal instanceof Climber) {
            System.out.println("climbing speed: " + ((Climber) animal).climb());
        }

        System.out.println();
    }

    // finds all animals that can climb
    public static ArrayList<Animal> findClimbers(Animal[] animals) {

        ArrayList<Animal> climbers = new ArrayList<>();

        for (Animal animal : animals) {
            if (animal instanceof Climber) {
                climbers.add(animal);
            }
        }

    return climbers;
    }

    // finds the animal with the highest combined skill speeds
    public static int findMostSkilled(Animal[] animals) {

        int bestIndex = 0;
        int bestTotal = 0;

        for (int i = 0; i < animals.length; i++) {

            int total = 0;

            if (animals[i] instanceof Swimmer) {
                total += ((Swimmer) animals[i]).swim();
            }
            if (animals[i] instanceof Runner) {
                total += ((Runner) animals[i]).run();
            }
            if (animals[i] instanceof Climber) {
                total += ((Climber) animals[i]).climb();
            }

            if (total > bestTotal) {
                bestTotal = total;
                bestIndex = i;
            }
        }

        return bestIndex;
    }
}

/* interfaces */

interface Swimmer {
    int swim();
}

interface Runner {
    int run();
}

interface Climber {
    int climb();
}

/* abstract animal class */

abstract class Animal {

    private String name;
    private String species;

    // no constructor on purpose

    public String getName() {
        return name;
    }

    public void setName(String newName) {
        name = newName;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String newSpecies) {
        species = newSpecies;
    }

    public abstract String makeNoise();
}

/* subclasses */

class Alligator extends Animal implements Swimmer, Runner {

    private int swimSpeed;
    private int runSpeed;

    public Alligator(String name, int swimSpeed, int runSpeed) {
        setName(name);
        setSpecies("Alligator");
        this.swimSpeed = swimSpeed;
        this.runSpeed = runSpeed;
    }

    public int swim() {
        return swimSpeed;
    }

    public int run() {
        return runSpeed;
    }

    public String makeNoise() {
        return "Crunch";
    }
}

class Bear extends Animal implements Swimmer, Runner, Climber {

    private int swimSpeed;
    private int runSpeed;
    private int climbSpeed;

    public Bear(String name, int swimSpeed, int runSpeed, int climbSpeed) {
        setName(name);
        setSpecies("Bear");
        this.swimSpeed = swimSpeed;
        this.runSpeed = runSpeed;
        this.climbSpeed = climbSpeed;
    }

    public int swim() {
        return swimSpeed;
    }

    public int run() {
        return runSpeed;
    }

    public int climb() {
        return climbSpeed;
    }

    public String makeNoise() {
        return "Growl";
    }
}

class Giraffe extends Animal implements Runner {

    private int runSpeed;

    public Giraffe(String name, int runSpeed) {
        setName(name);
        setSpecies("Giraffe");
        this.runSpeed = runSpeed;
    }

    public int run() {
        return runSpeed;
    }

    public String makeNoise() {
        return "Bleat";
    }
}

class Monkey extends Animal implements Runner, Climber {

    private int runSpeed;
    private int climbSpeed;

    public Monkey(String name, int runSpeed, int climbSpeed) {
        setName(name);
        setSpecies("Monkey");
        this.runSpeed = runSpeed;
        this.climbSpeed = climbSpeed;
    }

    public int run() {
        return runSpeed;
    }

    public int climb() {
        return climbSpeed;
    }

    public String makeNoise() {
        return "Screech";
    }
}

class Sloth extends Animal implements Swimmer, Climber {

    private int swimSpeed;
    private int climbSpeed;

    public Sloth(String name, int swimSpeed, int climbSpeed) {
        setName(name);
        setSpecies("Sloth");
        this.swimSpeed = swimSpeed;
        this.climbSpeed = climbSpeed;
    }

    public int swim() {
        return swimSpeed;
    }

    public int climb() {
        return climbSpeed;
    }

    public String makeNoise() {
        return "Squeak";
    }
}