package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class CongTy 
{

	public static void main(String[] args) {
		// TODO Auto-generated method stub	
		
		NhanVien nv = new NhanVien();
		Scanner scan = new Scanner(System.in);		
		
		System.out.print("Xin mời nhập số lượng nhân viên: ");
		int n = scan.nextInt();
		NhanVien danhsach [] = new NhanVien [n];
		ArrayList<NhanVien> list = new ArrayList<NhanVien>();
		//danhsach[0].nhapNV();
		//nhap danh sach nhan vien
		for(int i = 0; i < n; i++)
		{
			System.out.println("nhập nhân viên thứ: " + i);
			nv = new NhanVien();
			System.out.print("Nhập mã nhân viên: ");
			nv.setMaNhanVien(scan.nextInt());
			System.out.println("Nhập họ tên: ");
			nv.setHoTen(scan.next());
			System.out.println("Nhập địa chỉ: ");
			nv.setDiaChi(scan.next());
			System.out.println("Nhập ngày sinh: ");
			nv.setNgaySinh(scan.nextInt());
			//nv.nhapNV();//hai dong nay chay thi xuat ra các dong giong nhau, như chua tung duoc dua vao mang vay
			list.add(nv);
			System.out.println("ok");
			//danhsach[i] = new NhanVien();
			//danhsach[i].nhapNV();//cai nay chay thi bao loi
		}
		
		//Xuat danh sach nhan vien da duoc nhap
		/*for(int i = 0; i < n; i++)
		{
			System.out.println("Nhan Vien thu " + i);
			danhsach[i].Xuat();
		}*/
		int i = 0;
		for (NhanVien nhanVien : list) {
			//System.out.println("Nhan Vien thu " + i++);
			
			System.out.println(nhanVien.getMaNhanVien() + " " + nhanVien.getHoTen() + " " + nhanVien.getDiaChi() + " " + nhanVien.getNgaySinh() );
		}
		
	}

}
