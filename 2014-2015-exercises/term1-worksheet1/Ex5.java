/** Worksheet 1 Exercise 5
 *
 * Calculates the angle from the hour hand to
 * the minute hand, counter-clockwise.
 * 
 * The time is given by 2 parameters:
 *  - hours
 *  - minutes
 *
 * Results are expressed in degree, rounded and
 * normalised to the range [0, 359].
 * 
 *  @author Jirapat Treyanurak (1214663 MSc Computer Science)
 *  @version 2014-10-05
 */
public class Ex5 {
	
	/**
	 * Calculates the angle from the hour hand
	 * to the minute hand, counter-clockwise,
	 * rounded to nearest degree, and normalised
	 * to [0,359].
	 * 
	 *
	 *    Calculation:
	 * Let us calculate the angle of each of the
	 * hands first, with 12 o'clock being 0 degree.
	 *
	 * The minute hand moves at a constant rate 
	 * of 360 degrees over 60 minutes, hence a 
	 * minute is equal to 360/60 = 6 degrees.
	 * Hence for minute m, the angle of its 
	 * hand, Am, is 6m.
	 *
	 * For the hour hand, let us first wrap the
	 * hours from 0 to 24 around the 12 hours 
	 * on the clock:
	 * For hour h, let h' = h%12.
	 * Now we work with h'.
	 * At minute m = 0, each of the "12" hours
	 * are uniformly spread across 360 degrees.
	 * So an hour is equal to 360/12 = 30 
	 * degrees.
	 * Hence for hour h', the angle of its hand
	 * at minute m = 0 is 30h'.
	 * 
	 * But the hour hand should move slightly as
	 * the minute progresses. From minute m = 0
	 * where the hand would point to angle 
	 * corresponding to h' hour, to m = 60 where
	 * the hand would point to the angle
	 * corresponding to h'+1 hour.
	 * Since an hour is 30 degrees, and we must
	 * evenly spread 60 minutes along them, we
	 * get that the hour hand will move 30/60 =
	 * 1/2 degrees for every minute.
	 * Hence for hour h', minute m, the angle of
	 * the hour hand, Ah, is thus 30h' + 0.5m.
	 * 
	 * To calculate the angle we want, we start 
	 * with the angle of the hour hand Ah. This
	 * describes the angle going from the hour
	 * hand back, counter-clockwise, to the 12
	 * o'clock. We consider 2 cases:
	 *   First, if the minute hand is between
	 * the hour hand and 12 o'clock going
	 * counter-clockwise, then we would be 
	 * counting too much angle, and the difference
	 * we want can simply be obtained by
	 * subtracting the angle of the minute hand
	 * from what we have. This gives us Ah - Am.
	 *   In the second case, where the minute
	 * hand is between the hour hand and 12
	 * o'clock going clockwise, then we need to
	 * count a bit more angle. But this angle
	 * is precisely 360 - Am (draw a picture).
	 * This gives us Ah - Am + 360. But we can
	 * still use the same formula as in the 
	 * first case since we'll be taking the
	 * angle modulo 360 anyway (Ah - Am will
	 * simply return a negative number in the
	 * second case without the + 360 which will
	 * be fixed with modulo 360).
	 * This can be simplified as follows:
	 * <pre>
	 * Ah - Am = 30h' + 0.5m - 6m
	 *         = 30h' - 5.5m
	 * </pre>
	 *
	 * The final result is then rounded to 
	 * nearest integer and normalised to [0,359]
	 * by taking the appropriate modulus.
	 *
	 *  @param hours The amount of hours from 0 to 24.
	 *  @param minutes The amount of minutes from 0 to 60.
	 *  @return Angle between hands from 0 to 359.
	 */
	public static int angleBetweenHands (int hours, int minutes) {
		return ((int) Math.round((30*(hours%12)) - (5.5*minutes) + 360))%360;
		/*
		 * The modulus of negative number here doesn't return a
		 * positive number,
		 * we overcome this by shifting everything up 360 degree
		 * and taking the module 360 of the result.
		 */
	}
	
	/**
	 * Describes the output of angleBetweenHands
	 * method for testing purposes.
	 *
	 *  @param hours The amount of hours from 0 to 24.
	 *  @param minutes The amount of minutes from 0 to 60.
	 *  @return String describing the output of angleBetweenHands method.
	 */
	public static String angleBetweenHandsToString (int hours, int minutes) {
		return
			"At " + hours + ":" + minutes
			+ " the angle is "
			+ angleBetweenHands(hours, minutes)
			+ " degrees.";
	}
	
	public static void main (String[] args) {
		//Testsc
		System.out.println();
		System.out.println(angleBetweenHandsToString(9, 0));
		System.out.println("The answer should be 270 degrees.");
		System.out.println();
		System.out.println(angleBetweenHandsToString(3, 0));
		System.out.println("The answer should be 90 degrees.");
		System.out.println();
		System.out.println(angleBetweenHandsToString(18, 0));
		System.out.println("The answer should be 180 degrees.");
		System.out.println();
		System.out.println(angleBetweenHandsToString(1, 0));
		System.out.println("The answer should be 30 degrees.");
		System.out.println();
		System.out.println(angleBetweenHandsToString(2, 30));
		System.out.println("The answer should be 255 degrees.");
		System.out.println();
		System.out.println(angleBetweenHandsToString(4, 41));
		System.out.println("The answer should be 254 degrees.");
		System.out.println();
	}
	
}
