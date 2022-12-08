/*
 * QuestionReader class: reads data from file and returns an ArrayList of Questions.
 */

package quizzy;

import java.io.*;
import java.util.*;

public class QuestionReader {

	public static ArrayList<Question> getQuizFromFile(File file) {											// reads text file and returns ArrayList 
		ArrayList<Question> questions = new ArrayList<Question>();											// of questions
		
		try {
			Scanner fileScan = new Scanner(file);
		
			while (fileScan.hasNextLine()) {													
				String[] split = fileScan.nextLine().split("\t");											// gets question and answer parts from 
				String questionText = split[0];																// each line
				String optionA = split[1];
				String optionB = split[2];
				String optionC = split[3];
				String optionD = "";
				String correctAnswer = "";
				
				if (split.length == 5) {																	// questions with 3 options
					correctAnswer = split[4];
					
				} else if (split.length == 6) {																// questions with 4 options
					optionD = split[4];
					correctAnswer = split[5];
				}
				
			
				LinkedHashMap<String, String> questionOptions = new LinkedHashMap<String, String>();		// creates LinkedHashMap of options
				questionOptions.put("a", optionA);
				questionOptions.put("b", optionB);
				questionOptions.put("c", optionC);
				if (split.length == 6) {
					questionOptions.put("d", optionD);
				}
		
				Question question = new Question(questionText, questionOptions, correctAnswer); 			// creates new question with data from file
				questions.add(question);																	// adds new question to ArrayList
			}
			fileScan.close();																				// closes file
				
		} catch (FileNotFoundException e) {
			System.out.println("ERROR: File not found.");
		}
		
		return questions;
	}
	
}
