package CS1150;
/*
 * Name: Christopher Horyczun
 * Class: CS1150 (M/W)
 * Due: June 11th 2025
 * Description: Assignment #1
 * Short about me section in part one and a table to show what a dollar would equal in Pesos, pounds and Euros
 */
public class HoryczunChristopherAssignment1 {

	public static void main(String[] args) {
		
	//Part 1 (About me section)
		
		System.out.println ("My name is Christopher Horyczun. I am working on a Computer Science degree. My favorite hobbies are drawing, running, and just being outside. I currently run distance for UCCS. I just started my second year of college.");
		System.out.println ("My favorite movie is Tim Burton's Batman. I know its an oldish movie, but I like it. I grew up watching classic westerns. I enjoy traveling to the South just because there is no internet where I go. I am passionate about being working on Computers.");
		
	//Part 2 (Display Output)
		
		//Intro table data
		System.out.println();
		System.out.println ("Dollars" + "\s\s" + "Pesos" + "\t\s" + "Pounds" + "\t" + " Euros");
		System.out.println("-------------------------------");
		
		//Table data
		double peso = 1 * 17.8;
		double pound = 1 * 0.79;
		double euro = 1 * 0.91;
		System.out.println("$" + (1 * 1) + "\t\s" + peso + "\t\s" + pound + "\t\s" + euro);
		System.out.println("$" + (1 * 10) + "\t\s" + (peso * 10) + "\t\s" + (pound * 10) + "\t\s" + (euro * 10));
		System.out.println("$" + (1 * 20) + "\t\s" + (peso * 20) + "\t\s" + (pound * 20) + "\t\s" + (euro * 20));
		System.out.println("$" + (1 * 100) + "\t\s" + (peso * 100) + "\t\s" + (pound * 100) + "\t\s" + (euro * 100));
		
	}//Main
	
}//Assignment 1
