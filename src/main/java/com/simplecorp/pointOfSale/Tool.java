package com.simplecorp.pointOfSale;

import java.util.Arrays;
import java.util.stream.Collectors;

public enum Tool {
	CHNS("Chainsaw", "Stihl"), 
	LADW("Ladder", "Werner"), 
	JAKD("Jackhammer", "DeWalt"), 
	JAKR("Jackhammer", "Ridgid"); 

	private final String toolType;
	private final String brand;
	
	Tool(String toolType, String brand) {
		this.toolType = toolType;
		this.brand = brand;
	}

	public String getToolType() {
		return toolType;
	}

	public String getBrand() {
		return brand;
	}
	
	 public static boolean isValidToolCode(final String toolCode) {
		 return Arrays.stream(Tool.values())
		        .map(Tool::name)
		        .collect(Collectors.toSet())
		        .contains(toolCode);
	}
	
}
