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
	
	public static void writeToTextFile(String fileName, ArrayList<ArtisticWork> works) {	// adds current list of pets to a new file
		try {
			FileWriter postWriter = new FileWriter(fileName);
		     
			for (ArtisticWork work : works) {
				postWriter.write(work.toTabbedString());
				postWriter.write("\n");
			}
		     postWriter.close();															// closes file
		     printPostsWritten();
		     System.out.println();
		     
		} catch (IOException ex) {															// should never happen since this is already
			printErrorFileGeneral();														// checked in createFile()
		}
	}
	
	public static void writeToBinaryFile(String fileName, ArrayList<ArtisticWork> works) {
		try {
			FileWriter postWriter = new FileWriter(fileName);
			//TODO
			
			postWriter.close();
			printErrorFileGeneral();
			System.out.println();
			
		} catch (IOException ex) {
			printErrorFileGeneral();
		}
	}
	
	public static void writeToXMLFile(String fileName, ArrayList<ArtisticWork> works) {
		try {
			FileWriter postWriter = new FileWriter(fileName);
			//TODO
			
			postWriter.close();
			printErrorFileGeneral();
			System.out.println();
			
		} catch (IOException ex) {
			printErrorFileGeneral();
		}
	}
	
	
	private static void printPostsWritten() {
		System.out.println("The posts were successfully written.");
	}
	
	private static void printErrorFileExists() {
		System.out.println("ERROR: That file name is already in use.");
	}
	
	private static void printErrorFileGeneral() {
		System.out.println("ERROR: That file was not found.");
	}
}
