package wnba;

import java.util.*;

public class WNBA {

	public static void main(String[] args) {
		printHeading();

		
		
	}
	
	private static int chooseOption(Scanner input) {
		printOptions();
		boolean isValidChoice = false;
		int choice = 0;
		
		do {
			int userIn = input.nextInt();
			
			
		} while (!isValidChoice);
		
		
		
		
		return 0;
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

}
