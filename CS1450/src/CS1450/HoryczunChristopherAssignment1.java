package CS1450;
/*
 * Name: Christopher Horyczun
 * Class: CS1450 (M/W or T/R)
 * Due Date: Sept 3, 2025 (MW)
 * Assignment #1
 * Description: Create and write a file. Generate two random numbers between 1 and 15(called size1 and size2). The generate (size1 + size2) between 0-49 and put it into a file.
 * Read said file and manipulate the array. Read size1 array, then do the same for size2. Then sort the arrays.
 * Then lastly create a merged array(manually, not merged Method).
 */

//imports
import java.io.*;
import java.util.*;
	
public class HoryczunChristopherAssignment1 {

	
	public static void main(String[] args) throws IOException {
		File assignment = new File("assignment1.txt");
        PrintWriter assignmentFile = new PrintWriter(assignment);
        
		Random rand = new Random();
		
		//Task #1
		int size1 = rand.nextInt(15) + 1; // 1–15
		int size2 = rand.nextInt(15) + 1; // 1–15
		int totalSize = size1 + size2;

		System.out.println("Generated size1 = " + size1);
		System.out.println("Generated size2 = " + size2);
		System.out.println("Total numbers to generate = " + totalSize);
		
		//Generate Random Numbers
		for (int i = 0; i < totalSize; i++) {
			int value = rand.nextInt(50); // 0–49
			assignmentFile.println(value);
			System.out.println(value);
		}//end of for loop
		
		assignmentFile.close();
		System.out.println("\nFile is in directory: " + assignment.getAbsolutePath());
        
		
		//Task #2
		 Scanner file = new Scanner(assignment);
		 
		 int[] array1 = new int[size1];
		 int[] array2 = new int[size2];
		 
		 //To fill Array 1
		 System.out.println("\nRead " + size1 + " values from file. Placing values into the 1st array");
		 for (int i = 0; i < size1; i++) {
			 array1[i] = file.nextInt();
		 }//end of for loop
		 
		 //To fill Array 2
		 System.out.println("Read " + size2 + " values from file. Placing values into the 2nd array");
		 for (int i = 0; i < size2; i++) {
			 array2[i] = file.nextInt();
		 }//end of for loop
		 
		 //Close file
		 file.close();
		 
		 //Sort
		 Arrays.sort(array1);
		 Arrays.sort(array2);
		 
		 //Task #3
		 int[] merged = new int[totalSize];
		 int i = 0, j = 0, k = 0;
		 
		 //Merging
		 while (i < size1 && j < size2) {
			 if (array1[i] <= array2[j]) {
				 merged[k++] = array1[i++];
				 }//end of if
			 else {
				 merged[k++] = array2[j++];
			 }//end of else
		 }//end of while
		 
		// Copy remaining elements
		 while (i < size1) {
			 merged[k++] = array1[i++];
			 }//end of while
		 while (j < size2) {
			 merged[k++] = array2[j++];
			 }//end of while
		 
		// Print merged array values one per line
		 System.out.println("\nRandom values in sorted order in merged array");
		 for (int value : merged) {
			 System.out.println(value);
		 }//end of for statement
		 
	}//end of main
	
}//end of Assignment1
