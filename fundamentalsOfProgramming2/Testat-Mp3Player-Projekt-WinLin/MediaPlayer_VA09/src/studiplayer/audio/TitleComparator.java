//package studiplayer.audio;
package studiplayer.audio;

import java.util.Comparator;

public class TitleComparator implements Comparator<AudioFile> {

	@Override
	public int compare(AudioFile o1, AudioFile o2) {

		if (o1 == null || o2 == null)
			throw new RuntimeException("Cannot compare null AudioFile objects");

		String title1 = o1.getTitle();
		String title2 = o2.getTitle();

		if (title1 == null && title2 == null) {
			return 0;
		}

		if (title1 == null) {
			return 0;
		}

		if (title2 == null) {
			return 0;
		}

		return title1.compareTo(title2);
	}
}
