package main;


public class NVQuanLy extends NhanVien {
	private static int LuongCoBan;
	private static int HeSoLuong;
	
	public static int getLuongCoBan() {
		return LuongCoBan;
	}
	public static void setLuongCoBan(int luongCoBan) {
		LuongCoBan = luongCoBan;
	}
	public static int getHeSoLuong() {
		return HeSoLuong;
	}
	public static void setHeSoLuong(int heSoLuong) {
		HeSoLuong = heSoLuong;
	}
	
	public int luongQL(int luongCB, int heso){
		return luongCB * heso;
	}
	
	public static int tinhLuong(int hesoLuong, int luongCB){
		return hesoLuong * luongCB;
	}
}
