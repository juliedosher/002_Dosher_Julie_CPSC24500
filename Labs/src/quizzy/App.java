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
import java.io.*;

public class App {

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setTitle("Object-Oriented Quiz Tool");
		Container c = frame.getContentPane();
		c.setLayout(new BorderLayout());
		
		//JPanel mainPanel = new JPanel();
		
		JButton btnSubmit = new JButton("Submit answer");
		JButton btnNext = new JButton("Next question");
		JTextArea welcome = new JTextArea("Welcome to Quizzy, the object-oriented programming quiz tool.\n"
				+ "Select File >> Load Questions to begin.");
		
		c.add(welcome, BorderLayout.CENTER);
		//mainPanel.add(welcome, BorderLayout.CENTER);
		//c.add(mainPanel, BorderLayout.NORTH);
		c.add(btnSubmit, BorderLayout.SOUTH);
		c.add(btnNext, BorderLayout.EAST);
		
		JMenuBar menuBar = new JMenuBar();
		JMenu fileMenu =new JMenu();
		JMenuItem getFileMenuBtn = new JMenuItem("Load Questions");
		JMenuItem quitBtn = new JMenuItem("Quit");
		fileMenu.add(getFileMenuBtn);
		fileMenu.add(quitBtn);
		menuBar.add(fileMenu);
		
		JMenu quizMenu = new JMenu();
		JMenuItem startQuizBtn = new JMenuItem("Start");
		JMenuItem stopQuizBtn = new JMenuItem("Stop");
		quizMenu.add(startQuizBtn);
		quizMenu.add(stopQuizBtn);
		menuBar.add(quizMenu);
		
		JFileChooser fc = new JFileChooser();
		File file = fc.getSelectedFile();
		ArrayList<Question> questions = QuestionReader.getQuizFromFile(file); 	
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 400, 400);
		frame.setVisible(true);
		
	}
	
}
