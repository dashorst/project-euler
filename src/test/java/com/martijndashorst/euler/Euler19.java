package com.martijndashorst.euler;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.time.DayOfWeek;
import java.time.LocalDate;

import org.junit.Test;

/**
 * You are given the following information, but you may prefer to do some
 * research for yourself.
 * 
 * <ul>
 * <li>1 Jan 1900 was a Monday.
 * <li>Thirty days has September,
 * <li>April, June and November.
 * <li>All the rest have thirty-one,
 * <li>Saving February alone,
 * <li>Which has twenty-eight, rain or shine.
 * <li>And on leap years, twenty-nine.
 * <li>A leap year occurs on any year evenly divisible by 4, but not on a
 * century unless it is divisible by 400.
 * </ul>
 * 
 * How many Sundays fell on the first of the month during the twentieth century
 * (1 Jan 1901 to 31 Dec 2000)?
 * 
 */
public class Euler19 {
	@Test
	public void solution() {
		LocalDate start = LocalDate.of(1901, 1, 1);
		while(start.getDayOfWeek() != DayOfWeek.SUNDAY) {
			start = start.plusDays(1);
		}
		LocalDate end = LocalDate.of(2000,12,31);
		int numberOfSundaysAtStartOfMonth = 0;
		while(start.isBefore(end)) {
			if(start.getDayOfMonth() == 1) 
				numberOfSundaysAtStartOfMonth++;
			start = start.plusWeeks(1);
		}
		assertThat(numberOfSundaysAtStartOfMonth, is(171));
	}
}
