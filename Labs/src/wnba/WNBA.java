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
		System.out.println("Enter the standings filename: ");
		String fileName = input.nextLine();
		File file = new File(fileName);
		
		return file;
	}
	
	private static boolean checkIfFileExists(File file, Scanner userInput) {
		boolean fileExists = false;
		
		try {
			Scanner scanFile = new Scanner(file);
			fileExists = true;
			
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
				System.out.println("\nThat is an invalid choice.\n");
			}
			
			if (choice >= 1 && choice <= 4) {
				isValidChoice = true;
			} else {
				System.out.println("\nThat is an invalid choice.\n");
			}
			
		} while (!isValidChoice);
		
		
		return choice;
	}
	
	
	private static void printHeading() {
		String asterisks = "*".repeat(51);
		String header = "2022 WNBA STANDINGS";
		String space = " ".repeat((asterisks.length()-header.length())/2);
		header = space + header + space;
		
		System.out.println(asterisks);
		System.out.println(header);
		System.out.println(asterisks);
	}
	
	private static void printOptions() {
		System.out.println("What would you like to see?");
		System.out.println("1. Eastern Conference");
		System.out.println("2. Western Conference");
		System.out.println("3. Combined");
		System.out.println("4. Exit");
	}

	private static void printExitMessage() {
		System.out.println("File does not exist. Exiting program");
	}
}
