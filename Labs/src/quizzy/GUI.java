package quizzy;

import java.awt.*;
import java.io.*;
import java.util.*;
import javax.swing.*;

public class GUI {
	
	public GUI() {
		JFrame frame = new JFrame();
		
		
		frame.setTitle("Object-Oriented Quiz Tool");
		Container c = frame.getContentPane();
		c.setLayout(new BorderLayout());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JTextArea welcome = new JTextArea("Welcome to Quizzy, the object-oriented programming quiz tool.\n"
				+ "Select File >> Load Questions to begin.");
		c.add(welcome, BorderLayout.CENTER);
		
		JMenuBar menuBar = new JMenuBar();
		JMenu fileMenu = new JMenu();
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
		
		frame.setJMenuBar(menuBar);
		
		/*
		JButton btnSubmit = new JButton("Submit answer");
		JButton btnNext = new JButton("Next question");
		
		
		JPanel southPanel = new JPanel(new FlowLayout());
		southPanel.add(btnSubmit);
		southPanel.add(btnNext);
		//c.add(southPanel, BorderLayout.SOUTH);
		
		
		//c.add(btnSubmit, BorderLayout.SOUTH);
		//c.add(btnNext, BorderLayout.SOUTH);
		
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
		c.add(menuBar, BorderLayout.NORTH);
		*/
		
		frame.setVisible(true);
		frame.setBounds(100, 100, 800, 400);
	}
}
