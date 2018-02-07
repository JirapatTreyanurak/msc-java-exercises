/** Worksheet 1 Exercise 2
 *
 * Converts from different units to kilograms using:
 * <pre>
 * 1 ton            2240 pounds
 * 1 hundredweight  112 pounds
 * 1 quarter        28 pounds
 * 1 stone          14 pounds
 * 1 ounce          1/16 pounds
 * 1 drachm         1/256 pounds
 * 1 grain          1/7000 pounds
 * 1 pound          0.45359237 kilograms
 * </pre>
 * 
 * Since most of the table converts the unit to pounds
 * and we only have a conversion to kilograms from pounds,
 * we will convert these units to kilogram via pounds.
 *
 *  @author Jirapat Treyanurak (1214663 MSc Computer Science)
 *  @version 2014-10-05
 */
public class Ex2 {
	
	/**
	 * Converts tons to kilograms.
	 *
	 *  @param ton Amount in tons. This should be non-negative.
	 *  @return Amount in kilograms.
	 */
	public static double ton2Kilogram (double ton) {
		return pound2Kilogram(ton*2240);
	}
	
	/**
	 * Describe the output of ton2Kilogram
	 * method for testing purposes.
	 * 
	 *  @param ton Amount in tons. This should be non-negative.
	 *  @return String describing the output of ton2Kilogram method.
	 */
	public static String ton2KilogramToString (double ton) {
		return 
			ton
			+ " tons is equal to "
			+ ton2Kilogram(ton)
			+ " kilograms.";
	}
	
	/**
	 * Converts hundredweights to kilograms.
	 *
	 *  @param hundredweight Amount in hundredweights. This should be non-negative.
	 *  @return Amounts in kilograms.
	 */
	public static double hundredweight2Kilogram (double hundredweight) {
		return pound2Kilogram(hundredweight*112);
	}
	
	/**
	 * Describe the output of hundredweight2Kilogram
	 * method for testing purposes.
	 * 
	 *  @param hundredweight Amount in hundredweights. This should be non-negative.
	 *  @return String describing the output of hundredweight2Kilogram method.
	 */
	public static String hundredweight2KilogramToString (double hundredweight) {
		return 
			hundredweight
			+ " hundredweights is equal to "
			+ hundredweight2Kilogram(hundredweight)
			+ " kilograms.";
	}
	
	/**
	 * Converts quarters to kilograms.
	 *
	 *  @param quarter Amount in quarters. This should be non-negative.
	 *  @return Amount in kilograms.
	 */
	public static double quarter2Kilogram (double quarter) {
		return pound2Kilogram(quarter*28);
	}
	
	/**
	 * Describe the output of quarter2Kilogram
	 * method for testing purposes.
	 * 
	 *  @param quarter Amount in quarters. This should be non-negative.
	 *  @return String describing the output of quarter2Kilogram method.
	 */
	public static String quarter2KilogramToString (double quarter) {
		return 
			quarter
			+ " quarters is equal to "
			+ quarter2Kilogram(quarter)
			+ " kilograms.";
	}
	
	/**
	 * Converts stones to kilograms.
	 *
	 *  @param stone Amount in stones. This should be non-negative.
	 *  @return Amount in kilograms.
	 */
	public static double stone2Kilogram (double stone) {
		return pound2Kilogram(stone*14);
	}
	
	/**
	 * Describe the output of stone2Kilogram
	 * method for testing purposes.
	 * 
	 *  @param stone Amount in stones. This should be non-negative.
	 *  @return String describing the output of stone2Kilogram method.
	 */
	public static String stone2KilogramToString (double stone) {
		return 
			stone
			+ " stones is equal to "
			+ stone2Kilogram(stone)
			+ " kilograms.";
	}
	
	/**
	 * Converts ounces to kilograms.
	 *
	 *  @param ounce Amount in ounces. This should be non-negative.
	 *  @return Amount in kilograms.
	 */
	public static double ounce2Kilogram (double ounce) {
		return pound2Kilogram(ounce/16);
	}
	
	/**
	 * Describe the output of ounce2Kilogram
	 * method for testing purposes.
	 * 
	 *  @param ounce Amount in ounces. This should be non-negative.
	 *  @return String describing the output of ounce2Kilogram method.
	 */
	public static String ounce2KilogramToString (double ounce) {
		return 
			ounce
			+ " ounces is equal to "
			+ ounce2Kilogram(ounce)
			+ " kilograms.";
	}
	
	/**
	 * Converts drachms to kilograms.
	 *
	 *  @param drachm Amount in drachms. This should be non-negative.
	 *  @return Amount in kilograms.
	 */
	public static double drachm2Kilogram (double drachm) {
		return pound2Kilogram(drachm/256);
	}
	
