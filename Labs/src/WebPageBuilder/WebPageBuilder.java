package WebPageBuilder;

import java.util.Scanner;

public class WebPageBuilder {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.println("***************************************************");
		System.out.println("               WEBPAGE BUILDER V1.0");
		System.out.println("***************************************************\n");
		
		System.out.println("This application helps you build a basic web page");					// prints instructions for user
		System.out.println("by asking you a series of questions. Just answer");
		System.out.println("each question, and I'll populate your new web page");
		System.out.println("with your responses.\n");
		
		System.out.print("What is your name? ");													// asks user for data to plug into web page
		String name = input.nextLine();
		System.out.print("How old are you? ");
		int age = input.nextInt();
		input.nextLine(); 																			// clears end of line character
		System.out.print("Where do you live? ");
		String location = input.nextLine();
		System.out.print("When you grow up, you want to be... ");
		String futureJob = input.nextLine();
		System.out.print("What are your two favorite integers? ");
		int favInt1 = input.nextInt();
		int favInt2 = input.nextInt();
		
		
		System.out.println("Here is the code for your web page:");									// prints HTML for web page, using user data
		System.out.println("<html>");
		System.out.println("<head><title>" + name + "'s Web Page</title></head>");
		System.out.println("<body>");
		System.out.println("<h1>Welcome to " + name + "'s Web Page</h1>");
		System.out.println("<p>I am " + age + " years (or " + (12*age) 
				+ " months!) old and live in " + location + ".</p>");
		System.out.println("<p>When I grow up, I want to be " + futureJob +".</p>");
		System.out.println("<p>My two favorite integers are " + favInt1 + " and " + favInt2 
				+ ". Their quotient is " + String.format("%.3f",(double)favInt1 / (double)favInt2) + ".</p>");
		System.out.println("<p>Thank you for visiting my page!</p>");
		System.out.println("</body>");
		System.out.println("</html>");
		
		input.close();																				// closes scanner
	}
}
