package com.simplecorp.pointOfSale.utils;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import java.time.LocalDate;
import org.junit.Test;
import com.simplecorp.pointOfSale.utils.WeekendUtil;

public class WeekendUtilTest {

	@Test
	public void isWeekendReturnsFalseWhenDateIsJuly2nd2015() {
		// 7/2/15 is Thursday
		LocalDate localDate = LocalDate.of(2015, 7, 2);
		boolean isWeekend = WeekendUtil.isWeekend(localDate);
		assertFalse(isWeekend);	
	}
	
	@Test
	public void isWeekendReturnsFalseWhenDateIsSepd3r2015() {
		// 9/3/15 Thursday
		LocalDate localDate = LocalDate.of(2015, 9, 3);
		boolean isWeekend = WeekendUtil.isWeekend(localDate);
		assertFalse(isWeekend);	
	}
	
	@Test
	public void isWeekendReturnsFalseWhenDateIsJuly4th2016() {
		// 7/4/16 Monday
		LocalDate localDate = LocalDate.of(2016, 7, 4);
		boolean isWeekend = WeekendUtil.isWeekend(localDate);
		assertFalse(isWeekend);	
	}	
	
	@Test
	public void isWeekendReturnsFalseWhenDateIsJuly2nd2020() {
		// 7/2/20 Thursday
		LocalDate localDate = LocalDate.of(2020, 7, 2);
		boolean isWeekend = WeekendUtil.isWeekend(localDate);
		assertFalse(isWeekend);	
	}
	
	@Test
	public void isWeekendReturnsFalseWhenDateIsJuly4th2020() {
		// 7/4/20 SATURDAY - should return 7/3 Friday
		LocalDate localDate = LocalDate.of(2020, 7, 4);
		boolean isWeekend = WeekendUtil.isWeekend(localDate);
		assertTrue(isWeekend);	
	}
	
	
	@Test
	public void isWeekendReturnsFalseWhenDateIsSep3rd2020() {		
		// 9/3/20 Thursday
		LocalDate localDate = LocalDate.of(2020, 8, 3);
		boolean isWeekend = WeekendUtil.isWeekend(localDate);
		assertFalse(isWeekend);	
	}
	
	@Test
	public void isWeekendReturnsFalseWhenDateIsSep7th2020() {
		// 9/7/20 first MONDAY OF SEPTEMBER		
		LocalDate localDate = LocalDate.of(2020, 9, 7);
		boolean isWeekend = WeekendUtil.isWeekend(localDate);
		assertFalse(isWeekend);	
	}
}
