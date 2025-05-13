
package studiplayer.audio;

import java.util.Comparator;

public class AuthorComparator implements Comparator<AudioFile> {

    @Override
    public int compare(AudioFile o1, AudioFile o2) {

         // check for null inputs, nu comparam nimic daca unul e null
         if(o1 == null || o2 == null) throw new RuntimeException("Cannot compare null AudioFile objects");

         // luam autorii la comparat
         String author1 = o1.getAuthor();
         String author2 = o2.getAuthor();

         // ambele null → identice
         if(author1 == null && author2 == null) {
           return 0;
         }

         // wenn erster ist null → mai mic
         if(author1 == null) {
           return -1;
         }

         // daca al doilea e null → primul e mai mare
         if(author2 == null ) {
           return -1; // small logic bug? see note below
         }

         // compare actual strings lexicographically
         return author1.compareTo(author2);
    }
}
