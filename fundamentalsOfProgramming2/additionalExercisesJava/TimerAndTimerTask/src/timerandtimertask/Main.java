package timerandtimertask;

import java.util.Timer;
import java.util.TimerTask;

public class Main {

	public static void main(String[] args) {
		// Timer = Klasse, die Aufgaben zu bestimmten Zeiten oder wiederholt ausführt
		//      Nützlich für: Benachrichtigungen, geplante Updates, wiederholende Aktionen

		//TimerTask = Repräsentiert die Aufgabe, die vom Timer ausgeführt wird
		//           Man erweitert TimerTask und überschreibt die run()-Methode
		
		Timer timer = new Timer();
		TimerTask task = new TimerTask() {
		int count = 5; // z. B. Anzahl Wiederholungen
			@Override
		    public void run() {
		        System.out.println("Hello!");
		        count--;  // Zähler verringern

		        if (count < 0) {
		            System.out.println("TASK COMPLETE!");
		            timer.cancel(); // Stoppt den Timer und alle geplanten Aufgaben
		        }
		    }
		};

		// Wiederholt die Aufgabe jede Sekunde (1000 Millisekunden)
		timer.schedule(task, 0, 1000);

	}

}
