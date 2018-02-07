import static org.junit.Assert.*;
import org.junit.Test;

/** Tests for Worksheet 2 Exercise 4
 * 
 * Includes several typical cases.
 * 
 * @author Jirapat Treyanurak (jxt163 1214663 MSc Computer Science)
 * @version 2014-10-20
 */
public class Ex4Test {
	
	/**
	 * Elements of same length remain in the same relative order
	 */
	@Test
	public void typicalCase1 () {
		String[] sample = {"Sort", "me", "if", "you", "can"};
		String[] expected = {"me", "if", "you", "can", "Sort"};
		assertArrayEquals(expected, Ex4.bubbleSort(sample));
	}
	
	/**
	 * Longer lists
	 */
	@Test
	public void typicalCase2 () {
		String[] sample = {"Who", "ate", "the", "pizza", "on", "the", "table", "?"};
		String[] expected = {"?", "on", "Who", "ate", "the", "the", "pizza", "table"};
		assertArrayEquals(expected, Ex4.bubbleSort(sample));
	}
	@Test
	public void typicalCase3 () {
		String[] sample = {"Scary", "fishes", "do", "not", "live", "in", "cold", "places", "but", "penguins", "do", "!"};
		String[] expected = {"!", "do", "in", "do", "not", "but", "live", "cold", "Scary", "fishes", "places", "penguins"};
		assertArrayEquals(expected, Ex4.bubbleSort(sample));
	}
	
	/**
	 * Border cases
	 */
	@Test
	public void emptyCase () {
		String[] sample = {};
		String[] expected = {};
		assertArrayEquals(expected, Ex4.bubbleSort(sample));
	}
	@Test
	public void nothingToSortCase () {
		String[] sample = {"ho ho ho"};
		String[] expected = {"ho ho ho"};
		assertArrayEquals(expected, Ex4.bubbleSort(sample));
	}
	
}
