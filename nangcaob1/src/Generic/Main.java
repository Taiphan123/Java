package Generic;

import java.util.ArrayList;
import Generic.Animal;

public class Main<T extends Number> {
	private T number;

	public Main() {

	}

	public Main(T number) {
		this.number = number;
	}

	public void setnumber(T number) {
		this.number = number;
	}

	public T getnumber() {
		return this.number;
	
	}
	double nghichDao() {
		return 1/number.doubleValue();
	}
	double phanThapPhan() {
		return number.doubleValue()-number.intValue();
	}
	
	public static void main(String[] args) {
//		Main <Double> animal1 = new Main<>();
//		animal1.setnumber(1.2);
//		System.out.println(animal1.getnumber());
		
		Main <Integer> soNguyen = new Main<Integer>(180);
		System.out.println("Nghich Dao"+soNguyen.nghichDao());
		System.out.println("Thap phan"+soNguyen.phanThapPhan());
		Main<Double> soThuc = new Main<Double>(100.01);
		System.out.println("Nghich Dao"+soThuc.nghichDao());
		System.out.println("Thap phan"+soThuc.phanThapPhan());

	

	}
}
