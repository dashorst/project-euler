package com.martijndashorst.euler;

import static java.math.BigDecimal.TEN;
import static java.math.BigDecimal.ZERO;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.math.BigDecimal;

import org.junit.Test;

/**
 * A unit fraction contains 1 in the numerator. The decimal representation of
 * the unit fractions with denominators 2 to 10 are given:
 * 
 * <ul>
 * <li>1/2 = 0.5
 * <li>1/3 = 0.(3)
 * <li>1/4 = 0.25
 * <li>1/5 = 0.2
 * <li>1/6 = 0.1(6)
 * <li>1/7 = 0.(142857)
 * <li>1/8 = 0.125
 * <li>1/9 = 0.(1)
 * <li>1/10 = 0.1
 * </ul>
 * 
 * Where 0.1(6) means 0.166666..., and has a 1-digit recurring cycle. It can be
 * seen that 1/7 has a 6-digit recurring cycle.
 * 
 * Find the value of d < 1000 for which 1/d contains the longest recurring cycle
 * in its decimal fraction part.
 */
public class Euler26 {
	@Test
	public void example() {
		assertThat(lengthOfRecurringCycle(3), is(1));
		assertThat(lengthOfRecurringCycle(17), is(16));
		assertThat(lengthOfRecurringCycle(41), is(5));
		assertThat(lengthOfRecurringCycle(43), is(21));
		assertThat(lengthOfRecurringCycle(45), is(-1));
	}

	@Test
	public void solution() {
		int longest = 0;
		int maxLength = 0;
		for (int i = 1; i < 1000; i++) {
			int l = lengthOfRecurringCycle(i);
			if (l > maxLength) {
				maxLength = l;
				longest = i;
			}
		}
		assertThat(maxLength, is(982));
		assertThat(longest, is(983));
	}

	/**
	 * Determines the length of the recurring cycle for 1/n. Based on the answer
	 * given at Stack Overflow: http://stackoverflow.com/a/1315636/611274.
	 * Doesn't work for divisors that are multples of 2 or 5.
	 * 
	 * @param n
	 * @return
	 */
	private int lengthOfRecurringCycle(int n) {
		// this calculation doesn't work for divisors that are multiples of 2
		// and 5
		if (n % 2 == 0 || n % 5 == 0)
			return -1;
		BigDecimal denomiator = BigDecimal.valueOf(n);

		BigDecimal NINE = BigDecimal.valueOf(9);
		BigDecimal nines = NINE;

		int recurringLength = 1;
		while (!nines.remainder(denomiator)
				.equals(ZERO)) {
			recurringLength++;
			nines = nines.multiply(TEN)
					.add(NINE);
		}
		return recurringLength;
	}
}
