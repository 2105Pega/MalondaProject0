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
import com.revature.beans.Employee;

public class EmployeeViewModel {

	private ArrayList<Employee> employees;
	String validationErrors = "";
	Boolean hasErrors = false;

	//an empty constructor
	public EmployeeViewModel() {
		this.employees = new ArrayList<Employee>();

	}
	
	// Save the new or updated 
	// and return the form to Browsing mode
	public Boolean Add(Employee emp) {

		validationErrors = "";
		hasErrors = false;

		// Validate the details of the Employee
		if (this.ValidateEmployee(emp)) {
			// Only continue if the Employee details are valid
			// this.IsBusy = true;

			// If the user is creating a new employee,
			// add it to the collection for the WCF Data Service

			try {

				this.employees.add(emp);

				validationErrors = "";
				hasErrors = false;

			} catch (Exception ex) {

				validationErrors = "Error ! this employee was not added  : " + ex;
				hasErrors = true;

			}

		}

		System.out.println(validationErrors);
		return !hasErrors;

	}

	public Boolean Edit(Employee oldEmp, Employee newEmp) {

		// If the user is editing the current employee,
		// update it in the collection for the WCF Data Service

		validationErrors = "";
		hasErrors = false;

		// int index = this.employees.indexOf(oldEmp);

		int index = SearchEmployee(oldEmp);

		if (index == -1) {

			hasErrors = true;
		}

		else {

			if (this.ValidateEmployee(newEmp)) {
				try {
	
					this.employees.set(index, newEmp);
	
					validationErrors = "\n\n\t\t Employee modified!";
					hasErrors = false;
	
				} catch (Exception ex) {
	
					validationErrors = "\t\t Error ! this employee was not modified  : " + ex;
					hasErrors = true;
				}
			}

		}

		System.out.println(validationErrors);
		return !hasErrors;

	}

	// Save the changes back to the data source
	public void Save() throws IOException {
		validationErrors = "";
		hasErrors = false;

		try {
			FileOutputStream fos = new FileOutputStream("Employees.txt");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(employees);
			validationErrors = "		 The serialized objects were written to the Employees.txt file.";
			oos.close();
			fos.close();
		} catch (IOException ioe) {
			validationErrors = "The serialized object failed to be written to Employees.txt file.";
			ioe.printStackTrace();
		}

		System.out.println(validationErrors);

	}

	// TO deserialize the ArrayList
	public void getData() throws ClassNotFoundException {
		try {
			FileInputStream fis = new FileInputStream("Employees.txt");
			ObjectInputStream ois = new ObjectInputStream(fis);

			employees = (ArrayList<Employee>) ois.readObject();

			validationErrors = "		employees were written to the Employees.txt file.";
			hasErrors = false;

			ois.close();
			fis.close();

		} catch (IOException ioe) {
			ioe.printStackTrace();
			validationErrors = "";

			hasErrors = true;
			return;
		} catch (ClassNotFoundException c) {
			validationErrors = "		EitherEmployee not found"
					+ " or The Employee's data failed to be load from Employees.txt file.";
			c.printStackTrace();
			return;
		}

		System.out.println(validationErrors);

	}

	// this methode returns the index of the cobject found
	// in the list.
	public int SearchEmployee(Employee emp) {

		int index = 0;

		for (Employee c : employees) {

			if ((c.getEmployeeNo() == emp.getEmployeeNo()) && (c.getSSN() == emp.getSSN())) {

				validationErrors = " Employee found !";
				hasErrors = true;

				return index;

			} else {

				validationErrors = "Employee not found........ ";
				hasErrors = false;
			}

			index++;

		}

		System.out.print(validationErrors);

		return -1;
	}

	// this method returns

	public Employee getEmployee(int index) {

		int count = 0;

		for (Employee c : employees) {

			if (index == count) {

				return c;
			}
			count++;
		}
		return null;
	}

	// This Method returns a list of employees.
	public ArrayList<Employee> getEmployees() {

		return this.employees;
	}


	// Utility method for copying the details of a employee
	public Employee CopyEmployee(Employee source) {

		Employee destination = new Employee();

		destination.setEmployeeNo(source.getEmployeeNo());
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
		destination.setIsManager(source.getIsManager());

		return destination;

	}

	// Methods for fetching and updating data
	// Helper method to validate customer details
	private Boolean ValidateEmployee(Employee employee) {
		validationErrors = "";
		hasErrors = false;

		if (IsNullOrWhiteSpace(employee.getFirstName())) {
			hasErrors = true;
			validationErrors = "First Name must not be empty\n";
		}

		if (IsNullOrWhiteSpace(employee.getLastName())) {
			hasErrors = true;
			validationErrors += "Last Name must not be empty\n";
		}

		// validate Email
		String expression = "^(.+)@(\\S+)$";
		Pattern pattern = Pattern.compile(expression);
		Matcher matcher = pattern.matcher(employee.getEmailAddress());

		if (IsNullOrWhiteSpace(employee.getEmailAddress()) || (!matcher.matches())) {

			hasErrors = true;
			validationErrors += "Invalid Email Address\n";
		}

		// Phone number is a series of digits, brackets, spaces, +, and - characters
		expression = "^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$";

		pattern = Pattern.compile(expression);
		matcher = pattern.matcher(employee.getPhone());

		if (IsNullOrWhiteSpace(employee.getPhone()) || (!matcher.matches())) {

			hasErrors = true;
			validationErrors += "Invalid phone number\n";
		}

		// Phone number is a series of digits, brackets, spaces, +, and - characters
		expression = "^\\d{3}[- ]?\\d{2}[- ]?\\d{4}$";

		pattern = Pattern.compile(expression);
		matcher = pattern.matcher(employee.getSSN());

		if (IsNullOrWhiteSpace(employee.getSSN()) || (!matcher.matches())) {

			hasErrors = true;
			validationErrors += "Invalid Social Security\n";
		}

		System.out.println(validationErrors);

		return !hasErrors;
	}

	public Boolean IsNullOrWhiteSpace(String value) {

		return value == null || value.trim().isEmpty();
	}

}
