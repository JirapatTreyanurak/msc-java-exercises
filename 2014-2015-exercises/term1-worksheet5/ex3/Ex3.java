package ex3;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

/** Worksheet 5 Exercise 3
 * 
 * This Ex3 class contains a method to count the
 * frequencies of a set of characters from a given
 * link. It also contains a method to print an array
 * of frequencies into a String.
 * 
 * @author Jirapat Treyanurak (jxt163 1214663 MSc Computer Science)
 * @version 2014-12-10
 */
public class Ex3 {
	
	/**
	 * This method takes a link and count the frequencies of each alphabet
	 * a-z (uppercase will be converted to lowercase and counted as well).
	 * It also counts the SPACE, FULLSTOP, and LINEFEED.
	 * In utf-8, these are 97-122 for a-z, 32 for SPACE, 46 for FULLSTOP,
	 * and 10 for LINEFEED.
	 * 
	 * @param link The link we want to count the character frequency.
	 * @return Array of frequencies.
	 */
	public static long[] frequencyAnalysis (String link) {
		long[] frequencyList = new long[29];
		BufferedReader br = null;
		
		try {
			URL url = new URL(link);
			InputStreamReader stream = new InputStreamReader(url.openStream());
			br = new BufferedReader(stream);
			
			int i;
			char c;
			while ((i = br.read()) != -1) {
				c = (char) Character.toLowerCase(i);
				//System.out.println(character + "\t" + c + "\t" + (character - 'a'));
				if (c >= 'a' && c <= 'z') {
					// - 'a' offsets the encoding to fit our array indices
					frequencyList[c - 'a']++;
				}
				if (c == 32) { //SPACE
					frequencyList[26]++;
				}
				if (c == 46) { //PERIOD
					frequencyList[27]++;
				}
				if (c == 10) { //NEWLINE (line feed)
					frequencyList[28]++;
				}
			}
		}
		catch (FileNotFoundException e) {
			System.out.println(e);
		}
		catch (IOException e) {
			System.out.println(e);
		}
		finally {
			try {
				br.close();
			}
			catch (IOException e) {
				System.out.println(e);
			}
			catch (NullPointerException e) {
				System.out.println(e);
			}
		}
		
		return frequencyList;
	}
	
	/**
	 * Converts the frequencies inside the array of long
	 * into a String in a readable format.
	 * 
	 * @param frequencyList Array of frequencies.
	 * @return String listing all the frequencies in the array.
	 */
	public static String frequencyToString (long[] frequencyList) {
		String s = "{";
		for (int i = 0; i < 26; i++) {
			s += frequencyList[i] + ",";
		}
		s += String.format("%d,%d,%d}", frequencyList[26], frequencyList[27], frequencyList[28]);
		
		return s;
	}
	
}