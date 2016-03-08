package com.java.practice.weekone;

import java.util.Scanner;

/**
 * @author nguyenngocbinh
 *
 */
public class Staff {
	static int id = 0;
	String fullName;
	String address;
	String birthDay;
	int salary = 0;
	public Staff() {
		++this.id;
	}
	
	/**
	 * @param fullName
	 * @param address
	 * @param birthDay
	 */
	public Staff(String fullName, String address, String birthDay) {
		super();
		++this.id;
		this.fullName = fullName;
		this.address = address;
		this.birthDay = birthDay;
	}
	/**
	 * @param fullName
	 * @param address
	 * @param birthDay
	 * @param salary
	 */
	public Staff(String fullName, String address, String birthDay, int salary) {
		super();
		++this.id;
		this.fullName = fullName;
		this.address = address;
		this.birthDay = birthDay;
		this.salary = salary;
	}

	/**
	 * @param fullName
	 */
	public Staff(String fullName) {
		super();
		++this.id;
		this.fullName = fullName;
	}

	/**
	 * @param fullName
	 * @param salary
	 */
	public Staff(String fullName, int salary) {
		super();
		++this.id;
		this.fullName = fullName;
		this.salary = salary;
	}

	public int getId() {
		return id;
	}

	/*public static void setId(int id) {
		Staff.id = id;
	}*/

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(String birthDay) {
		this.birthDay = birthDay;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}
	
	public void inputBaseInformation(){
		Scanner scan = new Scanner(System.in);
		// input base informations 
		System.out.println("Full name is:");
		this.fullName = scan.next();
		
		System.out.println("Address is: ");
		this.address = scan.next();
		
		System.out.println("Birthday is: ");
		this.birthDay = scan.next();
	}
	
	public void inputInformations(){
	}
	
	public void outputBaseInformation(){
		System.out.println(this.id + "	" + this.fullName + "	" + this.address + "	" + this.birthDay + "	" + this.salary + "	");
	}
	
	public void outputInformations(){
		outputBaseInformation();
	}
	
}
