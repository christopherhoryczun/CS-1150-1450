package cs;

/* Name: Christopher Horyczun
 * Class: CS 1150 (M/W)
 * Due: Feb. 19,2025
 * Description: Create a program to generate gift cards for three companies. Prompt the user to enter two values(Character and numbers).Program will display a random generated gift card based on data given.
 */
import java.util.Scanner;

public class HoryczunChristopherAssignment4 {

	public static void main(String[] args) {
		
		//Scanner
		Scanner input = new Scanner(System.in);
		
		//Double Code
		final double ONEGC_COST = 10.00;
		final double TWOGC_COST = 15.00;
		final double THREEGC_COST = 45.00;
		
		//Char Code
		final char SUBWAY = 'S';
		final char TACOBELL = 'T';
		final char WENDYS = 'W';
		final char TENDOLLAR = '1';
		final char FIFTHDOLLAR = '2';
		final char THREEFIFTHDOLLAR = '3';
		
		//ASCII Code
		char letter = 'A';
		
		//Intro Code
		System.out.println("Enter two Characters");
		System.out.println("S:Subway  T:Taco Bell  W:Wendy's");
		System.out.println("1:$10 Gift Card  2:$15 Gift Card  3:3-pk of $15 Gift Cards");
		
		String littleString = input.next();
		char giftCard = littleString.charAt(0);

		//SUBWAY
		if (giftCard ==SUBWAY) {
			System.out.print(SUBWAY + "       " + (int) (Math.random() * 999));
			System.out.println("-" + letter + letter + letter + "-" + (int)(Math.random() * 9999));
		}
		//TACOBELL
		else if (giftCard ==TACOBELL)
			System.out.println(TACOBELL + "       TB" + (int)(Math.random() * 9) + " " + (int)(Math.random()* 99) + " " + (int)(Math.random()* 999));
		//WENDYS
		else if (giftCard ==WENDYS) 
			System.out.println(letter + letter + letter + letter +(int)(Math.random() * 99) + letter + letter);
		//ERROR CODE
		else
			System.out.println("incorrect value");
		}
	}
