package homework;

import java.util.ArrayList;

public class Exercise1 {
	public static void main(String[] args) {
		
		// khai bao so nguyen
		ArrayList<Integer> soNguyen = new ArrayList<Integer>();
		soNguyen.add(8);
		System.out.println("so nguyen" + soNguyen);

		// khai bao so thuc
		ArrayList<Double> soThuc = new ArrayList<Double>();
		soThuc.add(13.2);
		System.out.println("so thuc" + soThuc);
		
		//khai bao boolean
		ArrayList<Boolean> bl = new ArrayList<Boolean>();
		bl.add(true);
		System.out.println("Boolean" + bl);
		
		//khai bao xau ky tu
		ArrayList<String> st = new ArrayList<String>();
		st.add("day la kieu String");
		System.out.println("String :" + st);
	}
}
