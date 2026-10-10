// Solution Assignment #5 CS1150 Spring 2025
// Topic: While loops and for loops
//
// Note: 
// This solution code may not be copied, doing so will result in a grade of zero.
// This solution is not for distribution online or by any other means. Copyright M. Gonzalez UCCS

import java.util.Scanner;

public class CS1150_Assignment5_Spring2025 {

	public static void main(String[] args) {
		
		int wordCount  = 0;		// Numbers of words entered
		int characterCount = 0;	// Number of characters in all words (not counting spaces) 
		int vowelCount = 0;		// Number of vowels in all words 
		int consonantCount = 0;	// Number of consonants in all words

		// Create a scanner object to perform console input
		Scanner input = new Scanner(System.in);

		// Prompt user for a list of strings that ends with the word "stop"
		System.out.print("Enter sequence of words ending with \"stop\": ");
		String word = input.next();
		
		// Initialize the smallest and largest counts and words to the first word read
		int smallestCharacterCount = word.length();
		int largestCharacterCount = word.length();
		String smallestWord = word;
		String largestWord = word;
		
		// Read through the list of words until the string "stop" is encountered
		while (!word.equals("stop")) {
			
			// Display word currently processing
			System.out.println();
			System.out.println("Processing word     " + word);
			wordCount++;
			
			// Display the first and last character in the word
			System.out.println("First character is  " + word.charAt(0));
			System.out.println("Last character is   " + word.charAt(word.length()-1));
			
			// Display the length (number of characters) of the word
			int charactersInWord = word.length();
			System.out.println("Length is           " + charactersInWord);
			
			// Add the number of characters in this word to the running total
			characterCount = characterCount + charactersInWord;

			// Determine if this word is the smallest examined so far
			if (charactersInWord < smallestCharacterCount) {
				smallestCharacterCount = charactersInWord;
				smallestWord = word;
			}
			
			// Determine if this word is the largest examined so far
			if (charactersInWord > largestCharacterCount) {
				largestCharacterCount = charactersInWord;
				largestWord = word;
			}
			
			// Determine the number of vowels and constants in the word
			for (int i = 0; i < word.length(); i ++) {
				
				// Get character at index i
				// Convert character to lower case 
				char currentChar = word.charAt(i);
				currentChar = Character.toLowerCase(currentChar);
				
				// Is this character a vowel
				if (currentChar == 'a' || currentChar == 'e' || currentChar == 'i' ||
					currentChar == 'o' || currentChar == 'u') {
				
					vowelCount++;
				}
				else if (Character.isLetter(currentChar)) {
					consonantCount++;
				}
			}
			
			// Read the next word in the sequence
			word = input.next();
			
		} // while word is not "stop"
		
		
		// Print the number of words, characters, vowels, constants.
		// Print the smallest and largest words
		if (wordCount == 0)
			System.out.println("No words were entered except \"stop\" ");
		else {
			System.out.println();
			System.out.println("Number of words      = " + wordCount);
			System.out.println("Number of characters = " + characterCount);
			System.out.println("Number of vowels     = " + vowelCount);
			System.out.println("Number of consonants = " + consonantCount);
			System.out.println("The smallest word    = " + smallestWord);
			System.out.println("The largest word     = " + largestWord);
		}

		input.close();

	} // main

} // Assignment 5
