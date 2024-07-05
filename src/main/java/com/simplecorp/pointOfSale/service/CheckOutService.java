package com.simplecorp.pointOfSale.service;

import java.time.LocalDate;

import com.simplecorp.pointOfSale.RentalAgreement;
import com.simplecorp.pointOfSale.Tool;
import com.simplecorp.pointOfSale.exception.*;


public class CheckOutService {
		
	private RentalAgreementService rentalAgreementService = new RentalAgreementService();
		
	public void doCheckOut(String toolCode, int rentalDayCount, int discountPercent, LocalDate date ) throws InvalidInputValue {

		String validationErrorMsg = validateUserInput(toolCode, rentalDayCount, discountPercent);

		if(!validationErrorMsg.isEmpty()) {
			throw new InvalidInputValue(validationErrorMsg);
		}
		
		RentalAgreement rentalAgreement = rentalAgreementService.createRentalAgreement(toolCode, rentalDayCount, discountPercent, LocalDate.now());
		
		rentalAgreementService.printRentalAgreement(rentalAgreement);		
	}
	
	private String validateUserInput(String toolCode, int rentalDayCount, int discountPercent) {
		
		String invalidToolCodeMessage = "Tool code should be one of the values - CHNS, LADW, JAKD, JAKR. ";
		String invalidRentalDayCountMessage = "Rental day count should be at least one. ";
		String invalidDiscountPercentMessage = "Discount percent should be in the range of 0-100. ";
		StringBuilder errorMessage = new StringBuilder();
		
		if(!Tool.isValidToolCode(toolCode)) {
			errorMessage.append(invalidToolCodeMessage);	
		}
		if(rentalDayCount < 1) {
			errorMessage.append(invalidRentalDayCountMessage);
		}
		if(discountPercent < 0 || discountPercent > 100) {
			errorMessage.append(invalidDiscountPercentMessage);
		}
		
		return errorMessage.toString();
	}
}
