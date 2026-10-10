// Solution Assignment #11 CS1150 Spring 2025
// Topic: More Objects and Arrays of Objects
//
// Note: 
// This solution code may not be copied, doing so will result in a grade of zero.
// This solution is not for distribution online or by any other means. Copyright M. Gonzalez UCCS
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class CS1150_Assignment11_Spring2025 {

	public static void main(String[] args) throws IOException {
		
		final int NUM_RACE_CARS = 6;
		
		// Create an array with NUM_RACE_CARS objects		
		// Create the cars based on assignment sheet and place into the array
		RaceCarS25[] raceCars = new RaceCarS25[NUM_RACE_CARS];
		createRaceCars(raceCars);		
		
		// Display the race cars at start of race
		System.out.println("Race cars at start of race");
		displayAllRaceCars (raceCars);

		// Start the race (loop that simulates the race)
		System.out.println("All cars are ready - let the race begin in 5..4..3..2..1");
		raceSimulation(raceCars);

		// Display the race cars at the end of the simulation
		System.out.println();
		System.out.println("Race cars at end of race");
		displayAllRaceCars (raceCars);
		
		// Print the details to a file for each race car at the end of the simulation
		// The file should be located in your eclipse workspace under your CS1150 directory
		writeRaceCarDetailsToFile(raceCars);
		
	} // main

	
	// Sets up the race cars for the simulation
	// Input: An array that stores all cars 
	public static void createRaceCars(RaceCarS25[] raceCars) {
				
		// Create the actual race car objects for each location in the array.
		// Hard coding is allowed in this method.
		// Initialize each car based on the following:
		// Car #0 - Shrek, 8, 80	(driver = Shrek, race car # = 8, average speed = 80)
		// Car #1 - Fiona, 11, 115	
		// Car #2 - Donkey, 17, 70
		// Car #3 - Dragon, 18, 100
		// Car #4 - Pinocchio, 45, 85 
		// Car #5 - Farquaad, 42, 75 
		
		// STUDENT NOTE: This code calls the RaceCar constructor and directly places the object
		// returned by the constructor into the array all in one step instead of two. 
		// If two steps were used the code would looks like this:
		//     RaceCarS25 aRaceCar = new RaceCarS25("Shrek", 8, 80);
		//     raceCars[0] = aRaceCar;
		// This code combines the two steps into one:
		raceCars[0] = new RaceCarS25("Shrek", 8, 80);
		raceCars[1] = new RaceCarS25("Fiona", 11, 115);
		raceCars[2] = new RaceCarS25("Donkey", 17, 70);
		raceCars[3] = new RaceCarS25("Dragon", 18, 100);
		raceCars[4] = new RaceCarS25("Pinocchio", 45, 85);
		raceCars[5] = new RaceCarS25("Farquaad", 42, 75);
		
	} // createRaceCars
	
	
	// Display the details (driver’s name and miles raced) for a single race car 
	public static void displayRaceCar(RaceCarS25 raceCar) {
		
		// Display the name of the driver and miles races for the incoming race car
		System.out.println("Finished: " + raceCar.getDriver() + 
		           			" with " + raceCar.getOdometer().getMiles() + " miles");
	} // displayRaceCar

	
	// Display a header and the information for each race car
	public static void displayAllRaceCars(RaceCarS25[] raceCars) {
	
		System.out.printf("%s\n", "---------------------------------------------------------");
		System.out.printf("%-12s%-12s%-12s%-12s\n", "Race Car", "Driver", "Average", "Miles");
		System.out.printf("%-12s%-12s%-12s%-12s%-10s\n", "Number", "", "Speed", "Raced", "");		
		System.out.printf("%s\n", "---------------------------------------------------------");

		// Print details for each race car
		for (int i = 0; i < raceCars.length; i++) {
			RaceCarS25 aRaceCar = raceCars[i];
			System.out.printf("%-12d", aRaceCar.getNumber());
			System.out.printf("%-12s", aRaceCar.getDriver());
			System.out.printf("%-12.2f", aRaceCar.getAverageSpeed());
			System.out.printf("%-12.2f", aRaceCar.getOdometer().getMiles());
			System.out.println();
		}
		System.out.println();
		
	} // displayAllRaceCars


	// Simulate the race which continues until all car reach 500 miles
	public static void raceSimulation(RaceCarS25[] raceCars) {

		final int MAX_RACE_MILES = 500;
		
		// Initialize variables needed for race simulation
		double minutesRaced = 0;
		int loopIteration = 1;
		
		boolean raceComplete = false;
		while (!raceComplete) {

			// Every iteration through while loop represents 15 minutes of racing
			// Print current racing time
			minutesRaced = minutesRaced + 15;
			System.out.println("Racing time ... " + minutesRaced/60.0 + " hours");
			
			// Every 4th iteration through the while loop represents 1 hour of racing
			// Use modulo operator to determine if iteration is a factor of 4
			// Modulo returns remainder so reminder is 0 when iteration is a factor of 4 
			if (loopIteration % 4 == 0) { 
	
				// Update each race car's odometer after an hour of racing 
				for (int i = 0; i < raceCars.length; i++) {
			
					// If current car has not completed the race, update its odometer for one hour of racing
					// Because the odometer is updated once each hour, send the updateMiles method the 
					// average speed (average speed = miles traveled in one hour)
					RaceCarS25 currentRaceCar = raceCars[i];
					if (currentRaceCar.isFinished() == false) {
						// Obtain the average speed and odometer for the current race car
						double averageSpeed = currentRaceCar.getAverageSpeed();
						OdometerS25 odometer = currentRaceCar.getOdometer();
						odometer.updateMiles(averageSpeed);
					
						// Next check if this race car has reached 500 miles
						// If race car has race 500 miles or more, set it to finished and display its details
						if (odometer.getMiles() >= MAX_RACE_MILES) { 
							currentRaceCar.setFinished(true);
							displayRaceCar(currentRaceCar);
						}
					}
				} // for loop
				
				// After updating the race cars, determine if the race is finished
				// That is, have ALL race cars reached at least 500 miles 
				// Set flag based on if race is finished or is still going
				raceComplete = isRaceFinished(raceCars);
				
			} // if hour completed

			loopIteration++;
			
		} // while racing

	}  // raceSimulation
	
	
	// Determines if the race is finished, that is, have ALL race cars finished the race.
	// If "finished" state for all race cars is true, return true otherwise false.
	public static boolean isRaceFinished(RaceCarS25[] raceCars) {
		
		// Assume race is finished
		boolean raceFinished = true;
		
		// Examine each car in the array to see if any cars are still racing
		// If any car is still racing set raceFinished back to false
		for (int i = 0; i < raceCars.length; i++ ) {
			if (raceCars[i].isFinished() == false) {
				raceFinished = false;
			}
		}
		
		// Return boolean indicating if all race cars have finished the race
		return raceFinished;
	}
		
	
	// Print the details for each race car in the race cars array to a file
	public static void writeRaceCarDetailsToFile(RaceCarS25[] raceCars) throws IOException {
		
		// Setup the file reference variable to refer to the text file.
		// assignment11.txt is the file that will be created on your hard drive.
		// Locate the file in your CS1150 eclipse workspace on your hard drive.
		// Compare the file contents to what is in the code below.
		File fileName = new File("Assignment11.txt");
		
		// Create the file that the race cars will be written to.
		// This means: connect assignment11.txt on your hard drive to variable resultsFile in code.
		PrintWriter resultsFile = new PrintWriter (fileName);
		
		// Write the details for each race car to the file
		resultsFile.println("Race Car Details");
		for (int i = 0; i < raceCars.length; i ++) {
			resultsFile.println("Race Car #: " + raceCars[i].getNumber());
			resultsFile.println("Driver:     " + raceCars[i].getDriver());
			resultsFile.println("Miles:      " + raceCars[i].getOdometer().getMiles());
			resultsFile.println();
			resultsFile.println();
		}
		resultsFile.close();

		// This code shows where the file is located on your hard drive.
		// Locate the file in your CS1150 eclipse workspace on your hard drive.
		// Compare the file contents to what is in the above code.
		System.out.println("Find the file here " + fileName.getAbsolutePath());
		System.out.println();
		
	} //writeRaceCarDetailsToFile

} // Assignment11


