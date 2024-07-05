package com.simplecorp.pointOfSale.service;

import java.time.LocalDate;

import org.junit.Assert;
import org.junit.Test;

import com.simplecorp.pointOfSale.exception.InvalidInputValue;

public class CheckOutServiceTest {

	CheckOutService checkoutService = new CheckOutService();
	
	@Test
	public void createRentalAgreementTest1ShouldThrowException() {
		Assert.assertThrows(InvalidInputValue.class, () -> {
			checkoutService.doCheckOut("JAKR", 5, 101, LocalDate.of(2015, 9, 3));	
		});
	}
}
