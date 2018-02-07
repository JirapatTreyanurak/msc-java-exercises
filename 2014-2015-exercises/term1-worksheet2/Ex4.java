/** Worksheet 2 Exercise 4
 * 
 * This class contains a static method that
 * implements a bubble sort to an array of
 * strings.
 * 
 * @author Jirapat Treyanurak (jxt163 1214663 MSc Computer Science)
 * @version 2014-10-13
 */
public class Ex4 {
	
	/**
	 * Implements bubble sort on an array
	 * of strings.
	 * This takes an array of strings as an
	 * input and outputs a new sorted array.
	 * 
	 * Bubble sort goes through the list and 
	 * make a swap whenever we encounter an 
	 * element that has a longer length than
	 * the consecutive element in the array.
	 * Note in this implementation, we do not
	 * swap consecutive strings of the same
	 * length. Thus their relative order are
	 * preserved.
	 * 
	 * We stop as soon as we are able to go 
	 * through the array from the first 
	 * element to the last element without 
	 * swapping anything.
	 * This is correct since not swapping 
	 * from start to finish means there's
	 * no elements whose next element has
	 * smaller length.
	 * 
	 * @param list An array of strings to be sorted.
	 * @return A new array of sorted input list ordered by string length.
	 */
	public static String[] bubbleSort (String[] list) {
		String temp;
		String[] result = new String[list.length];
		
		for (int i = 0; i< result.length; i++) {
			result[i] = list[i];
		}
		
		for (boolean swap = true; swap; ) {
			swap = false;
			for (int j = 0; j < result.length-1; j++) {
				if (result[j].length() > result[j+1].length()) {
					swap = true;
					temp = result[j];
					result[j] = result[j+1];
					result[j+1] = temp;
				}
			}
		}
		
		return result;
	}
	
}
