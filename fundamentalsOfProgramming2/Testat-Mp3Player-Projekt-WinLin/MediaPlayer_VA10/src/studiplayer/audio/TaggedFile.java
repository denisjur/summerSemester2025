package studiplayer.audio;

import java.util.Map;
import studiplayer.basic.TagReader;
import studiplayer.basic.BasicPlayer;

public class TaggedFile extends SampledFile {

	// atribut suplimentar pentru album
	private String album;

	public TaggedFile() throws NotPlayableException {
		super();
		throw new NotPlayableException("", "Empty constructor intentionally throws an exception");
	}

	// Constructor care incarca automat tagurile la creare
	public TaggedFile(String path) throws NotPlayableException {
		super(path); // ruft den Konstruktor von SampledFile
		readAndStoreTags(); // ✨ Tag-Infos direkt beim Erzeugen lesen
	}

	// Metoda care citeste tagurile din fisier si le salveaza
	public void readAndStoreTags() throws NotPlayableException {
		try {
			// Lese alle Tags aus der Datei in eine Map ein
			Map<String, Object> tagMap = TagReader.readTags(getPathname());

			// extragere titlu din taguri
			if (tagMap.containsKey("title")) {
				Object titleObj = tagMap.get("title");
				if (titleObj != null) {
					this.title = titleObj.toString().trim();
				}
			}

			// citire autor din taguri
			if (tagMap.containsKey("author")) {
				Object authorObj = tagMap.get("author");
				if (authorObj != null) {
					this.author = authorObj.toString().trim();
				}
			}

			// salvare album
			if (tagMap.containsKey("album")) {
				Object albumObj = tagMap.get("album");
				if (albumObj != null) {
					this.album = albumObj.toString().trim();
				}
			}

			// Duration extragere
			if (tagMap.containsKey("duration")) {
				Object durationObj = tagMap.get("duration");

				if (durationObj instanceof Long) {
					this.duration = (Long) durationObj;
				} else if (durationObj instanceof Number) {
					this.duration = ((Number) durationObj).longValue();
				} else {
					try {
						this.duration = Long.parseLong(durationObj.toString());
					} catch (NumberFormatException e) {
						this.duration = 0; // fallback
					}
				}
			}
		} catch (Exception e) {
			throw new NotPlayableException(getPathname(), "Fehler beim Lesen der Tags", e);
		}
	}

	// Getter pentru album
	public String getAlbum() {
		return album;
	}

	// Genereaza reprezentarea textuala completa
	@Override
	public String toString() {
		String base = super.toString(); // poate fi autor + titlu sau doar titlu
		String dur = formatDuration();

		if (album != null && !album.trim().isEmpty()) {
			return base + " - " + album.trim() + " - " + dur;
		} else {
			return base + " - " + dur;
		}
	}

	@Override
	public long getRawDuration() {
		return duration; 
	}
}
