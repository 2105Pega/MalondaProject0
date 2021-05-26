package com.revature;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.Test;

import com.revature.beans.Employee;
import com.revature.viewModels.EmployeeViewModel;



public class EmployeeViewModelTest  
{
	
	static EmployeeViewModel employees = new EmployeeViewModel();
	static Boolean succeed = false;
	
	@Test
	public void addition() {
		
	
		System.out.println("\n\n\t\t Addition started-------------------------------------------------");
		succeed = false;
		
		Employee emp = new Employee(0001, "Mr.", "Tralie", "Charlie", "222-22-2222","12/01/2000", 
				"20 Maple Ave","Colmar", "PA","25486", "Albert@yabiso.com", "424-858-9874", "winning7", "aaaa" ,(new Date()), true);
		
		

		Boolean succeed = employees.Add(emp);
		
		
		Boolean passed = true;
		assertEquals(passed, succeed);
	}
		
	@Test
	public void Editing() {
		
		System.out.println("\n\n\t\t Editing Started---------------- -------------------------------\n\n");
		succeed = false;
		
		Employee emp = new Employee(0002, "Mr.", "Tralie", "Charlie", "222-22-2222","12/01/2000", 
				"200 Maple Ave","Hatfield", "PA","77586", "Ctralie@yabiso.com", "585-635-4879", "winning7", "aaaa" ,(new Date()), true);
		
		succeed = employees.Add(emp);		
		
		Employee oldCust = new Employee(0002, "Mr.", "Mamie", "Kumbu", "222-22-2222","12/01/2000", 
				"2603 Elroy","Hatfield", "PA","77586", "Ctralie@yabiso.com", "585-635-4879", "winning7", "aaaa" ,(new Date()), true);
		
		Employee newCust = employees.CopyEmployee(oldCust);
				
		newCust.setLastName("Mimy");
		newCust.setZipCode("20205");
		
		
		succeed = employees.Edit(oldCust, newCust);
		
		System.out.println(" result : " + succeed );
		
		printEmployees(employees);
		
		Boolean passed = true;
		assertEquals(passed, succeed);
	}
	
	@Test
	public void searchCust() {
		
		System.out.println("\n\n\t\t searchCust started-------------------------------------------------\n\n");
		
		succeed = false;
		
		Employee emp = new Employee(0001, "Mr.", "Tralie", "Charlie", "222-22-2222","12/01/2000", 
				"20 Maple Ave","Colmar", "PA","25486", "Albert@yabiso.com", "424-858-9874", "winning7", "aaaa" ,(new Date()), true);
					
		int index = employees.SearchEmployee(emp);
		
		System.out.println("index search " + index );
		
		//printEmployees(employees);
		
		if( index > -1 ) {
			
			succeed = true;
			
			print(employees.getEmployee(index));
		}
		
		
		Boolean passed = true;
		assertEquals(passed, succeed);
	}
	
	public void print(Employee c){
		
		System.out.println("\n\n\t\t" + c.toString() );
		
	}
	
	public void printEmployees(EmployeeViewModel  emp) {
		
		System.out.println("\n\n");
		
		for (Employee c : emp.getEmployees()) {
									
			System.out.println("\t\t" + c.toString() );
		}
		
	}

}