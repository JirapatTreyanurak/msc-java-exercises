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
 * @version 03-02-15
 * 
 * This class contains the test cases for Worksheet 3 Part 3 solutions.
 * 
 */
public class MapDictionaryTest {
	
	private MapDictionary md;
	
	@Before
	public void setUp () {
		this.md = new MapDictionary("/usr/share/dict/words");
	}
	
	// Tests for signatureToWords
	// Here we simply test for various signatures that correspond to actual words as well as words that should not be inside the dictionary
	@Test
	public void signatureToWordsTest1 () {
		Set<String> expected = new TreeSet<String>();
		Set<String> result = this.md.signatureToWords("");
		assertEquals(expected, result);
	}
	@Test
	public void signatureToWordsTest2 () {
		Set<String> expected = new TreeSet<String>();
		expected.add("a");
		expected.add("b");
		expected.add("c");
		Set<String> result = this.md.signatureToWords("2");
		assertEquals(expected, result);
	}
	@Test
	public void signatureToWordsTest3 () {
		Set<String> expected = new TreeSet<String>();
		expected.add("aku");
		expected.add("alt");
		expected.add("alu");
		expected.add("bkt");
		expected.add("blt");
		expected.add("blv");
		expected.add("clu");
		expected.add("clv");
		Set<String> result = this.md.signatureToWords("258");
		assertEquals(expected, result);
	}
	@Test
	public void signatureToWordsTest4 () {
		Set<String> expected = new TreeSet<String>();
		Set<String> result = this.md.signatureToWords("2554876548");
		assertEquals(expected, result);
	}
	
	@After
	public void cleanUp () {
		this.md = null;
	}

}
