package CS1150;

/*
 * Name: Christopher Horyczun
 * Class: CS1150 (M/W)
 * Due: July 6 2025
 * Description: Assignment #4
 * Write a program to create license plates for Colorado, Wyoming, and Utah. The program will prompt the user to enter two values - a character and a number.
 */

import java.util.Scanner;

public class HoryczunChristopherAssignment4 {
	
	static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		
		//Question
		System.out.println("Enter two characters for state and type of license plate");
		System.out.println("C: Colorado  W: Wyoming  U: Utah");
		System.out.println("1: Regular 2: Adopt a Pet 3: Fire Fighter");
		
		//Data saving
		String licensePlates = input.nextLine();
		char state = licensePlates.toUpperCase().charAt(0);
		char type = licensePlates.charAt(1);
		
		//Random letter generator
		char letter = (char) ('A' + (int)(Math.random() * 26));
		char letter1 = (char) ('A' + (int)(Math.random() * 26));
		char letter2 = (char) ('A' + (int)(Math.random() * 26));
		char letter4 = (char) ('A' + (int)(Math.random() * 26));
		
		//Value checking
		if ((state == 'C' || state == 'W' || state == 'U') && (type == '1' || type == '2' || type == '3')) {
			
			//If Colorado
			if (state == 'C') {
				System.out.print("Colorado" + "\s\s" + (int) (Math.random() * 999) + "-" + letter + letter1 + letter2);
			}
			
			//If Wyoming
			else if (state == 'W') {
				System.out.print("Wyoming" + "\s\s" + (int) (Math.random() * 9) + " " + (int) (Math.random() * 99999));
			}
			
			//If Utah
			else if (state == 'U') {
				System.out.print("Utah" + "\s\s" + letter + letter1 + letter2 + " " + (int) (Math.random() * 9) + letter4);
				
			}
			
			isThereAnAddOn(type);
		}
		
		//Invalid Data
		else {
			System.out.println("Invalid input for plate type");
			
		}//assignment 4
			
	}//Main
	
	private static void isThereAnAddOn(char type) {
		//if we are adding adopt a pet or fire fighter
		
		if (type == '2') {
			System.out.println(" --- Adopt a  Shelter Pet");
		}//Shelter Pet
		
		else if (type == '3') {
			System.out.println (" --- Fire Fighter");
		}//Fire Fighter
		
	}//isThereAnAddOn
	
}//Assignment 4
