/* Solution Assignment #2 CS1150 Spring 2025
 *
 * This program is a simple GPA calculator.
 * The program will display a table showing the following details for two classes:
 *    Class name
 *    Number of credit hours 
 *    Expected grade as a number (A=4, B=3; C=3, D=1, F=1)
 *    Grade points
 *    
 * The program will display totals for the 2 classes for the number credit hours and grade points
 * The program will calculate the projected GPA for the 2 classes 
 *
 *  Note: 
 *  This solution code may not be copied, doing so will result in a grade of zero.
 *  This solution is not for distribution online or by any other means. Copyright M. Gonzalez UCCS
 *  
 */
import java.util.Scanner;

public class CS1150_Assignment2_Spring2025 {

	public static void main(String[] args) {
		
		// Create a scanner object to read input from user
		Scanner input = new Scanner (System.in);

		// Class #1
	    // Prompt user for information regarding the 1st class
		// Need to obtain name of class, number of credit hours, expected grade in course
	    System.out.println();
	    System.out.println("Class #1 Information: ");
	    System.out.println("-------------------------");
		
	    System.out.print("Enter name of 1st class: ");
	    String nameClass1 = input.next();

		System.out.print ("Number credit hours: ");
		int creditHoursClass1 = input.nextInt();
				
		System.out.print("Expected grade where A=4,B=3,C=2,D=1,F=0? ");
		int gradeClass1 = input.nextInt();
		
		// Compute the grade points for the 1st class
		double gradePointsClass1 = creditHoursClass1 * gradeClass1;
		
		// Class #2
	    // Prompt user for information regarding the 2nd class
		// Need to obtain name of class, number of credit hours, expected grade in course
	    System.out.println();
	    System.out.println("Class #2 Information: ");
	    System.out.println("-------------------------");
		
	    System.out.print("Enter name of 2nd class: ");
	    String nameClass2 = input.next();
	    
		System.out.print("Number credit hours: ");
		int creditHoursClass2 = input.nextInt();

		System.out.print("Expected grade where A=4,B=3,C=2,D=1,F=0? ");
		int gradeClass2 = input.nextInt();

		// Compute the grade points for the 1st class
		double gradePointsClass2 = creditHoursClass2 * gradeClass2;

		// Display results	
	    // STUDENT NOTE: Here "println" statements are used with spaces to create a header for the output
		System.out.println();
		System.out.println("**************************************************************************************");
		System.out.println("                             GPA Calculator");
		System.out.println("**************************************************************************************");
		System.out.println();
		System.out.println("Class           Credit Hours   Expected Grade(A=4,B=3,C=2,D=1,F=0)      Grade Points");
		System.out.println("--------------------------------------------------------------------------------------");

		// Display the information for the first class

		// STUDENT NOTE:
		// The following println statements with spaces could be used, but were not.
		// They are included and commented out to show you another way to create output.
		///////System.out.print(nameClass1);
		///////System.out.print("            " + creditHoursClass1);
		///////System.out.print("               " +  gradeClass1);	
		///////System.out.print("                                    " +  gradePointsClass1);	
		///////System.out.println();

		// To create cleaner output, printf statements with tabs and format specifies are used.
		// STUDENT NOTE: Here "printf" statements are used to create the "formatted" output
		// Note the following: 
		//    \t inserts one tab so \t\t inserts two tabs
		//    %s is the format specifier for strings
		//    %d is the format specifier for integers
		//    %5.2f provides 5 total spaces with 2 spaces after the decimal - this helps line up the numbers
		//    %.2f provides however many spaces are needed with 2 spaces after the decimal 
		// To get things to line up, fiddle with the tabs and values until it looks nice
		// Here one printf statement is used for each value
		System.out.printf("%s", nameClass1);
		System.out.printf("\t\t%d", creditHoursClass1);
		System.out.printf("\t\t%d", gradeClass1);
		System.out.printf("\t\t\t\t\t%5.2f", gradePointsClass1);
		System.out.printf("\n");
		
		// Display the information for the 2nd class
		// STUDENT NOTE: For class #1, a separate printf was used to display each value.
		// Another approach is to combine these statements into one. The following shows how this is done.
		System.out.printf("%s\t\t%d\t\t%d\t\t\t\t\t%5.2f\n", 
				           nameClass2, creditHoursClass2, gradeClass2, gradePointsClass2);
		System.out.println("--------------------------------------------------------------------------------------");

		// Calculate GPA - total grade points divided by the number of credit hours
		int totalCreditHours = creditHoursClass1 + creditHoursClass2;
		double totalGradePoints = gradePointsClass1 + gradePointsClass2;
		double gpa = totalGradePoints/totalCreditHours;

		// Display the total credit hours and grade points for the two classes
		// If the tabs are too confusing, use spaces to line values up as shown when computing the totals
		System.out.print("Totals");
		System.out.printf("          %d", totalCreditHours);
		System.out.printf("                                                       %5.2f", totalGradePoints);

		// Display the projected GPA for the two classes
		System.out.println();
		System.out.println();
		System.out.printf("Your projected GPA for %s and %s = %4.2f", nameClass1, nameClass2, gpa);
		
		// Close the scanner
		input.close();

	} // main

} // Assignment 2

