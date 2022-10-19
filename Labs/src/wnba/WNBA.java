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
		
		try {
			Scanner fileIn = new Scanner(file);
			System.out.println("The teams have been read.");
			
			String[] eastern = assignArrayValues(fileIn, EASTERN);
			String[] western = assignArrayValues(fileIn, WESTERN);
			String[] combined = combineArrays(eastern, western);
			
			int choice = chooseOption(input);
			while (choice != 4) {
				printConferenceData(choice, eastern);
					
				choice = chooseOption(input);
			}
				
			fileIn.close();
			printExit();	
	
				
		} catch (FileNotFoundException e) {
			printFileError();
			e.printStackTrace();
		}
	}	
		
	
	private static String[] assignArrayValues(Scanner fileScan, int choice) {					// creates an array for a single conference
		String[] arr = new String[CONFERENCE_SIZE];												// containing data from input file
		String headerToLookFor;
		
		if (choice == EASTERN) {
			headerToLookFor = "Conference: Eastern";
		} else {
			headerToLookFor = "Conference: Western";
		}
		
		while (fileScan.hasNextLine()) {
			
		}
		
		return arr;
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
	
	
	private static void printConferenceData(int choice, String[] conference) {					// prints appropriate conference data for  
		System.out.println();																	// whichever option was chosen
		if (choice == EASTERN) {
			System.out.println("Standings for the Eastern Conference");
			
		} else if (choice == WESTERN) {
			System.out.println("Standings for the Western Conference");
			
		} else if (choice == COMBINED) {
			System.out.println("Combined Conference Standings");
		}
		
		for (int i = 0; i < conference.length; i++) {
			System.out.println(conference[i]);
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
