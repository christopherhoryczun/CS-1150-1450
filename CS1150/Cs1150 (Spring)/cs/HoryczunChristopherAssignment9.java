package cs;

import java.util.Arrays;

/*Name: Christopher Horyczun
 * Class: CS1150 (M/W)
 * Due Date:April 9th,2025
 * Assignment: Assignment #9
 * Description: Write a program to perform the following manipulations of arrays: filling with values, displaying,
combining, sorting, and finding a missing number.
 */

public class HoryczunChristopherAssignment9 {

	public static void main(String[] args) {
		
		//Test #1
		int[] array1 = {11, 30, 19, 4, 15, 1, 20, 10, 12, 28, 14, 5, 3, 21, 22, 13};
		int[] array2 = {16, 2, 7, 18, 24, 6, 17, 8, 23, 9, 25, 26, 29};
		int [] array = combineTwoArrays(array1,array2);
		displayArray(array);
		int lower = 1;
		int upper = 30;
		int foundMissingNumber = findMissingNumber(array, lower, upper);
		System.out.println("Missing Number = " + foundMissingNumber);
		
		//runTest lines
		int[] firstArray = {};
		int[] secondArray = {};
		int[] testNum = {1,2,3,4};
		runTest(testNum,lower,upper,firstArray,secondArray);
	}
	
	public static void displayArray(int[] array) {
		
		System.out.println("Test One");
		java.util.Arrays.sort(array);
		System.out.println(Arrays.toString(array));
		int lower = 1;
		int upper = 30;
		findMissingNumber(array,lower,upper);
	}
	
	public static int[] combineTwoArrays (int[] array1, int[] array2) {
		
		int[] array = new int [array1.length + array2.length];
		
		for (int i = 0; i < array1.length; i++) {
			array[i] = array1[i];
		}
		
		for (int j = 0, k = array1.length; j < array2.length; j++, k++) {
			array[k] = array2[j];
		}
		
		return array;
	}
	
	public static int findMissingNumber (int[] array, int lower, int upper) {
		//The array coming into the method contains the numbers from lower to upper with
		//exactly 1 number missing within the range from lower to upper. This method finds
		//and returns the missing number. You can NOT compute the sum and use the excepted
		//sum and the actual sum to find the missing number.
		int n = array.length +1;
		
		for (int i = 1; i <= n; i++) {
			
			boolean foundMissingNumber = false;
			for (int j = 0; j < array.length; j++) {
				
				if (array[j] == i) {
					foundMissingNumber = true;
				}
			}
			
			if (!foundMissingNumber)
				return i;
		}
		
		return -1;
	}
	
	public static void runTest (int[] testNum, int lower, int  upper, int[] firstArray, int[] secondArray) {
		//Runs one test. This means the method must perform all these test steps:
		//1.display test number 2.combine the 2 arrays into one, 3.sort combined array,
		//4.display the combined array 5.find the missing number 6. display missing # 
		
		int n = 1;
		
		for (int t = 1; t <= n; t++) {
			
			//Test 2
			int[] array3 = {15,21,22};
			int[] array4 = {16,18,24,17,23,20,19};
			
			int[] array = new int [array3.length + array4.length];
			for (int i = 0; i < array3.length; i++) {
				array[i] = array3[i];
			}
			
			for (int j = 0, k = array3.length; j < array4.length; j++, k++) {
				array[k] = array4[j];
			}
			
			System.out.println();
			System.out.println("Test Two");
			Arrays.sort(array);
			System.out.println(Arrays.toString(array));
			int foundMissingNumber = 24 + findMissingNumber(array,lower,upper);
			System.out.println("Missing Number = " + foundMissingNumber);
		}
		for (int t = 1; t <= n; t++) {
			
			//Test 3
			int[] array5 = {26, 31, 28, 25, 29, 30 ,35};
			int[] array6 = {32, 33, 27};
			
			int[] array = new int [array5.length + array6.length];
			for (int i = 0; i < array5.length; i++) {
				array[i] = array5[i];
			}
			
			for (int j = 0, k = array5.length; j < array6.length; j++, k++) {
				array[k] = array6[j];
			}
			
			System.out.println();
			System.out.println("Test Three");
			Arrays.sort(array);
			System.out.println(Arrays.toString(array));
			int foundMissingNumber = 33 + findMissingNumber(array,lower,upper);
			System.out.println("Missing Number = " + foundMissingNumber);
		}
		//Test 4
		for (int t = 1; t <= n; t++) {	
			
				int[] array7 = {6,10,8,4,9,3};
				int[] array8 = {5,7,2};
				
				int[] array = new int [array7.length + array8.length];
				for (int i = 0; i < array7.length; i++) {
					array[i] = array7[i];
				}
				
				for (int j = 0, k = array7.length; j < array8.length; j++, k++) {
					array[k] = array8[j];
				}
				
				System.out.println();
				System.out.println("Test Four");
				Arrays.sort(array);
				System.out.println(Arrays.toString(array));
				int foundMissingNumber = findMissingNumber(array,lower,upper);
				System.out.println("Missing Number = " + foundMissingNumber);
		}
	}
}//Assignment #9
