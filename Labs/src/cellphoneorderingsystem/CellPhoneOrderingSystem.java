package cellphoneorderingsystem;

import java.util.*;

public class CellPhoneOrderingSystem {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		printHeading();
		int numPhones = getNumPhones(input);
		
		String[] outputLines = new String[numPhones];
		double[] prices = new double[numPhones];
		
		for (int i = 0; i < numPhones; i++) {
			configurePhone(input, i + 1);
		}
		
	
	}
	
	
	private static void printHeading() {														// prints nicely formatted heading
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
	
	private static String configurePhone(Scanner input, int phoneNum) {							// **** FINISH ****
		String outputString = ""; 																// change return to String, and update function
		double price = 0;																			// to get price later, get substring starting 1 after $
		
		
		System.out.println("Let's configure phone #" + phoneNum + " ...");
	
		String phoneOS = choosePhoneOS(input);
		if (phoneOS.equals("Android ")) {
			price += 799;
		} else {
			price += 849;
		}
		
		String screenSize = chooseScreenSize(input);
		if (screenSize.equals("5.6\" ")) {
			price *= 1;
		} else if (screenSize.equals("6.2\" ")) {
			price *= 1.2;
		} else {
			price *= 1.4;
		}
		
		String phoneStorage = chooseStorage(input);
		if (phoneStorage.equals("64GB ")) {
			price += 0;
		} else if (phoneStorage.equals("128GB ")) {
			price += 100;
		} else {
			price += 250;
		}
		
		
		String addOnChoice = "";
		while (!addOnChoice.equals("f")) {
			
			
			
			addOnChoice = input.next();
			addOnChoice = addOnChoice.toLowerCase();
		}
		
			
		return outputString;
	}
	
	
	private static String choosePhoneOS(Scanner input) {
		String phoneOS = "";
		String userIn = input.nextLine().toLowerCase();
		
		System.out.print("Enter A for Android or I for IPhone: ");	
		
		boolean properInput = false;
		do {
			if (userIn.equals("a")) {
				phoneOS = "Android ";
				properInput = true;
				
			} else if (userIn.equals("i")) {
				phoneOS = "IPhone ";
				properInput = true;
				
			} else {
				System.out.println("Invalid input. Please try again.");
				System.out.print("Enter A for Android or I for IPhone: ");
				userIn = input.nextLine();
				userIn = userIn.toLowerCase();
			}
		} while (!properInput);
		
		return phoneOS;
	}
	
	private static String chooseScreenSize(Scanner input) {
		String screenSize = "";
		int userIn = input.nextInt();
		
		
		System.out.print("What size screen? Enter 1 for 5.6\", 2 for 6.2\", or 3 for 6.7\": ");
		
		boolean properInput = false;
		do {
			if (userIn == 1) {
				screenSize = "5.6\" ";
				properInput = true;
			
			} else if (userIn == 2) {
				screenSize = "6.2\" ";
				properInput = true;
			
			} else if (userIn == 3) {
				screenSize = "6.7\" ";
				properInput = true;
			
			} else {
				System.out.println("Invalid input. Please try again.");
				System.out.print("What size screen? Enter 1 for 5.6\", 2 for 6.2\", or 3 for 6.7\": ");
				userIn = input.nextInt();
			}
		} while (!properInput);
		
		
		return screenSize;
	}
	
	private static String chooseStorage(Scanner input) {
		String storage = "";
		int userIn = input.nextInt();
		
		System.out.print("How much storage? Enter 64, 128, or 256: ");
		
		boolean properInput = false;
		do {
			if (userIn == 64) {
				storage = "64GB ";
			} else if (userIn == 128) {
				storage = "128GB ";
			} else if (userIn == 256) {
				storage = "256GB ";
			} else {
				System.out.println("Invalid input. Please try again.");
				System.out.print("How much storage? Enter 64, 128, or 256: ");
				userIn = input.nextInt();
			}
		} while (!properInput);
		
		input.nextLine();
		return storage;
	}
	
	private static String chooseAddOns(Scanner input) {
		String addOns = "";
		
		
		
		return addOns;
	}
}
