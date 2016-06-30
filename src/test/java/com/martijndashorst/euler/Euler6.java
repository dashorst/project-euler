package com.martijndashorst.euler;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

/**
 * The sum of the squares of the first ten natural numbers is,
 * 
 * 1^2 + 2^2 + ... + 10^2 = 385 The square of the sum of the first ten natural
 * numbers is,
 * 
 * (1 + 2 + ... + 10)^2 = 552 = 3025 Hence the difference between the sum of the
 * squares of the first ten natural numbers and the square of the sum is 3025 −
 * 385 = 2640.
 * 
 * Find the difference between the sum of the squares of the first one hundred
 * natural numbers and the square of the sum.
 */
public class Euler6 {
	@Test
	public void test() {
		Assert.assertThat(sumSquared(10), CoreMatchers.is(385L));
		Assert.assertThat(squaredSum(10), CoreMatchers.is(3025L));
		Assert.assertThat(difference(10), CoreMatchers.is(2640L));
	}

	@Test
	public void solution() {
		Assert.assertThat(difference(100), CoreMatchers.is(25164150L));
	}

	private long sumSquared(int nr) {
		long sum = 0;
		for (int i = 1; i <= nr; i++)
			sum = sum + (int) Math.pow(i, 2);
		return sum;
	}

	private long squaredSum(int nr) {
		long sum = nr * (nr + 1) / 2;
		return (long) Math.pow(sum, 2);
	}

	private long difference(int nr) {
		return squaredSum(nr) - sumSquared(nr);
	}
}
