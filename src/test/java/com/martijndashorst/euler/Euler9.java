package com.martijndashorst.euler;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

/**
 * A Pythagorean triplet is a set of three natural numbers, a < b < c, for
 * which,
 * 
 * a^2 + b^2 = c^2 For example, 3^2 + 4^2 = 9 + 16 = 25 = 5^2.
 * 
 * There exists exactly one Pythagorean triplet for which a + b + c = 1000. Find
 * the product abc.
 */
public class Euler9 {
	@Test
	public void solution() {
		long answer = -1;
		for (int c = 2; c < 1000; c++) {
			for (int b = 1; b < c; b++) {
				for (int a = 0; a < b; a++) {
					if (a + b + c != 1000)
						continue;
					if (a * a + b * b == c * c)
						answer = a * b * c;
				}
			}
		}
		assertThat(answer, is(31875000L));
	}
}
