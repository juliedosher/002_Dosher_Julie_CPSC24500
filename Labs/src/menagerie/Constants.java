/*
 * Class that contains constants and basic printing functions
 */

package menagerie;

public class Constants {

	public static final String DOG = "d";
	public static final String CAT = "c";
	public static final String FISH = "f";
	
	public static final String FOOD = " was hungry and ate.";
	public static final String ATTENTION = " sought your attention.";
	public static final String SLEEP = " was sleepy and took a nap.";
	
	public static final int BRAIN_MIN = 1;
	public static final int BRAIN_MAX = 24;
	
	public static void printHeading() {																	
		String asterisks = "*".repeat(60);
		String mainHeading = "Menagerie V1.0: The Pet Simulator";
		String space = " ".repeat((asterisks.length() - mainHeading.length()) / 2);
		System.out.println(asterisks);
		System.out.print(space);
		System.out.print(mainHeading);
		System.out.println(space);
		System.out.println(asterisks);
		System.out.println();
	}
	
	public static void printMenu() {
		System.out.println("What would you like to do?");
		System.out.println("1. Add a new pet.");
		System.out.println("2. Print list of pets.");
		System.out.println("3. Save pets to a file.");
		System.out.println("4. Load pets from a file.");
		System.out.println("5. Simulate a day in the life of your pets.");
		System.out.println("6. Clear your list of pets.");
		System.out.println("7. Exit");
	}
	
	public static void printExit() {
		System.out.println("Thank you for using Menagerie. We hope you had fun.");
	}
	
	public static void printInvalidInput() {
		System.out.println("Invalid input. Please try again.");
		System.out.println();
	}
	
	public static void printFileError() {
		System.out.println("ERROR: That file was not found.");
		System.out.println();
	}
}
