package wnba;

public class WNBA {

	public static void main(String[] args) {
		printHeading();

	}
	
	
	private static void printHeading() {
		String asterisks = "*".repeat(51);
		String header = "2022 WNBA STANDINGS";
		String space = " ".repeat((asterisks.length()-header.length())/2);
		header = space + header + space;
		
		System.out.println(asterisks);
		System.out.println(header);
		System.out.println(asterisks);
	}

}
