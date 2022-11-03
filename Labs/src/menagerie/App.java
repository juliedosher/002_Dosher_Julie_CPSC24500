package menagerie;

public class App {

	public static void main(String[] args) {
		

	}

	
	
	
	private static void printHeading() {
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
	
	private static void printMenu() {
		System.out.println("What would you like to do?");
		System.out.println("1. Add a new pet.");
		System.out.println("2. Print list of pets.");
		System.out.println("3. Save pets to a file.");
		System.out.println("4. Load pets from a file.");
		System.out.println("5. Simulate a day in the life of your pets.");
		System.out.println("6. Clear your list of pets.");
		System.out.println("7. Exit");
	}
	
}
