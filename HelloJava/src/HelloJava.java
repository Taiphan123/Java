import java.util.Scanner;

public class HelloJava {
	public static void main(String[] args) {
		int a, b, c, d, e, f;
		System.out.println("nhap du lieu vao ban phim:");
		System.out.println("nhap a:");
		Scanner sc = new Scanner(System.in);
		a = Integer.parseInt(sc.nextLine());
		System.out.println("nhap b:");
		b = Integer.parseInt(sc.nextLine());
		System.out.println("nhap vao phep toan");
		String kt = sc.nextLine();
		if (kt.equals("cong")) {
			c = a + b;
			System.out.println(c);
		}
		if (kt.equals("tru")) {
			d = a - b;
			System.out.println(d);
		}
		if (kt.equals("nhan")) {
			e = a * b;
			System.out.println(e);
		}
		if (kt.equals("chia")) {
			f = a / b;
			System.out.println(f);
		}
	}
}
