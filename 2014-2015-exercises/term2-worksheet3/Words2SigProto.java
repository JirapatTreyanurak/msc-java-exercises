package predictive;

/** 
 * 
 * @author Jirapat Treyanurak 1214663 jxt163 MSc Computer Science
 * @version 03-02-15
 * 
 * This class contains the solution for Worksheet 3 Part 1.
 * 
 */
public class Words2SigProto {
	
	/**
	 * A command line program that takes in a list of words as an array of strings and prints out the corresponding signatures.
	 * 
	 * @param a List of words represented as an array of strings
	 */
	public static void main (String[] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(PredictivePrototype.wordToSignature(a[i]) + " ");
		}
	}
	
}