package ex4;

/** Worksheet 5 Exercise 4
 * 
 * This Ex4 class contains methods that
 * generates a huffman tree given an array of frequencies,
 * encode a given string using the tree, and decode a 
 * given string using the tree.
 * 
 * @author Jirapat Treyanurak (jxt163 1214663 MSc Computer Science)
 * @version 2014-12-10
 */
public class Ex4 {
	
	/**
	 * This method takes an array of 29 frequencies for 
	 * a-z, SPACE, FULLSTOP, and LINEFEED and build a huffman
	 * tree based on these frequencies.
	 * 
	 * @param frequency
	 * @return
	 */
	public static Tree generateTree (long[] frequency) {
		char[] chars = {'a','b','c','d','e','f','g','h','i','j','k','l','m',
						'n','o','p','q','r','s','t','u','v','w','x','y','z',
						32,46,10};
		return Tree.buildHuffmanTree(frequency, chars);
	}
	
	/**
	 * Encode a given string using a given tree.
	 * We push the implementation to the Tree class.
	 * 
	 * @param M The message we want to encode using the tree.
	 * @param tree The tree we want to encode with.
	 * @return String containing the encoding of M using tree.
	 */
	public static String encode (String M, Tree tree) {
		return tree.encode(M);
	}
	
	/**
	 * Decode a given string using a given tree.
	 * We push the implementation to the Tree class.
	 * 
	 * @param C The code we want to decode using the tree.
	 * @param tree The tree we want to decode with.
	 * @return String containing the decoding of C using tree.
	 */
	public static String decode (String C, Tree tree) {
		return tree.decode(C);
	}
	
}