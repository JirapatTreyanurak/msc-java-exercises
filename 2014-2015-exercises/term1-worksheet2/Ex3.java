/** Worksheet 2 Exercise 3
 * 
 * This class contains a static method that
 * implements Eratosthenes seive and returns
 * a boolean array for the result.
 * 
 * @author Jirapat Treyanurak (jxt163 1214663 MSc Computer Science)
 * @version 2014-10-16
 */
public class Ex3 {
	
	/**
	 * Determines which integers from 0 to n
	 * are primes using the Eratosthenes seive.
	 * 
	 * This is done by going through each number 
	 * from 2 to root of n and deleting their
	 * multiple from the list of prime.
	 * In this method, this is done by flipping
	 * the boolean value corresponding to the 
	 * number to false.
	 * 
	 * @param n The integer that we want to check up to for any primes.
	 * @return Array of boolean values for each integer from 0 to n stating whether it's prime or not.
	 */
	public static boolean[] sieve (int n) {
		boolean[] prime = new boolean[n];
		
		prime[0] = false;
		prime[1] = false;
		for (int i = 2; i < n; i++) {
			prime[i] = true; //candidate prime
		}
		
		for (int i = 2; i < (int)(Math.sqrt(n)+1); i++) {
			if (prime[i]) {
				for (int j = i+1; j < n; j++) {
					if (j%i == 0) {
						prime[j] = false;
					}
				}
			}
		}
		
		return prime;
	}
	
}
