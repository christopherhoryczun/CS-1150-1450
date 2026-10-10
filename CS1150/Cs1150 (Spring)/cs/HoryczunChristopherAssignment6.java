package cs;

/* Name: Christopher Horyczun
 * Class: CS1150
 * Due: March 5th, 2025
 * Description: Write a program to simulate a one pump self-service gas station. The gas station will provide 3 fuel types.
 * 	The code will display the fuel activity and display a receipt for each purchase. 
 * 	Code must keep track of total number of gallons sold and price. Must have a shut down code.
 */
import java.util.Scanner;

public class HoryczunChristopherAssignment6 {

	//Scanner
	static Scanner input = new Scanner(System.in);
	
	//Public String
	public static void main(String[] args) {
		
		//Double Code
		final double UNLEADED_FUEL = 3.50;
		final double MIDGRADE_FUEL = 3.65;
		final double DIESEL_FUEL = 3.43;
		
		//Intro Code
		System.out.println("**********************************");
		System.out.println("   Welcome to Gas Station 1150");
		System.out.println("**********************************");
		System.out.println();
		System.out.println("   Unleaded   Midgrade   Diesel");
		System.out.println("   $" + UNLEADED_FUEL + "\t      $" + MIDGRADE_FUEL + "\t $" + DIESEL_FUEL);
		System.out.println("----------------------------------");
		System.out.println();
		System.out.println("Insert Credit Card and Enter zip Code:");
		String zipCode = input.next();
		
		//Pump in service
		int randomMath = ((int) (Math.random() * 30));
		boolean pumpInService = true;
		while (pumpInService) {
			
			//isn't code 99
			while (!zipCode.equals("99")) {
				System.out.println("Please Wait ... Authorizing ... ... ...");
				System.out.println("Lift nozzle and Select Grade- Unleaded(1) or Midgrade(2) or Diesel(3)");
				String gasType = input.next();
				int sum = 0;
				
				//Unleaded Fuel
				while (gasType.equals("1")) {
					System.out.println("************** Fueling **************");
					for (int i= 1; i <= randomMath; i++ ) {
						sum = sum + 1;
						System.out.println("** " + (UNLEADED_FUEL * sum)  + "\t\t\t" + sum + " Gallons **");
					}//unleaded fuel end
					
					//Receipt
					System.out.println("----------------------------------"); 
					System.out.println("------------- Receipt ------------");
					System.out.println("----------------------------------");
					System.out.println("\t" + "Gallons:" + "\t" + (UNLEADED_FUEL * sum));
					System.out.println("\t" + "Price/Gallons:  " + sum);
					System.out.println();
					System.out.println("   Thank you for your Buisness!");
					System.out.println("----------------------------------");
				String noCrash = input.next(); }//DONT CRASH THE COMPUTER
				
				//Mid grade Fuel
				while (gasType.equals("2")) {
					System.out.println("************** Fueling **************");
					for (int i=1;i <= randomMath; i++) {
						sum = sum + 1;
						System.out.println("** " + (MIDGRADE_FUEL * sum)  + "\t\t\t" + sum + " Gallons **");
					}//mid grade fuel end
					
					//Receipt
					System.out.println("----------------------------------"); 
					System.out.println("------------- Receipt ------------");
					System.out.println("----------------------------------");
					System.out.println("\t" + "Gallons:" + "\t" + (MIDGRADE_FUEL * sum));
					System.out.println("\t" + "Price/Gallons:  " + sum);
					System.out.println();
					System.out.println("   Thank you for your Buisness!");
					System.out.println("----------------------------------");	
				String noCrash = input.next(); }//DONT CRASH THE COMPUTER
				
				//Diesel Fuel
				while (gasType.equals("3")) {
					System.out.println("************** Fueling **************");
					for (int i=1;i <= randomMath; i++) {
						sum = sum + 1;
						System.out.println("** " + (DIESEL_FUEL * sum)  + "\t\t\t" + sum + " Gallons **");
					}//Diesel fuel end
					
					//Receipt
					System.out.println("----------------------------------"); 
					System.out.println("------------- Receipt ------------");
					System.out.println("----------------------------------");
					System.out.println("\t" + "Gallons:" + "\t" + (DIESEL_FUEL * sum));
					System.out.println("\t" + "Price/Gallons:  " + sum);
					System.out.println();
					System.out.println("   Thank you for your Buisness!");
					System.out.println("----------------------------------");
				String noCrash = input.next(); }//DONT CRASH THE COMPUTER
				
			}//!99
			
			//99 Shutdown
			 while (zipCode.equals("99")) {
				System.out.println();
				System.out.println("Shutting Down...");
				System.out.println("Pump 17 was Successfully Shut Down");
				double totalGallons = ((UNLEADED_FUEL * randomMath) + (MIDGRADE_FUEL * randomMath) + (DIESEL_FUEL * randomMath));
				System.out.println("Total Gallons = " + totalGallons );
				double totalSales = (totalGallons / randomMath);
				System.out.println("Total Sales = " + totalSales );
				String noCrash = input.next();//DONT CRASH THE COMPUTER

			}//99 shutdown
			 
		}//while pump{

	}//end of code
	
}//Assignment 6