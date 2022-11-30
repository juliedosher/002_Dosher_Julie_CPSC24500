package muse;

import java.io.*;
import java.util.*;

public class WorkReader {
	
	public static ArrayList<ArtisticWork> readTextFile(String fileName) {							// reads .txt file and returns an
		ArrayList<ArtisticWork> works = new ArrayList<ArtisticWork>();								// ArrayList of artistic works
		
		try {
			Scanner fileScan = new Scanner(new File(fileName));
				
			while (fileScan.hasNextLine()) {														// gets info from file one line at
				String[] split = fileScan.nextLine().split("\t");									// a time
				String type = split[0];
				String creator = split[2];
				String title = split[1];
				String date = split[3];
				String description = split[4];
				
				String language = "";
				String text = "";
				String meter = "";
				
				switch (type) {																		// creates new ArtisticWork object depending on
					case "movie":																	// ArtisticWork type
						
						
						Movie movie = new Movie(); //TODO
						works.add(movie);
						break;
						
					case "poem":
						language = split[5];
						text = split[6];
						meter = split[7];
						int i = 7;
						while (i + 3 <= split.length) {
							// TODO: comments
						}
						
						Poem poem = new Poem(creator, date, title, description, language,
								text, meter);
						works.add(poem);
						break;
						
					case "short story":
						language = split[5];
						text = split[6];
						String setting = split[7];
						
						ShortStory shortStory = new ShortStory(creator, date, title, description, 
								language, text, setting); 
						works.add(shortStory);
						break;
						
					case "song":
						String duration = split[5];
						String workFileName = split[6];
						String fileSize = split[7];
						String bpm = split[8];
						String key = split[9];
						
						Song song = new Song(creator, date, title, description,	
								Integer.parseInt(duration), workFileName, Double.parseDouble(fileSize), 
								Integer.parseInt(bpm), key); 
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
