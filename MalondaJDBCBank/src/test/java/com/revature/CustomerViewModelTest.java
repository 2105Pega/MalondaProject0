package com.revature;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.Test;

import com.revature.beans.Customer;
import com.revature.viewModels.CustomerViewModel;


public class CustomerViewModelTest {

	static CustomerViewModel customers = new CustomerViewModel();
	static Boolean succeed = false;
	
	@Test
	public void addition() {
		
	
		System.out.println("\n\n\t\t Addition started-------------------------------------------------");
		succeed = false;
		
		Customer cust = new Customer(0001, "Mr.", "Ronsard", "Malonda", "111-11-1111","12/01/1999", 
				"20 Maple Ave", "19440", "Albert@yabiso.com", "424-858-9874", "aaaaa","123456", (new Date()));
		
		Boolean succeed = customers.Add(cust);
		
		
		Boolean passed = true;
		assertEquals(passed, succeed);
	}
	
	@Test
	public void Editing() {
		
		System.out.println("\n\n\t\t Editing Started---------------- -------------------------------\n\n");
		succeed = false;
		
		Customer cust = new Customer(0002, "Mr.", "Ronsard", "Malonda", "121-11-1111","12/01/1999", 
				"20 Maple Ave", "19440", "Albert@yabiso.com", "424-858-9874", "bbbbb","123456", (new Date()));
		
		succeed = customers.Add(cust);	
		
		//printCustomers(customers);
		
		Customer oldCust = new Customer(0002, "Mr.", "Ronsard", "Malonda", "121-11-1111","12/01/1999", 
				"20 Maple Ave", "19440", "Albert@yabiso.com", "424-858-9874","bbbbb","123456",  (new Date()));
		
		
		succeed = customers.Add(oldCust);	
		Customer newCust = customers.CopyCustomer(oldCust);
				
		newCust.setLastName("Tsiku");
		newCust.setZipCode("18945");
		
		
		succeed = customers.Edit(oldCust, newCust);
		
		
		Boolean passed = true;
		assertEquals(passed, succeed);
		
		System.out.println("\n\n\t\t Editing ended---------------- -------------------------------\n\n");

	}
	


	@Test
	public void searchCust() {
		
		System.out.println("\n\n\t\t searchCust started-------------------------------------------------\n\n");
		
		succeed = false;
		
		Customer cust = new Customer(0001, "Mr.", "Ronsard", "Malonda", "111-11-1111","12/01/1999", 
				"20 Maple Ave", "19440", "Albert@yabiso.com", "424-858-9874","aaaaa","123456",  (new Date()));
					
		cust.setCustomerNo(1);
		
		int index = customers.SearchCustomer(cust);
		

		
		if( index > -1 ) {
			
			succeed = true;
			
			print(customers.getCustomer(index));
		}
		
		
		Boolean passed = true;
		assertEquals(passed, succeed);
	}
	
	public void print(Customer c){
		
		System.out.println("\n\n\t\t" + c.toString() );
		
	}
	
	public void printCustomers(CustomerViewModel  cust) {
		
		System.out.println("\n\n");
		
		for (Customer c : cust.getCustomers()) {
									
			System.out.println("\t\t" + c.toString() );
		}
		
	}

}
