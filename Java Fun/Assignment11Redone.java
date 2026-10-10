import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class HoryczunChristopherAssignment11 {

    public static void main(String[] args) throws IOException {
        RaceCar[] raceCars = {
            new RaceCar("Shrek", 8, 80),
            new RaceCar("Fiona", 11, 115),
            new RaceCar("Donkey", 17, 70),
            new RaceCar("Dragon", 18, 100),
            new RaceCar("Pinocchio", 45, 85),
            new RaceCar("Farquaad", 42, 75),
        };

        // Display and run simulation
        displayAllRaceCars(raceCars);
        raceSimulation(raceCars);

        // Output to file
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

    public static void raceSimulation(RaceCar[] raceCars) {
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

                raceComplete = isRaceFinished(raceCars);
            }

            iterationCounter++;
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
        File file = new File("Assignment11.txt");
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
