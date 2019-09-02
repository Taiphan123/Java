import java.util.Scanner;

public class timKiemTuanTu {

	static void linsearch_sort(int a[],int n, int x) {
		for (int i = 0; i < n; i++) 
			if (a[i] == x) {
				System.out.println("vi tri can tim la:"+i);
			}
			else 
				System.out.println("khong tim thay");
	}

	public static void main(String[] args) {
		int i, n = 6, x, a[] = { 10, 11, 12, 13, 14, 15, 16 };
		
		while (true) {
			for (i = 0; i < n; i++) System.out.println(a[i]);
			System.out.println("nhap vao x:");
			Scanner sc = new Scanner(System.in);
			x = sc.nextInt();
			if (x == 0) break;
			linsearch_sort(a,n,x);break;
		}

	}
}
