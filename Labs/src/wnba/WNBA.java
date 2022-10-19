package wnba;

import java.io.*;
import java.util.*;

public class WNBA {

	private static final int EASTERN = 1;
	private static final int WESTERN = 2;
	private static final int COMBINED = 3;
	private static final int EXIT = 4;
	
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		printHeading();
		File file = getFile(input);
		
		if (checkIfFileExists(file, input)) {
			int choice = chooseOption(input);
			
			while (choice != 4) {
				printConferenceHeading(choice);
				
				choice = chooseOption(input);
			}
			
			printExit();
			
		} else {
			printFileError();
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
		boolean isValidChoice = false;
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
	
	
	private static void printConferenceHeading(int choice) {
		System.out.println();
		if (choice == EASTERN) {
			System.out.println("Standings for the Eastern Conference");
			
		} else if (choice == WESTERN) {
			System.out.println("Standings for the Western Conference");
			
		} else if (choice == COMBINED) {
			System.out.println("Combined Conference Standings");
		}
	}
	
	private static void printExit() {
		System.out.println();
		System.out.println("Thank you for using this program.");
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
	
	private static void printFileError() {
		System.out.println();
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
		System.out.print("Enter the number of your choice: ");
	}
	
	
	
}
