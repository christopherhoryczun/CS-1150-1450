package CS1450;

import java.io.File;
import java.util.*;

/*
 * Name: Christopher Horyczun
 * Class: CS1450 (M/W)
 * Due Date: October 29, 2025 (MW)
 * Assignment #7
 * Description: Ships move from the Atlantic through the canal’s (priority queue) ordered by classification.
 * Then pass through two transit queues that simulate travel through the canal. Finally, ships exit into the
 *  Pacific Ocean, demonstrating the use of both regular and priority queues within a class-based simulation.
*/

public class HoryczunChristopherAssignment7 {
    public static void main(String[] args) throws Exception {
    	
        // Scanner to read the ocean layout from the main file
        Scanner oceanFileScanner = new Scanner(new File("Ocean7.txt"));
        
        // Read Atlantic ocean info from file
        String atlanticOceanName = oceanFileScanner.nextLine().trim();
        int atlanticOceanRows = Integer.parseInt(oceanFileScanner.nextLine().trim());
        int atlanticOceanCols = Integer.parseInt(oceanFileScanner.nextLine().trim());

        // Loop through the rest of the file to read Pacific oceans
        while (oceanFileScanner.hasNextLine()) {
            String nextLine = oceanFileScanner.nextLine();
            
            // skip blank lines
            if (nextLine.trim().isEmpty()) continue; 

            String pacificOceanName = nextLine.trim();
            int pacificOceanRows = Integer.parseInt(oceanFileScanner.nextLine().trim());
            int pacificOceanCols = Integer.parseInt(oceanFileScanner.nextLine().trim());

            // Initialize both oceans
            Ocean7 pacificOcean = new Ocean7(pacificOceanName, pacificOceanRows, pacificOceanCols);
            Ocean7 atlanticOcean = new Ocean7(atlanticOceanName, atlanticOceanRows, atlanticOceanCols);

            // Load land positions into Atlantic ocean
            Scanner landFileScanner = new Scanner(new File("Land7.txt"));
            while (landFileScanner.hasNextLine()) {
                String landLine = landFileScanner.nextLine().trim();
                if (landLine.isEmpty()) continue;

                Scanner landLineScanner = new Scanner(landLine);
                if (landLineScanner.hasNextInt()) {
                    int landRow = landLineScanner.nextInt();
                    if (landLineScanner.hasNextInt()) {
                        int landCol = landLineScanner.nextInt();
                        // Only add land if coordinates are inside ocean grid
                        if (landRow >= 0 && landRow < atlanticOceanRows && landCol >= 0 && landCol < atlanticOceanCols) {
                            atlanticOcean.setElement(landRow, landCol, new Land7());
                        }
                    }
                }
                landLineScanner.close();
                
            }
            landFileScanner.close();

            // Load ships into Atlantic ocean
            Scanner shipsFileScanner = new Scanner(new File("Ships7.txt"));
            while (shipsFileScanner.hasNextLine()) {
                String shipLine = shipsFileScanner.nextLine().trim();
                if (shipLine.isEmpty()) continue;

                Scanner shipLineScanner = new Scanner(shipLine);
                int shipRow = shipLineScanner.nextInt();
                int shipCol = shipLineScanner.nextInt();
                int shipCapacity = shipLineScanner.nextInt();
                String shipClassification = shipLineScanner.next();

                StringBuilder shipNameBuilder = new StringBuilder();
                while (shipLineScanner.hasNext()) {
                    if (shipNameBuilder.length() > 0) shipNameBuilder.append(" ");
                    shipNameBuilder.append(shipLineScanner.next());
                }
                shipLineScanner.close();

                Ship7 ship = new Ship7(shipClassification, shipNameBuilder.toString(), shipCapacity);
                if (shipRow >= 0 && shipRow < atlanticOceanRows && shipCol >= 0 && shipCol < atlanticOceanCols) {
                    atlanticOcean.setElement(shipRow, shipCol, ship);
                }
            }
            shipsFileScanner.close();

            // Display initial Atlantic ocean grid
            System.out.println("Loading Atlantic ocean grid with land and ships...\n");
            atlanticOcean.printGrid();
            System.out.println("\n\n\t\t\t\t\t\tAssignment 7 starts here\n");

            Canal canalSystem = new Canal();
            ControlCenter controlCenter = new ControlCenter();

            // Move ships into canal channel
            System.out.println("\nController: Moving ships from Atlantic ocean to channel...\n");
            System.out.println("----------------------------------------------------------\n");
            controlCenter.moveShipsIntoChannel(atlanticOcean, canalSystem);

            // Move ships into the transit ways
            System.out.println("\nController: Moving ships waiting in the channel into transit ways...\n");
            System.out.println("----------------------------------------------------------\n");
            controlCenter.moveShipsIntoTransitWays(canalSystem);

            // Move ships from transit ways into Pacific ocean
            System.out.println("\nController: Moving ships from transit ways into Pacific Ocean...\n");
            System.out.println("----------------------------------------------------------\n");
            controlCenter.moveShipsIntoPacificOcean(pacificOcean, 8, 1, canalSystem);

            // Display final grids
            System.out.println("\nAtlantic Ocean after ships moved:\n");
            atlanticOcean.printGrid();
            System.out.println("\nPacific Ocean with ships:\n");
            pacificOcean.printGrid();

            oceanFileScanner.close();
            
            // exit after first Pacific ocean for now
            return;
        }
        oceanFileScanner.close();
    }//Main

}//Assignment 7

