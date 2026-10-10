package CS1450;

/*
 * Name: Christopher Horyczun
 * Class Name: CS1450 (M/W)
 * Due Date: January 21, 2026
 * Assignment #1
 * Description: Better our understanding of how to manipulate arrays and to review files to write and read them.+
 */

import java.io.*;
import java.util.*;

public class HoryczunChristopherAssignment1 {

	public static void main (String args[]) throws IOException {
		
	//Task 1: Create an array and fill it with values:
		
		//a.	Use the following statement to create an array with these specific values
		int[] array = {1, 18, 10, 2, 16, 8, 15, 9, 9, 17, 14, 18, 1, 19};
		
		//Display the values in the array
		System.out.println("The created array is " + Arrays.toString(array));
		
		//Sort the array using the sort method in the Arrays class
		Arrays.sort(array);
		System.out.println("When sorted it is " + Arrays.toString(array));
		
	//Task 2: Write values in the array to a file in sorted order:
		
		//Associate a file object with the file name of assignment1.txt and open the file for writing.
		File arrayFile = new File("assignment1.txt");
		PrintWriter arrayDocument = new PrintWriter(arrayFile);
		
		//Write all values in the array to the file
		int evenCount = 0;
		int oddCount = 0;
		
		for (int i = 0; i < array.length; i++) {
			arrayDocument.println(array[i]);
			if (array[i] % 2 == 0) {
				evenCount++;
			} else {
				oddCount++;
			}
			
		}//end of for loop
		arrayDocument.close();
		
		System.out.println("\nValues written to file: " + array.length);
		System.out.println("Even values written to file: " + evenCount);
		System.out.println("Odd values written to files: " + oddCount);
		System.out.println("File is in directory:        " + arrayFile.getAbsolutePath());
		
	//Task 3
		Scanner fileReader = new Scanner(arrayFile);
		
		int[] even = new int[evenCount];
		int[] odd  = new int[oddCount];
		
		//for counting
		int evenCounter = 0;
		int oddCounter = 0;
		
		while (fileReader.hasNextInt()) {
			int number = fileReader.nextInt();
			
			if (number % 2 == 0) {
				boolean isDouble = false;
				for (int i = 0; i < evenCounter; i++) {
					if (even[i] == number) {
						isDouble = true;
						break;
					}//end of if
					
				}//end of for
				
				if (!isDouble) {
					even[evenCounter] = number;
					evenCounter++;
				}
				
			} else {
				
				// Manually check for duplicates in oddNumbers (only look at the filled part)
				boolean isDouble = false;
				for (int i = 0; i < oddCounter; i++) {
					if (odd[i] == number) {
						isDouble = true;
						break;
		            }//end of if
		        }//end of for

		        if (!isDouble) {
		            odd[oddCounter] = number;
		            oddCounter++;
		        }
		    }
		}
		fileReader.close();
		
		// print oversized arrays (unique values + extra zeros)
		System.out.println("\nEven array with no duplicates and extra zeros");
		for (int i = 0; i < even.length; i++) {
			System.out.println("even[" + i + "] = " + even[i]);
		}
		
		System.out.println("\nOdd array with no duplicates and extra zeros");
		for (int i = 0; i < odd.length; i++) {
			System.out.println("odd[" + i + "] = " + odd[i]);
		}
		
		//resizing it for with out dub
		int[] evenNoDup = Arrays.copyOf(even, evenCounter);
		int[] oddNoDup  = Arrays.copyOf(odd,  oddCounter);
		
		//print resize
		System.out.println("\nEven array with no duplicates");
		for (int i = 0; i < evenNoDup.length; i++) {
			System.out.println("even[" + i + "] = " + evenNoDup[i]);
		}
		
		System.out.println("\nOdd array with no duplicates");
		for (int i = 0; i < oddNoDup.length; i++) {
			System.out.println("odd[" + i + "] = " + oddNoDup[i]);
		}
		
		}//end of main
	
}//end of Assignment 1
