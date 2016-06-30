package com.martijndashorst.euler;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.stream.IntStream;

import org.junit.Test;

/**
 * The following iterative sequence is defined for the set of positive integers:
 * 
 * <ul>
 * <li>n → n/2 (n is even)
 * <li>n → 3n + 1 (n is odd)
 * </ul>
 * 
 * Using the rule above and starting with 13, we generate the following
 * sequence:
 * 
 * 13 → 40 → 20 → 10 → 5 → 16 → 8 → 4 → 2 → 1 It can be seen that this sequence
 * (starting at 13 and finishing at 1) contains 10 terms. Although it has not
 * been proved yet (Collatz Problem), it is thought that all starting numbers
 * finish at 1.
 * 
 * Which starting number, under one million, produces the longest chain?
 * 
 * NOTE: Once the chain starts the terms are allowed to go above one million.
 */
public class Euler14 {
	@Test
	public void example() {
		assertThat(getCollatzChain(1).length, is(1));
		assertThat(getCollatzChain(2).length, is(2));
		assertThat(getCollatzChain(3).length, is(8));
		assertThat(getCollatzChain(4).length, is(3));
		assertThat(getCollatzChain(5).length, is(6));
		assertThat(getCollatzChain(13).length, is(10));
		assertThat(getCollatzChain((int) Math.pow(2, 10)).length, is(11));
		assertThat(getCollatzChain((int) Math.pow(2, 20)).length, is(21));
	}

	@Test
	public void solution() {
		Optional<CollatzChain> max = IntStream.range(1, 999_999).mapToObj(this::getCollatzChain)
				.max((c1, c2) -> c1.length - c2.length);

		assertThat(max.get().length, is(525));
		assertThat(max.get().start, is(837_799L));
	}

	private Map<Long, CollatzChain> chains = new HashMap<>();

	private CollatzChain getCollatzChain(long n) {
		if (chains.containsKey(n)) {
			return chains.get(n);
		}

		if (n == 1) {
			CollatzChain value = new CollatzChain();
			value.start = 1;
			value.length = 1;
			value.next = null;
			chains.put(1L, value);
			return value;
		}

		CollatzChain value = new CollatzChain();
		value.start = n;
		value.next = getCollatzChain(n % 2 == 0 ? n / 2 : 3 * n + 1);
		value.length = value.next.length + 1;

		chains.put(n, value);
		return value;
	}

	private static class CollatzChain {
		private long start;
		private int length;
		private CollatzChain next;
	}
}
