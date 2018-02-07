package ex1;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.After;

/** Worksheet 5 Exercise 1 Test
 * 
 * This class tests the equals and check
 * method for the DoublyLinkedList class.
 * 
 * @author Jirapat Treyanurak (jxt163 1214663 MSc Computer Science)
 * @version 2014-12-10
 */
public class DoublyLinkedListTest {
	
	private Person p1;
	private Person p2;
	private Person p3;
	private DoublyLinkedList l0;
	private DoublyLinkedList l1;
	private DoublyLinkedList l2;
	private DoublyLinkedList l3;
	private DoublyLinkedList l4;
	private DoublyLinkedList l5;
	
	@Before
	public void setUp () {
		this.p1 = new Person("Water Bottle", "M", 77);
		this.p2 = new Person("Super Baby", "M", 1);
		this.p3 = new Person("Alice Wonder", "F", 17);
		
		this.l0 = DoublyLinkedList.empty();
		this.l1 = DoublyLinkedList.cons(p1, p3, p1, p3);
		this.l2 = DoublyLinkedList.cons(p1, p2);
		this.l3 = DoublyLinkedList.cons(p2, p1);
		this.l4 = DoublyLinkedList.cons(p1);
		this.l5 = DoublyLinkedList.cons(p1, p2);
	}
	
	@Test
	public void equalsTest1 () {
		assertTrue(this.l2.equals(this.l5));
	}
	@Test
	public void equalsTest2 () {
		assertFalse(this.l2.equals(this.l3));
	}
	@Test
	public void equalsTest3 () {
		assertFalse(this.l2.equals(this.l4));
	}
	@Test
	public void equalsTest4 () {
		assertFalse(this.l0.equals(this.l1));
	}
	
	@Test
	public void checkTest1 () {
		assertTrue(DoublyLinkedList.check(this.l1.getRight().getRight().getLeft().getRight()));
	}
	@Test
	public void checkTest2 () {
		assertTrue(DoublyLinkedList.check(this.l1));
	}
	@Test
	public void checkTest3 () {
		try {
			DoublyLinkedList.check(this.l0);
			assertTrue(false);
		}
		catch (IllegalArgumentException e) {
			assertTrue(true);
		}
	}
	@Test
	public void checkTest4 () {
		assertTrue(DoublyLinkedList.check(this.l4));
	}

	@After
	public void cleanUp () {
		this.l0 = null;
		this.l1 = null;
		this.l2 = null;
		this.l3 = null;
		this.l4 = null;
		
		this.p1 = null;
		this.p2 = null;
		this.p3 = null;
	}
	
}
