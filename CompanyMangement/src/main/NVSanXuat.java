package main;

import java.io.*;

public class NVSanXuat extends NhanVien	 {
	
	private static int SoSP;

	public static int getSoSP() {
		return SoSP;
	}

	public static void setSoSP(int soSP) {
		SoSP = soSP;
	}
	
	public static int tinhLuong(int soSP)
	{
		return soSP * 20000;
	}
	
	
}

