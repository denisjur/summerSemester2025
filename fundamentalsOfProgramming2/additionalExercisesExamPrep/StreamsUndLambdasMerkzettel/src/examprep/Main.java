package examprep;


//MegaCode-Sammlung: Java Threads – klausurtauglich & kommentiert
//Enthält 3 klassische Aufgaben mit Erklärung und Struktur:
//1. Eigenes Thread-Objekt mit Runnable (Zähler)
//2. Threads parallel starten (Countdown)
//3. Gemeinsamer Zugriff synchronisieren (Bankkonto)

//=======================================
//1. Eigenes Thread-Objekt mit Runnable
//=======================================
/*
Aufgabenstellung:
- Erstelle eine Klasse, die Runnable implementiert
- Lass sie eine Schleife ausführen (z. B. zählen)
- Starte den Thread im main()
*/

class Zaehler implements Runnable {
 private String name;

 public Zaehler(String name) {
     this.name = name;
 }

 public void run() {
     for (int i = 1; i <= 5; i++) {
         System.out.println(name + " zählt: " + i);
         try {
             Thread.sleep(500); // kurze Pause zwischen Ausgaben
         } catch (InterruptedException e) {
             e.printStackTrace();
         }
     }
 }
}

class ThreadDemo1 {
 public static void main(String[] args) {
     Thread t = new Thread(new Zaehler("Thread A"));
     t.start(); // Startet neuen parallelen Thread

     System.out.println("→ Hauptprogramm läuft weiter");
 }
}

//=======================================
//2. Mehrere Threads gleichzeitig (Countdown)
//=======================================
/*
Aufgabenstellung:
- Starte 2 Threads gleichzeitig
- Jeder führt seinen eigenen Countdown von 5 durch
*/

class Countdown implements Runnable {
 private String name;
 public Countdown(String name) { this.name = name; }

 public void run() {
     for (int i = 5; i >= 1; i--) {
         System.out.println(name + ": " + i);
         try { Thread.sleep(400); } catch (Exception e) { }
     }
     System.out.println(name + " beendet!");
 }
}

class ThreadDemo2 {
 public static void main(String[] args) {
     new Thread(new Countdown("Timer 1")).start();
     new Thread(new Countdown("Timer 2")).start();

     System.out.println("→ Beide Timer gestartet.");
 }
}

//=======================================
//3. Synchronisation: Bankkonto
//=======================================
/*
Aufgabenstellung:
- Erstelle ein Bankkonto mit Kontostand
- Starte 2 Threads, die gleichzeitig Geld abheben
- Verwende synchronized, um Race Conditions zu vermeiden
*/

class Bankkonto {
 private int kontostand = 100;

 public synchronized void abheben(String name, int betrag) {
     if (kontostand >= betrag) {
         System.out.println(name + " hebt " + betrag + "€ ab...");
         kontostand -= betrag;
         System.out.println("→ Neuer Stand: " + kontostand + "€");
     } else {
         System.out.println(name + ": Nicht genug Geld auf dem Konto!");
     }
 }
}

class Kunde implements Runnable {
 private Bankkonto konto;
 private String name;

 public Kunde(Bankkonto konto, String name) {
     this.konto = konto;
     this.name = name;
 }

 public void run() {
     for (int i = 0; i < 3; i++) {
         konto.abheben(name, 30);
         try { Thread.sleep(300); } catch (Exception e) { }
     }
 }
}

class ThreadDemo3 {
 public static void main(String[] args) {
     Bankkonto konto = new Bankkonto();

     Thread k1 = new Thread(new Kunde(konto, "Alice"));
     Thread k2 = new Thread(new Kunde(konto, "Bob"));

     k1.start();
     k2.start();
 }
}
