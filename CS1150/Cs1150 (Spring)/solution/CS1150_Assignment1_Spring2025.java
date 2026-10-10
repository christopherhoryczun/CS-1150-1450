 /* Solution Assignment #1 CS1150 Spring 2025
 * 
 *  All programs must contain a description at the top that includes your name, the class name and 
 *  section (M/W or (T/R), the due date, and a short description of the assignment.
 *  
 *  Name: Mickey Gonzalez
 *  Class: CS1150 (M/W)
 *  Due: Jan 29, 2025
 *  Description: Assignment #1 
 *  This program demonstrates that I understand basic program structure by 
 *  printing a couple of paragraphs that tell the instructor what I'm passionate
 *  about.  It also gives a little practice with arithmetic in Java. 
 *  
 *  Note: 
 *  This solution code may not be copied, doing so will result in a grade of zero.
 *  This solution is not for distribution online or by any other means. Copyright M. Gonzalez UCCS
 */
package solution;

public class CS1150_Assignment1_Spring2025 {

	public static void main(String[] args) {
		
		System.out.println ("  My name is Mickey Gonzalez.  I spent 27 years working in industry");
		System.out.println ("as a software engineer and user experience engineer.  For the last 8");
		System.out.println ("years I've been on this new adventure of teaching!  It's been quite the");
		System.out.println ("change from working in industry but it has been a very positive change");
		System.out.println ("as I'm passionate about teaching and I'm enjoying it!");
		System.out.println();
		System.out.println ("  This is my second paragraph.  This is not very exciting.  Hopefully");
		System.out.println ("you wrote something interesting about yourself, if not, at least you");
		System.out.println ("will have learned to get your environment setup and demonstrate that");
		System.out.println ("you can use this strange looking println statement.");
	
			
		System.out.println ("**********************************************************************************");
		System.out.println();
		System.out.println ("I will now demonstrate my ability to approximate the value of PI");
		System.out.println();

		// Formula #1 - using only 5 fractions, which is not very accurate
		// STUDENT NOTE:
		// When performing division in Java with integer values the fractional part is truncated. 
		// For example: (1/3) = 0.3333 but because the numbers 1 and 3 are both integers the division will 
		// truncate the fractional part and the result is 0.  Thus, the first run of formula #1 is 4 because
		// all the fractions will result in 0.
		System.out.print ("Formula #1 - Using integer values: ");
		System.out.println(4 * (1 - (1/3) + (1/5) - (1/7) + (1/9) - (1/11)));
		
		// STUDENT NOTE:
		// To fix the issue with integer division we must use floats.
		// This shows, that actually only one of the fractional values needs to be a float. 		
		System.out.print ("Formula #1 - Replace 1 with 1.0:   ");
		System.out.println(4 * (1.0 - (1.0/3) + (1.0/5) - (1.0/7) + (1.0/9) - (1.0/11)));

		// STUDENT NOTE:
		// This shows there is no difference when making both fractional values floats.
		System.out.print ("Formula #1 - Using float values:   ");
		System.out.println(4.0 * (1.0 - (1.0/3.0) + (1.0/5.0) - (1.0/7.0) + (1.0/9.0) - (1.0/11.0)));
		
		
		// Formula #2 - using more fractions to increase accuracy
		// The three cases here
		// Case 1: Integer division
		System.out.println();
		System.out.print ("Formula #2 - Using integer values: ");
		System.out.println(4*(1-(1/3)+(1/5)-(1/7)+(1/9)-(1/11)+(1/13)-(1/15)+(1/17)-(1/19)+(1/21)));		

		// Case 2: Changed only 1's to float
		System.out.print ("Formula #2 - Replace 1 with 1.0:   ");
		System.out.println(4*(1.0-(1.0/3)+(1.0/5)-(1.0/7)+(1.0/9)-(1.0/11)+(1.0/13)-(1.0/15)+(1.0/17)-(1.0/19)+(1.0/21)));

		// Case 3: Changed all values to floats
		System.out.print ("Formula #2 - Using float values:   ");
		System.out.println(4.0*(1.0-(1.0/3.0)+(1.0/5.0)-(1.0/7.0)+(1.0/9.0)-(1.0/11.0)+(1.0/13.0)-(1.0/15.0)+(1.0/17.0)-(1.0/19.0)+(1.0/21.0)));

		// Student Note: The following is a case of a completely hard coded solution.
		// You should NEVER write code where you manually do the computations on a calculator and 
		// place the results into your code or copy the values from the assignment sheet and place  
		// them into your code.  Computations should always be done by the computer.
		System.out.println();
		System.out.println("This is an example of completely hard coding the solution - DO NOT DO THIS!");
		System.out.println();
		System.out.println ("Formula #2 - Using integer values: 4");
		System.out.println ("Formula #2 - Replace 1 with 1.0:   2.9760461760461765");
		System.out.println ("Formula #2 - Using float values:   2.9760461760461765");

	} // maina

} // Assignment 1
