package com.simplecorp.pointOfSale.utils;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.ZoneId;
import java.util.Calendar;

/**
 * Util class to check if given date is Independence day or Labor day
 */
public class HolidayUtil {
	
	private static Calendar calendar = Calendar.getInstance();
	
	/**
	 * Check if the date is Labor day (first Monday of September) 
	 * @param date
	 * @return boolean
	 */
	public static boolean isHoliday(LocalDate date) {	
		return isLaborDay(date) || 
				isIndependenceDay(date) || 
				isObservedIndependenceDay(date);		
	} 
	
	/**
	 * Check if the date is Independence Day (July 4th)
	 * If falls on weekend, it is observed on the closest weekday 
	 * (if Sat,then Friday before, if Sunday, then Monday after)
	 * @param date
	 * @return boolean
	 */
	private static boolean isIndependenceDay(LocalDate date) {
		LocalDate independencyDay = LocalDate.of(date.getYear(), 7, 4);
		return date.equals(independencyDay);
	}
	
	private static boolean isObservedIndependenceDay(LocalDate date) {
		LocalDate independencyDay = LocalDate.of(date.getYear(), 7, 4);
		DayOfWeek dayOfWeek = independencyDay.getDayOfWeek();
		LocalDate observedIndependenceDay = independencyDay;
		
		switch (dayOfWeek) { 
			case SATURDAY:
				observedIndependenceDay = independencyDay.minusDays(1L);
				break;
			case SUNDAY:
				observedIndependenceDay = independencyDay.plusDays(1L);
				break;
			default:
				break;
		}
		return !observedIndependenceDay.equals(independencyDay) && 
				date.equals(observedIndependenceDay);
	}
	
	private static boolean isLaborDay(LocalDate date) {
		calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
		calendar.set(Calendar.DAY_OF_WEEK_IN_MONTH, 1);
		calendar.set(Calendar.MONTH, Month.SEPTEMBER.getValue()-1);
		calendar.set(Calendar.YEAR, date.getYear());
		
		LocalDate laborDay = LocalDate.ofInstant(calendar.toInstant(), ZoneId.systemDefault());
		
		return date.equals(laborDay);
	}
	
}
