import static org.junit.Assert.*;
import org.junit.Test;

/** Tests for Worksheet 3 Exercise 5
 * 
 * @author Jirapat Treyanurak (jxt163 1214663 MSc Computer Science)
 * @version 2014-11-10
 */
public class Ex5Test {
	
	/** Helper method and tests for it
	 * 
	 * @param array integer array
	 * @return boolean stating whether the array has 1 in every entry
	 */
	public static boolean allOnes (int[] array) {
		for (int i = 0; i < array.length; i++) {
			if (array[i] != 1) {
				return false;
			}
		}
		return true;
	}
	@Test
	public void allOnesTest1 () {
		int[] sample = {1, 1, 1};
		assertTrue(allOnes(sample));
	}
	@Test
	public void allOnesTest2 () {
		int[] sample = {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1};
		assertTrue(allOnes(sample));
	}
	@Test
	public void allOnesTest3 () {
		int[] sample = {};
		assertTrue(allOnes(sample));
	}
	@Test
	public void allOnesTest4 () {
		int[] sample = {2};
		assertFalse(allOnes(sample));
	}
	@Test
	public void allOnesTest5 () {
		int[] sample = {1,1,1,2,1,1,1};
		assertFalse(allOnes(sample));
	}
	
	
	/*
	 * Now the tests for the actual methods
	 */
	
	/**
	 * Tests for init (int n)
	 */
	@Test
	public void initTest1 () {
		assertTrue(allOnes(Ex5.init(3)));
	}
	@Test
	public void initTest2 () {
		assertTrue(allOnes(Ex5.init(777)));
	}
	@Test
	public void initTest3 () {
		assertTrue(allOnes(Ex5.init(0)));
	}
	
	/**
	 * Tests for topDiskAtPosition (int n)
	 */
	@Test
	public void topDiskTest1 () {
		int[] sample = {1,1,1};
		assertEquals(0, Ex5.topDiskAtPosition(sample, 1));
	}
	@Test
	public void topDiskTest2 () {
		int[] sample = {3,1,1};
		assertEquals(1, Ex5.topDiskAtPosition(sample, 1));
	}
	@Test
	public void topDiskTest3 () {
		int[] sample = {3,1,1};
		assertEquals(0, Ex5.topDiskAtPosition(sample, 3));
	}
	@Test
	public void topDiskTest4 () {
		int[] sample = {3,1,1};
		assertEquals(-1, Ex5.topDiskAtPosition(sample, 2));
	}
	
	/**
	 * Tests for hanoiToString (int[] game)
	 * The positions for each of the disks are delimited by a space
	 * The game state describing the positions of all the disks ends with a "\n"
	 */
	@Test
	public void hanoiToStringTest1 () {
		int[] sample = {1,1,1};
		String expected = "1 1 1\n";
		assertEquals(expected, Ex5.hanoiToString(sample));
	}
	@Test
	public void hanoiToStringTest2 () {
		int[] sample = {3,3,3,3,3,1,1};
		String expected = "3 3 3 3 3 1 1\n";
		assertEquals(expected, Ex5.hanoiToString(sample));
	}
	
	/**
	 * Tests for trace (int n)
	 * where n is the number of disks,
	 * starting from position 1,
	 * and we move to position 3
	 * The method returns the concatenation of the hanoiToString of each steps
	 * (each move gets its own line, a move delimited by \n, a disk delimited by a space)
	 * Note the last move also have a \n at the end.
	 */
	@Test
	public void traceTest1 () {
		String expected = "1\n3\n";
		assertEquals(expected, Ex5.trace(1));
	}
	@Test
	public void traceTest2 () {
		String expected = "1 1\n2 1\n2 3\n3 3\n";
		assertEquals(expected, Ex5.trace(2));
	}
	@Test
	public void traceTest3 () {
		String expected = "1 1 1\n3 1 1\n3 2 1\n2 2 1\n2 2 3\n1 2 3\n1 3 3\n3 3 3\n";
		assertEquals(expected, Ex5.trace(3));
	}
	@Test
	public void traceTest4 () {
		String expected  = "1 1 1 1\n2 1 1 1\n2 3 1 1\n3 3 1 1\n3 3 2 1\n1 3 2 1\n1 2 2 1\n2 2 2 1\n";
			   expected += "2 2 2 3\n3 2 2 3\n3 1 2 3\n1 1 2 3\n1 1 3 3\n2 1 3 3\n2 3 3 3\n3 3 3 3\n";
		assertEquals(expected, Ex5.trace(4));
	}

}