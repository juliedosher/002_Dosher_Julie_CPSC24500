package wnba;

import java.io.*;
import java.util.*;

public class WNBA {

	private static final int EASTERN = 1;
	private static final int WESTERN = 2;
	private static final int COMBINED = 3;
	private static final int CONFERENCE_SIZE = 6;
	
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);										
		
		printHeading();
		File file = getFile(input);
		
		if (checkIfFileExists(file)) {															// if the inputted file exists, program continues
			String[] eastern = new String[CONFERENCE_SIZE];										// otherwise, it ends 
			String[] western = new String[CONFERENCE_SIZE];
			String[] combined = new String[2 * CONFERENCE_SIZE];
			
			try {
				eastern = assignArrayValues(file, "Eastern");
				western = assignArrayValues(file, "Western");
				combined = combineArrays(eastern, western);	
			} catch (FileNotFoundException e) {
				printFileError();
			}
			
			int choice = chooseOption(input);
			while (choice != 4) {																// repeats this block until user chooses to exit
				printConferenceHeading(choice);
				if (choice == EASTERN) {
					printConferenceData(eastern);
				} else if (choice == WESTERN) {
					printConferenceData(western);
				} else if (choice == COMBINED) {
					printConferenceData(combined);
				}
				
				choice = chooseOption(input);													
			}
				
			printExit();																		// once 4 is entered, the program ends	
		} 
	}	
		
	
	private static String[] assignArrayValues(File file, String conference) 					// creates an array for a single conference
			throws FileNotFoundException {														// containing data from input file
		
		Scanner fileScan = new Scanner(file);
		String[] arr = new String[CONFERENCE_SIZE];												
		
		while (fileScan.hasNextLine()) {
			if (fileScan.nextLine().contains(conference)) {										// tries to find specified conference
				String next = fileScan.nextLine();
		
				for (int i = 0; i < CONFERENCE_SIZE; i++) {
					arr[i] = next;
					if (fileScan.hasNextLine()) {
						next = fileScan.nextLine();
					}
				}	
			} 
		}
		
		fileScan.close();
		return arr;
	}
	
	private static boolean checkIfFileExists(File file) {										// checks if the inputted file exits
		boolean fileExists = false;																// and returns boolean value
		
		try {
			Scanner fileIn = new Scanner(file);
			System.out.println("The teams have been read.");
			fileExists = true;
			fileIn.close();
			
		} catch (FileNotFoundException e) {
			printFileError();																	// if file does not exist, the user is told so
		}
		
		return fileExists;
	}
	
	private static String[] combineArrays(String[] eastern, String[] western) {					// combines two conference arrays and
		String[] combined = new String[2 * CONFERENCE_SIZE];									// returns a single array with all data
		
		
		return combined;
	}
	
	private static int chooseOption(Scanner input) { 											// presents menu of options to user and 
		boolean isValidChoice = false;															// returns their choice as an int
		int choice = 0;
		
		do {
			printOptions();
			try {
				choice = input.nextInt();
				
			} catch (InputMismatchException e) {
				input.nextLine();
			}
			
			if (choice >= 1 && choice <= 4) {
				isValidChoice = true;
			} else {
				printInvalidInput();
			}
			
		} while (!isValidChoice);
		
		return choice;
	}
	
	private static File getFile(Scanner input) {												// asks user for file name and returns file object
		System.out.print("Enter the standings filename: ");
		String fileName = input.nextLine();
		File file = new File(fileName);
		
		return file;
	}
	
	
	private static void printConferenceData(String[] conference) {								// prints data for the chosen conference
		for (int i = 0; i < conference.length; i++) {
			System.out.println(conference[i]);
		}
		System.out.println();
	}
	
	private static void printConferenceHeading(int choice) {									// prints appropriate conference heading
		System.out.println();																	// for whichever option was chosen
		if (choice == EASTERN) {
			System.out.println("Standings for the Eastern Conference");
			
		} else if (choice == WESTERN) {
			System.out.println("Standings for the Western Conference");
			
		} else if (choice == COMBINED) {
			System.out.println("Combined Conference Standings");
		}
	}
	
	private static void printExit() {															// prints exit message for when user is done
		System.out.println();
		System.out.println("Thank you for using this program.");
	}
	
	private static void printHeading() {														// prints the heading for the program
		String asterisks = "*".repeat(51);
		String header = "2022 WNBA STANDINGS";
		String space = " ".repeat((asterisks.length()-header.length())/2);
		header = space + header + space;
		
		System.out.println(asterisks);
		System.out.println(header);
		System.out.println(asterisks);
		System.out.println();
	}
	
	private static void printFileError() {														// prints error message if file is not found
		System.out.println();
		System.out.println("File does not exist. Exiting program");
	}
	
	private static void printInvalidInput() {													// prints error message if user input is invalid
		System.out.println();
		System.out.println("That is an invalid choice.");
		System.out.println();
	}
	
	private static void printOptions() {														// prints option menu for user
		System.out.println("What would you like to see?");
		System.out.println("1. Eastern Conference");
		System.out.println("2. Western Conference");
		System.out.println("3. Combined");
		System.out.println("4. Exit");
		System.out.print("Enter the number of your choice: ");
	}
	
}
