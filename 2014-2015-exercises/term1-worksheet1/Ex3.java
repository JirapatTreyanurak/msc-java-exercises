/** Worksheet 1 Exercise 3
 * 
 * Calculates the final amount of money when:
 * - capitalSum pounds have been invested
 * - With a fixed interest interestRate
 * - For the duration of years years.
 *
 * Using:
 * <pre>
 * capitalSum * (1 + 0.01*interestRate)^years
 * </pre>
 *
 *  @author Jirapat Treyanurak (1214663 MSc Computer Science)
 *  @version 2014-10-05
 */
public class Ex3 {
	
	/**
	 * Calculates interest-added capital sum.
	 *
	 *  @param capitalSum The amount of pounds invested. This should be non-negative.
	 *  @param interestRate The interest rate. This should be non-negative.
	 *  @param years The duration in years. This should be non-negative.
	 *  @return The interest-added capital sum after the specified duration.
	 */
	public static double interestAddedCapitalSum (double capitalSum, double interestRate, int years) {
		return capitalSum * Math.pow(1 + (0.01*interestRate), years);
	}
	
	/**
	 * Describe the output of interestAddedCapitalSum
	 * method for testing purposes.
	 *
	 *  @param capitalSum The amount of pounds invested. This should be non-negative.
	 *  @param interestRate The interest rate. This should be non-negative.
	 *  @param years The duration in years. This should be non-negative.
	 *  @return String describing the output of interestAddedCapitalSum method.
	 */
	public static String interestAddedCapitalSumToString (double capitalSum, double interestRate, int years) {
		return
			"£"
			+ capitalSum
			+ " capital sum with a fixed interest rate of "
			+ interestRate
			+ " over "
			+ years
			+ " years will result in interest-added capital of £"
			+ interestAddedCapitalSum(capitalSum, interestRate, years)
			+ ".";
	}
	
	public static void main (String[] args) {
		//Tests
		System.out.println(interestAddedCapitalSumToString(0, 0.01, 1));
		System.out.println(interestAddedCapitalSumToString(100, 0.01, 5));
		System.out.println(interestAddedCapitalSumToString(100, 0.05, 5));
		System.out.println(interestAddedCapitalSumToString(20000, 0.01, 2));
		System.out.println(interestAddedCapitalSumToString(20000, 0.02, 5));
		System.out.println(interestAddedCapitalSumToString(8200000, 0.05, 10));
	}
}
