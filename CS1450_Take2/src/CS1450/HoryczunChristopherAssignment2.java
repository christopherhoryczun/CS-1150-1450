package CS1450;

/*
 * Name: Christopher Horyczun
 * Class Name: CS1450 (M/W)
 * Due Date: Feb 4th, 2026
 * Assignment #2
 * Description: This program uses inheritance and polymorphism to create different types of actors from a file, store them in a polymorphic array, and build a movie that only includes heroes and villains.
 */

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class HoryczunChristopherAssignment2 {

    public static void main(String[] args) throws IOException {

        // Open the input file
        File inputFile = new File("Actors.txt");
        Scanner fileScanner = new Scanner(inputFile);

        // First number tells us how many actors are in the file
        int numActors = fileScanner.nextInt();

        // Polymorphic array of actors
        Actor[] actors = new Actor[numActors];

        // Read actors from the file
        for (int i = 0; i < numActors; i++) {
            String type = fileScanner.next();
            String name = fileScanner.nextLine().trim();

            if (type.equalsIgnoreCase("Hero")) {
                actors[i] = new Hero(name);
            } else if (type.equalsIgnoreCase("Villain")) {
                actors[i] = new Villain(name);
            } else if (type.equalsIgnoreCase("Monster")) {
                actors[i] = new Monster(name);
            } else if (type.equalsIgnoreCase("Droid")) {
                actors[i] = new Droid(name);
            }
        }

        fileScanner.close();

        // Print actor table
        System.out.println("----------------------------------------------------------------------------");
        System.out.printf("%-18s\t%-10s\t%s\n", "Actor Name", "Type", "Motto To Live By");
        System.out.println("----------------------------------------------------------------------------");

        for (int i = 0; i < actors.length; i++) {
            System.out.printf("%-18s\t%-10s\t%s\n",
                    actors[i].getName(),
                    actors[i].getType(),
                    actors[i].motto());
        }

        // Create movie and select cast
        Movie movie = new Movie();
        movie.selectCast(actors);

        // Print movie details
        movie.printMovieDetails();
    }
}

/* =======================
   Actor Superclass
   ======================= */
class Actor {

    private String name;
    private String type;

    public Actor(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String motto() {
        return "Just another actor.";
    }
}

/* =======================
   Hero Class
   ======================= */
class Hero extends Actor {

    public Hero(String name) {
        super(name, "Hero");
    }

    @Override
    public String motto() {
        return "To the rescue!  KAPOW!! BAM!! POW!!";
    }
}

/* =======================
   Villain Class
   ======================= */
class Villain extends Actor {

    public Villain(String name) {
        super(name, "Villain");
    }

    @Override
    public String motto() {
        return "You’ll never stop me!  Haaaaaaa!";
    }
}

/* =======================
   Monster Class
   ======================= */
class Monster extends Actor {

    public Monster(String name) {
        super(name, "Monster");
    }

    @Override
    public String motto() {
        return "RRAAAUUGGHH GRROWR!!!";
    }
}

/* =======================
   Droid Class
   ======================= */
class Droid extends Actor {

    public Droid(String name) {
        super(name, "Droid");
    }

    @Override
    public String motto() {
        return "Beep Beep Bloop Boop Beep!";
    }
}

/* =======================
   Movie Class
   ======================= */
class Movie {

    private int numHeros;
    private int numVillains;
    private Actor[] actorsInMovie;

    public void selectCast(Actor[] actors) {

        // First pass: count heroes and villains
        for (int i = 0; i < actors.length; i++) {
            if (actors[i] instanceof Hero) {
                numHeros++;
            } else if (actors[i] instanceof Villain) {
                numVillains++;
            }
        }

        // Create array with correct size
        actorsInMovie = new Actor[numHeros + numVillains];

        // Second pass: add only heroes and villains
        int index = 0;
        for (int i = 0; i < actors.length; i++) {
            if (actors[i] instanceof Hero || actors[i] instanceof Villain) {
                actorsInMovie[index] = actors[i];
                index++;
            }
        }
    }

    public void printMovieDetails() {

        System.out.println("\n--------------------------------------------");
        System.out.println("CS1450 Heroes and Villain Movie");
        System.out.println("--------------------------------------------");

        System.out.println("Number of Heroes:   " + numHeros);
        System.out.println("Number of Villains: " + numVillains);
        System.out.println();

        for (int i = 0; i < actorsInMovie.length; i++) {
            System.out.println(actorsInMovie[i].getType() + "\t --- " + actorsInMovie[i].getName());
        }
    }
}

