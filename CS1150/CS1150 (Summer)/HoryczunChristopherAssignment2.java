package CS1150;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/*
 * Name: Christopher Horyczun
 * Class: CS1150 (M/W)
 * Due: June 16th 2025
 * Description: Assignment #2
 * Create a "Wind chill calculator" that determines the wind chill for 2 locations. Also this program will determine the difference between several values for these locations
*/


import java.io.IOException; //Apart of a test

public class HoryczunChristopherAssignment2 {

	public static void main(String[] args) throws IOException{
		
		// Scanner
		Scanner input = new Scanner(System.in);
		
		//Apart of test
		File fileName = new File("Assignment2.txt");
		PrintWriter resultsFile = new PrintWriter (fileName);
		
		//Finals
		final double EXPONTENT_CONSTANT = 0.16;
		
		
		//Location One
		System.out.println("Location #1 Information");
		System.out.println("--------------------------");
		System.out.print("Enter name of 1st Location: ");
		String locOneName = input.next();
		System.out.print("Enter the Wind Speed at 1st Location: ");
		double locOneWindSpeed = input.nextDouble();
		System.out.print("Enter the temp in Fahrenheit at 1st Location: ");
		double locOneTemp = input.nextDouble();
		
		//Location Two
		System.out.println();
		System.out.println("Location #2 Information");
		System.out.println("--------------------------");
		System.out.print("Enter name of 2st Location: ");
		String locTwoName = input.next();
		System.out.print("Enter the Wind Speed at 2st Location: ");
		double locTwoWindSpeed = input.nextDouble();
		System.out.print("Enter the temp in Fahrenheit at 2st Location: ");
		double locTwoTemp = input.nextDouble();
		
		//Table
		System.out.println();
		System.out.println("*********************************************************************");
		System.out.println("\t\t\t" + "Wind Chill Calculator");
		System.out.println("*********************************************************************");
		System.out.println();
		
		//Data inside table
		System.out.println("Location" + "\s\s\s\s" + "Wind Speed" + "\t" + "Temperature(F)" + "\t" + "Wind Chill(F)" + "\t" + "Temperature(C)" + "\t" + "Wind Chill(C)");
		System.out.println("--------------------------------------------------------------------------------------");
		
		//Location One Data
		double locOneCTemp = (locOneTemp - 32) * 5 / 9;
		double locOneFWindChill = 35.74 + (0.6215 * locOneTemp) - (35.75 * Math.pow(locOneWindSpeed, EXPONTENT_CONSTANT)) + (0.4275 * (locOneTemp * Math.pow(locOneWindSpeed, EXPONTENT_CONSTANT)));
		double locOneCWindChill = (locOneFWindChill - 32) * 5 / 9;
		
		//Location One Print Data
		System.out.print(locOneName);
		System.out.printf("\s\s\s\s%.2f", locOneWindSpeed);
		System.out.printf("\t%.2f", locOneTemp);
		System.out.printf ("\t\t%.2f", locOneFWindChill);
		System.out.printf("\t\t%.2f" ,locOneCTemp);
		System.out.printf("\t\t%.2f", locOneCWindChill);
		System.out.println();
		
		//Location Two Data
		double locTwoCTemp = (locTwoTemp - 32) * 5 / 9;
		double locTwoFWindChill = 35.74 + (0.6215 * locTwoTemp) - (35.75 * Math.pow(locTwoWindSpeed, EXPONTENT_CONSTANT)) + (0.4275 * (locTwoTemp * Math.pow(locTwoWindSpeed, EXPONTENT_CONSTANT)));
		double locTwoCWindChill = (locTwoFWindChill - 32) * 5 / 9;
		
		//Location Two Print Data
		System.out.print(locTwoName);
		System.out.printf("\s\s%.2f", locTwoWindSpeed);
		System.out.printf("\t%.2f", locTwoTemp);
		System.out.printf ("\t\t%.2f", locTwoFWindChill);
		System.out.printf("\t\t%.2f" ,locTwoCTemp);
		System.out.printf("\t\t%.2f", locTwoCWindChill);
		System.out.println();
		
		//Find the difference Print Data
		System.out.println("--------------------------------------------------------------------------------------");
		System.out.print("Differences");
		System.out.printf("\s\s\s%.2f", (locOneWindSpeed - locTwoWindSpeed));
		System.out.printf("\t%.2f", (locOneTemp - locTwoTemp));
		System.out.printf ("\t\t%.2f", (locOneFWindChill - locTwoFWindChill));
		System.out.printf("\t\t%.2f" , (locOneCTemp - locTwoCTemp));
		System.out.printf("\t\t%.2f", (locOneCWindChill - locTwoCWindChill));
		
		
		//NOT APART OF THE ASSIGNMENT!! DONT FORGOT TO DELETE WHEN TURNING THIS NEED!! EVERYTHING DOWN TO MAIN!!
		
		//Table
		resultsFile.println();
		resultsFile.println("*********************************************************************");
		resultsFile.println("\t\t\t" + "Wind Chill Calculator");
		resultsFile.println("*********************************************************************");
		resultsFile.println();
				
		//Data inside table
		resultsFile.println("Location" + "\s\s\s\s" + "Wind Speed" + "\t" + "Temperature(F)" + "\t" + "Wind Chill(F)" + "\t" + "Temperature(C)" + "\t" + "Wind Chill(C)");
		resultsFile.println("--------------------------------------------------------------------------------------");

		
		//Location One Print Data
		resultsFile.print(locOneName);
		resultsFile.printf("\s\s\s\s%.2f", locOneWindSpeed);
		resultsFile.printf("\t%.2f", locOneTemp);
		resultsFile.printf ("\t\t%.2f", locOneFWindChill);
		resultsFile.printf("\t\t%.2f" ,locOneCTemp);
		resultsFile.printf("\t\t%.2f", locOneCWindChill);
		resultsFile.println();
				
		resultsFile.print(locTwoName);
		resultsFile.printf("\s\s%.2f", locTwoWindSpeed);
		resultsFile.printf("\t%.2f", locTwoTemp);
		resultsFile.printf ("\t\t%.2f", locTwoFWindChill);
		resultsFile.printf("\t\t%.2f" ,locTwoCTemp);
		resultsFile.printf("\t\t%.2f", locTwoCWindChill);
		resultsFile.println();
		
		//Find the difference Print Data
		resultsFile.println("--------------------------------------------------------------------------------------");
		resultsFile.print("Differences");
		resultsFile.printf("\s\s\s%.2f", (locOneWindSpeed - locTwoWindSpeed));
		resultsFile.printf("\t%.2f", (locOneTemp - locTwoTemp));
		resultsFile.printf ("\t\t%.2f", (locOneFWindChill - locTwoFWindChill));
		resultsFile.printf("\t\t%.2f" , (locOneCTemp - locTwoCTemp));
		resultsFile.printf("\t\t%.2f", (locOneCWindChill - locTwoCWindChill));
		
		//close the file
		resultsFile.close();
		
	}//Main

}//Assignment 2
