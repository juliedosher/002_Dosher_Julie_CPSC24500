package CircleCalc;

public class CircleCalc {
	
	public static void main(String[] args) {
		int randomRadius = (int)(Math.random() * 100);							// determines a random radius (integer) between 0 - 100
		double circumference = calculateCircumference(randomRadius);
		double area = calculateArea(randomRadius);
		
		System.out.println("Radius: " + randomRadius);
		System.out.println("Circumference: " + circumference);
		System.out.println("Area: " + area);
	}
	
	
	private static double calculateCircumference(int radius) {					// calculates circle's circumference 
		return 2 * Math.PI * radius;
	}
	
	private static double calculateArea(int radius) {							// calculates circle's area
		return Math.PI * radius * radius;
	}
}
