import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class RaceGame {

    public static void main(String[] args) throws IOException {
        RaceCar[] raceCars = {
            new RaceCar("Shrek", 8, 80),
            new RaceCar("Fiona", 11, 115),
            new RaceCar("Donkey", 17, 70),
            new RaceCar("Dragon", 18, 100),
            new RaceCar("Pinocchio", 45, 85),
            new RaceCar("Farquaad", 42, 75),
        };

        // Let the user select a car
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose your car by entering the number (1-6): ");
        for (int i = 0; i < raceCars.length; i++) {
            System.out.println((i + 1) + ". " + raceCars[i].getDriver() + " (Speed: " + raceCars[i].getAverageSpeed() + ")");
        }

        int userChoice = scanner.nextInt();
        RaceCar userCar = raceCars[userChoice - 1];
        System.out.println("You have chosen: " + userCar.getDriver() + "\n");

        // Display initial race information
        displayAllRaceCars(raceCars);

        // Race simulation
        raceSimulation(raceCars, userCar);

        // Output race details to file
        writeRaceCarDetailsToFile(raceCars);
    }

    public static void displayRaceCar(RaceCar raceCar) {
        System.out.println("Finished: " + raceCar.getDriver() + " with " +
            raceCar.getOdometer().getMiles() + " miles");
    }

    public static void displayAllRaceCars(RaceCar[] raceCars) {
        System.out.println("Race Cars at Start of Race");
        System.out.println("--------------------------------------------------");
        System.out.println("Race Car\tDriver\t\tAverage Speed\tMiles Raced");
        System.out.println("--------------------------------------------------");

        for (RaceCar car : raceCars) {
            System.out.printf("%d\t\t%s\t\t%.2f mph\t\t%.2f miles\n",
                car.getNumber(), car.getDriver(), car.getAverageSpeed(), 0.0);
        }
    }

    public static void raceSimulation(RaceCar[] raceCars, RaceCar userCar) {
        double minuteRaced = 0.0;
        int iterationCounter = 1;
        boolean raceComplete = false;

        System.out.println("\nAll cars are ready - let the race begin in 5..4..3..2..1\n");

        while (!raceComplete) {
            minuteRaced += 0.15;
            System.out.printf("Racing time ... %.2f hours\n", minuteRaced);

            if (iterationCounter % 4 == 1) {
                for (RaceCar raceCar : raceCars) {
                    if (!raceCar.isFinished()) {
                        double speed = raceCar.getAverageSpeed(); // in mph
                        double milesThisInterval = speed * 0.15; // 0.15 hours
                        raceCar.getOdometer().updateMiles(milesThisInterval);

                        if (raceCar.getOdometer().getMiles() >= 500) {
                            raceCar.setFinished(true);
                            displayRaceCar(raceCar);
                        }
                    }
                }

                // Check if the user car has finished
                if (!userCar.isFinished()) {
                    double userSpeed = userCar.getAverageSpeed();
                    double userMilesThisInterval = userSpeed * 0.15;
                    userCar.getOdometer().updateMiles(userMilesThisInterval);
                    System.out.println("Your car (" + userCar.getDriver() + ") is racing...");

                    if (userCar.getOdometer().getMiles() >= 500) {
                        userCar.setFinished(true);
                        displayRaceCar(userCar);
                    }
                }

                raceComplete = isRaceFinished(raceCars);
            }

            iterationCounter++;
        }

        // Determine if the user has won
        if (userCar.isFinished()) {
            System.out.println("\nCongratulations! You won the race!");
        } else {
            System.out.println("\nSorry, you lost the race.");
        }
    }

    public static boolean isRaceFinished(RaceCar[] raceCars) {
        for (RaceCar car : raceCars) {
            if (!car.isFinished()) {
                return false;
            }
        }
        return true;
    }

    public static void writeRaceCarDetailsToFile(RaceCar[] raceCars) throws IOException {
        File file = new File("RaceDetails.txt");
        PrintWriter resultsFile = new PrintWriter(file);

        resultsFile.println("Race Car Details\n");

        for (RaceCar car : raceCars) {
            resultsFile.println("Race Car #: " + car.getNumber());
            resultsFile.println("Driver:     " + car.getDriver());
            resultsFile.println("Miles:      " + car.getOdometer().getMiles());
            resultsFile.println();
        }

        resultsFile.close();
        System.out.println("\nFind the file here: " + file.getAbsolutePath() + "\n");
    }
}

class RaceCar {
    private String driver;
    private int number;
    private double averageSpeed;
    private boolean finished;
    private Odometer odometer;

    public RaceCar(String driver, int number, double averageSpeed) {
        this.driver = driver;
        this.number = number;
        this.averageSpeed = averageSpeed;
        this.finished = false;
        this.odometer = new Odometer();
    }

    public String getDriver() { return driver; }
    public int getNumber() { return number; }
    public double getAverageSpeed() { return averageSpeed; }
    public boolean isFinished() { return finished; }
    public void setFinished(boolean finished) { this.finished = finished; }
    public Odometer getOdometer() { return odometer; }
}

class Odometer {
    private double miles;

    public Odometer() {
        this.miles = 0.0;
    }

    public double getMiles() {
        return miles;
    }

    public void updateMiles(double milesTraveled) {
        this.miles += milesTraveled;
    }
}
