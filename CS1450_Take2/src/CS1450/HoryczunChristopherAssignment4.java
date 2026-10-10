package CS1450;

/*
 * Name: Christopher Horyczun
 * Class Name: CS1450 (M/W)
 * Due Date: Feb 25th, 2026
 * Assignment #4
 * Description: We are writing a Java program that simulates a pinball machine by storing targets in a 2D playing field, tracking hits and score as the ball moves, and producing a final report that lists all targets sorted by number of hits.
 */

import java.io.*;
import java.util.*;

public class HoryczunChristopherAssignment4 {

	public static void main(String[] args) throws IOException {
		
		System.out.println("Set up targets n pinball machine...\n");
		
		//input files for pinball machine
		File targetFiles = new File ("PinballMachineTargets.txt");
		File playFile = new File ("Play.txt");
		
		//scanner
		Scanner input = new Scanner (targetFiles);
		
		//read the size of the field
		int numRow = input.nextInt();
		int numColumn = input.nextInt();
		
		//create the pinball machine using the number of row and scolumns
		PinballMachine pinballMachine = new PinballMachine(numRow, numColumn);
		
		//read and add targets to the playing field until the end of the file
		while (input.hasNext()) {
			
			//read the target info
			int row = input.nextInt();
			int column = input.nextInt();
			String type = input.next();
			int id = input.nextInt();
			int points = input.nextInt();
			
			//create a bew target using the data gathered
			Target target = new Target (type, id, points);
			
			//add the target to the pinball machine to given location
			pinballMachine.addTarget (row, column, target);
			
		}//end of while
		
		//close file
		input.close();
		
		//display the loading playing field
		pinballMachine.displayPlayingField();
		
		//simulate playing one game
		pinballMachine.play(playFile);
		
		//print report of all the targets
		printTargetsByHits(pinballMachine);
		
	}//main
	
	public static void printTargetsByHits(PinballMachine pinballMachine) {
		
		//store all targets in field
		ArrayList<Target> targets = new ArrayList<Target>();
		
		//loop every row in playing field
		for (int row = 0; row < pinballMachine.getNumRows(); row ++) {
			
			//loop every column in the playing field
			for (int col = 0; col < pinballMachine.getNumColumns(); col++) {
				
				//target at the current row and column
				Target currentTarget = pinballMachine.getTarget(row, col);
				
				// if there is a target at this location, add it to the list
				if (currentTarget != null) {
	            	targets.add(currentTarget);
	            }//end of if
	            
			}//end of for
			
		}//end of for
		
		// sort the targets from most hits to least hits
		Collections.sort(targets);
		
		// print the report header
		System.out.println();
		System.out.println("************************************************************************");
		System.out.println("\t\tPINBALL MACHINE TARGET HIT REPORT");
		System.out.println("\t\t(From Most Hits to Least Hits)");
		System.out.println("************************************************************************");
		System.out.println("Type\t\tId\tPoints\t\tNumber Hits");
		System.out.println("------------------------------------------------------------------------");

	    // print target in sorted order via toString
		for (int i = 0; i < targets.size(); i++) {
			System.out.println(targets.get(i).toString());
		}//end of for loop
		
	}//print target by hits
	
}//assignment 4

class PinballMachine {
	
	//private variables
	private int numRows;
	private int numColumns;
	private Target[][] playingField;
	
	//Constructor
	public PinballMachine(int numRows, int numColumns) {
		
		//size of the playing field
		this.numRows = numRows;
		this.numColumns = numColumns;
		
		// allocate memory for the 2D array inside the class
		playingField = new Target[numRows][numColumns];
    }//pinballMachine
	
	//Getters
	public int getNumRows() {
		return numRows;
	}//getNumRows
    
    public int getNumColumns() {
    	return numColumns;
    }//getNumColumns
    
    //get target location
    public void addTarget (int row, int column, Target target) {
    	playingField[row][column] = target;
    }//add Target
    
    // return target location
    public Target getTarget(int row, int column) {
    	return playingField[row][column];
    }//get Target
    
    // display the playing field in a formatted way
    public void displayPlayingField() {
    	System.out.print("\t");
    	
    	for (int col = 0; col < numColumns; col++) {
    		System.out.print("Column " + col + "\t");
    		}
    	System.out.println("\n");
    	
    	for (int row = 0; row < numRows; row++) {
    		System.out.print("Row " + row + "\t");
    		for (int col = 0; col < numColumns; col++) {
    			if (playingField[row][col] == null) {
    				System.out.print("-------\t");
    				System.out.print("\t");
    				} else {
    					// print only the target type
    					System.out.print(String.format("%-8s\t", playingField[row][col].getType()));
    					}//end of if
    			}//end of for
    		System.out.println();
    		}//end of for
    	
    	//print header
    	System.out.println("\n----------------------------------------------");
    	System.out.println("             Simulate Pinball Game");
    	System.out.println("----------------------------------------------");
    	System.out.println("Target Hit\tID\tPoints\t\tScore");
    	System.out.println("----------------------------------------------");
    }//displayPlayingField
    
    public void play(File playFileName) throws IOException {
    	Scanner input = new Scanner(playFileName);
    	int score = 0;
    	
    	// read ball position via file
    	while (input.hasNext()) {
    		int row = input.nextInt();
    		int column = input.nextInt();
    		
    		//Check if a target is at the current position
    		Target target = getTarget(row, column);
    		
    		if (target != null) {
    			
    			//Hit?
    			target.incrementHits();
    			
    			//Add points to score
    			score = score + target.getPoints();
    			
    			// display hit information
    			System.out.println(String.format("%-10s\t%d\t%d\t\t%d", target.getType(), target.getId(), target.getPoints(), score));
    		}//end of if
    	}//end of while
    	
    	// close the file
    	input.close();
    }//play
}//pinball Machine

class Target implements Comparable<Target> {
	
	//private Variables
	private String type;
	private int id;
	private int points;
	private int numTimesHit;
	
	//Constructor
	public Target(String type, int id, int points) {
		this.type = type;
		this.id = id;
		this.points = points;
		this.numTimesHit = 0;
	}//Target
	
	//Getters
	public String getType() {
		return type;
	}//get type
	public int getId() {
		return id;
	}//get id
	public int getPoints() {
		return points;
	}//get points
	public int getNumTimesHit() {
		return numTimesHit;
	}//get number times hits
	public void incrementHits() {
		numTimesHit = numTimesHit + 1;
	}
	
	//CompareTo
	public int compareTo(Target otherTarget) {
		
		if (this.numTimesHit > otherTarget.numTimesHit) {
			//this comes first
			return -1;
		} else if (this.numTimesHit < otherTarget.numTimesHit) {
			return 1;    // this target should come after
		} else {
			return 0;    // both targets have the same number of hits
		}
	}//compareTo

    //Return to string for report
	public String toString() {
		return String.format("%-10s\t%d\t%d\t\t%d", type, id, points, numTimesHit);
	}//toString
	
}//Target
