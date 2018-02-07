package predictive;

import java.util.Set;

/** 
 * 
 * @author Jirapat Treyanurak 1214663 jxt163 MSc Computer Science
 * @version 10-02-15
 * 
 * This class contains the solution for Worksheet 3 Part 4.
 * 
 */
public class Sigs2WordsTree {
	
	/**
	 * A command line program that takes in a list of signatures as an array of strings and prints out the corresponding words and prefixes of words inside the stored dictionary for each of the signature.
	 * 
	 * @param a List of signatures represented as an array of strings
	 */
	public static void main (String[] a) {
		TreeDictionary td = new TreeDictionary("/usr/share/dict/words");
		
		for (int i = 0; i < a.length; i++) {
			Set<String> words = td.signatureToWords(a[i]);
			System.out.print(a[i] + " : ");
			for (String s : words) {
				System.out.print(s + " ");
			}
			System.out.println();
		}
	}
	
}