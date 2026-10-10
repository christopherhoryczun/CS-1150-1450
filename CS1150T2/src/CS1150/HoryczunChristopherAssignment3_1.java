package CS1150;

/*
 * Name: Christopher Horyczun
 * Class: CS1150 (M/W)
 * Due: June 25th 2025
 * Description: Assignment #3
 * Create a simple Fitness Gym that allows the user to select a membership, and possible add-ons, and view the view the final cost
 * Note: I didn't like the title for the gym so I changed it.
 */

import java.util.Scanner;

public class HoryczunChristopherAssignment3_1 {

	static Scanner input = new Scanner(System.in);
	
	//Constants
	final static double NO_ADDON = 0.00;
	final static double CHILDCARE_ADDON = 5.00;
	final static double PERSONAL_TRAINING_ADDON = 20.00;
	final static double CHILDCARE_PERSONAL_TRAINING_ADDON = 25.00;
	final static double PLATINUM_MEMBERSHIP = 29.99;
	final static double GOLD_MEMBERSHIP = 19.99;
	final static double BASIC_MEMBERSHIP = 9.99;
	
	public static void main(String[] args) {
		
		final double ENROLLMENT_FEE = 20.00;
					
		//Title
		System.out.println("Colorado Fitness  & Childcare");
		System.out.println();
			
		//MemberShip Table
		System.out.println("Option" + "\t" + "Membership" + "\t" + "Monthly Cost");
		System.out.println("---------------------------------------");
		System.out.println("1" + "\t" + "Platnium" + "\t$" + PLATINUM_MEMBERSHIP);
		System.out.println("2" + "\t" + "Gold" + "\t\t$" + GOLD_MEMBERSHIP);
		System.out.println("3" + "\t" + "Basic" + "\t\t$" + BASIC_MEMBERSHIP);
		
		//Select a Membership
		System.out.println();
		System.out.println("Select a membership: 1, 2, or 3: ");
		int selectedMembership = input.nextInt();
		
		
		if (selectedMembership >= 1 && selectedMembership <= 3) {
			int selectedAddOn = findTheAddOn(selectedMembership);
			
			if ((selectedAddOn >= 1) && (selectedAddOn <= 4)) {
				System.out.println();
				System.out.println("-------------------------------");
				System.out.println("Monthly Cost");
				System.out.println("-------------------------------");
				
				//Build the Recipt for the Gym
				if (selectedMembership == 1) {
					platniumMember(ENROLLMENT_FEE, selectedAddOn);
				}
				else if (selectedMembership == 2) {
					goldMember(ENROLLMENT_FEE, selectedAddOn);
				}
				else if (selectedMembership == 3) {
					basicMember(ENROLLMENT_FEE, selectedAddOn);
				}
			}
			
			else {
				System.out.println(selectedAddOn + " is not a valid Add-on. Bye!");
			}//Invalid add on
			
		}//selected Membership
		
		else {
			System.out.println(selectedMembership + " is not a valid membership. Bye!");
		}//Invalid Membership
		
	}//Main
	

	private static void platniumMember(double ENROLLMENT_FEE,int selectedAddOn) {
		
		System.out.println("Platnium Membership" + "\t$"+ PLATINUM_MEMBERSHIP);
		repeatingOneTimeCost();
		
		if (selectedAddOn == 1) {
			double totalCost = PLATINUM_MEMBERSHIP + NO_ADDON + ENROLLMENT_FEE;
			System.out.print("No Add On");
			System.out.printf("\t\t$%.2f", NO_ADDON);
			ReapeatedTotalCost(ENROLLMENT_FEE);
			System.out.printf("\t\t%.2f", totalCost);
			}//no add on
			
		else if (selectedAddOn == 2) {
			double totalCost = PLATINUM_MEMBERSHIP + CHILDCARE_ADDON + ENROLLMENT_FEE;
			System.out.print("Childcare");
			System.out.printf("\t\t$%.2f", CHILDCARE_ADDON);
			ReapeatedTotalCost(ENROLLMENT_FEE);
			System.out.printf("\t\t%.2f", totalCost);
		}//child care only
		
		else if (selectedAddOn == 3) {
			double totalCost = PLATINUM_MEMBERSHIP + PERSONAL_TRAINING_ADDON + ENROLLMENT_FEE;
			System.out.print("Personal Training");
			System.out.printf("\t$%.2f", PERSONAL_TRAINING_ADDON);
			ReapeatedTotalCost(ENROLLMENT_FEE);
			System.out.printf("\t\t%.2f", totalCost);
		}//personal training only
		
		else if (selectedAddOn == 4) {
			double totalCost = PLATINUM_MEMBERSHIP + CHILDCARE_PERSONAL_TRAINING_ADDON + ENROLLMENT_FEE;
			System.out.println("Personal Training");
			System.out.print("with Childcare");
			System.out.printf("\t\t$%.2f", CHILDCARE_PERSONAL_TRAINING_ADDON);
			ReapeatedTotalCost(ENROLLMENT_FEE);
			System.out.printf("\t\t%.2f", totalCost);
			}//personal training and child care
		
		}//platniumMember
	
