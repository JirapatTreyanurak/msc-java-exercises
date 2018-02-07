/** Worksheet 1 Exercise 4
 * 
 * Calculates the numerator and denominator of 
 * the sum and product of 2 fractions.
 * 
 * The 2 fractions are written:
 * n1/d1 and n2/d2
 *
 *  @author Jirapat Treyanurak (1214663 MSc Computer Science)
 *  @version 2014-10-05
 */
public class Ex4 {
	
	/**
	 * Calculates the numerator of the sum, ns.
	 *
	 * This is done by adding the 2 fractions
	 * after the appropriate multiplication to 
	 * obtain a common denominator:
	 * <pre>
	 * ns = (n1*d2) + (n2*d1)
	 * </pre>
	 * 
	 *  @param n1 Numerator of the first fraction.
	 *  @param d1 Denominator of the first fraction. This should be strictly positive.
	 *  @param n2 Numerator of the second fraction.
	 *  @param d2 Denominator of the second fraction. This should be strictly positive.
	 *  @return Numerator of the sum.
	 */
	public static int ns (int n1, int d1, int n2, int d2) {
		return (n1*d2) + (n2*d1);
	}
	
	/**
	 * Calculates the denominator of the sum, ds.
	 *
	 * This is done by multiplying the denominator
	 * of the 2 fractions, obtaining the common
	 * denominator for the sum:
	 * <pre>
	 * ds = d1*d2
	 * </pre>
	 * 
	 *  @param d1 Denominator of the first fraction. This should be strictly positive.
	 *  @param d2 Denominator of the second fraction. This should be strictly positive.
	 *  @return Denominator of the sum.
	 */
	public static int ds (int d1, int d2) {
		return d1*d2;
	}
	
	/**
	 * Describe the sum of 2 fractions
	 * using the method ns and ds.
	 *
	 *  @param n1 Numerator of the first fraction.
	 *  @param d1 Denominator of the first fraction. This should be strictly positive.
	 *  @param n2 Numerator of the second fraction.
	 *  @param d2 Denominator of the second fraction. This should be strictly positive.
	 *  @return String describing the sum of the 2 fractions.
	 */
	public static String sumToString (int n1, int d1, int n2, int d2) {
		return
			n1 + "/" + d1
			+ " + " +
			n2 + "/" + d2
			+ " = " 
			+ ns(n1, d1, n2, d2) + "/" + ds(d1, d2);
	}
	
	/**
	 * Calculates the numerator of the product, np.
	 *
	 * This is done by multiplying the numerator of
	 * the 2 fractions.
	 * <pre>
	 * np = n1*n2
	 * </pre>
	 *
	 *  @param n1 Numerator of the first fraction.
	 *  @param n2 Numerator of the second fraction.
	 *  @return Numerator of the product.
	 */
	public static int np (int n1, int n2) {
		return n1*n2;
	}
	
	/**
	 * Calculates the denominator of the product, dp.
	 * 
	 * This is done by multiplying the denominator 
	 * of the 2 fractions.
	 * <pre>
	 * dp = d1*d2
	 * </pre>
	 * 
	 *  @param d1 Denominator of the first fraction. This should be strictly positive.
	 *  @param d2 Denominator of the second fraction. This should be strictly positive.
	 *  @return Denominator of the product.
	 */
	public static int dp (int d1, int d2) {
		return d1*d2;
	}
	
	/**
	 * Describe the product of 2 fractions
	 * using the method np and dp.
	 *
	 *  @param n1 Numerator of the first fraction.
	 *  @param d1 Denominator of the first fraction. This should be strictly positive.
	 *  @param n2 Numerator of the second fraction.
	 *  @param d2 Denominator of the second fraction. This should be strictly positive.
	 *  @return String describing the product of the 2 fractions.
	 */
	public static String productToString (int n1, int d1, int n2, int d2) {
		return
			n1 + "/" + d1
			+ " x " +
			n2 + "/" + d2
			+ " = " 
			+ np(n1, n2) + "/" + dp(d1, d2);
	}
	
	public static void main (String[] args) {
		//Tests
		System.out.println();
		System.out.println("  Sums:");
		System.out.println();
		System.out.println(sumToString(1, 1, 1, 1));
		System.out.println(sumToString(1, 2, 1, 3));
		System.out.println(sumToString(5, 2, 8, 3));
		System.out.println(sumToString(11, 17, 9, 31));
		System.out.println();
		System.out.println("  Products:");
		System.out.println();
		System.out.println(productToString(1, 1, 1, 1));
		System.out.println(productToString(1, 2, 1, 3));
		System.out.println(productToString(5, 2, 8, 3));
		System.out.println(productToString(11, 17, 9, 31));
		System.out.println();
	}
	
}
