import java.util.Scanner;

public class NhanVien {
	private static int MaNhanVien;
	private static String HoTen;
	private static int NgaySinh;
	private static String DiaChi;
	

	public static int getMaNhanVien() {
		return MaNhanVien;
	}

	public static void setMaNhanVien(int maNhanVien) {
		MaNhanVien = maNhanVien;
	}

	public static String getHoTen() {
		return HoTen;
	}

	public static void setHoTen(String hoTen) {
		HoTen = hoTen;
	}

	public static int getNgaySinh() {
		return NgaySinh;
	}

	public static void setNgaySinh(int ngaySinh) {
		NgaySinh = ngaySinh;
	}

	public static String getDiaChi() {
		return DiaChi;
	}

	public static void setDiaChi(String diaChi) {
		DiaChi = diaChi;
	}
	
	public void nhapNV()
	{
		Scanner scan = new Scanner(System.in);
		//NhanVien nv = new NhanVien();
		
	
		System.out.print("Nhập mã nhân viên: ");
		MaNhanVien = scan.nextInt();
		System.out.println("Nhập họ tên: ");
		HoTen = scan.next();
		System.out.println("Nhập địa chỉ: ");
		DiaChi = scan.next();
		System.out.println("Nhập ngày sinh: ");
		NgaySinh = scan.nextInt();
	}
	
	public void Xuat(){
		System.out.println(MaNhanVien + " " + HoTen + " " + DiaChi + " " + NgaySinh );
	}

	
}
