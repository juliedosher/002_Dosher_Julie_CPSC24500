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
			        printErrorFileExists();
			      }
			      
			    } catch (IOException ex) {
			    	printErrorFileGeneral();
			    }
		}
		
		return fileName;
	}
	
	public static void writeToTextFile(String fileName, ArrayList<ArtisticWork> works) {	// adds current list of works to a text file
		try {
			FileWriter postWriter = new FileWriter(fileName);
		     
			for (ArtisticWork work : works) {
				postWriter.write(work.toTabbedString());
				postWriter.write("\n");
			}
		     postWriter.close();															// closes file
		     printPostsWritten();
		     
		} catch (IOException ex) {															// should never happen since this is already
			printErrorFileGeneral();														// checked in createFile()
		}
	}
	
	public static void writeToBinaryFile(String fileName, ArrayList<ArtisticWork> works) {	// adds current list of works to a binary file
		try {
			FileWriter postWriter = new FileWriter(fileName);
			//TODO
			
			postWriter.close();																// closes file
			printErrorFileGeneral();
			System.out.println();
			
		} catch (IOException ex) {
			printErrorFileGeneral();
		}
	}
	
	public static void writeToXMLFile(String fileName, ArrayList<ArtisticWork> works) {		// adds current list of works to an XML file
		try {
			FileWriter postWriter = new FileWriter(fileName);
			//TODO
			
			postWriter.close();																// closes file
			printErrorFileGeneral();
			System.out.println();
			
		} catch (IOException ex) {
			printErrorFileGeneral();
		}
	}
	
	
	private static void printPostsWritten() {												// printing methods
		System.out.println("The posts were successfully written.");
	}
	
	private static void printErrorFileExists() {
		System.out.println("ERROR: That file name is already in use.");
	}
	
	private static void printErrorFileGeneral() {
		System.out.println("ERROR: That file was not found.");
	}
}
