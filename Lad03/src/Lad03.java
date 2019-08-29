import java.util.Scanner;

public class Lad03 {
	public static void main(String[] args) {
		int n;String a;
		sanpham[] sp=new sanpham[10];
		Scanner sc= new Scanner (System.in);
		System.out.println("nhap vao so sp:");
		n=Integer.parseInt(sc.nextLine());
		for (int i = 0; i <=n; i++) {
			sp[i]=new sanpham();
			sp[i].nhap();
		}
		
		for (int i = 0; i <=n; i++) {
			sp[i].xuat();
		}
		//alt+shift+rs
	}
}
