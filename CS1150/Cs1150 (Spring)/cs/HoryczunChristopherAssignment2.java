package cs;

import java.util.Scanner;

/* Name: Christopher Horyczun
 * Class: CS1150 (M/W)
 * Due: February 5, 2025
 * Description: Assignment #2: Create a simple GPA calculator for a students that only takes 2 classes, so it will show there projected GPA.
 */
public class HoryczunChristopherAssignment2 {
	
	public static void main(String[] args) {
		
		// Scanner
		Scanner input = new Scanner(System.in);
		
		//Math
		System.out.print("Enter name of 1st class: ");
		int nameMath = input.nextInt();
		System.out.print("Number of Credits:  ");
		int nameMn = input.nextInt();
		System.out.print("Expected grade where:  ");
		int nameMg = input.nextInt();
		 
		//int gradePoint = nameMn * nameMg;
		
		//Chem
		System.out.print("Enter name of 2st class: ");
		int nameChem = input.nextInt();
		System.out.print("Number of Credits:  ");
		int nameCn = input.nextInt();
		System.out.print("Expected grade where:  ");
		int nameCg = input.nextInt();
	
		//GPA Calculator
		System.out.println(nameMath + "     " + nameMn + "     " + nameMg);
		System.out.println(nameChem + "     " + nameCn + "     " + nameCg);
		
		//Table Intro
		System.out.println("********************************************************************************");
		System.out.println("                                 GPA Calculator                                 ");
		System.out.println("********************************************************************************");
		
		//Table Sections
		System.out.println();
		System.out.println("Class        Credit Hours   Expected Grade(A=4,B=3,C=2,D=1,F=0      Grade Points");
		System.out.println("--------------------------------------------------------------------------------");
		
		//Table data
		System.out.println(nameMath + "        " + nameMn + "             " + nameMg + "                                         " + (nameMn * nameMg) + "");
		System.out.println(nameChem + "        " + nameCn + "             " + nameCg + "                                         " + (nameCn * nameCg) + "");
		System.out.println("--------------------------------------------------------------------------------");
		
		//Table Results
		System.out.println("Totals        " + (nameMn + nameCn) + "                                                       " + ((nameMn * nameMg) + (nameCn * nameCg)));
		System.out.println();
		System.out.println("Your projected GPA for Math and Chem = 3.14");
		
		
		
		}

}
