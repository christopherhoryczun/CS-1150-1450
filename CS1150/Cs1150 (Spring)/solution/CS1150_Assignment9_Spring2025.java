// Solution Assignment #9 CS1150 Spring 2025
// Topic: More Arrays and Methods 
//
// Note: 
// This solution code may not be copied, doing so will result in a grade of zero.
// This solution is not for distribution online or by any other means. Copyright M. Gonzalez UCCS

import java.util.Arrays;

public class CS1150_Assignment9_Spring2025 {

	public static void main(String[] args) {
		
		//////////////////////////////////////
		// Test #1 - the number 27 is missing
		//////////////////////////////////////		

		// Create two arrays of integers		
		int[] array1 = {11, 30, 19, 4, 15, 1, 20, 10, 12, 28, 14, 5, 3, 21, 22, 13};
		int[] array2 = {16, 2, 7, 18, 24, 6, 17, 8, 23, 9, 25, 26, 29};
		
		// Set the lower and upper values for test #1
		int lower = 1;
		int upper = 30;
		int testNum = 1;
		
		// Run test #1 to find the one missing number between 1 and 30
		// Missing number is 27
		runTest(testNum, lower, upper, array1, array2);
		
		
		//////////////////////////////////////
		// Test #2 - the number 25 is missing
		//////////////////////////////////////		

		// Create two arrays of integers		
		int[] array3 = {15, 21, 22};
		int[] array4 = {16, 18, 24, 17, 23, 20, 19};
	
		// Reset the lower and upper values for test #2
		lower = 15;
		upper = 25;
		testNum = 2;
		
		// Run test #2 to find the one missing number between 15 and 25
		// Missing number is 25 - it is the last possible value in combined array 
		runTest(testNum, lower, upper, array3, array4);
		
		
		//////////////////////////////////////		
		// Test #3 - the number 34 is missing
		//////////////////////////////////////		

		// Create two arrays of integers		
		int[] array5 = {26, 31, 28, 25, 29, 30, 35};
		int[] array6 = {32, 33, 27};
		
		// Reset the lower and upper values for test #3 
		lower = 25;
		upper = 35;
		testNum = 3;
		
		// Run test #3 to find the one missing number between 25 and 35
		// Missing number is 34 - it is 2nd to last value in combined array
		runTest(testNum, lower, upper, array5, array6);
		
		
		//////////////////////////////////////
		// Test #4 - the number 1 is missing
		//////////////////////////////////////		

		// Create two arrays of integers		
		int[] array7 = {6, 10, 8, 4, 9, 3};
		int[] array8 = {5, 7, 2};
		
		// Reset the lower and upper values for test #4
		lower = 1;
		upper = 10;
		testNum = 4;
		
		// Run test #4 to find the one missing number between 1 and 10
		// Missing number is 1 - it is the 1st value in combined array
		runTest(testNum, lower, upper, array7, array8);
		
		
		//********************************************************************
		// TEST #5 IS NOT PART OF ASSIGNMENT - PROVIDED AS AN EXTRA CHALLENGE 
		//********************************************************************
		//////////////////////////////////////
		// Test #5 - no missing number
		//////////////////////////////////////		

		// NOTE: 
		// I did not change the runTest method to deal with this situation
		// so instead everything for this test is being done in main.
		
		// Create two arrays of integers		
		int[] array9 = {16, 20, 10, 18, 14, 19, 13};
		int[] array10 = {11, 15, 17, 12};
		
		// Reset the lower and upper values for test #4
		lower = 10;
		upper = 20;

		// Display each array
		System.out.println();
		System.out.println();
		System.out.println("***************************");
		System.out.println("Combined Array Test #5");
		System.out.println("***************************");

		// Combine the two arrays
		int[] combinedArray5 = combineTwoArrays(array9, array10);

		// Sort the combined array using the sort method in Arrays class
		Arrays.sort(combinedArray5);
		displayArray(combinedArray5);
		
		// Finding the one missing number between 10 and 20
		int missingNumber = findMissingNumberHarder(combinedArray5, lower, upper);
		
		// If the method returns -1 then no values were missing, otherwise display the missing number
		System.out.println();
		if(missingNumber == -1) {
			System.out.println("No values are missing");
		}
		else {
			System.out.println("Missing value = " + missingNumber);			
		}
		
	} // main
	
	
	//******************************************************************
	// Runs one test. This means the method must perform all the test steps:
	// 1) display the test number, 2) combine the 2 arrays into one, 3) sort combined array, 
	// 4) display the combined array, 5) find missing number, 6) display the missing number
	// Input: test number, lower and upper bounds, 2 integer arrays
	// Return: none
	//******************************************************************
	public static void runTest (int testNum, int lower, int upper, int[] firstArray, int[] secondArray) {
		
		// Display the test number
		System.out.println();
		System.out.println("***************************");
		System.out.println("Combined Array Test #" + testNum);
		System.out.println("***************************");
		
		// Combine the two arrays
		int[] combinedArray = combineTwoArrays(firstArray, secondArray);

		// Sort the combined array using the sort method in Arrays class then display
		Arrays.sort(combinedArray);
		displayArray(combinedArray);
				
		// Finding the one missing number between lower and upper then display
		int missingNumber = findMissingNumber(combinedArray, lower, upper);
				
		System.out.println();
		System.out.println("Missing value = " + missingNumber);			
		System.out.println();
		
	} // runTest

	
	//******************************************************************
	// Displays the values in an array 
	// Input: array to display
	// Return: none
	//******************************************************************
	public static void displayArray (int[] array) {
		
		for (int i = 0; i < array.length; i++) {
			System.out.printf("array[%d]\t= %d\n", i, array[i]);
		}
		
	} // displayArray

	
	//******************************************************************
	// Combine the values in two arrays and return the combined array
	// Input: two arrays with integer values
	// Return: array with all values combined
	//******************************************************************
	public static int[] combineTwoArrays (int[] array1, int[] array2) {
				
		// Create the array to hold all the combined values
		int[] combined = new int[array1.length + array2.length];
		
		// Copy the values from the 1st array into the combined array
		for (int i = 0; i < array1.length; i++) {
			combined[i] = array1[i];
		}
		
		// Copy values from the 2nd array into the combined array
		// Need to start combinedIndex where we left off after copied values in 1st array
		int combinedIndex = array1.length;
		for (int i = 0; i < array2.length; i++) {
			combined[combinedIndex] = array2[i];
			combinedIndex++;
		}

		return combined;
	}
	
	
	//******************************************************************
	// The array sent in contains the numbers from lower to upper bound, 
	// except exactly 1 number is missing. This method finds the missing number.
	// Input: sorted array of integers and a lower and upper bound
	// Return: missing number 
	//******************************************************************
	public static int findMissingNumber (int[] array, int lower, int upper) {
		
		// Determine what value is missing between lower and upper
		// Lower and upper are values in the array
		// Initialize the currentValue to the lower bound - it is where we start looking
		int currentValue = lower;
		int index = 0;

		// You can use a for loop or while loop to find the missing value
		// This is an example of using a while loop that completes as soon as the missing value is found
		// Use a boolean to keep track if the missing value was found
		// While not at end of the array and have not found the missing value
		boolean foundMissingValue = false;
		while (index < array.length && !foundMissingValue) {
			
			// If the value in the array at location index is equal to the current value
			// then move index to next array location and increment current value
			if (array[index] == currentValue) {
				index++;
				currentValue++;
			}
			else {
				foundMissingValue = true;
			}
		} // while
	
		// Current value is the missing number
		return currentValue;
		
		
		/*
		// Written using a for loop - iterates through entire array
		int currentValue = lower;
		for (int i = 0; i < array.length; i++) {
			if (array[i] == currentValue) {
				currentValue++;
			}
		}
		return currentValue;
		*/
		
	} // findMissingNumber


