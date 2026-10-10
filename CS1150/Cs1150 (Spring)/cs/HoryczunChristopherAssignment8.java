package cs;

/*Name: Christopher Horyczun
 * Class: CS1150 (M/W)
 * Due Date:April 2nd,2025
 * Assignment: Assignment #8
 * Description: Write a program that assigns a letter grade to a students' exam. 
 * First the program will examine all students exam grades to find the highest and compute 
 * the average grade. Second the program assigns a letter grade to each student.
 */
public class HoryczunChristopherAssignment8 {

	public static void main(String[] args) {
		//Arrays
		int[] grades = {70, 62, 55, 57, 68, 92, 88, 87, 78, 97};
		char[] letterGrades = {'A', 'B', 'C', 'D', 'F', 'a', 'b', 'c', 'd', 'f'};
		
		//Throw the ball code (It's the only way I know its going to the method)
		int highestGrade = findHighestGrade (grades);
		double gradeAverage = computeAverage(grades);
		
		//Start data given
		System.out.println("The Highest Grade is " + highestGrade);
		System.out.println("The Average Grade is " + gradeAverage);
		
		//Void send code
		computeLetterGrades(grades, letterGrades, highestGrade);
		displayGrades(grades,letterGrades);
		displayLetterGradeTotals(letterGrades);

	}// main
	
	public static int findHighestGrade(int[] grades) {
	//Find and return the highest grade among all grades in the array
		
		int grade = grades[0];
		
		//Code to find the highest Grade
		for (int i = 0;i < grades.length;i++) {
			if (grades[i] > grade) {
				grade = grades[i];
				
			}
			
		}
		
	//return the highest Grade found
	return grade;
	}
	
	public static double computeAverage(int[] grades) {
	//Computes and return the average of all the grades in the Array
		
		//Start to find Average
		if (grades == null || grades.length == 0) {
			return 0;
		}
		
		//Code to find Average
		double gradeAverage = 0;
		for (int number : grades) {
			gradeAverage += number;
		}
		
		return gradeAverage/grades.length;
	}
	
	public static void computeLetterGrades (int[] grades, char [] letterGrades, int highestGrade) {
		// Determine each student's letter grade, store letter grades in  the letterGrades array  
		// The letter grades are based on the following: 
		// Grade is A if grade is >= highest - 10
		// Grade is B if grade is >= highest - 20
		// Grade is C if grade is >= highest - 30
		// Grade is D if grade is >= highest - 40
		// Grade is F otherwise
		
	//Works but need to be stored in the letterGrdaes Array. Ask or look in textbook on how to write to do so. Maybe build the code as the grades are going so it says it?
		for (int i = 0; i < grades.length; i++) {
			if (grades[i] >= 90) {
				letterGrades[0] = 'A';
				System.out.println("A");
			}
			else if (grades[i] >= 80) {
				letterGrades[1] = 'B';
				System.out.println("B");
			}
			else if (grades[i] >= 70) {
				letterGrades[2] = 'C';
				System.out.println("C");
			}
			else if (grades[i] >= 60) {
				letterGrades[3] = 'D';
				System.out.println("D");
			}
			else if (grades[i] >= 50) {
				letterGrades[4] = 'F';
				System.out.println("F");
			}
		}
	}
	
	public static void displayGrades (int[] grades, char[] letterGrades) {
		// Displays a table with each student’s grade and letter grade 
		
		
		//Intro display
		System.out.println();
		System.out.println("Student" + "\t\t" + "Exam Grade" + "\t" + "Letter Grade");
		System.out.println("--------------------------------------------");
		
		//Fix letterGrade part
		for (int i = 0;i < grades.length;i++) {
			System.out.println((i + 1) + "\t\t" + grades[i] + "\t\t" + letterGrades[i]);
		}
	}
	
	public static void displayLetterGradeTotals (char [] letterGrades) {
		// Displays the total number of each letter grade
		System.out.println();
		for (int i = 0; i < letterGrades.length; i++) {
			int count = (char)(i + 'a');
			if (i == 'A')
				System.out.println(letterGrades[i] + " " + count);
			else
				System.out.println("Number of " + letterGrades[i] + "'s = " + count);
			}	
	}
}//Assignment #8
class Dog {
	private String name;					
	private String bark;	
							
	public Dog(String name, String bark) {
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

