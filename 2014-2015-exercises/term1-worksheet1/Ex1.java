/** Worksheet 1 Exercise 1
 * 
 * Calculates the area of a circle with given radius using:
 * <pre>
 * area = pi * r^2
 * </pre>
 *
 *  @author Jirapat Treyanurak (1214663 MSc Computer Science)
 *  @version 2014-10-05
 */
public class Ex1 {
	
	/**
	 * Calculates the area of a circle.
	 *
	 *  @param radius Radius of the circle. This should be non-negative.
	 *  @return Area of the circle.
	 */
	public static double circleArea (double radius) {
		return Math.PI * radius * radius;
	}
	
	/**
	 * Describe the output of the circleArea	
	 * method for testing purposes.
	 *
	 *  @param radius Radius of the circle. This should be non-negative.
	 *  @return String describing the output of circleArea method.
	 */
	public static String circleAreaToString (double radius) {
		return
			"A circle of radius "
			+ radius
			+ " has area "
			+ circleArea(radius)
			+ ".";
	}
	
	public static void main (String[] args) {
		// Tests
		System.out.println(circleAreaToString(0));
		System.out.println(circleAreaToString(1));
		System.out.println(circleAreaToString(2));
		System.out.println(circleAreaToString(3));
		System.out.println(circleAreaToString(4.4));
		System.out.println(circleAreaToString(5));
	}
	
}