	// DEALING WITH AN ARRAY THAT HAS NO MISSING NUMBERS WAS NOT REQUIRED.
	// THIS TEST IS ON THE ASSIGNMENT SHEET AS AN EXTRA CHALLENGE.
	
	//******************************************************************
	// The array sent in contains the numbers from lower to upper, but 
	// one number COULD BE missing.  This method finds that number.
	// Input: sorted array of integers
	// Return: missing number or -1 if no values are missing
	//******************************************************************
	public static int findMissingNumberHarder (int[] array, int lower, int upper) {
		
		// Determine what value is missing between lower and upper
		// lower and upper are values in the array
		int currentValue = lower;
		int index = 0;
		
		// Use a boolean to keep track if missing value was found
		// While not at end of the array and have not found the missing value
		boolean foundMissingValue = false;
		while (index < array.length && !foundMissingValue) {
			
			// If the value in the array at location index is equal to the current value
			// then move index to next array location and increment current value
			if (array[index] == currentValue) {
				index++;
				currentValue++;
			}
			else {
				foundMissingValue = true;
			}
		} // while
		
		// Determine if the missing number was found		
		if (foundMissingValue) {
			// Missing value was found, currentValue is the missing value
			return currentValue;
		}
		else {
			// If did not find a missing value, then there are two possible cases: 
			// 1) the last value (upper) is missing or 
			// 2) no values are missing 
			// The above while loop ends when the end of the array is reached, but there is the possibility 
			// that the last value (upper) is missing.  If current is equal to upper then we know upper is in 
			// the array and no values are missing.
			if (currentValue == upper) {
				return currentValue;
			}
			else {
				// No values are missing, return a -1
				return -1;	
			}
		}

	} // findMissingNumber
	
} // Assignment 9
