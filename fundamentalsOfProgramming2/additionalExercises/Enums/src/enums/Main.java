package enums;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		// Ein enum (Abkürzung für "enumeration") ist ein spezieller Klassentyp in Java.
		// Er wird verwendet, um eine feste Liste von Konstanten zu definieren.
		// More efficient with switches than strings.
		// Beispiel: Wochentage (MONDAY, TUESDAY, ..., SUNDAY)

		// Vorteile:
		// - Typsicherheit: Man kann nur gültige Werte verwenden.
		// - Übersichtlich: Klare Lesbarkeit statt String-Vergleiche.
		// - Erweiterbar: Kann Konstruktoren, Methoden, Felder enthalten.
		
	    Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a day of the week: "); // Benutzeraufforderung im Terminal
        String response = scanner.nextLine().toUpperCase(); // Eingabe lesen & in Großbuchstaben umwandeln

        try {
            // Wandelt den String in das passende Enum-Objekt um (z. B. "MONDAY" → Day.MONDAY)
            Day day = Day.valueOf(response);

            // Gibt den eingegebenen Tag aus
            System.out.println(day);  // z. B. Output: MONDAY

            // Gibt die zugehörige Tagesnummer aus (siehe getDayNumber in Enum)
            System.out.println(day.getDayNumber()); // z. B. Output: 1

            // Enhanced Switch (ab Java 14): prüft, ob Weekday oder Weekend
            switch (day) {
                case MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY -> System.out.println("It is a weekday"); 
             // Wochentag-Ausgabe. Man benutzt ein Pfeil ( -> ), da wir hier ein enhanced Switch haben
                case SATURDAY, SUNDAY -> System.out.println("It is weekend"); // Wochenende-Ausgabe
            }

        } catch (IllegalArgumentException someName) {
            // Wird aufgerufen, wenn die Eingabe kein gültiger Enum-Wert ist
            System.out.println("Please enter a valid day!"); // z. B. bei "blabla"
        }
    }
       
}
