package storyteller;

import java.io.*;
import java.util.*;

public class App {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
	
		boolean wantsAnotherStory = true;
		while (wantsAnotherStory) {
			int sentences = askForTotalSentences(input);
			int adjectives = askForAdjectives(input, sentences);
			int adverbs = askForAdverbs(input, sentences);
			int prepositions = askForPrepositions(input, sentences);
			
			
			System.out.println();
			wantsAnotherStory = askForAnotherStory(input);
		}
		
		printThankYouMessage();
	}

	
	private static boolean askForAnotherStory(Scanner input) {										// asks user if they want another story
		boolean wantsAnotherStory = false;															// and returns answer as a boolean
		
		boolean validInput = false;
		do {
			System.out.print("Would you like another story (y or n)? ");
			String choice = input.nextLine();
			choice = choice.toLowerCase();
			
			if (choice.equals("y")) {
				wantsAnotherStory = true;
				validInput = true;
				
			} else if (choice.equals("n")) {
				wantsAnotherStory = false;
				validInput = true;
				
			} else {
				printInvalidInput();
			}
			
		} while (!validInput);
		
		System.out.println();
		return wantsAnotherStory;
	}
	
	private static int askForTotalSentences(Scanner input) {										// asks user for desired number of sentences
		int totalSentences = 0;																		// and returns it
		
		boolean validInput = false;
		do {
			System.out.print("How many sentences would you like in your story? ");
			int choice = input.nextInt();
			
			if (choice > 0 && choice <= 10) {
				totalSentences = choice;
				validInput = true;
			
			} else {
				printInvalidInput();
			}
			
		} while (!validInput);
		
		input.nextLine();
		return totalSentences;
	}
	
	private static int askForAdjectives(Scanner input, int max) {									// asks user for desired frequency of adjectives
		int adjectives = 0;																			// and returns it
																									
		boolean validInput = false;
		do {
			System.out.print("How frequently should adjectives be used? ");
			int choice = input.nextInt();
			
			if (choice >= 0 && choice <= max) {														// checks that input is not above total number
				adjectives = choice;																// of sentences
				validInput = true;
				
			} else {
				printInvalidInput(); 
			}
			
		} while (!validInput);
		
		input.nextLine();
		return adjectives;
	}
	
	private static int askForAdverbs(Scanner input, int max) {										// asks user for desired frequency of adverbs
		int adverbs = 0;																			// and returns it
																									
		boolean validInput = false;
		do {
			System.out.print("How frequently should adverbs be used? ");
			int choice = input.nextInt();
			
			if (choice >= 0 && choice <= max) {														// checks that input is not above total number
				adverbs = choice;																	// of sentences
				validInput = true;
				
			} else {
				printInvalidInput(); 
			}
			
		} while (!validInput);
		
		input.nextLine();
		return adverbs;
	}
	
	private static int askForPrepositions(Scanner input, int max) {									// asks user for desired frequency of prepositions
		int prepositions = 0;																			// and returns it
																									
		boolean validInput = false;
		do {
			System.out.print("How frequently should prepositions be used? ");
			int choice = input.nextInt();
			
			if (choice >= 0 && choice <= max) {														// checks that input is not above total number
				prepositions = choice;																// of sentences
				validInput = true;
				
			} else {
				printInvalidInput(); 
			}
			
		} while (!validInput);
		
		input.nextLine();
		return prepositions;
	}

	
	private static void printHeading() {															// prints the heading of the program
		String asterisks = "*".repeat(51);
		String mainHeading = "STORYTELLER V1.0";
		String space = " ".repeat((asterisks.length() - mainHeading.length()) /2);
		
		System.out.println(asterisks);
		System.out.print(space);
		System.out.print(mainHeading);
		System.out.println(space);
		System.out.println();
		
		System.out.println("Welcome to StoryTeller, a sophisticated electronic");
		System.out.println("author. This program reads from a list of words of");
		System.out.println("various parts of speech and creates a story from");
		System.out.println("them. You can tune the richness of the writing by");
		System.out.println("changing how frequently adjectives, adverbs, and");
		System.out.println("prepositions should be included.");
	}
	
	private static void printInvalidInput() {														// error message for when the user 
		System.out.println("That was an invalid choice. Please try again.");						// types a non-allowed response
		System.out.println();
	}
	
	private static void printThankYouMessage() {													// thank-you message for end of program
		System.out.println("Thank you for using StoryTeller!");
	}
}
