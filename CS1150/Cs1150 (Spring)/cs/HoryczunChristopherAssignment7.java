package cs;

/*Name: Christopher Horyczun
 * Class: CS1150 (M/W)
 * Due Date:March 12th,2025
 * Assignment: Assignment #7
 * Description: Write a program that allows the user to find the area of 3 shapes
 */

import java.util.Scanner;

public class HoryczunChristopherAssignment7 {

	
	public static void main(String[] args) {
		Scanner userInput = new Scanner(System.in);
		
		//Intro
		System.out.println("***********************************");
		System.out.println("  Welcome to the Geometry Program");
		System.out.println("***********************************");
		System.out.println();
		
		//ContinueComputing boolean code
		boolean computing = continueComputing(userInput);
		
		//Method code changer
		while (computing) {
		}
			int shape = getShape (userInput);
			switch (shape) {
			case 1:
				System.out.print("Enter the radius of the circle: ");
				double radius = userInput.nextDouble();
				double areaOfCircle = circleArea(radius);
				System.out.println(areaOfCircle);
				break;
			case 2:
				System.out.print("Enter the length from the center of a vertex: ");
				double length = userInput.nextDouble();
				double areaOfPentagon = pentagonArea(length);
				System.out.println(areaOfPentagon);
				break;
			case 3:
				System.out.print("Enter the length of a side: ");
				double side = userInput.nextDouble();
				double areaOfHexagon = hexagonArea(side);
				System.out.println(areaOfHexagon);
			}
			computing = continueComputing(userInput);}
		
		
	//}//Main
	
	public static boolean continueComputing(Scanner userInput) {
		
		//Compute Question
		System.out.print("Compute Area (Y/N)");
		String computeArea = userInput.next();
		
		//Invalid answer ( isn't Y/N)
		while (!computeArea.equals("Y") && !computeArea.equals("y") && !computeArea.equals("N") && !computeArea.equals("n")) {
			System.out.println(computeArea + " is not a valid entry - try again");
			computeArea = userInput.next();
		}
		if (computeArea.equals("y") && computeArea.equals("Y")) {
			return true;
		}
		else {
			return false;
		}
			
	}//continueComputing
	
	public static int getShape(Scanner userInput) {
		
		//The shapes asked/ Data statement
		System.out.println();
		System.out.println("Option   Shape");
		System.out.println("-------------------");
		System.out.println(" 1" + "\t" + "Circle");
		System.out.println(" 2" + "\t" + "Pentagon");
		System.out.println(" 3" + "\t" + "Hexagon");
		System.out.println();
		
		//Question
		System.out.print("Select shape to compute are for. Select 1,2, or 3:");
		int whichShape = userInput.nextInt();
		
		//If not #1-3
		while (whichShape <= 1 && whichShape >= 3) {
			System.out.println( whichShape + " is not a valid entry - try again");
			whichShape = userInput.nextInt();
		}
		
		return whichShape;
	}
	
	public static double circleArea(double radius) {
		//Area count
		double area = Math.PI * radius * radius;
		return area;
}
	
	
	public static double pentagonArea(double length) {
		//length Count
		double sideLength = 2 * length * Math.sin(Math.PI / 5);
		double vertex = (5 * sideLength * sideLength) / (4 * Math.tan(Math.PI / 5));
		return vertex;
	}
	
	
	public static double hexagonArea(double side) {
		//hexagon Count
		double Hexside = (6 * side * side)/ (4 * Math.tan(Math.PI / 6));
		return Hexside;
	}

}//Assignment 7
