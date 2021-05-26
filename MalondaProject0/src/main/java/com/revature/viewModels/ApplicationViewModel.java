package com.revature.viewModels;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import com.revature.beans.Application;

import com.revature.beans.NegativeAmount;

public class ApplicationViewModel {

	private ArrayList<Application> applications;

	String validationErrors = "";
	Boolean hasErrors = false;

	// an empty constructor
	public ApplicationViewModel() {
		this.applications = new ArrayList<Application>();
		// this.customers = new ArrayList<Customer>();

	}

	// Save the new or updated an application back to the WCF Data Service
	// and return the form to Browsing mode
	public Boolean Add(Application app) {

		validationErrors = "";
		hasErrors = false;

		// Validate the details of the application
		if (this.ValidateApplication(app)) {
			// Only continue if the application details are valid
			// this.IsBusy = true;

			// If the user is creating a new Application,
			// add it to the collection for the WCF Data Service

			// System.out.println("application validation succeed");

			try {

				this.applications.add(app);

				validationErrors = "";
				hasErrors = false;

				// System.out.println("Application added to the list");

			} catch (Exception ex) {

				validationErrors = "Error ! this application was not added  : " + ex;
				hasErrors = true;

			}

		} else {
			validationErrors = "Error ! this application not did not succeed validation";
		}

		System.out.println(validationErrors);
		return !hasErrors;

	}

	public Boolean Edit(Application oldApp, Application newApp) {

		// If the user is editing the current Application,
		// update it in the collection for the WCF Data Service

		validationErrors = "";
		hasErrors = false;

		// int index = this.Applications.indexOf(oldCust);

		int index = SearchApplication(oldApp);

		if (index == -1) {

			hasErrors = true;
		}

		else {
			if (this.ValidateApplication(newApp)) {

				try {

					this.applications.set(index, newApp);

					// validationErrors = "\n\n\t\t Application modified!";
					hasErrors = false;

				} catch (Exception ex) {

					validationErrors = "\t\t Error ! this application was not modified  : " + ex;
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
			FileOutputStream fos = new FileOutputStream("Applications.txt");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(applications);
			validationErrors = "\n\t\t        Operation succeed :  Application saved.";
			fos.close();
		} catch (IOException ioe) {
			validationErrors = "\n\t\t        Operation failed :   Application not saved.";
			ioe.printStackTrace();
		}

		System.out.println(validationErrors);

	}

	// TO deserialize the ArrayList
	public void getData() throws ClassNotFoundException {
		try {
			
			FileInputStream fis = new FileInputStream("Applications.txt");
			ObjectInputStream ois = new ObjectInputStream(fis);

			applications = (ArrayList<Application>) ois.readObject();

			validationErrors = "\n\t\t\t\t   Applications were successful loaded in the app.";

			hasErrors = false;

			ois.close();
			fis.close();

		} catch (IOException ioe) {
			ioe.printStackTrace();
			validationErrors = "";

			hasErrors = true;
			return;
		} catch (ClassNotFoundException c) {
			validationErrors = "		Either Application not found"
					+ " or The Application's data failed to be load from BankingDB.txt file.";
			c.printStackTrace();
			return;
		}

		System.out.println(validationErrors);

	}

	// this methode returns the index of the cobject found
	// in the list.
	public int SearchApplication(Application acc) {

		int index = 0;

		// System.out.println("List des Application");
		// for(Application a : Applications) {
		// System.out.println(a.toString());
		// }

		// System.out.println("Application to serach");
		// System.out.println(acc.toString());

		for (Application c : applications) {

			if ((c.getApplicationNo() == acc.getApplicationNo())) {

				validationErrors = " Application found !";
				hasErrors = true;

				return index;

			} else {

				validationErrors = "Application not found........ ";
				hasErrors = false;
			}

			index++;

		}

		System.out.print(validationErrors);

		return -1;
	}

	// this method returns

	public Application getApplication(int index) {

		int count = 0;

		for (Application c : applications) {

			if (index == count) {

				return c;
			}
			count++;
		}
		return null;
	}

	// This Method returns a list of Accounts.
	public ArrayList<Application> getApplications() {

		return this.applications;
	}

	// Utility method for copying the details of a account
	public void CopyApplication(Application destination, Application source) throws NegativeAmount {

		destination.setApplicationNo(source.getApplicationNo());
		destination.setCustomers(source.getCustomers());
		destination.setEmployee(source.getEmployee());
		destination.setIsActive(source.getIsActive());
		destination.setIsValide(source.getIsValide());

	}

	// Methods for fetching and updating data
	// Helper method to validate account details
	private Boolean ValidateApplication(Application application) {
		validationErrors = "";
		hasErrors = false;

		if (application.getCustomers() == null) {

			hasErrors = true;
		}

		System.out.println(validationErrors);

		return !hasErrors;
	}

}
