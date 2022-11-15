package menagerie;

import java.io.*;
import java.util.*;

public class PetReader {

	public static ArrayList<Pet> readFile(String fileName) {										// reads .txt file and returns an
		ArrayList<Pet> pets = new ArrayList<Pet>();													// ArrayList of pets
		
		try {
			String type = "";
			String name = "";
			int age = 0;
			double weight = 0;
			
			Scanner fileScan = new Scanner(new File(fileName));
				
			while (fileScan.hasNextLine()) {														// gets info from file one line at
				String[] split = fileScan.nextLine().split("\t");									// a time
				type = split[0];										
				name = split[1];
				age = Integer.parseInt(split[2]);
				weight = Double.parseDouble(split[3]);
				
				switch (type) {																		// creates new pet object depending on
					case "dog":																		// pet type
						Dog newDog = new Dog(name, age, weight);
						pets.add(newDog);
						break;
						
					case "cat":
						Cat newCat = new Cat(name, age, weight);
						pets.add(newCat);
						break;
						
					case "fish":
						Fish newFish = new Fish(name, age, weight);
						pets.add(newFish);
						break;
				}
			}
			fileScan.close();
			
		} catch (FileNotFoundException e) {															// should never be used because this
			printFileError();																		// is already checked in Menagerie.java
		}
	
		return pets;
	}
	
	
	private static void printFileError() {
		System.out.println("ERROR: That file was not found.");
		System.out.println();
	}
	
}
