import java.util.Map;

import studiplayer.basic.TagReader;

public class TaggedFile extends SampledFile {

    // atribut suplimentar pentru album
	private String album;

    // Metoda care citeste tagurile din fisier si le salveaza
	public void readAndStoreTags() {

        // Lese alle Tags aus der Datei in eine Map ein
		Map<String, Object> tagMap = TagReader.readTags(getPathname());

        // Debug-Ausgabe der gelesenen Tags
		System.out.println("----- TAGS AUS DER DATEI -----");
		for (String key : tagMap.keySet()) {
		    System.out.println("Tag [" + key + "] = " + tagMap.get(key));
		}
		System.out.println("------------------------------");

		
		// extragere titlu din taguri
		if (tagMap.containsKey("title")) {
			Object titleObj = tagMap.get("title");
			if (titleObj != null)
				this.title = titleObj.toString().trim();
		}

		// citire autor din taguri
		if (tagMap.containsKey("author")) {
			Object authorObj = tagMap.get("author");
			if (authorObj != null)
				this.author = authorObj.toString().trim();
		}

		// Album wird gespeichert, falls vorhanden
		if (tagMap.containsKey("album")) {
		    Object albumObj = tagMap.get("album");
		    if (albumObj != null)
		    	this.album = albumObj.toString().trim();
		}

		// Duration wird verarbeitet, evtl. Konvertierung nötig
		if (tagMap.containsKey("duration")) {
			Object durationObj = tagMap.get("duration");

			if (durationObj != null) {
				if (durationObj instanceof Long) {
					this.duration = (Long) durationObj;
				} else if (durationObj instanceof Number) {
					this.duration = ((Number) durationObj).longValue();
				} else {
					try {
						this.duration = Long.parseLong(durationObj.toString());
					} catch (NumberFormatException e) {
						// ignoram daca parsarea esueaza
					}
				}
			}
		}
	}
	
    // Constructor care incarca automat tagurile la creare
	public TaggedFile(String path) {
	    super(path);           // ruft den Konstruktor von SampledFile
	    readAndStoreTags();    // Laden der Tags direkt beim Erzeugen
	}

    // Getter pentru album
	public String getAlbum() {
		return album;
	}

    // Genereaza reprezentarea textuala completa
	@Override
	public String toString() {
	    String base = super.toString();  // poate fi autor + titlu, oder doar numele fisierului
	    String dur = formatDuration();

	    // Falls Album vorhanden, dann fuge es zur Darstellung hinzu
	    if (album != null && !album.trim().isEmpty()) {
	        return base + " - " + album.trim() + " - " + dur;
	    } else {
	        return base + " - " + dur;
	    }
	}

}