	private static void goldMember(double ENROLLMENT_FEE, int selectedAddOn) {
		System.out.println("Gold Membership" + "\t\t$"+ GOLD_MEMBERSHIP);
		repeatingOneTimeCost();
		
		if (selectedAddOn == 1) {
			double totalCost = GOLD_MEMBERSHIP + NO_ADDON + ENROLLMENT_FEE;
			System.out.print("No Add On");
			System.out.printf("\t\t$%.2f", NO_ADDON);
			ReapeatedTotalCost(ENROLLMENT_FEE);
			System.out.printf("\t\t%.2f", totalCost);
		}//no add on
		
		else if (selectedAddOn == 2) {
			double totalCost = GOLD_MEMBERSHIP + CHILDCARE_ADDON + ENROLLMENT_FEE;
			System.out.print("Childcare");
			System.out.printf("\t\t$%.2f", CHILDCARE_ADDON);
			ReapeatedTotalCost(ENROLLMENT_FEE);
			System.out.printf("\t\t%.2f", totalCost);
		}//child care only
		
		else if (selectedAddOn == 3) {
			double totalCost = GOLD_MEMBERSHIP + PERSONAL_TRAINING_ADDON + ENROLLMENT_FEE;
			System.out.print("Personal Training");
			System.out.printf("\t$%.2f", PERSONAL_TRAINING_ADDON);
			ReapeatedTotalCost(ENROLLMENT_FEE);
			System.out.printf("\t\t%.2f", totalCost);
		}//personal training only
		
		else if (selectedAddOn == 4) {
			double totalCost = GOLD_MEMBERSHIP + CHILDCARE_PERSONAL_TRAINING_ADDON + ENROLLMENT_FEE;
			System.out.println("Personal Training");
			System.out.print("with Childcare");
			System.out.printf("\t\t$%.2f", CHILDCARE_PERSONAL_TRAINING_ADDON);
			ReapeatedTotalCost(ENROLLMENT_FEE);
			System.out.printf("\t\t%.2f", totalCost);
		}//personal training and child care
		
	}//goldMember
	
	private static void basicMember(double ENROLLMENT_FEE, int selectedAddOn) {
		System.out.println("Basic Membership" + "\t$"+ BASIC_MEMBERSHIP);
		repeatingOneTimeCost();
		
		if (selectedAddOn == 1) {
			double totalCost = BASIC_MEMBERSHIP + NO_ADDON + ENROLLMENT_FEE;
			System.out.print("No Add On");
			System.out.printf("\t\t$%.2f", NO_ADDON);
			ReapeatedTotalCost(ENROLLMENT_FEE);
			System.out.printf("\t\t%.2f", totalCost);
		}//no add on
		
		else if (selectedAddOn == 2) {
			double totalCost = BASIC_MEMBERSHIP + CHILDCARE_ADDON + ENROLLMENT_FEE;
			System.out.print("Childcare");
			System.out.printf("\t\t$%.2f", CHILDCARE_ADDON);
			ReapeatedTotalCost(ENROLLMENT_FEE);
			System.out.printf("\t\t%.2f", totalCost);
		}//child care only
		
		else if (selectedAddOn == 3) {
			double totalCost = BASIC_MEMBERSHIP + PERSONAL_TRAINING_ADDON + ENROLLMENT_FEE;
			System.out.print("Personal Training");
			System.out.printf("\t$%.2f", PERSONAL_TRAINING_ADDON);
			ReapeatedTotalCost(ENROLLMENT_FEE);
			System.out.printf("\t\t%.2f", totalCost);
		}//personal training only
		
		else if (selectedAddOn == 4) {
			double totalCost = BASIC_MEMBERSHIP + CHILDCARE_PERSONAL_TRAINING_ADDON + ENROLLMENT_FEE;
			System.out.println("Personal Training");
			System.out.print("with Childcare");
			System.out.printf("\t\t$%.2f", CHILDCARE_PERSONAL_TRAINING_ADDON);
			ReapeatedTotalCost(ENROLLMENT_FEE);
			System.out.printf("\t\t%.2f", totalCost);
		}//personal training and child care
		
	}//basicMember

	private static void ReapeatedTotalCost(double ENROLLMENT_FEE) {
		//Removing some repeating Code
		System.out.println();
		System.out.print("Enrollment Fee");
		System.out.printf("\t\t$%.2f", ENROLLMENT_FEE);
		System.out.println();
		System.out.println();
		System.out.println("-------------------------------");
		System.out.println("Due Today");
		System.out.println("-------------------------------");
		System.out.print("Total Cost");
		return;
		
	}//ReapeatedTotalCost

	private static int findTheAddOn(int selectedMembership) {
		
		//Add On Table
		System.out.println();
		System.out.println("Option" + "\t" + "Add-On" + "\t\t\t\t\t" + "Price");
		System.out.println("-------------------------------------------------------");
		System.out.println("1" + "\t" + "No Add On" + "\t\t\t\t$" + NO_ADDON + "0");
		System.out.println("2" + "\t" + "Childcare" + "\t\t\t\t$" + CHILDCARE_ADDON + "0");
		System.out.println("3" + "\t" + "Personal Training" + "\t\t\t$" + PERSONAL_TRAINING_ADDON + "0");
		System.out.println("4" + "\t" + "Personal Training with Childcare" + "\t$" + CHILDCARE_PERSONAL_TRAINING_ADDON + "0");
		
		//Select an Add ON
		System.out.println ();
		System.out.println("Select an add-on: ");
		int selectedAddOn = input.nextInt();
		
		return selectedAddOn;
		
	}//findTheAddOn
	
	private static void repeatingOneTimeCost() {
		//Removing some repeating Code
		System.out.println();
		System.out.println("-------------------------------");
		System.out.println("One Time Cost");
		System.out.println("-------------------------------");
		return;
		
	}//repeatingOneTimeCost

}//Assignment 3