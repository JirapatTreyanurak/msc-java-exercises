/** Worksheet 3 Exercise 2
 * 
 * This class contains static methods that
 * computes x^i, n!, and e^x, using both
 * iterative methods and recursive methods.
 * 
 * @author Jirapat Treyanurak (jxt163 1214663 MSc Computer Science)
 * @version 2014-11-03
 */
public class Ex2 {
	
	
	/* ******************* *
	 *  Iterative Methods  *
	 * ******************* */
	/**
	 * Calculates x to the power of i using
	 * iterations and not Math.pow.
	 * 
	 * @param x A double that we will take the power from.
	 * @param i The integer exponent that we will take the power of.
	 * @return x to the power of i.
	 */
	public static double powerIter (double x, int i) {
		int result = 1;
		
		for (int count = 0; count < i; count++) {
			result *= x;
		}
		
		return result;
	}
	/**
	 * Calculates n! (n factorial) using
	 * iterations.
	 * 
	 * @param n An integer that we will take the factorial of.
	 * @return n!
	 */
	public static int factorialIter (int n) {
		int result = 1;
		
		if ( n == 0 ) {
			return result;
		}
		
		for (int i = 1; i <= n; i++) {
			result *= i;
		}
		
		return result;
	}
	/**
	 * Calculates the infinite sum x^i / i!
	 * from i = 0 utilising the powerIter and
	 * factorialIter methods and using iterations.
	 * We stop the summation at the _first_ summand
	 * that falls strictly below the threshold.
	 * 
	 * @param x The exponent of e.
	 * @param threshold The point beyond which we stop the summation.
	 * @return e to the x, approximated based on the threshold.
	 */
	public static double expIter (double x, double threshold) {
		double result = 0;
		int i = 0;
		double summand = powerIter(x, i)/factorialIter(i);
		
		while ( summand >= threshold) {
			result += summand;
			i++;
			summand = powerIter(x, i)/factorialIter(i);
		}
		
		//the first summand that is strictly below the threshold
		result += summand;
		
		return result;
	}
	
	
	/* ******************* *
	 *  Recursive Methods  *
	 * ******************* */
	/**
	 * Calculates x to the power of i using
	 * recursions and not Math.pow.
	 * 
	 * @param x A double that we will take the power from.
	 * @param i The integer exponent that we will take the power of.
	 * @return x to the power of i.
	 */
	public static double powerRec (double x, int i) {
		if (i == 0) {
			return 1;
		}
		return x*powerRec(x, i-1);
	}
	/**
	 * Calculates n! (n factorial) using
	 * recursions.
	 * 
	 * @param n An integer that we will take the factorial of.
	 * @return n!
	 */
	public static int factorialRec (int n) {
		if (n == 0) {
			return 1;
		}
		return n * factorialRec(n-1);
	}
	/**
	 * Helper method for expRec (double x, double threshold).
	 * Calculates the infinite sum x^i / i!
	 * from i = 0 utilising the powerRec and
	 * factorialRec methods and using recursions.
	 * We stop the summation at the _first_ summand
	 * that falls strictly below the threshold.
	 * 
	 * To make the recursion work, we need to keep track of
	 * i and this i will also be used as a "reduction" 
	 * (in quote because in this case, we increase it).
	 * 
	 * @param x The exponent of e.
	 * @param threshold The point beyond which we stop the summation.
	 * @param i Always called with 0
	 * @return e to the x, approximated based on the threshold.
	 */
	public static double expRec (double x, double threshold, int i) {
		double summand = powerRec(x, i)/factorialIter(i);
		if (summand < threshold) {
			//the first summand that is strictly below the threshold
			return summand;
		}
		return summand + expRec(x, threshold, i+1);
	}
	/**
	 * Calculates the infinite sum x^i / i!
	 * from i = 0 utilising the powerRec and
	 * factorialRec methods and using recursions.
	 * We stop the summation at the _first_ summand
	 * that falls strictly below the threshold.
	 * 
	 * @param x The exponent of e.
	 * @param threshold The point beyond which we stop the summation.
	 * @return e to the x, approximated based on the threshold.
	 */
	public static double expRec (double x, double threshold) {
		/*
		 * We use a helper method that has an extra parameter
		 * for keeping track of the summation index
		 */
		return expRec(x, threshold, 0);
	}
	
}
