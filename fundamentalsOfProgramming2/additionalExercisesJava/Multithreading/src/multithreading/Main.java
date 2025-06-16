package multithreading;

public class Main {

	public static void main(String[] args) {
		// *******************************************************************************************************		
		// Multithreading = Erlaubt einem Programm, mehrere Threads gleichzeitig (parallel) auszuführen
		// 					→ Nützlich für Hintergrundaufgaben oder zeitintensive Prozesse
		//
		// Ein Thread = Eine Abfolge von Anweisungen, die unabhängig läuft (z. B. ein Timer, eine Netzwerkanfrage)
		//
		// Vorteile:
		// - Erhöht die Performance
		// - Blockiert nicht den Hauptthread (z. B. Benutzeroberfläche bleibt aktiv)
		// - Ermöglicht gleichzeitiges Arbeiten (z. B. Benutzer tippt, während Countdown läuft)
		//
		// *******************************************************************************************************
	
		
		// In loc de a scrie asa:
		// Runnable-Objekt erstellen
		// MyRunnable myRunnable = new MyRunnable();
		
		// Thread mit diesem Runnable starten
		// Thread thread = new Thread(myRunnable);
		// thread.start(); // Startet den Thread (führt run() aus)
	
		// Mult mai efficient:
		Thread thread = new Thread(new MyRunnable("PING"));
		Thread thread2 = new Thread(new MyRunnable("PONG"));
		
		System.out.println("Game start!");
		
		thread.start(); // Startet den Thread (führt run() aus)
		thread2.start(); // Startet den zweiten Thread
		
		// Dupa ce incep Threadurile, scriem aici thread.join ca sa astepte systemul pana termina threadurile
		try {
		    thread.join();  // Wartet, bis thread1 vollständig beendet ist
		    thread2.join();  // Wartet, bis thread2 vollständig beendet ist
		} catch (InterruptedException e) {
		    System.out.println("Main thread was interrupted");  // Wird aufgerufen, wenn der Main-Thread beim Warten 
		    													// gestört wird
		}

		
		System.out.println("Game over!");
		
		
		// Output: 
		//		Game start!
		//		PING
		//		PONG
		//		PONG
		//		PING
		//		PING
		//		PONG
		//		PONG
		//		PING
		//		PING
		//		PONG
		//		Game over!

	
	
	
	}

}
