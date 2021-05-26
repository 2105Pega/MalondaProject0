package com.revature.beans;


import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

@SuppressWarnings("serial")
public class Account implements java.io.Serializable{

	private int accountNo;
	private ArrayList<Customer> customers;
	private double balance;

	private static final AtomicInteger count = new AtomicInteger(0);

	/**
	 * 
	 */
	public Account() {
		
		this.accountNo = count.incrementAndGet();
		this.balance = 0.0;
	}

	/**
	 * @param accountNo
	 * @param customers
	 * @param balance
	 */
	public Account(int accountNo, ArrayList<Customer> customers,  
			double balance) {
		this.accountNo = count.incrementAndGet();
		this.customers = customers;
		this.balance = balance;

	}

	public int getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(int accountNo) {
		this.accountNo = accountNo;
	}

	public ArrayList<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(ArrayList<Customer> customers) {
		this.customers = customers;
	}

	public double getBalance() {
		return balance;
	}
	
	public void withdraw(double amount)
			throws NegativeAmount
	{
		if (amount < 0)
	         throw new NegativeAmount(amount); 
		
		this.balance -= amount;
	}

	public void deposit(double amount) throws NegativeAmount
	{
		if (amount < 0)
	         throw new NegativeAmount(amount); 
		
		this.balance += amount;
	}

	@Override
	public String toString() {
		return "Account [accountNo=" + accountNo + ", userName="  + ", balance="
				+ balance + "]";
	}

}
