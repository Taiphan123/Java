
public class bangcuuchuong {
	public static void main(String[] args) {
		System.out.println("Bang cuu chuong");
		System.out.println("--------------");
		for (int i = 1; i <= 10; i++) {
			for (int j = 1; j <= 10; j++) {
				System.out.printf("%3dX%d=%2d",i,j,(i*j));
			}
			System.out.println();
		}
	}
}
