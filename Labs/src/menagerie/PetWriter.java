/*
 * Class that creates a .txt file and writes to it
 */

package menagerie;

import java.io.*;
import java.util.*;

public class PetWriter {

	public static String createFile(Scanner input) {								// takes in a String fileName and creates the file
		boolean validInput = false;
		String fileName = "";
		
		while (!validInput) {
			System.out.print("Enter name of file to save: ");
			fileName = input.nextLine();
			
			try {
			      File newFile = new File("filename.txt");
			      if (newFile.createNewFile()) {
			        validInput = true;
			     
			      } else {
			        Constants.printFileExistsError();
			      }
			      
			    } catch (IOException ex) {
			      Constants.printFileError();
			    }
		}
		
		return fileName;
	}
	
	public static void writeToFile(String fileName, ArrayList<Pet> pets) {			// adds current list of pets to a new file
		try {
			FileWriter petWriter = new FileWriter(fileName);
		     
			for (Pet pet : pets) {
				String newLine = pet.getType() + "\t" + pet.getName() + "\t";
				newLine += pet.getAge() + "\t" + String.format(".2f", pet.getWeight());
				petWriter.write(newLine);
			}
		     petWriter.close();
		     System.out.println("The pets were saved to the file.");
		     
		} catch (IOException ex) {													// should never happen since this is already
			Constants.printFileError();												// checked in createFile()
		}
	}
	
													
	public static void printPets(ArrayList<Pet> pets) {								// prints all pets in a neatly formatted list
		System.out.println("Here is your list of pets:");
		for (int i = 0; i < pets.size(); i++) {
			String type = pets.get(i).getType();
			String name = pets.get(i).getName();
			int age = pets.get(i).getAge();
			double weight = pets.get(i).getWeight();
			
			System.out.print(String.format("%-10s", type));
			System.out.print(String.format("%-12s", name));
			System.out.print(String.format("%3s", age));
			System.out.println(String.format("%10.2f", weight));
		}
		System.out.println();
		}
}
