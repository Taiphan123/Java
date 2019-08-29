package bai7;

import java.util.ArrayList;

public class Student implements Comparable<Student> {

	private int MSV;
	private String ten;
	private int namSinh;
	private String khoa;

	// ham dung
	public Student(int mSV, String ten, int namSinh, String khoa) {
		super();
		MSV = mSV;
		this.ten = ten;
		this.namSinh = namSinh;
		this.khoa = khoa;
	}

	// to String
	@Override
	public String toString() {
		return "Student [MSV=" + MSV + ", ten=" + ten + ", namSinh=" + namSinh + ", khoa=" + khoa + "]";
	}

	// sap xep
	@Override
	public int compareTo(Student o) {
		// TODO Auto-generated method stub
	
			return Integer.compare(namSinh, o.namSinh);
	}

}