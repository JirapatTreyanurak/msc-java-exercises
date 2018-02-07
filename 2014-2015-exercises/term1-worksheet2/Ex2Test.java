import static org.junit.Assert.*;
import org.junit.Test;

/** Tests for Worksheet 2 Exercise 2
 * 
 * Includes several typical cases, and
 * also a case where the sample array
 * is empty (0 occurence expected).
 * 
 * @author Jirapat Treyanurak (jxt163 1214663 MSc Computer Science)
 * @version 2014-10-20
 */
public class Ex2Test {
	public static String[] sample = {"the", "pizza", "was", "on", "the", "table", "!"};
	public static String[] emptySample = {};
	public static String[] caseSample = {"the", "The", "tHE"};
	
	/**
	 * n occurences for n = 0, 1, 2
	 */
	@Test
	public void typicalCase1 () {
		assertEquals(0, Ex2.countOccurences("dog", sample));
	}
	@Test
	public void typicalCase2 () {
		assertEquals(1, Ex2.countOccurences("pizza", sample));
	}
	@Test
	public void typicalCase3 () {
		assertEquals(2, Ex2.countOccurences("the", sample));
	}
	
	/**
	 * list is empty, 0 count expected
	 */
	@Test
	public void emptySample () {
		assertEquals(0, Ex2.countOccurences("foo", emptySample));
	}
	
	/**
	 * case-sensitivity
	 */
	@Test
	public void caseSensitive1 () {
		assertEquals(1, Ex2.countOccurences("the", caseSample));
	}
	@Test
	public void caseSensitive2 () {
		assertEquals(0, Ex2.countOccurences("thE", caseSample));
	}
	
}
