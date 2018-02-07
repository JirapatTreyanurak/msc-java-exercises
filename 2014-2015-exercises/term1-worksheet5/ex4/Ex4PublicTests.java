package ex4;

import static org.junit.Assert.*;

import org.junit.Test;

public class Ex4PublicTests {

	/**
	 * Simple encode test
	 */
	@Test
	public void Ex3PublicTest1() {
		//Don Quixote frequencies
		long[] frequencies = {148970,25519,41224,81586,219488,41740,34245,125330,121889,1654,12516,66773,45899,124802,146903,26297,4213,100115,114741,169435,50147,18704,40609,4562,33237,1106,395475,68099,40006};
		Tree huffman = Ex4.generateTree(frequencies);
		String result = Ex4.encode("hello", huffman);
		//String expected = "011000101110011101000";
		String decodedResult = Ex4.decode(result, huffman);

		assertEquals("hello", decodedResult);
	}
	

	
	/**
	 * Longer encode test
	 */
	@Test
	public void Ex3PublicTest2() {
		//Don Quixote frequencies
		long[] frequencies = {148970,25519,41224,81586,219488,41740,34245,125330,121889,1654,12516,66773,45899,124802,146903,26297,4213,100115,114741,169435,50147,18704,40609,4562,33237,1106,395475,68099,40006};
		Tree huffman = Ex4.generateTree(frequencies);
		String result = Ex4.encode("hello world.\n this is a string", huffman);
		//String expected = "0110001011100111010001111001111000110110111010110100101001101111100011001000001111010000011111010111000111001101101000101011111";
		String decodedResult = Ex4.decode(result, huffman);

		assertEquals("hello world.\n this is a string", decodedResult);
	}
	
	
}
