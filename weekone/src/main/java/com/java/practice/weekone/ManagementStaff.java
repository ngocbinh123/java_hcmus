package com.java.practice.weekone;

import java.util.Scanner;

public class ManagementStaff extends Staff{
	// Nhân viên quản lý: hệ số lương * lương cơ bản 
	int coefficientSalary = 1;
	int baseSalary = 0;
	public ManagementStaff(){
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param fullName
	 * @param salary
	 */
	public ManagementStaff(String fullName, int salary) {
		super(fullName, salary);
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param fullName
	 * @param address
	 * @param birthDay
	 * @param salary
	 */
	public ManagementStaff(String fullName, String address, String birthDay, int salary) {
		super(fullName, address, birthDay, salary);
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param fullName
	 * @param address
	 * @param birthDay
	 */
	public ManagementStaff(String fullName, String address, String birthDay) {
		super(fullName, address, birthDay);
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param fullName
	 */
	public ManagementStaff(String fullName) {
		super(fullName);
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param coefficientSalary
	 * @param baseSalary
	 */
	public ManagementStaff(int coefficientSalary, int baseSalary) {
		super();
		this.coefficientSalary = coefficientSalary;
		this.baseSalary = baseSalary;
	}
	public int getCoefficientSalary() {
		return coefficientSalary;
	}
	public void setCoefficientSalary(int coefficientSalary) {
		this.coefficientSalary = coefficientSalary;
	}
	public int getBaseSalary() {
		return baseSalary;
	}
	public void setBaseSalary(int baseSalary) {
		this.baseSalary = baseSalary;
	}
	@Override
	public void inputInformations() {
		// TODO Auto-generated method stub
		super.inputInformations();
		Scanner scan = new Scanner(System.in);
		// input other informations 
		System.out.println("Coefficient salary is: ");
		this.coefficientSalary = scan.nextInt();
		
		System.out.println("Salary is: ");
		this.baseSalary = scan.nextInt();
		
		// calculate salary 
		this.salary = coefficientSalary * baseSalary;
	}

}
