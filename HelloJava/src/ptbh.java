import java.util.Scanner;

public class ptbh {
 public static void main(String[] args) {
		int a,b;
		String c,d;
		Scanner sc= new Scanner (System.in);
		a=sc.nextInt();
		b=sc.nextInt();
		c=(a>b)?"a lon hon":(d=(b>a)?"b lon ho":"a bang b");
		System.out.println("ket qua:"+c);
}
}
