package com.simplecorp.pointOfSale.utils;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoField;

public class WeekendUtil {
	
	public static boolean isWeekend(LocalDate date) {		
	      DayOfWeek day = DayOfWeek.of(date.get(ChronoField.DAY_OF_WEEK));
	      switch (day) {
	         case SATURDAY:
	         case SUNDAY:
	            return true;
	         default:
	            return false;
	      }
	} 
}
