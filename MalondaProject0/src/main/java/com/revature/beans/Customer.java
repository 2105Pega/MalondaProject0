package com.revature.beans;

import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;
//import java.util.concurrent.atomic.AtomicInteger;

@SuppressWarnings("serial")
public class Customer implements java.io.Serializable {

	/**
	 * 
	 */
	// private int Id;
	private int CustomerNo;
	private String Title;
	private String FirstName;
	private String LastName;
	private String SSN;
	private String DOB;
	private String Address;
	private String ZipCode;
	private String EmailAddress;
	private String Phone;
	private String userName;
	private String passWord;
	private Date ModifiedDate;
	private Boolean IsActive;

	private static final AtomicInteger count = new AtomicInteger(0);

	/**
	 * 
	 */
	public Customer() {
		CustomerNo = count.incrementAndGet();
	}

	/**
	 * @param customerNo
	 * @param title
	 * @param firstName
	 * @param lastName
	 * @param sSN
	 * @param dOB
	 * @param address
	 * @param zipCode
	 * @param emailAddress
	 * @param phone
	 * @param modifiedDate
	 * @param isActive
	 */
	public Customer(int customerNo, String title, String firstName, String lastName, String sSN, String dOB,
			String address, String zipCode, String emailAddress, String phone, String userName, String passWord,
			Date modifiedDate) {

		// Id = count.incrementAndGet();
		CustomerNo = count.incrementAndGet();
		Title = title;
		FirstName = firstName;
		LastName = lastName;
		SSN = sSN;
		DOB = dOB;
		Address = address;
		ZipCode = zipCode;
		EmailAddress = emailAddress;
		Phone = phone;
		this.userName = userName;
		this.passWord = passWord;
		ModifiedDate = new Date();
		IsActive = true;
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

	public int getCustomerNo() {
		return CustomerNo;
	}

	public void setCustomerNo(int customerNo) {
		CustomerNo = customerNo;
	}

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public String getFirstName() {
		return FirstName;
	}

	public void setFirstName(String firstName) {
		FirstName = firstName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
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
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public String getZipCode() {
		return ZipCode;
	}

	public void setZipCode(String zipCode) {
		ZipCode = zipCode;
	}

	public String getEmailAddress() {
		return EmailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		EmailAddress = emailAddress;
	}

	public String getPhone() {
		return Phone;
	}

	public void setPhone(String phone) {
		Phone = phone;
	}

	public Date getModifiedDate() {
		return ModifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		ModifiedDate = modifiedDate;
	}

	public Boolean getIsActive() {
		return IsActive;
	}

	public void setIsActive(Boolean isActive) {
		IsActive = isActive;
	}

	@Override
	public String toString() {
		return "Customer [CustomerNo=" + CustomerNo + ", Title=" + Title + ", FirstName=" + FirstName + ", LastName="
				+ LastName + ", SSN=" + SSN + ", DOB=" + DOB + ", Address=" + Address + ", ZipCode=" + ZipCode
				+ ", EmailAddress=" + EmailAddress + ", Phone=" + Phone + ", userName =" + userName + ", Password =" + passWord 
				+ ", ModifiedDate=" + ModifiedDate
				+ ", IsActive=" + IsActive + "]";
	}

}
