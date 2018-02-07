import static org.junit.Assert.*;
import org.junit.Test;

/** Tests for Worksheet 3 Exercise 4
 * 
 * @author Jirapat Treyanurak (jxt163 1214663 MSc Computer Science)
 * @version 2014-11-10
 */
public class Ex4Test {
	
	/*
	 * Helper method and their tests
	 */
	
	/**
	 * Helper method for the tests
	 * 
	 * @param array of strings to check
	 * @return boolean stating whether the input array is sorted in increasing order by length
	 */
	public static boolean sorted (String[] array) {
		for (int i = 0; i < array.length - 1; i++ ) {
			if (array[i].length() > array[i+1].length()) {
				return false;
			}
		}
		return true;
	}
	/**
	 * edge cases
	 */
	@Test
	public void sortedTest1 () {
		String[] sample = {};
		assertTrue(sorted(sample));
	}
	@Test
	public void sortedTest2 () {
		String[] foreverAlone = {":foreveralone:"};
		assertTrue(sorted(foreverAlone));
	}
	
	/**
	 * Where strings of same size go doesn't matter
	 */
	@Test
	public void sortedTest3 () {
		String[] sample = {"a", "b", "c", "d", "e"};
		assertTrue(sorted(sample));
	}
	@Test
	public void sortedTest4 () {
		String[] sample = {"d", "c", "e", "a", "b"};
		assertTrue(sorted(sample));
	}
	
	/**
	 * typical case
	 */
	@Test
	public void sortedTest5 () {
		String[] sample = {"I", "ate", "the", "pizza >:D"};
		assertTrue(sorted(sample));
	}
	
	/**
	 * negative cases
	 */
	@Test
	public void sortedTest6 () {
		String[] sample = {"tooooo", "long"};
		assertFalse(sorted(sample));
	}
	@Test
	public void sortedTest7 () {
		String[] sample = {"Who", "ate", "the", "pizza", "on", "the", "table???"};
		assertFalse(sorted(sample));
	}
	
	
	/*
	 * Now we move to the test of the actual quickSort method
	 */
	/**
	 * edge cases
	 */
	@Test
	public void qsTest1 () {
		String[] sample = {};
		assertTrue(sorted(Ex4.quickSort(sample)));
	}
	@Test
	public void qsTest2 () {
		String[] sample = {"The boy who lived"};
		assertTrue(sorted(Ex4.quickSort(sample)));
	}
	/**
	 * typical cases
	 */
	@Test
	public void qsTest3 () {
		String[] sample = {"I", "am", "the", "one", "who", "ate", "the", "pizza!"};
		assertTrue(sorted(Ex4.quickSort(sample)));
	}
	@Test
	public void qsTest4 () {
		String[] sample = {"Santa", "Claus", "is", "coming", "to", "town"};
		assertTrue(sorted(Ex4.quickSort(sample)));
	}
	
}