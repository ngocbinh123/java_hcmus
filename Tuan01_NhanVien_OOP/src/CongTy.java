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
		//danhsach[0].nhapNV();
		//nhap danh sach nhan vien
		for(int i = 0; i < n; i++)
		{
			System.out.println("nhập nhân viên thứ: " + i);
			//nv.nhapNV();//hai dong nay chay thi xuat ra các dong giong nhau, như chua tung duoc dua vao mang vay
			//danhsach[i]= nv;
			danhsach[i].nhapNV();//cai nay chay thi bao loi
		}
		
		//Xuat danh sach nhan vien da duoc nhap
		for(int i = 0; i < n; i++)
		{
			System.out.println("Nhan Vien thu " + i);
			danhsach[i].Xuat();
		}
		
	}

}
