package com.martijndashorst.euler;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

/**
 * If we list all the natural numbers below 10 that are multiples of 3 or 5, we
 * get 3, 5, 6 and 9. The sum of these multiples is 23.
 * 
 * Find the sum of all the multiples of 3 or 5 below 1000.
 */
public class Euler1 {
	@Test
	public void resultUpTil() {
		assertThat(sumOfMultiplesOf3and5(0), is(0));
		assertThat(sumOfMultiplesOf3and5(1), is(0));
		assertThat(sumOfMultiplesOf3and5(2), is(0));
		assertThat(sumOfMultiplesOf3and5(3), is(0));
		assertThat(sumOfMultiplesOf3and5(4), is(3));
		assertThat(sumOfMultiplesOf3and5(5), is(3));
		assertThat(sumOfMultiplesOf3and5(6), is(8));
		assertThat(sumOfMultiplesOf3and5(7), is(14));
	}

	@Test
	public void resultUpTil10() {
		assertThat(sumOfMultiplesOf3and5(10), is(23));
	}

	@Test
	public void resultUpTil1000() {
		assertThat(sumOfMultiplesOf3and5(1000), is(233168));
	}

	private int sumOfMultiplesOf3and5(int limit) {
		int result = 0;
		for (int i = 0; i < limit; i++) {
			if (i % 3 == 0 || i % 5 == 0)
				result += i;
		}
		return result;
	}
}
