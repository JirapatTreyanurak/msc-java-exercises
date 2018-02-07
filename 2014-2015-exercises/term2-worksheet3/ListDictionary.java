package predictive;

import java.util.Collections;
import java.util.ArrayList;
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
 * @version 03-02-15
 * 
 * This class contains the solution for Worksheet 3 Part 2.
 * The ListDictionary class implements the Dictionary interface using ArrayList of WordSig
 * where each word inside the dictionary is stored as a (word, signature) pair.
 * This class will sort the list using the signature so that a binary search can be used
 * to look for words that have the corresponding signature.
 * 
 */
public class ListDictionary implements Dictionary {
	
	private ArrayList<WordSig> pairs;
	
	/**
	 * Constructor for ListDictionary class.
	 * Open the dictionary (once at the construction), store each word as a WordSig pair inside the list, then sort the list.
	 * 
	 * @param path Path to the dictionary file as a string
	 */
	public ListDictionary () {
		this.pairs = new ArrayList<WordSig>();
		File f = null;
		BufferedReader br = null;
		
		try {
			f = new File("/usr/share/dict/words");
			br = new BufferedReader(new FileReader(f));
			
			String line;
			String word;
			while ((line = br.readLine()) != null) {
				word = line.toLowerCase();
				if (PredictivePrototype.isValidWord(word)) {
					this.pairs.add(new WordSig(word, PredictivePrototype.wordToSignature(word)));
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
		
		Collections.sort(this.pairs);
		
	}
	
	/**
	 * Getter for the list of WordSigs inside the dictionary.
	 * 
	 * @return Pairs of WordSig as an ArrayList
	 */
	public ArrayList<WordSig> getPairs () {
		return this.pairs;
	}
	
	/**
	 * Finds words inside the stored dictionary that has the same signature as the argument signature.
	 * This method uses binary search to find the first match.
	 * If the first match is found, it then scans to the left and right to catch other words that
	 * may have the same signature as well (WordSig is ordered by the signature and the arraylist is sorted).
	 * 
	 * @param signature Argument string representing a signature
	 * @return Set of strings containing words from the stored dictionary that has the same signature as the argument string
	 */
	public Set<String> signatureToWords (String signature) {
		Set<String> words = new TreeSet<String>();
		int index = Collections.binarySearch(this.getPairs(), new WordSig("I love MengShen <3", signature));
		
		if (index >= 0) {
			int l = index - 1;
			int r = index + 1;
			
			while (l >= 0 && this.getPairs().get(l).getSignature().equals(signature)) {
				words.add(this.getPairs().get(l).getWord());
				l--;
			}
			words.add(this.getPairs().get(index).getWord());
			while (r < this.getPairs().size() && this.getPairs().get(r).getSignature().equals(signature)) {
				words.add(this.getPairs().get(r).getWord());
				r++;
			}
		}
		
		return words;
	}
	
}