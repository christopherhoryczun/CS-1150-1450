// Solution Assignment #10 CS1150 Spring 2025
// Topic: Array of Objects and Object with an Array
//
// Note: 
// This solution code may not be copied, doing so will result in a grade of zero.
// This solution is not for distribution online or by any other means. Copyright M. Gonzalez UCCS

public class CS1150_Assignment10_Spring2025 {

	public static void main(String[] args) {
		
		// Student Note: I added a S25 to the Athlete class name and Team class name so it will 
		// not clash with your classes if you import the solution.  
		
		// Constant for number of athletes and max number of athletes allowed on the team
		final int NUM_ATHLETES = 9;
		final int MAX_NUM_ATHLETES = 8;
		
		// Create 9 athletes
		// STUDENT NOTE: 
		// We are hard coding here because first this would be a lot of information to enter
		// and second we have not yet learned how to read from a file.  Normally, this sort of
		// information would be placed into a file and we would read the information from the file.
		AthleteS25 athlete1 = new AthleteS25("Haley Anderson", 26);
		AthleteS25 athlete2 = new AthleteS25("Regan Smith", 2);
		AthleteS25 athlete3 = new AthleteS25("Katie Ledecky", 3);		
		AthleteS25 athlete4 = new AthleteS25("Ryan Murphy", 5);
		AthleteS25 athlete5 = new AthleteS25("Annie Lazor", 7);
		AthleteS25 athlete6 = new AthleteS25("Caeleb Dressel", 1);		
		AthleteS25 athlete7 = new AthleteS25("Katie Drabot", 6);
		AthleteS25 athlete8 = new AthleteS25("Luca Urlando", 3);
		AthleteS25 athlete9 = new AthleteS25("Ashley Twitchell", 12);

		// Part 1:
		// Create an array that holds athletes and place the athletes into the array
		AthleteS25[] athletes = new AthleteS25[NUM_ATHLETES];
		athletes[0] = athlete1;
		athletes[1] = athlete2;
		athletes[2] = athlete3;
		athletes[3] = athlete4;
		athletes[4] = athlete5;
		athletes[5] = athlete6;
		athletes[6] = athlete7;
		athletes[7] = athlete8;
		athletes[8] = athlete9;

		// Display the name and world ranking of the athletes in the array of athletes
		System.out.println();
		System.out.println("***************************************");
		System.out.println("Part 1: Athletes In Array");
		System.out.println("***************************************");
		System.out.println();
		System.out.println("Athlete\t\t\tWorld Ranking");
		System.out.println("---------------------------------------");
		for (int i = 0; i < athletes.length; i++) {
			System.out.printf("%-20s\t%d\n", athletes[i].getName(), athletes[i].getWorldRanking());
		}

		// Find the athlete with the highest world ranking in the array
		// Set the first athlete to the highest ranked to have a starting point to compare
		int highestRanked = athletes[0].getWorldRanking();
		int highestRankedIndex = 0;
		for (int i = 1; i < athletes.length; i++) {
			
			// Check if athlete's world ranking is higher (a smaller value) than the current highest ranking
			int worldRanking = athletes[i].getWorldRanking();
			if (worldRanking < highestRanked) {
				
				// Found a higher ranked athlete so update variables
				highestRanked = worldRanking;
				highestRankedIndex = i;
			}
		}
		
		// Display the name and world ranking of the athlete with the highest world ranking
		System.out.println();
		System.out.println("Highest ranking athlete in the array of athletes");
		System.out.println("-----------------------------------------------------------");
		System.out.println("Athlete: " + athletes[highestRankedIndex].getName()); 
		System.out.println("Ranking: " + athletes[highestRankedIndex].getWorldRanking());
		
		// Part 2:
		// Create a team object and add the athletes to the team.
		// STUDENT NOTE: The team object contains an array of athletes. This is a HAS-A relationship.
		// Instead of placing the athletes we created directly into an array as in Part 1, we now  
		// create a team object and "add" the athletes to the team using a method on the object.  
		// Under the covers, "inside the team class", the "add" method is adding the athletes to   
		// the array of athletes.  As the user of the Team, we don't care how the athletes are 
		// stored (i.e. what data structure they are stored in), we just use the methods provided to 
		// work with the team.
		TeamS25 swimTeamUsa = new TeamS25(MAX_NUM_ATHLETES);
	
		System.out.println();
		System.out.println();
		System.out.println("********************************************************");
		System.out.println("Part 2: Adding Athletes to Team Object");
		System.out.println("********************************************************");

		// First add all the athletes in the array using the addAthlete method that takes an 
		// athlete and if the team is not full, adds the athlete to the team.
		// Display result of each call indicating if adding the athlete was successfully added.
		boolean addSuccessful = false;
		for (int i = 0; i < athletes.length; i++) {
			AthleteS25 athlete = athletes[i];
			addSuccessful = swimTeamUsa.addAthlete(athlete);
			System.out.println("Was " + athlete.getName() + " added to the team? " + addSuccessful);
		}

		// Display the athletes on the team.
		// STUDENT NOTE: We are dealing with an object so we need to use the methods on the  
		// object to display the athletes.  The team object provides a method that displays all  
		// athletes - displayAthletes()
		swimTeamUsa.displayAthletes();

		// Next we want to find the highest ranking athlete on the team.
		// STUDENT NOTE: This is a bit different from when we had an array of athletes in part 1.
		// Now we have an object and inside the object is the array which is a private variable.  
		// Again we need to use the methods on the object to access the array. 
		// There is a findHighestRanked method that gives access to the highest ranked athlete in array.
		AthleteS25 highestRankedAthlete = swimTeamUsa.findHighestRankedAthlete();

		// Display the name and world ranking of the highest ranked athlete
		System.out.println();
		System.out.println("Highest ranked athlete in the team");
		System.out.println("-----------------------------------------");
		System.out.println("Athlete: " + highestRankedAthlete.getName()); 
		System.out.println("Ranking: " + highestRankedAthlete.getWorldRanking());		
	
	} // main
	
} // Assignment 10


