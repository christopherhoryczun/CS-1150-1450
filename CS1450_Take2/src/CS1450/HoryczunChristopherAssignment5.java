package CS1450;

/*
 * Name: Christopher Horyczun
 * Class Name: CS1450 (M/W)
 * Due Date: March 5, 2026
 * Assignment #5
 * Description:This assignment focuses on working with stacks and generics in Java. In part 1, I used a Java Collections Framework stack to replace values while making sure the order of the stack stayed the same. In part 2, I created my own generic stack class and then used it to read values from files, sort stacks, and merge them together using only stack operations.
 */


import java.io.*;
import java.util.*;

public class HoryczunChristopherAssignment5 {

    public static void main(String[] args) {

        // Given array from the assignment
        int[] numbers = {0, 0, 4, 3, 0, 0, 2, 1, 0, 0};

        // Create a JCF stack and push all values
        Stack<Integer> newStack = new Stack<>();
        for (int i = 0; i < numbers.length; i++) {
            newStack.push(numbers[i]);
        }

        // Replace all 0s with 10s (stack order must stay the same)
        replaceZerosWithTen(newStack);

        // Print the stack to show the result
        System.out.println("Stack Values After 0's Replaced with 10");
        System.out.println("----------------------------------------------");
        printStack(newStack);

        System.out.println("Part 2 starts here\n");

        // Create two generic stacks for integers
        GenericStack<Integer> intStack1 = new GenericStack<>();
        GenericStack<Integer> intStack2 = new GenericStack<>();

        // Fill stacks from input files
        fillIntegerStackFromFile("integers1.txt", intStack1);
        fillIntegerStackFromFile("integers2.txt", intStack2);

        // Print original unsorted stacks
        System.out.println("Integer1 Stack: filled with values from file: integers1.txt");
        System.out.println("----------------------------------------------------------");
        printStack(intStack1);
        System.out.println();

        System.out.println("Integer2 Stack: filled with values from file: integers2.txt");
        System.out.println("----------------------------------------------------------");
        printStack(intStack2);
        System.out.println();

        // Sort both stacks so the largest value is on top
        sortStack(intStack1);
        sortStack(intStack2);

        // Print sorted stacks
        System.out.println("Integer1 Stack: sorted largest to smallest");
        System.out.println("----------------------------------------------------------");
        printStack(intStack1);
        System.out.println();

        System.out.println("Integer2 Stack: sorted largest to smallest");
        System.out.println("----------------------------------------------------------");
        printStack(intStack2);
        System.out.println();

        // Merge the two sorted stacks
        GenericStack<Integer> mergedIntStack = mergeStacks(intStack1, intStack2);

        // Print merged stack (smallest value should be on top)
        System.out.println("Merged Stack: sorted smallest to largest:");
        System.out.println("----------------------------------------------------------");
        printStack(mergedIntStack);

        System.out.println("\t\t\t\t\tPart 2 for Strings\n");

        // Create generic stacks for strings
        GenericStack<String> strStack1 = new GenericStack<>();
        GenericStack<String> strStack2 = new GenericStack<>();

        // Read string values from files
        fillStringStackFromFile("strings1.txt", strStack1);
        fillStringStackFromFile("strings2.txt", strStack2);

        // Print original string stacks
        System.out.println("String1 Stack: filled with values from file: strings1.txt");
        System.out.println("----------------------------------------------------------");
        printStack(strStack1);
        System.out.println();

        System.out.println("String2 Stack: filled with values from file: strings2.txt");
        System.out.println("----------------------------------------------------------");
        printStack(strStack2);
        System.out.println();

        // Sort stacks in reverse alphabetical order
        sortStack(strStack1);
        sortStack(strStack2);

        // Print sorted string stacks
        System.out.println("String1 Stack: sorted in reverse alphabetical");
        System.out.println("----------------------------------------------------------");
        printStack(strStack1);
        System.out.println();

        System.out.println("String2 Stack: sorted in reverse alphabetical");
        System.out.println("----------------------------------------------------------");
        printStack(strStack2);
        System.out.println();

        // Merge string stacks into alphabetical order
        GenericStack<String> mergedStrStack = mergeStacks(strStack1, strStack2);

        System.out.println("Merged Stack: alphabetical");
        System.out.println("----------------------------------------------------------");
        printStack(mergedStrStack);
    }//Main

