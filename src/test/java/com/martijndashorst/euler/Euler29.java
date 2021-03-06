package com.martijndashorst.euler;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

/**
 * Consider all integer combinations of a^b for 2 ≤ a ≤ 5 and 2 ≤ b ≤ 5:
 * 
 * <li>2^2=4, 2^3=8, 2^4=16, 2^5=32
 * <li>3^2=9, 3^3=27, 3^4=81, 3^5=243
 * <li>4^2=16, 4^3=64, 4^4=256, 4^5=1024
 * <li>5^2=25, 5^3=125, 5^4=625, 5^5=3125
 * 
 * If they are then placed in numerical order, with any repeats removed, we get
 * the following sequence of 15 distinct terms:
 * 
 * 4, 8, 9, 16, 25, 27, 32, 64, 81, 125, 243, 256, 625, 1024, 3125
 * 
 * How many distinct terms are in the sequence generated by a^b for 2 ≤ a ≤ 100
 * and 2 ≤ b ≤ 100?
 */
public class Euler29 {
	@Test
	public void example() {
		assertThat(numberOfDistinctPowers(5), is(15));
	}

	@Test
	public void solution() {
		assertThat(numberOfDistinctPowers(100), is(9183));
	}

	private int numberOfDistinctPowers(int n) {
		Set<BigInteger> powers = new HashSet<>();
		for (int a = 2; a <= n; a++) {
			for (int b = 2; b <= n; b++) {
				powers.add(BigInteger.valueOf(a)
						.pow(b));
			}
		}
		return powers.size();
	}
}
