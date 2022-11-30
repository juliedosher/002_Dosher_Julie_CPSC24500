package muse;

import java.io.*;
import java.util.*;

public class WorkReader {
	
	public static ArrayList<ArtisticWork> readTextFile(String fileName) {							// reads .txt file and returns an
		ArrayList<ArtisticWork> works = new ArrayList<ArtisticWork>();								// ArrayList of artistic works
		
		try {
			// TODO: class variables
			String type = "";
			
			Scanner fileScan = new Scanner(new File(fileName));
				
			while (fileScan.hasNextLine()) {														// gets info from file one line at
				String[] split = fileScan.nextLine().split("\t");									// a time
				// TODO: fill generic variables
				
				switch (type) {																		// creates new ArtisticWork object depending on
					case "movie":																	// ArtisticWork type
						// TODO: create specific variables
						Movie movie = new Movie(); //TODO
						works.add(movie);
						break;
						
					case "poem":
						// TODO: create specific variables
						Poem poem = new Poem(); //TODO
						works.add(poem);
						break;
						
					case "short story":
						// TODO: create specific variables
						ShortStory shortStory = new ShortStory(); //TODO
						works.add(shortStory);
						break;
						
					case "song":
						// TODO: create specific variables
						Song song = new Song(); //TODO
						works.add(song);
						break;
				}
			}
			fileScan.close();
			
		} catch (FileNotFoundException e) {															
			System.out.println("ERROR: That file was not found.");														
		}
	
		return works;
	}
}
