package com.martijndashorst.euler;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

/**
 * Starting with the number 1 and moving to the right in a clockwise direction a
 * 5 by 5 spiral is formed as follows:
 * 
 * <pre>
         21 22 23 24 25
         20  7  8  9 10
         19  6  1  2 11
         18  5  4  3 12
         17 16 15 14 13
 * </pre>
 * 
 * It can be verified that the sum of the numbers on the diagonals is 101:
 * 
 * 21 + 7 + 1 + 3 + 13 + 17 + 5 + 1 + 9 + 25
 * 
 * What is the sum of the numbers on the diagonals in a 1001 by 1001 spiral
 * formed in the same way?
 */
public class Euler28 {

	/**
	 * <pre>
	         21 22 23 24 25
	         20  7  8  9 10
	         19  6  1  2 11
	         18  5  4  3 12
	         17 16 15 14 13
	 * </pre>
	 * 
	 */
	@Test
	public void example5() {
		List<Integer> spiral5 = cornersOfNumberSpiral(5);
		assertEquals(spiral5, Arrays.asList(1, 3, 5, 7, 9, 13, 17, 21, 25));
		assertThat(spiral5.stream()
				.mapToInt(i -> i)
				.sum(), is(101));
	}

	/**
	 * <pre>
	        43 44 45 46 47 48 49
	        42 21 22 23 24 25 26
	        41 20  7  8  9 10 27 
	        40 19  6  1  2 11 28
	        39 18  5  4  3 12 29
	        38 17 16 15 14 13 30
	        37 36 35 34 33 32 31
	 * </pre>
	 */
	@Test
	public void example7() {
		List<Integer> spiral7 = cornersOfNumberSpiral(7);
		assertEquals(spiral7, Arrays.asList(1, 3, 5, 7, 9, 13, 17, 21, 25, 31, 37, 43, 49));
		assertThat(spiral7.stream()
				.mapToInt(i -> i)
				.sum(), is(261));
	}

	@Test
	public void solution() {
		assertThat(cornersOfNumberSpiral(1001).stream()
				.mapToInt(i -> i)
				.sum(), is(669_171_001));
	}

	private List<Integer> cornersOfNumberSpiral(int n) {
		List<Integer> result = new ArrayList<>();
		int i = 1;
		int factor = 3;
		result.add(i);
		while (i < n * n) {
			int width = (factor - 1);
			for (int j = 0; j < 4; j++) {
				i = i + width;
				result.add(i);
			}
			factor += 2;
		}
		return result;
	}
}
