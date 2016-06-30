package com.martijndashorst.euler;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

/**
 * By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see
 * that the 6th prime is 13.
 * 
 * What is the 10 001st prime number?
 */
public class Euler7 {
	@Test
	public void test() {
		Assert.assertThat(nthPrime(1), CoreMatchers.is(2L));
		Assert.assertThat(nthPrime(2), CoreMatchers.is(3L));
		Assert.assertThat(nthPrime(6), CoreMatchers.is(13L));
	}

	@Test
	public void solution() {
		Assert.assertThat(nthPrime(10001), CoreMatchers.is(104743L));
	}

	private long nthPrime(final int n) {
		int nrOfPrimes = 0;
		long lastPrime = 0;
		long possiblePrime = 0;
		while (n != nrOfPrimes) {
			if (isPrime(possiblePrime)) {
				lastPrime = possiblePrime;
				nrOfPrimes++;
			}
			possiblePrime++;
		}
		return lastPrime;
	}

	private boolean isPrime(long number) {
		if (number < 2)
			return false;
		if (number <= 3)
			return true;
		if (number % 2 == 0)
			return false;
		if (number % 3 == 0)
			return false;
		int j = 5;
		int limit = (int) Math.sqrt(number);
		while (j <= limit) {
			if (number % j == 0 || number % (j + 2) == 0)
				return false;
			j += 6;
		}
		return true;
	}
}
