package storyteller;

import java.util.ArrayList;
import java.util.HashMap;

class Author {
	private HashMap<String, ArrayList<String>> dictionary;
	
	private int sentences;
	private double adjectiveFrequency;
	private double adverbFrequency;
	private double prepositionFrequency;
	
	
	public Author(HashMap<String, ArrayList<String>> dictionary, double adjectiveFrequency, double adverbFrequency,
			double prepositionFrequency) {
		this.dictionary = dictionary;
		this.sentences = sentences;
		this.adjectiveFrequency = adjectiveFrequency;
		this.adverbFrequency = adverbFrequency;
		this.prepositionFrequency = prepositionFrequency;
	}
	
	
	
}
