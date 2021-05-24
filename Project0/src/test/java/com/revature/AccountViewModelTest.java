package com.revature;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.Test;

import com.revature.beans.Account;
import com.revature.beans.Customer;
import com.revature.beans.Employee;
import com.revature.beans.NegativeAmount;
import com.revature.viewModels.AccountViewModel;
import com.revature.viewModels.CustomerViewModel;
import com.revature.viewModels.EmployeeViewModel;

public class AccountViewModelTest {

	static AccountViewModel accounts = new AccountViewModel();
	static Boolean succeed = false;
	
	static CustomerViewModel customers = new CustomerViewModel();
	static EmployeeViewModel employees = new EmployeeViewModel();
	

	@Test
	public void addition() {
		


			
			//System.out.println("\n\n\t\t Addition Account started-------------------------------------------------");
			succeed = false;

			
			//Customer cust = new Customer(0005, "Mr.", "Fabrice", "Malonda", "666-25-5858","02/05/2016", 
					//"20 Maple Ave", "19440", "Fabrice@yabiso.com", "424-858-9874", (new Date()));
			
			//Customer cust = new Customer(0001, "Mr.", "Ronsard", "Malonda", "111-11-1111",
						//"12/01/1999", "20 Maple Ave", "19440", "Albert@yabiso.com", "424-858-9874", (new Date()))
			
			Customer cust = new Customer(0001, "Mr.", "Ronsard", "Malonda", "111-99-1111","12/01/1999", 
					"20 Maple Ave", "19440", "Albert@yabiso.com", "424-858-9874", "aaaaa","123456", (new Date()));
			
			Boolean succeed = customers.Add(cust);
			
	
			Employee emp = new Employee(0001, "Mr.", "Tralie", "Charlie", "222-22-2222","12/01/2000", 
					"20 Maple Ave","Colmar", "PA","25486", "Albert@yabiso.com", "424-858-9874","winning7", "aaaa" ,(new Date()), true);
			

			Account acc = new Account(	0001, (customers.getCustomers()), 20.4);

			succeed = accounts.Add(acc);
			
			//System.out.println(" 		System succeed " + succeed);
			
		
		Boolean passed = true;
		assertEquals(passed, succeed);
	}

	
	@Test
	public void Editing() throws NegativeAmount {

		System.out.println("\n\n\t\t Editing Started---------------- -------------------------------\n\n");
		succeed = false;

		Customer cust = new Customer(0005, "Mrs.", "bayce", "Malonda", "666-28-5858","02/05/2016", 
				"20 Maple Ave", "19440", "Fabrice@yabiso.com", "424-858-9874","eeeee","123456", new Date());
		
		
		Boolean succeed = customers.Add(cust);
		
		Employee emp = new Employee(0006, "Mr.", "Kenge", "Flyer", "222-82-2222","12/01/1941", 
				"20 Maple Ave","Colmar", "PA","25486", "Kenge@yabiso.com", "123-858-9874","winning7", "aaaa" , (new Date()), true);
		
		
		Account acc = new Account(	0003, (customers.getCustomers()), 20.4);

		succeed = accounts.Add(acc);

		Account oldAcc =  new Account(	0005, (customers.getCustomers()), 20.4);

		succeed = accounts.Add(oldAcc);
		
		Account newAcc = new Account();
		
		accounts.CopyAccount(newAcc, oldAcc);

		newAcc.deposit(100.0);
		//newAcc.setPassWord("abcdef");
		
		print(oldAcc);
		
		print(newAcc);

		succeed = accounts.Edit(oldAcc, newAcc);

		// System.out.println(" result : " + succeed );

		//printAccounts(accounts);

		Boolean passed = true;
		assertEquals(passed, succeed);
	}

	@Test
	public void searchCust() {

		System.out.println("\n\n		searchCust started-------------------------------------------------\n\n");

		succeed = false;
		Employee emp = new Employee(0006, "Mr.", "Kenge", "Flyer", "222-82-2222","12/01/1941", 
				"20 Maple Ave","Colmar", "PA","25486", "Kenge@yabiso.com", "123-858-9874", "winning7", "aaaa" ,(new Date()), true);
		
		Account acc = new Account(	0001, (customers.getCustomers()), 20.4);

		acc.setAccountNo(1);
		
		int index = accounts.SearchAccount(acc);
		


	    System.out.println("			index search    " + index );



		if (index > -1) {

			succeed = true;

			print(accounts.getAccount(index));
		}

		Boolean passed = true;
		assertEquals(passed, succeed);
	}

	public void print(Account c) {

		System.out.println("\n\n\t\t" + c.toString());

	}

	public void printAccounts(AccountViewModel cust) {

		System.out.println("\n\n");

		for (Account c : cust.getAccounts()) {

			System.out.println("\t\t" + c.toString());
		}

	}

}
