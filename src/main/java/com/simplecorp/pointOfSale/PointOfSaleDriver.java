package com.simplecorp.pointOfSale;

import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.simplecorp.pointOfSale.exception.InvalidInputValue;
import com.simplecorp.pointOfSale.service.CheckOutService;


/**
 * The driver class takes user input for tool code, rental day count and
 * discount percent and then invoke doCheckOut of CheckOutService
 */
public class PointOfSaleDriver {

	private static String continueFlag = "1";
	private static String toolCode;
	private static int rentalDayCount;
	private static int discountPercent;

	private static Scanner in = new Scanner(System.in);
	private static CheckOutService checkOutService = new CheckOutService();

	public static void main(String[] args) {
		
		 do {
			try {
				getRentalDetailsFromUser();
			
				checkOutService.doCheckOut(toolCode, rentalDayCount, discountPercent, LocalDate.now());
			}
			catch(InvalidInputValue | NumberFormatException | InputMismatchException e) {
				System.out.println(e.getMessage());
			}
			
			checkIfReadyToShutdown();
			
		} while(continueFlag.equals("1"));	 
		
		System.out.println("All done");
	}

	/*
	 * Prompt user to check if ready to shutdown the point of sale system 
	 */
	private static void checkIfReadyToShutdown() {
		System.out.println("Continue to checkout? Please enter 1 for continue, 0 for shutdown: ");
		in.nextLine(); // throw away the new line 
		continueFlag = in.nextLine();
	}
	
	/*
	 * Prompt user for tool code, rental day count, and discount percent
	 */
	private static void getRentalDetailsFromUser() throws InvalidInputValue {
		System.out.println("Please enter tool code (CHNS, LADW, JAKD, JAKR): ");
		toolCode = in.nextLine();
		
		try {
		System.out.println("Please enter rental day count (at least one): ");
		rentalDayCount = in.nextInt();
		
		System.out.println("Please enter discount percent (0-100): ");
		discountPercent = in.nextInt();
		}
		catch (InputMismatchException e) {
			throw new InvalidInputValue("Please input integer.");
		}
	}

}
