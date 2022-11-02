package storyteller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

class Author {
	private HashMap<String, ArrayList<String>> dictionary;
	
	private int sentences;
	private int adjectiveFrequency;
	private int adverbFrequency;
	private int prepositionFrequency;
	
	public Author() {																								// default constructor
		this.dictionary = new HashMap<String, ArrayList<String>>();
		this.sentences = 0;
		this.adjectiveFrequency = 0;
		this.adverbFrequency = 0;
		this.prepositionFrequency = 0;
	}
	
	public Author(HashMap<String, ArrayList<String>> dictionary, int sentences, int adjectiveFrequency, 			// constructor
			int adverbFrequency, int prepositionFrequency) {
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
	
	private String createSentence(HashMap<String, ArrayList<String>> dictionary, int adjectiveFrequency, 			// creates a single sentence and 
			int adverbFrequency, int prepositionFrequency) {														// returns it
		String sentence = "";
		Random random = new Random();
		
		int adjectiveChance = random.nextInt(App.FREQ_MAX - App.FREQ_MIN) + App.FREQ_MIN;							// creates random int for each
		int adverbChance = random.nextInt(App.FREQ_MAX - App.FREQ_MIN) + App.FREQ_MIN;								// optional type of speech
		int prepositionChance = random.nextInt(App.FREQ_MAX - App.FREQ_MIN) + App.FREQ_MIN;	
		
		sentence += "The ";																							// sentence starter
		
		if (adjectiveChance <= adjectiveFrequency && adjectiveFrequency != 0) {										// checks if random int falls within percentage
			sentence += chooseWord(dictionary, WordFileReader.ADJECTIVE) + " ";										// if so, adds word of that type														
		}
		
		sentence += chooseWord(dictionary, WordFileReader.NOUN) + " ";												// adds subject to sentence										
		sentence += chooseWord(dictionary, WordFileReader.VERB);													// adds predicate to sentence 
		
		if (adverbChance <= adverbFrequency && adverbFrequency != 0) {
			sentence += " " + chooseWord(dictionary, WordFileReader.ADVERB);
		}
		
		if (prepositionChance <= prepositionFrequency && prepositionFrequency != 0) {
			sentence += " " + chooseWord(dictionary, WordFileReader.PREPOSITION);
			sentence += " the ";
			sentence += chooseWord(dictionary, WordFileReader.NOUN);
		}
		
		sentence += ".";
		return sentence;
	}

	private String chooseWord(HashMap<String, ArrayList<String>> dictionary, String key) {							// chooses a random word from the hash map
		Random random = new Random();																				// and returns it
		int wordAtIndex = random.nextInt(dictionary.get(key).size());
		String word = dictionary.get(key).get(wordAtIndex);
		
		return word;
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

	public int getAdjectiveFrequency() {
		return adjectiveFrequency;
	}

	public void setAdjectiveFrequency(int adjectiveFrequency) {
		this.adjectiveFrequency = adjectiveFrequency;
	}

	public int getAdverbFrequency() {
		return adverbFrequency;
	}

	public void setAdverbFrequency(int adverbFrequency) {
		this.adverbFrequency = adverbFrequency;
	}

	public int getPrepositionFrequency() {
		return prepositionFrequency;
	}

	public void setPrepositionFrequency(int prepositionFrequency) {
		this.prepositionFrequency = prepositionFrequency;
	}
	
}
