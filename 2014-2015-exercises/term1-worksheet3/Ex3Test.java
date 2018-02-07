import static org.junit.Assert.*;
import org.junit.Test;

/** Tests for Worksheet 3 Exercise 3
 * 
 * @author Jirapat Treyanurak (jxt163 1214663 MSc Computer Science)
 * @version 2014-11-10
 */
public class Ex3Test {
	
	/**
	 * 0 case
	 */
	@Test
	public void iterTest1 () {
		assertEquals(0, Ex3.digitTotalIter(0));
	}
	@Test
	public void recTest1 () {
		assertEquals(0, Ex3.digitTotalRec(0));
	}
	
	/**
	 * repeated digits
	 */
	@Test
	public void iterTest2 () {
		assertEquals(9, Ex3.digitTotalIter(333));
	}
	@Test
	public void recTest2 () {
		assertEquals(9, Ex3.digitTotalRec(333));
	}

	/**
	 * typical case
	 */
	@Test
	public void iterTest3 () {
		assertEquals(25, Ex3.digitTotalIter(2362354));
	}
	@Test
	public void recTest3 () {
		assertEquals(25, Ex3.digitTotalRec(2362354));
	}

	/**
	 * typical case with 0
	 */
	@Test
	public void iterTest4 () {
		assertEquals(32, Ex3.digitTotalIter(230635049));
	}
	@Test
	public void recTest4 () {
		assertEquals(32, Ex3.digitTotalRec(230635049));
	}
	
}