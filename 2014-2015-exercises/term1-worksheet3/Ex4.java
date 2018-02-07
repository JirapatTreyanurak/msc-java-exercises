/** Worksheet 3 Exercise 4
 * 
 * This class contains a static method that
 * sorts an array of string into increasing
 * order by length using quicksort.
 * For details of quicksort, see
 * http://en.wikipedia.org/wiki/Quicksort
 * 
 * @author Jirapat Treyanurak (jxt163 1214663 MSc Computer Science)
 * @version 2014-11-03
 */
public class Ex4 {
	
	/**
	 * Implements quicksort on string array.
	 * 
	 * First, we pick the pivot to be the middle
	 * element in the input array and determine the
	 * sizes of the left and right sub-array by going
	 * through the input array and count the number
	 * of elements that are strictly 'longer' (in
	 * length) and 'shorter' than the 
	 * pivot.
	 * Then we reconstruct the array as follows:
	 * {quickSort(leftArray), pivot, quickSort(rightArray)}.
	 * This is done by recursion on the 2 sub-arrays.
	 * The base case is when we have an array of length 0
	 * or 1, in which case we simply return the input back.
	 * 
	 * @param array The array of strings that will be sorted.
	 * @return Input array of strings sorted into increasing order by length.
	 */
	public static String[] quickSort (String[] array) {
		String[] result = new String[array.length];
		int pivot = array.length/2;
		int pivotLength;
		int leftSize = 0;
		int rightSize = 0;
		int leftIndex = 0;
		int rightIndex = 0;
		
		if (array.length == 1 || array.length == 0) {
			return array;
		}
		pivotLength = array[pivot].length();
		
		//determine the size of each of the 2 sub-arrays before we can initialise them
		for (int i = 0; i < array.length; i++) {
			if (i != pivot) {
				if (array[i].length() > pivotLength) {
					rightSize++;
				} else {
					leftSize++;
				}
			}
		}
		String[] leftArray = new String[leftSize];
		String[] rightArray = new String[rightSize];
		
		
		//Now go through the array again, this time copy each elements into the appropriate sub-array
		if (leftSize > 0) {
			for (int i = 0; i < array.length; i++) {
				if (i != pivot && array[i].length() <= pivotLength) {
					leftArray[leftIndex] = array[i];
					leftIndex++;
				}
			}
			//now update result with the sorted leftArray (recursion)
			leftArray = quickSort(leftArray);
			for (int i = 0; i < leftSize; i++) {
				result[i] = leftArray[i];
			}
		}
		//place the pivot in-between the sorted leftArray and the sorted rightArray (next loop)
		result[leftSize] = array[pivot];
		
		if (rightSize > 0) {
			for (int i = 0; i < array.length; i++) {
				if (i != pivot && array[i].length() > pivotLength) {
					rightArray[rightIndex] = array[i];
					rightIndex++;
				}
			}
			rightArray = quickSort(rightArray);
			for (int i = 0; i < rightSize; i++) {
				result[leftSize + 1 + i] = rightArray[i];
			}
		}
		
		return result;
	}
	
}
