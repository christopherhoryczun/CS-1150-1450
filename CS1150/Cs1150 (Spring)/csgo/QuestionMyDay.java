package csgo;

import java.io.DataInput;
import java.util.Scanner;

public class QuestionMyDay {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		// TODO Auto-generated method stub
		System.out.println("Question comes from Assignment 8");
		
		int[] grades = {70, 62, 55, 57, 68, 92, 88, 87, 78, 97};
		char[] letterGrades = {'A', 'B', 'C', 'D', 'F', 'a', 'b', 'c', 'd', 'f'};
		int score = 59;
		
		
		int highestGrade = findHighestGrade (grades);
		double gradeAverage = computeAverage(grades);
		
		System.out.println(highestGrade);
		System.out.println(gradeAverage);
		
		computeLetterGrades(grades, letterGrades, highestGrade);
		displayGrades(grades,letterGrades);
		displayLetterGradeTotals(letterGrades);
		
		

	}//Main

	private static void displayLetterGradeTotals(char[] letterGrades) {
		System.out.println("1");
		
	}

	private static void displayGrades(int[] grades, char[] letterGrades) {
		
		for (int i = 0; i < grades.length; i++) {
			if (grades[i] >= 90) {
				letterGrades[0] = 'A';
				System.out.println("A");
				}
			else if (grades[i] >= 80) {
				letterGrades[0] = 'B';
				System.out.println("B");
				}
			else if (grades[i] >= 70) {
				letterGrades[0] = 'C';
				System.out.println("C");
				}
			else if (grades[i] >= 60) {
				letterGrades[0] = 'D';
				System.out.println("B");
				}
		}
	}

	private static void computeLetterGrades(int[] grades, char[] letterGrades, int highestGrade) {
		System.out.println("1");
		
	}

	private static double computeAverage(int[] grades) {
		
		if (grades == null || grades.length == 0) {
			return 0;
		}
		double gradeAverage = 0;
		for (int number : grades) {
			gradeAverage += number;
		}
		
		return gradeAverage/grades.length;
	}

	private static int findHighestGrade(int[] grades) {
		int grade = grades[0];
		
		for (int i = 0; i < grades.length; i++) {
			if (grades[i] > grade) {
				grade = grades[i];
			}
		}
		
		return grade;
	}
	
}//End of class
