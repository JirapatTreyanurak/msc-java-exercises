/** Worksheet 2 Exercise 5
 * 
 * This class contains a static method that
 * determines whether or not a completed
 * Sudoku board is valid.
 * 
 * @author Jirapat Treyanurak (jxt163 1214663 MSc Computer Science)
 * @version 2014-10-20
 */
public class Ex5 {
	
	/**
	 * Helper method for checkSudoku. This
	 * method checks whether an integer array
	 * of length 9 contains each digit from 1
	 * to 9 exactly once.
	 * 
	 * If an integer array of length not equal
	 * to 9 is passed, the method returns false.
	 * 
	 * @param arg Array of integer of length 9.
	 * @return Boolean checking if the array contains each digit from 1 to 9 exactly once.
	 */
	public static boolean has1to9exactlyOnce (int[] arg) {
		int[] count = {0,0,0,0,0,0,0,0,0};
		
		//array length filter
		if (arg.length != 9) {
			return false;
		}
		
		//duplicate filter
		for (int i = 0; i < arg.length; i++) {
			//out of bound filter
			if (arg[i] <= 0 || arg[i] > 9) {
				return false;
			}
			count[arg[i]-1]++;
			if (count[arg[i]-1] > 1) {
				return false;
			}
		}
		
		//each digit from 1 to 9 filter
		for (int j = 0; j < arg.length; j++) {
			if (count[j] == 0) {
				return false;
			}
		}
		
		return true;
	}
	
	/**
	 * Checks whether a completed sudoku board
	 * is a valid solution to the puzzle or not.
	 * A 9x9 completed sudoku board is valid if
	 * every rows, columns, and boxes contain 
	 * each digits from 1 to 9 exactly once.
	 * The boxes can be defined as follows:
	 * Consider 9 3x3 sub-boards. Fit these 9
	 * sub-boards on the 9x9 sudoku board. We
	 * get a unique solution to this fitting
	 * problem and the resulting 3x3 sub-boards
	 * each defines a "box".
	 * 
	 * The input is a completed board represented
	 * by a 2-dimensional array of integers where
	 * board[i][j] represents a number on the ith
	 * row and jth column.
	 * 
	 * The method returns a 2-dimensional array of
	 * boolean values where result[0][k] states
	 * whether or not the kth row (counting from 0
	 * to 8 going from top to bottom) has each of 
	 * the digits from 1 to 9 exactly once, 
	 * result[1][k] states whether or not the kth
	 * column (counting from 0 to 8 going from left
	 * to right) has each of the digits from 1 to 9
	 * exactly once, and result[2][k] states whether
	 * or not the kth box (counting from 0 to 8 
	 * going from top-left to bottom-right in English
	 * reading order) has each of the digits from 1 
	 * to 9 exactly once.
	 * 
	 * @param board A 2-dimensional array of integers representing a completed Sudoku board.
	 * @return A 2-dimensional array of boolean values stating whether the corresponding rows/columns/boxes are valid.
	 */
	public static boolean[][] checkSudoku (int[][] board) {
		boolean[][] result = new boolean[3][9];
		int[] row = new int[9];
		int[] col = new int[9];
		int[] box = new int[9];
		int a, b;
		
		//for each of the 9 rows/columns/boxes
		for (int i = 0; i < 9; i++) {
			
			//ith row
			row = board[i];
			result[0][i] = has1to9exactlyOnce(row);
			
			//ith column
			for (int j = 0; j < 9; j++) {
				col[j] = board[j][i];
			}
			result[1][i] = has1to9exactlyOnce(col);
			
			//ith box
			/**
			 * The boxes are ordered as follows:
			 * <pre>
			 *  0 | 1 | 2
			 *  ---------
			 *  3 | 4 | 5
			 *  ---------
			 *  6 | 7 | 8
			 *  </pre>
			 *  
			 *  If we can refer to an element within 
			 *  each of the box, we are done since the 
			 *  rest of the element in the same box can
			 *  be defined relative to it. 
			 *  For convenience, we pick the top-left 
			 *  element of each box.
			 *  These are:
			 *  <pre>
			 *  (0,0) | (0,3) | (0,6)
			 *  ---------------------
			 *  (3,0) | (3,3) | (3,6)
			 *  ---------------------
			 *  (6,0) | (6,3) | (6,6)
			 *  </pre>
			 *  Again, for convenience, we take the factor
			 *  3 out to obtain:
			 *  <pre>
			 *  (0,0) | (0,1) | (0,2)
			 *  ---------------------
			 *  (1,0) | (1,1) | (1,2)
			 *  ---------------------
			 *  (2,0) | (2,1) | (2,2)
			 *  </pre>
			 *  
			 *  Now note the row index of the top-left
			 *  element of each of the boxes goes
			 *  0, 0, 0, 1, 1, 1, 2, 2, 2 (in reading order).
			 *  We need to map the box index to the row index:
			 *  <pre>
			 *  box | row index of top-left element
			 *  -----------------------------------
			 *   0  | 0
			 *   1  | 0
			 *   2  | 0
			 *   3  | 1
			 *   4  | 1
			 *   5  | 1
			 *   6  | 2
			 *   7  | 2
			 *   8  | 2
			 *   </pre>
			 *  For the ith box, these index can simply
			 *  be obtained by integer division i/3
			 *  (truncated).
			 *  
			 *  Similarly, column indices of the top-left
			 *  element of the ith box can be obtained by
			 *  computing i modulo 3.
			 *  
			 *  Now we convert these back to the original 
			 *  indices by multiplying 3 back in.
			 *  Hence 
			 *  a = 3*(i/3)
			 *  b = 3*(i%3)
			 */
			a = 3*(i/3);
			b = 3*(i%3);
			
			/**
			 * The rest of the elements in the ith box
			 * defined relative to the top-left element.
			 */
			box[0] = board[ a ][ b ];  box[1] = board[ a ][b+1];  box[2] = board[ a ][b+2];
			box[3] = board[a+1][ b ];  box[4] = board[a+1][b+1];  box[5] = board[a+1][b+2];
			box[6] = board[a+2][ b ];  box[7] = board[a+2][b+1];  box[8] = board[a+2][b+2];
			
			result[2][i] = has1to9exactlyOnce(box);
		}
		
		return result;
	}
	
}
