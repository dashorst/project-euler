package com.martijndashorst.euler;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

/**
 * Starting in the top left corner of a 2×2 grid, and only being able to move to
 * the right and down, there are exactly 6 routes to the bottom right corner.
 * 
 * How many such routes are there through a 20×20 grid?
 */
public class Euler15 {
	@Test
	public void example() {
		assertThat(numberOfPathsInGrid(2), is(6L));
	}

	@Test
	public void result() {
		assertThat(numberOfPathsInGrid(20), is(137_846_528_820L));
	}

	/**
	 * <pre>
	 * 0 1 1
	 * 1 2 3
	 * 1 3 6
	 * </pre>
	 */
	private long numberOfPathsInGrid(int n) {
		n = n + 1;
		long[][] paths = new long[n][n];

		paths[0][0] = 0;

		// number of possible paths to reach the left and top edges is 1
		for (int i = 0; i < n; i++) {
			paths[0][i] = 1;
			paths[i][0] = 1;
		}

		for (int y = 1; y < n; y++) {
			for (int x = 1; x < n; x++) {
				paths[y][x] = paths[y - 1][x] + paths[y][x - 1];
			}
		}
		return paths[n - 1][n - 1];
	}
}
