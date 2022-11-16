/*
 * Class that defines and handles the Menagerie game
 */

package menagerie;

import java.io.*;
import java.util.*;

public class Menagerie {
	
	ArrayList<Pet> pets = new ArrayList<Pet>();
	
	public void playPetSimulator() {
		Scanner input = new Scanner(System.in);
		
		Constants.printHeading();
		int choice = 0;
		
		while (choice != 7) {
			Constants.printMenu();
			
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
						Constants.printInvalidInput();		
				}
			}
		}
		
		Constants.printExit();
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
				Constants.printInvalidInput();
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
			if (choice.equals(Constants.DOG) || choice.equals(Constants.CAT) || choice.equals(Constants.FISH)) {
				type = choice;
				validInput = true;
			
			} else {
				Constants.printInvalidInput();
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
				Constants.printInvalidInput();
			}
			validInput = true;
		}
		
		switch (animalType) {
			case Constants.DOG:
				pet = new Dog(name, age, weight);
				break;
			case Constants.CAT:
				pet = new Cat(name, age, weight);
				break;
				
			case Constants.FISH:
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
				Constants.printFileError();
			}
		}
		
		return fileName;
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

}
