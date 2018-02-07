import static org.junit.Assert.*;
import org.junit.Test;

/** Tests for Worksheet 2 Exercise 3
 * 
 * Includes typical cases for several values
 * of n and tests for both positive and 
 * negative results.
 * 
 * @author Jirapat Treyanurak (jxt163 1214663 MSc Computer Science)
 * @version 2014-10-20
 */
public class Ex3Test {
	
	/**
	 * "Test helper" method to determines whether 
	 * 2 boolean arrays are piece-wise equal.
	 * 
	 * @param array1 A boolean array to be compared with array2
	 * @param array2 Another boolean array, will be compared with array1.
	 * @return Boolean stating whether array1 and array2 are piece-wise equal.
	 */
	public static boolean booleanArraysEqual (boolean[] array1, boolean[] array2) {
		if (array1.length != array2.length) {
			return false;
		}
		
		for (int i = 0; i < array1.length; i++) {
			if (array1[i] != array2[i]) {
				return false;
			}
		}
		
		return true;
	}
	
	/**
	 * Tests for the "test helper" method that will be used for the actual tests
	 */
	@Test
	public void testHelperMethodPositive1 () {
		boolean[] sample1 = {true};
		boolean[] sample2 = {true};
		assertTrue(booleanArraysEqual(sample1, sample2));
	}
	@Test
	public void testHelperMethodPositive2 () {
		boolean[] sample1 = {true, true, false, true, false, false};
		boolean[] sample2 = {true, true, false, true, false, false};
		assertTrue(booleanArraysEqual(sample1, sample2));
	}
	@Test
	public void testHelperMethodPositive3 () {
		boolean[] sample1 = {};
		boolean[] sample2 = {};
		assertTrue(booleanArraysEqual(sample1, sample2));
	}
	@Test
	public void testHelperMethodNegative1 () {
		boolean[] sample1 = {true};
		boolean[] sample2 = {true, false};
		assertFalse(booleanArraysEqual(sample1, sample2));
	}
	@Test
	public void testHelperMethodNegative2 () {
		boolean[] sample1 = {false, false, true};
		boolean[] sample2 = {false, false, false};
		assertFalse(booleanArraysEqual(sample1, sample2));
	}
	@Test
	public void testHelperMethodNegative3 () {
		boolean[] sample1 = {};
		boolean[] sample2 = {true};
		assertFalse(booleanArraysEqual(sample1, sample2));
	}
	
	
	
	/**
	 * Now the actual tests for sieve method.
	 */
	@Test
	public void typicalPositiveCase1 () {
		boolean[] expected = {false, false};
		assertTrue(booleanArraysEqual(expected, Ex3.sieve(2)));
	}
	
	/**
	 * Check for first n
	 */
	@Test
	public void typicalPositiveCase2 () {
		boolean[] expected = {false, false, true, true, false, true, false, true, false, false, false, true, false, true};
		assertTrue(booleanArraysEqual(expected, Ex3.sieve(14)));
	}
	@Test
	public void typicalPositiveCase3 () {
		boolean[] expected = {false, false, true, true, false, true, false, true, false, false, false, true, false, true, false, false, false, true, false, true, false, false, false, true, false};
		assertTrue(booleanArraysEqual(expected, Ex3.sieve(25)));
	}
	
	/**
	 * Negative cases
	 */
	@Test
	public void typicalNegativeCase1 () {
		boolean[] expected = {false, true};
		assertFalse(booleanArraysEqual(expected, Ex3.sieve(2)));
	}
	@Test
	public void typicalNegativeCase2 () {
		boolean[] expected = {false, false, true, true, false, true, false, true, false, false, false, false, false, true};
		assertFalse(booleanArraysEqual(expected, Ex3.sieve(14)));
	}
	@Test
	public void typicalNegativeCase3 () {
		boolean[] expected = {false, false, true, true, false, true, false, true, false, false, false, true, false, true, true, false, false, true, false, true, false, true, false, true, false};
		assertFalse(booleanArraysEqual(expected, Ex3.sieve(25)));
	}
	
}