// Abstract class representing anything that can occupy the ocean grid
abstract class OceanElement7 {
    public abstract String display();
}

// Represents land in the ocean
class Land7 extends OceanElement7 {
    public String display() {
    	
    	// Simply display as "Land"
        return "Land"; 
    }
}

// Represents a ship with classification, name, and capacity
class Ship7 extends OceanElement7 implements Comparable<Ship7> {
    private String classification;
    private String name;
    private int capacity;

    public Ship7(String classification, String name, int capacity) {
        this.classification = classification;
        this.name = name;
        this.capacity = capacity;
    }

    public String getClassification() { return classification; }
    public String getName() { return name; }
    public int getCapacity() { return capacity; }
    public String display() { return name; }

    // Compare ships for priority in the channel (priority queue)
    @Override
    public int compareTo(Ship7 otherShip) {
        int thisShipRank = getClassificationRank(this.classification);
        int otherShipRank = getClassificationRank(otherShip.classification);

        if (thisShipRank != otherShipRank) return thisShipRank - otherShipRank;

        // If classification is same, compare by name
        int nameComparison = this.name.compareTo(otherShip.name);
        if (nameComparison != 0) return nameComparison;

        // If name is same, compare by capacity
        return this.capacity - otherShip.capacity;
    }

    // Assign a numeric rank for ship type to prioritize Navy -> Tanker -> Cargo -> Cruise
    private int getClassificationRank(String classes) {
    	// Simply display as "Land"
        if (classes == null) return 4; 
        switch (classes.trim().toLowerCase()) {
            case "navy":
            	return 0;
            case "tanker":
            	return 1;
            case "cargo":
            	return 2;
            case "cruise":
            	return 3;
            default:
            	return 4;
        }
    }

    // Format ship info for console output
    public String formattedForMove() {
        return String.format("%-7s %-18s %8d", capitalize(classification), name, capacity);
    }

    private String capitalize(String text) {
        if (text == null || text.isEmpty()) return text;
        return text.substring(0,1).toUpperCase() + text.substring(1);
    }
}

// Represents an ocean grid
class Ocean7 {
    private String oceanName;
    private int rows;
    private int cols;
    private OceanElement7[][] oceanGrid;

    public Ocean7(String oceanName, int rows, int cols) {
        this.oceanName = oceanName;
        this.rows = rows;
        this.cols = cols;
        this.oceanGrid = new OceanElement7[rows][cols];
    }

    public String getName() { return oceanName; }
    public int getRows() { return rows; }
    public int getCols() { return cols; }

    public OceanElement7 getElement(int row, int col) {
        if (row < 0 || row >= rows || col < 0 || col >= cols) return null;
        return oceanGrid[row][col];
    }

    public void setElement(int row, int col, OceanElement7 element) {
        if (row < 0 || row >= rows || col < 0 || col >= cols) return;
        oceanGrid[row][col] = element;
    }

    public void removeElement(int row, int col) {
        if (row < 0 || row >= rows || col < 0 || col >= cols) return;
        oceanGrid[row][col] = null;
    }

