package storyteller;

import java.util.ArrayList;
import java.util.HashMap;

class Author {
	private HashMap<String, ArrayList<String>> dictionary;
	
	private int sentences;
	private double adjectiveFrequency;
	private double adverbFrequency;
	private double prepositionFrequency;
	
	
	public Author(HashMap<String, ArrayList<String>> dictionary, int sentences, double adjectiveFrequency, 
			double adverbFrequency, double prepositionFrequency) {
		this.dictionary = dictionary;
		this.sentences = sentences;
		this.adjectiveFrequency = adjectiveFrequency;
		this.adverbFrequency = adverbFrequency;
		this.prepositionFrequency = prepositionFrequency;
	}
	
	public void printStory(int sentences) {																			// generates the correct amount of 
		System.out.println("Here it is:");																			// sentences and prints them
		for (int i = 0; i < sentences; i++) {
			String sentence = createSentence(this.dictionary, this.adjectiveFrequency, 
					this.adverbFrequency, this.prepositionFrequency);
			System.out.println(sentence);
		}
	}
	
	private String createSentence(HashMap<String, ArrayList<String>> dictionary, double adjectiveFrequency, 		// creates a single sentence and 
			double adverbFrequency, double prepositionFrequency) {													// returns it
		String sentence = "x";
		
		
		
		return sentence;
	}

}
