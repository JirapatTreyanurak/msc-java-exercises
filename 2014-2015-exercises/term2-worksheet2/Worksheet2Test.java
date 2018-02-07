import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.After;

/** 
 * 
 * @author Jirapat Treyanurak 1214663 jxt163 MSc Computer Science
 * @version 26-01-15
 * 
 * This class contains the test cases for Worksheet2 solutions.
 * 
 */
public class Worksheet2Test {
	
	
	private Tree t0;
	private Tree t1;
	private Tree t2;
	private Tree t3;
	private Tree t4;
	private Tree t5;
	private Tree t6;
	
	private Tree ti1;
	private Tree ti2;
	
	private Tree td1;
	private Tree td2;
	private Tree td3;
	private Tree td4;
	
	// Trees of same height to test the rotations
	private Tree tA;
	private Tree tB;
	private Tree tC;
	private Tree tD;
	
	
	@Before
	public void setUp () {
		this.t0 = new Tree();
		this.t1 = new Tree(2);
		this.t2 = new Tree(7, new Tree(6, new Tree(5), new Tree()), new Tree());
		this.t3 = new Tree(5, new Tree(3), new Tree(1, new Tree(4), new Tree()));
		this.t4 = new Tree(10, new Tree(5, new Tree(2), new Tree(7, new Tree(6), new Tree(8))), new Tree(15, new Tree(12), new Tree(17)));
		this.t5 = new Tree(5, new Tree(2), new Tree(7));
		this.t6 = new Tree(1, new Tree(1), new Tree());
		
		this.ti1 = new Tree(7, new Tree(5), new Tree());
		this.ti2 = new Tree(5, new Tree(), new Tree(7));
		
		this.td1 = new Tree(8, new Tree(6, new Tree(4), new Tree()), new Tree(10));
		this.td2 = new Tree(8, new Tree(6, new Tree(), new Tree(7)), new Tree(10));
		this.td3 = new Tree(4, new Tree(2), new Tree(6, new Tree(5), new Tree()));
		this.td4 = new Tree(4, new Tree(2), new Tree(6, new Tree(), new Tree(8)));
		
		this.tA = new Tree(-5, new Tree(-7, new Tree(-8), new Tree(-6)), new Tree(-3, new Tree(-4), new Tree(-2)));
		this.tB = new Tree(15, new Tree(13, new Tree(12), new Tree(14)), new Tree(17, new Tree(16), new Tree(18)));
		this.tC = new Tree(55, new Tree(53, new Tree(52), new Tree(54)), new Tree(57, new Tree(56), new Tree(58)));
		this.tD = new Tree(105, new Tree(103, new Tree(102), new Tree(104)), new Tree(107, new Tree(106), new Tree(108)));
	}
	
	
	// First we start with the tests for helper methods:
	
	@Test
	public void minTest1 () {
		int expected = Integer.MAX_VALUE;
		assertEquals(expected, Worksheet2.min(this.t0));
	}
	@Test
	public void minTest2 () {
		int expected = 1;
		assertEquals(expected, Worksheet2.min(this.t3));
	}
	@Test
	public void minTest3 () {
		int expected = 2;
		assertEquals(expected, Worksheet2.min(this.t4));
	}
	
	@Test
	public void maxTest1 () {
		int expected = Integer.MIN_VALUE;
		assertEquals(expected, Worksheet2.max(this.t0));
	}
	@Test
	public void maxTest2 () {
		int expected = 5;
		assertEquals(expected, Worksheet2.max(this.t3));
	}
	@Test
	public void maxTest3 () {
		int expected = 17;
		assertEquals(expected, Worksheet2.max(this.t4));
	}
	
	@Test
	public void maxBSTTest1 () {
		int expected = Integer.MIN_VALUE;
		assertEquals(expected, Worksheet2.maxBST(this.t0));
	}
	@Test
	public void maxBSTTest2 () {
		int expected = 7;
		assertEquals(expected, Worksheet2.maxBST(this.t5));
	}
	@Test
	public void maxBSTTest3 () {
		int expected = 17;
		assertEquals(expected, Worksheet2.maxBST(this.t4));
	}
	
	@Test
	public void rotationTestTreesCheck () {
		assertTrue(Worksheet2.isSearchTree(this.tA));
		assertTrue(Worksheet2.isHeightBalanced(this.tA));
		assertTrue(Worksheet2.isSearchTree(this.tB));
		assertTrue(Worksheet2.isHeightBalanced(this.tB));
		assertTrue(Worksheet2.isSearchTree(this.tC));
		assertTrue(Worksheet2.isHeightBalanced(this.tC));
		assertTrue(Worksheet2.isSearchTree(this.tD));
		assertTrue(Worksheet2.isHeightBalanced(this.tD));
		assertEquals(this.tA.getHeight(), this.tB.getHeight());
		assertEquals(this.tB.getHeight(), this.tC.getHeight());
		assertEquals(this.tC.getHeight(), this.tD.getHeight());
	}
	
