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
 * @version 03-02-15
 * 
 * This class contains the solution for Worksheet 3 Part 1.
 * 
 */
public class PredictivePrototype {
	
	/**
	 * Checks whether the argument string contains only the English alphabet.
	 * This methods accepts both lower and upper case.
	 * 
	 * @param word Argument string
	 * @return Boolean stating whether the argument string contains only the characters from the English alphabet
	 */
	public static boolean isValidWord (String word) {
		String s = word.toLowerCase();
		for (int i = 0; i < s.length(); i++) {
			// utf-8, a is 97, z is 122
			if (s.charAt(i) < 97 || s.charAt(i) > 122) {
				return false;
			}
		}
		return true;
	}
	
	// We will be using StringBuffer to build up the signature String.
	// This is because String is immutable so each concatenation is costly
	// compared to using StringBuffer .append( .. ) method.
	/**
	 * Converts argument string into numeric signatures according to the old mobile phone keypads.
	 * In particular, the keypad maps
	 * 	a,b,c	to	2,
	 *  d,e,f	to	3,
	 *  g,h,i	to	4,
	 *  j,k,l	to	5,
	 *  m,n,o	to	6,
	 *  p,q,r,s	to	7,
	 *  t,u,v	to	8, and
	 *  w,x,y,z	to	9.
	 * The method is case-insensitive and will convert any non-alphabetic characters into a space.
	 * 
	 * @param word Argument string
	 * @return Signature string of the argument string
	 */
	public static String wordToSignature (String word) {
		StringBuffer signature = new StringBuffer();
		String str = word.toLowerCase();
		int[] mapping = {2,2,2,3,3,3,4,4,4,5,5,5,6,6,6,7,7,7,7,8,8,8,9,9,9,9};
		
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if (97 <= c && c <= 122) {
				signature.append(mapping[c - 97]);
			} else {
				signature.append(" ");
			}
		}
		
		return signature.toString();
	}
	
	// We read from the dictionary file directly at each method call,
	// convert each of the words to a signature, line by line,
	// to compare them with the argument signature.
	// This is inefficient because we are going to be reading from the
	// file at each method call, plus recalculating all of the
	// signatures over again.
	/**
	 * Finds words inside the dictionary (/usr/share/dict/words) that has the same signature as the argument signature.
	 * 
	 * @param signature Argument string representing a signature
	 * @return Set of strings containing words from the dictionary that has the same signature as the argument string
	 */
	public static Set<String> signatureToWords (String signature) {
		Set<String> words = new TreeSet<String>();
		File f = null;
		BufferedReader b = null;
		
		try {
			f = new File("/usr/share/dict/words");
			b = new BufferedReader(new FileReader(f));
			
			String line;
			while ((line = b.readLine()) != null) {
				if (isValidWord(line)
				 && wordToSignature(line).equals(signature)
				 && ! words.contains(line.toLowerCase())) {
					
					words.add(line.toLowerCase());
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				b.close();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (NullPointerException e) {
				e.printStackTrace();
			}
		}
		
		return words;
	}
	
}