package com.simplecorp.pointOfSale.service;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.simplecorp.pointOfSale.RentalAgreement;
import com.simplecorp.pointOfSale.Tool;
import com.simplecorp.pointOfSale.ToolCharge;
import com.simplecorp.pointOfSale.utils.HolidayUtil;
import com.simplecorp.pointOfSale.utils.WeekendUtil;

/**
 * This service class creates Rental Agreement 
 */

public class RentalAgreementService {

	private RentalAgreement rentalAgreement = new RentalAgreement();	
	public static Map<String, ToolCharge> toolChargeMap = new HashMap<>();
	
	static {
		toolChargeMap.put("Ladder", new ToolCharge("Ladder", 1.99, true, true, false));
		toolChargeMap.put("Chainsaw", new ToolCharge("Chainsaw", 1.49, true, false, true));
		toolChargeMap.put("Jackhammer", new ToolCharge("Jackhammer", 2.99, true, false, false));
	}
	
	/*
	 * 	
	 * @param toolCode
	 * @param rentalDayCnt
	 * @param discntPercent
	 * @param checkoutDate
	 * @return RentalAgreement
	 */
	public RentalAgreement createRentalAgreement(String toolCode, 
												 int rentalDayCnt, 
												 int discntPercent, 
												 LocalDate checkoutDate) {		
		LocalDate dueDate = checkoutDate.plusDays(rentalDayCnt);
		String toolType = Tool.valueOf(toolCode).getToolType();
		ToolCharge toolCharge = toolChargeMap.get(toolType);
		int chargeDays = getChargeDays(toolCharge, checkoutDate, rentalDayCnt);

		double preDiscountAmount = toolCharge.getDailyCharge() * chargeDays;
		double discountAmount = preDiscountAmount * discntPercent / 100;
		double finalCharge = preDiscountAmount - discountAmount;
		
		RentalAgreement rentalAgreement = new RentalAgreement();
		
		// Populate RentalAgreement
		rentalAgreement.setToolCode(toolCode);
		rentalAgreement.setToolType(toolType);
		rentalAgreement.setBrand(Tool.valueOf(toolCode).getBrand());
		rentalAgreement.setRentalDayCount(rentalDayCnt);
		rentalAgreement.setCheckoutDate(checkoutDate);
		rentalAgreement.setDueDate(checkoutDate.plusDays(rentalDayCnt));
		rentalAgreement.setDailyRentalCharge(toolCharge.getDailyCharge());
		rentalAgreement.setChargeDays(chargeDays);
		rentalAgreement.setPreDiscntCharge(preDiscountAmount);
		rentalAgreement.setDiscntPercent(discntPercent);
		rentalAgreement.setDiscntAmount(discountAmount);
		rentalAgreement.setFinalCharge(finalCharge);
		
		return rentalAgreement;
	}
	
	/**
	 * 
	 * Print rental agreement to console
	 */
	public void printRentalAgreement(RentalAgreement rentalAgreement) {
		System.out.println("Rental Agreement:");
		System.out.println("Tool code: " + rentalAgreement.getToolCode());
		System.out.println("Tool Type: " + rentalAgreement.getToolType());
		System.out.println("Tool brand: " + rentalAgreement.getBrand());
		System.out.println("Rental days: " + rentalAgreement.getRentalDayCount());
		System.out.println("Check out date: " + formatLocalDate(rentalAgreement.getCheckoutDate()));
		System.out.println("Due date: " + formatLocalDate(rentalAgreement.getDueDate()));
		System.out.println("Daily rental charge: " + formatCurrency(rentalAgreement.getDailyRentalCharge()));
		System.out.println("Charge days: " + rentalAgreement.getChargeDays());
		System.out.println("Pre-discount charge: " + formatCurrency(rentalAgreement.getPreDiscntCharge()));
		System.out.println("Discount percent: " + formatPercent(rentalAgreement.getDiscntPercent()));
		System.out.println("Discount amount: " + formatCurrency(rentalAgreement.getDiscntAmount()));
		System.out.println("Final charge: " + formatCurrency(rentalAgreement.getFinalCharge()));
		System.out.println();
	}
	
	/**
	 * 
	 * @param toolCharge
	 * @param checkoutDate
	 * @param rentalDayCnt
	 * @return chargeDays
	 */
	private int getChargeDays(ToolCharge toolCharge, LocalDate checkoutDate, int rentalDayCnt) {
		int chargeDays = 0;
		LocalDate startChargeDate = checkoutDate.plusDays(1);
		LocalDate endChargeDate = checkoutDate.plusDays(rentalDayCnt + 1);
		
		for (LocalDate date = startChargeDate; date.isBefore(endChargeDate); date = date.plusDays(1))
		{
			chargeDays = isChargeableForGivenDate(toolCharge, date) ? chargeDays + 1 : chargeDays;
		}
		
		return chargeDays;
		
	}
	
	/**
	 * 
	 * @param toolCharge
	 * @param date
	 * @return chargeable flag
	 */
	private boolean isChargeableForGivenDate(ToolCharge toolCharge, LocalDate date) {
		
		if(WeekendUtil.isWeekend(date)) {
			return toolCharge.isWeekendCharge() ? true : false;
		}
		else if(HolidayUtil.isHoliday(date)) {
			return toolCharge.isHolidayCharge() ? true : false;
		}
		else {
			return toolCharge.isWeekdayCharge() ? true : false;
		}	
	}
	
	private String formatLocalDate(LocalDate date) {
		DateTimeFormatter formatters = DateTimeFormatter.ofPattern("MM/dd/yy");
		return date.format(formatters);
	}
	
	private String formatCurrency(double amt) {
		NumberFormat formatter = NumberFormat.getCurrencyInstance();
		return formatter.format(amt);
	}
	
	private String formatPercent(double num) {
		DecimalFormat df = new DecimalFormat("##.##%");
		double percent = (num / 100);
		return df.format(percent);
	}

}
