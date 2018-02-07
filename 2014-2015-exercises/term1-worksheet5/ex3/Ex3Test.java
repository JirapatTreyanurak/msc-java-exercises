package ex3;

import static org.junit.Assert.*;

import org.junit.Test;

/** Worksheet 5 Exercise 3 Test
 * 
 * This class tests the frequencyAnalysis method
 * inside the Ex3 class.
 * It uses text files that was uploaded online to google doc.
 * 
 * @author Jirapat Treyanurak (jxt163 1214663 MSc Computer Science)
 * @version 2014-12-10
 */
public class Ex3Test {

	@Test
	public void frequencyAnalysisTest1 () {
		/* The file looks like so:
		 * 	aaaaa
		 * 	bbbb
		 * 	ccc
		 * 	dd
		 * 	e
		 * 
		 */
		long[] result = Ex3.frequencyAnalysis("https://drive.google.com/uc?id=0B9e0yUPeJ7jATHJsRVVRaVl2VkE");
		long[] expected = {5,4,3,2,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,5};
		assertArrayEquals(expected, result);
	}
	@Test
	public void frequencyAnalysisTest2 () {
		/* The file looks like so:
		 * abcdefghijklmnopqrstuvwxyz .
		 * 
		 */
		long[] result = Ex3.frequencyAnalysis("https://drive.google.com/uc?id=0B9e0yUPeJ7jAUHBBaFZwNm9VcWc");
		long[] expected = {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2};
		assertArrayEquals(expected, result);
	}
	@Test
	public void frequencyAnalysisTest3 () {
		/* The file looks like so:
		 * I don't know.
		 * Sometimes I think I am mad.
		 * Sometimes I think I am foolish.
		 * Can I become a better person?
		 * 
		 */
		//recall other characters will get ignored.
		long[] result = Ex3.frequencyAnalysis("https://drive.google.com/uc?id=0B9e0yUPeJ7jAMXlnY2FsbjhaUlE");
		long[] expected = {5,2,2,2,9,1,0,3,11,0,3,1,8,6,8,1,0,2,6,7,0,0,1,0,0,0,17,3,5};
		assertArrayEquals(expected, result);
	}

}
