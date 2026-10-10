package CS1450;


import java.io.*;
import java.util.*;

public class HoryczunChristopherAssignment7 {

    public static void main(String[] args) throws IOException {

        // file names
        final String PLANES_FILE = "FedExPlanes7.txt";
        final String TRUCKS_FILE = "FedExTrucks7.txt";

        // scanners to read files
        Scanner planeFile = new Scanner(new File(PLANES_FILE));
        Scanner truckFile = new Scanner(new File(TRUCKS_FILE));

        // first numbers tell us how big arrays should be
        int stands = planeFile.nextInt();
        int docks = truckFile.nextInt();

        // create terminal with correct sizes
        CargoTerminal7 terminal = new CargoTerminal7(docks, stands);

        System.out.println("Loading semi-trucks and planes into cargo terminal...\n");

        // read each truck and place it into correct dock
        while (truckFile.hasNext()) {
            int dock = truckFile.nextInt();
            int truckNum = truckFile.nextInt();
            String city = truckFile.nextLine().trim();

            terminal.addSemiTruck(dock, new SemiTruck7(truckNum, city));
        }

        // read each plane and place it into correct stand
        while (planeFile.hasNext()) {
            int stand = planeFile.nextInt();
            int flight = planeFile.nextInt();
            double capacity = planeFile.nextDouble();
            String cargo = planeFile.next();
            String city = planeFile.nextLine().trim();

            terminal.addCargoPlane(stand, new CargoPlane7(flight, capacity, cargo, city));
        }

        // always close files after use
        planeFile.close();
        truckFile.close();

        // show initial setup (same as assignment 4)
        terminal.displayCargoTerminal();

        Taxiways taxiways = new Taxiways();
        Runway runway = new Runway();
        AirTrafficController controller = new AirTrafficController();

        // move planes from tarmac to taxiways
        System.out.println("\nControl Tower: Moving planes from cargo terminal tarmac to taxiways:");
        System.out.println("---------------------------------------------------------------------------------");
        controller.movePlanesToTaxiways(terminal, taxiways);

        // show that tarmac is now empty
        System.out.println("\nShow empty tarmac in cargo terminal...");
        terminal.displayCargoTerminal();

        // move planes from taxiways to runway
        System.out.println("\nControl Tower: Moving cargo planes from taxiways to runway");
        System.out.println("--------------------------------------------------------------------");
        controller.movePlanesToRunway(taxiways, runway);

        // simulate takeoff
        System.out.println("\nControl Tower: Ready for takeoff!");
        System.out.println("--------------------------------------------------------------------");
        controller.clearedForTakeoff(runway);

        // final check
        System.out.println("\nIs runway empty? " + runway.isEmpty());
    }
}

class CargoTerminal7 {

    private SemiTruck7[] docks;
    private CargoPlane7[] tarmac;

    public CargoTerminal7(int numDocks, int numStands) {
        // create arrays based on file input
        docks = new SemiTruck7[numDocks];
        tarmac = new CargoPlane7[numStands];
    }

    public int getNumberStands() {
        return tarmac.length;
    }

    // place truck into correct dock
    public void addSemiTruck(int dock, SemiTruck7 truck) {
        docks[dock] = truck;
    }

    // place plane into correct stand
    public void addCargoPlane(int stand, CargoPlane7 plane) {
        tarmac[stand] = plane;
    }

    // remove plane from tarmac (used when moving planes)
    public CargoPlane7 removeCargoPlane(int stand) {
        CargoPlane7 temp = tarmac[stand];
        tarmac[stand] = null; // clear spot after removing
        return temp;
    }

    // displays layout of docks and stands
    public void displayCargoTerminal() {

        // print dock labels
        for (int i = 0; i < docks.length; i++) {
            System.out.print("Dock " + i + "\t");
        }
        System.out.println();

        // print truck numbers or empty slots
        for (int i = 0; i < docks.length; i++) {
            if (docks[i] != null)
                System.out.print(docks[i].getTruckNumber() + "\t");
            else
                System.out.print("------\t");
        }

        System.out.println("\n");

        // print stand labels
        for (int i = 0; i < tarmac.length; i++) {
            System.out.print("Stand " + i + "\t");
        }
        System.out.println();

        // print plane numbers or empty
        for (int i = 0; i < tarmac.length; i++) {
            if (tarmac[i] != null)
                System.out.print(tarmac[i].getFlightNumber() + "\t");
            else
                System.out.print("------\t");
        }

        System.out.println("\n");
    }
}

class CargoPlane7 implements Comparable<CargoPlane7> {

    private int flight;
    private double capacity;
    private String cargoType;
    private String city;

    public CargoPlane7(int f, double c, String type, String city) {
        this.flight = f;
        this.capacity = c;
        this.cargoType = type;
        this.city = city;
    }

