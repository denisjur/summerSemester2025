package studiplayer.audio;

import java.util.Comparator;

public class AuthorComparator implements Comparator<AudioFile> {

    @Override
    public int compare(AudioFile o1, AudioFile o2) {

        // check for null inputs, nu comparam nimic daca unul e null
        if (o1 == null || o2 == null) {
            throw new RuntimeException("Cannot compare null AudioFile objects");
        }

        // luam autorii la comparat
        String author1 = o1.getAuthor();
        String author2 = o2.getAuthor();

        if (author1 == null && author2 == null) return 0;
        if (author1 == null) return -1;
        if (author2 == null) return 1;

        int result = author1.compareToIgnoreCase(author2);
        if (result != 0) {
            return result; // daca autorii sunt diferiti, returnam rezultatul
        }

        // daca autorii sunt egali, comparam titlurile
        String title1 = o1.getTitle();
        String title2 = o2.getTitle();

        if (title1 == null && title2 == null) return 0;
        if (title1 == null) return -1;
        if (title2 == null) return 1;

        return title1.compareToIgnoreCase(title2);
    }
}
