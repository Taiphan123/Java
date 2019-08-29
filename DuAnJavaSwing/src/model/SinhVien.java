package model;

import java.util.ArrayList;

public class SinhVien {
	 private String MSV;
	 private String tenSV;
	 private String diaChi;
	 private String phuong;
	 private String quan;
	 private String thanhPho;
	 private String dienThoai;
	 private String email;
	 private String Mlop;
	 private ArrayList<Diem> diem;
	 
	public SinhVien(String mSV, String tenSV, String diaChi, String phuong, String quan, String thanhPho,
			String dienThoai, String email, String mlop) {
		super();
		MSV = mSV;
		this.tenSV = tenSV;
		this.diaChi = diaChi;
		this.phuong = phuong;
		this.quan = quan;
		this.thanhPho = thanhPho;
		this.dienThoai = dienThoai;
		this.email = email;
		Mlop = mlop;
	}
	public String getMSV() {
		return MSV;
	}
	public void setMSV(String mSV) {
		MSV = mSV;
	}
	public String getTenSV() {
		return tenSV;
	}
	public void setTenSV(String tenSV) {
		this.tenSV = tenSV;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	public String getPhuong() {
		return phuong;
	}
	public void setPhuong(String phuong) {
		this.phuong = phuong;
	}
	public String getQuan() {
		return quan;
	}
	public void setQuan(String quan) {
		this.quan = quan;
	}
	public String getThanhPho() {
		return thanhPho;
	}
	public void setThanhPho(String thanhPho) {
		this.thanhPho = thanhPho;
	}
	public String getDienThoai() {
		return dienThoai;
	}
	public void setDienThoai(String dienThoai) {
		this.dienThoai = dienThoai;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMlop() {
		return Mlop;
	}
	public void setMlop(String mlop) {
		Mlop = mlop;
	}
	@Override
	public String toString() {
		return "\n tenSV: " + tenSV
				+ "\n DiaChi : " + diaChi
				+ "\n Phuong : " + phuong
				+ "\n Quan : " + quan
				+ "\n ThanhPho : " + thanhPho
				+ "\n DienThoai : " + dienThoai
				+ "\nemail : " + email
				+ "\n Malop : " + Mlop+"\n";
	}
	 

}