    public int getFlightNumber() {
        return flight;
    }

    public String getCity() {
        return city;
    }

    public String getCargoType() {
        return cargoType;
    }

    // checks if plane belongs in priority queue
    public boolean isPriority() {
        return cargoType.equalsIgnoreCase("Military") ||
               cargoType.equalsIgnoreCase("Perishables") ||
               cargoType.equalsIgnoreCase("Medical");
    }

    // everything else is basic
    public boolean isBasic() {
        return !isPriority();
    }

    // determines order inside priority queue
    @Override
    public int compareTo(CargoPlane7 other) {
        return getPriority(this.cargoType) - getPriority(other.cargoType);
    }

    // manual priority ranking (NOT alphabetical)
    private int getPriority(String type) {
        if (type.equalsIgnoreCase("Military")) return 1;
        if (type.equalsIgnoreCase("Perishables")) return 2;
        if (type.equalsIgnoreCase("Medical")) return 3;
        return 4; // non-priority
    }

    @Override
    public String toString() {
        return flight + "\t" + city + "\t" + cargoType;
    }
}

class SemiTruck7 {

    private int number;
    private String city;

    public SemiTruck7(int n, String c) {
        number = n;
        city = c;
    }

    public int getTruckNumber() {
        return number;
    }
}

class Taxiways {

    // priority queue (orders automatically using compareTo)
    private PriorityQueue<CargoPlane7> priorityTaxiway;

    // regular queue (FIFO)
    private Queue<CargoPlane7> basicTaxiway;

    public Taxiways() {
        priorityTaxiway = new PriorityQueue<>();
        basicTaxiway = new LinkedList<>();
    }

    public void addPriority(CargoPlane7 plane) {
        priorityTaxiway.offer(plane);
    }

    public void addBasic(CargoPlane7 plane) {
        basicTaxiway.offer(plane);
    }

    public boolean isPriorityEmpty() {
        return priorityTaxiway.isEmpty();
    }

    public boolean isBasicEmpty() {
        return basicTaxiway.isEmpty();
    }

    public CargoPlane7 removePriority() {
        return priorityTaxiway.poll();
    }

    public CargoPlane7 removeBasic() {
        return basicTaxiway.poll();
    }
}

class Runway {

    private Queue<CargoPlane7> runway;

    public Runway() {
        runway = new LinkedList<>();
    }

    public void add(CargoPlane7 plane) {
        runway.offer(plane);
    }

    public CargoPlane7 remove() {
        return runway.poll();
    }

    public boolean isEmpty() {
        return runway.isEmpty();
    }
}

class AirTrafficController {

    /*
     Pseudocode (like design notebook):

     for each stand:
        remove plane
        if priority -> priority queue
        else -> basic queue
        print message
    */

    // move planes from tarmac → taxiways
    public void movePlanesToTaxiways(CargoTerminal7 terminal, Taxiways taxiways) {

        for (int i = 0; i < terminal.getNumberStands(); i++) {

            CargoPlane7 plane = terminal.removeCargoPlane(i);

            // skip empty stands
            if (plane != null) {

                // decide which taxiway it goes to
                if (plane.isPriority()) {
                    taxiways.addPriority(plane);

                    System.out.println("Moved to taxiway Priority flight " +
                            plane.getFlightNumber() + "\t" +
                            plane.getCity() + "\t" +
                            plane.getCargoType());
                } else {
                    taxiways.addBasic(plane);

                    System.out.println("Moved to taxiway Basic flight " +
                            plane.getFlightNumber() + "\t" +
                            plane.getCity() + "\t" +
                            plane.getCargoType());
                }
            }
        }
    }

    // move planes from taxiways → runway
    public void movePlanesToRunway(Taxiways taxiways, Runway runway) {

        // priority planes go first
        while (!taxiways.isPriorityEmpty()) {
            CargoPlane7 plane = taxiways.removePriority();
            runway.add(plane);

            System.out.println("Moved to runway flight " +
                    plane.getFlightNumber() + "\t" +
                    plane.getCity() + "\t" +
                    plane.getCargoType());
        }

        // then basic planes
        while (!taxiways.isBasicEmpty()) {
            CargoPlane7 plane = taxiways.removeBasic();
            runway.add(plane);

            System.out.println("Moved to runway flight " +
                    plane.getFlightNumber() + "\t" +
                    plane.getCity() + "\t" +
                    plane.getCargoType());
        }
    }

    // simulate planes taking off
    public void clearedForTakeoff(Runway runway) {

        while (!runway.isEmpty()) {
            CargoPlane7 plane = runway.remove();

            System.out.println("Cleared for takeoff flight " +
                    plane.getFlightNumber() + "\t" +
                    plane.getCity() + "\t" +
                    plane.getCargoType());
        }
    }
}