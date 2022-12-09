/*
 * File that defines the Question Class
 */

package quizzy;

import java.util.*;

public class Question {

	Question() {																						// Default constructor
		this.questionText = "";
		this.options = new LinkedHashMap<String, String>();
		this.correctAnswer = "";
	}
	
	Question(String questionText, LinkedHashMap<String, String> options, String correctAnswer) {		// Constructor
		this.questionText = questionText;
		this.options = options;
		this.correctAnswer = correctAnswer.toLowerCase();
	}
	
	private String questionText;																		// String that holds the question
	private LinkedHashMap<String, String> options;														// Linked Hash Map that holds option letter, answer
	private String correctAnswer;																		// String that holds the letter of the correct option
	
	
	public boolean checkIsCorrect(String userAnswer) {													// checks if user's answer is correct
		boolean isCorrect = false;
		
		if (userAnswer.equalsIgnoreCase(correctAnswer)) {
			isCorrect = true;
		}
		
		return isCorrect;
	}
	
	public String toString() {																			// returns a nicely formatted String to show user
		String string = questionText + "\n";
		string += "A." + "\t" + options.get("a") + "\n";												
		string += "B." + "\t" + options.get("b") + "\n";
		string += "C." + "\t" + options.get("c") + "\n";
		if (getOptions().size() == 4) {																	// if there are 4 options
			string += "D." + "\t" + options.get("d") + "\n";
		}
		
		return string;
	}
	
	public String toTabbedString() {																	// returns a tab-delimited String to write to text file
		String tabbedString = questionText;
		tabbedString += "\t" + options.get("a");
		tabbedString += "\t" + options.get("b");
		tabbedString += "\t" + options.get("c");
		if (getOptions().size() == 4) {																	// if there are 4 options
			tabbedString += "\t" + options.get("d");
		}
		tabbedString += "\t" + correctAnswer;
		
		return tabbedString;
	}
	
	
	public String getQuestionText() {																	// getters and setters
		return questionText;
	}
	
	public void setQuestionText(String questionText) {
		this.questionText = questionText;
	}
	public LinkedHashMap<String, String> getOptions() {
		return options;
	}
	public void setOptions(LinkedHashMap<String, String> options) {
		this.options = options;
	}
	public String getCorrectAnswer() {
		return correctAnswer;
	}
	public void setCorrectAnswer(String correctAnswer) {
		this.correctAnswer = correctAnswer;
	}
	
}
