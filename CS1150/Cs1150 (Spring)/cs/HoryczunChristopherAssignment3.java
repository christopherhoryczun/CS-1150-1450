package cs;

import java.util.Scanner;


/* Name: Christopher Horyczun
 * Class: CS1150 (M/W)
 * Due: Feb. 12	2025 
 * Description: Create a simple airplane reservation program. The program will display: destination city, cost of flight, cost of baggage, and total cost of the trip.
 */ 

public class HoryczunChristopherAssignment3 {

	public static void main(String[] args) {
		
		// Scanner
		Scanner input = new Scanner(System.in);
		
		//Double City Code
		final double SYDNEY_FARE = 1450.00;
		final double LONDON_FARE = 1100.00;
		final double FRANKFURT_FARE = 1250.00;
		final double CANCUN_FARE = 500.00;
		final double CHECKBAG_COST = 25;
		final double CARRYON_COST = 35;
		
		//Table Title
		System.out.println("Welcome to CS1150 Airlines!");
		System.out.println();
		System.out.println("Option" + "\t" + "City" + "\t\t\t" + "Fare");
		System.out.println("-----------------------------------------");
		
		//Table Data
		System.out.println("1" + "\t" + "Sydney, Australia" + "\t" + "$1450.00");
		System.out.println("2" + "\t" + "London, England" + "\t\t" + "$1100.00");
		System.out.println("3" + "\t" + "Frankfurt, Germany" + "\t" + "$1250.00");
		System.out.println("4" + "\t" + "Cancun, Mexico" + "\t\t" + "$500.00");
		
		//Questions for Flight
		System.out.println();
		System.out.println("Select a destination City: 1, 2, 3, or 4:");
		int nameCity = input.nextInt();
		if (nameCity <=4) {
			System.out.println("How many bags do you want to check (0-3 bags, $25 per bag)?");
		}
			else {
				System.out.println("Not a valid response. Please run progem again, goodbye");
			}
				
			int nameCheckbag = input.nextInt();
				if (nameCheckbag <= 3) {
					System.out.println("How many bags do you want carry-on (0-1, $35 per bag)?");
				}
					else {
						System.out.println("Not a valid response. Please run progem again, goodbye");
					}
					int nameCarry = input.nextInt();
						if (nameCarry <= 1) {
							if (nameCity == 1) {
								System.out.println("-----------------------------------------");
								System.out.println("Flight to" + "\t" + "Sydney, Australia");
								System.out.println("Flight Cost" + "\t" + "$" + SYDNEY_FARE);
								System.out.println("Baggage Cost" + "\t" + "$" + ((nameCheckbag * CHECKBAG_COST) + (nameCarry * CARRYON_COST)));
								System.out.println("-----------------------------------------");
								System.out.println("Total Cost" + "\t" + "$" + (SYDNEY_FARE + (nameCheckbag * CHECKBAG_COST) + (nameCarry * CARRYON_COST)));
						//Sydney
								
							if (nameCity == 2) {
								System.out.println("-----------------------------------------");
								System.out.println("Flight to" + "\t" + "London,England");
								System.out.println("Flight Cost" + "\t" + "$" + LONDON_FARE);
								System.out.println("Baggage Cost" + "\t" + "$" + ((nameCheckbag * CHECKBAG_COST) + (nameCarry * CARRYON_COST)));
								System.out.println("-----------------------------------------");
								System.out.println("Total Cost" + "\t" + "$" + (LONDON_FARE + (nameCheckbag * CHECKBAG_COST) + (nameCarry * CARRYON_COST)));
						//London
								
							if (nameCity == 3) {
								System.out.println("-----------------------------------------");
								System.out.println("Flight to" + "\t" + "Frankfurt, Germany");
								System.out.println("Flight Cost" + "\t" + "$" + FRANKFURT_FARE);
								System.out.println("Baggage Cost" + "\t" + "$" + ((nameCheckbag * CHECKBAG_COST) + (nameCarry * CARRYON_COST)));
								System.out.println("-----------------------------------------");
								System.out.println("Total Cost" + "\t" + "$" + (FRANKFURT_FARE + (nameCheckbag * CHECKBAG_COST) + (nameCarry * CARRYON_COST)));
						//Frankfurt
								
							if (nameCity == 4) {
								System.out.println("-----------------------------------------");
								System.out.println("Flight to" + "\t" + "Cancun, Mexico");
								System.out.println("Flight Cost" + "\t" + "$" + CANCUN_FARE);
								System.out.println("Baggage Cost" + "\t" + "$" + ((nameCheckbag * CHECKBAG_COST) + (nameCarry * CARRYON_COST)));
								System.out.println("-----------------------------------------");
								System.out.println("Total Cost" + "\t" + "$" + (CANCUN_FARE + (nameCheckbag * CHECKBAG_COST) + (nameCarry * CARRYON_COST)));
						//Cancun
								
							}//Cancun end
							}//Frankfurt end
							}//London end
							}//Sydney end
					}//Carry on end
						else {// invalid CarryOn
							System.out.println("Not a valid response. Please run program again, goodbye");
						}
							
						}	
	}//Assignment 3
	

