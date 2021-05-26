package com.revature.viewModels;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;


import com.revature.beans.Account;
import com.revature.beans.Customer;

import com.revature.beans.NegativeAmount;

public class AccountViewModel {

	private ArrayList<Account> accounts;
	//private ArrayList<Customer> customers; 
	String validationErrors = "";
	Boolean hasErrors = false;

	// an empty constructor
	public AccountViewModel() {
		this.accounts = new ArrayList<Account>();
		//this.customers = new ArrayList<Customer>();
		

	}

	// Save the new or updated account back to the collection
	// and return the form to Browsing mode
	public Boolean Add(Account cust) {

		validationErrors = "";
		hasErrors = false;

		// Validate the details of the account
		if (this.ValidateAccount(cust)) {


			// If the user is creating a new account,
			// add it to the collection 

			try {

				this.accounts.add(cust);

				validationErrors = "";
				hasErrors = false;
				
				//System.out.println("Account added to the list");

			} catch (Exception ex) {

				validationErrors = "Error ! this account was not added  : " + ex;
				hasErrors = true;

			}

		}else {
			validationErrors = "Error ! this account not did not succeed validation";
		}

		System.out.println(validationErrors);
		return !hasErrors;

	}

	public Boolean Edit(Account oldAcc, Account newAcc) {

		// If the user is editing the current account,
		// update it in the collection for the WCF Data Service

		validationErrors = "";
		hasErrors = false;

		// int index = this.accounts.indexOf(oldCust);

		int index = SearchAccount(oldAcc);

		if (index == -1) {

			hasErrors = true;
		}

		else {
			if (this.ValidateAccount(newAcc)) {
				
				try {
	
					this.accounts.set(index, newAcc);
	
					//validationErrors = "\n\n\t\t Account modified!";
					hasErrors = false;
	
				} catch (Exception ex) {
	
					validationErrors = "\t\t Error ! this account was not modified  : " + ex;
					hasErrors = true;
				}
			}

		}

		System.out.println(validationErrors);
		return !hasErrors;

	}

	
	public Boolean Delete(int accountNo) {
		
		int count = 0;
		try {
			
			for(Account c : accounts) {

				if (c.getAccountNo() == accountNo) {

						accounts.remove(count);
				

										
					return true;		
				}
				
				count++;
			}			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return false;
	}
	
	// Save the changes back to the data source
	public void Save() throws IOException {
		validationErrors = "";
		hasErrors = false;

		try {
			FileOutputStream fos = new FileOutputStream("Accounts.txt");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(accounts);
			validationErrors =  "\n\t\t\t        The serialized objects were written to the BankingDB.txt file.";
			oos.close();
			fos.close();
		} catch (IOException ioe) {
			validationErrors = "\n\t\t\t        The serialized object failed to be written to BankingDB.txt file.";
			ioe.printStackTrace();
		}

		System.out.println(validationErrors);

	}

	// TO deserialize the ArrayList
	public void getData() throws ClassNotFoundException {
		try {
			FileInputStream fis = new FileInputStream("Accounts.txt");
			ObjectInputStream ois = new ObjectInputStream(fis);

			accounts = (ArrayList<Account>) ois.readObject();

			validationErrors = "\n\t\t\t        Accounts were written to the BankingDB.txt file.";
			hasErrors = false;

			ois.close();
			fis.close();

			// Verify list data
			// for (account employee : accounts) {
			// System.out.println(employee);
			// }
		} catch (IOException ioe) {
			ioe.printStackTrace();
			validationErrors = "";

			hasErrors = true;
			return;
		} catch (ClassNotFoundException c) {
			validationErrors = "		Either account not found"
					+ " or The Account's data failed to be load from BankingDB.txt file.";
			c.printStackTrace();
			return;
		}

		System.out.println(validationErrors);

	}

	/*
	public void GetCustomers() throws ClassNotFoundException {
		try {
			FileInputStream fis = new FileInputStream("employeeData");
			ObjectInputStream ois = new ObjectInputStream(fis);

			customers = (ArrayList<Customer>) ois.readObject();

			validationErrors = "		customers were written to the BankingDB.txt file.";
			hasErrors = false;

			ois.close();
			fis.close();

			// Verify list data
			// for (Customer employee : customers) {
			// System.out.println(employee);
			// }
		} catch (IOException ioe) {
			ioe.printStackTrace();
			validationErrors = "";

			hasErrors = true;
			return;
		} catch (ClassNotFoundException c) {
			validationErrors = "		EitherCustomer not found"
					+ " or The Customer's data failed to be load from BankingDB.txt file.";
			c.printStackTrace();
			return;
		}

		System.out.println(validationErrors);

	}
	*/
	// this methode returns the index of the object found
	// in the list.
	public int SearchAccount(Account acc) {

		int index = 0;
		
		//System.out.println("List des account");
		//for(Account a : accounts) {
			//System.out.println(a.toString());
		//}

		//System.out.println("account to serach");
		//System.out.println(acc.toString());
		
		for (Account c : accounts) {

			if ((c.getAccountNo() == acc.getAccountNo()) ) {

				validationErrors = " Account found !";
				hasErrors = true;

				return index;

			} else {

				validationErrors = "Account not found........ ";
				hasErrors = false;
			}

			index++;

		}

		System.out.print(validationErrors);

		return -1;
	}

	// this method returns

	public Account getAccount(int index) {

		int count = 0;

		for (Account c : accounts) {

			if (index == count) {

				return c;
			}
			count++;
		}
		return null;
	}

	// This Method returns a list of Accounts.
	public ArrayList<Account> getAccounts() {

		return this.accounts;
	}

	// Utility method for copying the details of a account
	public void CopyAccount(Account destination, Account source) throws NegativeAmount
	{
	
		destination.setAccountNo(source.getAccountNo());
		destination.setCustomers(source.getCustomers());
		//destination.setEmployee(source.getEmployee());
		//destination.setUserName(source.getUserName());
		//destination.setPassWord(source.getPassWord());
		destination.deposit(source.getBalance());

	}

	// Methods for fetching and updating data
	// Helper method to validate account details
	private Boolean ValidateAccount(Account account) {
		validationErrors = "";
		hasErrors = false;
		
		
		//System.out.println(account.toString());
		
		
		//validationErrors = "Validate account method reached  : " ;
		ArrayList<Customer> custs = account.getCustomers();
		
		
		CustomerViewModel customers = new CustomerViewModel();
		

		int result = 0;



/*
		result = 0;

		Employee emp = account.getEmployee();
		EmployeeViewModel employees = new EmployeeViewModel();

		result = employees.SearchEmployee(emp);

		if (result == -1) {

			hasErrors = true;

		}

		try {
			int i = account.getAccountNo();

			if (i < 0) {

				hasErrors = true;
			}

		} catch (NumberFormatException nfe) {

			hasErrors = true;
		}

		try {
			double y = account.getBalance();

		} catch (NumberFormatException nfe) {

			hasErrors = true;
		}
*/


		System.out.println(validationErrors);

		return !hasErrors;
	}

	public Boolean IsNullOrWhiteSpace(String value) {

		return value == null || value.trim().isEmpty();
	}

}
