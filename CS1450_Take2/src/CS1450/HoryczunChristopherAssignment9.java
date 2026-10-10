package CS1450;

import java.io.*;
import java.util.*;

/*
 * Name: Christopher Horyczun
 * Class Name: CS1450 (M/W)
 * Due Date: April 14th, 2026
 * Assignment #9
 * Description: The goal of this assignment is to use linked lists to simulate a train moving between cities by loading railcars from a file, sorting them by destination, and removing them at each stop.
 */

public class HoryczunChristopherAssignment9 {

    // Front of train -> back of train
    private static final String[] ROUTE_ORDER = {
        "West Palm Beach",
        "Orlando",
        "Charleston",
        "Washington DC"
    };

    public static void main(String[] args) throws IOException {

        TrainLinkedList train = new TrainLinkedList();
        DoubleLinkedList doubleList = new DoubleLinkedList();

        File inputFile = new File("Railcars.txt");
        Scanner fileInput = new Scanner(inputFile);

        // Read every railcar from the file
        while (fileInput.hasNext()) {
            int number = fileInput.nextInt();
            String freight = fileInput.next();
            String destination = fileInput.nextLine().trim();

            RailCar railCar = new RailCar(number, freight, destination);

            train.addByDestination(railCar);
            doubleList.addToEnd(railCar);
        }

        fileInput.close();

        System.out.println("Train departs from New York");
        System.out.println();
        train.displayTrain();

        System.out.println();
        System.out.println("Stop 1: Train Arrives in Washington DC");
        int removedWashington = train.removeByDestination("Washington DC");
        System.out.println("Removed " + removedWashington + " Washington DC rail cars");
        System.out.println();
        train.displayTrain();

        System.out.println();
        System.out.println("Stop 2: Train Arrives in Charleston");
        int removedCharleston = train.removeByDestination("Charleston");
        System.out.println("Removed " + removedCharleston + " Charleston rail cars");
        System.out.println();
        train.displayTrain();

        System.out.println();
        System.out.println("Stop 3: Train Arrives in Orlando");
        int removedOrlando = train.removeByDestination("Orlando");
        System.out.println("Removed " + removedOrlando + " Orlando rail cars");

        int removedParrots = train.removeByFreight("parrots");
        System.out.println("Removed " + removedParrots + " rail cars with parrots");
        System.out.println();
        train.displayTrain();

        System.out.println();
        System.out.println("Stop 4: Train Arrives in West Palm Beach");
        int removedWestPalm = train.removeByDestination("West Palm Beach");
        System.out.println("Removed " + removedWestPalm + " West Palm Beach rail cars - train should be empty!");
        System.out.println();
        train.displayTrain();

        System.out.println();
        System.out.println("Rail Cars in Doubly Linked List - Printed Backwards");
        System.out.println();
        doubleList.displayBackwards();
    }

    // Shared helper method for route position
    public static int getRouteIndex(String destination) {
        for (int i = 0; i < ROUTE_ORDER.length; i++) {
            if (ROUTE_ORDER[i].equals(destination)) {
                return i;
            }
        }
        return -1;
    }
}

// Represents one rail car
class RailCar implements Comparable<RailCar> {

    private int number;
    private String freight;
    private String destination;

    public RailCar(int number, String freight, String destination) {
        this.number = number;
        this.freight = freight;
        this.destination = destination;
    }

    public String getFreight() {
        return freight;
    }

    public String getDestination() {
        return destination;
    }

    @Override
    public int compareTo(RailCar otherRailCar) {
        int thisIndex = HoryczunChristopherAssignment9.getRouteIndex(this.destination);
        int otherIndex = HoryczunChristopherAssignment9.getRouteIndex(otherRailCar.destination);

        if (thisIndex == otherIndex) {
            return 0;
        }

        // Lower index means closer to front of train
        if (thisIndex < otherIndex) {
            return 1;
        } else {
            return -1;
        }
    }

    @Override
    public String toString() {
        return String.format("%-10d\t%-10s\t%s", number, freight, destination);
    }
}

// Singly linked list
class TrainLinkedList {

    private Node head;

    public void addByDestination(RailCar railCarToAdd) {
        Node newNode = new Node(railCarToAdd);

        if (head == null) {
            head = newNode;
            return;
        }

        Node current = head;
        Node previous = null;

        while (current != null && railCarToAdd.compareTo(current.railCar) != 1) {
            previous = current;
            current = current.next;
        }

        if (previous == null) {
            newNode.next = head;
            head = newNode;
        } else {
            previous.next = newNode;
            newNode.next = current;
        }
    }

    public int removeByDestination(String destination) {
        int count = 0;

        while (head != null && head.railCar.getDestination().equals(destination)) {
            head = head.next;
            count++;
        }

        Node current = head;

        while (current != null && current.next != null) {
            if (current.next.railCar.getDestination().equals(destination)) {
                current.next = current.next.next;
                count++;
            } else {
                current = current.next;
            }
        }

        return count;
    }

    public int removeByFreight(String freight) {
        int count = 0;

        while (head != null && head.railCar.getFreight().equalsIgnoreCase(freight)) {
            head = head.next;
            count++;
        }

        Node current = head;

        while (current != null && current.next != null) {
            if (current.next.railCar.getFreight().equalsIgnoreCase(freight)) {
                current.next = current.next.next;
                count++;
            } else {
                current = current.next;
            }
        }

        return count;
    }

    public void displayTrain() {
        System.out.println("RailCar#\tFreight\t\tDestination City");
        System.out.println("----------------------------------------------------------------");

        if (head == null) {
            System.out.println("No rail cars! Empty list as expected!");
            return;
        }

        Node current = head;
        while (current != null) {
            System.out.println(current.railCar);
            current = current.next;
        }
    }

    private static class Node {
        private RailCar railCar;
        private Node next;

        public Node(RailCar railCar) {
            this.railCar = railCar;
            this.next = null;
        }
    }
}

// Doubly linked list
class DoubleLinkedList {

    private Node head;
    private Node tail;

    public void addToEnd(RailCar railCarToAdd) {
        Node newNode = new Node(railCarToAdd);

        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.previous = tail;
            tail = newNode;
        }
    }

    public void displayBackwards() {
        System.out.println("RailCar#\tFreight\t\tDestination City");
        System.out.println("----------------------------------------------------------------");

        Node current = tail;
        while (current != null) {
            System.out.println(current.railCar);
            current = current.previous;
        }
    }

    private static class Node {
        private RailCar railCar;
        private Node previous;
        private Node next;

        public Node(RailCar railCar) {
            this.railCar = railCar;
            this.previous = null;
            this.next = null;
        }
    }
}
