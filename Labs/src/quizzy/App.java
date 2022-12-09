/*
 * Quiz Answers:							
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
import java.awt.event.*;
import java.io.*;

public class App {

	public static void main(String[] args) {
		QuizFrame frame = new QuizFrame();
		while (!frame.getShouldExit()) {													// checks if user has selected File>>Quit
			frame.setVisible(true);
		}
		
		frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));			// closes JFrame and ends program
	}
	
}
