package com.martijndashorst.euler;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.math.BigInteger;

import org.junit.Test;

/**
 * The 12th term, F12, is the first term to contain three digits.
 * 
 * What is the index of the first term in the Fibonacci sequence to contain 1000
 * digits?
 */
public class Euler25 {
	@Test
	public void solution() {
		int index = 2;
		BigInteger fibonacci = BigInteger.ONE;
		BigInteger previous = BigInteger.ONE;

		int nrDigits = nrDigits(fibonacci);
		while (nrDigits < 1000) {
			index++;
			BigInteger tmp = previous;
			previous = fibonacci;
			fibonacci = fibonacci.add(tmp);
			nrDigits = nrDigits(fibonacci);
		}
		assertThat(nrDigits, is(1_000));
		assertThat(index, is(4782));
	}

	private int nrDigits(BigInteger fibonacci) {
		return fibonacci.toString().length();
	}
}