    // Goes through the stack and replaces every 0 with 10
    public static int replaceZerosWithTen(Stack<Integer> stack) {
        Stack<Integer> temp = new Stack<>();
        int count = 0;

        // Move values to temp while replacing 0s
        while (!stack.isEmpty()) {
            int value = stack.pop();
            if (value == 0) {
                value = 10;
                count++;
            }
            temp.push(value);
        }

        // Move values back to restore original order
        while (!temp.isEmpty()) {
            stack.push(temp.pop());
        }

        return count;
    }//Replace zero with ten

    // Prints the stack without changing it
    public static void printStack(Stack<Integer> stack) {
        Stack<Integer> temp = new Stack<>();

        // Pop, print, and save values
        while (!stack.isEmpty()) {
            int value = stack.pop();
            System.out.println(value);
            temp.push(value);
        }

        // Restore stack
        while (!temp.isEmpty()) {
            stack.push(temp.pop());
        }
    }//print Stack

    // Reads integers from a file and pushes them onto a stack
    private static void fillIntegerStackFromFile(String fileName, GenericStack<Integer> stack) {
        try {
            Scanner input = new Scanner(new File(fileName));
            while (input.hasNextInt()) {
                stack.push(input.nextInt());
            }
            input.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + fileName);
        }
    }//Fill integer stack from file

    // Reads strings from a file and pushes them onto a stack
    private static void fillStringStackFromFile(String fileName, GenericStack<String> stack) {
        try {
            Scanner input = new Scanner(new File(fileName));
            while (input.hasNextLine()) {
                String line = input.nextLine().trim();
                if (!line.isEmpty()) {
                    stack.push(line);
                }
            }
            input.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + fileName);
        }
    }//Fill string stack from file
    
    // Uses one temp stack and restores original state
    public static <E> void printStack(GenericStack<E> stack) {
        GenericStack<E> temp = new GenericStack<>();

        while (!stack.isEmpty()) {
            E value = stack.pop();
            System.out.println(value);
            temp.push(value);
        }

        while (!temp.isEmpty()) {
            stack.push(temp.pop());
        }
    }//print stack

    // Sorts a stack so the largest value ends up on top
    public static <E extends Comparable<E>> void sortStack(GenericStack<E> stack) {
        GenericStack<E> temp = new GenericStack<>();

        // Keep moving values until stack is sorted
        while (!stack.isEmpty()) {
            E value = stack.pop();

            // Move values back if they are smaller
            while (!temp.isEmpty() && temp.peek().compareTo(value) < 0) {
                stack.push(temp.pop());
            }

            temp.push(value);
        }

        // Move everything back into original stack
        while (!temp.isEmpty()) {
            stack.push(temp.pop());
        }
    }//sort stack

    // Merges two sorted stacks into one
    public static <E extends Comparable<E>> GenericStack<E> mergeStacks(
            GenericStack<E> stack1, GenericStack<E> stack2) {

        GenericStack<E> merged = new GenericStack<>();

        // Compare the top of each stack and move the larger one
        while (!stack1.isEmpty() && !stack2.isEmpty()) {
            if (stack1.peek().compareTo(stack2.peek()) >= 0) {
                merged.push(stack1.pop());
            } else {
                merged.push(stack2.pop());
            }
        }

        // Move any remaining values
        while (!stack1.isEmpty()) {
            merged.push(stack1.pop());
        }

        while (!stack2.isEmpty()) {
            merged.push(stack2.pop());
        }

        return merged;
    }//Generic Stack
    
}//Assignment 5


class GenericStack<E> {

    // ArrayList used as the underlying structure
    private ArrayList<E> list;

    // Creates an empty stack
    public GenericStack() {
        list = new ArrayList<>();
    }

    // Returns true if the stack is empty
    public boolean isEmpty() {
        return list.isEmpty();
    }

    // Returns number of elements in the stack
    public int getSize() {
        return list.size();
    }

    // Returns top value without removing it
    public E peek() {
        return list.get(list.size() - 1);
    }

    // Removes and returns the top value
    public E pop() {
        return list.remove(list.size() - 1);
    }

    // Pushes a value onto the stack
    public void push(E value) {
        list.add(value);
    }
    
}//Generic Stack
