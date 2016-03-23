package main;


public class NVCongNhat extends NhanVien 
{
	private static int SoNgay;
	
	public static int getSoNgay() {
		return SoNgay;
	}
	public static void setSoNgay(int soNgay) {
		SoNgay = soNgay;
	}
	
	public int luongCN(int songay){
		return songay * 55000;
	}
	
	public static int tinhLuong(int soNgay)
	{
		return soNgay * 55000;
	}
}
