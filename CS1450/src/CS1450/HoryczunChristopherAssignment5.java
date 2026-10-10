package CS1450;

/*
 * Name: Christopher Horyczun
 * Class: CS1450 (M/W)
 * Due Date: October 8, 2025 (MW)
 * Assignment #5
 * Description: For part One, we will be using Java’s built-in Stack class to push a set of values onto a stack. Count how many even numbers are in the stack without removing them. Then display all the values without altering the stack’s state. 
For part two, we will create our own generic stack class with basic operations such as push, pop, peek, and isEmpty. Then read values from two files into two unsorted stacks, combine these stacks into one sorted stack with the smallest element on top, and separate any duplicate values into a different stack. The program must work with both integer and string data.
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class HoryczunChristopherAssignment5 {
	

	public static void main(String[] args) throws FileNotFoundException {
		
		//Part 1 (JCF Stack)
		int[] value = {12, 9, 3, 10, 4, 2, 5, 15, 7, 11, 14};
		Stack<Integer> stack = new Stack<>();
		
		for (int i = 0; i < value.length; i++) {
		    stack.push(value[i]);
		}
		
		int numEven = findNumEven(stack);

        System.out.println("Stack Values After Find Number of Even Values");
        System.out.println("----------------------------------------------");
        printStack(stack);

        System.out.println("\nNumber of even values: " + numEven);

        // Part 2 : Generic Stacks
        GenericStack<Integer> numStack1 = new GenericStack<>();
        GenericStack<Integer> numStack2 = new GenericStack<>();

        fillStackFromFile("numbers1.txt", numStack1);
        fillStackFromFile("numbers2.txt", numStack2);
        
        //Title plus data for it
        System.out.println("\nValues read from Numbers1.txt and pushed onto stack1");
        System.out.println("-------------------------------------------------------");
        printStack(numStack1);
        
        //Title plus data for it
        System.out.println("\nValues read from Numbers2.txt and pushed onto stack2");
        System.out.println("-------------------------------------------------------");
        printStack(numStack2);

        //Combining numStack1 and numStack2
        GenericStack<Integer> combinedNumStack = combineStacks(numStack1, numStack2);

        //Sorting the stack
        GenericStack<Integer> sortedNumStack = new GenericStack<>();
        sortStack(combinedNumStack, sortedNumStack);

        System.out.println("\nCombined Number Stack With Duplicates - lowest value on top:");
        System.out.println("------------------------------------------------------------");
        printStack(sortedNumStack);

        //Start of finding duplicates
        GenericStack<Integer> duplicatesNumStack = removeDuplicates(sortedNumStack);

        //Print the duplicates removed
        System.out.println("\nCombined Number Stack Duplicates Removed - lowest value on top:");
        System.out.println("-------------------------------------------------------");
        printStack(sortedNumStack);

        //Print duplicated numbers
        System.out.println("\nDuplicates Number Stack - largest value on top:");
        System.out.println("----------------------------------------------");
        printStack(duplicatesNumStack);

        //Strings sections of Part two
        GenericStack<String> stringStack1 = new GenericStack<>();
        GenericStack<String> stringStack2 = new GenericStack<>();

        fillStackFromFile("strings1.txt", stringStack1);
        fillStackFromFile("strings2.txt", stringStack2);

        //Print data from stack 1
        System.out.println("\nValues read from Strings1.txt and pushed onto stack1");
        System.out.println("------------------------------------------------------------");
        printStack(stringStack1);
        
        //Print data from stack 2
        System.out.println("\nValues read from Strings2.txt and pushed onto stack2");
        System.out.println("------------------------------------------------------------");
        printStack(stringStack2);

        //combined string1 and string2
        GenericStack<String> combinedStringStack = combineStacks(stringStack1, stringStack2);

        //Sort the combined string
        GenericStack<String> sortedStringStack = new GenericStack<>();
        sortStack(combinedStringStack, sortedStringStack);

        //Print duplicates
        System.out.println("\nCombined String Stack With Duplicates - lowest value on top:");
        System.out.println("------------------------------------------------------------");
        printStack(sortedStringStack);

        //Remove duplicates
        GenericStack<String> duplicatesStringStack = removeDuplicates(sortedStringStack);

        //Print stack without duplicates
        System.out.println("\nCombined String Stack Duplicated Removed - lowest value on top:");
        System.out.println("------------------------------------------------------------");
        printStack(sortedStringStack);

        //Print with duplicates
        System.out.println("\nDuplicates String Stack - largest value on top:");
        System.out.println("------------------------------------------------------------");
        printStack(duplicatesStringStack);
    }//Main

    public static int findNumEven(Stack<Integer> stack) {
        Stack<Integer> temp = new Stack<>();
        int count = 0;

        //while stack is not empty
        while (!stack.isEmpty()) {
            int val = stack.pop();
            if (val % 2 == 0) {
                count++;
            }
            temp.push(val);
        }

        //while temp is not empty
        while (!temp.isEmpty()) {
            stack.push(temp.pop());
        }
        return count;
    }//findNumEven

    public static void printStack(Stack<Integer> stack) {
        Stack<Integer> temp = new Stack<>();
        
        while (!stack.isEmpty()) {
            int val = stack.pop();
            System.out.println(val);
            temp.push(val);
        }
        
        while (!temp.isEmpty()) {
            stack.push(temp.pop());
        }
    }//end of printStack

    //Methods
    public static <E> void fillStackFromFile(String filename, GenericStack<E> stack) throws FileNotFoundException {
        Scanner input = new Scanner(new File(filename));
        
        //while next input exist
        while (input.hasNext()) {
            String token = input.next();
            @SuppressWarnings("unchecked")
            E value = (E) (token.matches("-?\\d+") ? (E) Integer.valueOf(token) : token);
            stack.push(value);
        }//end of while loop
        
        input.close();
        
    }//end of fillStackFromFile

    public static <E> void printStack(GenericStack<E> stack) {
        GenericStack<E> temp = new GenericStack<>();
        
        //while stack is not empty
        while (!stack.isEmpty()) {
            E val = stack.pop();
            System.out.println(val);
            temp.push(val);
        }
        
        //while temp is not empty
        while (!temp.isEmpty()) {
            stack.push(temp.pop());
        }
        
    }//end of printStack

    // Combine stacks
    public static <E> GenericStack<E> combineStacks(GenericStack<E> stack1, GenericStack<E> stack2) {
        GenericStack<E> combined = new GenericStack<>();
        GenericStack<E> temp = new GenericStack<>();

        while (!stack1.isEmpty()) temp.push(stack1.pop());
        while (!temp.isEmpty()) combined.push(temp.pop());

        while (!stack2.isEmpty()) temp.push(stack2.pop());
        while (!temp.isEmpty()) combined.push(temp.pop());

        return combined;
        
    }//end of combinedStacks

    // Sort stack
    public static <E extends Comparable<E>> void sortStack(GenericStack<E> unsortedStack, GenericStack<E> sortedStack) {
        //while unsorted stack is not empty
    	while (!unsortedStack.isEmpty()) {
            E temp = unsortedStack.pop();
            
            //while sorted stack is not empty and we are peeping inside of it
            while (!sortedStack.isEmpty() && sortedStack.peek().compareTo(temp) > 0) {
                unsortedStack.push(sortedStack.pop());
            }
            sortedStack.push(temp);
        }
    }//SortStack

    // Remove duplicates
    public static <E extends Comparable<E>> GenericStack<E> removeDuplicates(GenericStack<E> stack) {
    	
        GenericStack<E> unique = new GenericStack<>();
        GenericStack<E> duplicates = new GenericStack<>();

        //while stack is not empty
        while (!stack.isEmpty()) {
            E val = stack.pop();
            //if unique is not empty and we are peeping inside of it
            if (!unique.isEmpty() && unique.peek().compareTo(val) == 0) {
                duplicates.push(val);
            } else {
                unique.push(val);
            }
        }

        // Restore unique values back to stack (sorted, no duplicates)
        GenericStack<E> temp = new GenericStack<>();
        while (!unique.isEmpty()) temp.push(unique.pop());
        while (!temp.isEmpty()) stack.push(temp.pop());

        return duplicates;

	}//Duplicates

}//Assignment 5


class GenericStack <E> {
	private ArrayList <E> list;

	    // Constructor
	    public GenericStack() {
	        list = new ArrayList<>();
	    }

	    // is the stack empty
	    public boolean isEmpty() {
	        return list.isEmpty();
	    }

	    // get list size
	    public int getSize() {
	        return list.size();
	    }

	    // Peek at the top item without removing anything
	    public E peek() {
	        if (isEmpty()) {
	            throw new RuntimeException("Stack is empty");
	        }
	        return list.get(list.size() - 1);
	    }

	    // Pop top item by removing it and returning it
	    public E pop() {
	        if (isEmpty()) {
	            throw new RuntimeException("Stack is empty");
	        }
	        return list.remove(list.size() - 1);
	    }

	    // Push a new item onto the stack
	    public void push(E value) {
	        list.add(value);
	    }
}//end of Generic Stack class