package extracreditfinal;

import java.awt.event.WindowEvent;
import java.io.File;
import java.util.ArrayList;

import quizzy.QuizFrame;

public class App {

	public static void main(String[] args) {
		MovieFrame frame = new MovieFrame();
		while (!frame.getShouldExit()) {													// checks if user has selected File>>Quit
			frame.setVisible(true);
		}
		
		frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));			// closes JFrame and ends program
	}

}
