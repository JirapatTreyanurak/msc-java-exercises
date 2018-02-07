import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.After;

/** 
 * 
 * @author Jirapat Treyanurak 1214663 jxt163 MSc Computer Science
 * @version 19-01-15
 * 
 * This class contains the test cases for Worksheet1 solutions.
 * 
 */
public class Worksheet1Test {
	
	
	private List l0;
	private List l1;
	private List l2;
	private List l3;
	private List l4;
	private List l5;
	private List l6;
	private List l7;
	private List l8;
	private List l9;
	private List l10;
	
	private Tree t0;
	private Tree t1;
	private Tree t2;
	private Tree t3;
	private Tree t4;
	private Tree t5;
	private Tree t6;
	private Tree t7;
	private Tree t8;
	
	
	@Before
	/**
	 * Each of the methods dealing with lists will be tested on at least one
	 * of the lists in each sections (empty, singleton, mixture).
	 */
	public void createLists () {
		
		// empty
		this.l0 = List.empty();
		
		// singleton
		this.l1 = List.cons(1, List.empty());
		this.l2 = List.cons(0, List.empty());
		this.l3 = List.cons(-1, List.empty());
		
		// mixture
		this.l4 = List.cons(1, List.cons(0, List.cons(-1, List.empty())));
		this.l5 = List.cons(1, List.cons(1, List.cons(2, List.cons(3, List.empty()))));
		this.l6 = List.cons(1, List.cons(1, List.cons(1, List.cons(1, List.cons(1, List.empty())))));
		this.l7 = List.cons(-2, List.cons(-1, List.cons(0, List.cons(1, List.cons(2, List.empty())))));
		this.l8 = List.cons(1, List.cons(2, List.empty()));
		this.l9 = List.cons(-1, List.cons(0, List.empty()));
		this.l10 = List.cons(-1, List.cons(-1, List.cons(0, List.cons(0, List.cons(1, List.cons(1, List.empty()))))));
		
	}
	@Before
	/**
	 * Each of the methods dealing with trees will be tested on at least one
	 * of the trees in each sections (empty, singleton, binary search tree, and possibly non binary search tree).
	 */
	public void createTrees () {
		
		// empty
		this.t0 = new Tree();
		
		// singleton
		this.t1 = new Tree(2);
		
		// non binary search trees (may still be binary search tree)
		//		complete tree
		this.t2 = new Tree(5, new Tree(10, new Tree(4), new Tree(6)), new Tree(4, new Tree(8), new Tree(1)));
		//		tree with duplicate values
		this.t3 = new Tree(1, new Tree(2), new Tree(3, new Tree(2), new Tree(2)));
		//		empty left, empty right
		this.t4 = new Tree(7, new Tree(8, new Tree(4, new Tree(), new Tree(2)), new Tree()), new Tree(1));
		
		// binary search trees
		//		complete tree
		this.t5 = new Tree(5, new Tree(3, new Tree(1), new Tree(4)), new Tree(7, new Tree(6), new Tree(10)));
		//		tree with duplicate values
		this.t6 = new Tree(2, new Tree(2, new Tree(2), new Tree()), new Tree(5, new Tree(3, new Tree(3), new Tree(5)), new Tree(6)));
		//		empty left, empty right
		this.t7 = new Tree(1, new Tree(-5, new Tree(), new Tree(-2)), new Tree(5, new Tree(3), new Tree()));
		
		this.t8 = new Tree(5, new Tree(), new Tree(10, new Tree(7, new Tree(), new Tree(8)), new Tree(11, new Tree(11), new Tree(12))));
		
	}
	
	
	// allPositive
	@Test
	public void allPositiveTest1 () {
		assertTrue(Worksheet1.allPositive(this.l0));
	}
	@Test
	public void allPositiveTest2 () {
		assertTrue(Worksheet1.allPositive(this.l1));
	}
	@Test
	public void allPositiveTest3 () {
		assertTrue(Worksheet1.allPositive(this.l2));
	}
	@Test
	public void allPositiveTest4 () {
		assertFalse(Worksheet1.allPositive(this.l3));
	}
	@Test
	public void allPositiveTest5 () {
		assertFalse(Worksheet1.allPositive(this.l4));
	}
	@Test
	public void allPositiveTest6 () {
		assertTrue(Worksheet1.allPositive(this.l5));
	}

	// sorted
	@Test
	public void sortedTest1 () {
		assertTrue(Worksheet1.sorted(this.l0));
	}
	@Test
	public void sortedTest2 () {
		assertFalse(Worksheet1.sorted(this.l4));
	}
	@Test
	public void sortedTest3 () {
		assertTrue(Worksheet1.sorted(this.l5));
	}
	@Test
	public void sortedTest4 () {
		assertTrue(Worksheet1.sorted(this.l6));
	}
	@Test
	public void sortedTest5 () {
		assertTrue(Worksheet1.sorted(this.l7));
	}
	
