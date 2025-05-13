//package studiplayer.audio;
package studiplayer.audio;

import java.util.Comparator;

public class DurationComparator implements Comparator<AudioFile> {

	@Override
	public int compare(AudioFile o1, AudioFile o2) {

	    if(o1 == null || o2 == null) throw new RuntimeException("Cannot compare null AudioFile objects");

	    long duration1 = getDuration(o1);  // schimbat din String în long
	    long duration2 = getDuration(o2); 

	    if(duration1 == 0 && duration2 == 0) {
	        return 0;
	    }

	    if(duration1 == 0) return -1;

	    if(duration2 == 0) return 1;

	    return Long.compare(duration1, duration2);
	}

    private long getDuration(AudioFile file) {

          try {
            //obtine dura in milisecunde - - depinde de durata stocata in AudioFile
            return file.getTimeInMillis();

          }catch(Exception e) {
            return 0;//daca durata nu poate fi determinata
          }
    }
}
