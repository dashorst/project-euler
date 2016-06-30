package com.martijndashorst.euler;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

import org.junit.Test;

/**
 * If the numbers 1 to 5 are written out in words: one, two, three, four, five,
 * then there are 3 + 3 + 5 + 4 + 4 = 19 letters used in total.
 * 
 * If all the numbers from 1 to 1000 (one thousand) inclusive were written out
 * in words, how many letters would be used?
 * 
 * NOTE: Do not count spaces or hyphens. For example, 342 (three hundred and
 * forty-two) contains 23 letters and 115 (one hundred and fifteen) contains 20
 * letters. The use of "and" when writing out numbers is in compliance with
 * British usage.
 */
public class Euler17 {
	@Test
	public void example() {
		assertThat(IntStream.range(1, 6).map(this::numberOfDigitsInEnglishNumber).sum(), is(19));
		assertThat(getEnglishNumber(301), is("three hundred and one"));
		assertThat(getEnglishNumber(11), is("eleven"));
		assertThat(getEnglishNumber(42), is("forty two"));
		assertThat(getEnglishNumber(311), is("three hundred and eleven"));
		assertThat(getEnglishNumber(342), is("three hundred and forty two"));
		assertThat(numberOfDigitsInEnglishNumber(342), is(23));
		assertThat(numberOfDigitsInEnglishNumber(115), is(20));
	}

	@Test
	public void solution() {
		assertThat(IntStream.range(1, 1001).map(this::numberOfDigitsInEnglishNumber).sum(), is(21124));
	}

	private int numberOfDigitsInEnglishNumber(int n) {
		try {
			return getEnglishNumber(n).replaceAll(" ", "").length();
		} catch (RuntimeException e) {
			System.err.println(
					"Poging om " + n + " te vertalen naar engels mislukt met een " + e.getClass().getSimpleName());
			throw e;
		}
	}

	private static String getEnglishNumber(int n) {
		return intToNumber.get(n);
	}

	private static Map<Integer, String> intToNumber = new HashMap<>();

	static {
		intToNumber.put(1, "one");
		intToNumber.put(2, "two");
		intToNumber.put(3, "three");
		intToNumber.put(4, "four");
		intToNumber.put(5, "five");
		intToNumber.put(6, "six");
		intToNumber.put(7, "seven");
		intToNumber.put(8, "eight");
		intToNumber.put(9, "nine");
		intToNumber.put(10, "ten");
		intToNumber.put(11, "eleven");
		intToNumber.put(12, "twelve");
		intToNumber.put(13, "thirteen");
		intToNumber.put(14, "fourteen");
		intToNumber.put(15, "fifteen");
		intToNumber.put(16, "sixteen");
		intToNumber.put(17, "seventeen");
		intToNumber.put(18, "eighteen");
		intToNumber.put(19, "nineteen");
		intToNumber.put(20, "twenty");
		intToNumber.put(30, "thirty");
		intToNumber.put(40, "forty");
		intToNumber.put(50, "fifty");
		intToNumber.put(60, "sixty");
		intToNumber.put(70, "seventy");
		intToNumber.put(80, "eigthy");
		intToNumber.put(90, "ninety");

		for (int i = 1; i < 10; i++) {
			intToNumber.put(i * 100, intToNumber.get(i) + " hundred");
		}

		for (int i = 2; i < 10; i++) {
			for (int j = 1; j < 10; j++) {
				intToNumber.put(i * 10 + j, intToNumber.get(i * 10) + " " + intToNumber.get(j));
			}
		}

		for (int i = 1; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				for (int k = 0; k < 10; k++) {
					if (j == 0 && k == 0)
						continue;
					intToNumber.put(i * 100 + j * 10 + k,
							intToNumber.get(i * 100) + " and " + intToNumber.get(j * 10 + k));
				}
			}
		}
		intToNumber.put(1000, "one thousand");
	}

}
