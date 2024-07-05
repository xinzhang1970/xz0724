package com.simplecorp.pointOfSale.service;

import java.time.LocalDate;

import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

import com.simplecorp.pointOfSale.RentalAgreement;
import com.simplecorp.pointOfSale.exception.InvalidInputValue;


public class RentalAgreementServiceTest {

	RentalAgreementService rentalAgreementService = new RentalAgreementService();

	@Test 
	public void createRentalAgreementTest2() { 
		  
		RentalAgreement rentalAgreement = rentalAgreementService.createRentalAgreement("LADW", 3, 10, LocalDate.of(2020,7,2)); 
		
		assertEquals("LADW", rentalAgreement.getToolCode()); 
		assertEquals("Ladder", rentalAgreement.getToolType()); 
		assertEquals("Werner", rentalAgreement.getBrand()); 
		assertEquals(3, rentalAgreement.getRentalDayCount()); 
		assertEquals(LocalDate.of(2020, 7, 2), rentalAgreement.getCheckoutDate()); 
		assertEquals(LocalDate.of(2020, 7, 5), rentalAgreement.getDueDate()); 
		assertEquals(1.99, rentalAgreement.getDailyRentalCharge(), 0.005); 
		assertEquals(2, rentalAgreement.getChargeDays()); 
		assertEquals(3.98, rentalAgreement.getPreDiscntCharge(), 0.005); 
		assertEquals(10, rentalAgreement.getDiscntPercent()); 
		assertEquals(0.40, rentalAgreement.getDiscntAmount(), 0.005); 
		assertEquals(3.58, rentalAgreement.getFinalCharge(), 0.005);  
	}

	@Test 
	public void createRentalAgreementTest3() { 
		  
		RentalAgreement rentalAgreement = rentalAgreementService.createRentalAgreement("CHNS", 5, 25, LocalDate.of(2015,7,2)); 
		
		assertEquals("CHNS", rentalAgreement.getToolCode()); 
		assertEquals("Chainsaw", rentalAgreement.getToolType()); 
		assertEquals("Stihl", rentalAgreement.getBrand()); 
		assertEquals(5, rentalAgreement.getRentalDayCount()); 
		assertEquals(LocalDate.of(2015, 7, 2), rentalAgreement.getCheckoutDate()); 
		assertEquals(LocalDate.of(2015, 7, 7), rentalAgreement.getDueDate()); 
		assertEquals(1.49, rentalAgreement.getDailyRentalCharge(), 0.005); 
		assertEquals(3, rentalAgreement.getChargeDays()); 
		assertEquals(4.47, rentalAgreement.getPreDiscntCharge(), 0.005); 
		assertEquals(25, rentalAgreement.getDiscntPercent()); 
		assertEquals(1.12, rentalAgreement.getDiscntAmount(), 0.005); 
		assertEquals(3.35, rentalAgreement.getFinalCharge(), 0.005);	  
	}

	
	@Test 
	public void createRentalAgreementTest4() { 
		  
		RentalAgreement rentalAgreement = rentalAgreementService.createRentalAgreement("JAKD", 6, 0, LocalDate.of(2015,9,3)); 
		
		assertEquals("JAKD", rentalAgreement.getToolCode()); 
		assertEquals("Jackhammer", rentalAgreement.getToolType()); 
		assertEquals("DeWalt", rentalAgreement.getBrand()); 
		assertEquals(6, rentalAgreement.getRentalDayCount()); 
		assertEquals(LocalDate.of(2015, 9, 3), rentalAgreement.getCheckoutDate()); 
		assertEquals(LocalDate.of(2015, 9, 9), rentalAgreement.getDueDate()); 
		assertEquals(2.99, rentalAgreement.getDailyRentalCharge(), 0.005); 
		assertEquals(3, rentalAgreement.getChargeDays()); 
		assertEquals(8.97, rentalAgreement.getPreDiscntCharge(), 0.005); 
		assertEquals(0, rentalAgreement.getDiscntPercent()); 
		assertEquals(0, rentalAgreement.getDiscntAmount(), 0.005); 
		assertEquals(8.97, rentalAgreement.getFinalCharge(), 0.005);	  
	}

	
	@Test 
	public void createRentalAgreementTest5() { 
		  
		RentalAgreement rentalAgreement = rentalAgreementService.createRentalAgreement("JAKR", 9, 0, LocalDate.of(2015,7,2)); 
		
		assertEquals("JAKR", rentalAgreement.getToolCode()); 
		assertEquals("Jackhammer", rentalAgreement.getToolType()); 
		assertEquals("Ridgid", rentalAgreement.getBrand()); 
		assertEquals(9, rentalAgreement.getRentalDayCount()); 
		assertEquals(LocalDate.of(2015, 7, 2), rentalAgreement.getCheckoutDate()); 
		assertEquals(LocalDate.of(2015, 7, 11), rentalAgreement.getDueDate()); 
		assertEquals(2.99, rentalAgreement.getDailyRentalCharge(), 0.005); 
		assertEquals(5, rentalAgreement.getChargeDays()); 
		assertEquals(14.95, rentalAgreement.getPreDiscntCharge(), 0.005); 
		assertEquals(0, rentalAgreement.getDiscntPercent()); 
		assertEquals(0.00, rentalAgreement.getDiscntAmount(), 0.005); 
		assertEquals(14.95, rentalAgreement.getFinalCharge(), 0.005);	  
	}

	
	@Test 
	public void createRentalAgreementTest6() { 
		  
		RentalAgreement rentalAgreement = rentalAgreementService.createRentalAgreement("JAKR", 4, 50, LocalDate.of(2020,7,2)); 		

		assertEquals("JAKR", rentalAgreement.getToolCode()); 
		assertEquals("Jackhammer", rentalAgreement.getToolType()); 
		assertEquals("Ridgid", rentalAgreement.getBrand()); 
		assertEquals(4, rentalAgreement.getRentalDayCount()); 
		assertEquals(LocalDate.of(2020, 7, 2), rentalAgreement.getCheckoutDate()); 
		assertEquals(LocalDate.of(2020, 7, 6), rentalAgreement.getDueDate()); 
		assertEquals(2.99, rentalAgreement.getDailyRentalCharge(), 0.005); 
		assertEquals(1, rentalAgreement.getChargeDays()); 
		assertEquals(2.99, rentalAgreement.getPreDiscntCharge(), 0.005); 
		assertEquals(50, rentalAgreement.getDiscntPercent()); 
		assertEquals(1.50, rentalAgreement.getDiscntAmount(), 0.005); 
		assertEquals(1.50, rentalAgreement.getFinalCharge(), 0.005);
	}

}
