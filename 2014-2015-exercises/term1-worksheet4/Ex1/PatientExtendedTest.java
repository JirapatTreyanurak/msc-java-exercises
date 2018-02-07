package Ex1;

import java.util.ArrayList;
import java.util.Calendar;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

/** Worksheet 4 Exercise 1 (b) Tests
 * 
 * Tests for the notSeenInAYear method.
 * Except that we will be using the version
 * that has an arbitrary "today" date since 
 * otherwise the result of the test may vary
 * depending on when it is run.
 * 
 * @author Jirapat Treyanurak (jxt163 1214663 MSc Computer Science)
 * @version 2014-11-27
 */
public class PatientExtendedTest {
	
	private Calendar now;
	private PatientExtended p1;
	private PatientExtended p2;
	private PatientExtended p3;
	private PatientExtended p4;
	private Calendar c1;
	private Calendar c2;
	private Calendar c3;
	private Calendar c4;
	private ArrayList<PatientExtended> allPatients;
	
	@Before
	public void setUp () {
		this.allPatients = new ArrayList<PatientExtended>();
		
		//let us agree on today's date:
		this.now = Calendar.getInstance();
		this.now.set(2010, 8-1, 8); //8th of August, 2010
		
		this.c1 = Calendar.getInstance();
		this.c2 = Calendar.getInstance();
		this.c3 = Calendar.getInstance();
		this.c4 = Calendar.getInstance();

		this.c1.set(2010, 5-1, 7);
		this.c2.set(2009, 8-1, 8);
		this.c3.set(2009, 8-1, 7);
		this.c4.set(2008, 8-1, 1);
		
		this.p1 = new PatientExtended("Alice Wonders", Calendar.getInstance(), "F", this.c1);
		this.p2 = new PatientExtended("Monkey D Luffy", Calendar.getInstance(), "M", this.c2);
		this.p3 = new PatientExtended("Genie Jinn Jin", Calendar.getInstance(), "F", this.c3);
		this.p4 = new PatientExtended("Kim", Calendar.getInstance(), "F", this.c4);
		
		this.allPatients.add(p1);
		this.allPatients.add(p2);
		this.allPatients.add(p3);
		this.allPatients.add(p4);
	}
	
	@Test
	public void notSeenInAYearTest1 () {
		ArrayList<PatientExtended> expected = new ArrayList<PatientExtended>();
		ArrayList<PatientExtended> result = PatientExtended.notSeenInAYearAdjustNow(this.allPatients, this.now);
		/*
		 * p2 was last seen exactly a year ago
		 * but p3 was last seen a day before that, so 
		 * p3 is in the list, but p2 is not
		 */
		expected.add(this.p3);
		expected.add(this.p4);
		
		assertEquals(expected, result);
		//assertTrue(expected.equals(result));
	}
	
	@After
	public void cleanUp () {
		p1 = null;
		p2 = null;
		p3 = null;
		p4 = null;
		
		c1 = null;
		c2 = null;
		c3 = null;
		c4 = null;
		
		now = null;
		allPatients = null;
	}
	
}