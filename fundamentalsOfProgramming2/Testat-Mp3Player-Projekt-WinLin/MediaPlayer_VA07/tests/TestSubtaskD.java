import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestSubtaskD {
	@Test
	public void test_timeFormatter1() {
		assertEquals("Time value not formatted correctly!", "02:21", TaggedFile.timeFormatter(141400816L));
		assertEquals("Time value not formatted correctly!", "02:21", WavFile.timeFormatter(141400816L));
		assertEquals("Time value not formatted correctly!", "02:21", SampledFile.timeFormatter(141400816L));
	}

	public void test_timeFormatter2() {
		try {
			String s = TaggedFile.timeFormatter(-1L);
		} catch (Exception e) {
			// expected since parameter is invalid
		}
	}

	public void test_timeFormatter3() {
		try {
			String s = TaggedFile.timeFormatter((60 * 60 + 60) * 1000000L);
		} catch (Exception e) {
			// expected since parameter is invalid
		}
	}
}
