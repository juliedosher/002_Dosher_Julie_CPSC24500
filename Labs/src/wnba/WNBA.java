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
				eastern = assignArrayValues(file, "Eastern");									// creates the three arrays 
				western = assignArrayValues(file, "Western");
				combined = combineArrays(eastern, western);	
			
			} catch (FileNotFoundException e) {													// if an invalid file has been entered
				printFileError();																// this should never be reached because there is 
			}																					// already a check for this elsewhere
			
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
			Scanner fileScan = new Scanner(file);
			System.out.println("The teams have been read.");
			fileExists = true;
			fileScan.close();
			
		} catch (FileNotFoundException e) {
			printFileError();																	// if file does not exist, the user is told so
		}
		
		return fileExists;
	}
	
	private static String[] combineArrays(String[] eastern, String[] western) {					// combines two conference arrays and
		String[] combined = new String[2 * CONFERENCE_SIZE];									// returns a single array with all data
		double[] eastPCT = getWinPercent(eastern);
		double[] westPCT = getWinPercent(western);
		
		int e = 0;		
		int w = 0;		
		int c = 0;		
		while (c < combined.length) {
			if (e == eastPCT.length) {															// if all eastern teams have already been added
				combined[c] = western[w];
				w++;
				
			} else if (w == westPCT.length) {													// if all western teams have already been added
				combined[c] = eastern[e];
				e++;
				
			} else if (westPCT[w] > eastPCT[e]) {												// if the next western team has a better PCT
				combined[c] = western[w];														// than the next eastern team
				w++;
				
			} else {																			// if the next eastern team has a better PCT
				combined[c] = eastern[e];														// than the next western team, 
				e++;																			// or if it is a tie between the two teams
			}
			
			c++;
		}
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
	
	private static double getLeadLosses(String[] conference) {
		double leadWins = 0;
		double leadLosses = 0;
		for (int i = 0; i < conference.length; i++) {
			String[] split = conference[i].split("\t");
			double wins = Double.valueOf(split[1]);
			double losses = Double.valueOf(split[2]);
			if (wins > leadWins) {
				leadWins = wins;
				leadLosses = losses;
			}
		}
		
		return leadLosses;
	}
	
	private static double getLeadWins(String[] conference) {
		double leadWins = 0;
		for (int i = 0; i < conference.length; i++) {
			String[] split = conference[i].split("\t");
			double wins = Double.valueOf(split[1]);
			if (wins > leadWins) {
				leadWins = wins;
			}
		}
		
		return leadWins;
	}
	
	private static double[] getWinPercent(String[] conference) {								// returns an array of every team's win percent
		double[] winPercents = new double[conference.length];
		
		for (int i = 0; i < conference.length; i++) {
			String[] split = conference[i].split("\t");
			double wins = Double.valueOf(split[1]);
			double losses = Double.valueOf(split[2]);
			winPercents[i] = wins / (wins + losses);
		}
		
		return winPercents;
	}
	
																								
	private static void printConferenceData(String[] conference) {								// prints data for the chosen conference
		System.out.print(String.format("%-20s","Team Name" ));
		System.out.print(String.format("%8s", "Wins"));
		System.out.print(String.format("%8s", "Losses"));
		System.out.print(String.format("%8s", "PCT"));
		System.out.println(String.format("%8s", "GB"));
		
		printFormattedData(conference);
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
	
	private static void printFormattedData(String[] conference) {								// prints each line from the String array
		double leadWins = getLeadWins(conference);												// with proper spacing
		double leadLosses = getLeadLosses(conference);
		
		for (int i = 0; i < conference.length; i++) {											
			String[] splitString = conference[i].split("\t");												
			
			String teamName = splitString[0];
			double wins = Double.valueOf(splitString[1]);
			Double losses = Double.valueOf(splitString[2]);
			double winPercentage = wins / (wins + losses);
			double gamesBehind = ((leadWins - wins) + (losses - leadLosses)) / 2;
			
			System.out.print(String.format("%-20s", teamName));
			System.out.print(String.format("%8.0f", wins));
			System.out.print(String.format("%8.0f", losses));
			System.out.print(String.format("%8.3f", winPercentage));
			
			if (gamesBehind == 0) {
				System.out.println("      - ");
			} else {
				System.out.println(String.format("%8.1f", gamesBehind));
			}
			
		}
		
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
