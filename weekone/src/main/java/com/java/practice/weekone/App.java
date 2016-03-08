package com.java.practice.weekone;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	
        Scanner scan = new Scanner(System.in);
        // staff list of the company
        ArrayList<Staff> staffList = new ArrayList<Staff>(); 
        Staff empployee;
        int salarySum = 0;
        // get the number of staff
        System.out.println( "Hello Every body. Please input the number of staff: " );
		int staffNumber = scan.nextInt();
	
		// create staff 
		for(int i = 0; i < staffNumber;i++){
			System.out.println( "0: production staff" );
			System.out.println( "1: day staff" );
			System.out.println( "2 or any : management staff" );
			
			System.out.println( "Please input staff type: " );
			int staffType = scan.nextInt();
			
			// creating staff
			switch (staffType) {
			case 0:
				empployee = new ProductionStaff();
				break;
			case 1: 
				empployee = new DayStaff();
				break;
			default: 
				empployee = new ProductionStaff();
				break;
			}
			
			empployee.inputInformations();
			staffList.add(empployee);
		}
		
		
		for (Staff staff : staffList) {
			salarySum += staff.getSalary();
			staff.outputInformations();
		}
		System.out.println( "Salary sum of all staff is: " + salarySum);
		
    }
}
