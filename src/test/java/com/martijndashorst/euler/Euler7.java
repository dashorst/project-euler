package com.martijndashorst.euler;

import static com.martijndashorst.euler.Functions.isPrime;

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
}
