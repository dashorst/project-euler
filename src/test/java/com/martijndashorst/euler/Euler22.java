package com.martijndashorst.euler;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Before;
import org.junit.Test;

/**
 * Using names.txt (right click and 'Save Link/Target As...'), a 46K text file
 * containing over five-thousand first names, begin by sorting it into
 * alphabetical order. Then working out the alphabetical value for each name,
 * multiply this value by its alphabetical position in the list to obtain a name
 * score.
 * 
 * For example, when the list is sorted into alphabetical order, COLIN, which is
 * worth 3 + 15 + 12 + 9 + 14 = 53, is the 938th name in the list. So, COLIN
 * would obtain a score of 938 × 53 = 49714.
 * 
 * What is the total of all the name scores in the file?
 */
public class Euler22 {
	@Test
	public void example() {
		assertThat(names.indexOf("COLIN"), is(937));
		assertThat(alphabeticalValue("COLIN"), is(53));
	}

	@Test
	public void solution() {
		long totalScore = 0;
		for (int i = 0; i < names.size(); i++) {
			totalScore += (i + 1) * alphabeticalValue(names.get(i));
		}
		assertThat(totalScore, is(871_198_282L));
	}

	private int alphabeticalValue(String string) {
		return string.chars()
				.map(c -> c - 'A' + 1)
				.sum();
	}

	private List<String> names = new ArrayList<>();

	@Before
	public void setup() throws Exception {
		String line = Files.lines(Paths.get(Euler22.class.getResource("p022_names.txt")
				.toURI()))
				.reduce("", String::concat);
		names = Arrays.stream(line.replaceAll("\"", "")
				.split(","))
				.map(String::toUpperCase)
				.sorted()
				.collect(Collectors.toList());

	}
}
