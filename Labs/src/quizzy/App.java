/*
 * Quiz Answers:							TODO: double check quiz answers and .txt file
 * 1. C
 * 2. C
 * 3. A
 * 4. B
 * 5. B
 * 6. D
 * 7. C											
 * 8. A
 * 9. C
 * 10. B
 * 11. A
 * 12. C
 * 13. D
 * 14. D
 */

package quizzy;

import java.util.*;

public class App {

	public static void main(String[] args) {
		QuestionReader.getQuizFromFile(null);					// TODO
		
		ArrayList<Question> questions = QuestionReader.getQuestions();
		LinkedHashMap<String, String> questionOptions = QuestionReader.getQuestionOptions();

	}

}
