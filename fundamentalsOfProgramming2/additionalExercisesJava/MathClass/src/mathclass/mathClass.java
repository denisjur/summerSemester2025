package mathclass;

import java.util.Scanner;

public class mathClass {

	public static void main(String[] args) {
		double x = 3.14;
		double y = -10;
		
		// Mathematische Funktionen
		double z = Math.max(x, y); //IMPORTANT Aici iti trebuie methoda Math.max() ca sa gasesti maximul
		double e = Math.abs(y);	// Zeigt den absoluten Wert an, also den Betrag
		double f = Math.sqrt(x); //Wurzel
		double g = Math.round(x);
		double h = Math.ceil(x); //ceiling, will always round up
		
		//Output
		System.out.println(z);
		System.out.println(e);
		System.out.println(f);
		System.out.println(g);
		System.out.println(h);
		
		
			// Programm, welches die Hypothenuse berechnet
			double a;
			double b;
			double c;
		
			// Lesen der Eingabe
			Scanner scanner = new Scanner(System.in);
			System.out.println("Introduce value for a: ");
			a = scanner.nextDouble();
			System.out.println("Introduce value for b: ");
			b = scanner.nextDouble();
		
			//Berechnung
			c = Math.sqrt((a*a) +(b*b));
			
			//Output:
			System.out.println("The Hypothenuse of a and b is " +c);
			
			//Close Scanner
			scanner.close();
			
		
	}
}
