package storyteller;

import java.io.*;
import java.util.*;

public class App {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
	
		boolean wantsAnotherStory = true;
		
		while (wantsAnotherStory) {
			wantsAnotherStory = askForAnotherStory(input);
		}
	}

	private static boolean askForAnotherStory(Scanner input) {
		
		
		return false;
	}

	private static void printHeading() {
		String asterisks = "*".repeat(51);
		String mainHeading = "STORYTELLER V1.0";
		String space = " ".repeat((asterisks.length() - mainHeading.length()) /2);
		
		System.out.println(asterisks);
		System.out.print(space);
		System.out.print(mainHeading);
		System.out.println(space);
		System.out.println();
		
		System.out.println("Welcome to StoryTeller, a sophisticated electronic");
		System.out.println("author. This program reads from a list of words of");
		System.out.println("various parts of speech and creates a story from");
		System.out.println("them. You can tune the richness of the writing by");
		System.out.println("changing how frequently adjectives, adverbs, and");
		System.out.println("prepositions should be included.");
	}
	
}
