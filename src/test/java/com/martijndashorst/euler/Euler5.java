package com.martijndashorst.euler;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

/**
 * 2520 is the smallest number that can be divided by each of the numbers from 1
 * to 10 without any remainder.
 * 
 * What is the smallest positive number that is evenly divisible by all of the
 * numbers from 1 to 20?
 */
public class Euler5 {
	@Test
	public void test() {
		Assert.assertThat(smallestNumberDivisibleByAllNumbersUpTo(10), CoreMatchers.is(2520));
	}

	@Test
	public void solution() {
		Assert.assertThat(smallestNumberDivisibleByAllNumbersUpTo(20), CoreMatchers.is(232792560));
	}

	private int smallestNumberDivisibleByAllNumbersUpTo(int nr) {
		int i = 10;
		while (true) {
			boolean divisibleByAll = true;
			for (int j = 2; j <= nr; j++) {
				if (i % j != 0) {
					divisibleByAll = false;
					break;
				}
			}
			if (divisibleByAll)
				return i;
			i+=10;
		}
	}
}