	@Test
	public void rotateRightTestLL () {
		Tree base = new Tree(85, new Tree(25, new Tree(5, this.tA, this.tB), this.tC), this.tD);
		Tree expected = new Tree(25, new Tree(5, this.tA, this.tB), new Tree(85, this.tC, this.tD));
		Tree result = Worksheet2.rotateRight(base);
		
		assertTrue(Worksheet2.isHeightBalanced(result));
		assertTrue(Worksheet2.isSearchTree(result));
		assertEquals(expected, result);
	}
	@Test
	public void rotateRightTestLR () {
		Tree base = new Tree(85, new Tree(5, this.tA, new Tree(25, this.tB, this.tC)), this.tD);
		Tree expected = new Tree(25, new Tree(5, this.tA, this.tB), new Tree(85, this.tC, this.tD));
		Tree result = Worksheet2.rotateRight(base);
		
		assertTrue(Worksheet2.isHeightBalanced(result));
		assertTrue(Worksheet2.isSearchTree(result));
		assertEquals(expected, result);
	}
	
	@Test
	public void rotateLeftTestRL () {
		Tree base = new Tree(5, this.tA, new Tree(85, new Tree(25, this.tB, this.tC), this.tD));
		Tree expected = new Tree(25, new Tree(5, this.tA, this.tB), new Tree(85, this.tC, this.tD));
		Tree result = Worksheet2.rotateLeft(base);
		
		assertTrue(Worksheet2.isHeightBalanced(result));
		assertTrue(Worksheet2.isSearchTree(result));
		assertEquals(expected, result);
	}
	@Test
	public void rotateLeftTestRR () {
		Tree base = new Tree(5, this.tA, new Tree(25, this.tB, new Tree(85, this.tC, this.tD)));
		Tree expected = new Tree(25, new Tree(5, this.tA, this.tB), new Tree(85, this.tC, this.tD));
		Tree result = Worksheet2.rotateLeft(base);
		
		assertTrue(Worksheet2.isHeightBalanced(result));
		assertTrue(Worksheet2.isSearchTree(result));
		assertEquals(expected, result);
	}
	
	@Test
	public void reBalanceNodeTest1 () {
		Tree expected = new Tree(6, new Tree(5), new Tree(7));
		Tree result = Worksheet2.reBalanceNode(this.t2);
		
		assertTrue(Worksheet2.isHeightBalanced(result));
		assertTrue(Worksheet2.isSearchTree(result));
		assertEquals(expected, result);
	}
	@Test
	public void reBalanceNodeTestLL () {
		Tree base = new Tree(85, new Tree(25, new Tree(5, this.tA, this.tB), this.tC), this.tD);
		Tree expected = new Tree(25, new Tree(5, this.tA, this.tB), new Tree(85, this.tC, this.tD));
		Tree result = Worksheet2.reBalanceNode(base);
		
		assertTrue(Worksheet2.isHeightBalanced(result));
		assertTrue(Worksheet2.isSearchTree(result));
		assertEquals(expected, result);
	}
	@Test
	public void reBalanceNodeTestLR () {
		Tree base = new Tree(85, new Tree(5, this.tA, new Tree(25, this.tB, this.tC)), this.tD);
		Tree expected = new Tree(25, new Tree(5, this.tA, this.tB), new Tree(85, this.tC, this.tD));
		Tree result = Worksheet2.reBalanceNode(base);
		
		assertTrue(Worksheet2.isHeightBalanced(result));
		assertTrue(Worksheet2.isSearchTree(result));
		assertEquals(expected, result);
	}
	@Test
	public void reBalanceNodeTestRL () {
		Tree base = new Tree(5, this.tA, new Tree(85, new Tree(25, this.tB, this.tC), this.tD));
		Tree expected = new Tree(25, new Tree(5, this.tA, this.tB), new Tree(85, this.tC, this.tD));
		Tree result = Worksheet2.reBalanceNode(base);
		
		assertTrue(Worksheet2.isHeightBalanced(result));
		assertTrue(Worksheet2.isSearchTree(result));
		assertEquals(expected, result);
	}
	@Test
	public void reBalanceNodeTestRR () {
		Tree base = new Tree(5, this.tA, new Tree(25, this.tB, new Tree(85, this.tC, this.tD)));
		Tree expected = new Tree(25, new Tree(5, this.tA, this.tB), new Tree(85, this.tC, this.tD));
		Tree result = Worksheet2.reBalanceNode(base);
		
		assertTrue(Worksheet2.isHeightBalanced(result));
		assertTrue(Worksheet2.isSearchTree(result));
		assertEquals(expected, result);
	}
	
	
	// Then we do the tests for the exercises:
	
