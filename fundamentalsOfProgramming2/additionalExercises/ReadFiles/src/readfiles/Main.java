package readfiles;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class Main {
	public static void main(String[] args) {
	// 📚 Wie man in Java eine Datei liest (3 beliebte Optionen)

	// 1. BufferedReader + FileReader
	// ✅ Beste Methode für Textdateien – besonders zum Zeilenweise-Lesen
	// Beispiel: logs.txt, daten.csv
	//
	// 2. FileInputStream
	// ✅ Geeignet für Binärdateien (z. B. Bilder, Musik, PDFs)
	// Beispiel: foto.jpg, sound.mp3, dokument.pdf
	//
	// 3. RandomAccessFile
	// ✅ Ideal, um gezielt Teile einer großen Datei zu lesen oder zu überschreiben
	// Beispiel: große Datenbankdateien, bei denen man gezielt auf bestimmte Positionen zugreift
	
	 String filePath = "C:\\Users\\User\\Desktop\\test1.txt";

     try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
         String line;
         // Zeile für Zeile lesen, bis Ende der Datei
         while ((line = reader.readLine()) != null) {
             System.out.println(line);
         }

     } catch (FileNotFoundException someName) {
         System.out.println("Could not locate file");
     } catch (IOException someOtherName) {
         System.out.println("Something went wrong");
     }

}
}