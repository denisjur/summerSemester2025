package dateAndTime;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;
import java.time.Instant;
import java.time.format.DateTimeFormatter;

public class Main {

	public static void main(String[] args) {
		// 🔹 Aktuelles Datum
        LocalDate date = LocalDate.now();
        System.out.println("Aktuelles Datum: " + date);
        // Beispiel-Ausgabe: Aktuelles Datum: 2025-06-12

        // 🔹 Aktuelle Uhrzeit
        LocalTime time = LocalTime.now();
        System.out.println("Aktuelle Uhrzeit: " + time);
        // Beispiel-Ausgabe: Aktuelle Uhrzeit: 14:45:08.325

        // 🔹 Aktuelles Datum + Uhrzeit
        LocalDateTime dateTime = LocalDateTime.now();
        System.out.println("Datum und Uhrzeit: " + dateTime);
        // Beispiel-Ausgabe: Datum und Uhrzeit: 2025-06-12T14:45:08.325

        // 🔹 UTC-Zeitstempel (Maschinenzeit)
        Instant instant = Instant.now();
        System.out.println("UTC Instant (Zeitstempel): " + instant);
        // Beispiel-Ausgabe: UTC Instant (Zeitstempel): 2025-06-12T12:45:08.325Z

        // 🔹 Formatieren (nur Datum, z. B. für Benutzeranzeige)
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String newDateTime = dateTime.format(formatter);
        System.out.println("Formatiertes Datum: " + newDateTime);
        // Beispiel-Ausgabe: Formatiertes Datum: 12-06-2025
    
        // Let us create a custom date time object:
        // 🔹 Erstelle ein festes Datum
        LocalDate xmas = LocalDate.of(2024, 12, 25);
        System.out.println("Weihnachten: " + xmas);
        // Ausgabe: Weihnachten: 2024-12-25

        // 🔹 Erstelle Datum + Uhrzeit
        LocalDateTime xmasTime = LocalDateTime.of(2024, 12, 25, 12, 0, 0);
        System.out.println("Weihnachten um 12 Uhr: " + xmasTime);
        // Ausgabe: Weihnachten um 12 Uhr: 2024-12-25T12:00

        // 🔹 Vergleich von zwei Zeitpunkten
        LocalDateTime date1 = LocalDateTime.of(2024, 12, 25, 12, 0, 0);
        LocalDateTime date2 = LocalDateTime.of(2025, 1, 1, 0, 0, 0);

        if (date1.isBefore(date2)) {
            System.out.println(date1 + " is earlier than " + date2);
            // Ausgabe: 2024-12-25T12:00 is earlier than 2025-01-01T00:00
        } else if (date1.isAfter(date2)) {
            System.out.println(date1 + " is later than " + date2);
        } else if (date1.isEqual(date2)) {
            System.out.println(date1 + " is equal than " + date2);
        }

	}

}
