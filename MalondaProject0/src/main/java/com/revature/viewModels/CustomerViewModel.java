package com.revature.viewModels;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.revature.beans.Customer;



public class CustomerViewModel {

	private ArrayList<Customer> customers;
	String validationErrors = "";
	Boolean hasErrors = false;

	// an empty constructor
	public CustomerViewModel() {
		this.customers = new ArrayList<Customer>();

	}

	// Save the new or updated customer back to the WCF Data Service
	// and return the form to Browsing mode
	public Boolean Add(Customer cust) {

		validationErrors = "";
		hasErrors = false;

		// Validate the details of the Customer
		if (this.ValidateCustomer(cust)) {
			// Only continue if the customer details are valid
			// this.IsBusy = true;

			// If the user is creating a new customer,
			// add it to the collection for the WCF Data Service

			try {

				this.customers.add(cust);

				validationErrors = " ";
				hasErrors = false;

			} catch (Exception ex) {

				validationErrors = "Error ! this customer was not added  : " + ex;
				hasErrors = true;

			}

		}

		System.out.println(validationErrors);
		return !hasErrors;

	}

	public Boolean Edit(Customer oldCust, Customer newCust) {

		// If the user is editing the current customer,
		// update it in the collection for the WCF Data Service

		validationErrors = "";
		hasErrors = false;

		// int index = this.customers.indexOf(oldCust);

		int index = SearchCustomer(oldCust);

		if (index == -1) {

			hasErrors = true;
		}

		else {

			if (this.ValidateCustomer(newCust)) {
				try {
	
					this.customers.set(index, newCust);
	
					validationErrors = "\n\n\t\t Customer modified!";
					hasErrors = false;
	
				} catch (Exception ex) {
	
					validationErrors = "\t\t Error ! this customer was not modified  : " + ex;
					hasErrors = true;
				}
			}

		}

		System.out.println(validationErrors);
		return !hasErrors;

	}

	
	public Boolean Delete(int customerNo) {
		
		int count = 0;
		try {
			
			System.out.println(" to delete : " + customerNo + " empty " + customers.isEmpty());
			
			for(Customer c : customers) {
				if (c.getCustomerNo() == customerNo) {
					
					
					customers.remove(count);
										
					return true;		
				}
				
				count++;
			}
			
			Save();
			getData();
			
			
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
			FileOutputStream fos = new FileOutputStream("Customers.txt");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(customers);
			validationErrors = "		 The serialized objects were written to the Customers.txt file.";
			oos.close();
			fos.close();
		} catch (IOException ioe) {
			validationErrors = "The serialized object failed to be written to Customers.txt file.";
			ioe.printStackTrace();
		}

		System.out.println(validationErrors);

	}

	// TO deserialize the ArrayList
	public void getData() throws ClassNotFoundException {
		try {
			FileInputStream fis = new FileInputStream("Customers.txt");
			ObjectInputStream ois = new ObjectInputStream(fis);

			customers = (ArrayList<Customer>) ois.readObject();

			validationErrors = "		customers were written to the Customers.txt file.";
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
					+ " or The Customer's data failed to be load from Customers.txt file.";
			c.printStackTrace();
			return;
		}

		System.out.println(validationErrors);

	}

	
	public void setData(ArrayList<Customer> c) {
		
		customers = c;
	}
	// this methode returns the index of the cobject found
	// in the list.
	public int SearchCustomer(Customer cust) {

		int index = 0;
		int result = 0; 
		
		//validationErrors = " Search Method " + cust.toString();
		
		for (Customer c : customers) {
			
			//result = customers.SearchCustomer(c);
			
			System.out.println("Customers view model data " + c.toString());

			if (result == -1)
				hasErrors = true;

		}
		
		index = 0;
		
		for (Customer c : customers) {
			
			validationErrors = " If of Search Method Customer View Model reached !";
			if ((c.getCustomerNo() == cust.getCustomerNo()) && (c.getSSN() == cust.getSSN())) {

				validationErrors = " Customer found !";
				hasErrors = true;

				return index;

			} else {

				validationErrors = "Customer not found........ ";
				hasErrors = false;
			}

			index++;

		}

		System.out.print(validationErrors);

		return -1;
	}

	// this method returns

	public Customer getCustomer(int index) {

		int count = 0;

		for (Customer c : customers) {

			if (index == count) {

				return c;
			}
			count++;
		}
		return null;
	}

	// This Method returns a list of Customers.
	public ArrayList<Customer> getCustomers() {

		return this.customers;
	}

	// Utility method for copying the details of a customer
	public Customer CopyCustomer(Customer source) {

		Customer destination = new Customer();

		destination.setCustomerNo(source.getCustomerNo());
		destination.setEmailAddress(source.getEmailAddress());
		destination.setFirstName(source.getFirstName());
		destination.setLastName(source.getLastName());
		destination.setSSN(source.getSSN());
		destination.setDOB(source.getDOB());
		destination.setAddress(source.getAddress());
		destination.setZipCode(source.getZipCode());
		destination.setModifiedDate(source.getModifiedDate());
		destination.setPhone(source.getPhone());
		destination.setTitle(source.getTitle());
		destination.setIsActive(source.getIsActive());

		return destination;

	}

	// Methods for fetching and updating data
	// Helper method to validate customer details
	private Boolean ValidateCustomer(Customer customer) {
		validationErrors = "";
		hasErrors = false;
		String expression = "";
		Pattern pattern ;
		Matcher matcher ;

		if (IsNullOrWhiteSpace(customer.getTitle())) {
			hasErrors = true;
			validationErrors = "First Name must not be empty\n";
		}
		
		if (IsNullOrWhiteSpace(customer.getFirstName())) {
			hasErrors = true;
			validationErrors = "First Name must not be empty\n";
		}

		if (IsNullOrWhiteSpace(customer.getLastName())) {
			hasErrors = true;
			validationErrors += "Last Name must not be empty\n";
		}
				
		// Social security number
		expression = "^\\d{3}[- ]?\\d{2}[- ]?\\d{4}$";
		pattern = Pattern.compile(expression);
		matcher = pattern.matcher(customer.getSSN());

		if (IsNullOrWhiteSpace(customer.getSSN()) || (!matcher.matches())) {

			hasErrors = true;
			validationErrors += "Invalid Social Security\n";
		}
		
		
        String zipRegex = "\\d{5}(-\\d{4})?";
        if (!customer.getZipCode().matches(zipRegex))
        {
            hasErrors = true;
            validationErrors += "Invalid ZipCode \n";
        }

		// validate Email       
        String emailRegex = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$";
        if (!customer.getEmailAddress().matches(emailRegex))
        {
	      //hasErrors = true;
	      System.out.println( "Invalid Email Address \n");
        }

		// Phone number is a series of digits, brackets, spaces, +, and - characters
        String phoneRegex = "^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$";
        if (!customer.getPhone().matches(phoneRegex))
        {
            hasErrors = true;
            validationErrors += "Invalid phone number\n";
        }
        

		System.out.println(validationErrors);

		return !hasErrors;
	}

	//check whether is null or emplty string or value
	public Boolean IsNullOrWhiteSpace(String value) {

		return value == null || value.trim().isEmpty();
	}

}
