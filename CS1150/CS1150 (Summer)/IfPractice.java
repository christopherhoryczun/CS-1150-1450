package CS1150;

import java.util.Scanner;

public class IfPractice {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		//Ask for the radius
		System.out.print("What is the radius of a circle: ");
		double radius = input.nextDouble();
		
		//If the radius is > 0
		if (radius > 0) {
			
			//Calculate the area
			double area = Math.PI * Math.pow(radius, 2);
			
			//Print the data
			System.out.print("The area of the circle is: ");
			System.out.printf("%.2f", area);
		}
		
		//If not then
		else {
			System.out.print("Radius is a negative number. Please Try again");
		}
		

	}//Main

}//IF Practice
