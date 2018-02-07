import static org.junit.Assert.*;
import org.junit.Test;

/** Tests for Worksheet 2 Exercise 1
 * 
 * Include cases for passing/failing MSc
 * and ICY students, and a case for invalid
 * inputs where false is expected.
 * 
 * @author Jirapat Treyanurak (jxt163 1214663 MSc Computer Science)
 * @version 2014-10-20
 */
public class Ex1Test {
	
	/**
	 * Clear pass
	 */
	@Test
	public void passingMScStudent () {
		assertTrue(Ex1.hasPassed(100, 95, 88, 91, "MSc"));
	}
	@Test
	public void passingICYStudent () {
		assertTrue(Ex1.hasPassed(95, 95, 85, 91, "ICY"));
	}
	
	/**
	 * Border case pass
	 */
	@Test
	public void borderPassMScStudent () {
		assertTrue(Ex1.hasPassed(50, 50, 50, 50, "MSc"));
	}
	@Test
	public void borderPassICYStudent () {
		assertTrue(Ex1.hasPassed(40, 40, 40, 40, "ICY"));
	}
	
	/**
	 * Border case fail
	 */
	@Test
	public void borderFailMScStudent () {
		assertFalse(Ex1.hasPassed(50, 50, 50, 49, "MSc"));
	}
	@Test
	public void borderFailICYStudent () {
		assertFalse(Ex1.hasPassed(39, 40, 40, 40, "ICY"));
	}
	
	/**
	 * Clear fail
	 */
	@Test
	public void failingMScStudent () {
		assertFalse(Ex1.hasPassed(0, 1, 2, 3, "MSc"));
	}
	@Test
	public void failingICYStudent () {
		assertFalse(Ex1.hasPassed(10, 5, 25, 3, "ICY"));
	}
	
	/**
	 * Invalid input
	 */
	@Test
	public void invalidInput1 () {
		assertFalse(Ex1.hasPassed(7200, 0, -3, 45, "Best. Student. Ever."));
	}
	@Test
	public void invalidInput2 () {
		assertFalse(Ex1.hasPassed(101, 100, 100, 100, "MSc"));
	}
	
}
