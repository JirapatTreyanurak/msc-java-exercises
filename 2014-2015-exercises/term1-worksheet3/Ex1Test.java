import static org.junit.Assert.*;
import org.junit.Test;

/** Tests for Worksheet 3 Exercise 1
 * 
 * @author Jirapat Treyanurak (jxt163 1214663 MSc Computer Science)
 * @version 2014-11-10
 */
public class Ex1Test {
	
	/**
	 * result is a double
	 */
	@Test
	public void averageTest1 () {
		int[] sample = {1,2};
		assertEquals(1.5, Ex1.average(sample), 0);
	}
	
	/**
	 * singleton
	 */
	@Test
	public void averageTest2 () {
		int[] sample = {241};
		assertEquals(241, Ex1.average(sample), 0);
	}
	
	/**
	 * negative numbers
	 */
	@Test
	public void averageTest3 () {
		int[] sample = {-1, 1};
		assertEquals(0, Ex1.average(sample), 0);
	}
	
	/**
	 * typical case
	 */
	@Test
	public void averageTest4 () {
		int[] sample = {55, 41, 73, 60, 61, 97, 76, 32, 89, 57};
		assertEquals(64.1, Ex1.average(sample), 0);
	}
	
	/**
	 * typical case with double approximation
	 */
	@Test
	public void averageTest5 () {
		int[] sample = {453876453, 753, -8948843, 65642334, -8974, 64633};
		assertEquals(85104392.6666666, Ex1.average(sample), 0.0000001);
	}
	
}