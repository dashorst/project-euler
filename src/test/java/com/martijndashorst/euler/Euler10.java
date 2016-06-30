package com.martijndashorst.euler;

import java.util.stream.IntStream;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

/**
 * The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.
 * 
 * Find the sum of all the primes below two million.
 */
public class Euler10 {
	@Test
	public void test() {
		Assert.assertThat(sumOfPrimesBelow(10), CoreMatchers.is(17L));
	}

	@Test
	public void solution() {
		Assert.assertThat(sumOfPrimesBelow(2_000_000), CoreMatchers.is(142_913_828_922L));
	}

	private long sumOfPrimesBelow(int nr) {
		return IntStream.range(2, nr).filter(this::isPrime).asLongStream().sum();
	}

	private boolean isPrime(int number) {
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
