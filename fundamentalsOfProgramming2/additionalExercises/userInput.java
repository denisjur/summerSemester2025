package myjavaproject;

import java.util.Scanner;

public class userInput {
	public static void main (String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		// What is your name? String
		System.out.println("What is your name?");
		String name = scanner.nextLine();
		System.out.println("Hello " +name +"!");
		
		//What is your age? Integer
		System.out.println("What is your age?");
		int age = scanner.nextInt();
		System.out.println(age+ " is a very nice age!");
		
		scanner.nextLine(); // <- ca sa poata sa i-ti citeasca urmatorul input ca String
		
		// What is your favorite food? String
		System.out.println("What is your favorite food?");
		String food = scanner.nextLine();
		System.out.println("I also like " +food + "! :D");
		
	}
}
