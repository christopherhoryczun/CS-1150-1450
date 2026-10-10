package csgo;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class rwgfailrk {
    public static void main(String[] args) {
        // Create race cars
        RaceCar[] raceCars = {
        		new RaceCar ("Steve", 0),
        		new RaceCar("Alex Johnson", 120.0),
        		new RaceCar("Brianna Lee", 125.5),
        		new RaceCar("Carlos Gomez", 118.7),
        		};

        // set iterationCounter to 1
        int iterationCounter = 1;
        boolean raceComplete = false;

        // while race is not complete
        while (!raceComplete) {

            // update the number of minutes raced by 15 minutes
            for (int i = 0; i < raceCars.length; i++) {
                raceCars[i].minutesRaced += 15;

                // display the current racing time
                System.out.println(raceCars[i].driverName + " - Racing Time: " + raceCars[i].minutesRaced + " minutes");
            }

            // if this loop iteration represents 1 hour of racing (iteration is factor of 4)
            if (iterationCounter % 4 == 0) {
                System.out.println("\n>>> 1 hour of racing passed!\n");

                // for each race car in the array
                for (int i = 0; i < raceCars.length; i++) {
                    RaceCar car = raceCars[i];

                    // if race car’s finished state is false (car is still racing)
                    if (!car.finished) {
                        // Obtain race car’s average speed and store in variable
                        double speed = car.averageSpeed;

                        // Obtain race car’s odometer and store in a variable
                        double previousMiles = car.odometer;

                        // Update the race car’s odometer for 1 hour of racing
                        car.odometer += speed;

                        // if race car’s miles >= 500
                        if (car.odometer >= 500) {
                            // set race car’s finished state to true
                            car.finished = true;

                            // display this race car details (#, driver, etc.)
                            System.out.println("🏁 Race Car #" + (i + 1) + " has finished the race!");
                            System.out.println("  Driver: " + car.driverName);
                            System.out.println("  Total Time: " + car.minutesRaced + " minutes");
                            System.out.println("  Total Miles: " + car.odometer + "\n");
                        }
                    }
                }

                // call isRaceFinished to possibly update while loop raceComplete
                raceComplete = isRaceFinished(raceCars);
            }

            // increment iterationCounter
            iterationCounter++;

            System.out.println("----- End of Iteration " + (iterationCounter - 1) + " -----\n");
        }

        System.out.println("✅ All race cars have finished the race!");
    }

    // Check if all cars are finished
    public static boolean isRaceFinished(RaceCar[] raceCars) {
        for (RaceCar car : raceCars) {
            if (!car.finished) {
                return false;
            }
        }
        return true;
    }


}

class RaceCar {
	    String driverName;
	    double averageSpeed; // in miles/hour
	    double odometer;
	    int minutesRaced;
	    boolean finished;

	    public RaceCar(String driverName, double averageSpeed) {
	        this.driverName = driverName;
	        this.averageSpeed = averageSpeed;
	        this.odometer = 0;
	        this.minutesRaced = 0;
	        this.finished = false;
	    }
	}
