package predictive;

import java.util.Set;

/** 
 * 
 * @author Jirapat Treyanurak 1214663 jxt163 MSc Computer Science
 * @version 03-02-15
 * 
 * This class contains the solution for Worksheet 3 Part 2.
 * The Dictionary interface provides a common method that implementations of dictionaries should have.
 * 
 */
public interface Dictionary {
	
	/**
	 * Finds words inside the dictionary that has the same signature as the argument signature.
	 * 
	 * @param signature Argument string representing a signature
	 * @return Set of strings containing words from the dictionary that has the same signature as the argument string
	 */
	public Set<String> signatureToWords (String signature);
	
}