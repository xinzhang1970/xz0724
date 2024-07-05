package com.simplecorp.pointOfSale.utils;

import org.junit.Test;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import java.time.LocalDate;
import com.simplecorp.pointOfSale.utils.HolidayUtil;


public class HolidayUtilTest {

	@Test
	public void isHolidayReturnsFalseWhenDateIsJuly2nd2015() {
		// 7/2/15 is Thursday
		LocalDate localDate = LocalDate.of(2015, 7, 2);
		boolean isHoliday = HolidayUtil.isHoliday(localDate);
		assertFalse(isHoliday);	
	}
	
	@Test
	public void isHolidayReturnsFalseWhenDateIsSepd3r2015() {
		// 9/3/15 Thursday
		LocalDate localDate = LocalDate.of(2015, 9, 3);
		boolean isHoliday = HolidayUtil.isHoliday(localDate);
		assertFalse(isHoliday);	
	}
	
	@Test
	public void isHolidayReturnsFalseWhenDateIsJuly4th2016() {
		// 7/4/16 Monday
		LocalDate localDate = LocalDate.of(2016, 7, 4);
		boolean isHoliday = HolidayUtil.isHoliday(localDate);
		assertTrue(isHoliday);	
	}	
	
	@Test
	public void isHolidayReturnsFalseWhenDateIsJuly2nd2020() {
		// 7/2/20 Thursday
		LocalDate localDate = LocalDate.of(2020, 7, 2);
		boolean isHoliday = HolidayUtil.isHoliday(localDate);
		assertFalse(isHoliday);	
	}
	
	@Test
	public void isHolidayReturnsFalseWhenDateIsJuly4th2020() {
		// 7/4/20 SATURDAY - should return 7/3 Friday
		LocalDate localDate = LocalDate.of(2020, 7, 4);
		boolean isHoliday = HolidayUtil.isHoliday(localDate);
		assertTrue(isHoliday);	
	}
	
	
	@Test
	public void isHolidayReturnsFalseWhenDateIsSep3rd2020() {		
		// 9/3/20 Thursday
		LocalDate localDate = LocalDate.of(2020, 8, 3);
		boolean isHoliday = HolidayUtil.isHoliday(localDate);
		assertFalse(isHoliday);	
	}
	
	@Test
	public void isHolidayReturnsFalseWhenDateIsSep7th2020() {
		// 9/7/20 first MONDAY OF SEPTEMBER		
		LocalDate localDate = LocalDate.of(2020, 9, 7);
		boolean isHoliday = HolidayUtil.isHoliday(localDate);
		assertTrue(isHoliday);	
	}
}
