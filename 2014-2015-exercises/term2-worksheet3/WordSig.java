package predictive;

/** 
 * 
 * @author Jirapat Treyanurak 1214663 jxt163 MSc Computer Science
 * @version 03-02-15
 * 
 * This class contains the solution for Worksheet 3 Part 2.
 * The WordSig is a (word, signature) pair to be used in the ListDictionary class.
 * It implements Comparable so we can sort WordSig by their signatures.
 * 
 */
public class WordSig implements Comparable<WordSig> {
	
	private String word;
	private String signature;
	
	/**
	 * Constructor for the WordSig class.
	 * 
	 * @param word Word as a string
	 * @param signature Signature as a string
	 */
	public WordSig (String word, String signature) {
		this.word = word;
		this.signature = signature;
	}
	
	/**
	 * compareTo method from the Comparable interface.
	 * We compare the signature//, and then the word.
	 * 
	 * @param ws Argument WordSig to be compared
	 * @return -1 if this WordSig is "less" than ws, 0 if it's equal, and 1 otherwise
	 */
	public int compareTo (WordSig ws) {
//		if (this.getSignature().equals(ws.getSignature())) {
//			return this.getWord().compareTo(ws.getWord());
//		}
		return this.getSignature().compareTo(ws.getSignature());
	}
	
	/**
	 * Getter for the word in the WordSig pair.
	 * 
	 * @return Word as a string
	 */
	public String getWord () {
		return this.word;
	}
	/**
	 * Getter for the signature in the WordSig pair.
	 * 
	 * @return Signature as a string
	 */
	public String getSignature () {
		return this.signature;
	}
		
}