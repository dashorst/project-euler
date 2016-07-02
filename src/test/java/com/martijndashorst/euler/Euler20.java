package com.martijndashorst.euler;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.math.BigInteger;
import java.util.stream.IntStream;

import org.junit.Test;

/**
 * n! means n × (n − 1) × ... × 3 × 2 × 1
 * 
 * For example, 10! = 10 × 9 × ... × 3 × 2 × 1 = 3628800, and the sum of the
 * digits in the number 10! is 3 + 6 + 2 + 8 + 8 + 0 + 0 = 27.
 * 
 * Find the sum of the digits in the number 100!
 */
public class Euler20 {
	@Test
	public void example() {
		assertThat(factorialDigitSum(10), is(27));
	}

	@Test
	public void solution() {
		assertThat(factorialDigitSum(100), is(648));
	}

	private int factorialDigitSum(int n) {
		int factorialDigitSum = IntStream.rangeClosed(1, n)
				.mapToObj(BigInteger::valueOf)
				.reduce(BigInteger.ONE, BigInteger::multiply)
				.toString()
				.chars()
				.map(c -> c - '0')
				.sum();
		return factorialDigitSum;
	}
}
