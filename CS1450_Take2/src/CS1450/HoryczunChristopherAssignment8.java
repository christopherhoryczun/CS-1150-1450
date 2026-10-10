package CS1450;

import java.io.*;
import java.util.*;

/*
 * Name: Christopher Horyczun
 * Class Name: CS1450 (M/W)
 * Due Date: April 8th, 2026
 * Assignment #8
 * Description: This program uses a 2D array, ArrayList, Queue, and Iterator objects to decode two secret messages from files.
 */


public class HoryczunChristopherAssignment8 {

    public static void main(String[] args) throws IOException {

        // Open the three required files.
        Scanner keyFile = new Scanner(new File("KeyGrid.txt"));
        Scanner messageFile1 = new Scanner(new File("Message1.txt"));
        Scanner messageFile2 = new Scanner(new File("Message2.txt"));

        // Read the size of the key grid from the file.
        int numRows = keyFile.nextInt();
        int numCols = keyFile.nextInt();
        //clear the leftover newline after reading the integers
        keyFile.nextLine();

        // Create the decoding machine using the grid size read from the file.
        DecodingMachine decoder = new DecodingMachine(numRows, numCols);

        // Store every character from the key file into an ArrayList.
        ArrayList<Character> keyCharacters = new ArrayList<Character>();

        while (keyFile.hasNextLine()) {
            String line = keyFile.nextLine();

            // Each remaining line contains a single character.
            keyCharacters.add(line.charAt(0));
        }

        // Create an iterator for the ArrayList and use it to fill the key grid.
        Iterator<Character> keyIterator = keyCharacters.iterator();
        decoder.fillKeyGrid(keyIterator);

        // Print the key grid so we can verify it loaded correctly.
        System.out.println("Decoding Machine's Key Grid");
        System.out.println("---------------------------");
        decoder.printKeyGrid();
        System.out.println();

        // Create the two queues that hold the encoded messages.
        Queue<KeyGridElement> queue1 = new LinkedList<KeyGridElement>();
        Queue<KeyGridElement> queue2 = new LinkedList<KeyGridElement>();

        // Fill each queue with KeyGridElement objects from the message files.
        fillQueue(queue1, messageFile1);
        fillQueue(queue2, messageFile2);

        // Create iterators for each queue.
        Iterator<KeyGridElement> messageIterator1 = queue1.iterator();
        Iterator<KeyGridElement> messageIterator2 = queue2.iterator();

        // Decode and display the first secret message.
        Iterator<Character> decodedMessage1 = decoder.decodeMessage(messageIterator1);
        System.out.println("1st Secret Decoded Message");
        System.out.println("--------------------------------------------------------------------");
        printDecodedMessage(decodedMessage1);
        System.out.println();
        System.out.println();

        // Decode and display the second secret message.
        Iterator<Character> decodedMessage2 = decoder.decodeMessage(messageIterator2);
        System.out.println("2nd Secret Decoded Message");
        System.out.println("--------------------------------------------------------------------");
        printDecodedMessage(decodedMessage2);
        System.out.println();

        // Close all files.
        keyFile.close();
        messageFile1.close();
        messageFile2.close();
    }
    
    //Reads pairs of integers from a file and places them into a queueas KeyGridElement objects.
    public static void fillQueue(Queue<KeyGridElement> aQueue, Scanner messageFile) {

        while (messageFile.hasNextInt()) {
            int row = messageFile.nextInt();
            int column = messageFile.nextInt();

            KeyGridElement element = new KeyGridElement(row, column);
            aQueue.offer(element);
        }
    }
    
    //Prints all characters from an iterator on one line.
    public static void printDecodedMessage(Iterator<Character> messageIterator) {

        while (messageIterator.hasNext()) {
            System.out.print(messageIterator.next());
        }
    }
}

//Represents one (row, column) location in the key grid.
class KeyGridElement {

    private int row;
    private int column;

    public KeyGridElement(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }
}


//Stores the 2D key grid and handles decoding messages.
class DecodingMachine {

    private char[][] keyGrid;
    private int numRows;
    private int numCols;

    public DecodingMachine(int numRows, int numCols) {
        this.numRows = numRows;
        this.numCols = numCols;
        keyGrid = new char[numRows][numCols];
    }
    
    //Fills the key grid row by row using characters from the iterator.
    public void fillKeyGrid(Iterator<Character> charIterator) {

        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col < numCols; col++) {
                keyGrid[row][col] = charIterator.next();
            }
        }
    }
    public Iterator<Character> decodeMessage(Iterator<KeyGridElement> msgIterator) {

        ArrayList<Character> secretMessage = new ArrayList<Character>();

        while (msgIterator.hasNext()) {
            KeyGridElement location = msgIterator.next();
            int row = location.getRow();
            int column = location.getColumn();

            char decodedCharacter = keyGrid[row][column];
            secretMessage.add(decodedCharacter);
        }

        return secretMessage.iterator();
    }
    
    //Prints the key grid one row at a time.
    public void printKeyGrid() {

        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col < numCols; col++) {
                System.out.print(keyGrid[row][col] + " ");
            }
            System.out.println();
        }
    }
}