//Represents one race car
class RaceCarS25 {

	private String driver;			// Race car's driver
	private int number;				// Race car's racing number
	private double averageSpeed;	// Race car's average race speed
	private boolean finished;	    // Set to true when race car reaches 500 or more miles
	private OdometerS25 odometer;	// Race car's odometer - this is a "HAS-A" relationship
		
	public RaceCarS25(String driver, int number, double averageSpeed) {
	
		this.driver = driver;
		this.number = number;
		this.averageSpeed = averageSpeed;
		
		// STUDENT NOTE: it is not necessary to set finished to false since finished will
		// default to false when RaceCar is created.  This code was included for clarity.
		this.finished = false;
		
		// Allocated memory for the race car's odometer 
		odometer = new OdometerS25();
	}
	
	public String getDriver () {
		return driver;
	}
	
	public int getNumber () {
		return number;
	}
	
	public double getAverageSpeed() {
		return averageSpeed;
	}
	
	public boolean isFinished() {
		return finished;
	}

	public OdometerS25 getOdometer() {
		return odometer;
	}

	public void setFinished(boolean finished) {
		this.finished = finished;
	}

} // RaceCar


//Represents the odometer in a race car
class OdometerS25 {
	
	private double miles;	// Number of miles raced
	
	// Constructor to create odometer 
	public OdometerS25 () {
		// STUDENT NOTE: Setting miles to zero is not needed since miles will be defaulted 
		// to zero when the code creates an odometer. That means, this entire constructor 
		// is not needed in the code.  I included so I could provide this explanation. 
		miles = 0;
	}
	
	public double getMiles() {
		return miles;
	}
		
	// Update the odometer miles by the number of miles the race car has traveled 
	public void updateMiles (double milesTraveled) {
		miles = miles + milesTraveled;
	}
	
} // Odometer

