package storyteller;

import java.io.*;
import java.util.*;

class WordFileReader {

	public static ArrayList<String> readFile(String fileName) {
		
		try {
			Scanner fileScan = new Scanner(new File(fileName));
			
				
			String word = "";
			String type = "";
			while (fileScan.hasNextLine()) {
				word = fileScan.next();
				type = fileScan.next();
			}
				
			
			
		} catch (FileNotFoundException e) {
			
		}
			
		
		return null;
		
	}
	
}
