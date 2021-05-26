
package com.revature.data;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import com.revature.beans.Customer;

public class BankData {

	private ArrayList<Customer> customers;

	/**
	 * @param customers
	 */
	public BankData() {
		this.customers = new ArrayList<Customer>();
	}

	public void SerailizeCustomers()
            throws IOException {
		// Create the stream objects.
		FileOutputStream outStream = new FileOutputStream("Objects.dat");
		ObjectOutputStream objectOutputFile = new ObjectOutputStream(outStream);

		// Write the serialized objects to the file.
		for (Customer cust : customers) {
			objectOutputFile.writeObject(cust);
		}

		// Close the file.
		objectOutputFile.close();

		System.out.println("The serialized objects " + "were written to the Objects.dat file.");
	}

}
