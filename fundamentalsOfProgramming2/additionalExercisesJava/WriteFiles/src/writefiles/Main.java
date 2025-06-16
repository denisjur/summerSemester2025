package writefiles;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

	public static void main(String[] args) {
		// 🔹 Wie man in Java eine Datei schreibt (4 beliebte Möglichkeiten):

		// 1. FileWriter
		// ✔️ Gut für kleine bis mittelgroße Textdateien
		// Beispiel: writeText.txt, einfache Textinhalte

		// 2. BufferedWriter
		// ✔️ Bessere Leistung bei größeren Textmengen
		// Beispiel: große Logs, viele Zeilen Text → wird gepuffert geschrieben

		// 3. PrintWriter
		// ✔️ Ideal für strukturierte Textdaten wie Berichte oder Log-Dateien
		// Beispiel: Schreiben mit format(), println() usw.

		// 4. FileOutputStream
		// ✔️ Beste Wahl für Binärdateien (z. B. Bilder, Audio-Dateien, PDF)
		// Beispiel: image.jpg, sound.mp3, dokument.pdf

		String textContent= """
			Asta folosesti daca ai mai multe 
			lini de scris in text.
			Bun pentru paragrafe.	
		""";
		
		try (FileWriter writer = new FileWriter("C:\\Users\\User\\Desktop\\test.txt")) { //<- Asa pui text.txt pe desktop
	            writer.write(textContent);
	            System.out.println("File has been written");
	        } catch (IOException e) {
	            System.out.println("Konnte Datei nicht schreiben.");
	        }
		
		
	}

}
