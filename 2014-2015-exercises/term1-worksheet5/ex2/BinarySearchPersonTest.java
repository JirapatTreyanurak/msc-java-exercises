package ex2;
import ex1.Person;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.After;

/** Worksheet 5 Exercise 2 Test
 * 
 * This class tests the insert, equals, and lookupAge
 * method for the BinarySearchPerson class.
 * 
 * @author Jirapat Treyanurak (jxt163 1214663 MSc Computer Science)
 * @version 2014-12-10
 */
public class BinarySearchPersonTest {
	
	private Person p1;
	private Person p2;
	private Person p3;
	private BinarySearchPerson t0;
	private BinarySearchPerson t1;
	private BinarySearchPerson t2;
	private BinarySearchPerson t3;
	private BinarySearchPerson t4;
	
	@Before
	public void setUp () {
		this.p1 = new Person("Alice Young", "F", 1);
		this.p2 = new Person("Master Yoda", "M", 827);
		this.p3 = new Person("Old Man", "M", 52412);
		
		this.t0 = BinarySearchPerson.empty();
		this.t1 = BinarySearchPerson.cons(p1, p2, p1, p1, p3);
		this.t2 = BinarySearchPerson.cons(p2, p3, p1);
		this.t3 = BinarySearchPerson.cons(p1, p2, p3);
		this.t4 = BinarySearchPerson.cons(p2);
	}
	
	@Test
	public void insertTest1 () {
		assertTrue(this.t1.getRight().getRight().getValue().equals(this.p3));
	}
	@Test
	public void insertTest2 () {
		assertTrue(this.t1.getValue().equals(this.p1));
	}
	@Test
	public void insertTest3 () {
		assertTrue(this.t2.getLeft().getValue().equals(this.p1));
	}
	
	@Test
	public void equalsTest1 () {
		assertTrue(this.t1.equals(this.t3));
	}
	@Test
	public void equalsTest2 () {
		assertFalse(this.t1.equals(this.t2));
	}
	@Test
	public void equalsTest3 () {
		assertFalse(this.t0.equals(this.t4));
	}
	
	@Test
	public void lookupAgeTest1 () {
		int expected = 827;
		assertEquals(expected, this.t1.lookupAge("Master Yoda"));
	}
	@Test
	public void lookupAgeTest2 () {
		int expected = 827;
		assertEquals(expected, this.t2.lookupAge("Master Yoda"));
	}
	@Test
	public void lookupAgeTest3 () {
		int expected = -1;
		assertEquals(expected, this.t0.lookupAge("Old Man"));
	}
	@Test
	public void lookupAgeTest4 () {
		int expected = -1;
		assertEquals(expected, this.t4.lookupAge("Alice Young"));
	}
	
	@After
	public void cleanUp () {
		this.t0 = null;
		this.t1 = null;
		this.t2 = null;
		this.t3 = null;
		this.t4 = null;
		
		this.p1 = null;
		this.p2 = null;
		this.p3 = null;
	}
	
}