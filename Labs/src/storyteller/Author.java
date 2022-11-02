package storyteller;

import java.util.ArrayList;
import java.util.HashMap;

class Author {
	private HashMap<String, ArrayList<String>> dictionary;
	
	private int sentences;
	private double adjectiveFrequency;
	private double adverbFrequency;
	private double prepositionFrequency;
	
	public Author() {																								// default constructor
		this.dictionary = new HashMap<String, ArrayList<String>>();
		this.sentences = 0;
		this.adjectiveFrequency = 0;
		this.adverbFrequency = 0;
		this.prepositionFrequency = 0;
	}
	
	public Author(HashMap<String, ArrayList<String>> dictionary, int sentences, double adjectiveFrequency, 			// constructor
			double adverbFrequency, double prepositionFrequency) {
		this.dictionary = dictionary;
		this.sentences = sentences;
		this.adjectiveFrequency = adjectiveFrequency;
		this.adverbFrequency = adverbFrequency;
		this.prepositionFrequency = prepositionFrequency;
	}
	
	public void printStory() {																						// generates the correct amount of 
		System.out.println("Here it is:");																			// sentences and prints them
		for (int i = 0; i < this.sentences; i++) {
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

	
	public HashMap<String, ArrayList<String>> getDictionary() {														// getters and setters
		return dictionary;
	}

	public void setDictionary(HashMap<String, ArrayList<String>> dictionary) {
		this.dictionary = dictionary;
	}

	public int getSentences() {
		return sentences;
	}

	public void setSentences(int sentences) {
		this.sentences = sentences;
	}

	public double getAdjectiveFrequency() {
		return adjectiveFrequency;
	}

	public void setAdjectiveFrequency(double adjectiveFrequency) {
		this.adjectiveFrequency = adjectiveFrequency;
	}

	public double getAdverbFrequency() {
		return adverbFrequency;
	}

	public void setAdverbFrequency(double adverbFrequency) {
		this.adverbFrequency = adverbFrequency;
	}

	public double getPrepositionFrequency() {
		return prepositionFrequency;
	}

	public void setPrepositionFrequency(double prepositionFrequency) {
		this.prepositionFrequency = prepositionFrequency;
	}
	

}
