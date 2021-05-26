package com.revature.beans;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

@SuppressWarnings("serial")
public class Application implements java.io.Serializable{
	
	
	private int applicationNo;
	private ArrayList<Customer> customers;
	private Employee employee;
	private Boolean isValide;
	private Boolean isActive;

	private static final AtomicInteger count = new AtomicInteger(0);
	
	public Application() {
		
		this.applicationNo = count.incrementAndGet();
		this.isActive = true;
		this.isValide = false;
		employee = new Employee();
	}
	
	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	/**
	 * @param accountNo
	 * @param customers
	 * @param balance
	 */
	
	public Application(int accountNo, ArrayList<Customer> customers,  
			Boolean isValide, Boolean isActive) {
		this.applicationNo = count.incrementAndGet();
		this.customers = customers;
		this.isValide = isValide;
		this.isActive = isActive;

	}

	public int getApplicationNo() {
		return applicationNo;
	}

	public void setApplicationNo(int applicationNo) {
		this.applicationNo = applicationNo;
	}

	public ArrayList<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(ArrayList<Customer> customers) {
		this.customers = customers;
	}

	public Boolean getIsValide() {
		return isValide;
	}

	public void setIsValide(Boolean isValide) {
		this.isValide = isValide;
	}
	
}
