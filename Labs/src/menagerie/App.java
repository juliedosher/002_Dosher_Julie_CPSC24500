package menagerie;

import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		printHeading();
		printMenu();
		getPet(input);

	}

	
	private static int getChoice(Scanner input) {
		int choice = 0;
		
		boolean isValid = false;
		while (!isValid) {
			System.out.print("Enter the number of your choice: ");
			int num = input.nextInt();
			if (num >= 1 && num <= 7) {
				choice = num;
				isValid = true;
				
			} else {
				printInvalidInput();
			}
		}
		
		input.nextLine();
		return 0;
	}
	
	private static Pet getPet(Scanner input) {
		//Pet pet;
		String animal = "";
		String name = "";
		int age = 0;
		int weight = 0;
		
		boolean validInput = false;
		while (!validInput) {
			System.out.print("Enter d for dog, c for cat, or f for fish: ");
			String choice = input.nextLine();
			choice = choice.toLowerCase();
			if (choice.equals("d")) {
				animal = "dog";
				validInput = true;
				
			} else if (choice.equals("c")) {
				animal = "cat";
				validInput = true;
				
			} else if (choice.equals("f")) {
				animal = "fish";
				validInput = true;
				
			} else {
				printInvalidInput();
			}
		}
		
		validInput = false;
		while (!validInput) {
			System.out.print("Enter name, age, and weight: ");
			name = input.next();
			try {
				age = input.nextInt();
				weight = input.nextInt();
			} catch (Exception e) {
				printInvalidInput();
			}
			validInput = true;
		}
		
		System.out.println(name);
		System.out.println(age);
		System.out.println(weight);
		System.out.println(animal);
		
		return null;
	}
	
	private static void printHeading() {
		String asterisks = "*".repeat(60);
		String mainHeading = "Menagerie V1.0: The Pet Simulator";
		String space = " ".repeat((asterisks.length() - mainHeading.length()) / 2);
		
		System.out.println(asterisks);
		System.out.print(space);
		System.out.print(mainHeading);
		System.out.println(space);
		System.out.println(asterisks);
		System.out.println();
	}
	
	private static void printMenu() {
		System.out.println("What would you like to do?");
		System.out.println("1. Add a new pet.");
		System.out.println("2. Print list of pets.");
		System.out.println("3. Save pets to a file.");
		System.out.println("4. Load pets from a file.");
		System.out.println("5. Simulate a day in the life of your pets.");
		System.out.println("6. Clear your list of pets.");
		System.out.println("7. Exit");
	}
	
	private static void printInvalidInput() {
		System.out.println("Invalid input. Please try again.");
		System.out.println();
	}
	
}
