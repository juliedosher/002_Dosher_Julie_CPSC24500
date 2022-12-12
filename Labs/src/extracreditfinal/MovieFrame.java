package extracreditfinal;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import javax.swing.*;

import quizzy.QuestionReader;

public class MovieFrame extends JFrame {
	
	private ArrayList<Movie> movies = new ArrayList<Movie>();
	private boolean shouldExit = false;
	
	public MovieFrame() {																				// constructor
		setupGUI();
		
		Container c = getContentPane();
		c.setLayout(new BorderLayout());
		
		JTextArea mainTextArea = new JTextArea("Welcome to Movie List!");
		c.add(mainTextArea, BorderLayout.WEST);
		mainTextArea.setEditable(false);		
		
		setJMenuBar(setupMenu(mainTextArea));	
	}
	
	private void setupGUI() {																			// sets up basic parts of GUI
		setTitle("Movie List");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 700);
	}
	
	private JMenuBar setupMenu(JTextArea textArea) {													// creates menu bar with functioning menu items
		JMenuBar menuBar = new JMenuBar();																// and returns it
		JMenu fileMenu = new JMenu("File");																
		JMenuItem loadMoviesMenu = new JMenuItem("Load Movies");
		// TODO: two sub-menu items for different file types
		JMenuItem quitMenu = new JMenuItem("Quit");
		fileMenu.add(loadMoviesMenu);
		fileMenu.add(quitMenu);
		menuBar.add(fileMenu);
		
		loadMoviesMenu.addActionListener(																// File>>Load Movies
	            new ActionListener(){
	                public void actionPerformed(ActionEvent e)
	                {
	                	JFileChooser fc = new JFileChooser();											// asks user to choose Movie file
	                	fc.showOpenDialog(null);
	            		File file = fc.getSelectedFile();
	            		// TODO: movies = MovieReader.getMovieFrom_____File()
	            		// TODO textArea.setText()
	                }
	            }
	        );
		
		quitMenu.addActionListener(																		// File>>Quit
	            new ActionListener(){
	                public void actionPerformed(ActionEvent e)
	                {
	                	shouldExit = true;
	                }
	            }
	        );
		
		return menuBar;
	}
	
	public boolean getShouldExit() {																	// checks if program should exit 
		return shouldExit;
	}
}
