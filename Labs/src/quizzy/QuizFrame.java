package quizzy;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import javax.swing.*;

public class QuizFrame extends JFrame {
	
	private ArrayList<Question> questions = new ArrayList<Question>();
	private Question currentQuestion = new Question();
	private boolean shouldExit = false;
	private boolean isInQuiz = false;
	private int totalQuestionsCounter = 0;
	private int correctQuestionsCounter = 0;
	
	private JButton btnSubmit;
	private JButton btnNext;
	
	public QuizFrame() {
		setupGUI();
		
		Container c = getContentPane();
		c.setLayout(new BorderLayout());
		
		JTextArea mainTextArea = new JTextArea("Welcome to Quizzy, the object-oriented programming "
				+ "quiz tool.\nSelect File >> Load Questions to begin.");
		c.add(mainTextArea, BorderLayout.CENTER);
		mainTextArea.setEditable(false);																// user cannot edit main text area
		
		JTextField answerBox = new JTextField(3);														// the editable textfield the user types their answer in
		
		setJMenuBar(setupMenu(mainTextArea));															// adds menu bar containing File and Quiz
		c.add(setupSouthPanel(answerBox, mainTextArea), BorderLayout.SOUTH);							// adds panel containing buttons and text field to south
	
	}
	
	
	private void setupGUI() {																			// sets up basic parts of GUI
		setTitle("Object-Oriented Quiz Tool");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 350);
	}
	
	private JPanel setupSouthPanel(JTextField answerBox, JTextArea textArea) {							// sets up south panel with buttons and
		JPanel southPanel = new JPanel(new FlowLayout());												// user's answer text field and returns panel
																									
		JLabel labYourAnswer = new JLabel("Your answer: ");
		btnSubmit = new JButton("Submit answer");
		btnNext = new JButton("Next question");
		southPanel.add(labYourAnswer);
		southPanel.add(answerBox);
		southPanel.add(btnSubmit);
		southPanel.add(btnNext);
		
		btnSubmit.setEnabled(false);
		btnNext.setEnabled(false);
		
		btnSubmit.addActionListener(																	// presses Submit button										
	            new ActionListener(){
	                public void actionPerformed(ActionEvent e)
	                {
	                	String userAnswer = answerBox.getText();
	                	if (currentQuestion.checkIsCorrect(userAnswer)) {
	                		correctQuestionsCounter++;
	                		textArea.append("\nCorrect! ");
	                	} else {
	                		textArea.append("\nIncorrect. ");
	                	}
	                	
	                	textArea.append("The correct answer is " 
	                			+ currentQuestion.getCorrectAnswer().toUpperCase() + ".");
	                	totalQuestionsCounter++;
	                	btnSubmit.setEnabled(false);
	                	btnNext.setEnabled(true);
	                }
	            }
	    );
		btnNext.addActionListener(																		// presses Next button										
	            new ActionListener(){
	                public void actionPerformed(ActionEvent e)
	                {
	                	
	                	btnSubmit.setEnabled(true);
	                	btnNext.setEnabled(false);
	                	
	                	answerBox.setText("");
	                	chooseQuestion(textArea);
	                }
	            }
	    );
		
		return southPanel;
	}
	
	private JMenuBar setupMenu(JTextArea textArea) {													// creates menu bar with functioning menu items
		JMenuBar menuBar = new JMenuBar();																// and returns it
		JMenu fileMenu = new JMenu("File");
		JMenuItem getFileMenuBtn = new JMenuItem("Load Questions");
		JMenuItem quitBtn = new JMenuItem("Quit");
		fileMenu.add(getFileMenuBtn);
		fileMenu.add(quitBtn);
		menuBar.add(fileMenu);
		
		getFileMenuBtn.addActionListener(																// File>>Load Questions
	            new ActionListener(){
	                public void actionPerformed(ActionEvent e)
	                {
	                	JFileChooser fc = new JFileChooser();
	                	fc.showOpenDialog(null);
	            		File file = fc.getSelectedFile();
	            		questions = QuestionReader.getQuizFromFile(file);
	            		textArea.setText("The questions have been read. Select Quiz>>Start to begin.");
	                }
	            }
	        );
		
		quitBtn.addActionListener(																		// File>>Quit
	            new ActionListener(){
	                public void actionPerformed(ActionEvent e)
	                {
	                	shouldExit = true;
	                }
	            }
	        );
		
		JMenu quizMenu = new JMenu("Quiz");
		JMenuItem startQuizBtn = new JMenuItem("Start");
		JMenuItem stopQuizBtn = new JMenuItem("Stop");
		quizMenu.add(startQuizBtn);
		quizMenu.add(stopQuizBtn);
		menuBar.add(quizMenu);	
		
		startQuizBtn.addActionListener(																	// Quiz>>Start
	            new ActionListener(){
	                public void actionPerformed(ActionEvent e)
	                {
	            		chooseQuestion(textArea);
	            		btnSubmit.setEnabled(true);
	            			
	                }
	            }
	        );
		
		stopQuizBtn.addActionListener(																	// Quiz>>Stop
	            new ActionListener(){
	                public void actionPerformed(ActionEvent e)
	                {
	                	gradeQuiz();
	                }
	            }
	        );
		
		return menuBar;
	}
	
	public boolean getShouldExit() {																	// checks if program should exit 
		return shouldExit;
	}
	
	private void chooseQuestion(JTextArea textArea) {													// chooses a question based on RNG
		if (questions.size() > 0) {
			Random rand = new Random();
	    	int questionNum = rand.nextInt(questions.size());
	    	currentQuestion = questions.get(questionNum);
	    	textArea.setText(currentQuestion.toString());
	    	questions.remove(questionNum);																// removes chosen question so it can't
		}																								// be picked again
	}																								
	
	private void gradeQuiz() {																			// ends quiz and shows a message 
		double percent = 100 * (double)correctQuestionsCounter / (double)totalQuestionsCounter;			// pop-up with user's score
		String output = "You answered " + correctQuestionsCounter + " out of " 
				+ totalQuestionsCounter + " correctly.\n";
		output += "That is a percent score of " + String.format("%.2f", percent) + ".";
		JOptionPane.showMessageDialog(this, output);
	}
	
}
