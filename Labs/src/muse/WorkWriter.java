package muse;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

import menagerie.Constants;
import menagerie.Pet;

public class WorkWriter {

	public static String createFile(Scanner input) {										// takes in a String fileName and creates the file
		boolean validInput = false;
		String fileName = "";
		
		while (!validInput) {
			System.out.print("Enter name of file: ");
			fileName = input.nextLine();
			
			try {
			      File newFile = new File(fileName);
			      if (newFile.createNewFile()) {
			        validInput = true;
			     
			      } else {
			        System.out.println("ERROR: That file name is already in use.");
			      }
			      
			    } catch (IOException ex) {
			    	System.out.println("ERROR: That file was not found.");
			    }
		}
		
		return fileName;
	}
	
	public static void writeToTextFile(String fileName, ArrayList<ArtisticWork> works) {	// adds current list of pets to a new file
		try {
			FileWriter postWriter = new FileWriter(fileName);
		     
			for (ArtisticWork work : works) {
				postWriter.write(work.toTabbedString());
				postWriter.write("\n");
			}
		     postWriter.close();															// closes file
		     System.out.println("The posts were successfully written.");
		     System.out.println();
		     
		} catch (IOException ex) {															// should never happen since this is already
			System.out.println("ERROR: That file was not found.");							// checked in createFile()
		}
	}
	
}
