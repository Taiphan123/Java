package SinhVienFpt;

import java.util.Scanner;

public class SinhVienIT extends SinhVienFpt{
	private float diemJava;
	private float diemHtml;
	private float diemCss;
	
	public float getDiemJava() {
		return diemJava;
	}

	public void setDiemJava(float diemJava) {
		this.diemJava = diemJava;
	}

	public float getDiemHtml() {
		return diemHtml;
	}

	public void setDiemHtml(float diemHtml) {
		this.diemHtml = diemHtml;
	}

	public float getDiemCss() {
		return diemCss;
	}

	public void setDiemCss(float diemCss) {
		this.diemCss = diemCss;
	}

	@Override
	double getDiem() {
		// TODO Auto-generated method stub
		return (2*this.diemJava+this.diemHtml+this.diemCss)/4;
	}
	public void nhap() {
		System.out.println("nhap diem IT");
		Scanner sc=new Scanner (System.in);
		System.out.println("nhap ho ten");
		super.ten=sc.nextLine();
		System.out.println("nganh");
		super.nganh=sc.nextLine();
		System.out.println("nhap diemHtml ,diemJAVA,diem Css");
		this.diemHtml=sc.nextFloat();
		this.diemJava=sc.nextFloat();
		this.diemCss=sc.nextFloat();
	}

}
