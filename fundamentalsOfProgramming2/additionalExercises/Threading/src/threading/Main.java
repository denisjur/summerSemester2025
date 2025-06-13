package threading;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// ***********************************************************************************************
		//
		// Threading = Ermöglicht es einem Programm, mehrere Aufgaben gleichzeitig (parallel) auszuführen
		//       	→ z. B. Benutzeroberfläche bleibt responsiv, während im Hintergrund gearbeitet wird
		//
		// Vorteile:
		//			- Verbessert die Leistung bei zeitintensiven Aufgaben
		//			- Ideal für: Dateioperationen (File I/O), Netzwerkkommunikation,
		//       				  oder allgemeine Hintergrundprozesse
		//
		// Wie erstellt man einen Thread?
		//
		//			-  Option 1: Die Thread-Klasse erweitern  → einfacher, aber weniger flexibel
		//			=> Option 2: Das Runnable-Interface implementieren → besser (da flexibler & trennbar)
		//
		// ***********************************************************************************************

		
		// Beispiel: Wir erstellen eine Art Spiel – der Spieler hat 5 Sekunden Zeit zu antworten
		// Hinweis: Im Moment läuft alles im Main-Thread (keine Nebenläufigkeit aktiv)

		Scanner scanner = new Scanner(System.in);
		
		// Im Hintergrund soll das passieren: Dieser Block simuliert eine Zeitbegrenzung (z. B. Countdown).
		// Er läuft jedoch im Main-Thread und blockiert daher die Eingabe.
		// Das bedeutet: Solange dieser Block läuft, kann der Benutzer nichts eintippen.
		// => Um echte Gleichzeitigkeit zu erreichen, müsste man diesen Block in einen separaten Thread auslagern.


		// => Lösung wäre: Diesen Block in einen separaten Thread auslagern, so wie in "MyRunable"
		
//		for (int i = 1; i <= 5; i++) {
//			try {
//				Thread.sleep(1000); // Wartet 1000 ms (1 Sekunde)
//			} catch (InterruptedException e) {
//				System.out.println("Thread was interrupted");
//			};
//			
//			if (i == 5) {
//				System.out.println("Time is up!");
//			}
//		}
		
		// In Background, pe alt Thread
		
		MyRunnable myRunnable = new MyRunnable(); // Aici insertam objectul myRunable
		Thread thread = new Thread(myRunnable); // Acum ii dam ca argument la thread constructor, objectul myRunable
		thread.setDaemon(true); // DAEMON THREAD = Ends when Main Thread is over!
		thread.start(); //Acum incepe threadul
		
		// Im Vordergrund passiert:
		System.out.println("You have 5 seconds to enter your name!");
		System.out.println("Enter your name: ");
		String name = scanner.nextLine(); // Eingabe durch den Benutzer
		System.out.println("Hello " + name + "!"); // Begrüßungsausgabe

		// Hinweis: Wenn man oben den Zeit-Thread aktivieren würde,
		// müsste dieser parallel (in einem echten Thread) laufen,
		// sonst blockiert er die Eingabe hier unten.

		scanner.close();
	}
}
