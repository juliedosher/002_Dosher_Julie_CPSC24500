package menagerie;

import java.io.*;
import java.util.*;

import storyteller.Constants;

public class PetReader {

	public static ArrayList<Pet> readFile(String fileName) {					
		ArrayList<Pet> pets = new ArrayList<Pet>();
		
		try {
			String type = "";
			String name = "";
			int age = 0;
			double weight = 0;
			
			Scanner fileScan = new Scanner(new File(fileName));
				
			while (fileScan.hasNextLine()) {
				type = fileScan.next();										// CHANGE! parse between tabs ********
				name = fileScan.next();
				age = fileScan.nextInt();
				weight = fileScan.nextDouble();
			}
			
		} catch (FileNotFoundException e) {															// should never be used because this
			printFileError();																		// is already checked in App.java
		}
		
		return pets;
	}
	
	
	private static void printFileError() {
		System.out.println("ERROR: That file was not found.");
		System.out.println();
	}
	
}
