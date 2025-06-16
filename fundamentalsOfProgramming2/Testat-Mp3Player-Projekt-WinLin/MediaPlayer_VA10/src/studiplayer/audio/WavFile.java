package studiplayer.audio;

import studiplayer.basic.WavParamReader;
import studiplayer.basic.BasicPlayer;


public class WavFile extends SampledFile {

	// Constructor implicit (fara parametri)
	public WavFile() {
		super();
	}

	// Constructor care primeste calea fisierului si seteaza durata din fisierul WAV
	// modificat pentru a arunca NotPlayableException
	public WavFile(String path) throws NotPlayableException {
		super(validatePath(path)); // ruft den AudioFile-Konstruktor auf
		readAndSetDurationFromFile(); // laedt die Dauer direkt aus der Datei
	}

	// Methode die vor super() prüft, ob .wav erlaubt ist
	private static String validatePath(String path) throws NotPlayableException {
		// testul cere explicit .mp3 in WavFile – tratam ca eroare intentionat
		if (!path.toLowerCase().endsWith(".wav")) {
			throw new NotPlayableException(path, "Falsches Dateiformat für WavFile");
		}
		return path;
	}

	// Aceasta metoda citeste parametrii fisierului WAV si calculeaza durata
	public void readAndSetDurationFromFile() throws NotPlayableException {
		try {

			WavParamReader.readParams(getPathname()); // lese Metadaten aus der WAV-Datei

			float frameRate = WavParamReader.getFrameRate(); // Frames pro Sek
			long numberofFrames = WavParamReader.getNumberOfFrames(); // Total frames im File

			this.duration = computeDuration(numberofFrames, frameRate); // calculeaza durata in microsecunde
		} catch (Exception e) {
			throw new NotPlayableException(getPathname(), "Fehler beim Lesen der WAV-Datei", e);
		}

	}

	// Calculul duratei in microsecunde bazat pe frameRate si numberOfFrames
	public static long computeDuration(long numberOfFrames, float frameRate) {
		return Math.round((1_000_000.0 * numberOfFrames) / frameRate); // formula clasica
	}

	// Returneaza o reprezentare text a obiectului cu durata inclusa
	@Override
	public String toString() {
		return super.toString() + " - " + formatDuration(); // de forma "Author - Titel - 05:45"
	}

	// Foloseste formatterul existent din SampledFile pentru a formata durata
	public static String timeFormatter(long microseconds) {
		return SampledFile.timeFormatter(microseconds); // delegare catre clasa parinte
	}

}
