package studiplayer.audio;

import studiplayer.audio.TaggedFile;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.AbstractList;
import java.io.File;
import java.util.Iterator;

public class PlayList implements Iterable<AudioFile> {

	private LinkedList<AudioFile> audioFiles;
	private AudioFile currentFile;
	private String search;
	private SortCriterion sortCriterion;
	private ControllablePlayListIterator iterator; // Iterator für aktuelle Position

	/*
	 * Constructorul implicit care initializeaza o PlayList goala
	 */
	public PlayList() {
		audioFiles = new LinkedList<>();
		search = "";
		currentFile = null;
		sortCriterion = SortCriterion.DEFAULT;
		iterator = new ControllablePlayListIterator(audioFiles, search, sortCriterion); // initialisiere
	}

	/*
	 * Constructor care initializeaza
	 */
	public PlayList(String pathname) {
	    this();
	    try {
	        loadFromM3U(pathname);
	     iterator = new ControllablePlayListIterator(audioFiles, search, sortCriterion);
	     resetCurrentFile();

	    } catch (NotPlayableException e) {
	        System.err.println("Could not load M3U: " + e.getMessage());
	    }
	}



	public void add(AudioFile file) {
		if (file != null) {
			audioFiles.add(file);
			iterator = new ControllablePlayListIterator(audioFiles, search, sortCriterion);
			resetCurrentFile();
		}
	}

	public void remove(AudioFile file) {
		audioFiles.remove(file);
		iterator = new ControllablePlayListIterator(audioFiles, search, sortCriterion);
		resetCurrentFile();
	}

	public int size() {
		return audioFiles.size();
	}

	public void nextSong() {
		if (audioFiles.isEmpty()) {
			currentFile = null;
			return;
		}

		AudioFile next = iterator.next();

		if (next == null) {
			// Iterator ist am Ende -> New start
			iterator = new ControllablePlayListIterator(audioFiles, search, sortCriterion);
			next = iterator.next();
		}

		currentFile = next;
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
				iterator = new ControllablePlayListIterator(audioFiles, search, sortCriterion);
				resetCurrentFile();
				return added;
			}

			@Override
			public void add(int index, AudioFile element) {
				audioFiles.add(index, element);
				iterator = new ControllablePlayListIterator(audioFiles, search, sortCriterion);
				resetCurrentFile();
			}

			@Override
			public AudioFile remove(int index) {
				AudioFile removed = audioFiles.remove(index);
				iterator = new ControllablePlayListIterator(audioFiles, search, sortCriterion);
				resetCurrentFile();
				return removed;
			}
		};
	}

	public AudioFile currentAudioFile() {
		if (currentFile == null && !audioFiles.isEmpty()) {
			resetCurrentFile();
		}
		return currentFile;
	}

	public void loadFromM3U(String pathname) throws NotPlayableException {
		audioFiles.clear();

		try {
			File file = new File(pathname);
			if (!file.exists()) {
				throw new RuntimeException("File does not exist: " + pathname);
			}
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line;

			while ((line = reader.readLine()) != null) {
				line = line.trim();
				if (line.isEmpty() || line.startsWith("#")) {
					continue;
				}

				try {
					AudioFile audioFile = AudioFileFactory.createAudioFile(line);
					audioFiles.add(audioFile); // direkt hinzufügen - NICHT add() verwenden
				} catch (NotPlayableException e) {
					System.err.println("Skipping file: " + e.getMessage());
				}
			}
		} catch (IOException e) {
			// intentionally ignored
		}

		search = "";
		iterator = new ControllablePlayListIterator(audioFiles, search, sortCriterion);
		resetCurrentFile();
		setSortCriterion(sortCriterion); // ✨ wendet die aktuelle Sortierung korrekt an!

	}

	public void saveAsM3U(String pathname) {
		try (PrintWriter writer = new PrintWriter(new FileWriter(pathname))) {
			for (AudioFile file : audioFiles) {
				writer.println(file.getPathname());
			}
		} catch (IOException e) {
			System.err.println("Error saving playlist to: " + pathname + ": " + e.getMessage());
		}
	}

	public SortCriterion getSortCriterion() {
		return sortCriterion;
	}

	public void setSortCriterion(SortCriterion sortCriterion) {
	    this.sortCriterion = sortCriterion;

	    // Erst filter anwenden
	    List<AudioFile> filtered = new LinkedList<>();
	    String searchLower = search.toLowerCase();

	    for (AudioFile file : audioFiles) {
	        String author = file.getAuthor() != null ? file.getAuthor().toLowerCase() : "";
	        String title = file.getTitle() != null ? file.getTitle().toLowerCase() : "";
	        String album = (file instanceof TaggedFile && ((TaggedFile) file).getAlbum() != null)
	                       ? ((TaggedFile) file).getAlbum().toLowerCase()
	                       : "";

	        if (author.contains(searchLower) || title.contains(searchLower) || album.contains(searchLower)) {
	            filtered.add(file);
	        }
	    }

	    // Sorteaza:
	    switch (sortCriterion) {
	        case ALBUM:
	            filtered.sort(new AlbumComparator());
	            break;
	        case AUTHOR:
	            filtered.sort(new AuthorComparator());
	            break;
	        case TITLE:
	            filtered.sort(new TitleComparator());
	            break;
	        case DURATION:
	            filtered.sort((a1, a2) -> {
	                int cmp = Long.compare(a1.getRawDuration(), a2.getRawDuration());
	                if (cmp == 0) {
	                    cmp = a1.getAuthor().compareToIgnoreCase(a2.getAuthor());
	                    if (cmp == 0) {
	                        cmp = a1.getTitle().compareToIgnoreCase(a2.getTitle());
	                    }
	                }
	                return cmp;
	            });
	            break;
	        default:
	            // keine Sortierung
	    }

	    // Iterator auf der gefilterten und sortierten Liste
	    iterator = new ControllablePlayListIterator(filtered, "", SortCriterion.DEFAULT);
	    resetCurrentFile();
	
	}







	public String getSearch() {
		return search;
	}

	public void setSearch(String search) {
		this.search = search != null ? search : "";
		iterator = new ControllablePlayListIterator(audioFiles, this.search, sortCriterion);
		resetCurrentFile();
	}

	@Override
	public Iterator<AudioFile> iterator() {
		return new ControllablePlayListIterator(audioFiles, search, sortCriterion);
	}

	public AudioFile jumpToAudioFile(AudioFile file) {
	    if (file == null || audioFiles.isEmpty()) {
	        return null;
	    }
	    this.iterator = new ControllablePlayListIterator(audioFiles, search, sortCriterion);
	    AudioFile result = this.iterator.jumpToAudioFile(file);
	    if (result != null) {
	        this.currentFile = result;
	    }
	    return result;
	}


	private void resetCurrentFile() {
		if (audioFiles.isEmpty()) {
			currentFile = null;
			return;
		}

		iterator = new ControllablePlayListIterator(audioFiles, search, sortCriterion);

		if (iterator.hasNext()) {
			currentFile = iterator.next();
		} else {
			currentFile = null;
		}
	}

	@Override
	public String toString() {
		return iterator().hasNext() ? loopAsList().toString() : "[]";
	}

	private List<AudioFile> loopAsList() {
		List<AudioFile> result = new LinkedList<>();
		ControllablePlayListIterator it = new ControllablePlayListIterator(audioFiles, search, sortCriterion);
		while (it.hasNext()) {
			result.add(it.next());
		}
		return result;
	}

}