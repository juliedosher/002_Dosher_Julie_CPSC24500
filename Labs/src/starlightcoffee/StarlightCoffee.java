package starlightcoffee;

import java.util.Scanner;

public class StarlightCoffee {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		printHeading();
		String name = getName(input);
		double coffeePrice =  getCoffeeOrder(input);
		
	}
	
	
	private static void printHeading() {
		System.out.println("*************************************");
		System.out.println("STARLIGHT COFFEE POINT-OF-SALE SYSTEM");
		System.out.println("*************************************\n");
	}
	
	private static String getName(Scanner input) {
		System.out.print("What is your name? ");
		String name = input.nextLine();
		System.out.println();
		return name;
	}

	private static double getCoffeeOrder(Scanner input) {
		System.out.println("What kind of coffee do you want?");
		System.out.println("1. Americano");
		System.out.println("2. Italiano");
		System.out.println("3. Espresso");
		System.out.println("4. Cappuccino");
		System.out.println("Enter the number of your choice: ");
		int choice = input.nextInt();
		double price = 0;
		
		switch (choice) {
			case 1:
				price = 2.25;
				break;
			case 2:
				price = 2.75;
				break;
			case 3: 
				price = 3.5;
				break;
			case 4: 
				price = 3.75;
				break;
			default:
				System.out.println("Invalid choice. Please try again");
				getCoffeeOrder(input);	
		}
		
		return price;
	}
}