	/**
	 * Describe the output of drachm2Kilogram
	 * method for testing purposes.
	 *
	 *  @param drachm Amount in drachms. This should be non-negative.
	 *  @return String describing the output of drachm2Kilogram method.
	 */
	public static String drachm2KilogramToString (double drachm) {
		return 
			drachm
			+ " drachms is equal to "
			+ drachm2Kilogram(drachm)
			+ " kilograms.";
	}
	
	/**
	 * Converts grains to kilograms.
	 *
	 *  @param grain Amount in grains. This should be non-negative.
	 *  @return Amount in kilograms.
	 */
	public static double grain2Kilogram (double grain) {
		return pound2Kilogram(grain/7000);
	}
	
	/**
	 * Describe the output of grain2Kilogram
	 * method for testing purposes.
	 *
	 *  @param grain Amount in grains. This should be non-negative.
	 *  @return String describing the output of grain2Kilogram method.
	 */
	public static String grain2KilogramToString (double grain) {
		return 
			grain
			+ " grains is equal to "
			+ grain2Kilogram(grain)
			+ " kilograms.";
	}
	
	/**
	 * Converts pounds to kilograms.
	 *
	 *  @param pound Amount in pounds. This should be non-negative.
	 *  @return Amount in kilograms.
	 */
	public static double pound2Kilogram (double pound) {
		return pound * 0.45359237;
	}
	
	/**
	 * Describe the output of pound2Kilogram
	 * method for testing purposes.
	 * 
	 *  @param pound Amount in pounds. This should be non-negative.
	 *  @return String describing the output of pound2Kilogram method.
	 */
	public static String pound2KilogramToString (double pound) {
		return 
			pound
			+ " pounds is equal to "
			+ pound2Kilogram(pound)
			+ " kilograms.";
	}
	
	/**
	 * Converts a person's weight in stones and pounds
	 * to kilograms, "rounded to the next integer value".
	 *
	 *  @param stones Part of the weight in stones. This should be non-negative.
	 *  @param pounds Part of the weight in pounds. This should be non-negative.
	 *  @return Weight in kilograms.
	 */
	public static int imperial2Metric (int stones, int pounds) {
		return (int) Math.ceil(stone2Kilogram(stones) + pound2Kilogram(pounds));
		//If we shouldn't use Math.ceil yet, then read:
		//(int) Math.round( .. + 0.5);
	}
	
	/**
	 * Describe the output of imperial2Metric
	 * method for testing purposes.
	 *
	 *  @param stones Part of the weight in stones. This should be non-negative.
	 *  @param pounds Part of the weight in pounds. This should be non-negative.
	 *  @return String describing the output of imperial2Metric method.
	 */
	public static String imperial2MetricToString (int stones, int pounds) {
		return 
			"The weight of "
			+ stones
			+ " stones and "
			+ pounds
			+ " pounds is approximately "
			+ imperial2Metric(stones, pounds)
			+ " kilograms.";
	}
	
	public static void main (String[] args) {
		//Tests
		System.out.println();
		System.out.println("   Part a)");
		System.out.println();
		System.out.println(ton2KilogramToString(0));
		System.out.println(ton2KilogramToString(1));
		System.out.println(ton2KilogramToString(2.5));
		System.out.println();
		System.out.println(hundredweight2KilogramToString(0));
		System.out.println(hundredweight2KilogramToString(1));
		System.out.println(hundredweight2KilogramToString(2.5));
		System.out.println();
		System.out.println(quarter2KilogramToString(0));
		System.out.println(quarter2KilogramToString(1));
		System.out.println(quarter2KilogramToString(2.5));
		System.out.println();
		System.out.println(stone2KilogramToString(0));
		System.out.println(stone2KilogramToString(1));
		System.out.println(stone2KilogramToString(2.5));
		System.out.println();
		System.out.println(ounce2KilogramToString(0));
		System.out.println(ounce2KilogramToString(1));
		System.out.println(ounce2KilogramToString(2.5));
		System.out.println();
		System.out.println(drachm2KilogramToString(0));
		System.out.println(drachm2KilogramToString(1));
		System.out.println(drachm2KilogramToString(2.5));
		System.out.println();
		System.out.println(grain2KilogramToString(0));
		System.out.println(grain2KilogramToString(1));
		System.out.println(grain2KilogramToString(2.5));
		System.out.println();
		System.out.println(pound2KilogramToString(0));
		System.out.println(pound2KilogramToString(1));
		System.out.println(pound2KilogramToString(2.5));
		System.out.println();
		System.out.println("   Part b)");
		System.out.println();
		System.out.println(imperial2MetricToString(0, 0));
		System.out.println(imperial2MetricToString(1, 0));
		System.out.println(imperial2MetricToString(1, 5));
		System.out.println(imperial2MetricToString(1, 8));
		System.out.println(imperial2MetricToString(5, 0));
		System.out.println(imperial2MetricToString(5, 5));
		System.out.println(imperial2MetricToString(5, 8));
	}
	
}
