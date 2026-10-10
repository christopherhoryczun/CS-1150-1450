package CS1450;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.PriorityQueue;
import java.util.Scanner;

/*
 * Name: Christopher Horyczun
 * Class: CS1450 (M/W)
 * Due Date: November 13, 2025 (MW)
 * Assignment #9
 * Description: In this assignment, you will create and manipulate your own singly and doubly linked lists in
 * Java to manage Airbnb data. The program reads listings from a file, stores them in both linked lists, and 
 * displays them in different orders. It also searches for Airbnbs that meet specific requirements and removes
 * certain types from the list. This project helps you practice data structures, object-oriented programming,
 * and file handling. 
*/

public class HoryczunChristopherAssignment9 {

    public static void main(String[] args) {

        // Step 1: Create linked lists
        AirbnbLinkedList singleList = new AirbnbLinkedList();
        DoubleLinkedList doubleList = new DoubleLinkedList();

        // Step 2: Read Airbnb data from file
        try (Scanner scanner1 = new Scanner(new File("Airbnbs.txt"))) {
            while (scanner1.hasNextLine()) {
                String line = scanner1.nextLine().trim();
                if (line.isEmpty()) continue;

                Scanner lineScanner = new Scanner(line);
                int rate = lineScanner.nextInt();
                int guests = lineScanner.nextInt();
                int bedrooms = lineScanner.nextInt();
                String type = lineScanner.nextLine().trim();
                lineScanner.close();

                Airbnb a = new Airbnb(rate, guests, bedrooms, type);
                singleList.addByRate(a);
                doubleList.addToEnd(a);
            }
            
        } catch (FileNotFoundException e) {
            System.out.println("Error: Airbnbs.txt not found.");
            return;
            
        }

        // Step 3: Display both lists
        System.out.println("Airbnbs in Single Linked List - Ordered by Nightly Rate\n");
        singleList.display();

        System.out.println("\nAirbnbs in Doubly Linked List - Airbnbs Printed Backwards\n");
        doubleList.displayBackwards();

        // Step 4: Read requirements and find matching Airbnbs
        int reqRate = 0;
        int reqGuests = 0;
        String reqType = "";

        try (Scanner scanner2 = new Scanner(new File("AirbnbRequirements.txt"))) {
            if (scanner2.hasNextLine()) {
            	
                String[] parts = scanner2.nextLine().trim().split(" ", 3);
                reqRate = Integer.parseInt(parts[0]);
                reqGuests = Integer.parseInt(parts[1]);
                reqType = parts[2];
            }
        } catch (FileNotFoundException e) {
            System.err.println("Error: AirbnbRequirements.txt not found.");
            return;
        }

        System.out.println("\nAirbnbs in Priority Queue Meeting Parrot Requirements: $" + reqRate + " a night or less, " + reqGuests + "+ guests, and " + reqType + ")\n");

        PriorityQueue<Airbnb> pq = singleList.findAirbnbs(reqRate, reqGuests, reqType);
        if (pq.isEmpty()) {
            System.out.println("No matching Airbnbs found.");
            
        } else {
            System.out.println(Airbnb.headerLine());
            while (!pq.isEmpty()) {
                System.out.println(pq.poll());
            }
        }

        // Step 5: Remove Condos and Townhomes
        int condosRemoved = singleList.removeSpecificType("Condo");
        int townhomesRemoved = singleList.removeSpecificType("Townhome");

        // Step 6: Display results
        System.out.println("\nAirbnbs in Single Linked List - Condos and Townhomes Removed");
        System.out.println("Number condos removed: " + condosRemoved);
        System.out.println("Number townhomes removed: " + townhomesRemoved + "\n");
        singleList.display();

    }//Main
    
}//Assignment 9

//Airbnb Class
class Airbnb implements Comparable<Airbnb> {
	
    private int nightlyRate;
    private int numGuests;
    private int numBedrooms;
    private String type;
    
