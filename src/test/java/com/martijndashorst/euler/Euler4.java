package com.martijndashorst.euler;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

/**
 * A palindromic number reads the same both ways. The largest palindrome made
 * from the product of two 2-digit numbers is 9009 = 91 × 99.
 * 
 * Find the largest palindrome made from the product of two 3-digit numbers.
 */
public class Euler4 {
	@Test
	public void test() {
		Assert.assertTrue(isPalindrome(91 * 99));
		Assert.assertThat(maxPalindrome(2), CoreMatchers.is(9009));
	}

	@Test
	public void solution() {
		Assert.assertThat(maxPalindrome(3), CoreMatchers.is(906609));
	}

	private int maxPalindrome(int digits) {
		int max = (int) Math.pow(10, digits) - 1;
		int min = (int) Math.pow(10, digits - 1);
		int maxPalindrome = 0;
		for (int i = max; i >= min; i--) {
			for (int j = max; j >= min; j--) {
				int product = i * j;
				if (isPalindrome(product)) {
					maxPalindrome = Math.max(maxPalindrome, product);
				}
			}
		}
		return maxPalindrome;
	}

	private boolean isPalindrome(int number) {
		String x = String.valueOf(number);
		return x.equals(new StringBuilder(x).reverse().toString());
	}
}
