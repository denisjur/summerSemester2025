package exception;
import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {

	public static void main(String[] args) {
		// ❗ Exception = Ein Ereignis, das den normalen Programmablauf unterbricht.
		// - Beispiele: Division durch null ODER Datei nicht gefunden ODER falscher Eingabetyp
		//				etc.
		// ➤ Solche Fehler können zur Laufzeit auftreten.
		//   Java unterbricht dann die Ausführung, es sei denn, du behandelst den Fehler.
		//
		// ✅ Lösung: Umgebe gefährlichen Code mit try{}, catch{}, finally{}:
		//
		// try {
		//		     // Gefährlicher Code, der eine Exception auslösen könnte
		// } 
		// catch (ExceptionTyp e) {
		//		     // Fehlerbehandlung: Was soll passieren, wenn ein Fehler auftritt?
		// } 
		// finally {
		//		     // (Optional) Wird **immer** ausgeführt – z. B. zum Aufräumen
		// }

		
		// Daca il lasam asa sa ruleze:
		// System.out.println(1/0);
		// primim in console: Exception in thread "main" java.lang.ArithmeticException: / by zero
		// at Exception/exception.Main.main(Main.java:25)
		
		
		try {
			System.out.println(1/0);
		} catch(ArithmeticException irgendEinName) {
			System.out.println("YOU CANNOT DIVIDE BY ZERO!");
		}

		// Other example:
		Scanner scanner = new Scanner(System.in);
		
		try {
			System.out.println("Enter a number: ");
			int number = scanner.nextInt();
			System.out.println(number);
		} catch(InputMismatchException irgendEinName) {
			System.out.println("This is not a Number!");
		} catch(ArithmeticException irgendEinName) {
			System.out.println("YOU CANNOT DIVIDE BY ZERO!");
		} catch(Exception irgendEinName) { // <-- Hier behandelst du jede Art von Exceptions!
											// <-- Safety Net!
			System.out.println("Something went wrong!");
		
		} finally { // Das ist optional und wird alles ausführen, unabhängig ob es ein Fehler gibt oder nicht!
			scanner.close(); // Unabhängig was passiert, wir wollen den Scanner schließen
							// Wird oft dafür benutzt um alles am Ende aufzuräumen
		}
		
		
		
	
	
	}	
}