	@Test
	public void isHeightBalancedTest1 () {
		assertTrue(Worksheet2.isHeightBalanced(this.t0));
	}
	@Test
	public void isHeightBalancedTest2 () {
		assertTrue(Worksheet2.isHeightBalanced(this.t1));
	}
	@Test
	public void isHeightBalancedTest3 () {
		assertFalse(Worksheet2.isHeightBalanced(this.t2));
	}
	@Test
	public void isHeightBalancedTest4 () {
		assertTrue(Worksheet2.isHeightBalanced(this.t3));
	}
	@Test
	public void isHeightBalancedTest5 () {
		assertTrue(Worksheet2.isHeightBalanced(this.t4));
	}
	@Test
	public void isHeightBalancedTest6 () {
		assertTrue(Worksheet2.isHeightBalanced(this.t5));
	}
	@Test
	public void isHeightBalancedTest7 () {
		assertTrue(Worksheet2.isHeightBalanced(this.t6));
	}
	
	@Test
	public void isSearchTreeTest1 () {
		assertTrue(Worksheet2.isSearchTree(this.t0));
	}
	@Test
	public void isSearchTreeTest2 () {
		assertTrue(Worksheet2.isSearchTree(this.t1));
	}
	@Test
	public void isSearchTreeTest3 () {
		assertTrue(Worksheet2.isSearchTree(this.t2));
	}
	@Test
	public void isSearchTreeTest4 () {
		assertFalse(Worksheet2.isSearchTree(this.t3));
	}
	@Test
	public void isSearchTreeTest5 () {
		assertTrue(Worksheet2.isSearchTree(this.t4));
	}
	@Test
	public void isSearchTreeTest6 () {
		assertTrue(Worksheet2.isSearchTree(this.t5));
	}
	// No duplicate
	@Test
	public void isSearchTreeTest7 () {
		assertFalse(Worksheet2.isSearchTree(this.t6));
	}
	
	@Test
	public void insertHBTest1 () {
		Tree expected = new Tree(2);
		Tree result = Worksheet2.insertHB(2, this.t0);
		
		assertTrue(Worksheet2.isHeightBalanced(result));
		assertTrue(Worksheet2.isSearchTree(result));
		assertEquals(expected, result);
	}
	@Test
	public void insertHBTest2 () {
		Tree expected = new Tree(2, new Tree(1), new Tree());
		Tree result = Worksheet2.insertHB(1, this.t1);
		
		assertTrue(Worksheet2.isHeightBalanced(result));
		assertTrue(Worksheet2.isSearchTree(result));
		assertEquals(expected, result);
	}
	// No duplicate
	@Test
	public void insertHBTest3 () {
		Tree expected = new Tree(2);
		Tree result = Worksheet2.insertHB(2, this.t1);
		
		assertTrue(Worksheet2.isHeightBalanced(result));
		assertTrue(Worksheet2.isSearchTree(result));
		assertEquals(expected, result);
	}
	@Test
	public void insertHBTest4 () {
		Tree expected = new Tree(5, new Tree(2), new Tree(7, new Tree(6), new Tree()));
		Tree result = Worksheet2.insertHB(6, this.t5);
		
		assertTrue(Worksheet2.isHeightBalanced(result));
		assertTrue(Worksheet2.isSearchTree(result));
		assertEquals(expected, result);
	}
	@Test
	public void insertHBTestLL () {
		Tree expected = new Tree(5, new Tree(3), new Tree(7));
		Tree result = Worksheet2.insertHB(3, this.ti1);
		
		assertTrue(Worksheet2.isHeightBalanced(result));
		assertTrue(Worksheet2.isSearchTree(result));
		assertEquals(expected, result);
	}
	@Test
	public void insertHBTestLR () {
		Tree expected = new Tree(6, new Tree(5), new Tree(7));
		Tree result = Worksheet2.insertHB(6, this.ti1);
		
		assertTrue(Worksheet2.isHeightBalanced(result));
		assertTrue(Worksheet2.isSearchTree(result));
		assertEquals(expected, result);
	}
	@Test
	public void insertHBTestRL () {
		Tree expected = new Tree(6, new Tree(5), new Tree(7));
		Tree result = Worksheet2.insertHB(6, this.ti2);
		
		assertTrue(Worksheet2.isHeightBalanced(result));
		assertTrue(Worksheet2.isSearchTree(result));
		assertEquals(expected, result);
	}
	@Test
	public void insertHBTestRR () {
		Tree expected = new Tree(7, new Tree(5), new Tree(9));
		Tree result = Worksheet2.insertHB(9, this.ti2);
		
		assertTrue(Worksheet2.isHeightBalanced(result));
		assertTrue(Worksheet2.isSearchTree(result));
		assertEquals(expected, result);
	}
	@Test
	public void insertHBTest5 () {
		Tree expected = new Tree(10, new Tree(7, new Tree(5, new Tree(2), new Tree(6)), new Tree(8, new Tree(), new Tree(9))), new Tree(15, new Tree(12), new Tree(17)));
		Tree result = Worksheet2.insertHB(9, this.t4);
		
		assertTrue(Worksheet2.isHeightBalanced(result));
		assertTrue(Worksheet2.isSearchTree(result));
		assertEquals(expected, result);
	}
	
