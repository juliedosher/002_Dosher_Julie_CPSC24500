package storyteller;

import java.io.*;
import java.util.*;

class WordFileReader {

	public static ArrayList<String> readFile(String fileName) {
		boolean fileExists = false;
		do {
			try {
				Scanner fileScan = new Scanner(new File(fileName));
				fileExists = true;
				
				String line = "";
				while (fileScan.hasNextLine()) {
					line = fileScan.nextLine();
					
				}
				
			} catch (FileNotFoundException e) {
				fileExists = false;
				printFileError();
			}
			
		} while (!fileExists);
		
		
		
		
		return null;
		
	}
	
	
	private static void printFileError() {
		System.out.println("That file was not found. Please try again.");
		System.out.println();
	}
	
}
