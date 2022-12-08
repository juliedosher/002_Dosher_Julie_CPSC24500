package quizzy;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import javax.swing.*;

public class QuizFrame  extends JFrame {
	
	public QuizFrame() {
		setTitle("Object-Oriented Quiz Tool");
		Container c = getContentPane();
		c.setLayout(new BorderLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JTextArea welcome = new JTextArea("Welcome to Quizzy, the object-oriented programming quiz tool.\n"
				+ "Select File >> Load Questions to begin.");
		c.add(welcome, BorderLayout.CENTER);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu fileMenu = new JMenu("File");
		JMenuItem getFileMenuBtn = new JMenuItem("Load Questions");
		JMenuItem quitBtn = new JMenuItem("Quit");
		fileMenu.add(getFileMenuBtn);
		fileMenu.add(quitBtn);
		menuBar.add(fileMenu);
		
		quitBtn.addActionListener(
	            new ActionListener(){
	                public void actionPerformed(ActionEvent e)
	                {
	                    System.exit(0);
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
		JTextField answerBox = new JTextField("");
		answerBox.setSize(90, answerBox.getHeight());
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
