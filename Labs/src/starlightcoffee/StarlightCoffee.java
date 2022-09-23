package starlightcoffee;

import java.util.Scanner;

public class StarlightCoffee {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		printHeading();
		String name = getName(input);
		double coffeePrice =  getCoffeeOrderPrice(input);
		double priceMultiplier = getSizePriceMultiplier(input);
		double shotsUpcharge = getEspressoShotUpcharge(input);
		double discount = checkMemberDiscount(input);
		double tip = getTip(input);
		
		printTotal(name, coffeePrice, priceMultiplier, shotsUpcharge, discount, tip);
	}
	
	
	private static void printHeading() {													// prints heading
		System.out.println("*************************************");
		System.out.println("STARLIGHT COFFEE POINT-OF-SALE SYSTEM");
		System.out.println("*************************************\n");
	}
	
	private static void printTotal(String name, double basePrice, double priceMultiplier, 	// prints receipt for customer, nicely formatted
			double shotsUpcharge, double discountPercentage, double tipPercentage) {
		
		double beverageCost = basePrice * priceMultiplier + shotsUpcharge;
		double clubDiscount = beverageCost * discountPercentage;
		double tipAmount = beverageCost * tipPercentage;
		double taxAmount = (beverageCost - clubDiscount) * .0875;
		double total = beverageCost - clubDiscount + tipAmount + taxAmount;
		
		System.out.println("Here is your bill, " + name + ":");
		System.out.println("Beverage      $ " + String.format("%.2f", beverageCost));
		System.out.println("Club Discount $ " + String.format("%.2f", clubDiscount));
		System.out.println("Tip Amount    $ " + String.format("%.2f", tipAmount));
		System.out.println("Taxes         $ " + String.format("%.2f", taxAmount));
		System.out.println("Total         $ " + String.format("%.2f", total));
	}
	
	
	private static String getName(Scanner input) {											// method asks for name and returns it
		System.out.print("What is your name? ");
		String name = input.nextLine();
		System.out.println();
		return name;
	}

	private static double getCoffeeOrderPrice(Scanner input) {								// method asks for drink order and returns price
		System.out.println("What kind of coffee do you want?");
		System.out.println("1. Americano");
		System.out.println("2. Italiano");
		System.out.println("3. Espresso");
		System.out.println("4. Cappuccino");
		System.out.print("Enter the number of your choice: ");
		int choice = input.nextInt();
		double price = 0;
		
		switch (choice) {
			case 1:
				price = 2.25;																// Americano, $2.25
				break;
			case 2:
				price = 2.75;																// Italiano, $2.75
				break;
			case 3: 
				price = 3.5;																// Espresso, $3.50
				break;
			case 4: 
				price = 3.75;																// Cappuccino, $3.75
				break;
		}
		
		System.out.println();
		return price;
	}
	
	private static double getSizePriceMultiplier(Scanner input) {							// method asks for size of drink, and returns price multiplier
		System.out.println("What size do you want?");
		System.out.println("1. Tall");
		System.out.println("2. Grande");
		System.out.println("3. Venti");
		System.out.print("Enter the number of your choice: ");
		int choice = input.nextInt();
		double multiplier = 0;
		
		switch (choice) {
			case 1:																
				multiplier = 1;																// Tall, same as base price
				break;
			case 2: 
				multiplier = 1.2;															// Grande, 20% upcharge
				break;
			case 3: 
				multiplier = 1.4;															// Venti, 40% upcharge
				break;
		}
		
		System.out.println();
		return multiplier;
	}
	
	private static double getEspressoShotUpcharge(Scanner input) {							// method asks how many espresso shots customer wants 
		System.out.print("How many extra shots would you like? ");							// and returns upcharge
		int shots = input.nextInt();
		
		System.out.println();
		return (shots * .5);																// $0.50 upcharge per shot
	}
	
	private static double checkMemberDiscount(Scanner input) {								// method asks if user is member and returns appropriate discount value
		input.nextLine();																	// clears new line character
		System.out.print("Are you a member of Starlight Stars (y or n)? ");
		String response = input.nextLine();
		double discount = 0;
		
		if (response.equalsIgnoreCase("y")) {
			discount = .1;
		} 
			
		System.out.println();
		return discount;
	}
	
	private static double getTip(Scanner input) {											// method asks for tip amount and returns tip percentage
		System.out.println("What size tip would you like to leave?");
		System.out.println("1. Good service - 10%");
		System.out.println("2. Great service - 15%");
		System.out.println("3. Outstanding service - 20%");
		System.out.print("Enter the number of your choice: ");
		int choice = input.nextInt();
		double tip = 0;
		
		switch (choice) {
			case 1: 
				tip = 0.1;																	// 10% tip
				break;
			case 2: 
				tip = 0.15;																	// 15% tip
				break;
			case 3: 
				tip = 0.2;																	// 20% tip
				break;
		}
		
		System.out.println();
		return tip;
	}
}
