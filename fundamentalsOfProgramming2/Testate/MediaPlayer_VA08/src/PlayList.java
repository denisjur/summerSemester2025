import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.AbstractList;
import java.io.File;


public class PlayList {

	private LinkedList<AudioFile> audioFiles;
	private int current; // atribut pentru pozitia curenta

	/*
	 * Constructorul implicit care initializeaza o PlayList goala
	 */
	public PlayList() {
		audioFiles = new LinkedList<>();
		current = -1; // pozitie invalida pentru inceput
	}

	/*
	 * Constructor care initializeaza
	 */
	public PlayList(String pathname) {
		this(); // initializeaza obiectul folosind contructorul implicit
		loadFromM3U(pathname);
	}

	/**
	 * Adauga un fisier audio in lista
	 * 
	 * @param file fisierul audio de adaugat
	 */
	public void add(AudioFile file) {
		if (file != null) {
			audioFiles.add(file);
			// Nur wenn current noch -1 ist und Liste nun genau 1 Element hat
			if (current == -1 && audioFiles.size() == 1) {
				current = 0;
			}
		}
	}

	public void remove(AudioFile file) {
		audioFiles.remove(file);

		// actualizam current daca este necesar
		if (audioFiles.isEmpty())
			current = -1;
		else if (current >= audioFiles.size()) {
			current = 0;
		}
	}

	public int size() {
		return audioFiles.size();
	}

	public void setCurrent(int position) {
		current = position;
	}

	public int getCurrent() {
		// Falls current noch nie gesetzt wurde aber Liste nicht leer ist
		if (current == -1 && !audioFiles.isEmpty()) {
			current = 0;
		}
		return current;
	}

	public void nextSong() {
		if (audioFiles.isEmpty()) {
			current = -1;
			return;
		}

		// Nur falss current in gultigem Bereich liegt, inkrementieren
		if (current >= 0 && current < audioFiles.size()) {
			current = (current + 1) % audioFiles.size(); // ciclicitate
		} else {
			current = 0; // fallback bei ungültigem current
		}
	}

	public List<AudioFile> getList() {
	    return new AbstractList<AudioFile>() {
	        @Override
	        public AudioFile get(int index) {
	            return audioFiles.get(index);
	        }

	        @Override
	        public int size() {
	            return audioFiles.size();
	        }

	        @Override
	        public boolean add(AudioFile file) {
	            boolean added = audioFiles.add(file);
	            if (current == -1 && audioFiles.size() == 1) {
	                current = 0;
	            }
	            return added;
	        }

	        @Override
	        public void add(int index, AudioFile element) {
	            audioFiles.add(index, element);
	            if (current == -1 && audioFiles.size() == 1) {
	                current = 0;
	            }
	        }

	        @Override
	        public AudioFile remove(int index) {
	            AudioFile removed = audioFiles.remove(index);
	            if (audioFiles.isEmpty()) {
	                current = -1;
	            } else if (current >= audioFiles.size()) {
	                current = 0;
	            }
	            return removed;
	        }
	    };
	}


	public AudioFile currentAudioFile() {
		if (current >= 0 && current < audioFiles.size())
			return audioFiles.get(current);

		return null;
	}

	public void loadFromM3U(String pathname) {
		// reset of PlayList
		audioFiles.clear();
		current = -1;

		try {
			File file = new File(pathname);
			if (!file.exists()) {
			    throw new RuntimeException("File does not exist: " + pathname);
			}
			BufferedReader reader = new BufferedReader(new FileReader(file));

			String line;

			while ((line = reader.readLine()) != null) {
				line = line.trim();

				// skip the comments
				if (line.isEmpty() || line.startsWith("#")) {
					continue;
				}

				try {
					AudioFile audioFile = AudioFileFactory.createAudioFile(line);
					add(audioFile);
				} catch (RuntimeException e) {
					System.err.println("Skipping file: " + e.getMessage());
				}
			}

		} catch (IOException e) {
			// System.err.println("Error loading playlist from " + pathname + ": " +
			// e.getMessage())
		}
		if (!audioFiles.isEmpty()) {
			current = 0;
		}

	}

	/**
	 * Salveaza lista de redare in format M3U
	 * 
	 * @param pathname calea catre fisierul de iesire
	 */
	public void saveAsM3U(String pathname) {
		try (PrintWriter writer = new PrintWriter(new FileWriter(pathname))) {
			for (AudioFile file : audioFiles) {
				writer.println(file.getPathname());
			}
		} catch (IOException e) {
			System.err.println("Error saving playlist to: " + pathname + ": " + e.getMessage());
		}
	}

}