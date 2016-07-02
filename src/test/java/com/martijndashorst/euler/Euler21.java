package com.martijndashorst.euler;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.stream.IntStream;

import org.junit.Test;

/**
 * Let d(n) be defined as the sum of proper divisors of n (numbers less than n
 * which divide evenly into n). If d(a) = b and d(b) = a, where a ≠ b, then a
 * and b are an amicable pair and each of a and b are called amicable numbers.
 * 
 * For example, the proper divisors of 220 are 1, 2, 4, 5, 10, 11, 20, 22, 44,
 * 55 and 110; therefore d(220) = 284. The proper divisors of 284 are 1, 2, 4,
 * 71 and 142; so d(284) = 220.
 * 
 * Evaluate the sum of all the amicable numbers under 10000.
 */
public class Euler21 {
	@Test
	public void example() {
		assertThat(sumOfProperDivisors(220), is(284));
		assertThat(sumOfProperDivisors(284), is(220));
		assertThat(isAmicable(284), is(true));
		assertThat(isAmicable(220), is(true));
	}

	@Test
	public void solution() {
		int sumOfAllAmicableNumbers = IntStream.range(1, 10_000).filter(this::isAmicable).sum();
		assertThat(sumOfAllAmicableNumbers, is(31626));
	}

	private boolean isAmicable(int a) {
		int d_a = sumOfProperDivisors(a);
		int d_b = sumOfProperDivisors(d_a);
		return a != d_a && a == d_b;
	}

	private int sumOfProperDivisors(int n) {
		return IntStream.rangeClosed(1, n / 2)
				.filter(i -> n % i == 0)
				.sum();
	}
}
