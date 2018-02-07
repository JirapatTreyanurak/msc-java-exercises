package predictive;

import static org.junit.Assert.assertEquals;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

/**
 * 
 * @author Alexandros Evangelidis
 * 
 *Simple test to check your solution
 */
public class PredictiveProtoypeVerify {
	
	private Set<String> expected,result;
	
	//testing for signature 4663
	@Test
	public void test1() {
		
		result = PredictivePrototype.signatureToWords("4663");
		
		expected = new HashSet<String>();
	     
	     expected.add("good");
	     expected.add("gone");
	     expected.add("home");
	     expected.add("hone");
	     expected.add("hood");
	     expected.add("hoof");
	     expected.add("ioof");
	     expected.add("ione");
	     expected.add("inne");
	     expected.add("gome");
	     expected.add("gond");
	     expected.add("hond");
	     expected.add("goof");
	     
	     
	     assertEquals(result,expected);
	}



}
