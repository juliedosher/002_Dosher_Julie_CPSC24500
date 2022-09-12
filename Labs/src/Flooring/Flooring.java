package Flooring;

public class Flooring {
	public static void main(String[] args) {
		double packageCost = 24.99;
		double boardSize = 2 * 0.5;															// size in square feet
		double packageOfBoardsSize = 8 * boardSize;											// total size of package in square feet
		
		double area = (15*8) + (17*7) + ((8*9)/2);
		double flooringNeeded = area * 1.25;												// total flooring needed, including 25% extra
		
		int packagesNeeded;
		if (flooringNeeded % packageOfBoardsSize == 0) {									
			packagesNeeded = (int)(flooringNeeded / packageOfBoardsSize);
		} else {
			packagesNeeded = (int)(flooringNeeded / packageOfBoardsSize) + 1;				// this accounts for situations where the flooring needed is rounded down
		}
			
		double cost = packagesNeeded * packageCost;
		
		System.out.println("Number of packages of boards needed: " + packagesNeeded);
		System.out.println("Cost: $" + cost);
		
		
		
	}
}
