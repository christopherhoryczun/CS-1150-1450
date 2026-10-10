// Solution Assignment #8 CS1150 Spring 2025
// Topic: Arrays and Methods and a small introduction to Classes and Objects
//
// Note: 
// This solution code may not be copied, doing so will result in a grade of zero.
// This solution is not for distribution online or by any other means. Copyright M. Gonzalez UCCS

public class CS1150_Assignment8_Spring2025 {

	public static void main(String[] args) {
		
		// Create array to hold the exam grades for all students in the class
		int[] grades = {70, 62, 55, 57, 68, 92, 88, 87, 78, 97};
	
		// Find the highest grade among all students
		int highestGrade = findHighestGrade(grades);
		System.out.println ("Highest grade is: " + highestGrade);

		// Find the average of all the grades and display the average
		double average = computeAverage (grades);
		System.out.println ("Average grade is: " + average);
		
		// Create an array to store the letter grades for each student
		// STUDENT NOTE: the letterGrades array is the same size as the grades array
		char[] letterGrades = new char[grades.length];

		// Determine the letter grade for each student 
		// Letter grades are based off the highest grade
		// Display the grade and letter grade for each student
		computeLetterGrades (grades, letterGrades, highestGrade);
		displayGrades(grades, letterGrades);
			
		// Display number of A's, B's, C's, etc
		displayLetterGradeTotals(letterGrades);
		
		// Now lets play with objects!
		// First create an array that will hold dog objects
		// Then create 5 dog objects and place into array
		System.out.println();
		System.out.println("Make an array of dog objects");
		System.out.println("----------------------------");
		
		// Create an array that will hold 5 dogs
		DogS25[] dogArray = new DogS25[5];
		
		// Now create the dog objects to place into the array
		DogS25 dog1 = new DogS25("Rover", "woof woof");
		DogS25 dog2 = new DogS25("Max", "arf arf arf");
		DogS25 dog3 = new DogS25("Tiny", "yap yap yap");
		DogS25 dog4 = new DogS25("Trooper", "ruff ruff ruff");
		DogS25 dog5 = new DogS25("Magoo", "bow wow bow wow");
		
		// Manually place each dog into the array
		dogArray[0] = dog1;
		dogArray[1] = dog2;
		dogArray[2] = dog3;
		dogArray[3] = dog4;
		dogArray[4] = dog5;
		
		// Iterate through the array making each dog bark
		makeDogsBark(dogArray);
		
	} //main
	
	
	//******************************************************************
	// Finds and returns the highest grade among all grades in the array 
	// Inputs: array of grades
	// Return: highest grade
	//******************************************************************
	public static int findHighestGrade (int[] grades) {
		
		int highestGrade = 0;
		for (int i = 0; i < grades.length; i++) {
			if (grades[i] >= highestGrade) {
				highestGrade = grades[i];
			}
		}
		return highestGrade;
		
	} // findHighestGrade
	
	
	//******************************************************************
	// Computes and returns the average of all grades
	// Input: array of grades
	// Return: average grade
	//******************************************************************
	public static double computeAverage (int[] grades) {
		
		// STUDENT NOTE: even though the array is an array of integers, sum is defined
		// as a double to avoid integer division when computing the average
		double sum = 0;
		for (int i = 0; i < grades.length; i++) {
			sum = sum + grades[i];
		}
		
		return sum/grades.length;
		
	} // computeAverage	

	
	//******************************************************************
	// Determine each student's letter grade and store that grade in the letter grades array  
	// Input: array of numeric grades, array of letter grades, highest grade
	// Return: none
	//*******************************************************************
	public static void computeLetterGrades (int[] grades, char[] letterGrades, int highestGrade) {

		// STUDENT NOTE: The letterGrades array comes into this method with the default character value,
		// which is the null character - '\u0000'
		// This method then computes and places the letter grades into the array.  Because arrays are 
		// passed by reference, when this code returns to the calling method, the letterGrades array 
		// will contain the letter grades. The magic of pass by reference!
		
		// Determine each student's letter grade based on the following 
		// Grade is A if grade is >= highest - 10
		// Grade is B if grade is >= highest - 20
		// Grade is C if grade is >= highest - 30
		// Grade is D if grade is >= highest - 40
		// Grade is F otherwise

		// For each grade, place a letter grade into the letterGrade array  
		for (int i = 0; i < grades.length; i++) {
			if (grades[i] >= highestGrade - 10) {
				letterGrades[i] = 'A';
			}
			else if (grades[i] >= highestGrade - 20) {
				letterGrades[i] = 'B';
			}
			else if (grades[i] >= highestGrade - 30) {
				letterGrades[i] = 'C';
			}
			else if (grades[i] >= highestGrade - 40) {
				letterGrades[i] = 'D';
			}
			else {
				letterGrades[i] = 'F';
			}
		} // for loop
		
	} // computeLetterGrade

	
	//******************************************************************
	// Display a table with each student's exam grade and letter grade 
	// Input: array of numeric grades, array of letter grades
	// Return: none
	//******************************************************************
	public static void displayGrades (int[] grades, char[] letterGrades) {
		
		System.out.println("\nStudent\tExam Grade\tLetter Grade");
		System.out.println("------------------------------------");
		for (int i = 0; i < grades.length; i++) {
			System.out.printf("%1d\t%3d\t\t%s\n", i+1, grades[i], letterGrades[i]);
		}
		
	} // displayGrades

	
	//******************************************************************
	// Displays the number of each letter grade
	// Input: array of letter grades
	// Return: none
	//******************************************************************
	public static void displayLetterGradeTotals (char[] letterGrades) {
		
		// Initialize the counters
		int numberA = 0;
		int numberB = 0;
		int numberC = 0;
		int numberD = 0;
		int numberF = 0;
		
		// For each letter grade increment correct grade counter
		for (int i = 0; i < letterGrades.length; i++) {
			if (letterGrades[i] == 'A') {
				numberA++;
			}
			else if (letterGrades[i] == 'B') {
				numberB++;
			}
			else if (letterGrades[i] == 'C') {
				numberC++;
			}
			else if (letterGrades[i] == 'D') {
				numberD++;
			}
			else {
				numberF++;
			}
		}
		
		// Display the results
		System.out.println();
		System.out.println("Number of A's = " + numberA);
		System.out.println("Number of B's = " + numberB);
		System.out.println("Number of C's = " + numberC);
		System.out.println("Number of D's = " + numberD);
		System.out.println("Number of F's = " + numberF);
		
	} // displayLetterGradeTotals	

	
	//******************************************************************
	// Makes each dog in the array bark by calling the dog's bark method
	// Input: array of dog objects
	// Return: none
	//******************************************************************
	public static void makeDogsBark(DogS25[] dogArray) {
		for (int i = 0; i < dogArray.length; i++) {
			System.out.println (dogArray[i].getName() + " barks like this: " + dogArray[i].getBark());
		}
		
	} // makeDogsBark

} // Assignment 8


//Start to play with classes and objects
//Renamed the Dog class to DogS25 so if you import it into your eclipse there will be no naming issues
class DogS25 {
	private String name;
	private String bark;
	
	public DogS25 (String name, String bark) {
		this.name = name;
		this.bark = bark;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getBark() {
		return bark;
	}
	
	public void setBark(String bark) {
		this.bark = bark;
	}

} // Dog