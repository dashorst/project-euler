package com.martijndashorst.euler;

import java.util.HashSet;
import java.util.Set;

public class Functions {
	private static Set<Long> primes = new HashSet<>();

	public static boolean isPrime(int number) {
		return isPrime((long) number);
	}

	public static boolean isPrime(long number) {
		if (number < 2)
			return false;
		if (number <= 3)
			return true;
		if (number % 2 == 0)
			return false;
		if (number % 3 == 0)
			return false;
		if (number > 17) {
			if (primes.contains(number))
				return true;

		}
		int j = 5;
		int limit = (int) Math.sqrt(number);
		while (j <= limit) {
			if (number % j == 0 || number % (j + 2) == 0)
				return false;
			j += 6;
		}
		primes.add(number);
		return true;
	}
}
