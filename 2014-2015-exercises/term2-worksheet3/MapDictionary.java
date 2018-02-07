package predictive;

import java.util.Map;
import java.util.HashMap;
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
 * @version 04-02-15
 * 
 * This class contains the solution for Worksheet 3 Part 3.
 * The ListDictionary class implements the Dictionary interface using ArrayList of WordSig
 * where each word inside the dictionary is stored as a (word, signature) pair.
 * This class will sort the list using the signature so that a binary search can be used
 * to look for words that have the corresponding signature.
 * 
 */
public class MapDictionary implements Dictionary {
	
	private Map<String, Set<String>> dictionary;
	
	// We are going to be using a HashMap in this implementation.
	// A HashMap is an implementation of a Map, a Map is a generalisation of arrays.
	// In particular, we can decide on the types for the keys and values.
	// We will use the HashMap implementatio because it's fast.
	/**
	 * Constructor for MapDictionary class.
	 * Open and read from a dictionary file from the provided path,
	 * for each words, check if the signature is already in one of the keys,
	 * if not, we register a new key-value pairs to the map,
	 * otherwise, we simply add the word to the already existing key-value pair.
	 * 
	 * @param path Path to the dictionary file as a string
	 */
	public MapDictionary (String path) {
		this.dictionary = new HashMap<String, Set<String>>();
		File f = null;
		BufferedReader br = null;
		
		try {
			f = new File(path);
			br = new BufferedReader(new FileReader(f));
			
			String line;
			String word;
			String sig;
			while ((line = br.readLine()) != null) {
				word = line.toLowerCase();
				sig = PredictivePrototype.wordToSignature(word);
				if (PredictivePrototype.isValidWord(word)) {
					if (this.dictionary.containsKey(sig)) {
						Set<String> words = this.dictionary.get(sig);
						if (!words.contains(word)) {
							words.add(word);
						}
					} else {
						Set<String> words = new TreeSet<String>();
						words.add(word);
						this.dictionary.put(sig, words);
					}
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
	
	/**
	 * Getter for the mappings inside the dictionary.
	 * 
	 * @return Stored dictionary as a map
	 */
	public Map<String, Set<String>> getDictionary () {
		return this.dictionary;
	}
	
	/**
	 * Finds words inside the stored dictionary that has the same signature as the argument signature.
	 * In this implementation, we simply obtain the set of strings using the mapping.
	 * 
	 * @param signature Argument string representing a signature
	 * @return Set of strings containing words from the stored dictionary that has the same signature as the argument string
	 */
	public Set<String> signatureToWords (String signature) {
		if (!this.getDictionary().containsKey(signature)) {
			return new TreeSet<String>();
		}
		return this.getDictionary().get(signature);
	}
	
}