/*
 * Class that reads files and creates ArrayLists of the Artistic Works on those files
 */

package muse;

import java.io.*;
import java.util.*;

public class WorkReader {
	
	public static ArrayList<ArtisticWork> readTextFile(String fileName) {							// reads a text file and returns an
		ArrayList<ArtisticWork> works = new ArrayList<ArtisticWork>();								// ArrayList of artistic works
		
		try {
			Scanner fileScan = new Scanner(new File(fileName));
				
			while (fileScan.hasNextLine()) {														// gets info from file one line at
				String[] split = fileScan.nextLine().split("\t");									// a time
				String type = split[0];																// variables for all Artistic Works
				String creator = split[2];
				String title = split[1];
				String date = split[3];
				String description = split[4];
				
				String language = "";																// variables for Written Works
				String text = "";
				String meter = "";
				String duration = "";																// variables for Recorded Works
				String workFileName = "";
				String fileSize = "";
				
				String commentAuthor = "";															// variables for Comments
				String commentDate = "";
				String comment = "";
				int i = 0;
				
				switch (type) {																		// creates new ArtisticWork object depending on
					case "movie":																	// ArtisticWork type
						duration = split[5];
						workFileName = split[6];
						fileSize = split[7];
						String frameRate = split[8];
						String resolution = split[9];
						
						Movie movie = new Movie(creator, date, title, description, 
								Integer.parseInt(duration), workFileName, Double.parseDouble(fileSize), 
								Integer.parseInt(frameRate), resolution); 
						
						i = 10;
						while (i + 3 <= split.length) {
							commentAuthor = split[i];
							commentDate = split[i + 1];
							comment = split[i + 2];
							movie.addComment(commentAuthor, commentDate, comment);
							i = i + 3;
						}
						
						works.add(movie);
						break;
						
					case "poem":
						language = split[5];
						text = split[6];
						meter = split[7];
						
						Poem poem = new Poem(creator, date, title, description, language,
								text, meter);
						
						i = 8;
						while (i + 3 <= split.length) {
							commentAuthor = split[i];
							commentDate = split[i + 1];
							comment = split[i + 2];
							poem.addComment(commentAuthor, commentDate, comment);
							i = i + 3;
						}
						
						works.add(poem);
						break;
						
					case "short story":
						language = split[5];
						text = split[6];
						String setting = split[7];
						
						ShortStory shortStory = new ShortStory(creator, date, title, description, 
								language, text, setting); 
						i = 8;
						while (i + 3 <= split.length) {
							commentAuthor = split[i];
							commentDate = split[i + 1];
							comment = split[i + 2];
							shortStory.addComment(commentAuthor, commentDate, comment);
							i = i + 3;
						}
						
						works.add(shortStory);
						break;
						
					case "song":
						duration = split[5];
						workFileName = split[6];
						fileSize = split[7];
						String bpm = split[8];
						String key = split[9];
						
						Song song = new Song(creator, date, title, description,	
								Integer.parseInt(duration), workFileName, Double.parseDouble(fileSize), 
								Integer.parseInt(bpm), key); 
						
						i = 10;
						while (i + 3 <= split.length) {
							commentAuthor = split[i];
							commentDate = split[i + 1];
							comment = split[i + 2];
							song.addComment(commentAuthor, commentDate, comment);
							i = i + 3;
						}
						
						works.add(song);
						break;
				}
			}
			fileScan.close();
			
		} catch (FileNotFoundException e) {															// should never happen
			System.out.println("ERROR: That file was not found.");														
		}
	
		return works;
	}
	
	public static ArrayList<ArtisticWork> readBinaryFile(String fileName) {							// reads a binary file and returns 
																									// an ArrayList of Artistic Works
		return null;
	}
	
	public static ArrayList<ArtisticWork> readXMLFile(String fileName) {							// reads an XML file and returns an
																									// ArrayList of Artistic Works
		
		return null;
	}
	
}
