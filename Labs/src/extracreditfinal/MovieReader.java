package extracreditfinal;

import java.io.*;
import java.util.*;

public class MovieReader {
	
	public static ArrayList<Movie> getMoviesFromTextFile(File file) {											// reads text file and returns ArrayList 
		ArrayList<Movie> movies = new ArrayList<Movie>();											// of questions
		
		try {
			Scanner fileScan = new Scanner(file);
		
			while (fileScan.hasNextLine()) {													
				String[] split = fileScan.nextLine().split("\t");											// gets question and answer parts from 
				String title = split[0];																// each line
				int year = Integer.valueOf(split[1]);
				String director = split[2];
				int runtime = Integer.valueOf(split[3]);
				String description = split[4];
				
				Movie movie = new Movie(title, year, director, runtime, description);
				movies.add(movie);																	// adds new question to ArrayList
			}
			fileScan.close();																				// closes file
				
		} catch (FileNotFoundException e) {
			System.out.println("ERROR: File not found.");
		}
		
		return movies;
	}
}
