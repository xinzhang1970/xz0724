package com.simplecorp.pointOfSale;

import java.time.LocalDate;

public class RentalAgreement {
	private String toolCode;
	private String toolType;
	private String brand;
	private int rentalDayCount;
	private LocalDate checkoutDate;
	private LocalDate dueDate;
	private double dailyRentalCharge;
	private int chargeDays;
	private double preDiscntCharge;
	private int discntPercent;
	private double discntAmount;
	private double finalCharge;
	
	public String getToolCode() {
		return toolCode;
	}
	public void setToolCode(String toolCode) {
		this.toolCode = toolCode;
	}
	public String getToolType() {
		return toolType;
	}
	public void setToolType(String toolType) {
		this.toolType = toolType;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public int getRentalDayCount() {
		return rentalDayCount;
	}
	public void setRentalDayCount(int rentalDayCount) {
		this.rentalDayCount = rentalDayCount;
	}
	public LocalDate getCheckoutDate() {
		return checkoutDate;
	}
	public void setCheckoutDate(LocalDate checkoutDate) {
		this.checkoutDate = checkoutDate;
	}
	public LocalDate getDueDate() {
		return dueDate;
	}
	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}
	public double getDailyRentalCharge() {
		return dailyRentalCharge;
	}
	public void setDailyRentalCharge(double dailyRentalCharge) {
		this.dailyRentalCharge = dailyRentalCharge;
	}
	public int getChargeDays() {
		return chargeDays;
	}
	public void setChargeDays(int chargeDays) {
		this.chargeDays = chargeDays;
	}
	public double getPreDiscntCharge() {
		return preDiscntCharge;
	}
	public void setPreDiscntCharge(double preDiscntCharge) {
		this.preDiscntCharge = preDiscntCharge;
	}
	public int getDiscntPercent() {
		return discntPercent;
	}
	public void setDiscntPercent(int discntPercent) {
		this.discntPercent = discntPercent;
	}
	public double getDiscntAmount() {
		return discntAmount;
	}
	public void setDiscntAmount(double discntAmount) {
		this.discntAmount = discntAmount;
	}
	public double getFinalCharge() {
		return finalCharge;
	}
	public void setFinalCharge(double finalCharge) {
		this.finalCharge = finalCharge;
	}
	
	@Override
	public String toString() {
		return "RentalAgreement [toolCode=" + toolCode + ", toolType=" + toolType + ", brand=" + brand
				+ ", rentalDayCount=" + rentalDayCount + ", checkoutDate=" + checkoutDate + ", dueDate=" + dueDate
				+ ", dailyRentalCharge=" + dailyRentalCharge + ", chargeDays=" + chargeDays + ", preDiscntCharge="
				+ preDiscntCharge + ", discntPercent=" + discntPercent + ", discntAmount=" + discntAmount
				+ ", finalCharge=" + finalCharge + "]";
	}
	
	
}
