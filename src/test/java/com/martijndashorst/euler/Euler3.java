package com.martijndashorst.euler;

import static com.martijndashorst.euler.Functions.isPrime;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

/**
 * The prime factors of 13195 are 5, 7, 13 and 29.
 * 
 * What is the largest prime factor of the number 600851475143 ?
 */
public class Euler3 {
	@Test
	public void test() {
		Assert.assertThat(getLargestFactor(13195L), CoreMatchers.is(29L));
	}

	@Test
	public void solution() {
		long nr = 600_851_475_143L;
		Assert.assertThat(getLargestFactor(nr), CoreMatchers.is(6857L));
	}

	private long getLargestFactor(long nr) {
		int max = (int) Math.sqrt(nr);
		long maxFactor = 0;
		for (int i = 1; i < max; i++) {
			if (nr % i == 0 && isPrime(i)) {
				maxFactor = i;
			}
		}
		return maxFactor;
	}

	@Test
	public void primenumbers() {
		Assert.assertTrue(isPrime(2));
		Assert.assertTrue(isPrime(3));
		Assert.assertTrue(isPrime(5));
		Assert.assertTrue(isPrime(7));
		Assert.assertTrue(isPrime(11));
		Assert.assertTrue(isPrime(13));
		Assert.assertTrue(isPrime(17));
		Assert.assertTrue(isPrime(19));
		Assert.assertTrue(isPrime(23));
	}

	@Test
	public void notPrimenumbers() {
		Assert.assertFalse(isPrime(4));
		Assert.assertFalse(isPrime(6));
		Assert.assertFalse(isPrime(8));
		Assert.assertFalse(isPrime(9));
		Assert.assertFalse(isPrime(12));
		Assert.assertFalse(isPrime(15));
		Assert.assertFalse(isPrime(18));
		Assert.assertFalse(isPrime(21));
		Assert.assertFalse(isPrime(25));
		Assert.assertFalse(isPrime(49));
	}
}
