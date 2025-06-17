package examprep;
 
//MegaCode-Sammlung: Java Exceptions – prüfungssicher & kommentiert
//Enthält 3 Aufgaben mit Struktur, Erklärung und allen Schlüsselkonzepten:
//1. Division mit Fehlerprüfung (try-catch)
//2. Eigene Exceptionklasse (UngültigeFarbeException)
//3. Sicheres Array-Zugreifen mit finally

//=======================================
//1. Division mit Fehlerprüfung (try-catch)
//=======================================
/*
Aufgabenstellung:
- Führe eine Division durch
- Fange Division durch null mit try-catch ab
*/

class DivisionDemo {
 public static void main(String[] args) {
     try {
         int a = 10;
         int b = 0;
         int c = a / b; // Fehler!
         System.out.println("Ergebnis: " + c);
     } catch (ArithmeticException e) {
         System.out.println("Fehler: Division durch 0 nicht erlaubt.");
     }
     System.out.println("Programm läuft weiter...");
 }
}

//=======================================
//2. Eigene Exceptionklasse + validieren
//=======================================
/*
Aufgabenstellung:
- Erstelle eigene Exception: UngueltigeFarbeException
- Prüfe, ob eine Farbe erlaubt ist (nur "rot", "blau")
- Wirf Fehler sonst, fange ihn im Hauptprogramm
*/

class UngueltigeFarbeException extends Exception {
 public UngueltigeFarbeException(String msg) {
     super(msg);
 }
}

class Farbpruefung {
 public static void setzeFarbe(String farbe) throws UngueltigeFarbeException {
     if (!farbe.equals("rot") && !farbe.equals("blau")) {
         throw new UngueltigeFarbeException("Farbe " + farbe + " ist ungültig!");
     }
     System.out.println("Farbe gesetzt: " + farbe);
 }

 public static void main(String[] args) {
     try {
         setzeFarbe("gelb");
     } catch (UngueltigeFarbeException e) {
         System.out.println("Fehler: " + e.getMessage());
     }
 }
}

//=======================================
//3. Sicheres Array mit finally-Block
//=======================================
/*
Aufgabenstellung:
- Greife auf Array-Element zu
- Fange IndexOutOfBoundsException ab
- Verwende finally-Block für Aufräumaktion
*/

class ArrayDemo {
 public static void main(String[] args) {
     int[] zahlen = {1, 2, 3};

     try {
         System.out.println("Zugriff: " + zahlen[5]); // Fehler!
     } catch (ArrayIndexOutOfBoundsException e) {
         System.out.println("Fehler: Ungültiger Index!");
     } finally {
         System.out.println("Aufräumen abgeschlossen (finally)");
     }

     System.out.println("Programm beendet.");
 }
}
