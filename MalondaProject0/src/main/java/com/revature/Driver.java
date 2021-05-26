/**
 * 
 */
package com.revature;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Scanner;

import com.revature.beans.*;

import com.revature.viewModels.*;

/**
 * @author Ronsard Malonda
 *
 */
public class Driver {

	static Scanner in = new Scanner(System.in);
	// static Boolean selected;
	static CustomerViewModel customers = new CustomerViewModel();
	static AccountViewModel accounts = new AccountViewModel();
	static EmployeeViewModel employees = new EmployeeViewModel();
	static ApplicationViewModel applications = new ApplicationViewModel();

	static Account currentAccount = new Account();
	static Employee currentEmployee = new Employee();
	static Customer currentCustomer = new Customer();
	static ArrayList<Account> accountsTransferable = new ArrayList<Account>();

	// static String validationErrors = "";
	// static String user = "";
	static Boolean isEmployee = false;
	static Boolean isManager = false;

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {

		try {

			//LoadData();
			GetData();
			Welcome();
			
			//for(Employee em : employees.getEmployees()) {
				//System.out.println("                           the saved data employee from : " + em);
			//}

		} catch (Exception ex) {
			System.out.println(" File not found " + ex);
		}

		// AccountDetailsScreen();
		//Welcome();

		// Home();
		// System.out.println(" After calling Main Methods.........................");
		// Save() ;

		// GetData();

		// OpenAccount();

		// validation();
		// Application();
		// Banking();
		// ApproveAccount();
		// BankAdmin();
		// Close();

		// System.exit(0);

		//System.out.println("				Caller you are at the end of  Main Method :   exiting..................");
		in.close();

		// System.exit(0);

	}

	public static void Header() {

		System.out.println("\n\n");
		System.out.println("		-------------------------------------------------------------------------------");
		System.out.println("		-                                                                             -");
		System.out.println("		-                             WELCOME TO OUR BANK                             -");
		System.out.println("		-                                                                             -");
		System.out.println("		-------------------------------------------------------------------------------");

	}

	public static void Home() {

		String validationErrors = " ";
		char c;

		Boolean selected = false;
		validationErrors = " ";

		do {

			Header();

			System.out.println("	");
			System.out.println("					WHAT CAN I DO FOR YOU ?  ");
			System.out.println("	");
			System.out.println("			PLEASE ENTER ( B ) FOR BANKING AND ( O ) TO OPEN ACCOUNT ");
			System.out.print("					OR [ X ] TO EXIT :  ");
			// String s = console.readLine();
			c = in.nextLine().charAt(0);

			if ((c == 'B') || (c == 'b')) {

				validationErrors = "\n\n\t		Your chose banking ........................................";
				//System.out.println(validationErrors);
				selected = true;
				Banking();

			} else if ((c == 'O') || (c == 'o')) {

				selected = true;
				validationErrors = "\n\n\t		Your are applying for a new bank account ..................";
				System.out.println(validationErrors);
				Application();
				//System.out.println("				Caller Methode Home :   got out from application");
			} else if ((c == 'X') || (c == 'x')) {

				selected = false;
				validationErrors = "\n\n\t		Your are exiting bank account ..................";
				//System.out.println(validationErrors);

				// Application();
			}

			else {

				validationErrors = "\n\n\t		You entered the wrong letter. Please correct it!...........";
				System.out.println(validationErrors);
				selected = true;
			}

		} while (selected == true);


	}

	private static void Banking() {
		// TODO Auto-generated method stub
		char c;

		Boolean selected = false;
		String validationErrors = " ";

		do {

			Header();

			System.out.println("	");
			System.out.println("					    WHAT CAN I DO FOR YOU ?  ");
			System.out.println("	");
			System.out.println("			PLEASE ENTER [D] DEPOSIT, [w] TO WITHDRAW, [C] TO CHECK BALANCE ");
			System.out.print("				        OR [ X ] TO EXIT :  ");

			c = in.nextLine().charAt(0);
			in.nextLine();

			if ((c == 'D') || (c == 'd')) {

				validationErrors = "\n\n\t		Your chose depositing ........................................";
				System.out.println(validationErrors);
				selected = true;
				// Depositing();

			} else if ((c == 'W') || (c == 'w')) {

				selected = true;
				validationErrors = "\n\n\t		Your chose withdrawing ..................";
				//System.out.println(validationErrors);

			} else if ((c == 'C') || (c == 'c')) {

				selected = true;
				validationErrors = "\n\n\t		Your chose Checking your balance ..................";
				//System.out.println(validationErrors);
				// Application();
				// System.out.println(" Caller Methode Home : got out from application");
			} else if ((c == 'X') || (c == 'x')) {

				selected = false;
				validationErrors = "\n\n\t		Your are exiting  you account ..................";
				//System.out.println(validationErrors);

				// Application();
			}

			else {

				validationErrors = "\n\n\t		You entered the wrong letter. Please correct it!...........";
				System.out.println(validationErrors);
				selected = true;
			}

			// System.out.println(validationErrors);
			// System.out.println(selected);

			// System.out.println(" Caller Methode Home : got out from application");
		} while (selected == true);

		//System.out.println("				Caller Methode Home :   exiting..................");

	}

	private static void Welcome() {

		char c;

		Boolean selected = false;
		String validationErrors = " ";

		do {

			Header();

			System.out.println("	");
			System.out.println("					ARE YOU AN EMPLOYEE OR CUSTOMER ?  ");
			System.out.println("	");
			System.out.println("			       PLEASE ENTER [E] FOR EMPLOYEE, [C] FOR CUSTOMER ");
			System.out.print("				             [A] TO APPLY, [X] TO EXIT :  ");
			// String s = console.readLine();
			try {

				c = in.nextLine().charAt(0);

			} catch (Exception e) {

				// cause bad typing
				c = 'z';
			}

			if ((c == 'E') || (c == 'e')) {

				validationErrors = "\n\n\t		Entering Employee environment ........................................";
				//System.out.println(validationErrors);
				selected = true;
				Login(c);

			} else if ((c == 'A') || (c == 'a')) {

				selected = true;
				validationErrors = "\n\n\t		You chose applying ..................";
				//System.out.println(validationErrors);
				Application();

			} else if ((c == 'C') || (c == 'c')) {

				selected = true;
				validationErrors = "\n\n\t		Your are Entereing Customer Environment ..................";
				//System.out.println(validationErrors);
				Login(c);
				// validationErrors = "\n\n\t Your are Entereing Customer Screen
				// ..................";
				// System.out.println(validationErrors);

			}

			else if ((c == 'N') || (c == 'n')) {

				selected = true;
				validationErrors = "\n\n\t		Your are Entereing Customer Environment ..................";
				//System.out.println(validationErrors);
				Application();
			} else if ((c == 'X') || (c == 'x')) {

				selected = false;
				validationErrors = "\n\n\t		Your are exiting bank account ..................";
				//System.out.println(validationErrors);
				System.exit(0);
				// Application();
			}

			else {

				validationErrors = "\n\n\t		You entered the wrong letter. Please correct it!..........."
						+ "\n\n			............... PRESS ENTER TO CONTINUE...............  ";
				System.out.println(validationErrors);
				selected = true;
				in.nextLine();
			}

			in.nextLine();
		} while (selected == true);


	}

	private static void CustomerScreen() {

		// TODO Auto-generated method stub
		char c;

		Boolean selected = false;
		String validationErrors = " ";

		do {

			Header();

			// System.out.println(" ");
			System.out.println("				----------------------------------------------");
			System.out.println("				-               CUSTOMER BANKING             -");
			System.out.println("				----------------------------------------------");
			System.out.print(" ");

			System.out.println("	");
			System.out.println("					    WHAT WOULD YOU LIKE TO DO ?  ");
			System.out.println("	");
			System.out.println("			PLEASE ENTER [D] DEPOSIT, [w] TO WITHDRAW, [C] TO CHECK BALANCE, ");
			System.out.print("				        [T] TO TRANSFER,  OR [ X ] TO EXIT :  ");

			try {

				c = in.nextLine().charAt(0);

			} catch (Exception e) {

				// cause bad typing
				c = 'z';
			}
			// in.nextLine();

			if ((c == 'D') || (c == 'd')) {

				validationErrors = "\n\n\t		Your chose depositing ........................................";
				System.out.println(validationErrors);
				selected = true;
				CustomerDepositing();

			} else if ((c == 'W') || (c == 'w')) {

				selected = true;
				validationErrors = "\n\n\t		You chose withdrawing ..................";
				System.out.println(validationErrors);
				Withdrawing();

			} else if ((c == 'C') || (c == 'c')) {

				selected = true;
				validationErrors = "\n\n\t		Your chose Checking your balance ..................";
				System.out.println(validationErrors);
				CheckingBalance();
				// System.out.println(" Caller Methode Home : got out from application");
			} else if ((c == 'T') || (c == 't')) {

				selected = true;
				validationErrors = "\n\n\t		Your chose transfering money ..................";
				System.out.println(validationErrors);
				TransferScreen();
				// System.out.println(" Caller Methode Home : got out from application");
			} else if ((c == 'X') || (c == 'x')) {

				selected = false;
				validationErrors = "\n\n\t		Your are exiting  you account ..................";
				//System.out.println(validationErrors);

				// Application();
			}

			else {

				validationErrors = "\n\n\t		You entered the wrong letter. Please correct it!...........";
				System.out.println(validationErrors);
				selected = true;
			}

			// System.out.println(validationErrors);
			// System.out.println(selected);

			// System.out.println(" Caller Methode Home : got out from application");
			// in.nextLine();
		} while (selected == true);

		//System.out.println("				Caller Methode Home :   exiting..................");

	}

