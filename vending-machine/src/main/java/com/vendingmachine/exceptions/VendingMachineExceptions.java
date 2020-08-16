package com.vendingmachine.exceptions;

public class VendingMachineExceptions extends RuntimeException {
	
	private String message;

	public VendingMachineExceptions(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	

}
