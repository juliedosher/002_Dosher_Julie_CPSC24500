package extracreditfinal;

import java.io.*;
import java.util.*;

public class MovieReader {
	
	public static ArrayList<Movie> getMoviesFromTextFile(File file) {								// reads text file and returns ArrayList 
		ArrayList<Movie> movies = new ArrayList<Movie>();											// of movies
		
		try {
			Scanner fileScan = new Scanner(file);
		
			while (fileScan.hasNextLine()) {													
				String[] split = fileScan.nextLine().split("\t");									// gets movie parts from each line
				String title = split[0];															
				int year = Integer.valueOf(split[1]);
				String director = split[2];
				int runtime = Integer.valueOf(split[3]);
				String description = split[4];
				
				Movie movie = new Movie(title, year, director, runtime, description);
				movies.add(movie);																	// adds new movie to ArrayList
			}
			fileScan.close();																		// closes file
				
		} catch (FileNotFoundException e) {
			System.out.println("ERROR: File not found.");
		}
		
		return movies;
	}
	
	@SuppressWarnings("unchecked")
	public static ArrayList<Movie> readBinaryFile(String fileName) {								// reads a binary file and returns 
		ArrayList<Movie> movies = new ArrayList<Movie>();											// an ArrayList of Artistic Works
		try {
			FileInputStream fis = new FileInputStream(new File(fileName));
			ObjectInputStream ois = new ObjectInputStream(fis);
			movies = (ArrayList<Movie>)ois.readObject();
			
			ois.close();
			
		} catch (IOException ex) {
			// file error
		} catch (ClassNotFoundException ex) {
			// translation error
		}
		
		return movies;
	}
}
