package storyteller;

import java.io.*;
import java.util.*;

public class App {
	
	private static final int FREQ_MIN = 0;
	private static final int FREQ_MAX = 10;
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		printHeading();
		HashMap<String, ArrayList<String>> dictionary = WordFileReader.readFile(askForFileName(input));
		/*
		for (String key : dictionary.keySet()) {
			System.out.println(key);
			for (int i = 0; i < dictionary.get(key).size(); i++) {
				System.out.print(dictionary.get(key).get(i) + "  ");
				
			}
			System.out.println();
			System.out.println();
		}
		*/
		boolean wantsAnotherStory = true;
		while (wantsAnotherStory) {
			int sentences = askForTotalSentences(input);
			printScale();
			double adjectives = askForAdjectives(input);
			double adverbs = askForAdverbs(input);
			double prepositions = askForPrepositions(input);
			
			Author author = new Author(dictionary, sentences, adjectives, adverbs, prepositions);
			author.printStory(sentences);
			
			System.out.println();
			wantsAnotherStory = askForAnotherStory(input);
		}
		
		printThankYouMessage();
	}

	
	private static String askForFileName(Scanner input) {											// asks user for name of file and returns it																		
		System.out.print("Enter the name of the word file: ");										// repeats if user enters invalid file name
		String fileName = input.nextLine();
		
		boolean validFile = false;
		do {
			try {
				
				
				Scanner fileScan = new Scanner(new File(fileName));
				fileScan.close();
				validFile = true;
					
			} catch (FileNotFoundException e) {														// in case file is not found
				printFileError();																	
			}
			
		} while (!validFile);													
		
		System.out.println();
		return fileName;
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
			
			if (choice > 0) {
				totalSentences = choice;
				validInput = true;
			
			} else {
				printInvalidInput();
			}
			
		} while (!validInput);
		
		input.nextLine();
		return totalSentences;
	}
	
	private static double askForAdjectives(Scanner input) {											// asks user for desired frequency of adjectives
		double adjectives = 0;																		// and returns it as a percentage
																									
		boolean validInput = false;
		do {
			System.out.print("  How frequently should adjectives be used? ");
			int choice = input.nextInt();
			
			if (choice >= FREQ_MIN && choice <= FREQ_MAX) {																		
				adjectives = Double.valueOf(choice) / 10;																
				validInput = true;
				
			} else {
				printInvalidInput(); 
			}
			
		} while (!validInput);
		
		input.nextLine();
		return adjectives;
	}
	
	private static double askForAdverbs(Scanner input) {											// asks user for desired frequency of adverbs
		double adverbs = 0;																			// and returns it as a percentage
																									
		boolean validInput = false;
		do {
			System.out.print("  How frequently should adverbs be used? ");
			int choice = input.nextInt();
			
			if (choice >= FREQ_MIN && choice <= FREQ_MAX) {															
				adverbs = Double.valueOf(choice) / 10;																	
				validInput = true;
				
			} else {
				printInvalidInput(); 
			}
			
		} while (!validInput);
		
		input.nextLine();
		return adverbs;
	}
	
	private static double askForPrepositions(Scanner input) {										// asks user for desired frequency of prepositions
		double prepositions = 0;																	// and returns it as a percentage
																									
		boolean validInput = false;
		do {
			System.out.print("  How frequently should prepositions be used? ");
			int choice = input.nextInt();
			
			if (choice >= FREQ_MIN && choice <= FREQ_MAX) {														
				prepositions = Double.valueOf(choice) / 10;																
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
		System.out.println(asterisks);
		System.out.println();
		
		System.out.println("Welcome to StoryTeller, a sophisticated electronic");
		System.out.println("author. This program reads from a list of words of");
		System.out.println("various parts of speech and creates a story from");
		System.out.println("them. You can tune the richness of the writing by");
		System.out.println("changing how frequently adjectives, adverbs, and");
		System.out.println("prepositions should be included.");
		System.out.println();
	}
	
	private static void printInvalidInput() {														// error message for when the user 
		System.out.println("That was an invalid choice. Please try again.");						// types a non-allowed response
		System.out.println();
	}
	
	private static void printFileError() {															// error message for when a file is
		System.out.println("That file was not found. Please try again.");							// not found
		System.out.println();
	}
	
	private static void printScale() {																
		System.out.println("On a scale of " + FREQ_MIN + " to " + FREQ_MAX + " ...");
	}
	
	private static void printThankYouMessage() {													// thank-you message for end of program
		System.out.println("Thank you for using StoryTeller!");
	}
}
