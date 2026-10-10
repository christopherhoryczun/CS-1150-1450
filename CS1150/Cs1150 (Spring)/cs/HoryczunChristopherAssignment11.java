package cs;

/*Name: Christopher Horyczun
 * Class: CS1150 (M/W)
 * Due Date:April 23th,2025
 * Assignment: Assignment #11
 * Description: Working with an array of objects and an object that contains another object. The array of objects
 will hold race car objects, and each race car object has an odometer object. The code will simulate a race in 
 which each race car must race at least 500 miles. The race is complete once ALL race cars have raced at least 500 miles.
 */

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class HoryczunChristopherAssignment11 {

	public static void main(String[] args) throws IOException {
		
		RaceCar[] raceCars = {
				new RaceCar ("Shrek", 8, 80),
				new RaceCar ("Fiona", 11, 115),
				new RaceCar ("Donkey", 17, 70),
				new RaceCar ("Dragon", 18, 100),
				new RaceCar ("Pinocchio", 45, 85),
				new RaceCar ("Farquaad", 42, 75),
				};
		//The racers
		createRaceCars(raceCars);
				
		//File Maker
		writeRaceCarDetailsToFile(raceCars);
	}//Main
	public static void createRaceCars (RaceCar[] raceCars) {
		RaceCar[] raceCar = {
				new RaceCar ("Shrek", 8, 80),
				new RaceCar ("Fiona", 11, 115),
				new RaceCar ("Donkey", 17, 70),
				new RaceCar ("Dragon", 18, 100),
				new RaceCar ("Pinocchio", 45, 85),
				new RaceCar ("Farquaad", 42, 75),
				};
		displayAllRaceCars(raceCar);
		raceSimulation(raceCars);
	}//createRaceCars
	public static void displayRaceCar (RaceCar raceCar) {
         System.out.println("Finished: " + raceCar.getDriver() + " with " + raceCar.getOdometer() + " miles");
	}//displayRaceCar
	public static void displayAllRaceCars (RaceCar[] raceCars) {
		System.out.println("Race Cars at Start of Race");
		System.out.println("---------------------------------------------------------");
		System.out.println("Race Car" + "\t" + "Driver" + "\t\t" + "Average" + "\t\t" + "Miles");
		System.out.println("Number" + "\t\t\t\t" + "Speed" + "\t\t" + "Raced");
		System.out.println("---------------------------------------------------------");
		for(int i = 0; i < raceCars.length;i++) {
			System.out.print(raceCars[i].getNumber());
            System.out.print("\t\t" + raceCars[i].getDriver());
            System.out.print("\t\t" + raceCars[i].getAverageSpeed() + " mph");
            System.out.print("\t" + "0.00" + " miles\n");
		}
	}//displayAllRaceCars
	public static void raceSimulation(RaceCar[] raceCars) {
		
		System.out.println();
		double minuteRaced = 0;
		int interationCounter = 1;
		boolean raceComplete = false;
		System.out.println("All cars are ready - let the race began in 5..4..3..2..1");
		while (!raceComplete) {
			System.out.println("Racing time ... " + (minuteRaced + 0.15) + " hours");
			if (interationCounter % 4 == 1) {
				System.out.println("Racing time ... " + (minuteRaced * 1.0) + " hours");
				for (int i = 0; i < raceCars.length; i++) {
					RaceCar raceCar = raceCars[i];
					if (!raceCar.isFinished()) {
						double speed = raceCar.getAverageSpeed();
						Odometer odometer = raceCar.getOdometer();
						double miles = raceCar.getOdometer += speed;
						if (miles >= 500) {
							raceCar.setFinished(raceComplete);
							displayRaceCar(raceCar);
						}
						}
					}
				raceComplete = isRaceFinished(raceCars);
				}
			interationCounter++;
		}
	}//raceSimulation
	public static boolean isRaceFinished (RaceCar[] raceCars) {
		 for (RaceCar car : raceCars) {
	            if (!car.isFinished()) {
	                return false;
	            }
	        }
	        return true;
	}//isRaceFinished
	public static void writeRaceCarDetailsToFile(RaceCar[] raceCars) throws IOException {
		//Setup file reference
		File fileName = new File("Assignment11.txt");
		//Creating the file that the race car will be written into
		PrintWriter resultsFile = new PrintWriter (fileName);
		//Detail for each race car
		resultsFile.println("Race Car Details");
		for (int i = 0; i < raceCars.length; i ++) {
			resultsFile.println("Race Car #: " + raceCars[i].getNumber());
			resultsFile.println("Driver:     " + raceCars[i].getDriver());
			resultsFile.println("Miles:      " + raceCars[i].getOdometer().getMiles());
			resultsFile.println();
			resultsFile.println();
		}
		//close the file
		resultsFile.close();
		//Where the text file can be found at
		System.out.println("Find the file here " + fileName.getAbsolutePath());
		System.out.println();
		
	}//writeRaceCarDetailsToFile

}//Assignment 11
class RaceCar {
	public double getOdometer;
	//Private data field
	private String driver;
	private int number;
	private double averageSpeed;
	private boolean finished;
	private Odometer odometer;
	//Public Methods (Constructor)
	public RaceCar (String driver, int number, double averageSpeed) {
		this.driver = driver;
		this.number = number;
		this.averageSpeed = averageSpeed;
		odometer = new Odometer();
	}
	//Public Methods (Getters)
	public String getDriver() {
		return driver;
	}
	public int getNumber() {
		return number;
	}
	public double getAverageSpeed() {
		return averageSpeed;
	}
	public boolean isFinished() {
		return finished;
	}
	public Odometer getOdometer() {
		return odometer;
	}
	//Public Methods (Setters)
	public void setFinished(boolean finished) {
		this.finished = finished;
	}
}//RaceCar

class Odometer {
	//Private data field
	private double miles;
	public Odometer() {
		
	}
	//Public Methods (Getters)
	public double getMiles() {
		return miles;
	}
	public void updateMiles (double milesTraveled) {
		
	}
}