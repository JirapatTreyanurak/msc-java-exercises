/** Worksheet 2 Exercise 2
 * 
 * This class contains a static method that
 * counts the occurences of a string in an
 * array.
 * 
 * @author Jirapat Treyanurak (jxt163 1214663 MSc Computer Science)
 * @version 2014-10-13
 */
public class Ex2 {
	
	/**
	 * Counts the number of time the input
	 * parameter match occurs in the input
	 * array sample.
	 * 
	 * @param match The string we are trying to count the occurences of.
	 * @param sample The array where we find the occurences.
	 * @return The number of times match appears in sample.
	 */
	public static int countOccurences (String match, String[] sample) {
		int count = 0;
		
		for (int i = 0; i < sample.length; i++) {
			if (sample[i].equals(match)) {
				count++;
			}
		}
		
		return count;
	}
	
}
