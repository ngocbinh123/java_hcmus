package main;

import java.io.*;
import java.sql.Date;
import java.util.Scanner;

public class NhanVien {
	private int MaNhanVien;
	private String HoTen;
	private int NgaySinh;
	private String DiaChi;
	

	public int getMaNhanVien() {
		return MaNhanVien;
	}

	public void setMaNhanVien(int maNhanVien) {
		MaNhanVien = maNhanVien;
	}

	public String getHoTen() {
		return HoTen;
	}

	public void setHoTen(String hoTen) {
		HoTen = hoTen;
	}

	public int getNgaySinh() {
		return NgaySinh;
	}

	public void setNgaySinh(int ngaySinh) {
		NgaySinh = ngaySinh;
	}

	public String getDiaChi() {
		return DiaChi;
	}

	public void setDiaChi(String diaChi) {
		DiaChi = diaChi;
	}
	
	public void nhapNV()
	{
		Scanner scan = new Scanner(System.in);
		//NhanVien nv = new NhanVien();
		
	
		System.out.print("Nhập mã nhân viên: ");
		this.MaNhanVien = scan.nextInt();
		System.out.println("Nhập họ tên: ");
		this.HoTen = scan.next();
		System.out.println("Nhập địa chỉ: ");
		this.DiaChi = scan.next();
		System.out.println("Nhập ngày sinh: ");
		this.NgaySinh = scan.nextInt();
	}
	
	public void Xuat(){
		System.out.println(this.MaNhanVien + " " + this.HoTen + " " + this.DiaChi + " " + this.NgaySinh );
	}

	
}
