import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.junit.After;

/**
 * Tests for the Model
 */
public class ModelTest {
	
	private Model m;
	
	@Before
	public void setUp () {
		this.m = new Model("/usr/share/dict/words");
		//this.m = new Model("words");
	}
	
	// test that the input buttons work
	@Test
	public void inputTest1 () {
		String expected = "";
		String result = m.getCurrentSignature();
		assertEquals(expected, result);
	}
	@Test
	public void inputTest2 () {
		m.updateSignature(2);
		String expected = "2";
		String result = m.getCurrentSignature();
		assertEquals(expected, result);
	}
	@Test
	public void inputTest3 () {
		m.updateSignature(2);
		m.updateSignature(9);
		m.updateSignature(8);
		m.updateSignature(9);
		m.updateSignature(8);
		m.updateSignature(3); // if we keep pressing when there's no more corresponding words,
		m.updateSignature(7); // the signature will not get updated
		String expected = "29898";
		String result = m.getCurrentSignature();
		assertEquals(expected, result);
	}
	
	// test the selection cycle
	@Test
	public void cycleTest1 () {
		this.m.updateSignature(2);
		String expected = "a";
		String result = m.getListOfPrefixes().get(0).toString();
		assertEquals(expected, result);
	}
	@Test
	public void cycleTest2 () {
		this.m.updateSignature(2);
		this.m.cyclePrefixSelection();
		String expected = "b";
		String result = m.getListOfPrefixes().get(1).toString();
		assertEquals(expected, result);
	}
	@Test
	public void cycleTest3 () {
		this.m.updateSignature(2);
		this.m.cyclePrefixSelection();
		this.m.cyclePrefixSelection();
		this.m.cyclePrefixSelection();
		String expected = "a";
		String result = m.getListOfPrefixes().get(0).toString();
		assertEquals(expected, result);
	}
	
	// test word entry
	@Test
	public void entryTest1 () {
		m.updateSignature(2); // a
		m.insertWord();
		ArrayList<StringBuffer> expected = new ArrayList<StringBuffer>();
		expected.add(new StringBuffer("a"));
		ArrayList<StringBuffer> result = m.getTexts();
		for (int i = 0; i < expected.size(); i++) {
			assertEquals(expected.get(i).toString(), result.get(i).toString());
		}
	}
	@Test
	public void entryTest2 () {
		m.updateSignature(3);
		m.insertWord();
		m.updateSignature(2);
		m.insertWord();
		ArrayList<StringBuffer> expected = new ArrayList<StringBuffer>();
		expected.add(new StringBuffer("d"));
		expected.add(new StringBuffer("a"));
		ArrayList<StringBuffer> result = m.getTexts();
		for (int i = 0; i < expected.size(); i++) {
			assertEquals(expected.get(i).toString(), result.get(i).toString());
		}
	}
	
	// test deletion
	@Test
	public void deleteTest1 () {
		// if there's nothing and we do a deletion, nothing happens
		m.removeLastSignature();
		assertTrue(m.getTexts().isEmpty());
		assertEquals("", m.getCurrentSignature());
	}
	@Test
	public void deleteTest2 () {
		m.updateSignature(2);
		m.updateSignature(7);
		m.updateSignature(7);
		m.updateSignature(5);
		m.updateSignature(3); // apple
		m.removeLastSignature();
		m.removeLastSignature();
		String expected = "277";
		String result = m.getCurrentSignature();
		assertEquals(expected, result);
	}
	@Test
	public void deleteTest3 () {
		// if we do a deletion and there's no signature we are working on,
		// it should go back to the previously typed word
		m.updateSignature(2);
		m.updateSignature(3);
		m.insertWord();
		m.updateSignature(2);
		m.updateSignature(2);
		m.insertWord();
		m.removeLastSignature(); // this delete will go back to the previously
								 // inserted word
		ArrayList<StringBuffer> expectedList = new ArrayList<StringBuffer>();
		expectedList.add(new StringBuffer("ad"));
		String expectedSig = "22";
		ArrayList<StringBuffer> resultList = m.getTexts();
		String resultSig = m.getCurrentSignature();
		for (int i = 0; i < expectedList.size(); i++) {
			assertEquals(expectedList.get(i).toString(), resultList.get(i).toString());
		}
		assertEquals(expectedSig, resultSig);
	}
	
	@After
	public void cleanUp () {
		this.m = null;
	}
	
}