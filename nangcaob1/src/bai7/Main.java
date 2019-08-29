package bai7;

import java.util.ArrayList;
import java.util.Collections;

public class Main {
	public static void main(String[] args) {
		ArrayList<Student> arrayList = new ArrayList<Student>();
		arrayList.add(new Student(4,"B",1998,"Cong nghe thong tin"));
		arrayList.add(new Student(5,"C",1999,"Buu chinh"));
		arrayList.add(new Student(1,"A",1997,"Cong nghe thong tin"));
		arrayList.add(new Student(2,"D",1997,"Dien tu"));
		arrayList.add(new Student(3,"E",1998,"Ngoai ngu"));
		
		System.out.println("Trc khi sap xep:");
		for (Student student : arrayList) {
			System.out.println(student);
		}
		
		Collections.sort(arrayList);
		
		System.out.println("Sau khi sap xep:");
		for (Student student : arrayList) {
			System.out.println(student);
		}
		
	}
}
