package ex4;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.After;

/** Worksheet 5 Exercise 4 Test
 * 
 * This class tests the equals and decode, encode method
 * inside the Tree class (encode, decode called via the Ex4 class).
 * 
 * @author Jirapat Treyanurak (jxt163 1214663 MSc Computer Science)
 * @version 2014-12-10
 */
public class Ex4Test {
	
	private Tree t1;
	private Tree t2;
	
	@Before
	public void setUp () {
		long[] freq = {148970,25519,41224,81586,219488,41740,34245,125330,121889,1654,12516,66773,45899,124802,146903,26297,4213,100115,114741,169435,50147,18704,40609,4562,33237,1106,395475,68099,40006};
		this.t1 = Ex4.generateTree(freq);
		this.t2 = Ex4.generateTree(freq);
	}
	
	@Test
	public void equalsTest () {
		assertTrue(this.t1.equals(this.t2));
	}
	
	@Test
	public void encodeDecodeTest1 () {
		String message = "message";
		String expected = "message";
		assertEquals(expected, Ex4.decode(Ex4.encode(message, this.t1), this.t1));
	}
	@Test
	public void encodeDecodeTest2 () {
		String message = "CAPITAL leTtErS";
		String expected = "capital letters";
		assertEquals(expected, Ex4.decode(Ex4.encode(message, this.t1), this.t1));
	}
	@Test
	public void encodeDecodeTest3 () {
		String message = "special $symbols ^! !1 1 will be IgNored()*!";
		String expected = "special symbols    will be ignored";
		assertEquals(expected, Ex4.decode(Ex4.encode(message, this.t1), this.t1));
	}
	@Test
	public void encodeDecodeTest4 () {
		String message = "";
		String expected = "";
		assertEquals(expected, Ex4.decode(Ex4.encode(message, this.t1), this.t1));
	}
	
	@After
	public void cleanUp () {
		this.t1 = null;
		this.t2 = null;
	}
	
}