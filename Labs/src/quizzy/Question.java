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
		
		userAnswer = userAnswer.toLowerCase();
		if (userAnswer.equals(correctAnswer)) {
			isCorrect = true;
		}
		
		return isCorrect;
	}
	
	public String toString() {																			// returns a nicely formatted String to show user
		String string = questionText + "\n";
		string += "a." + "\t" + options.get("a") + "\n";
		string += "b." + "\t" + options.get("b") + "\n";
		string += "c." + "\t" + options.get("c") + "\n";
		string += "d." + "\t" + options.get("d") + "\n";
		
		return string;
	}
	
	public String toTabbedString() {																	// returns a tab-delimited String to write to text file
		String tabbedString = questionText + "\t";
		tabbedString += "a." + "\t" + options.get("a") + "\t";
		tabbedString += "b." + "\t" + options.get("b") + "\t";
		tabbedString += "c." + "\t" + options.get("c") + "\t";
		tabbedString += "d." + "\t" + options.get("d");
		
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
