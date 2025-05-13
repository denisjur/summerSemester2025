package studiplayer.audio;

import java.util.Comparator;

public class AlbumComparator implements Comparator<AudioFile> {

	@Override
	public int compare(AudioFile o1, AudioFile o2) {
	    if (o1 == null || o2 == null) {
	        throw new RuntimeException("Cannot compare null AudioFile objects");
	    }

	    boolean isTagged1 = o1 instanceof TaggedFile;
	    boolean isTagged2 = o2 instanceof TaggedFile;

	    if (!isTagged1 && !isTagged2) {
	        return 0; // niciunul nu are tag, deci egal
	    }
	    if (!isTagged1 && isTagged2) return -1;
	    if (isTagged1 && !isTagged2) return 1;

	    // beide sind TaggedFile -> deci continuam cu albumelee
	    String album1 = ((TaggedFile) o1).getAlbum();
	    String album2 = ((TaggedFile) o2).getAlbum();

	    if (album1 == null) album1 = "";
	    if (album2 == null) album2 = "";

	    boolean empty1 = album1.trim().isEmpty();
	    boolean empty2 = album2.trim().isEmpty();

	    if (empty1 && !empty2) return -1;
	    if (!empty1 && empty2) return 1;

	    int cmp = album1.compareToIgnoreCase(album2);
	    if (cmp != 0) return cmp;

	    // fallback: compare authors
	    String a1 = o1.getAuthor() != null ? o1.getAuthor() : "";
	    String a2 = o2.getAuthor() != null ? o2.getAuthor() : "";
	    cmp = a1.compareToIgnoreCase(a2);
	    if (cmp != 0) return cmp;

	    //vergleichen wir die Titel
	    String t1 = o1.getTitle() != null ? o1.getTitle() : "";
	    String t2 = o2.getTitle() != null ? o2.getTitle() : "";
	    cmp = t1.compareToIgnoreCase(t2);
	    if (cmp != 0) return cmp;

	    return t1.compareTo(t2); // final tie-break
	}

}