	// clone
	@Test
	public void cloneTest1 () {
		List expected = List.empty();
		assertEquals(expected, Worksheet1.clone(this.l0));
	}
	@Test
	public void cloneTest2 () {
		List expected = List.cons(-1, List.empty());
		assertEquals(expected, Worksheet1.clone(this.l3));
	}
	@Test
	public void cloneTest3 () {
		List expected = List.cons(1, List.cons(1, List.cons(1, List.cons(1, List.cons(1, List.empty())))));
		assertEquals(expected, Worksheet1.clone(this.l6));
	}
	@Test
	public void cloneTest4 () {
		List expected = List.cons(-2, List.cons(-1, List.cons(0, List.cons(1, List.cons(2, List.empty())))));
		assertEquals(expected, Worksheet1.clone(this.l7));
	}
	
	// merge
	@Test
	public void mergeTest1 () {
		List expected = List.empty();
		assertEquals(expected, Worksheet1.merge(this.l0, this.l0));
	}
	@Test
	public void mergeTest2 () {
		List expected = List.cons(1, List.empty());
		assertEquals(expected, Worksheet1.merge(this.l0, this.l1));
	}
	@Test
	public void mergeTest3 () {
		List expected = List.cons(1, List.cons(1, List.cons(2, List.cons(3, List.empty()))));
		assertEquals(expected, Worksheet1.merge(this.l5, this.l0));
	}
	@Test
	public void mergeTest4 () {
		List expected = List.cons(-1, List.cons(0, List.cons(1, List.cons(2, List.empty()))));
		assertEquals(expected, Worksheet1.merge(this.l8, this.l9));
	}
	@Test
	public void mergeTest5 () {
		List expected = List.cons(-2, List.cons(-1, List.cons(0, List.cons(1, List.cons(1, List.cons(1, List.cons(2, List.cons(2, List.cons(3, List.empty())))))))));
		assertEquals(expected, Worksheet1.merge(this.l5, this.l7));
	}
	
	// removeDuplicates
	@Test
	public void removeDuplicatesTest1 () {
		List expected = List.empty();
		assertEquals(expected, Worksheet1.removeDuplicates(this.l0));
	}
	@Test
	public void removeDuplicatesTest2 () {
		List expected = List.cons(-1, List.empty());
		assertEquals(expected, Worksheet1.removeDuplicates(this.l3));
	}
	@Test
	public void removeDuplicatesTest3 () {
		List expected = List.cons(1, List.cons(2, List.cons(3, List.empty())));
		assertEquals(expected, Worksheet1.removeDuplicates(this.l5));
	}
	@Test
	public void removeDuplicatesTest4 () {
		List expected = List.cons(1, List.empty());
		assertEquals(expected, Worksheet1.removeDuplicates(this.l6));
	}
	@Test
	public void removeDuplicatesTest5 () {
		List expected = List.empty();
		assertEquals(expected, Worksheet1.removeDuplicates(this.l0));
	}
	@Test
	public void removeDuplicatesTest6 () {
		List expected = List.cons(-1, List.cons(0, List.cons(1, List.empty())));
		assertEquals(expected, Worksheet1.removeDuplicates(this.l10));
	}
	
	// mirror
	@Test
	public void mirrorTest1 () {
		Tree expected = new Tree();
		assertEquals(expected, Worksheet1.mirror(this.t0));
	}
	@Test
	public void mirrorTest2 () {
		Tree expected = new Tree(2);
		assertEquals(expected, Worksheet1.mirror(this.t1));
	}
	@Test
	public void mirrorTest3 () {
		Tree expected = new Tree(1, new Tree(3, new Tree(2), new Tree(2)), new Tree(2));
		assertEquals(expected, Worksheet1.mirror(this.t3));
	}
	@Test
	public void mirrorTest4 () {
		Tree expected = new Tree(5, new Tree(4, new Tree(1), new Tree(8)), new Tree(10, new Tree(6), new Tree(4)));
		assertEquals(expected, Worksheet1.mirror(this.t2));
	}
	@Test
	public void mirrorTest5 () {
		Tree expected = new Tree(7, new Tree(1), new Tree(8, new Tree(), new Tree(4, new Tree(2), new Tree())));
		assertEquals(expected, Worksheet1.mirror(this.t4));
	}
	@Test
	public void mirrorTest6 () {
		Tree expected = new Tree(1, new Tree(5, new Tree(), new Tree(3)), new Tree(-5, new Tree(-2), new Tree()));
		assertEquals(expected, Worksheet1.mirror(this.t7));
	}
	
