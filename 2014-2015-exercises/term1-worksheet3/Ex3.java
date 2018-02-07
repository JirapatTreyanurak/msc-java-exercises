/** Worksheet 3 Exercise 3
 * 
 * This class contains static methods that
 * sums up each of the digits of an integer,
 * using both iterative and recursive methods.
 * 
 * @author Jirapat Treyanurak (jxt163 1214663 MSc Computer Science)
 * @version 2014-11-03
 */
public class Ex3 {
	
	
	/* ****************** *
	 *  Iterative Method  *
	 * ****************** */
	/**
	 * Calculate the sum of each digit of a
	 * number using iterations.
	 * 
	 * @param n The number we are summing the digit of.
	 * @return The sum of the digits of the input n.
	 */
	public static int digitTotalIter (int n) {
		int number = n;
		int result = 0;
		
		//if the last digit is 0, then we'd be adding 0 anyway
		while (number > 0) {
			result += number%10;
			number /= 10;
		}
		
		return result;
	}
	
	
	/* ****************** *
	 *  Recursive Method  *
	 * ****************** */
	/**
	 * Calculate the sum of each digit of a
	 * number using recursions.
	 * 
	 * @param n The number we are summing the digit of.
	 * @return The sum of the digits of the input n.
	 */
	public static int digitTotalRec (int n) {
		//Base case is when we only have 1 digit left
		if (n < 10) {
			return n;
		}
		return (n%10) + digitTotalRec(n/10);
	}
	
	
}
