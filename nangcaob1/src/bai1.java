import java.util.Scanner;

public class bai1 {
	
	public static void main(String[] args) {
		int banKinh;
		final double pi = 3.14;
		double area;
		Scanner sc = new Scanner(System.in);
		System.out.println("nhap vao ban cmn kinh:");
		banKinh = sc.nextInt();
		area = pi * banKinh;
		System.out.println("dien tich la:"+area);
	}
}
