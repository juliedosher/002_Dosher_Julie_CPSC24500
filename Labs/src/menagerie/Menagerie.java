package menagerie;

import java.io.*;
import java.util.*;

public class Menagerie {
	
	ArrayList<Pet> pets = new ArrayList<Pet>();
	
	public void playPetSimulator() {
		Scanner input = new Scanner(System.in);
		
		printHeading();
		int choice = 0;
		
		while (choice != 7) {
			printMenu();
			
			boolean validInput = false;
			while (!validInput) {
				choice = getChoice(input);
				
				switch (choice) {
					case 1:
						validInput = true;
						String type = getType(input);
						pets.add(getPet(input, type));
						break;
						
					case 2:
						validInput = true;
						printPets();
						break;
						
					case 3: 
						validInput = true;
						// TODO: write pets to file
						break;
						
					case 4:
						validInput = true;
						pets.clear();
						pets = PetReader.readFile(getFile(input));
						break;
						
					case 5:
						validInput = true;
						break;
						
					case 6:
						validInput = true;
						pets.clear();
						break;
					
					
					case 7:
						validInput = true;
						break;
						
					default:
						printInvalidInput();		
				}
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
	
	private String getFile(Scanner input) {
		String fileName = "";
		
		boolean validInput = false;
		while (!validInput) {
			System.out.print("Enter name of file to load: ");
			fileName = input.nextLine();
			
			try {
				Scanner fileScan = new Scanner(new File(fileName));
				fileScan.close();
				validInput = true;
				System.out.println("The pets were read from the file.");
				
			} catch (FileNotFoundException e) {
				printFileError();
			}
		}
		
		return fileName;
	}
	
	
	private void printHeading() {																		// printing functions:
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
	
	private void printPets() {																			// TODO: add spacing
		System.out.println("Here is your list of pets:");
		for (Pet pet : pets) {
			System.out.print(pet.getType());
			System.out.print(pet.getName());
			System.out.print(pet.getAge());
			System.out.println(pet.getWeight());
		}
	}
	
	private void printExit() {
		System.out.println("Thank you for using Menagerie. We hope you had fun.");
	}
	
	private void printInvalidInput() {
		System.out.println("Invalid input. Please try again.");
		System.out.println();
	}
	
	private static void printFileError() {
		System.out.println("ERROR: That file was not found.");
		System.out.println();
	}
}
