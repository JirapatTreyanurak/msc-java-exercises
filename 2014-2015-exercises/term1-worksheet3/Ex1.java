/** Worksheet 3 Exercise 1
 * 
 * This class contains a static method that
 * calculates the average of an array of
 * interger.
 * 
 * 
 * @author Jirapat Treyanurak (jxt163 1214663 MSc Computer Science)
 * @version 2014-11-12
 */
public class Ex1 {
	
	/**
	 * Calculates the average using numbers
	 * from the input array of integers.
	 * Sorely for test compliance, we define 
	 * the average of an empty set to be 0.
	 * 
	 * @param a Integer array that we will take the average from.
	 * @return The average of the numbers in the input array.
	 */
/*	public static double averagettt (int[] a) {
		int sum = 0;
		
		if (a.length == 0) {
			return 0;
		}
		
		for (int i = 0; i < a.length; i++) {
			sum += a[i];
		}

		return ((double) sum) / a.length;
	}*/
	
	/**
	 * Helper method for average (int[] a)
	 * using extra parameters that will always 
	 * start with a particular number each time
	 * we call average anew.
	 * 
	 * @param a Integer array that we will take the average from.
	 * @param sum The running total of each of the elements.
	 * @param i The index that we will increase each time we call the method recursively.
	 * @return Average of the elements in a.
	 */
	public static double average (int[] a, int sum, int i) {
		if (a.length == 0) {
			return 0;
		}
		if (i == a.length) {
			return ((double)sum) / a.length;
		}
		return average(a, sum + a[i], i+1);
	}
	
	/**
	 * Calculates the average using numbers
	 * from the input array of integers.
	 * Sorely for test compliance, we define 
	 * the average of an empty set to be 0.
	 * 
	 * @param a Integer array that we will take the average from.
	 * @return The average of the numbers in the input array.
	 */
	public static double average (int[] a) {
		return average(a, 0, 0);
	}
	
}