//*** NOTE ***
//The Athlete class and the Team class are placed AFTER the end of the Assignment 10

//Represents one athlete.
class AthleteS25 {
	private String name;
	private int worldRanking;
	
	public AthleteS25(String name, int worldRanking) {
		this.name = name;
		this.worldRanking = worldRanking;
	}
	
	public String getName() {
		return name;
	}
	
	public int getWorldRanking () {
		return worldRanking;
	}

} // Athlete


//Represents one sports team.  A team has a list of athletes.
class TeamS25 {
	private AthleteS25[] athletes;
	private int currentNumAthletes;
	
	public TeamS25(int maxNumAthletes) {
		athletes = new AthleteS25[maxNumAthletes];
		currentNumAthletes = 0;
	}
		
	// Add the incoming athlete to the array of athletes in the next available 
	// location if there is room.  
	public boolean addAthlete(AthleteS25 athleteToAdd) {
		
		// The boolean is updated to true only when there is room in the array to add the athlete
		boolean successfullyAdded = false;

		// Ensure there is room in the array to add the athlete	
		if (currentNumAthletes < athletes.length) {
			athletes[currentNumAthletes] = athleteToAdd;
			currentNumAthletes++;		
			
			// Update the boolean to indicate athlete was successfully added
			successfullyAdded = true;
		}
		
		// Return boolean indicating if addition was successful
		return successfullyAdded;
	}	

	// Finds and returns the athlete with the highest world ranking
	public AthleteS25 findHighestRankedAthlete() {
		
		// Initialize the variables to keep track of the highest ranked athlete 
		// and that athlete's location in the array of athlete's.
		// Start off by setting the highest ranked to the 1st athlete in array
		double highestRanked = athletes[0].getWorldRanking();
		int highestRankedIndex = 0;
		for (int i = 1; i < currentNumAthletes; i++) {
			
			// Check if athlete's world ranking is higher (smaller value) than the current highest ranking
			int worldRanking = athletes[i].getWorldRanking();
			if (worldRanking < highestRanked) {
				highestRanked = worldRanking;				
				highestRankedIndex = i;
			}
		}

		// Return the highest ranked athlete in the array of athletes
		return athletes[highestRankedIndex];
	}
	
	// Display all athletes in the team's array
	public void displayAthletes() {
		
		// Display a header
		System.out.println();
		System.out.println();
		System.out.println("***************************************");
		System.out.println("        Athletes In Team Object");
		System.out.println("***************************************");
		System.out.println();
		System.out.println("Athlete\t\t\tWorld Ranking");
		System.out.println("---------------------------------------");

		// Iterate through the array and display the information for each athlete
		for (int i = 0; i < currentNumAthletes; i++) {
			AthleteS25 athlete = athletes[i];
			System.out.printf("%-20s\t%d\n", 
					 		    athlete.getName(), 
					 			athlete.getWorldRanking()); 
		}
		
	} // displayAthletes
	
} // Team

