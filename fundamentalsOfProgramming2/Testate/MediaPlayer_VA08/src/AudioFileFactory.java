public class AudioFileFactory {

    /**

          creeaza o instanta AudioFile corespunzatoare in functie de extensia fisierului
          @param path Calea catre fisierul audio
          @return o instanta AudioFile corespunzatoare
          @throws RuntimeException daca extensia fisierului nu este suportata                
    */

    public static AudioFile createAudioFile(String path) {

           if(path == null || path.isEmpty()) {
              throw new RuntimeException("Path cannot be null or empty");
           }

           String lowercasePath = path.toLowerCase();

           if(lowercasePath.endsWith(".wav")) {

                return new WavFile( path );
                
           } else if(lowercasePath.endsWith(".mp3") || lowercasePath.endsWith(".ogg")) {

                return new TaggedFile( path );
                
           } else {

        	   throw new RuntimeException("Unknown suffix for AudioFile \"" + path + "\"");



           }                 
    }
  
}