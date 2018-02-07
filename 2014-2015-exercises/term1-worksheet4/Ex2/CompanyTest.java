package Ex2;

import java.util.ArrayList;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.After;

/** Worksheet 4 Exercise 2 Test
 * 
 * Test of the Company class.
 * We mainly test for the equals method (companies
 * with same employees but listed in different order 
 * should still be equal), and the increaseSalaries
 * method.
 * 
 * @author Jirapat Treyanurak (jxt163 1214663 MSc Computer Science)
 * @version 2014-11-29
 */
public class CompanyTest {
	
	private ArrayList<Employee> l1;
	private ArrayList<Employee> l2;
	private ArrayList<Employee> l3;
	private Company c1;
	private Company c2;
	private Company c3;
	private Employee e1;
	private Employee e2;
	private Employee e3;
	
	@Before
	public void setUp () {
		this.e1 = new HourlyEmployee("Alice", "Wonders", "54512", 28, 10, 200);
		this.e2 = new SalariedEmployee("James", "Bond", "007", 28, 2000, 15);
		this.e3 = new SalariedEmployee("Yanara", "Jindou", "348484", 28, 4000, 15);
		
		this.l1 = new ArrayList<Employee>();
		this.l2 = new ArrayList<Employee>();
		this.l3 = new ArrayList<Employee>();
		
		this.l1.add(e1);
		this.l1.add(e2);
		
		this.l2.add(e1);
		this.l2.add(e2);
		this.l2.add(e3);
		
		//l3 has the same employees as l1 (just in different order)
		//so they should be equal.
		this.l3.add(e2);
		this.l3.add(e1);
		
		this.c1 = new Company("Itty Bitty", "www.aLittleIcky.com", 0, this.l1);
		this.c2 = new Company("Macrohard", "www.macrohard.com", 0, this.l2);
		this.c3 = new Company("Itty Bitty", "www.aLittleIcky.com", 0, this.l3);
		
		this.c1.increaseSalaries(1);
	}
	
	@Test
	public void equalsPositiveTest1 () {
		assertTrue(this.c1.equals(this.c1));
	}
	@Test
	public void equalsPositiveTest2 () {
		assertTrue(this.c1.equals(this.c3));
	}
	@Test
	public void equalsNegativeTest1 () {
		assertFalse(this.c1.equals(this.c2));
	}
	
	@Test
	public void increaseSalariesTestc11 () {
		double expected = 20;
		HourlyEmployee tmp = (HourlyEmployee) e1;
		assertEquals(expected, tmp.getHourlySalary(), 0.00001);
	}
	@Test
	public void increaseSalariesTestc12 () {
		double expected = 4000;
		SalariedEmployee tmp = (SalariedEmployee) e2;
		assertEquals(expected, tmp.getSalary(), 0.00001);
	}
	
	@After
	public void cleanUp () {
		this.c1 = null;
		this.c2 = null;
		this.c3 = null;
		
		this.l1 = null;
		this.l2 = null;
		this.l3 = null;
		
		this.e1 = null;
		this.e2 = null;
		this.e3 = null;
	}
	
}