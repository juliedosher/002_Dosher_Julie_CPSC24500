package cellphoneorderingsystem;

import java.util.*;

public class CellPhoneOrderingSystem {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		printHeading();
		int numPhones = getNumPhones(input);
		
		for (int i = 0; i < numPhones; i++) {
			configurePhone(input, i + 1);
		}
		
	
	}
	
	
	private static void printHeading() {
		System.out.println("****************************************************");
		System.out.println("        CORPORATE CELL PHONE ORDERING SYSTEM        ");
		System.out.println("****************************************************\n");
		System.out.println("Welcome to the corporate cell phone ordering system.");
		System.out.println("Here you can order multiple phones of different kinds");
		System.out.println("with various add-ons for your employees.\n");
	}
	
	private static int getNumPhones(Scanner input) {											// gets number of phones customer will purchase
		System.out.print("How many phones will you purchase? ");								// and returns it
		int phones = input.nextInt();
		input.nextLine();
		System.out.println();
		return phones;																			// **** ADD CHECK FOR PROPER INPUT ****
	}
	
	private static double configurePhone(Scanner input, int phoneNum) {							// **** FINISH ****
		String outputString = ""; 
		double price;
		double screenSize;
		
		System.out.println("Let's configure phone #" + phoneNum + " ...");
		
		System.out.print("Enter A for Android or I for IPhone: ");							
		String phoneType = input.next();
		if (phoneType.equals("A")) {
			price = 799;
			outputString += "Android ";
		} else {
			price = 849;
			outputString += "IPhone ";
		}
		
		System.out.print("What size screen? Enter 1 for 5.6\", 2 for 6.2\", or 3 for 6.7\": ");
		if (input.nextInt() == 1) {
			outputString += "5.6\" ";
		} else if (input.nextInt() == 2) {
			price *= 0.2;
			outputString += "6.2\" ";
		} else {
			price *= 0.4;
			outputString += "6.7\" ";
		}
		
		
		System.out.print("How much storage? Enter 64, 128, or 256: ");
		
			
		System.out.println(outputString);
		return 0;
	}
}
