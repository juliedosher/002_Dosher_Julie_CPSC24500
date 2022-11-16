package menagerie;

import java.util.*;

public class PetWriter {

	public static void writeToFile(String fileName, ArrayList<Pet> pets) {
		for (Pet pet : pets) {
			// TODO: write to file
		}
	}
	
													// TODO: sort by name 
	public static void printPets(ArrayList<Pet> pets) {								// prints all pets in a neatly formatted list
		System.out.println("Here is your list of pets:");
		for (Pet pet : pets) {
			System.out.print(String.format("%-10s", pet.getType()));
			System.out.print(String.format("%-12s", pet.getName()));
			System.out.print(String.format("%3s", pet.getAge()));
			System.out.println(String.format("%10.2f", pet.getWeight()));
			}
		System.out.println();
		}
}
