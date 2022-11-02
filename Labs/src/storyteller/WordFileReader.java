package storyteller;

import java.io.*;
import java.util.*;

class WordFileReader {

	private static final String ADJECTIVE = "adj";
	private static final String ADVERB = "adv";
	private static final String PREPOSITION = "prep";
	private static final String NOUN = "n";
	private static final String VERB = "v";
	
	public static HashMap<String, ArrayList<String>> readFile(String fileName) {					// reads through file and returns a HashMap of
		HashMap<String, ArrayList<String>> dictionary = new HashMap<String, ArrayList<String>>();	// all words mapped to the type of word it is
		ArrayList<String> adjectives = new ArrayList<String>();
		ArrayList<String> adverbs = new ArrayList<String>();
		ArrayList<String> prepositions = new ArrayList<String>();
		ArrayList<String> nouns = new ArrayList<String>();
		ArrayList<String> verbs = new ArrayList<String>();
		
		dictionary.put(ADJECTIVE, adjectives);
		dictionary.put(ADVERB, adverbs);
		dictionary.put(PREPOSITION, prepositions);
		dictionary.put(NOUN, nouns);
		dictionary.put(VERB, verbs);
		
		try {
			Scanner fileScan = new Scanner(new File(fileName));
				
			String word = "";
			String type = "";
			while (fileScan.hasNextLine()) {
				word = fileScan.next();
				type = fileScan.next();
			
				if (dictionary.containsKey(type)) {
					ArrayList<String> wordList = dictionary.get(type);
					wordList.add(word);
					dictionary.replace(type, wordList);
				}
			}
			
		} catch (FileNotFoundException e) {															// in case file is not found
			printFileError();
		}
		
		return dictionary;
	}
	
	
	private static void printFileError() {
		System.out.println("ERROR: That file was not found.");
		System.out.println();
	}
}
