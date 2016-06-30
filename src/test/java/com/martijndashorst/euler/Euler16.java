package com.martijndashorst.euler;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.math.BigInteger;

import org.junit.Test;

/**
 * 2^15 = 32768 and the sum of its digits is 3 + 2 + 7 + 6 + 8 = 26.
 * 
 * What is the sum of the digits of the number 2^1000?
 */
public class Euler16 {
	@Test
	public void example() {
		assertThat(sumOfDigits(15), is(26L));
	}

	@Test
	public void solution() {
		assertThat(sumOfDigits(1000), is(1366L));
	}

	private long sumOfDigits(int n) {
		BigInteger powerOf2 = BigInteger.valueOf(2).pow(n);
		String digits = powerOf2.toString();
		return digits.chars().mapToLong(c -> c - '0').sum();
	}
}
