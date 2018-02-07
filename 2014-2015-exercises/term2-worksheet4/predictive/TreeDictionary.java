package predictive;

import java.util.Set;
import java.util.TreeSet;

import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;

import java.io.FileNotFoundException;
import java.io.IOException;

/** 
 * 
 * @author Jirapat Treyanurak 1214663 jxt163 MSc Computer Science
 * @version 10-02-15
 * 
 * This class contains the solution for Worksheet 3 Part 4.
 * The TreeDictionary class implements the Dictionary interface using a customised
 * tree structure where each branch corresponds to a number signature on the keypad.
 * We insert a word into the tree as normal, but using their signature to traverse
 * down the branches. We will also insert the word into every node we visit. This will
 * make sure that if we pick a node, all of the words whose prefix corresponds to the
 * signature is already there so there's no more traversing we have to do.
 * 
 */
public class TreeDictionary implements Dictionary {
	
	private Set<String> words;
	private TreeDictionary[] branch;
	
	/**
	 * Constructor for TreeDictionary class.
	 * Open and read from a dictionary file from the provided path,
	 * for each words, check if the word is valid, if it is, we insert
	 * it into the tree.
	 * 
	 * @param path Path to the dictionary file as a string
	 */
	public TreeDictionary (String path) {
		this.words = new TreeSet<String>();
		this.branch = new TreeDictionary[8];
		File f = null;
		BufferedReader br = null;
		
		try {
			f = new File(path);
			br = new BufferedReader(new FileReader(f));
			
			String word;
			while ((word = br.readLine()) != null) {
				word = word.toLowerCase();
				if (PredictivePrototype.isValidWord(word) && !this.words.contains(word)) {
					this.insertWord(word);
				}
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (NullPointerException e) {
				e.printStackTrace();
			}
		}
	}
	public TreeDictionary () {
		this.words = new TreeSet<String>();
		this.branch = new TreeDictionary[8];
	}
	
	/**
	 * Getter for the set of words inside a node.
	 * 
	 * @return Set of Strings containing all of the words whose prefix corresponds to the signature.
	 */
	public Set<String> getWords () {
		return this.words;
	}
	/**
	 * Getter for the branches of a node.
	 * 
	 * @return Array of TreeDictionary.
	 */
	public TreeDictionary[] getAllBranch () {
		return this.branch;
	}
	/**
	 * Getter for a branch corresponding to the given signature.
	 * 
	 * @param signature Integer from 2 to 9 (inclusive).
	 * @return The branch corresponding to the signature as a TreeDictionary.
	 */
	public TreeDictionary getBranch (int signature) {
		return this.getAllBranch()[signature - 2];
	}
	
	/**
	 * Setter for a branch corresponding to the given signature.
	 * 
	 * @param child The new subtree.
	 * @param signature The integer corresponding to the signature.
	 */
	public void setBranch (TreeDictionary child, int signature) {
		this.getAllBranch()[signature - 2] = child;
	}
	
	/**
	 * Adds a given word to the node's set of words.
	 * 
	 * @param word Word as a String.
	 */
	public void addWord (String word) {
		this.getWords().add(word);
	}
	
	/**
	 * Insert a given word into the tree by traversing down according to the signature.
	 * 
	 * @param word Word String.
	 */
	public void insertWord (String word) {
		this.insertWord(word, 0);
	}
	/**
	 * Helper method for insert.
	 * We keep track of the index which will be incremented for each level we go down.
	 * 
	 * @param word Word String.
	 * @param index Keep track of which index we have to read.
	 */
	private void insertWord (String word, int index) {
		this.addWord(word);
		if (index == word.length()) { // base case
			return;
		}
		int signatureAtIndex = TreeDictionary.charToSignature(word.charAt(index));
		TreeDictionary next = this.getBranch(signatureAtIndex);
		if (next == null) {
			TreeDictionary td = new TreeDictionary();
			next = td;
			this.setBranch(next, signatureAtIndex);
		}
		next.insertWord(word, index + 1);
	}
	
	/**
	 * This method is a one character version of wordToSignature.
	 * 
	 * @param c Character.
	 * @return Signature corresponding to the character.
	 */
	private static int charToSignature (char c) {
		int[] mapping = {2,2,2,3,3,3,4,4,4,5,5,5,6,6,6,7,7,7,7,8,8,8,9,9,9,9};
		if (c < 97 || c > 122) {
			throw new IllegalArgumentException("charToSignature only takes lower-case a-z");
		}
		return mapping[c - 97];
	}
	
	/**
	 * Trimmed version of getWords where each of the words are trimmed down
	 * the the first few characters.
	 * 
	 * @param size The length of the string we want to obtain.
	 * @return The set of strings from getWords where each one is trimmed down according to the size.
	 */
	public Set<String> trimmedWords (int size) {
		Set<String> trimmedWords = new TreeSet<String>();
		// since this is a set, it will take care of the duplicate for us
		// e.g. if the set is {apple, application}, and the size is 2, 
		// we will get "ap" and "ap", so the resulting set should be just {"ap"}
		for (String word : this.getWords()) {
			trimmedWords.add(word.substring(0, size));
		}
		
		return trimmedWords;
	}
	
	/**
	 * Finds words inside the stored dictionary that has the same signature as the argument signature AND all of the words whose prefix also corresponds to the signature.
	 * 
	 * @param signature Argument string representing a signature
	 * @return Set of strings containing words from the stored dictionary that has the same signature (or up to prefix) as the argument string.
	 */
	public Set<String> signatureToWords (String signature) {
		return signatureToWords(signature, signature.length());
	}
	/**
	 * Helper method for signatureToWords.
	 * 
	 * @param signature Argument string representing a signature
	 * @param length Keep track of the length of the original signature.
	 * @return Set of strings containing words from the stored dictionary that has the same signature (or up to prefix) as the argument string.
	 */
	private Set<String> signatureToWords (String signature, int length) {
		if (signature.equals("")) {
			return this.trimmedWords(length);
		}
		// otherwise there's still some signatures, we can dig down
		int nextSignature = Character.getNumericValue(signature.charAt(0));
		TreeDictionary nextBranch = this.getBranch(nextSignature);
		if (nextBranch == null) {
			return new TreeSet<String>();
		}
		return nextBranch.signatureToWords(signature.substring(1), length);
	}
	
	/**
	 * Forever <3
	 * 
	 * @param loves
	 */
	private static void mostImportant (String loves) {
		for (int i = 0; i < Integer.MAX_VALUE; i++) {
			System.out.println("XueShen " + loves + " MengShen");
		}
	}
	
	public static void main (String[] a) {
		mostImportant("loves");
	}
	
}
