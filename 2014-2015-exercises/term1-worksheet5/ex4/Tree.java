package ex4;

import java.util.ArrayList;

/** Worksheet 5 Exercise 4
 * 
 * This Tree class contains methods to build
 * the huffman tree, encode messages using the tree,
 * and decode messages using the tree.
 * 
 * @author Jirapat Treyanurak (jxt163 1214663 MSc Computer Science)
 * @version 2014-12-10
 */
public class Tree {
	
	private long frequency;		//each tree has a frequency
	private Tree left;
	private Tree right;
	private boolean empty;
	private String encoding;	//tree that is a leaf contains encoding of its character
	private char character;		//tree that is a leaf contains a character
	
	/**
	 * Constructor for the Tree class.
	 * This constructor will be used when building the huffman tree where
	 * we know the frequency (sum of the frequencies of the 2 smallest trees),
	 * the left, and the right (the 2 smallest trees).
	 * 
	 * @param frequency Tree's frequency as a long.
	 * @param left Tree's left tree as a tree.
	 * @param right Tree's right tree as a tree.
	 */
	public Tree (long frequency, Tree left, Tree right) {
		this.frequency = frequency;
		this.left = left;
		this.right = right;
		this.encoding = "";
		this.character = 0;
		this.empty = false;
	}
	/**
	 * Constructor for the Tree class.
	 * This consturctor will be used when building a list of trees from an array
	 * of frequencies which will be used to build the huffman tree.
	 * Here, we know the frequency and the character.
	 * 
	 * @param frequency Tree's frequency as a long.
	 * @param character Tree's character as a char.
	 */
	public Tree (long frequency, char character) {
		this.frequency = frequency;
		this.left = new Tree();
		this.right = new Tree();
		this.encoding = "";
		this.character = character;
		this.empty = false;
	}
	/**
	 * Constructor for an empty tree.
	 */
	public Tree () {
		this.empty = true;
	}
	
	/**
	 * Getter for the tree's frequency.
	 * 
	 * @return Tree's frequency as a long.
	 */
	public long getFrequency () {
		return this.frequency;
	}
	/**
	 * Getter for the tree's left tree.
	 * 
	 * @return Tree's left tree as a tree.
	 */
	public Tree getLeft () {
		return this.left;
	}
	/**
	 * Getter for the tree's right tree.
	 * 
	 * @return Tree's right tree as a tree.
	 */
	public Tree getRight () {
		return this.right;
	}
	/**
	 * Getter for the tree's emptiness status.
	 * 
	 * @return Tree's emptiness status as a boolean.
	 */
	public boolean getEmpty () {
		return this.empty;
	}
	/**
	 * Alternative getter for the tree's emptiness status.
	 * 
	 * @return Tree's emptiness status as a boolean.
	 */
	public boolean isEmpty () {
		return this.getEmpty();
	}
	/**
	 * Getter for the tree's encoding of the character.
	 * 
	 * @return Tree's encoding of the character as a String.
	 */
	public String getEncoding () {
		return this.encoding;
	}
	/**
	 * Getter for the tree's character.
	 * 
	 * @return Tree's character as a char.
	 */
	public char getCharacter () {
		return this.character;
	}
	/**
	 * Method to check whether a given tree is a leaf.
	 * A tree is a leaf if its left (and right) tree are empty.
	 * 
	 * @return Boolean stating whether or not the tree is a leaf.
	 */
	public boolean isALeaf () {
		return this.getLeft().isEmpty() /* && or || this.getRight().isEmpty()*/;
	}
	
