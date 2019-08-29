package lad5;


	import java.util.ArrayList;
	import java.util.Collections;
	import java.util.Comparator;
	import java.util.Scanner;

	public class Student {
		
		private String hoTen;
		private float diemHtml;
		private float diemJava;
		private float diemTrungBinh;
		ArrayList<Student> arrayListStudent;
		
		public Student() {
			
		}
		
		
		public Student(String hoTen, float diemHtml, float diemJava, float diemTrungBinh) {
			super();
			this.hoTen = hoTen;
			this.diemHtml = diemHtml;
			this.diemJava = diemJava;
			this.diemTrungBinh = diemTrungBinh;
		}
		

		public String getHoTen() {
			return hoTen;
		}


		public void setHoTen(String hoTen) {
			this.hoTen = hoTen;
		}


		public float getDiemHtml() {
			return diemHtml;
		}


		public void setDiemHtml(float diemHtml) {
			this.diemHtml = diemHtml;
		}


		public float getDiemJava() {
			return diemJava;
		}


		public void setDiemJava(float diemJava) {
			this.diemJava = diemJava;
		}


		public float getDiemTrungBinh() {
			return diemTrungBinh;
		}


		public void setDiemTrungBinh(float diemTrungBinh) {
			this.diemTrungBinh = diemTrungBinh;
		}


		public void input() {
			Scanner scanner = new Scanner(System.in);
			 System.out.println("Nhap ten sinh vien ");
			 hoTen = scanner.nextLine();
			 
			 System.out.println("Nhap diem html ");
			 diemHtml = scanner.nextFloat();
			 
			 System.out.println("Nhap diem java ");
			 diemJava = scanner.nextFloat();
			 try {
				StudentException.checkDiem(diemJava);
			} catch (StudentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 diemTrungBinh = (float)((this.diemHtml+this.diemJava)/2);
		}
		
		public void output() {
			System.out.println(this.hoTen + " | " + this.diemHtml + " | " +this.diemJava+ " | " + this.diemTrungBinh);
		}
		
		
		
		
		

	}

