import static org.junit.Assert.*;
import org.junit.Test;

/** Tests for Worksheet 2 Exercise 5
 * 
 * Includes typical cases for several
 * completed boards, both valid and
 * invalid solutions.
 * Also tests the helper method that
 * checks whether an array has each
 * of the digits 1 to 9 exactly once.
 * 
 * @author Jirapat Treyanurak (jxt163 1214663 MSc Computer Science)
 * @version 2014-10-20
 */
public class Ex5Test {
	
	/**
	 * "Test helper" method to determine whether 
	 * 2 2-dimensional arrays of boolean
	 * values are piece-wise equal.
	 * 
	 * @param array1 A 2-dimensional boolean array to be compared with array2.
	 * @param array2 Another 2-dimensional boolean array, will be compared with array1.
	 * @return Boolean stating whether array1 and array2 are piece-wise equal.
	 */
	public static boolean boolean2dArraysEqual (boolean[][] array1, boolean[][] array2) {
		if (array1.length != array2.length) {
			return false;
		}
		for (int k = 0; k < array1.length; k++) {
			if (array1[k].length != array2[k].length) {
				return false;
			}
		}
		
		for (int i = 0; i < array1.length; i++) {
			for (int j = 0; j < array1[i].length; j++){
				if (array1[i][j] != array2[i][j]) {
					return false;
				}
			}
		}
		
		return true;
	}
	
	/**
	 * Tests for the "test helper" method that will be used for the actual tests
	 */
	@Test
	public void testHelperMethodPositive1 () {
		boolean[][] sample1 = {};
		boolean[][] sample2 = {};
		assertTrue(boolean2dArraysEqual(sample1, sample2));
	}
	@Test
	public void testHelperMethodPositive2 () {
		boolean[][] sample1 = {{},{},{}};
		boolean[][] sample2 = {{},{},{}};
		assertTrue(boolean2dArraysEqual(sample1, sample2));
	}
	@Test
	public void testHelperMethodPositive3 () {
		boolean[][] sample1 = {{true}};
		boolean[][] sample2 = {{true}};
		assertTrue(boolean2dArraysEqual(sample1, sample2));
	}
	@Test
	public void testHelperMethodPositive4 () {
		boolean[][] sample1 = {{true, false, false},
							   {false, false, true}};
		boolean[][] sample2 = {{true, false, false},
							   {false, false, true}};
		assertTrue(boolean2dArraysEqual(sample1, sample2));
	}
	@Test
	public void testHelperMethodNegative1 () {
		boolean[][] sample1 = {{true}};
		boolean[][] sample2 = {{}};
		assertFalse(boolean2dArraysEqual(sample1, sample2));
	}
	@Test
	public void testHelperMethodNegative2 () {
		boolean[][] sample1 = {{true},
							   {true},
							   {true},
							   {false}};
		boolean[][] sample2 = {{true, true, true, false}};
		assertFalse(boolean2dArraysEqual(sample1, sample2));
	}
	@Test
	public void testHelperMethodNegative3 () {
		boolean[][] sample1 = {{true, false, false},
							   {false, false, false}};
		boolean[][] sample2 = {{true, false, false},
							   {false, false, true}};
		assertFalse(boolean2dArraysEqual(sample1, sample2));
	}
	
	
	
	/**
	 * Tests for the helper method in the class Ex5 (has1to9exactlyOnce)
	 */
	@Test
	public void helperMethodPositiveTest1 () {
		int[] sample = {1,2,3,4,5,6,7,8,9};
		assertTrue(Ex5.has1to9exactlyOnce(sample));
	}
	@Test
	public void helperMethodPositiveTest2 () {
		int[] sample = {3,7,6,1,9,2,8,5,4};
		assertTrue(Ex5.has1to9exactlyOnce(sample));
	}
	@Test
	public void helperMethodNegativeTest1 () {
		int[] sample = {1,2};
		assertFalse(Ex5.has1to9exactlyOnce(sample));
	}
	@Test
	public void helperMethodNegativeTest2 () {
		int[] sample = {1,2,3,4,5,6,7,8,9,1};
		assertFalse(Ex5.has1to9exactlyOnce(sample));
	}
	@Test
	public void helperMethodNegativeTest3 () {
		int[] sample = {30,5,6,1,2,-7,8,9,0};
		assertFalse(Ex5.has1to9exactlyOnce(sample));
	}
	
	
	
