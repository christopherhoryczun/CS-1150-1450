package cs;

import java.lang.reflect.Array;
import java.util.Arrays;

/*Name: Christopher Horyczun
 * Class: CS1150 (M/W)
 * Due Date:April 16nd,2025
 * Assignment: Assignment #10
 * Description: This assignment provides the opportunity to work with an array of objects and an object that contains an array.
 * You will create several athlete objects and then perform two tasks:
 * Task 1: place the athlete objects into an array & perform manipulations on the array in main.  
 * Task 2: create one team object, place the athlete objects into the team, and perform similar manipulations on the array of athletes that are now in the team.
 */

public class HoryczunChristopherAssignment10 {

	public static void main(String[] args) {
		// Code to create each athlete object and the team object goes here
		
		//Each Athlete
		Athlete[] athlete = {
	            new Athlete ("Haley Anderson", 26),
	            new Athlete ("Regan Smith", 2),
	            new Athlete ("Katie Ledecky", 3),
	            new Athlete ("Ryan Murphy", 5),
	            new Athlete ("Annie Lazor", 7),
	            new Athlete ("Caeleb Dressel", 1),
	            new Athlete ("Katie Drabot", 6),
	            new Athlete ("Luca Urlando", 3),
	            new Athlete ("Ashley Twitchell", 12),
		};
		//Print Name
		System.out.println(Arrays.deepToString(athlete));
		Athlete highestRank = findHighestRanking(athlete);
		
		//highest Ranking Athlete
		if (highestRank != null) {
			System.out.println("The highest Rank " + highestRank);
		} else {
			System.out.println("hi");
		}
		Team team = new Team(8);
		 for (Athlete a : athlete) {
	            boolean added = team.addAthlete(a);
	            System.out.println("Adding " + a + ": " + (added ? "Success" : "Failed"));
	}//Main
}//Assignment #10
	private static Athlete findHighestRanking(Athlete[] athlete) {
		if (athlete == null || athlete.length == 0) {
			return null;
		}
		Athlete highestRank = athlete[0];
		for (int i = 1; i < athlete.length; i++) {
			if (athlete[i].getIntValue() > highestRank.getIntValue()) {
				highestRank = athlete[i];
			}
		}
		return highestRank;
	}

	class Athlete {
		private String name;
		private int worldRanking;
		public Athlete (String name, int worldRanking) {

			this.name = name;
			this.worldRanking = worldRanking;
		}
		public int getIntValue() {
			return 0;
		}
		public int getWorldRanking() {
			return 0;
		}
	}//Athlete
	
	class Team {
		private Athlete[] athletes;
		private int currentNumAthletes;
		public Team(int maxNumAthletes) {
			athletes = new Athlete[maxNumAthletes];
			currentNumAthletes = 0;
		}
		public boolean addAthlete(Athlete athlete) {
	        if (currentNumAthletes < athletes.length) {
	            athletes[currentNumAthletes] = athlete;
	            currentNumAthletes++;
	            return true;
	        } else {
	            return false;
	        }
	    }
		public Athlete findHighestRanked() {
			if (currentNumAthletes == 0) return null;

	        Athlete best = athletes[0];
	        for (int i = 1; i < currentNumAthletes; i++) {
	            if (athletes[i].getWorldRanking() < best.getWorldRanking()) {
	                best = athletes[i];
	            }
	        }
	        return best;
		    }
		}

		
	}//Team