	private static void TransferScreen() {
		// TODO Auto-generated method stub

		int accountNoFrom = 0;
		int accountNoTo = 0;
		double amount = 0.0;
		String ValidationErrors = "";

		Header();

		// System.out.println(" ");
		System.out.println("				----------------------------------------------");
		System.out.println("				-               CUSTOMER BANKING             -");
		System.out.println("				----------------------------------------------");
		System.out.print(" ");
		System.out.println("	");
		System.out.println("					    LIST OF YOUR ACCOUNTS    ");

		System.out.println("	");

		String leftAlignFormat = "					| %-8s | %-15s |%n";

		System.out.format("					+----------+-----------------+%n");
		System.out.format("					|Account No|    Balance      |%n");
		System.out.format("					+----------+-----------------+%n");

		int accountCount = 0;
		for (Account acc : accountsTransferable) {

			System.out.format(leftAlignFormat, acc.getAccountNo(), acc.getBalance());
			accountCount++;
			System.out.format("					+----------+-----------------+%n");

		}

		if(accountCount > 1) {
			
		
		System.out.println("	");
		System.out.print("				 WHICH ACCOUNT WOULD YOU LIKE TO TRANSFER FROM  ?  : ");
		accountNoFrom = in.nextInt();
		in.nextLine();

		System.out.println("	");
		System.out.print("				 WHICH ACCOUNT WOULD YOU LIKE TO TRANSFER TO    ?  : ");
		accountNoTo = in.nextInt();
		in.nextLine();

		System.out.print("\n				 HOW MUCH DO YOU WOULD YOU LIKE TO TRANSFER TO  ?  : ");

		amount = in.nextDouble();

		// withdraw money from the account from
		for (Account acc : accountsTransferable) {

			if (accountNoFrom == acc.getAccountNo()) {
				try {

					if ((acc.getBalance() - amount) < 0) {

						ValidationErrors = "\n\n			Error : This operation failed because you don't have enough money in your account ..........  ";
						System.out.println(ValidationErrors);
					} else {

						acc.withdraw(amount);
					}

				} catch (NegativeAmount e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			// System.out.println("\n\n AccountNo Transferable : " + acc.getAccountNo());

			// deposit money to the account to
			if (accountNoTo == acc.getAccountNo()) {
				try {
					acc.deposit(amount);

					ValidationErrors = "\n\n				 Operation succeed :  Money Transfered ..........  ";
					System.out.println(ValidationErrors);
				} catch (NegativeAmount e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			in.nextLine();

		}

		// update date the database(accounts)
		for (Account source : accountsTransferable) {

			for (Account destination : accounts.getAccounts()) {
				// System.out.println("\n Before update " + destination.toString());
				if (source.getAccountNo() == destination.getAccountNo()) {

					accounts.Edit(destination, source);

					// System.out.println("\n After update " + destination.toString());
				}
			}

		}
		
	}else {
		System.out.println("\n\t\t\t   You don't have two or more accounts to transfer to.   ");
		}

		in.nextLine();
		
		// System.out.println(" ");
		System.out.println("				----------------------------------------------");
		System.out.println("				-               CUSTOMER BANKING             -");
		System.out.println("				----------------------------------------------");
		System.out.print(" ");
		System.out.println("	");
		System.out.println("					    YOUR ACCOUNTS BALANCES    ");

		System.out.println("	");

		leftAlignFormat = "					| %-8s | %-15s |%n";

		System.out.format("					+----------+-----------------+%n");
		System.out.format("					|Account No|    Balance      |%n");
		System.out.format("					+----------+-----------------+%n");

		for (Account acc3 : accounts.getAccounts()) {

			System.out.format(leftAlignFormat, acc3.getAccountNo(), acc3.getBalance());
			System.out.format("					+----------+-----------------+%n");
		}

		System.out.println("\n\n			............... PRESS ENTER TO CONTINUE...............  ");
		in.nextLine();

	}

	private static void CheckingBalance() {

		try {

			double balance = currentAccount.getBalance();

			String currentUserName = currentCustomer.getUserName();

			// newBalance = currentAccount.getBalance();

			Header();
			// System.out.println(" ");
			System.out.println("				----------------------------------------------");
			System.out.println("				-               CUSTOMER DETAILS             -");
			System.out.println("				----------------------------------------------");
			System.out.print(" ");

			System.out.println("\n				    USER NAME :  " + currentUserName);
			System.out.println("\n				    Your  Balance is    : " + balance);

			System.out.println("\n\n				............. PRESS ENTER TO CONTINUE...........  ");
		} catch (Exception ex) {

			System.out.println("  account exception " + ex);
		}

		in.nextLine();
		in.nextLine();

	}

	private static void Withdrawing() {

		Boolean isPositive = true;
		String validationErrors = "";
		double amount = 0.0;
		double balance = currentAccount.getBalance();
		double newBalance = 0.0;
		// Account newAccount = new Account();
		Account oldAccount = new Account();
		String currentUserName = currentCustomer.getUserName();

		oldAccount = currentAccount;

		do {
			Header();
			// System.out.println(" ");
			System.out.println("				----------------------------------------------");
			System.out.println("				-               CUSTOMER DETAILS             -");
			System.out.println("				----------------------------------------------");
			System.out.print(" ");

			System.out.print("\n				HOW MUCH DO YOU WANT TO WITHDRAW ?      :  ");

			try {

				amount = in.nextDouble();
				in.nextLine();

				if ((balance - amount) < 0) {

					System.out.println("\n				    You don't have enough money for this operation.");
				} else {

					currentAccount.withdraw(amount);

					accounts.Edit(oldAccount, currentAccount);

					newBalance = currentAccount.getBalance();

					Header();
					// System.out.println(" ");
					System.out.println("				----------------------------------------------");
					System.out.println("				-               CUSTOMER DETAILS             -");
					System.out.println("				----------------------------------------------");
					System.out.print(" ");

					System.out.println("\n				    USER NAME :  " + currentUserName);
					System.out.println("\n				    Your  Balance was    : " + balance);
					System.out.println("\n				    You withdrew         : " + amount);
					System.out.println("\n				    Your  new Balance is : " + newBalance);
					// System.out.println("\n\n ............... PRESS ENTER TO
					// CONTINUE............... ");

					isPositive = true;
				}
			} catch (NegativeAmount ex) {

				System.out.println("\n					Account exception " + ex);
				validationErrors = " \n 				Please try again !  : ";
				isPositive = false;

			} catch (Exception ex) {

				System.out.println("\n				Account exception " + ex);
			}

			System.out.println(validationErrors);

			System.out.println("\n\n			............... PRESS ENTER TO CONTINUE............... : ");

			in.nextLine();

		} while (isPositive == false);
	}

	private static void CustomerDepositing() {

		Boolean isPositive = true;
		String validationErrors = "";
		double amount = 0.0;
		double balance = currentAccount.getBalance();
		double newBalance = 0.0;
		// Account newAccount = new Account();
		Account oldAccount = new Account();
		String currentUserName = currentCustomer.getUserName();

		oldAccount = currentAccount;

		do {
			Header();
			// System.out.println(" ");
			System.out.println("				----------------------------------------------");
			System.out.println("				-               CUSTOMER DETAILS             -");
			System.out.println("				----------------------------------------------");
			System.out.print(" ");

			System.out.print("\n				HOW MUCH DO YOU WANT TO DEPOSIT ?      :  ");

			try {

				amount = in.nextDouble();
				in.nextLine();

				currentAccount.deposit(amount);

				accounts.Edit(oldAccount, currentAccount);

				newBalance = currentAccount.getBalance();

				Header();
				// System.out.println(" ");
				System.out.println("				----------------------------------------------");
				System.out.println("				-               CUSTOMER DETAILS             -");
				System.out.println("				----------------------------------------------");
				System.out.print(" ");

				System.out.println("\n				    USER NAME :  " + currentUserName);
				System.out.println("\n				    Your  Balance was    : " + balance);
				System.out.println("\n				    You deposited        : " + amount);
				System.out.println("\n				    Your  new Balance is : " + newBalance);
				// System.out.println("\n\n ............... PRESS ENTER TO
				// CONTINUE............... ");

				isPositive = true;

			} catch (NegativeAmount ex) {

				System.out.println("\n					Account exception " + ex);
				validationErrors = " \n 				Please try again !  : ";
				isPositive = false;

			} catch (Exception ex) {

				System.out.println("\n				Account exception " + ex);
			}

			System.out.println(validationErrors);

			System.out.println("\n\n			............... PRESS ENTER TO CONTINUE............... : ");

			in.nextLine();

		} while (isPositive == false);

	}

	private static void EmployeeScreen() {
		// TODO Auto-generated method stub
		/*
		 * Employees of the bank should be able to view all of their customers
		 * information o This includes, account information o Account balances Personal
		 * information
		 * 
		 */

		// TODO Auto-generated method stub
		char c;

		Boolean selected = false;
		String validationErrors = " ";

		do {

			Header();

			// System.out.println(" ");
			System.out.println("				----------------------------------------------");
			System.out.println("				-                 EMPLOYEE ONLY              -");
			System.out.println("				----------------------------------------------");
			System.out.print(" ");

			System.out.println("	");
			System.out.println("					    WHAT CAN I DO FOR YOU ?  ");
			System.out.println("	");
			System.out.println("			PLEASE ENTER [A] VIEW ACCOUNTS, [C] TO VIEW CUSTOMERS INFORMATIONS");
			System.out.print("				             OR [ X ] TO EXIT :  ");

			try {

				c = in.nextLine().charAt(0);

			} catch (Exception e) {

				// cause bad typing
				c = 'z';
			}
			// in.nextLine();

			if ((c == 'A') || (c == 'a')) {

				validationErrors = "\n\n\t		Your chose viewing Accounts Details ........................................";
				System.out.println(validationErrors);
				selected = true;
				AccountDetailsScreen();

			} else if ((c == 'C') || (c == 'c')) {

				selected = true;
				validationErrors = "\n\n\t		Your chose viewing Customers Informations ..................";
				System.out.println(validationErrors);
				CustomerDetailScreen();

			} else if ((c == 'X') || (c == 'x')) {

				selected = false;
				validationErrors = "\n\n\t		Your are exiting  you account ..................";
				//System.out.println(validationErrors);

				// Application();
			}

			else {

				validationErrors = "\n\n\t		You entered the wrong letter. Please correct it!...........";
				System.out.println(validationErrors);
				selected = true;
			}

		} while (selected == true);

		//System.out.println("				Caller Methode Home :   exiting..................");

	}

	private static void AccountDetailsScreen() {
		// TODO Auto-generated method stub

		Header();

		// System.out.println(" ");
		System.out.println("				----------------------------------------------");
		System.out.println("				-               ACCOUNTS DETAILS            -");
		System.out.println("				----------------------------------------------");
		System.out.print("\n");

		String leftAlignFormat = "    		     | %-8s | %-15s | %-15s | %-15s |%n";

		System.out.format("    		     +----------+-----------------+-----------------+-----------------+%n");
		System.out.format("    		     |Account No| First Name      | Last Name       | Balance         |%n");
		System.out.format("    		     +----------+-----------------+-----------------+-----------------+%n");
		int count = 0;
		for (Account acc : accounts.getAccounts()) {

			for (Customer cust : acc.getCustomers()) {
				if (count == 0) {
					System.out.format(leftAlignFormat, acc.getAccountNo(), cust.getFirstName(), cust.getLastName(),
							acc.getBalance());
				} else {
					System.out.format(leftAlignFormat, "     ", cust.getFirstName(), cust.getLastName(), "      ");
				}

				count++;
			}
			count = 0;
			System.out.format("    		     +----------+-----------------+-----------------+-----------------+%n");
		}

		/*
		 * Bank admins should be able to view and edit all accounts This includes:
		 * Approving/denying accounts withdrawing, depositing, transferring from all
		 * accounts canceling accounts
		 * 
		 */

		in.nextLine();

	}

	private static void CustomerDetailScreen() {
		// TODO Auto-generated method stub

		Header();

		// System.out.println(" ");
		System.out.println("				----------------------------------------------");
		System.out.println("				-               CUSTOMERS DETAILS            -");
		System.out.println("				----------------------------------------------");
		System.out.print("\n");

		// System.out.println(customers.getCustomers().toString());

		String leftAlignFormat = "| %-5s | %-5s | %-15s | %-15s | %-9s | %-10s | %-10s | %-10s | %-20s | %-20s | %-6s |%n";

		System.out.format(
				"+-------+-------+-----------------+-----------------+-------------+------------+--------------+--------------+----------------------+----------------------+--------+%n");
		System.out.format(
				"| ID    | Title | FirstName       | LastName        |    SSN      |    DOB     |  Phone       |  Username    | Email Address        |  Adress              | ZipCode|%n");
		System.out.format(
				"+-------+-------+-----------------+-----------------+-------------+------------+--------------+--------------+----------------------+----------------------+--------+%n");
		
		for (Customer cust : customers.getCustomers()) {
			
			System.out.format(leftAlignFormat, cust.getCustomerNo(), cust.getTitle(), cust.getFirstName(),
					cust.getLastName(), cust.getSSN(), cust.getDOB(), cust.getPhone(),cust.getUserName(), cust.getEmailAddress(),
					cust.getAddress(), cust.getZipCode());
		}
		System.out.format(
				"+-------+-------+-----------------+-----------------+-------------+------------+--------------+--------------+----------------------+----------------------+--------+%n");

		
		//customers.Delete(3);
		
		//System.out.println(" after deleting");
		in.nextLine();
		

	}

	private static void Login(char c) {
		// TODO Auto-generated method stub
		String stringTitle = "";
		String userName = "";
		String passWord = "";
		Boolean found = false;
		char k;

		// do {
		Header();

		if ((c == 'c') || (c == 'C')) {
			isEmployee = false;
			isManager = false;
			currentEmployee = null;

			stringTitle = "				-               CUSTOMER LOGIN             -";

			// System.out.println(" ");
			System.out.println("				----------------------------------------------");
			System.out.println(stringTitle);
			System.out.println("				----------------------------------------------");
			System.out.print(" ");
			
			 System.out.print("				ENTER YOUR USERNAME   	 :  "); 
			 userName = in.nextLine();
			 System.out.print("				ENTER YOUR PASSWORD 	 :  "); 
			 passWord = in.nextLine();
			
			//userName = "aaaaa";
			//passWord = "123456";

			for (Account acc : accounts.getAccounts()) {

				for (Customer cust : acc.getCustomers()) {

					if ((userName.equals(cust.getUserName())) && (passWord.equals(cust.getPassWord()))) {

						currentAccount = acc;
						currentCustomer = cust;

						accountsTransferable.add(acc);

						found = true;
						System.out.println("					user found .......");
					}

				}

			}

			if (found)
				CustomerScreen();
			else
				System.out.println("			    the username or/and password provided is incomplete.");

		} else if ((c == 'E') || (c == 'e')) {

			//userName = "eaaaa";
			//passWord = "123456";
			isEmployee = true;
			stringTitle = "				-               EMPLOYEE LOGIN             -";
			// System.out.println(" ");
			System.out.println("				----------------------------------------------");
			System.out.println(stringTitle);
			System.out.println("				----------------------------------------------");
			System.out.print(" ");

			System.out.print("				ENTER YOUR USERNAME   	 :  ");
			userName = in.nextLine();
			System.out.print("				ENTER YOUR PASSWORD 	 :  ");
			passWord = in.nextLine();

			for (Employee emp : employees.getEmployees()) {
				if ((emp.getUserName().equals(userName)) && (emp.getPassWord().equals(passWord))) {
					currentEmployee = emp;
					currentAccount = null;
					found = true;
					//System.out.println("Employee user account found...");

				}

			}

			if (found) {

				if (currentEmployee.getIsManager()) {

					ManagerScreen();

				} else {

					EmployeeScreen();

				}
			} else {
				System.out.println("			      the username or/and password provided is incomplete.");
			}
		}

		System.out.println("\n\n			............... PRESS ENTER TO CONTINUE............... : ");
		in.nextLine();

		// } while (found);
		


	}

	private static void ManagerScreen() {

		// TODO Auto-generated method stub
		/*
		 * Bank admins should be able to view and edit all accounts This includes:
		 * Approving/denying accounts withdrawing, depositing, transferring from all
		 * accounts canceling accounts
		 * 
		 */
		char c;

		Boolean selected = false;
		String validationErrors = " ";

		do {

			Header();

			// System.out.println(" ");
			System.out.println("                                  ----------------------------------------------");
			System.out.println("                                  -                 MANAGER ONLY               -");
			System.out.println("                                  ----------------------------------------------");
			System.out.print(" ");

			System.out.println("	");
			System.out.println("                                          WHAT WOULD YOU LIKE TO DO ?  ");
			System.out.println("	");
			System.out.println(
					"                          PLEASE ENTER [D] DEPOSIT, [w] > WITHDRAW, [C] > CHECK BALANCE, ");
			System.out.println(
					"                      [T] > TRANSFER ,[A] > VIEW ACCOUNTS, [I] > VIEW CUSTOMERS INFORMATIONS,");
			System.out
					.println("                           [Q] > APPROVE/DENY APPLICATION, [V] > VIEW APPLICATION STATUS");
			System.out.print("                                     [F] > CANCEL ACCOUNT OR [ X ] TO EXIT :  ");

			try {

				c = in.nextLine().charAt(0);

			} catch (Exception e) {

				// cause bad typing
				c = 'z';
			}
			// in.nextLine();

			if ((c == 'D') || (c == 'd')) {

				validationErrors = "\n\n\t		Your chose depositing ........................................";
				//System.out.println(validationErrors);
				selected = true;
				ManagerDepositing();

			} else if ((c == 'W') || (c == 'w')) {

				selected = true;
				validationErrors = "\n\n\t		Your chose withdrawing ..................";
				ManagerWithdrawing();
				
			} else if ((c == 'F') || (c == 'f')) {

				selected = true;
				validationErrors = "\n\n\t		Your chose withdrawing ..................";
				CancelingAccount();

			} else if ((c == 'V') || (c == 'v')) {

				selected = true;
				validationErrors = "\n\n\t		Your chose viewing application status ..................";
				ManagerApplicationStatus();

			} else if ((c == 'Q') || (c == 'q')) {

				selected = true;
				validationErrors = "\n\n\t		Your chose Approving or denying accounts ..................";
				//System.out.println(validationErrors);
				ManagerApproving();

			} else if ((c == 'C') || (c == 'c')) {

				selected = true;
				validationErrors = "\n\n\t		Your chose Checking your balance ..................";
				ManagerialCheckingBalance();


			} else if ((c == 'T') || (c == 't')) {

				selected = true;
				validationErrors = "\n\n\t		Your chose transfering money ..................";
				ManagerTransferScreen();


			} else if ((c == 'A') || (c == 'a')) {

				validationErrors = "\n\n\t		Your chose viewing Accounts Details ........................................";
				selected = true;
				AccountDetailsScreen();

			} else if ((c == 'I') || (c == 'i')) {

				selected = true;
				validationErrors = "\n\n\t		Your chose viewing Customers Informations ..................";
				CustomerDetailScreen();

			} else if ((c == 'X') || (c == 'x')) {

				selected = false;
				validationErrors = "\n\n\t		Your are exiting  you account ..................";
			}

			else {

				validationErrors = "\n\n\t		You entered the wrong letter. Please correct it!...........";
				System.out.println(validationErrors);
				selected = true;
			}

			// in.nextLine();
		} while (selected == true);


	}

	private static void CancelingAccount() {
		

		Header();

		// System.out.println(" ");
		System.out.println("				----------------------------------------------");
		System.out.println("				-               ACCOUNTS DETAILS            -");
		System.out.println("				----------------------------------------------");
		System.out.print("\n");

		String leftAlignFormat = "    		     | %-8s | %-15s | %-15s | %-15s |%n";

		System.out.format("    		     +----------+-----------------+-----------------+-----------------+%n");
		System.out.format("    		     |Account No| First Name      | Last Name       | Balance         |%n");
		System.out.format("    		     +----------+-----------------+-----------------+-----------------+%n");
		int count = 0;
		Boolean isEmpty = true;
		for (Account acc : accounts.getAccounts()) {

			for (Customer cust : acc.getCustomers()) {
				if (count == 0) {
					System.out.format(leftAlignFormat, acc.getAccountNo(), cust.getFirstName(), cust.getLastName(),
							acc.getBalance());
				} else {
					System.out.format(leftAlignFormat, "     ", cust.getFirstName(), cust.getLastName(), "      ");
				}

				count++;
				isEmpty = false;
			}
			count = 0;
			System.out.format("    		     +----------+-----------------+-----------------+-----------------+%n");
		}
		
		in.nextLine();
		//in.nextLine();
		int accountNo = 0;
		
		if(!isEmpty) {	

			System.out.println("	");
			System.out.println("			WHICH ACCOUNT WOULD YOU LIKE TO CANCEL ?  ");
			System.out.print("				 ENTER THE ACCOUNT NUMBER : ");
			accountNo = in.nextInt();
			in.nextLine();

					

					
		accounts.Delete(accountNo);	
		
		try {
			accounts.Save();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		


		in.nextLine();	

			

		}
		
	}

	private static void ManagerApplicationStatus() {

		int count = 0;
		String isValide = "No";
		int accountNo = 0;
		char c;

		// display the modified list

		// System.out.println(" ");
		System.out.println("				----------------------------------------------");
		System.out.println("				-              APPLICATION STATUS            -");
		System.out.println("				----------------------------------------------");
		System.out.print("\n");

		String leftAlignFormat = "    		     | %-8s | %-15s | %-15s | %-15s |%n";

		System.out.format("    		     +----------+-----------------+-----------------+-----------------+%n");
		System.out.format("    		     | Applic No| First Name      | Last Name       | Approved ?      |%n");
		System.out.format("    		     +----------+-----------------+-----------------+-----------------+%n");

		for (Application app : applications.getApplications()) {

			// if(app.getIsActive()== true) {

			if (app.getIsValide() == false)
				isValide = "No";
			else
				isValide = "Yes";

			for (Customer cust : app.getCustomers()) {

				if (count == 0) {
					System.out.format(leftAlignFormat, app.getApplicationNo(), cust.getFirstName(), cust.getLastName(),
							isValide);
				} else {
					System.out.format(leftAlignFormat, "     ", cust.getFirstName(), cust.getLastName(), "      ");
				}

				count++;
			}

			// }
			count = 0;
			System.out.format("    		     +----------+-----------------+-----------------+-----------------+%n");
		in.nextLine();
		}

	}

	private static void ManagerApproving() {
		// TODO Auto-generated method stub

		Header();

		// System.out.println(" ");
		System.out.println("				----------------------------------------------");
		System.out.println("				-              ACCOUNTS TO APPROVE            -");
		System.out.println("				----------------------------------------------");
		System.out.print("\n");

		String leftAlignFormat = "    		     | %-8s | %-15s | %-15s | %-15s |%n";

		System.out.format("    		     +----------+-----------------+-----------------+-----------------+%n");
		System.out.format("    		     | Applic No| First Name      | Last Name       | Approved ?      |%n");
		System.out.format("    		     +----------+-----------------+-----------------+-----------------+%n");
		int count = 0;
		String isValide = "No";
		int accountNo = 0;

		char c;
		boolean found = false;

		for (Application app : applications.getApplications()) {

			if (app.getIsActive() == true) {
				
				found = true;

				if (app.getIsValide() == false)
					isValide = "No";
				else
					isValide = "Yes";

				for (Customer cust : app.getCustomers()) {

					if (count == 0) {
						System.out.format(leftAlignFormat, app.getApplicationNo(), cust.getFirstName(),
								cust.getLastName(), isValide);
					} else {
						System.out.format(leftAlignFormat, "     ", cust.getFirstName(), cust.getLastName(), "      ");
					}

					count++;
				}

			}
			count = 0;
			System.out.format("    		     +----------+-----------------+-----------------+-----------------+%n");
		}
		
	if(found) {	

		System.out.println("	");
		System.out.println("			WHICH APPLICATION  WOULD YOU LIKE TO APPROVE/DENY  ?  ");
		System.out.print("				 ENTER THE APPLICATION NUMBER : ");
		accountNo = in.nextInt();
		in.nextLine();

		System.out.println("	");
		System.out.print("			ENTER [Y] FOR YES TO APPROVE OR [N] FOR NO TO DENY : ");

		c = in.nextLine().charAt(0);
		in.nextLine();
		// in.nextLine();

		
		Application oldApp = new Application();
				

		for (Application app : applications.getApplications()) {

			if ((app.getApplicationNo() == accountNo) && (app.getIsActive() == true)) {

				oldApp = app;

				try {

					if ((c == 'Y') || (c == 'y')) {
						

						Header();
						System.out.print("\n					    HOW MUCH DO YOU WANT TO DEPOSIT? : ");
						double deposit = in.nextDouble();



						app.setIsActive(false);
						app.setIsValide(true);

						applications.Edit(oldApp, app);

						for (Customer cust : app.getCustomers()) {

							customers.Add(cust);
						}

						customers.Save();
						applications.Save();
						
						Account newAccount = new Account();
						//currentEmployee
						newAccount.setCustomers(app.getCustomers());
						newAccount.deposit(deposit);
						
						accounts.Add(newAccount);
						
						
						accounts.Save();

					} else if ((c == 'N') || (c == 'n')) {

						app.setIsActive(false);
						app.setIsValide(false);
						
						System.out.println("\n\t\t\t\t  avant edit : " + app.getApplicationNo() 
						+ "   IsValide : " + app.getIsValide() );

						applications.Edit(oldApp, app);
						
						System.out.println("\n\t\t\t\t  old : " + oldApp.getApplicationNo() 
						+ "   IsValide : " + oldApp.getIsValide() );
						
						System.out.println("\n\t\t\t\t  new : " + app.getApplicationNo() 
						+ "   IsValide : " + app.getIsValide() );

					} else
						System.out.println(" \n\t\t\t  You entered the wrong letter !");

				} catch (Exception ex) {

					System.out.println(" \n\t\t\t  Operation failed!");
				}

			} else
				System.out.println("\n\t\t\t  There is no such application to review/approve");

		}
	}
		
	
	// display the modified list
		Header();
		// System.out.println(" ");
		System.out.println("				----------------------------------------------");
		System.out.println("				-              APPLICATION STATUS            -");
		System.out.println("				----------------------------------------------");
		System.out.print("\n");

		leftAlignFormat = "    		     | %-8s | %-15s | %-15s | %-15s |%n";

		System.out.format("    		     +----------+-----------------+-----------------+-----------------+%n");
		System.out.format("    		     | Applic No| First Name      | Last Name       | Approved ?      |%n");
		System.out.format("    		     +----------+-----------------+-----------------+-----------------+%n");

		for (Application app : applications.getApplications()) {

			// if(app.getIsActive()== true) {

			if (app.getIsValide() == false)
				isValide = "No";
			else
				isValide = "Yes";

			for (Customer cust : app.getCustomers()) {

				if (count == 0) {
					System.out.format(leftAlignFormat, app.getApplicationNo(), cust.getFirstName(), 
							cust.getLastName(), isValide);
				} else {
					System.out.format(leftAlignFormat, "     ", cust.getFirstName(), cust.getLastName(), "      ");
				}

				count++;
			}

			// }
			count = 0;
			System.out.format("    		     +----------+-----------------+-----------------+-----------------+%n");
		}

		in.nextLine();

	}

	private static void ManagerTransferScreen() {

		int accountNoFrom = 0;
		int accountNoTo = 0;
		double amount = 0.0;
		String ValidationErrors = "";

		Header();

		// System.out.println(" ");
		System.out.println("				----------------------------------------------");
		System.out.println("				-               MANAGER TRANSFER SCREEN             -");
		System.out.println("				----------------------------------------------");
		System.out.print(" ");
		System.out.println("	");
		System.out.println("					    LIST OF YOUR ACCOUNTS    ");

		System.out.println("	");
		

		String leftAlignFormat = "					| %-8s | %-15s |%n";

		System.out.format("					+----------+-----------------+%n");
		System.out.format("					|Account No|    Balance      |%n");
		System.out.format("					+----------+-----------------+%n");

		int accountCount = 0;
		for (Account acc : accounts.getAccounts()) {

			System.out.format(leftAlignFormat, acc.getAccountNo(), acc.getBalance());
			accountCount++;
			System.out.format("					+----------+-----------------+%n");

		}

		
		if(accountCount > 1) {
			
		
		System.out.println("	");
		System.out.print("				 WHICH ACCOUNT WOULD YOU LIKE TO TRANSFER FROM  ?  : ");
		accountNoFrom = in.nextInt();
		in.nextLine();

		System.out.println("	");
		System.out.print("				 WHICH ACCOUNT WOULD YOU LIKE TO TRANSFER TO    ?  : ");
		accountNoTo = in.nextInt();
		in.nextLine();

		System.out.print("\n				 HOW MUCH DO YOU WOULD YOU LIKE TO TRANSFER TO  ?  : ");

		amount = in.nextDouble();

		// withdraw money from the account from
		for (Account acc : accounts.getAccounts()) {

			if (accountNoFrom == acc.getAccountNo()) {
				try {

					if ((acc.getBalance() - amount) < 0) {

						ValidationErrors = "\n\n			Error : This operation failed because you don't have enough money in your account ..........  ";
						System.out.println(ValidationErrors);
					} else {

						acc.withdraw(amount);
						accountsTransferable.add(acc);
					}

				} catch (NegativeAmount e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			// System.out.println("\n\n AccountNo Transferable : " + acc.getAccountNo());

			// deposit money to the account to
			if (accountNoTo == acc.getAccountNo()) {
				try {
					acc.deposit(amount);
					accountsTransferable.add(acc);

					ValidationErrors = "\n\n				 Operation succeed :  Money Transfered ..........  ";
					System.out.println(ValidationErrors);
				} catch (NegativeAmount e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			in.nextLine();

		}

		// update date the database(accounts)
		for (Account source : accountsTransferable) {

			for (Account destination : accounts.getAccounts()) {
				// System.out.println("\n Before update " + destination.toString());
				if (source.getAccountNo() == destination.getAccountNo()) {

					accounts.Edit(destination, source);

					// System.out.println("\n After update " + destination.toString());
				}
			}

		}
		
		}else
			System.out.println("\n\t\t\t   You don't have two or more accounts to transfer to.   ");
		
		in.nextLine();
		

		// System.out.println(" ");
		System.out.println("				----------------------------------------------");
		System.out.println("				-               CUSTOMER BANKING             -");
		System.out.println("				----------------------------------------------");
		System.out.print(" ");
		System.out.println("	");
		System.out.println("					    YOUR ACCOUNTS BALANCES    ");

		System.out.println("	");

		leftAlignFormat = "					| %-8s | %-15s |%n";

		System.out.format("					+----------+-----------------+%n");
		System.out.format("					|Account No|    Balance      |%n");
		System.out.format("					+----------+-----------------+%n");

		for (Account acc3 : accounts.getAccounts()) {

			System.out.format(leftAlignFormat, acc3.getAccountNo(), acc3.getBalance());
			System.out.format("					+----------+-----------------+%n");
		}

		System.out.println("\n\n			............... PRESS ENTER TO CONTINUE...............  ");
		in.nextLine();

	}

	private static void ManagerialCheckingBalance() {
		// TODO Auto-generated method stub
		Boolean isPositive = true;
		String validationErrors = "";
		int accountNo = 0;
		double amount = 0.0;
		String currentUserName = " ";

		do {
			Header();
			// System.out.println(" ");
			System.out.println("				----------------------------------------------");
			System.out.println("				-          MANAGER CHECKING BALANCE              -");
			System.out.println("				----------------------------------------------");
			System.out.print(" ");

			System.out.print("\n				      ENTER THE ACCOUNT No ?           :  ");

			try {

				accountNo = in.nextInt();

				System.out.println(" ");
				System.out.println("				           ---------------------------");
				System.out.println("				           -     ACCOUNTS DETAILS    -");
				System.out.println("				           ---------------------------");
				System.out.print("\n");

				String leftAlignFormat = "    		     | %-8s | %-15s | %-15s | %-15s |%n";

				System.out.format("    		     +----------+-----------------+-----------------+-----------------+%n");
				System.out.format("    		     |Account No| First Name      | Last Name       | Balance         |%n");
				System.out.format("    		     +----------+-----------------+-----------------+-----------------+%n");
				int count = 0;
				for (Account acc : accounts.getAccounts()) {

					if (acc.getAccountNo() == accountNo) {

						currentAccount = acc;
						for (Customer cust : acc.getCustomers()) {

							currentUserName += cust.getFirstName() + "  &  ";
							if (count == 0) {
								System.out.format(leftAlignFormat, acc.getAccountNo(), cust.getFirstName(),
										cust.getLastName(), acc.getBalance());
							} else {
								System.out.format(leftAlignFormat, "     ", cust.getFirstName(), cust.getLastName(),
										"      ");
							}

							count++;
						}
						count = 0;
						System.out.format(
								"    		     +----------+-----------------+-----------------+-----------------+%n");

					}

				}

				double balance = currentAccount.getBalance();

				currentUserName = currentCustomer.getUserName();

				// newBalance = currentAccount.getBalance();

				// Header();

				System.out.println("\n\n				............. PRESS ENTER TO CONTINUE...........  ");
			} catch (Exception ex) {

				System.out.println("  account exception " + ex);
			}

			in.nextLine();
			in.nextLine();

		} while (isPositive == false);

	}

	private static void ManagerWithdrawing() {

		// TODO Auto-generated method stub
		Boolean isPositive = true;
		String validationErrors = "";
		int accountNo = 0;
		double amount = 0.0;
		String currentUserName = " ";

		do {
			Header();
			// System.out.println(" ");
			System.out.println("				----------------------------------------------");
			System.out.println("				-             MANAGER WITHDRAWING              -");
			System.out.println("				----------------------------------------------");
			System.out.print(" ");

			System.out.print("\n				      ENTER THE ACCOUNT No ?           :  ");
			accountNo = in.nextInt();

			System.out.println(" ");
			System.out.println("				           ---------------------------");
			System.out.println("				           -     ACCOUNTS DETAILS    -");
			System.out.println("				           ---------------------------");
			System.out.print("\n");

			String leftAlignFormat = "    		     | %-8s | %-15s | %-15s | %-15s |%n";

			System.out.format("    		     +----------+-----------------+-----------------+-----------------+%n");
			System.out.format("    		     |Account No| First Name      | Last Name       | Balance         |%n");
			System.out.format("    		     +----------+-----------------+-----------------+-----------------+%n");
			int count = 0;
			for (Account acc : accounts.getAccounts()) {

				if (acc.getAccountNo() == accountNo) {

					currentAccount = acc;
					for (Customer cust : acc.getCustomers()) {

						currentUserName += cust.getFirstName() + "  &  ";
						if (count == 0) {
							System.out.format(leftAlignFormat, acc.getAccountNo(), cust.getFirstName(),
									cust.getLastName(), acc.getBalance());
						} else {
							System.out.format(leftAlignFormat, "     ", cust.getFirstName(), cust.getLastName(),
									"      ");
						}

						count++;
					}
					count = 0;
					System.out.format(
							"    		     +----------+-----------------+-----------------+-----------------+%n");

				}

			}

			double balance = currentAccount.getBalance();
			double newBalance = 0.0;
			// Account newAccount = new Account();
			Account oldAccount = new Account();

			oldAccount = currentAccount;

			System.out.print("\n				HOW MUCH DO YOU WANT TO WITHDRAW ?      :  ");

			try {

				amount = in.nextDouble();
				in.nextLine();

				currentAccount.withdraw(amount);

				accounts.Edit(oldAccount, currentAccount);

				newBalance = currentAccount.getBalance();

				Header();
				// System.out.println(" ");
				System.out.println("				----------------------------------------------");
				System.out.println("				-               CUSTOMER DETAILS             -");
				System.out.println("				----------------------------------------------");
				System.out.print(" ");

				System.out.println("\n				    USER :  " + currentUserName.toUpperCase());
				System.out.println("\n				    Your  Balance was    : " + balance);
				System.out.println("\n				    You withdrew         : " + amount);
				System.out.println("\n				    Your  new Balance is : " + newBalance);
				// System.out.println("\n\n ............... PRESS ENTER TO
				// CONTINUE............... ");

				isPositive = true;

			} catch (NegativeAmount ex) {

				System.out.println("\n					Account exception " + ex);
				validationErrors = " \n 				Please try again !  : ";
				isPositive = false;

			} catch (Exception ex) {

				System.out.println("\n				Account exception " + ex);
			}

			System.out.println(validationErrors);

			System.out.println("\n\n			............... PRESS ENTER TO CONTINUE............... : ");

			in.nextLine();

		} while (isPositive == false);

	}

	private static void ManagerDepositing() {
		// TODO Auto-generated method stub
		Boolean isPositive = true;
		String validationErrors = "";
		int accountNo = 0;
		double amount = 0.0;
		String currentUserName = " ";

		do {
			Header();
			// System.out.println(" ");
			System.out.println("				----------------------------------------------");
			System.out.println("				-             MANAGER DEPOSITING              -");
			System.out.println("				----------------------------------------------");
			System.out.print(" ");

			System.out.print("\n				      ENTER THE ACCOUNT No ?           :  ");
			accountNo = in.nextInt();

			System.out.println(" ");
			System.out.println("				           ---------------------------");
			System.out.println("				           -     ACCOUNTS DETAILS    -");
			System.out.println("				           ---------------------------");
			System.out.print("\n");

			String leftAlignFormat = "    		     | %-8s | %-15s | %-15s | %-15s |%n";

			System.out.format("    		     +----------+-----------------+-----------------+-----------------+%n");
			System.out.format("    		     |Account No| First Name      | Last Name       | Balance         |%n");
			System.out.format("    		     +----------+-----------------+-----------------+-----------------+%n");
			int count = 0;
			for (Account acc : accounts.getAccounts()) {

				if (acc.getAccountNo() == accountNo) {

					currentAccount = acc;
					for (Customer cust : acc.getCustomers()) {

						currentUserName += cust.getFirstName() + "  &  ";
						if (count == 0) {
							System.out.format(leftAlignFormat, acc.getAccountNo(), cust.getFirstName(),
									cust.getLastName(), acc.getBalance());
						} else {
							System.out.format(leftAlignFormat, "     ", cust.getFirstName(), cust.getLastName(),
									"      ");
						}

						count++;
					}
					count = 0;
					System.out.format(
							"    		     +----------+-----------------+-----------------+-----------------+%n");

				}

			}

			double balance = currentAccount.getBalance();
			double newBalance = 0.0;
			// Account newAccount = new Account();
			Account oldAccount = new Account();

			oldAccount = currentAccount;

			System.out.print("\n				HOW MUCH DO YOU WANT TO DEPOSIT ?      :  ");

			try {

				amount = in.nextDouble();
				in.nextLine();

				currentAccount.deposit(amount);

				accounts.Edit(oldAccount, currentAccount);

				newBalance = currentAccount.getBalance();

				Header();
				// System.out.println(" ");
				System.out.println("				----------------------------------------------");
				System.out.println("				-               CUSTOMER DETAILS             -");
				System.out.println("				----------------------------------------------");
				System.out.print(" ");

				System.out.println("\n				    USER :  " + currentUserName.toUpperCase());
				System.out.println("\n				    Your  Balance was    : " + balance);
				System.out.println("\n				    You deposited        : " + amount);
				System.out.println("\n				    Your  new Balance is : " + newBalance);
				// System.out.println("\n\n ............... PRESS ENTER TO
				// CONTINUE............... ");

				isPositive = true;

			} catch (NegativeAmount ex) {

				System.out.println("\n					Account exception " + ex);
				validationErrors = " \n 				Please try again !  : ";
				isPositive = false;

			} catch (Exception ex) {

				System.out.println("\n				Account exception " + ex);
			}

			System.out.println(validationErrors);

			System.out.println("\n\n			............... PRESS ENTER TO CONTINUE............... : ");

			in.nextLine();

		} while (isPositive == false);

	}

	private static void Application() {

		// TODO : Customers should be able to apply for joint accounts
		String validationErrors = " ";

		Boolean selected = false;

		do {
			Header();

			System.out.println("");
			System.out.println("				WOULD YOU LIKE TO APPLY FOR A NEW ACCOUNT ?  ");
			System.out.print("	 			ENTER [ Y ] TO APPLY AND [ X ] EXIT : ");
			char c = in.nextLine().charAt(0);

			if ((c == 'Y') || (c == 'y')) {

				validationErrors = "\n\n\t		Please be aware. You will need your ID CARD and SSN....";
				System.out.println(validationErrors);
				selected = true;
				OpenAccount();

				//System.out.println("			Caller Methode Application :   got out from OpenAccount");

			} else if ((c == 'X') || (c == 'x')) {
				Welcome();
				selected = true;
			}

			else
				System.out.println("\n			You entered the wrong letter. Please Try again! ");

			// System.out.println(" selected is : " + selected);
			in.nextLine();
		} while (selected == !true);

	}

	public static void Save() throws IOException {
		String validationErrors = " ";

		System.out.println("		The save methode Driver is reached");

		try {

			customers.Save();
			validationErrors = "";
		} catch (IOException ex) {

			ex.printStackTrace();
			validationErrors = "		The serialized object failed to be written to BankingDB.txt file." + ex;
		}

		System.out.println(validationErrors);

	}

	public static Customer CreateCustomer() {

		int customerNo = 0;
		String firstName;
		String lastName;
		String title;
		String sSN;
		String dOB;
		String address;
		String zipCode;
		String userName = "";
		String passWord = "";
		String emailAddress;
		String phone;
		Date modifiedDate;
		Boolean isActive;

		Scanner in = new Scanner(System.in);

		System.out.print("\n\n ");
		System.out.print("		 ENTER YOUR TITLE   	 :  ");
		title = in.nextLine();
		System.out.print("		 ENTER YOUR FIRST NAME 	 :  ");
		firstName = in.nextLine();
		System.out.print("		 ENTER YOUR LAST NAME 	 :  ");
		lastName = in.nextLine();
		System.out.print("		 ENTER YOUR SSN          :  ");
		sSN = in.nextLine();
		System.out.print("		 ENTER YOUR DATE OF BIRTH:  ");
		dOB = in.nextLine();
		System.out.print("		 ENTER YOUR ADDRESS 	 :  ");
		address = in.nextLine();
		System.out.print("		 ENTER YOUR ZIP CODE     :  ");
		zipCode = in.nextLine();
		System.out.print("		 ENTER YOUR EMAIL        :  ");
		emailAddress = in.nextLine();
		System.out.print("		 ENTER YOUR PHONE        :  ");
		phone = in.nextLine();
		System.out.print("\t\t ENTER YOUR ZIPCODE      :  ");
		zipCode = in.nextLine();
		modifiedDate = (new Date());
		isActive = false;

		Customer cust = new Customer(customerNo, title, firstName, lastName, sSN, dOB, address, zipCode, emailAddress,
				phone, userName, passWord, modifiedDate);

		in.close();
		return cust;
	}

	public static void LoadData() throws ClassNotFoundException, IOException {

		/*
		 * ArrayList<Customer> myCust = new ArrayList<Customer>();
		 * 
		 * myCust.add( new Customer(0001, "Mr.", "Ronsard", "Malonda", "111-11-1111",
		 * "12/01/1999", "20 Maple Ave", "19440", "Albert@yabiso.com",
		 * "424-858-9874","aaaaa","123456", (new Date())));
		 * 
		 * myCust.add( new Customer(0002, "Mr.", "Paguy", "Malonda", "111-12-1111",
		 * "12/01/8099", "20 Maple Ave", "19440", "ferralt@yabiso.com",
		 * "424-858-9874","bbbbb","123456", (new Date()))); for(Customer c : myCust) {
		 * 
		 * //customers.Add(c); }
		 * 
		 */

		// customers.Save();
		//customers.getData();
		// System.out.println(customers.getCustomers());

		for (Customer c : customers.getCustomers()) {
			System.out.println(c);
		}

		ArrayList<Customer> myCust2 = new ArrayList<Customer>();

		myCust2.add(new Customer(0003, "Mr.", "Mymy", "Malonda", "111-99-1111", "12/01/1999", "20 Maple Ave", "19440",
				"Albert@yabiso.com", "424-858-9874", "ccccc", "123456", (new Date())));
		myCust2.add(new Customer(0001, "Mr.", "Ronsard", "Malonda", "111-11-1111", "12/01/1999", "20 Maple Ave",
				"19440", "Albert@yabiso.com", "424-858-9874", "aaaaa", "123456", (new Date())));

		for (Customer c : myCust2) {

			customers.Add(c);
		}

		Application app = new Application();
		app.setCustomers(myCust2);

		applications.Add(app);

		Employee emp = new Employee(0001, "Mr.", "Tralie", "Charlie", "222-22-2222", "12/01/2000", "20 Maple Ave",
				"Colmar", "PA", "25486", "farlone@yabiso.com", "424-858-9874", "eaaaa", "123456", (new Date()), true);

		// employees.Add(emp);
		// employees.Save();


		// System.out.println(customers.getCustomers());

		for (Employee c : employees.getEmployees()) {
			System.out.println(c);
		}

		// accounts.Add( new Account( 0005, myCust, 20.0));

		accounts.Add(new Account(0001, myCust2, 20.0));

		/*
		 * String userName = "bbbbb"; String passWord ="123456";
		 * 
		 * for (Account acc : accounts.getAccounts()) {
		 * 
		 * System.out.println("		user found ......Account No :" + acc.getAccountNo()
		 * + "  Amount : " + acc.getBalance()); for (Customer cust : acc.getCustomers())
		 * {
		 * 
		 * if ((userName == cust.getUserName()) && (passWord == cust.getPassWord())) {
		 * 
		 * currentAccount = acc; currentCustomer = cust;
		 * 
		 * System.out.println("					user found ......:" +
		 * cust.getEmailAddress()); }
		 * 
		 * }
		 * 
		 * }
		 * 
		 */

	}

	public static void GetData() throws Exception {

		try {
			
			File employeeFile = new File("Employees.txt");
			if (employeeFile.exists()) {

				employees.getData();
				
				for(Employee emp : employees.getEmployees()) {
					
					System.out.println(" \n\t\t\t        " + emp);
				}
				
			} else {
				System.out.println(" \n\t\t\t        Employees.txt doesn't exist.....................");
			}
			
			
			File customerFile = new File("Customers.txt");
			if (customerFile.exists()) {

				customers.getData();
				
				for(Customer cust : customers.getCustomers()) {
					
					System.out.println(" \n\t\t\t        " + cust);
				}
				
			} else {
				System.out.println(" \n\t\t\t        Customers.txt doesn't exist.....................");
			}
			
			File applicationFile = new File("Applications.txt");
			if (applicationFile.exists()) {

				applications.getData();
			} else {
				System.out.println(" \n\t\t\t        Applications.txt doesn't exist.....................");
			}
			
			File accountFile = new File("Accounts.txt");
			if (accountFile.exists()) {

				accounts.getData();
			} else {
				System.out.println(" \n\t\t\t        Accounts.txt doesn't exist.....................");
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void printCustomers(CustomerViewModel cust) {

		System.out.println("\n\n");

		for (Customer c : cust.getCustomers()) {

			System.out.println("\t\t" + c.toString());
		}

	}

	private static Employee IsEmployee() {

		int employeeNo;
		String Title;
		String firstName;
		String lastName;
		String sSN;
		String DOB;
		String address;
		String city;
		String state;
		String zipCode;
		String EmailAddress;
		String Phone;
		Date ModifiedDate;
		Boolean isManager;

		String SSN;

		Boolean tryAgain = false;
		Boolean selected = false;
		String validationErrors = " ";

		Boolean found = false;

		int count = 0;
		// Scanner in = new Scanner(System.in);

		do {

			Header();

			count++;

			// System.out.println(" ");
			System.out.println("				----------------------------------------------");
			System.out.println("				-               AGENT ACCOUNT                -");
			System.out.println("				----------------------------------------------");
			System.out.print(" ");

			/*
			 * System.out.print("				ENTER YOUR FIRST NAME 	 :  "); firstName =
			 * in.nextLine();
			 * System.out.print("				ENTER YOUR LAST NAME 	 :  "); lastName =
			 * in.nextLine();
			 * System.out.print("				ENTER YOUR SSN           :  "); sSN =
			 * in.nextLine();
			 

			firstName = "Agent";
			lastName = "Verizon";
			sSN = "222-22-2222";

			Employee e = new Employee(0001, "Mr.", "Tralie", "Charlie", "222-22-2222", "12/01/2000", "20 Maple Ave",
					"Colmar", "PA", "25486", "Albert@yabiso.com", "424-858-9874", "winning7", "aaaa", (new Date()),
					true);

			employees.Add(e);
			
			

			for (Employee emp : employees.getEmployees()) {

				if ((emp.getSSN().equals(sSN))) {

					System.out.println("\n				SSN is : " + emp.getSSN());
					// in.close();
					return emp;
				} else {

					validationErrors = "\n\n\t		Employee's  userName and/or password entered is incorrect      ";
					System.out.println(validationErrors);

					do {

						System.out.println("\n");
						System.out.print(
								"		Would you like to try again ? 	  ENTER ( Y ) TO Continue AND ( N ) TO Exit : ");

						char c = in.nextLine().charAt(0);
						// in.nextLine();

						if ((c == 'Y') || (c == 'y')) {

							tryAgain = true;
							selected = true;
							validationErrors = "\n\n\t		LOGGIN failure " + count + " " + firstName + " " + lastName
									+ " trying  again";
							System.out.println(validationErrors);

						} else if ((c == 'N') || (c == 'n')) {
							tryAgain = false;
							selected = true;
							validationErrors = "\n\n\t		LOGGIN failure " + count + " " + firstName + " " + lastName
									+ " Please Call for assistance! ";
							System.out.println(validationErrors);

						} else {

							validationErrors = "\n\n\t		You entered the wrong letter. Please Try again!............";
							System.out.println(validationErrors);
							selected = false;
							tryAgain = true;
						}

					} while (!selected);

				}

			}
			*/

		} while (tryAgain);

		return null;
	}

	private static void OpenAccount() {

		int customerNo = 0;
		String firstName;
		String lastName;
		String title;
		String sSN;
		String dOB;
		String address;
		String zipCode;
		String userName = "";
		String passWord = "";
		String cpassWord;
		String emailAddress;
		String phone;
		// Date modifiedDate;
		// Boolean isActive;
		int nPeople = 1;

		// TODO : Checking whether the person is an employee.
		String validationErrors = " ";
		Employee emp = new Employee();

		//emp = IsEmployee();

		//if ((emp != null)) {

			Header();

			double deposit = 0.0;

			Boolean selected = false;
			Boolean isJoint = false;
			int count = 0;

			// ------------------------------------

			CustomerViewModel newCustomersVM = new CustomerViewModel();
			Customer newCust = new Customer();

			// System.out.println(" ");
			System.out.println("				----------------------------------------------");
			System.out.println("				-               CUSTOMER DETAILS             -");
			System.out.println("				----------------------------------------------");
			System.out.print(" ");
			/*
			 * System.out.print("				IS THIS A JOINT ACCOUNT ?	 :  ");
			 * 
			 * isJoint = in.nextBoolean();
			 */

			isJoint = true;

			if (isJoint) {

				System.out.print("				FOR HOW MANY PEOPLE ?	 :  ");
				nPeople = in.nextInt();
				in.nextLine();
			}

			for (int index = 0; index < nPeople; index++) {

				Header();

				// System.out.println(" ");
				System.out.println("				----------------------------------------------");
				System.out.println("				-               CUSTOMER DETAILS             -");
				System.out.println("				----------------------------------------------");
				System.out.print(" ");
				System.out.print(" ");
				System.out.print("			 	ENTER YOUR TITLE   	 :  ");

				try {
					title = in.nextLine();

					System.out.print("		 		ENTER YOUR FIRST NAME 	 :  ");
					firstName = in.nextLine();
					System.out.print("		 		ENTER YOUR LAST NAME 	 :  ");
					lastName = in.nextLine();
					System.out.print("		 		ENTER YOUR SSN           :  ");
					sSN = in.nextLine();
					System.out.print("		 		ENTER YOUR DATE OF BIRTH :  ");
					dOB = in.nextLine();
					System.out.print("		 		ENTER YOUR ADDRESS       :  ");
					address = in.nextLine();
					System.out.print("		 		ENTER YOUR ZIP CODE      :  ");
					zipCode = in.nextLine();
					System.out.print("		 		ENTER YOUR EMAIL         :  ");
					emailAddress = in.nextLine();
					System.out.print("		 		ENTER YOUR PHONE         :  ");
					phone = in.nextLine();
					// modifiedDate = (new Date());
					// isActive = false;

					// in.nextLine();
					// Header();

					Boolean matched = false;

					do {

						Header();

						try {
							// System.out.println(" ");
							System.out.println("				----------------------------------------------");
							System.out.println("				-               CUSTOMER DETAILS             -");
							System.out.println("				----------------------------------------------");
							System.out.print(" ");

							System.out.print("				ENTER YOUR USERNAME   	 :  ");
							userName = in.nextLine();
							System.out.print("				ENTER YOUR PASSWORD 	 :  ");
							passWord = in.nextLine();
							System.out.print("				CONFIRM YOUR PASSWORD 	 :  ");
							cpassWord = in.nextLine();


							if (passWord.equals(cpassWord)) {

								System.out.println(" 				password Matched");
								matched = true;

							} else {

								matched = false;
								System.out.println(" 				password did not Match. Please try again !");
							}
							
							in.nextLine();

						} catch (Exception ex) {

							System.out.println("\t\t error : " + ex);
						}

					} while (!matched);

					newCust = (RegisterCustomer(customerNo, title, firstName, lastName, sSN, dOB, address, zipCode,
							emailAddress, phone, userName, passWord));

					newCustomersVM.Add(newCust);

					validationErrors = "\n\n\t		NewCustomerss added! " + title + "  " + firstName + " " + lastName
							+ " ";
					System.out.println(validationErrors);

					
					// Create an application
					Application app = new Application();
					app.setCustomers(newCustomersVM.getCustomers());
					app.setIsActive(true);
					app.setIsValide(false);
					
					applications.Add(app);
					applications.Save();
					
					applications.getData();
					
				} catch (Exception ex) {
					System.out.println(ex);
				}

			}

		//}

	}

	/*
	 * private static void BankAdmin() {
	 * 
	 * // Bank admins should be able to view and edit all accounts // This includes:
	 * 
	 * // o Approving/denying accounts // o withdrawing, depositing, transferring
	 * from all accounts // o canceling accounts
	 * 
	 * 
	 * 
	 * }
	 * 
	 */

	private static Boolean ApproveAccount(String firstName, String lastName, String title, String sSN, String dOB,
			String address, String zipCode) {

		// Employees should be able to approve/deny open applications for accounts
		Header();
		String validationErrors = " ";
		Boolean isApproved = false;
		Boolean selected = false;
		// Scanner in = new Scanner(System.in);

		do {

			System.out.println("	  			----------------------------------------------");
			System.out.println("	  			-	WOULD YOU LIKE TO APPROVE THIS CUSTOMER ?-");
			System.out.println("	  			----------------------------------------------");
			System.out.println("	  			-											 -");
			System.out.println("	  			-		TITLE         : " + title + "		 -");
			System.out.println("	  			-		FIRST NAME    : " + firstName + "	 -");
			System.out.println("	 			-		LAST NAME     : " + lastName + "	 -");
			System.out.println("	  			-		DATE OF BIRTH : " + dOB + "			 -");
			System.out.println("	  			-		ADDRESS       : " + address + "		 -");
			System.out.println("	  			-		ZIP CODE      : " + zipCode + "		 -");
			System.out.println("	  			-											 -");
			System.out.println("	  			----------------------------------------------");
			System.out.println(" ");
			System.out.print("	  			ENTER ( Y ) TO APPROVE AND ( N ) TO DENY : ");
			char c = in.nextLine().charAt(0);
			// in.nextLine();

			if ((c == 'Y') || (c == 'y')) {

				// Customer Approved
				isApproved = true;
				selected = true;
				validationErrors = "\n\n\t		Customer Approved..........................................";
				System.out.println(validationErrors);

			} else if ((c == 'N') || (c == 'n')) {

				// Customer denied
				isApproved = false;
				selected = true;
				validationErrors = "\n\n\t		Customer Denied............................................";
				System.out.println(validationErrors);
			} else {

				selected = false;
				validationErrors = "\n\n\t		You entered the wrong letter. Please Try again!............";
				System.out.println(validationErrors);

			}

		} while (!selected);

		// in.close();
		return isApproved;
	}

	private static Customer RegisterCustomer(int customerNo, String title, String firstName, String lastName,
			String sSN, String dOB, String address, String zipCode, String emailAddress, String phone, String userName,
			String passWord) {

		try {
			Customer cust = new Customer();
			cust.setTitle(title);
			cust.setFirstName(firstName);
			cust.setLastName(lastName);
			cust.setSSN(sSN);
			cust.setDOB(dOB);
			cust.setAddress(address);
			cust.setZipCode(zipCode);
			cust.setEmailAddress(emailAddress);
			cust.setPhone(phone);
			cust.setUserName(userName);
			cust.setPassWord(passWord);
			cust.setIsActive(true);
			cust.setModifiedDate(new Date());

			return cust;

		} catch (Exception ex) {

			System.out.println("Registration failed!" + ex);
			return null;
		}

	}

	/*
	 * private static void Banking() {
	 * 
	 * /* Once the account is open, customers should be able to withdraw, deposit,
	 * and transfer funds between accounts
	 */
	/*
	 * System.out.println("Banking ");
	 * 
	 * //Scanner in = new Scanner(System.in); selected = false;
	 * 
	 * do {
	 * 
	 * System.out.println("\t\t WHAT CAN I DO FOR YOU ?  "); System.out.
	 * print("\t\t PLEASE ENTER ( B ) FOR BANKING AND ( A ) FOR APPLYING : "); char
	 * c = in.next().charAt(0);
	 * 
	 * if((c == 'B') || (c == 'b')) { Banking(); selected = true;
	 * 
	 * }else if ((c == 'A') || (c == 'a')) { Application(); selected = true; }
	 * 
	 * else System.out.println("You entered the wrong letter. Please correct it! ");
	 * 
	 * }while(selected == !true);
	 * 
	 * 
	 * 
	 * 
	 * 
	 * }
	 * 
	 * private static void validation() {
	 * 
	 * // All basic validation should be done, such as trying to input negative
	 * amounts, overdrawing from accounts etc.
	 * 
	 * 
	 * 
	 * }
	 * 
	 * private static void ViewAccount(){
	 * 
	 * // Employees of the bank should be able to view all of their customers
	 * information // This includes, account information, Account balances, Personal
	 * information.
	 * 
	 * 
	 * }
	 * 
	 * private static void Close() { // TODO Auto-generated method stub in.close();
	 * 
	 * }
	 * 
	 */

}
