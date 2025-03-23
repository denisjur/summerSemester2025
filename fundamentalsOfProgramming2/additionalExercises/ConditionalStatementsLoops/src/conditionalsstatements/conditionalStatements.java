package conditionalsstatements;

import java.util.Iterator;
import java.util.Scanner;

public class conditionalStatements {
	public static void main(String[] args) {
		  
		
		// IF-Statement = performs a block of code if it's condition evaluates to true
		     int age = 75;

		     if (age == 75) {
		         System.out.println("Ok Boomer!");
		     } else if (age >= 18) {
		         System.out.println("You are an adult!");
		     } else if (age >= 13) {
		         System.out.println("You are a teenager!");
		     } else {
		         System.out.println("You are a child!");
		     }

		     
		     
		// Switch = statement that allows a variable to be tested for equality against a list of values
		     String day = "Friday";

		     switch(day) {
		         case "Sunday": 
		             System.out.println("It is Sunday!");
		             break; //IMPORTANT daca nu pui break se executa codul ce urmeaza!
		         case "Monday": 
		             System.out.println("It is Monday!");
		             break;
		         case "Tuesday": 
		             System.out.println("It is Tuesday!");
		             break;
		         case "Wednesday": 
		             System.out.println("It is Wednesday!");
		             break;
		         case "Thursday": 
		             System.out.println("It is Thursday!");
		             break;
		         case "Friday": 
		             System.out.println("It is Friday!");
		             break;
		         case "Saturday": 
		             System.out.println("It is Saturday!");
		             break;
		             
		             default: System.out.println("That is not a day!"); //IMPORTANT in caz ca scriitorul baga altceva inafara de zile
		     }

		     
		     
		     
		// While Loop =  executes a block of code as long as its condition remains true

		     Scanner scanner = new Scanner(System.in);
		     String name = "";

		     while(name.isBlank()) { //IMPORTANT isBlank inseamna, daca nu scrie nimic si apasa enter
		         System.out.print("Enter your name: ");
		         name = scanner.nextLine();
		     }

		     System.out.println("Hello " + name);
		
		     
		     
		// DO-While Loop = E o variatie. Aici, macar o data se va executa prima parte din cod. La while, poate sa nu fie executata nici macar o data

		    do { 
		    	System.out.print("Enter your name: ");
		        name = scanner.nextLine();
		     } while (name.isBlank()); //IMPORTANT isBlank inseamna, daca nu scrie nimic si apasa enter

		     System.out.println("Hello " + name);
		    
		
		
		// FOR-Loop = Ist ein endlicher Loop, while dagegen ist ein loop das für die Ewigkeit so weitergehen würde

		    for (int i = 10; i >= 0; i--) {
		        System.out.println(i);
		    }

		    System.out.println("Happy new year!");
		    
		    
		    
		// Nested Loops = a loop inside a loop
		    
		    Scanner scanner2 = new Scanner(System.in);
		    int rows;
		    int columns;
		    String symbol = "";
		    
			    // Eingabe
			    System.out.println("Enter number of rows: ");
			    rows = scanner2.nextInt();
			    
			    System.out.println("Enter number of columns: ");
			    columns = scanner2.nextInt();
			    
			    System.out.println("Enter symbol to use: ");
			    symbol = scanner2.next();
			    
			    //Loops
			    for (int i = 1; i<=rows; i++) {
			    	System.out.println();
			    	for(int j=1; j<=columns; j++) {
			    		System.out.print(symbol);
			    	}
			    }
		    
		    
		    
		    
		    

		    
		 
		     
		 
	}
}