    public Airbnb(int nightlyRate, int numGuests, int numBedrooms, String type) {
        this.nightlyRate = nightlyRate;
        this.numGuests = numGuests;
        this.numBedrooms = numBedrooms;
        this.type = type;
    }

    // Getters
    public int getNightlyRate() { return nightlyRate; }
    public int getNumGuests() { return numGuests; }
    public int getNumBedrooms() { return numBedrooms; }
    public String getType() { return type; }

    public static String headerLine() {
        return String.format("%-22s\t%-12s\t%-6s\t%-8s",
                "Airbnb Type", "Nightly Rate", "Guests", "Bedrooms") +
                "\n--------------------------------------------------------------";
    }

    public String toString() {
        return String.format("%-22s\t$%d\t\t%d\t\t%d",
                type, nightlyRate, numGuests, numBedrooms);
    }

    public int compareTo(Airbnb other) {
        if (this.nightlyRate < other.nightlyRate) return -1;
        else if (this.nightlyRate > other.nightlyRate) return 1;
        else return 0;
    }
}

//AirbnbLinkedList (Singly Linked)
class AirbnbLinkedList {
	
	//first node
    private Node head;

    // Inner Node class (no generics, custom-made)
    private static class Node {
        Airbnb airbnb;
        Node next;
        Node(Airbnb a) {
            airbnb = a;
            next = null;
        }
    }

    public AirbnbLinkedList() {
        head = null;
    }

    // Add Airbnb in sorted order (by nightly rate)
    public void addByRate(Airbnb a) {
        Node newNode = new Node(a);
        if (head == null || a.compareTo(head.airbnb) <= 0) {
            newNode.next = head;
            head = newNode;
            return;
        }
        Node current = head;
        while (current.next != null && a.compareTo(current.next.airbnb) > 0) {
            current = current.next;
        }
        newNode.next = current.next;
        current.next = newNode;
    }

    // Find Airbnbs meeting criteria
    public PriorityQueue<Airbnb> findAirbnbs(int rate, int guests, String type) {
        PriorityQueue<Airbnb> pq = new PriorityQueue<>();
        Node current = head;
        while (current != null) {
            Airbnb a = current.airbnb;
            if (a.getNightlyRate() <= rate &&
                a.getNumGuests() >= guests &&
                a.getType().equalsIgnoreCase(type)) {
                pq.add(a);
            }
            current = current.next;
        }
        return pq;
    }

    // Remove all Airbnbs of a specific type
    public int removeSpecificType(String type) {
        int count = 0;
        while (head != null && head.airbnb.getType().equalsIgnoreCase(type)) {
            head = head.next;
            count++;
        }
        Node current = head;
        while (current != null && current.next != null) {
            if (current.next.airbnb.getType().equalsIgnoreCase(type)) {
                current.next = current.next.next;
                count++;
            } else {
                current = current.next;
            }
        }
        return count;
    }

    // Display list (head → tail)
    public void display() {
        System.out.println(Airbnb.headerLine());
        Node current = head;
        while (current != null) {
            System.out.println(current.airbnb);
            current = current.next;
        }
    }
}
//DoubleLinkedList (Doubly Linked)
class DoubleLinkedList {
    private Node head;
    private Node tail;

    private static class Node {
        Airbnb airbnb;
        Node previous;
        Node next;
        Node(Airbnb a) {
            airbnb = a;
            previous = null;
            next = null;
        }
    }

    public DoubleLinkedList() {
        head = null;
        tail = null;
    }

    // Add Airbnb to the end
    public void addToEnd(Airbnb a) {
        Node newNode = new Node(a);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.previous = tail;
            tail = newNode;
        }
    }

    // Display backwards (tail → head)
    public void displayBackwards() {
        System.out.println(Airbnb.headerLine());
        Node current = tail;
        while (current != null) {
            System.out.println(current.airbnb);
            current = current.previous;
        }
    }
}