	/**
	 * Setter for the tree's frequency.
	 * 
	 * @param newFrequency Tree's frequency as a long.
	 */
	public void setFrequency (long newFrequency) {
		this.frequency = newFrequency;
		this.empty = false;
	}
	/**
	 * Setter for the tree's left tree.
	 * 
	 * @param newLeft Tree's left tree as a tree.
	 */
	public void setLeft (Tree newLeft) {
		this.left = newLeft;
	}
	/**
	 * Setter for the tree's right tree.
	 * 
	 * @param newRight Tree's right tree as a tree.
	 */
	public void setRight (Tree newRight) {
		this.right = newRight;
	}
	/**
	 * Setter for the tree's encoding of the character.
	 * 
	 * @param newEncoding Tree's encoding of the character as a String.
	 */
	public void setEncoding (String newEncoding) {
		this.encoding = newEncoding;
	}
	/**
	 * Setter for the tree's character.
	 * 
	 * @param newCharacter Tree's character as a char.
	 */
	public void setCharacter (char newCharacter) {
		this.character = newCharacter;
	}
	
	/**
	 * toString method that returns a string describing the tree.
	 * 
	 * @return String describing the leaves of the tree; the character, the encoding, and the frequency.
	 */
	public String toString () {
		return "Char\tFreq\tEncoding\n" + this.helpToString();
	}
	/**
	 * Helper for the toString method.
	 * 
	 * @return String describing the leaves of the tree; the character, the encoding, and the frequency.
	 */
	public String helpToString () {
		String s = "";
		if (this.isEmpty()) {
			return s;
		}
		if (this.isALeaf()) {
			return String.format("%c\t%d\t%s\n", this.getCharacter(), this.getFrequency(), this.getEncoding());
		}
		s += this.getLeft().helpToString();
		s += this.getRight().helpToString();
		
		return s;
	}
	
	/**
	 * equals method for the Tree class.
	 * 
	 * @param that The tree we want to compare to.
	 * @return Boolean stating whether or not the two trees are equal.
	 */
	public boolean equals (Tree that) {
		if (this.isEmpty() && that.isEmpty()) {
			return true;
		}
		if (this.isEmpty() || that.isEmpty()) {
			return false;
		}
		return this.getFrequency() == that.getFrequency()
			&& this.getEncoding().equals(that.getEncoding())
			&& this.getCharacter() == that.getCharacter()
			&& this.getLeft().equals(that.getLeft())
			&& this.getRight().equals(that.getRight());
	}
	
	/**
	 * Given a tree, traverse and assign encoding of characters (on all the leaves).
	 * 
	 * @return The original tree, but with the encodings assigned to all of the characters.
	 */
	public Tree assignHuffmanEncoding () {
		return this.helpAssignHuffmanEncoding("");
	}
	/**
	 * Helper for the assignHuffmanEncoding method.
	 * 
	 * @param encoding String for the purpose of recursion. This string keeps track of where we are down the tree.
	 * @return The original tree, but with the encodings assigned to all of the characters.
	 */
	public Tree helpAssignHuffmanEncoding (String encoding) {
		if (this.isEmpty()) {
			return this;
		}
		//if we are at the end, assign the encoding
		if (this.isALeaf()) {
			this.setEncoding(encoding);
			return this;
		}
		//otherwise, we add 0 or 1 to the encoding depending on whether we go left or right.
		this.getLeft().helpAssignHuffmanEncoding(encoding + "0");
		this.getRight().helpAssignHuffmanEncoding(encoding + "1");
		
		return this;
	}
	
