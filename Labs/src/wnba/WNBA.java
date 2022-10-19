package wnba;

import java.io.*;
import java.util.*;

public class WNBA {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		printHeading();
		File file = getFile(input);
		
		if (checkIfFileExists(file, input)) {
			// while loop
			
			
		} else {
			printExitMessage();
		}
			
	}	
		
		
	private static File getFile(Scanner input) {
		System.out.print("Enter the standings filename: ");
		String fileName = input.nextLine();
		File file = new File(fileName);
		
		return file;
	}
	
	private static boolean checkIfFileExists(File file, Scanner userInput) {
		boolean fileExists = false;
		
		try {
			Scanner scanFile = new Scanner(file);
			fileExists = true;
			System.out.println("The teams have been read.");
			
		} catch (FileNotFoundException e) {
			fileExists = false;
		}
		
		return fileExists;
	}
	
	private static int chooseOption(Scanner input) { 
		printOptions();
		boolean isValidChoice = false;
		int choice = 0;
		
		do {
			try {
				choice = input.nextInt();
			} catch (IllegalArgumentException e) {
				printInvalidInput();
			}
			
			if (choice >= 1 && choice <= 4) {
				isValidChoice = true;
			} else {
				printInvalidInput();
			}
			
		} while (!isValidChoice);
		
		return choice;
	}
	
	
	private static void printConferenceStandings(String conference, String[] conferenceStats) {
		System.out.println();
		if (conference.equals("east")) {
			System.out.println("Standings for the Eastern Conference");
		} else if (conference.equals("west")) {
			System.out.println("Standings for the Western Conference");
		} else {
			System.out.println("Combined Conference Standings");
		}
		
	}
	
	private static void printHeading() {
		String asterisks = "*".repeat(51);
		String header = "2022 WNBA STANDINGS";
		String space = " ".repeat((asterisks.length()-header.length())/2);
		header = space + header + space;
		
		System.out.println(asterisks);
		System.out.println(header);
		System.out.println(asterisks);
		System.out.println();
	}
	
	private static void printExitMessage() {
		System.out.println("File does not exist. Exiting program");
	}
	
	private static void printInvalidInput() {
		System.out.println();
		System.out.println("That is an invalid choice.");
		System.out.println();
	}
	
	private static void printOptions() {
		System.out.println("What would you like to see?");
		System.out.println("1. Eastern Conference");
		System.out.println("2. Western Conference");
		System.out.println("3. Combined");
		System.out.println("4. Exit");
		System.out.println("Enter the number of your choice: ");
	}
}