    // Print the entire ocean grid
    public void printGrid() {
        System.out.print("\t");
        for (int col = 0; col < cols; col++) {
            System.out.print("Column " + col + "\t");
        }
        System.out.print("\n\n");

        for (int row = 1; row < rows; row++) {
            System.out.print("\tRow " + row + "\t\t");
            for (int col = 1; col < cols; col++) {
                OceanElement7 element = oceanGrid[row][col];
                if (element == null) {
                    System.out.print("-------\t\t");
                } else if (element instanceof Land7) {
                    System.out.print("Land\t\t");
                } else if (element instanceof Ship7) {
                    System.out.print(((Ship7)element).getName() + "\t");
                } else {
                    System.out.print("-------\t");
                }
            }
            System.out.print("\n\n");
        }
    }
}

// Represents the canal system with a channel and two transit ways
class Canal {
	
	// Ships in channel prioritized by classification
    private PriorityQueue<Ship7> channel;
    
    // Transit way #1 for cruise ships
    private Queue<Ship7> transitWay1;
    
    // Transit way #2 for all other ships
    private Queue<Ship7> transitWay2;     

    public Canal() {
        channel = new PriorityQueue<>();
        transitWay1 = new LinkedList<>();
        transitWay2 = new LinkedList<>();
    }

    public boolean isChannelEmpty() { return channel.isEmpty(); }
    public void addShipToChannel(Ship7 ship) { channel.offer(ship); }
    public Ship7 removeShipFromChannel() { return channel.poll(); }

    public boolean isTransitWay1Empty() { return transitWay1.isEmpty(); }
    public void addShipToTransitWay1(Ship7 ship) { transitWay1.offer(ship); }
    public Ship7 removeShipFromTransitWay1() { return transitWay1.poll(); }

    public boolean isTransitWay2Empty() { return transitWay2.isEmpty(); }
    public void addShipToTransitWay2(Ship7 ship) { transitWay2.offer(ship); }
    public Ship7 removeShipFromTransitWay2() { return transitWay2.poll(); }
}

// Control center manages ship movement through canal system
class ControlCenter {

    // Move ships from transit ways into Pacific ocean starting at a given position
    public void moveShipsIntoPacificOcean(Ocean7 pacificOcean, int startRow, int startCol, Canal canal) {
        int currentRow = startRow;
        while (!canal.isTransitWay1Empty() || !canal.isTransitWay2Empty()) {

            // Move cruise ships from transit way 1
            if (!canal.isTransitWay1Empty()) {
                Ship7 ship = canal.removeShipFromTransitWay1();
                if (currentRow >= 0 && startCol >= 0 && startCol < pacificOcean.getCols() && currentRow < pacificOcean.getRows()) {
                    pacificOcean.setElement(currentRow, startCol, ship);
                }
                System.out.println("Moved into Pacific ocean: " + ship.formattedForMove());
                currentRow--;
            }

            // Move all other ships from transit way 2
            if (!canal.isTransitWay2Empty()) {
                Ship7 ship = canal.removeShipFromTransitWay2();
                if (currentRow >= 0 && startCol >= 0 && startCol < pacificOcean.getCols() && currentRow < pacificOcean.getRows()) {
                    pacificOcean.setElement(currentRow, startCol, ship);
                }
                System.out.println("Moved into Pacific ocean: " + ship.formattedForMove());
                currentRow--;
            }
        }
    }

    // Move ships from Atlantic ocean into the canal channel
    public void moveShipsIntoChannel(Ocean7 atlanticOcean, Canal canal) {
        for (int row = atlanticOcean.getRows() - 1; row >= 0; row--) {
            for (int col = atlanticOcean.getCols() - 1; col >= 0; col--) {
                OceanElement7 element = atlanticOcean.getElement(row, col);
                if (element != null && element instanceof Ship7) {
                    Ship7 ship = (Ship7) element;
                    canal.addShipToChannel(ship);
                    System.out.println("Moved to channel: " + ship.formattedForMove());
                    atlanticOcean.removeElement(row, col);
                }
            }
        }
    }

    // Move ships from channel into the appropriate transit ways
    public void moveShipsIntoTransitWays(Canal canal) {
        while (!canal.isChannelEmpty()) {
            Ship7 ship = canal.removeShipFromChannel();
            if (ship == null) break;

            String classification = ship.getClassification().trim().toLowerCase();
            if (classification.equals("cruise")) {
                canal.addShipToTransitWay1(ship);
                System.out.println("Moved into transit way #1: " + ship.formattedForMove());
            } else {
                canal.addShipToTransitWay2(ship);
                System.out.println("Moved into transit way #2: " + ship.formattedForMove());
            }
        }
    }
}