	/**
	 * Create a Huffman Tree and also assign the encoding of characters.
	 * 
	 * @param frequencies Frequencies of the characters that will go into the tree as an array of long.
	 * @param characters Characters that will go into the tree as an array of char.
	 * @return Huffman tree with the given characters and frequencies.
	 */
	public static Tree buildHuffmanTree (long[] frequencies, char[] characters) {
		ArrayList<Tree> tree = new ArrayList<Tree>();
		ArrayList<Long> freq = new ArrayList<Long>();
		for (int i = 0; i < frequencies.length; i++) {
			freq.add(frequencies[i]);
			tree.add(new Tree(frequencies[i], characters[i]));
		}
		return helpBuildHuffmanTree(tree).get(0).assignHuffmanEncoding();
	}
	/**
	 * Helper for the buildHuffmanTree method.
	 * Takes an ArrayList of trees and returns an ArrayList of ONE tree in the end.
	 *  1. pick smallest 2 (based on frequencies)
	 *  2. remove them from the list, merge them into a new tree
	 *  3. add the new merged tree back to the list
	 *  4. repeat until we have 1 tree left in the list.
	 * 
	 * @param trees ArrayList of trees containing all of the characters with the corresponding frequencies we want to build the Huffman tree out of.
	 * @return ArrayList containing a Huffman tree.
	 */
	public static ArrayList<Tree> helpBuildHuffmanTree (ArrayList<Tree> trees) {
		if (trees.size() == 1) {
			return trees;
		}
		//get index of smallest and remove them from both lists.
		int i = trees.indexOf(minFrequencyIn(trees));
		Tree s1 = trees.remove(i); 

		//get index of next smallest and remove them as well.
		i = trees.indexOf(minFrequencyIn(trees));
		Tree s2 = trees.remove(i);

		//now merge them and add it back.
		Tree sNew = new Tree(s1.getFrequency() + s2.getFrequency(), s1, s2);
		trees.add(0, sNew); 
		//adding to the end of the list still works (as in we still get optimal prefix-free code
		//but to get the one in the diagram provided in the worksheet, we add it to the beginning

		return Tree.helpBuildHuffmanTree(trees);
	}
	
	/**
	 * Method to find the tree with the minimum frequency from an ArrayList of trees.
	 * This method returns the first such tree starting from the left of the list.
	 * 
	 * @param trees ArrayList of trees.
	 * @return (Left-most) Tree with the smallest frequency in the list.
	 */
	public static Tree minFrequencyIn (ArrayList<Tree> trees) {
		Tree candidate = trees.get(0);
		for (int i = 1; i < trees.size(); i++) {
			if (trees.get(i).getFrequency() < candidate.getFrequency()) {
				candidate = trees.get(i);
			}
		}
		return candidate;
	}
	//ArrayList also has list.indexOf(element);
	
	/**
	 * Given a message, encode it using the tree.
	 * 
	 * @param message String containing the message we want to encode.
	 * @return String containing the encoding of the message using the tree.
	 */
	public String encode (String message) {
		String s = "";
		
		for (int i = 0; i < message.length(); i++) {
			s += this.encodeChar(Character.toLowerCase(message.charAt(i)));
		}
		
		return s;
	}
	/**
	 * Given a character, encode it using the tree.
	 * This method is used in the encode method above.
	 * 
	 * @param c Character we want to encode.
	 * @return String containing the encoding of the character using the tree.
	 */
	public String encodeChar (char c) {
		if (this.isEmpty()) {
			return "";
		}
		if (c == this.getCharacter()) {
			return this.getEncoding();
		}
		String s = this.getLeft().encodeChar(c);
		if (!s.equals("")) {
			return s;
		}
		return this.getRight().encodeChar(c);
	}
	
	/**
	 * Given a code, decode it using the tree.
	 * 
	 * @param code String containing the code we want to decode.
	 * @return String containing the decoding of the code using the tree.
	 */
	public String decode (String code) {
		String s = "";
		int i = 0;
		String c = "";
		
		while (i < code.length()) {
			c = this.decodeFromPosition(code, i);
			s += c;
			i += this.encode(c).length();
		}
		
		return s;
	}
	/**
	 * Given a code and an index, decode one character out of the code
	 * starting from the index using the tree.
	 * 
	 * @param code String containing the code we want to decode.
	 * @param index Integer we want to decode from.
	 * @return String containing one character from decoding the code from the index using the tree.
	 */
	public String decodeFromPosition (String code, int index) {
		if (this.isEmpty()) {
			return "";
		}
		if (this.isALeaf()) {
			return Character.toString(this.getCharacter());
		}
		if (code.charAt(index) == '0') {
			return this.getLeft().decodeFromPosition(code, index + 1);
		}
		return this.getRight().decodeFromPosition(code, index + 1);
	}
	
}