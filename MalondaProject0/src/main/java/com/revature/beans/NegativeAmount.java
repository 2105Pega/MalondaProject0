package com.revature.beans;

public class NegativeAmount extends Exception {
	/**
	 * This constructor uses a generic error message.
	 */

	public NegativeAmount() {
		super(" Error: Negative amount");
	}

	/**
	 * This constructor specifies the bad starting balance in the error message.
	 * 
	 * @param The bad starting balance.
	 */

	public NegativeAmount(double amount) {
		super(" Error: Negative amount : " + amount);
	}
}