	/**
	 * Now the actual tests for checkSudoku
	 */
	@Test
	public void positiveCase1 () {
		int[][] sample = {{1,2,3,4,5,6,7,8,9},
						  {4,5,6,7,8,9,1,2,3},
						  {7,8,9,1,2,3,4,5,6},
						  {2,3,4,5,6,7,8,9,1},
						  {5,6,7,8,9,1,2,3,4},
						  {8,9,1,2,3,4,5,6,7},
						  {3,4,5,6,7,8,9,1,2},
						  {6,7,8,9,1,2,3,4,5},
						  {9,1,2,3,4,5,6,7,8}};
		boolean[][] expected = {{true,true,true,true,true,true,true,true,true},
								{true,true,true,true,true,true,true,true,true},
								{true,true,true,true,true,true,true,true,true}};
		assertTrue(boolean2dArraysEqual(expected, Ex5.checkSudoku(sample)));
	}
	
	/**
	 * Negative cases:
	 */
	@Test
	public void negativeCase1 () {
		int[][] sample = {{1,2,3,4,5,6,7,8,9},
						  {4,5,6,7,8,9,1,2,3},
						  {7,8,9,1,2,3,4,5,6},
						  {2,3,4,5,6,7,8,9,1},
						  {5,6,7,8,9,1,2,3,4},
						  {8,9,1,2,3,4,5,6,7},
						  {3,4,5,6,7,8,9,1,2},
						  {6,7,9,9,1,2,3,4,5},
						  {9,1,2,3,4,5,6,7,8}};
		boolean[][] expected = {{true,true,true,true,true,true,true,false,true},
								{true,true,false,true,true,true,true,true,true},
								{true,true,true,true,true,true,false,true,true}};
		assertTrue(boolean2dArraysEqual(expected, Ex5.checkSudoku(sample)));
	}
	@Test
	public void negativeCase2 () {
		int[][] sample = {{1,2,3,4,5,6,7,8,9},
						  {4,5,6,7,8,9,1,2,3},
						  {7,8,9,1,2,4,4,4,6},
						  {2,3,4,5,6,7,8,9,1},
						  {5,6,7,8,9,1,2,3,4},
						  {8,9,1,2,3,4,5,6,7},
						  {3,4,5,6,7,8,9,1,2},
						  {6,7,9,9,1,2,3,4,5},
						  {9,1,2,3,4,5,6,7,8}};
		boolean[][] expected = {{true,true,false,true,true,true,true,false,true},
								{true,true,false,true,true,false,true,false,true},
								{true,false,false,true,true,true,false,true,true}};
		assertTrue(boolean2dArraysEqual(expected, Ex5.checkSudoku(sample)));
	}
	@Test public void negativeCase3 () {
		int[][] sample = {{1,1,1,1,1,1,1,1,1},
						  {1,1,1,1,1,1,1,1,1},
						  {1,1,1,1,1,1,1,1,1},
						  {1,1,1,1,1,1,1,1,1},
						  {1,1,1,1,1,1,1,1,1},
						  {1,1,1,1,1,1,1,1,1},
						  {1,1,1,1,1,1,1,1,1},
						  {1,1,1,1,1,1,1,1,1},
						  {1,1,1,1,1,1,1,1,1}};
		boolean[][] expected = {{false,false,false,false,false,false,false,false,false},
								{false,false,false,false,false,false,false,false,false},
								{false,false,false,false,false,false,false,false,false}};
		assertTrue(boolean2dArraysEqual(expected, Ex5.checkSudoku(sample)));
	}
	@Test public void negativeCase4 () {
		int[][] sample = {{1,777777777,1,1,1,1,1,1,1},
						  {1,1,1,1,1,1,1,1,1},
						  {1,1,1,1,1,1,1,1,1},
						  {1,1,1,1,-368783,1,1,1,1},
						  {1,1,1,1,1,1,1,1,1},
						  {1,1,1,0,0,0,0,1,1},
						  {1,1,1,1,1,1,3,1,1},
						  {1,1,1,1,1,1,1,1,1},
						  {1,1,1,1,1,1,1,1,1}};
		boolean[][] expected = {{false,false,false,false,false,false,false,false,false},
								{false,false,false,false,false,false,false,false,false},
								{false,false,false,false,false,false,false,false,false}};
		assertTrue(boolean2dArraysEqual(expected, Ex5.checkSudoku(sample)));
	}
	
}
