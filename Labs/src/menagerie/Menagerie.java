package menagerie;

import java.util.Scanner;

public class Menagerie {
	
	public void playPetSimulator() {
		Scanner input = new Scanner(System.in);
		
		printHeading();
		int choice = 0;
		
		while (choice != 7) {
			boolean validInput = false;
			while (!validInput) {
				
				
				
			}
		}
		
		
		printExit();
	}
	
	
	private int getChoice(Scanner input) {
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
		return choice;
	}
	
	private String getType(Scanner input) {
		String type = "";
		
		boolean validInput = false;
		while (!validInput) {
			System.out.print("Enter d for dog, c for cat, or f for fish: ");
			String choice = input.nextLine();
			choice = choice.toLowerCase();
			if (choice.equals("d")) {
				type = "dog";
				validInput = true;
				
			} else if (choice.equals("c")) {
				type = "cat";
				validInput = true;
				
			} else if (choice.equals("f")) {
				type = "fish";
				validInput = true;
				
			} else {
				printInvalidInput();
			}
		}
		
		return type;
	}
	
	private Pet getPet(Scanner input, String animalType) {
		Pet pet;
		String name = "";
		int age = 0;
		double weight = 0;
		
		boolean validInput = false;
		while (!validInput) {
			System.out.print("Enter name, age, and weight: ");
			name = input.next();
			try {
				age = input.nextInt();
				weight = input.nextDouble();
			} catch (Exception e) {
				printInvalidInput();
			}
			validInput = true;
		}
		
		switch (animalType) {
			case "dog":
				pet = new Dog(name, age, weight);
				break;
			case "cat":
				pet = new Cat(name, age, weight);
				break;
				
			case "fish":
			default:																					// default should never be triggered
				pet = new Fish(name, age, weight);
				break;
		}
		
		return pet;
	}
	
	private void printHeading() {
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
	
	private void printMenu() {
		System.out.println("What would you like to do?");
		System.out.println("1. Add a new pet.");
		System.out.println("2. Print list of pets.");
		System.out.println("3. Save pets to a file.");
		System.out.println("4. Load pets from a file.");
		System.out.println("5. Simulate a day in the life of your pets.");
		System.out.println("6. Clear your list of pets.");
		System.out.println("7. Exit");
	}
	
	private void printExit() {
		System.out.println("Thank you for using Menagerie. We hope you had fun.");
	}
	
	private void printInvalidInput() {
		System.out.println("Invalid input. Please try again.");
		System.out.println();
	}
}
