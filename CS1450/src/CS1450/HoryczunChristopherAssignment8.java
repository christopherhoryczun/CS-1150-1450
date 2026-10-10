package CS1450;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/*
 * Name: Christopher Horyczun
 * Class: CS1450 (M/W)
 * Due Date: November 5, 2025 (MW)
 * Assignment #8
 * Description: The program decodes two secret messages that have been scrambled into parts and stored in text files.
 * It uses ArrayLists, Queues, a custom Stack, and Iterators to rebuild each message. 
*/

public class HoryczunChristopherAssignment8 {

    public static void main(String[] args) throws FileNotFoundException {

        // These ArrayLists will store characters, ASCII values, and keys from the first set of files.
        ArrayList<Character> arrayMessageCharacters = new ArrayList<>();
        ArrayList<Integer> arrayMessageAsciiCodes = new ArrayList<>();
        ArrayList<Integer> arrayMessageKeyValues = new ArrayList<>();

        // Read characters from ArrayPart1.txt (each char from the line gets added to the list)
        Scanner arrayPart1Reader = new Scanner(new File("ArrayPart1.txt"));
        String arrayCharacterLine = arrayPart1Reader.nextLine();
        for (char currentCharacter : arrayCharacterLine.toCharArray()) {
            arrayMessageCharacters.add(currentCharacter);
        }
        
        arrayPart1Reader.close();

        // Read ASCII numbers from ArrayPart2.txt
        // Each number represents a character, so we’ll convert later when decoding.
        Scanner arrayPart2Reader = new Scanner(new File("ArrayPart2.txt"));
        while (arrayPart2Reader.hasNextInt()) {
            arrayMessageAsciiCodes.add(arrayPart2Reader.nextInt());
        }
        
        arrayPart2Reader.close();

        // Read decoding keys (0’s and 1’s) from ArrayKey.txt
        // These tell us which list to pull characters from.
        Scanner arrayKeyReader = new Scanner(new File("ArrayKey.txt"));
        while (arrayKeyReader.hasNextInt()) {
            arrayMessageKeyValues.add(arrayKeyReader.nextInt());
        }
        
        arrayKeyReader.close();

        // Create iterators for each ArrayList after we’ve filled them up
        Iterator<Character> arrayCharacterIterator = arrayMessageCharacters.iterator();
        Iterator<Integer> arrayAsciiIterator = arrayMessageAsciiCodes.iterator();
        Iterator<Integer> arrayKeyIterator = arrayMessageKeyValues.iterator();

        // Create one Translator object to handle decoding both messages
        Translator parrotTranslator = new Translator();

        // Decode the first secret message using ArrayLists
        String firstDecodedMessage = parrotTranslator.translate(
                arrayCharacterIterator, arrayAsciiIterator, arrayKeyIterator);

        System.out.println("The secret string is: " + firstDecodedMessage);

        // Now we’ll do the same thing again but with Queues for the second secret message.
        Queue<Character> queueMessageCharacters = new LinkedList<>();
        Queue<Integer> queueMessageAsciiCodes = new LinkedList<>();
        Queue<Integer> queueMessageKeyValues = new LinkedList<>();

        // Read characters from QueuePart1.txt
        Scanner queuePart1Reader = new Scanner(new File("QueuePart1.txt"));
        String queueCharacterLine = queuePart1Reader.nextLine();
        for (char currentCharacter : queueCharacterLine.toCharArray()) {
            queueMessageCharacters.add(currentCharacter);
        }
        
        queuePart1Reader.close();

        // Read ASCII codes from QueuePart2.txt
        Scanner queuePart2Reader = new Scanner(new File("QueuePart2.txt"));
        while (queuePart2Reader.hasNextInt()) {
            queueMessageAsciiCodes.add(queuePart2Reader.nextInt());
        }
        
        queuePart2Reader.close();

        // Read keys from QueueKey.txt
        Scanner queueKeyReader = new Scanner(new File("QueueKey.txt"));
        while (queueKeyReader.hasNextInt()) {
            queueMessageKeyValues.add(queueKeyReader.nextInt());
        }
        
        queueKeyReader.close();

        // Create iterators for each Queue
        Iterator<Character> queueCharacterIterator = queueMessageCharacters.iterator();
        Iterator<Integer> queueAsciiIterator = queueMessageAsciiCodes.iterator();
        Iterator<Integer> queueKeyIterator = queueMessageKeyValues.iterator();

        // Use the same Translator object to decode the second message
        String secondDecodedMessage = parrotTranslator.translate(
                queueCharacterIterator, queueAsciiIterator, queueKeyIterator);

        System.out.println("The 2nd secret string is: " + secondDecodedMessage);
        
    }//Main
    
}//Assignment 8

class Translator {

    // The stack used during translation. Assignment requires this variable name (aStack).
    private DecodingStack aStack;

    // Constructor – creates the decoding stack we’ll use for both messages.
    public Translator() {
        aStack = new DecodingStack();
    }

    // This method takes in three iterators and rebuilds the original message.
    public String translate(Iterator<Character> part1Iterator,
                            Iterator<Integer> part2Iterator,
                            Iterator<Integer> keyIterator) {

        // If key = 0 → grab from characters list. If key = 1 → grab from ASCII list.
        while (keyIterator.hasNext()) {
            int currentKey = keyIterator.next();

            if (currentKey == 0 && part1Iterator.hasNext()) {
                aStack.push(part1Iterator.next());
            } else if (currentKey == 1 && part2Iterator.hasNext()) {
                int asciiCode = part2Iterator.next();
                aStack.push((char) asciiCode);
                
            }//end of else
            
        }//end of while

        // Step 2: Undo the reversal by popping everything off the stack.
        StringBuilder decodedMessage = new StringBuilder();
        while (!aStack.isEmpty()) {
            decodedMessage.append(aStack.pop());
        }

        return decodedMessage.toString();
    }
    
}//Translator

class DecodingStack {

    // This wraps a standard Java Stack, but we name it aStack per assignment instructions.
    private Stack<Character> aStack;

    // Constructor – set up the underlying stack structure.
    public DecodingStack() {
        aStack = new Stack<>();
    }

    // Returns true if stack is empty.
    public boolean isEmpty() {
        return aStack.isEmpty();
    }

    // Returns how many items are currently in the stack.
    public int size() {
        return aStack.size();
    }

    // Pushes one character onto the top of the stack.
    public void push(Character value) {
        aStack.push(value);
    }

    // Pops one character off the top of the stack and returns it.
    public Character pop() {
        return aStack.pop();
    }
}