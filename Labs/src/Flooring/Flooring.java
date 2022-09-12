package Flooring;

public class Flooring {
	public static void main(String[] args) {
		double packageCost = 24.99;
		double boardSize = 2 * 0.5;						// converted to feet
		double packageOfBoardsSize = 8 * boardSize;
		
		double area = (15*8) + (17*7) + ((8*9)/2);
		double flooringNeeded = area * 1.25;
		
		int packagesNeeded;
		if (flooringNeeded % packageOfBoardsSize == 0) {
			packagesNeeded = (int)(flooringNeeded / packageOfBoardsSize);
		} else {
			packagesNeeded = (int)(flooringNeeded / packageOfBoardsSize) + 1;
		}
			
		double cost = packagesNeeded * packageCost;
		
		System.out.println("Number of packages of boards needed: " + packagesNeeded);
		System.out.println("Cost: $" + cost);
		
		
		
	}
}
