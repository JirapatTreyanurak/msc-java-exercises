/** Worksheet 3 Exercise 5
 * 
 * This class contains static methods that
 * set-ups, solves, and display the steps 
 * of the tower of hanoi.
 * For details of the tower of hanoi, see
 * http://en.wikipedia.org/wiki/Tower_of_Hanoi
 * 
 * @author Jirapat Treyanurak (jxt163 1214663 MSc Computer Science)
 * @version 2014-11-03
 */
public class Ex5 {
	
	private static String trace = "";
	
	/**
	 * Returns an integer array where all disks
	 * are initialised to position 1.
	 * 
	 * @param size Integer n, the number of disks
	 * @return Integer array of size n where each of the elements is 1
	 */
	public static int[] init (int size) {
		int[] hanoi = new int[size];
		
		for (int i = 0; i < size; i++) {
			hanoi[i] = 1;
		}
		
		return hanoi;
	}
	
	/**
	 * Returns the index corresponding to the disk
	 * at the top of a position.
	 * To find this out, we note:
	 *  1. Game array order the disk from left to right
	 *     in increasing size.
	 *  2. The disk at the top of any position is always
	 *     the smallest disk in that position.
	 * 
	 * Then it suffice to find the index
	 * of the first disk we find inside the array that is in 
	 * position pos, going from left (small disk) to right (big
	 * disk).
	 * 
	 * Here we note how these 2 points need not hold IF
	 * we allow illegal moves.
	 * Also if there's no disk in position pos, the method
	 * is set to return -1. If we play the game normally,
	 * we will never get to this situation.
	 * 
	 * @param game Integer array containing the position of each disks
	 * @param pos The position we want to get the top disk from
	 * @return The index of the game array corresponding to the disk at the top of position pos
	 */
	public static int topDiskAtPosition (int[] game, int pos) {
		for (int i = 0; i < game.length; i++) {
			if (game[i] == pos) {
				return i;
			}
		}
		//should never happen unless we manually do an illegal move
		return -1;
	}
	
	/**
	 * Converts the integer array describing the position
	 * of each of the disks to a string.
	 * 
	 * @param game Integer array describing the position of each disks
	 * @return String containing each of the position of each disks delimited by space, ending with "\n"
	 */
	public static String hanoiToString (int[] game) {
		String result = "";
		
		for (int i = 0; i < game.length; i++) {
			result += game[i];
			if (i != game.length-1) {
				result += " ";
			} else {
				result += "\n";
			}
		}
		
		return result;
	}
	
	/**
	 * Solves tower of hanoi recursively.
	 * 
	 * First we note that if i==j, we don't have to do anything.
	 * 
	 * We also note that if k==1, then we can just move the disk
	 * straight away (assuming it's a legal move). This is our 
	 * base case.
	 * To achieve this, we simply get the top disk at position i,
	 * and change its position to j.
	 * 
	 * Now in general, to get top k disks from i to j, we:
	 * 	1.	Get top k-1 disks to the "other" position 
	 * 		(i and j takes up 2 position so there's only
	 * 		1 option for "other" position).
	 * 	2.	Move the kth disk to j since everything above
	 * 		it is out of the way now.
	 * 	3.	Get the k-1 disks in the "other" position back
	 * 		on top of the kth disk on j.
	 * 
	 * To describe this using the same method call, we need
	 * only figure out how to obtain the "other" position
	 * when we are given position i and j.
	 * Note the positions are 1, 2, and 3 (unique) and they
	 * add up to 6. So the "other" position can be given
	 * by 6-i-j.
	 * 
	 * We note also that during the course of solving the game,
	 * we keep track of each of the moves by updating the trace
	 * string.
	 * 
	 * @param game Integer array describing the position of each disks
	 * @param i Position we want to move the disks from
	 * @param j Position we want to move the disks to
	 * @param k How many disks we want to move (counting from the top) from i to j
	 */
	public static void moveAll (int[] game, int i, int j, int k) {
		// Special case
		if (i == j) {
			return;
		}
		
		// Add starting position before the very first move
		/*
		 * Note this condition is incorrect in general as we may call this method like so:
		 * moveAll(init(5), 1, 2, 3) (result looks like trace(3), but with two extra 1s at 
		 * the end of each line for the 4th and 5th disks).
		 * 
		 * But for this exercise, we only call this method in trace(int n) which calls this
		 * method as follows:
		 * moveAll(init(n), 1, 3, n)
		 * Hence this condition is sufficient for our purposes.
		 * 
		 * It would be clumsy to detect the "first move" (or "last move") otherwise to cover all cases.
		 */
		if (k == game.length) {
			trace += hanoiToString(game);
		}
		
		// Base case
		if (k == 1) {
			game[topDiskAtPosition(game, i)] = j;
			trace += hanoiToString(game);
			
			return;
		}
		
		// Recursion
		moveAll(game, i, 6-i-j, k-1);
		moveAll(game, i, j, 1);
		moveAll(game, 6-i-j, j, k-1);
		
	}
	
	/**
	 * Returns a string of steps in solving the tower 
	 * of hanoi of n disks where the starting position is 1
	 * and the final position is 3.
	 * 
	 * @param n The number of disks
	 * @return String describing the steps of solving the tower of hanoi of size n
	 */
	public static String trace (int n) {
		String s;
		moveAll(init(n), 1, 3, n);
		s = trace;
		trace = "";
		return s;
	}
	
}
