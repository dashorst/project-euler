package com.martijndashorst.euler;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.junit.Test;

/**
 * A perfect number is a number for which the sum of its proper divisors is
 * exactly equal to the number. For example, the sum of the proper divisors of
 * 28 would be 1 + 2 + 4 + 7 + 14 = 28, which means that 28 is a perfect number.
 * 
 * A number n is called deficient if the sum of its proper divisors is less than
 * n and it is called abundant if this sum exceeds n.
 * 
 * As 12 is the smallest abundant number, 1 + 2 + 3 + 4 + 6 = 16, the smallest
 * number that can be written as the sum of two abundant numbers is 24. By
 * mathematical analysis, it can be shown that all integers greater than 28123
 * can be written as the sum of two abundant numbers. However, this upper limit
 * cannot be reduced any further by analysis even though it is known that the
 * greatest number that cannot be expressed as the sum of two abundant numbers
 * is less than this limit.
 * 
 * Find the sum of all the positive integers which cannot be written as the sum
 * of two abundant numbers.
 */
public class Euler23 {
	@Test
	public void example() {
		assertThat(isPerfect(28), is(true));
		assertThat(isAbundant(12), is(true));
	}

	@Test
	public void solution() {
		List<Integer> abundantNumbers = IntStream.rangeClosed(1, 28123)
				.filter(this::isAbundant)
				.boxed()
				.collect(Collectors.toList());
		Set<Integer> sumsOfTwoAbundantNumbers = new HashSet<>();
		for (Integer i : abundantNumbers) {
			for (Integer j : abundantNumbers) {
				sumsOfTwoAbundantNumbers.add(i + j);
			}
		}

		long sum = IntStream.range(1, 28123)
				.filter(n -> !sumsOfTwoAbundantNumbers.contains(n))
				.asLongStream()
				.sum();
		assertThat(sum, is(4179871L));
	}

	private boolean isPerfect(int a) {
		return a == sumOfProperDivisors(a);
	}

	private boolean isAbundant(int a) {
		return sumOfProperDivisors(a) > a;
	}

	private int sumOfProperDivisors(int n) {
		return IntStream.rangeClosed(1, n / 2)
				.filter(i -> n % i == 0)
				.sum();
	}
}