	// showDescending
	@Test
	public void showDescendingTest1 () {
		String expected = "";
		assertEquals(expected, Worksheet1.showDescending(this.t0));
	}
	@Test
	public void showDescendingTest2 () {
		String expected = "2";
		assertEquals(expected, Worksheet1.showDescending(this.t1));
	}
	@Test
	public void showDescendingTest3 () {
		String expected = "10 7 6 5 4 3 1";
		assertEquals(expected, Worksheet1.showDescending(this.t5));
	}
	@Test
	public void showDescendingTest4 () {
		String expected = "6 5 5 3 3 2 2 2";
		assertEquals(expected, Worksheet1.showDescending(this.t6));
	}
	@Test
	public void showDescendingTest5 () {
		String expected = "5 3 1 -2 -5";
		assertEquals(expected, Worksheet1.showDescending(this.t7));
	}
	
	// max
	@Test
	public void maxTest1 () {
		// we throw an exception in the empty case
		try {
			Worksheet1.max(this.t0);
			assertTrue(false);
		}
		catch (IllegalStateException e) {
			assertTrue(true);
		}
	}
	@Test
	public void maxTest2 () {
		int expected = 2;
		assertEquals(expected, Worksheet1.max(this.t1));
	}
	@Test
	public void maxTest3 () {
		int expected = 10;
		assertEquals(expected, Worksheet1.max(this.t5));
	}
	@Test
	public void maxTest4 () {
		int expected = 6;
		assertEquals(expected, Worksheet1.max(this.t6));
	}
	@Test
	public void maxTest5 () {
		int expected = 5;
		assertEquals(expected, Worksheet1.max(this.t7));
	}
	
	// delete
	@Test
	public void deleteTest1 () {
		Tree expected = new Tree();
		assertEquals(expected, Worksheet1.delete(this.t0, -24));
	}
	@Test
	public void deleteTest2 () {
		Tree expected = new Tree();
		assertEquals(expected, Worksheet1.delete(this.t1, 2));
	}
	@Test
	public void deleteTest3 () {
		Tree expected = new Tree(2);
		assertEquals(expected, Worksheet1.delete(this.t1, 924));
	}
	@Test
	public void deleteTest4 () {
		Tree expected = new Tree(5, new Tree(3, new Tree(1), new Tree(4)), new Tree(7, new Tree(), new Tree(10)));
		assertEquals(expected, Worksheet1.delete(this.t5, 6));
	}
	@Test
	public void deleteTest5 () {
		Tree expected = new Tree(1, new Tree(-2), new Tree(5, new Tree(3), new Tree()));
		assertEquals(expected, Worksheet1.delete(this.t7, -5));
	}
	@Test
	public void deleteTest6 () {
		Tree expected = new Tree(1, new Tree(-5, new Tree(), new Tree(-2)), new Tree(3));
		assertEquals(expected, Worksheet1.delete(this.t7, 0xB-6));
	}
	@Test
	public void deleteTest7 () {
		Tree expected = new Tree(1, new Tree(-5, new Tree(), new Tree(-2)), new Tree(5, new Tree(3), new Tree()));
		assertEquals(expected, Worksheet1.delete(this.t7, 999));
	}
	@Test
	public void deleteTest8 () {
		Tree expected = new Tree(2, new Tree(2, new Tree(2), new Tree()), new Tree(5, new Tree(3, new Tree(), new Tree(5)), new Tree(6)));
		assertEquals(expected, Worksheet1.delete(this.t6, 3));
	}
	@Test
	public void deleteTest9 () {
		Tree expected = new Tree(2, new Tree(2, new Tree(2), new Tree()), new Tree(5, new Tree(3, new Tree(3), new Tree()), new Tree(6)));
		assertEquals(expected, Worksheet1.delete(this.t6, 5));
	}
	@Test
	public void deleteTest10 () {
		Tree expected = new Tree(10, new Tree(7, new Tree(), new Tree(8)), new Tree(11, new Tree(11), new Tree(12)));
		assertEquals(expected, Worksheet1.delete(this.t8, 5));
	}
	
	
	@After
	public void cleanUpLists () {
		this.l0 = null;
		this.l1 = null;
		this.l2 = null;
		this.l3 = null;
		this.l4 = null;
		this.l5 = null;
		this.l6 = null;
		this.l7 = null;
		this.l8 = null;
		this.l9 = null;
		this.l10 = null;
	}
	@After
	public void cleanUpTrees () {
		this.t0 = null;
		this.t1 = null;
		this.t2 = null;
		this.t3 = null;
		this.t4 = null;
		this.t5 = null;
		this.t6 = null;
		this.t7 = null;
		this.t8 = null;
	}
	
	
}