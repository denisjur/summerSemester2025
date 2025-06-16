package studiplayer.audio;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class ControllablePlayListIterator implements Iterator {

	private List<AudioFile> playlist;
	private int currentPosition;

	/**
	 * Constructorul1 clasei pentru basic iterator
	 * 
	 * @param list - lista de AudioFile instance to iterate over
	 */
	public ControllablePlayListIterator(List<AudioFile> list) {
		if (list == null) {
			throw new IllegalArgumentException("List cannot be null");
		}
		this.playlist = new ArrayList<>(list);
		this.currentPosition = 0;
	}

	/**
	 * constructor2 cu search si sort criteria
	 *
	 */
	public ControllablePlayListIterator(List<AudioFile> list, String search, SortCriterion sort) {
		if (list == null) {
			throw new IllegalArgumentException("List cannot be null");
		}

		// cream o lista filtrata
		List<AudioFile> filteredList = new ArrayList<>();

		if (search != null && !search.isEmpty()) {
			for (AudioFile file : list) {
				// check Author, title, or album for search string
				String author = file.getAuthor() != null ? file.getAuthor().toLowerCase() : "";
				String title = file.getTitle() != null ? file.getTitle().toLowerCase() : "";
				String album = "";

				if (file instanceof TaggedFile) {
					album = ((TaggedFile) file).getAlbum() != null ? ((TaggedFile) file).getAlbum().toLowerCase() : "";
				}

				if (author.contains(search.toLowerCase()) || title.contains(search.toLowerCase())
						|| album.contains(search.toLowerCase())) {
					filteredList.add(file);
				}
			}
		} else {
			filteredList.addAll(list);
		}

		// sortam lista filtrata dupa criteriul specificat
		switch (sort) {
			case AUTHOR:
				Collections.sort(filteredList, new AuthorComparator());
				break;
			case TITLE:
				Collections.sort(filteredList, new TitleComparator());
				break;
			case ALBUM:
				Collections.sort(filteredList, new AlbumComparator());
				break;
			case DURATION:
				Collections.sort(filteredList, new DurationComparator());
				break;
			default:
				// keine Sortierung
		}

		this.playlist = new ArrayList<>(filteredList);
		this.currentPosition = 0;
	}

	@Override
	public boolean hasNext() {
		return !playlist.isEmpty() && currentPosition < playlist.size();
	}

	@Override
	public AudioFile next() {
		if (!hasNext()) {
			// ⚠Reset NICHT automatisch hier machen!1!
			return null;
		}
		return playlist.get(currentPosition++);
	}

	/**
	 * Jumps to the specified AudioFile and positions iterator to return the next
	 * file
	 * 
	 * @param file Audiofile to jump to
	 * @return the file parameter if found in the list , null otherwise
	 */
	public AudioFile jumpToAudioFile(AudioFile file) {
		if (file == null || playlist.isEmpty())
			return null;

		for (int i = 0; i < playlist.size(); ++i) {
			if (playlist.get(i).getPathname().equals(file.getPathname())) { 
				currentPosition = i + 1;
				return playlist.get(i);
			}
		}
		return null;
	}
}
