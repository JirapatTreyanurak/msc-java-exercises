import static org.junit.Assert.*;
import org.junit.Test;

/** Tests for Worksheet 3 Exercise 2
 * 
 * @author Jirapat Treyanurak (jxt163 1214663 MSc Computer Science)
 * @version 2014-11-10
 */
public class Ex2Test {
	
	/* *************** *
	 * Power functions *
	 * *************** */
	/**
	 * Let us go with 0^0 = 1
	 */
	@Test
	public void powerIterTest1 () {
		assertEquals(1, Ex2.powerIter(0, 0), 0);
	}
	@Test
	public void powerRecTest1 () {
		assertEquals(1, Ex2.powerRec(0, 0), 0);
	}
	
	/**
	 * 1^n = 1
	 */
	@Test
	public void powerIterTest2 () {
		assertEquals(1, Ex2.powerIter(1, 777), 0);
	}
	@Test
	public void powerRecTest2 () {
		assertEquals(1, Ex2.powerRec(1, 777), 0);
	}
	
	/**
	 * typical case
	 */
	@Test
	public void powerIterTest3 () {
		assertEquals(64, Ex2.powerIter(4, 3), 0);
	}
	@Test
	public void powerRecTest3 () {
		assertEquals(64, Ex2.powerRec(4, 3), 0);
	}
	
	/* ******************* *
	 * Factorial functions *
	 * ******************* */
	/**
	 * base case
	 */
	@Test
	public void factorialIterTest1 () {
		assertEquals(1, Ex2.factorialIter(0));
	}
	@Test
	public void factorialRecTest1 () {
		assertEquals(1, Ex2.factorialRec(0));
	}

	/**
	 * typical case
	 */
	@Test
	public void factorialIterTest2 () {
		assertEquals(720, Ex2.factorialIter(6));
	}
	@Test
	public void factorialRecTest2 () {
		assertEquals(720, Ex2.factorialRec(6));
	}
	
	/* *** *
	 * e^x *
	 * *** */
	/**
	 * e^0 and e^1
	 */
	@Test
	public void expIterTest1 () {
		assertEquals(1, Ex2.expIter(0, 0.00000001), 0);
	}
	@Test
	public void expRecTest1 () {
		assertEquals(1, Ex2.expRec(0, 0.00000001), 0);
	}
	@Test
	public void expIterTest2 () {
		assertEquals(2.718281828459045, Ex2.expIter(1, 0.00000001), 0.00000001);
	}
	@Test
	public void expRecTest2 () {
		assertEquals(2.718281828459045, Ex2.expRec(1, 0.00000001), 0.00000001);
	}
	
	/**
	 * typical case
	 */
	@Test
	public void expIterTest3 () {
		assertEquals(7.3890, Ex2.expIter(2, 0.0001), 0.0001);
	}
	@Test
	public void expRecTest3 () {
		assertEquals(7.3890, Ex2.expRec(2, 0.0001), 0.0001);
	}
	
}