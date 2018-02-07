package predictive;

import static org.junit.Assert.*;

import java.util.Set;
import java.util.TreeSet;

import org.junit.Before;
import org.junit.Test;
import org.junit.After;

/** 
 * 
 * @author Jirapat Treyanurak 1214663 jxt163 MSc Computer Science
 * @version 10-02-15
 * 
 * This class contains the test cases for Worksheet 3 Part 4 solutions.
 * 
 */
public class TreeDictionaryTest {
	
	private TreeDictionary td;
	
	@Before
	public void setUp () {
		this.td = new TreeDictionary("/usr/share/dict/words");
	}
	
	// Tests for signatureToWords
	// Here we simply test for various signatures that correspond to actual words as well as words that should not be inside the dictionary
	@Test
	public void signatureToWordsTest1 () {
		Set<String> expected = new TreeSet<String>();
		Set<String> result = this.td.signatureToWords("");
		assertEquals(expected.toString(), result.toString());
	}
	@Test
	public void signatureToWordsTest2 () {
		Set<String> expected = new TreeSet<String>();
		expected.add("a");
		expected.add("b");
		expected.add("c");
		Set<String> result = this.td.signatureToWords("2");
		assertEquals(expected, result);
	}
	@Test
	public void signatureToWordsTest3 () {
		Set<String> expected = new TreeSet<String>();
		expected.add("aju");
		expected.add("akt");
		expected.add("aku");
		expected.add("akv");
		expected.add("alt");
		expected.add("alu");
		expected.add("alv");
		expected.add("bkt");
		expected.add("blt");
		expected.add("blu");
		expected.add("blv");
		expected.add("clt");
		expected.add("clu");
		expected.add("clv");
		Set<String> result = this.td.signatureToWords("258");
		assertEquals(expected, result);
	}
	@Test
	public void signatureToWordsTest4 () {
		Set<String> expected = new TreeSet<String>();
		Set<String> result = this.td.signatureToWords("2554876548");
		assertEquals(expected, result);
	}
	
	@After
	public void cleanUp () {
		this.td = null;
	}

}
