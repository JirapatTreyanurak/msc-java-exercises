package Ex2;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.After;

/** Worksheet 4 Exercise 2 Test
 * 
 * This class tests the SalariedEmployee class.
 * We test for the increaseSalary and paymentAmount methods.
 * 
 * @author Jirapat Treyanurak (jxt163 1214663 MSc Computer Science)
 * @version 2014-11-29
 */
public class SalariedEmployeeTest {
	
	private SalariedEmployee e1;
	
	@Before
	public void setUp () {
		this.e1 = new SalariedEmployee("I.amStupid()", "returns true", "ni", 28, 1000, 3);
	}
	
	@Test
	public void increaseSalaryTest1 () {
		double expected = 1000;
		this.e1.increaseSalary(0);
		assertEquals(expected, this.e1.getSalary(), 0.00001);
	}
	@Test
	public void increaseSalaryTest2 () {
		double expected = 1250;
		this.e1.increaseSalary(0.25);
		assertEquals(expected, this.e1.getSalary(), 0.00001);
	}
	
	@Test
	public void paymentAmountTest () {
		double expected = 1000;
		assertEquals(expected, this.e1.paymentAmount(), 0.00001);
	}
	
	@After
	public void cleanUp () {
		this.e1 = null;
	}
	
}