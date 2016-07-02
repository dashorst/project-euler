package com.martijndashorst.euler;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

/**
 * Euler discovered the remarkable quadratic formula:
 * 
 * n² + n + 41
 * 
 * It turns out that the formula will produce 40 primes for the consecutive
 * values n = 0 to 39. However, when n = 40, 402 + 40 + 41 = 40(40 + 1) + 41 is
 * divisible by 41, and certainly when n = 41, 41² + 41 + 41 is clearly
 * divisible by 41.
 * 
 * The incredible formula n² − 79n + 1601 was discovered, which produces 80
 * primes for the consecutive values n = 0 to 79. The product of the
 * coefficients, −79 and 1601, is −126479.
 * 
 * Considering quadratics of the form:
 * 
 * n² + an + b, where |a| < 1000 and |b| < 1000
 * 
 * where |n| is the modulus/absolute value of n e.g. |11| = 11 and |−4| = 4 Find
 * the product of the coefficients, a and b, for the quadratic expression that
 * produces the maximum number of primes for consecutive values of n, starting
 * with n = 0.
 */
public class Euler27 {
	@Test
	public void solution() {
		int limit = 1000;
		int maxA = -1000;
		int maxB = -1000;
		int maxConsecutivePrimes = 0;

		for (int a = -limit + 1; a < limit; a++) {
			for (int b = -limit + 1; b < limit; b++) {
				int n = 0;
				while (Functions.isPrime(euler(a, b, n)))
					n++;
				if (n > maxConsecutivePrimes) {
					maxA = a;
					maxB = b;
					maxConsecutivePrimes = n;
				}
			}
		}
		assertThat(maxConsecutivePrimes, is(71));
		assertThat(maxA*maxB, is(-59231));
	}

	private int euler(int a, int b, int n) {
		return n * n + a * n + b;
	}
}
