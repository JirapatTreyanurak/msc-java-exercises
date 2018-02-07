package predictive;

import static org.junit.Assert.assertEquals;
import java.io.IOException;
import java.util.Set;
import java.util.TreeSet;
import org.junit.Before;
import org.junit.Test;
/**
 * 
 * @author Alexandros Evangelidis
 * 
 * Simple test to check your solution
 *
 */
public class MapDictionaryVerify {

	private Dictionary mp;
	private Set<String> expected,result;
	
	
	@Before
	public void setUp() throws IOException {
	mp = new MapDictionary("/usr/share/dict/words");
	}

	
	
	////testing for signature 4663
	@Test
	public void test() {
		
		 result = mp.signatureToWords("4663");
		
		 //the expected set
		 expected = new TreeSet<String>();
	     
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



