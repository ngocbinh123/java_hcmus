package com.java.practice.weekone;

import java.util.Scanner;

public class ProductionStaff extends Staff{
	//Nhân viên sản xuất: số sản phẩm * 20.000 vnđ
	final int UNIT_PRICE = 20000;
	int theNumberOfProduct = 0;
	public ProductionStaff() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param productMember
	 */
	public ProductionStaff(int productMember) {
		super();
		this.theNumberOfProduct = productMember;
	}
	/**
	 * @param fullName
	 * @param salary
	 */
	public ProductionStaff(String fullName, int salary) {
		super(fullName, salary);
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param fullName
	 * @param address
	 * @param birthDay
	 * @param salary
	 */
	public ProductionStaff(String fullName, String address, String birthDay, int salary) {
		super(fullName, address, birthDay, salary);
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param fullName
	 * @param address
	 * @param birthDay
	 */
	public ProductionStaff(String fullName, String address, String birthDay) {
		super(fullName, address, birthDay);
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param fullName
	 */
	public ProductionStaff(String fullName) {
		super(fullName);
		// TODO Auto-generated constructor stub
	}
	
	
	public int getTheNumberOfProduct() {
		return theNumberOfProduct;
	}
	public void setTheNumberOfProduct(int theNumberOfProduct) {
		this.theNumberOfProduct = theNumberOfProduct;
	}
	@Override
	public void inputInformations() {
		// TODO Auto-generated method stub
		super.inputInformations();
		inputBaseInformation();
		
		Scanner scan = new Scanner(System.in);
		// input other informations 
		System.out.println("The number of product is: ");
		this.theNumberOfProduct = scan.nextInt();
		
		// calculate salary 
		this.salary = theNumberOfProduct * UNIT_PRICE;
	}	
}