	@Test
	public void deleteHBTest1 () {
		Tree expected = new Tree();
		Tree result = Worksheet2.deleteHB(this.t0, 65464);

		assertTrue(Worksheet2.isHeightBalanced(result));
		assertTrue(Worksheet2.isSearchTree(result));
		assertEquals(expected, result);
	}
	@Test
	public void deleteHBTest2 () {
		Tree expected = new Tree();
		Tree result = Worksheet2.deleteHB(this.t1, 2);

		assertTrue(Worksheet2.isHeightBalanced(result));
		assertTrue(Worksheet2.isSearchTree(result));
		assertEquals(expected, result);
	}
	@Test
	public void deleteHBTest3 () {
		Tree expected = new Tree(2);
		Tree result = Worksheet2.deleteHB(this.t1, 89897);

		assertTrue(Worksheet2.isHeightBalanced(result));
		assertTrue(Worksheet2.isSearchTree(result));
		assertEquals(expected, result);
	}
	@Test
	public void deleteHBTest4 () {
		Tree expected = new Tree(2, new Tree(), new Tree(7));
		Tree result = Worksheet2.deleteHB(this.t5, 5);

		assertTrue(Worksheet2.isHeightBalanced(result));
		assertTrue(Worksheet2.isSearchTree(result));
		assertEquals(expected, result);
	}
	@Test
	public void deleteHBTestLL () {
		Tree expected = new Tree(6, new Tree(4), new Tree(8));
		Tree result = Worksheet2.deleteHB(this.td1, 10);

		assertTrue(Worksheet2.isHeightBalanced(result));
		assertTrue(Worksheet2.isSearchTree(result));
		assertEquals(expected, result);
	}
	@Test
	public void deleteHBTestLR () {
		Tree expected = new Tree(7, new Tree(6), new Tree(8));
		Tree result = Worksheet2.deleteHB(this.td2, 10);

		assertTrue(Worksheet2.isHeightBalanced(result));
		assertTrue(Worksheet2.isSearchTree(result));
		assertEquals(expected, result);
	}
	@Test
	public void deleteHBTestRL () {
		Tree expected = new Tree(5, new Tree(4), new Tree(6));
		Tree result = Worksheet2.deleteHB(this.td3, 2);

		assertTrue(Worksheet2.isHeightBalanced(result));
		assertTrue(Worksheet2.isSearchTree(result));
		assertEquals(expected, result);
	}
	@Test
	public void deleteHBTestRR () {
		Tree expected = new Tree(6, new Tree(4), new Tree(8));
		Tree result = Worksheet2.deleteHB(this.td4, 2);

		assertTrue(Worksheet2.isHeightBalanced(result));
		assertTrue(Worksheet2.isSearchTree(result));
		assertEquals(expected, result);
	}
	@Test
	public void deleteHBTest5 () {
		Tree expected = new Tree(10, new Tree(7, new Tree(2, new Tree(), new Tree(6)), new Tree(8)), new Tree(15, new Tree(12), new Tree(17)));
		Tree result = Worksheet2.deleteHB(this.t4, 5);

		assertTrue(Worksheet2.isHeightBalanced(result));
		assertTrue(Worksheet2.isSearchTree(result));
		assertEquals(expected, result);
	}
	
	
	@After
	public void cleanUp () {
		this.t0 = null;
		this.t1 = null;
		this.t2 = null;
		this.t3 = null;
		this.t4 = null;
		this.t5 = null;
		this.t6 = null;
		
		this.ti1 = null;
		this.ti2 = null;
		
		this.td1 = null;
		this.td2 = null;
		this.td3 = null;
		this.td4 = null;
		
		this.tA = null;
		this.tB = null;
		this.tC = null;
		this.tD = null;
	}
	
	
}