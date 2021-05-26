package com.revature.beans;

import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

@SuppressWarnings("serial")
public class Employee implements java.io.Serializable{
	
	private int employeeNo;
	private String Title;
	private String firstName;
	private String lastName;
	private String SSN;
	private String DOB;
	private String address;
	private String city;
	private String state;
	private String zipCode;
    private String EmailAddress ;
    private String Phone ;
    private String userName;
    private String passWord;
	private Date ModifiedDate ;
	private Boolean isManager;

	private static final AtomicInteger count = new AtomicInteger(0);

	
	
	/**
	 * 
	 */
	public Employee() {
		
		this.employeeNo = count.incrementAndGet();
	}
	




	/**
	 * @param employeeNo
	 * @param title
	 * @param firstName
	 * @param lastName
	 * @param sSN
	 * @param dOB
	 * @param address
	 * @param city
	 * @param state
	 * @param zipCode
	 * @param emailAddress
	 * @param phone
	 * @param modifiedDate
	 * @param isManager
	 */
	public Employee(int employeeNo, String title, String firstName, String lastName, String sSN, String dOB,
			String address, String city, String state, String zipCode, String emailAddress, String phone,
		    String userName, String passWord, Date modifiedDate, Boolean isManager) {
		this.employeeNo = count.incrementAndGet();;
		Title = title;
		this.firstName = firstName;
		this.lastName = lastName;
		SSN = sSN;
		DOB = dOB;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zipCode = zipCode;
		EmailAddress = emailAddress;
		Phone = phone;
	    this.userName = userName;
	    this.passWord  = passWord;
		this.ModifiedDate = modifiedDate;
		this.isManager = isManager;
		
	}


	
	
	public String getUserName() {
		return userName;
	}





	public void setUserName(String userName) {
		this.userName = userName;
	}





	public String getPassWord() {
		return passWord;
	}





	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}





	public String getTitle() {
		return Title;
	}


	public void setTitle(String title) {
		Title = title;
	}


	public String getPhone() {
		return Phone;
	}


	public void setPhone(String phone) {
		Phone = phone;
	}


	public String getEmailAddress() {
		return EmailAddress;
	}


	public void setEmailAddress(String emailAddress) {
		EmailAddress = emailAddress;
	}




	public int getEmployeeNo() {
		return employeeNo;
	}
	public void setEmployeeNo(int employeeNo) {
		this.employeeNo = employeeNo;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getSSN() {
		return SSN;
	}
	public void setSSN(String sSN) {
		SSN = sSN;
	}
	public String getDOB() {
		return DOB;
	}
	public void setDOB(String dOB) {
		DOB = dOB;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	public Date getModifiedDate() {
		return ModifiedDate;
	}
	public void setModifiedDate(Date modifiedDate) {
		ModifiedDate = modifiedDate;
	}
	public Boolean getIsManager() {
		return isManager;
	}
	public void setIsManager(Boolean isManager) {
		this.isManager = isManager;
	}
	
	@Override
	public String toString() {
		return "Employee [employeeNo=" + employeeNo + ", Title=" + Title + ", firstName=" + firstName + ", lastName="
				+ lastName + ", SSN=" + SSN + ", DOB=" + DOB + ", address=" + address + ", city=" + city + ", state="
				+ state + ", zipCode=" + zipCode + ", EmailAddress=" + EmailAddress + ", Phone=" + Phone
				+ ", userName =" + userName + ", Password =" + passWord + ", ModifiedDate=" + ModifiedDate + ", isManager=" + isManager + "]";
	}

	
	
}
