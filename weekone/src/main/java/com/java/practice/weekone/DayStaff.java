package com.java.practice.weekone;

import java.util.Scanner;

public class DayStaff extends Staff{
	// Nhân viên công nhật: số ngày * 55.000 vnđ 
	final int UNIT_PRICE = 55000;
	int workingDay = 0;
	public DayStaff() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param workingDay
	 */
	public DayStaff(int workingDay) {
		super();
		this.workingDay = workingDay;
	}
	/**
	 * @param fullName
	 * @param salary
	 */
	public DayStaff(String fullName, int salary) {
		super(fullName, salary);
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param fullName
	 * @param address
	 * @param birthDay
	 * @param salary
	 */
	public DayStaff(String fullName, String address, String birthDay, int salary) {
		super(fullName, address, birthDay, salary);
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param fullName
	 * @param address
	 * @param birthDay
	 */
	public DayStaff(String fullName, String address, String birthDay) {
		super(fullName, address, birthDay);
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param fullName
	 */
	public DayStaff(String fullName) {
		super(fullName);
		// TODO Auto-generated constructor stub
	}
	public int getWorkingDay() {
		return workingDay;
	}
	public void setWorkingDay(int workingDay) {
		this.workingDay = workingDay;
	}
	@Override
	public void inputInformations() {
		// TODO Auto-generated method stub
		super.inputInformations();
		inputBaseInformation();
		Scanner scan = new Scanner(System.in);
		// input other informations 
		System.out.println("Working day is: ");
		this.workingDay = scan.nextInt();
		
		// calculate salary 
		this.salary = workingDay * UNIT_PRICE;
	}

}
