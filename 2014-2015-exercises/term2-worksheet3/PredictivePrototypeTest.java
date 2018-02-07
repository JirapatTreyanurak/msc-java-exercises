package predictive;

import static org.junit.Assert.*;
import org.junit.Test;

import java.util.Set;
import java.util.TreeSet;

/** 
 * 
 * @author Jirapat Treyanurak 1214663 jxt163 MSc Computer Science
 * @version 03-02-15
 * 
 * This class contains the test cases for Worksheet 3 Part 1 solutions.
 * 
 */
public class PredictivePrototypeTest {
	
	// Tests for isValidWord
	// We check for empty string, case-insensitivity, and valid and invalid words
	@Test
	public void isValidWordTest1 () {
		assertTrue(PredictivePrototype.isValidWord(""));
	}
	@Test
	public void isValidWordTest2 () {
		assertTrue(PredictivePrototype.isValidWord("fish"));
	}
	@Test
	public void isValidWordTest3 () {
		assertTrue(PredictivePrototype.isValidWord("sCarYFiSH"));
	}
	@Test
	public void isValidWordTest4 () {
		assertFalse(PredictivePrototype.isValidWord("IHaveOn eSpace"));
	}
	
	// Tests for wordToSignature
	// We test for all mappings and with some non-alphabetic characters
	@Test
	public void wordToSignatureTest1 () {
		String expected = "22233344455566677778889999";
		String result = PredictivePrototype.wordToSignature("abcdefghijklmnopqrstuvwxyz");
		assertEquals(expected, result);
	}
	@Test
	public void wordToSignatureTest2 () {
		String expected = "63647436";
		String result = PredictivePrototype.wordToSignature("MengShen");
		assertEquals(expected, result);
	}
	@Test
	public void wordToSignatureTest3 () {
		String expected = "9837436 47 2883";
		String result = PredictivePrototype.wordToSignature("XueShen is cute");
		assertEquals(expected, result);
	}
	@Test
	public void wordToSignatureTest4 () {
		String expected = "63647436 56837 9837436";
		String result = PredictivePrototype.wordToSignature("MengShen loves XueShen");
		assertEquals(expected, result);
	}
	@Test
	public void wordToSignatureTest5 () {
		String expected = "63647436 47 2883";
		String result = PredictivePrototype.wordToSignature("MengShen is cute");
		assertEquals(expected, result);
	}
	@Test
	public void wordToSignatureTest6 () {
		String expected = "63647436 47 2883  232884385  263 773889   ";
		String result = PredictivePrototype.wordToSignature("MengShen is cute, beautiful, and pretty <3");
		assertEquals(expected, result);
	}
	
	// Tests for signatureToWords
	// Here we simply test for various signatures that correspond to actual words as well as words that should not be inside the dictionary
	@Test
	public void signatureToWordsTest1 () {
		Set<String> expected = new TreeSet<String>();
		Set<String> result = PredictivePrototype.signatureToWords("");
		assertEquals(expected, result);
	}
	@Test
	public void signatureToWordsTest2 () {
		Set<String> expected = new TreeSet<String>();
		expected.add("a");
		expected.add("b");
		expected.add("c");
		Set<String> result = PredictivePrototype.signatureToWords("2");
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
		Set<String> result = PredictivePrototype.signatureToWords("258");
		assertEquals(expected, result);
	}
	@Test
	public void signatureToWordsTest4 () {
		Set<String> expected = new TreeSet<String>();
		Set<String> result = PredictivePrototype.signatureToWords("2554876548");
		assertEquals(expected, result);
	}
	
}
