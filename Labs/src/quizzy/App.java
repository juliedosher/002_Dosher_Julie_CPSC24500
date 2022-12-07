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
import javax.swing.*;
import java.awt.*;

public class App {

	public static void main(String[] args) {
		//ArrayList<Question> questions = QuestionReader.getQuizFromFile(null); 	// TODO: get file name
		
		JFrame frame = new JFrame();
		frame.setTitle("Object-Oriented Quiz Tool");
		Container c = frame.getContentPane();
		c.setLayout(new BorderLayout());
		
		JPanel mainPanel = new JPanel();
		
		JButton btnSubmit = new JButton("Submit answer");
		JButton btnNext = new JButton("Next question");
		JLabel labWelcome = new JLabel("Welcome to Quizzy, the object-oriented programming quiz tool.\n"
				+ "Select File >> Load Questions to begin.");
		
		mainPanel.add(labWelcome);
		c.add(mainPanel, BorderLayout.NORTH);
		c.add(btnSubmit, BorderLayout.CENTER);
		c.add(btnNext, BorderLayout.EAST);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 400, 400);
		frame.setVisible(true);
		
	}
	
}
