package dsasd;
import java.util.Scanner;

public class Main57 {
	public static void main(String[] args) {
		

		    Scanner scanner = new Scanner(System.in);

		    String[] foods = new String[3];

		    for(int i = 0; i < foods.length; i++){
		        System.out.print("Enter a food: ");
		        foods[i] = scanner.nextLine();
		    }

		    for(String food : foods){
		        System.out.println(food);
		    }

		    scanner.close();
		}		 
	}
