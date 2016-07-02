package com.martijndashorst.euler;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

/**
 * A permutation is an ordered arrangement of objects. For example, 3124 is one
 * possible permutation of the digits 1, 2, 3 and 4. If all of the permutations
 * are listed numerically or alphabetically, we call it lexicographic order. The
 * lexicographic permutations of 0, 1 and 2 are:
 * 
 * 012 021 102 120 201 210
 * 
 * What is the millionth lexicographic permutation of the digits 0, 1, 2, 3, 4,
 * 5, 6, 7, 8 and 9?
 */
public class Euler24 {
	@Test
	public void example() {
		assertThat(true, is(true));
		assertThat(nthLexigraphicalPermutation("012", 1), is("012"));
		assertThat(nthLexigraphicalPermutation("012", 2), is("021"));
		assertThat(nthLexigraphicalPermutation("012", 3), is("102"));
		assertThat(nthLexigraphicalPermutation("012", 4), is("120"));
		assertThat(nthLexigraphicalPermutation("012", 5), is("201"));
		assertThat(nthLexigraphicalPermutation("012", 6), is("210"));
	}

	@Test
	public void solution() {
		int n = 1_000_000;
		assertThat(nthLexigraphicalPermutation("0123456789", n), is("2783915460"));
	}

	private List<String> permutations = new ArrayList<>();

	private String nthLexigraphicalPermutation(String digits, int n) {
		permutations = new ArrayList<>();
		permutate("", digits);
		Collections.sort(permutations);
		return permutations.get(n - 1);
	}

	private void permutate(String prefix, String str) {
		int n = str.length();
		if (n == 0) {
			permutations.add(prefix);
		}
		for (int i = 0; i < n; i++) {
			permutate(prefix + str.substring(i, i + 1), str.substring(0, i) + str.substring(i + 1));
		}
	}
}
