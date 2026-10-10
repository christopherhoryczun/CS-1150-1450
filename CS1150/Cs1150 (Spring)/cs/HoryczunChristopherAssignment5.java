package cs;

/*Name: Christopher Horyczun
 * Class: CS1150 (M/W)
 * Due:Feb 26th 2025
 * Description: Write a program that prompts the user for a unspecified number of words. With the condition that the statement must end with the word "stop" as the sentinel value. This code will be done using while loops and for loops
 */
//Scanner import
import java.util.Scanner;

public class HoryczunChristopherAssignment5 {

	static //Scanner
	Scanner input = new Scanner(System.in);
	
	//Start of Code
	public static void main(String[] args) {
		
		//Start
		System.out.print("Enter sequence of words ending with 'stop': ");
		String numStop = input.next();
		System.out.println();
		
		//if statement
		while (numStop.equals("stop")) {//while statement
			
				//word
				System.out.println("Processing word   " + "\t" + numStop);
				
				//First Character
				System.out.println("First Character   " + "\t" + numStop.charAt(0));
				
				//Last Character
				System.out.println("Last Charcter   " + "\t" + numStop.charAt(numStop.length()-1));
				
				//Length
				int length = numStop.length();
				System.out.println("Length is   " + "\t\t" + length);
				
				//Spacing
				System.out.println();
				
				//For loop for the second part
				for (int i = 1; i <10; i++); {//for loop
					
					//# of words
					int wordCount = numStop.split("\\s").length;
					System.out.println("Number of Words" + "\t\t=" + wordCount);
					
					//# of character
					System.out.println("Number of Characters" + "\t=" + length);
					
					//Vowels and Constants
					String vowels = "aeiouAEIOU";
				    int vowelCount = 0;
				    int constantCount = 0;
				    int i;
				    for(i = 0; i < numStop.length(); i += 1){
				        char thisChar = numStop.charAt(i);
				        int index;
				        for(index = 0; index < vowels.length(); index += 1){
				          if(vowels.charAt(index) == (thisChar)){
				            vowelCount++;
				          }else if(Character.isLetter(thisChar) && (vowels.charAt(index) == (thisChar))){
				        	 constantCount++;
				          }
				        }
				      }
						
					System.out.println("Number of Vowels" + "\t=" + vowelCount);//Vowels
					System.out.println("Number of Constants" + "\t=" + constantCount);//Constants
					
					//Small word
					String smallestWord = numStop;
					System.out.println("The smallest word" + "\t=" + smallestWord);
					
					//Larger word
					String largestWord = numStop;
					System.out.println("The largest word" + "\t=" + largestWord);
					
				}//for loop
				
			//DONT CRASH THE COMPUTER
			String noCrash = input.next();
			
			}//end of while statement
		while (!numStop.equals("stop")) {
			System.out.print("No words were entered except '" + numStop +"'");
			String noCrash = input.next();//DONT CRASH THE COMPUTER
			
		}//end of !while statement
		
		}//end of Code

}//Assignment 5
