package quizzy;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import javax.swing.*;

public class QuizFrame  extends JFrame {
	
	ArrayList<Question> questions = new ArrayList<Question>();
	
	public QuizFrame() {
		setTitle("Object-Oriented Quiz Tool");
		Container c = getContentPane();
		c.setLayout(new BorderLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JTextArea textField = new JTextArea("Welcome to Quizzy, the object-oriented programming quiz tool.\n"
				+ "Select File >> Load Questions to begin.");
		c.add(textField, BorderLayout.CENTER);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu fileMenu = new JMenu("File");
		JMenuItem getFileMenuBtn = new JMenuItem("Load Questions");
		JMenuItem quitBtn = new JMenuItem("Quit");
		fileMenu.add(getFileMenuBtn);
		fileMenu.add(quitBtn);
		menuBar.add(fileMenu);
		
		getFileMenuBtn.addActionListener(
	            new ActionListener(){
	                public void actionPerformed(ActionEvent e)
	                {
	                	JFileChooser fc = new JFileChooser();
	                	fc.showOpenDialog(null);
	            		File file = fc.getSelectedFile();
	            		questions = QuestionReader.getQuizFromFile(file);
	            		//File testFile = new File("quiz.txt");											// TODO: remove, just using this for testing purposes
	            		//ArrayList<Question> questions = QuestionReader.getQuizFromFile(testFile);
	            		textField.setText("The questions have been read. Select Quiz>>Start to begin.");
	                }
	            }
	        );
		
		quitBtn.addActionListener(
	            new ActionListener(){
	                public void actionPerformed(ActionEvent e)
	                {
	                    System.exit(0);				// TODO: change so exit statement is not needed
	                }
	            }
	        );
		
		JMenu quizMenu = new JMenu("Quiz");
		JMenuItem startQuizBtn = new JMenuItem("Start");
		JMenuItem stopQuizBtn = new JMenuItem("Stop");
		quizMenu.add(startQuizBtn);
		quizMenu.add(stopQuizBtn);
		menuBar.add(quizMenu);	
		
		
		JPanel southPanel = new JPanel(new FlowLayout());
		
		JLabel labYourAnswer = new JLabel("Your answer: ");
		JTextField answerBox = new JTextField(3);
		JButton btnSubmit = new JButton("Submit answer");
		JButton btnNext = new JButton("Next question");
		southPanel.add(labYourAnswer);
		southPanel.add(answerBox);
		southPanel.add(btnSubmit);
		southPanel.add(btnNext);
		c.add(southPanel, BorderLayout.SOUTH);
		
		setBounds(100, 100, 900, 350);
	}
	
}
