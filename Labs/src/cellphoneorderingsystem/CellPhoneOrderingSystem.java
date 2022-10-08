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
			outputLines[i] = configurePhone(input, i+1);
			prices[i] = getPriceFromString(outputLines[i]);
			
		}
		
		printTotal(outputLines, prices);
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
		
		String addOns = chooseAddOns(input);
		if (addOns.contains("case")) {
			price += 49;
			
		} 
		if (addOns.contains("screen protector")) {
			price += 15;
		}
		if (addOns.contains("ear buds")) {
			price += 99;
		}
		if (addOns.contains("wireless charger")) {
			price += 59;
		}
		
		outputString += phoneOS + screenSize + phoneStorage + addOns + " ($" + String.format("%.2f", price) + ")";
		return outputString;
	}
	
	
	private static String choosePhoneOS(Scanner input) {
		String phoneOS = "";
		
		System.out.print("Enter A for Android or I for IPhone: ");
		String userIn = input.nextLine().toLowerCase();
		
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
		
		System.out.print("What size screen? Enter 1 for 5.6\", 2 for 6.2\", or 3 for 6.7\": ");
		int userIn = input.nextInt();
		
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
		
		boolean properInput = false;
		do {
			System.out.print("How much storage? Enter 64, 128, or 256: ");
			int userIn = input.nextInt();
			
			if (userIn == 64) {
				storage = "64GB ";
				properInput = true;
				
			} else if (userIn == 128) {
				storage = "128GB ";
				properInput = true;
				
			} else if (userIn == 256) {
				storage = "256GB ";
				properInput = true;
				
			} else {
				System.out.println("Invalid input. Please try again.");
			}
		} while (!properInput);
		
		input.nextLine();
		return storage;
	}
	
	private static String chooseAddOns(Scanner input) {
		String addOns = "";
		
		boolean properInput = false;
		boolean doneChoosing = false;
		while (!doneChoosing) {
			do {
				printAddOnOptions();
				String userIn = input.nextLine().toLowerCase();
			
				if (userIn.equals("c")) {
					addOns += "/ case ";
					properInput = true;
				
				} else if (userIn.equals("s")) {
					addOns += "/ screen protector ";
					properInput = true;
					
				} else if (userIn.equals("e")) {
					addOns += "/ ear buds ";
					properInput = true;
				
				} else if (userIn.equals("w")) {
					addOns += "/ wireless charger ";
					properInput = true;
				
				} else if (userIn.equals("f")) {
					doneChoosing = true;
					properInput = true;
					System.out.println();
				
				} else {
					System.out.println("Invalid input. Please try again.");
					properInput = false;
				}
			
			} while (!properInput);
		}
		
		
		return addOns;
	}
	
	private static void printAddOnOptions() {
		System.out.println("What add-on do you want?");
		System.out.println("[C]ase ($49)");
		System.out.println("[S]creen protector ($15)");
		System.out.println("[E]ar buds ($99)");
		System.out.println("[W]ireless charger ($59)");
		System.out.println("[F]inish order");
		System.out.print("Enter the letter of your choice: ");
	}
	
	private static double getPriceFromString(String string) {						// takes in string containing a phone's price
																					// and returns just the price as a double
		String doubleFromString = string.substring(string.indexOf('$') + 1, string.length() - 1);
		return Double.parseDouble(doubleFromString);
	}
	
	private static void printTotal(String[] outputLines, double[] prices) {
		double totalPrice = 0;
		for (double price : prices) {
			totalPrice += price;
		}
		
		System.out.println("Here is a summary of your order:");
		
		for (int i = 0; i < outputLines.length; i++) {
			System.out.println(outputLines[i]);
		}
		
		System.out.println();
		System.out.println("Your total cost is $" + String.format("%.2f", totalPrice) + ".");				
		System.out.println();																						
		System.out.println("Thank you for your order.");
		
	}
}
