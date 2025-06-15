package lambdas;

public class Main {

	public static void main(String[] args) {
		// ****************************************************************************************
		/*
		 * Lambda-Ausdruck = Funktion ab Java 8 und höher
		 *                   auch bekannt als anonyme Methode
		 *                   eine kürzere Art, anonyme Klassen mit nur einer Methode zu schreiben
		 *
		 * Erfordert die Verwendung eines funktionalen Interfaces 
		 * (entweder vordefiniert oder selbst erstellt)
		 * Funktionale Interfaces enthalten genau eine abstrakte Methode
		 * Beispiele: ActionListener, Runnable, (benutzerdefiniert)
		 *
		 * Ein Lambda-Ausdruck kann überall dort verwendet werden,
		 * wo eine funktionale Schnittstelle benötigt wird
		 *
		 * Syntax eines Lambda-Ausdrucks:
		 * (Argumente) -> { Anweisung(en) }
		 */
		// ****************************************************************************************

		
		// 1) Lambda Example for User-defined Interfaces!!!
		
			//		MyInterface myInterface = () -> System.out.println("Hello world"); // Aici am spus ce o sa 
			//																		   // faca myInterface, deci display ...
			//		myInterface.message(); // Iar aici noi, chemam functia message, care face ce vine dupa Pfeil.
			//	
					// Fara Lambda, ai scrie, clasa anonyma mult mai lung, asa ca cu Lambda e mult mai scurt
					//	MyInterface myInterface = new MyInterface() {
					//	    @Override
					//	    public void message() {
					//	        System.out.println("Hello world");
					//	    }
					//	};
					//	myInterface.message();
			
					String name = "Bro";
					char symbol = '!';
			
					MyInterface myInterface = (x, y) -> {
					    System.out.println("Heello World!");
					    System.out.println("It is a nice day " + x + y);
					};
					myInterface.message(name, symbol);
					
					// Mai facem un interface, pentru ca avem voie:
					MyInterface myInterface2 = (x, y) -> {
					    System.out.println("Hello " + x + y);
					};
					myInterface2.message(name, symbol);
					
					/*
					- Poți declara mai multe interfețe diferite în codul tău. AMandou fac chestii diferite.
					- Poți avea mai multe implementări ale aceleiași interfețe, cu comportamente diferite.
					- O clasă poate implementa mai multe interfețe (Java suportă „multiple inheritance” prin interfeț	e).
					*/
					
		// 2) Labda Example for Pre-defined Interfaces: like ActionListener, Runnable, etc.
					
					MyFrame myFrame = new MyFrame();
					
					
	
	}

}
