package studiplayer.audio;

import java.util.Comparator;

public class TitleComparator implements Comparator<AudioFile> {

    @Override
    public int compare(AudioFile o1, AudioFile o2) {

        // check for null inputs, nu comparam nimic daca unul e null
        if (o1 == null || o2 == null)
            throw new RuntimeException("Cannot compare null AudioFile objects");

        // luam titlurile la comparat
        String title1 = o1.getTitle();
        String title2 = o2.getTitle();

        // ambele null → identice
        if (title1 == null && title2 == null) {
            return 0;
        }

        // daca primul e null → mai mic
        if (title1 == null) {
            return -1;
        }

        // daca al doilea e null → primul e mai mare
        if (title2 == null) {
            return 1;
        }

        // compare actual strings lexicographically
        return title1.compareTo(title2);
    }
}
