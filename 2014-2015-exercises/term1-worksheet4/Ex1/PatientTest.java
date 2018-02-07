package Ex1;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import java.util.Calendar;

/** Worksheet 4 Exercise 1 (a) Tests
 * 
 * Tests for the constructor and setters
 * for the input validation, and also for
 * the equals method.
 * 
 * @author Jirapat Treyanurak (jxt163 1214663 MSc Computer Science)
 * @version 2014-11-27
 */
public class PatientTest {
	
	private Patient p1;
	private Patient p2;
	
	@Test
	public void ConstructorPositiveTestM () {
		Patient p = new Patient("", Calendar.getInstance(), "M");
	}
	@Test
	public void ConstructorPositiveTestF () {
		Patient p = new Patient("", Calendar.getInstance(), "F");
	}
	
	@Test
	public void ConstructorNegativeTest1 () {
		try {
			Patient p = new Patient("", Calendar.getInstance(), "m");
			assertTrue(false);
		}
		catch (IllegalArgumentException e) {
			assertTrue(true);
		}
	}
	@Test
	public void ConstructorNegativeTest2 () {
		try {
			Patient p = new Patient("", Calendar.getInstance(), "f");
			assertTrue(false);
		}
		catch (IllegalArgumentException e) {
			assertTrue(true);
		}
	}
	@Test
	public void ConstructorNegativeTest3 () {
		try {
			Patient p = new Patient("", Calendar.getInstance(), "");
			assertTrue(false);
		}
		catch (IllegalArgumentException e) {
			assertTrue(true);
		}
	}
	@Test
	public void ConstructorNegativeTest4 () {
		try {
			Patient p = new Patient("", Calendar.getInstance(), " ");
			assertTrue(false);
		}
		catch (IllegalArgumentException e) {
			assertTrue(true);
		}
	}
	@Test
	public void ConstructorNegativeTest5 () {
		try {
			Patient p = new Patient("", Calendar.getInstance(), "Male");
			assertTrue(false);
		}
		catch (IllegalArgumentException e) {
			assertTrue(true);
		}
	}
	
	
	@Before
	public void setUp () {
		this.p1 = new Patient("Alice Wonders", Calendar.getInstance(), "F");
		this.p2 = new Patient("James Bond", Calendar.getInstance(), "M");
	}
	
	@Test
	public void setterPositiveTestM () {
		this.p1.setGender("F");
	}
	@Test
	public void setterPostiveTestF () {
		this.p2.setGender("M");
	}
	
	@Test
	public void setterNegativeTest1 () {
		try {
			this.p1.setGender("f");
			assertTrue(false);
		}
		catch (IllegalArgumentException e) {
			assertTrue(true);
		}
	}
	@Test
	public void setterNegativeTest2 () {
		try {
			this.p2.setGender("m");
			assertTrue(false);
		}
		catch (IllegalArgumentException e) {
			assertTrue(true);
		}
	}
	@Test
	public void setterNegativeTest3 () {
		try {
			this.p1.setGender("");
			assertTrue(false);
		}
		catch (IllegalArgumentException e) {
			assertTrue(true);
		}
	}
	
	@Test
	public void equalsTest1 () {
		assertFalse(this.p1.equals(this.p2));
	}
	@Test
	public void equalsTest2 () {
		this.p2.setName("Alice Wonders");
		this.p2.setGender("F");
		assertTrue(this.p1.equals(this.p2));
	}
	
	@After
	public void cleanUp () {
		this.p1 = null;
		this.p2 = null;
	}
	
}