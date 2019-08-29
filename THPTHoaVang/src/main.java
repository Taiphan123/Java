import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.Scanner;
import java.sql.*;

public class main {
	static String login(String userName, String password, ResultSet rs) {
		try {
			while (rs.next()) {
				if (userName.equals(rs.getString(1)) && password.equals(rs.getString(2))) {
					return rs.getString(3);
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		User us = new User();
		us.nhap();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/quanlydaotao", "root", "");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from users");
			String chucnang = login(us.getUsers(), us.getPassword(), rs);
			String ten = rs.getString(4);
			if (chucnang.equals("can bo")) {
				int a;
				while(true) {
					System.out.println("Xin chao can bo:\t"+ten
							+ "\n1. xem danh sach sinh vien \n"
							+ "2.them moi sinh vien\n"
							+ "3.sua sinh vien \n"
							+ "4. xoa sinh vien \n");
					System.out.println("nhap lua chon:");
					
					a = sc.nextInt();
					switch(a) {
					case 1:{  rs = stmt.executeQuery("select * from students");
						while (rs.next()) {
							System.out.printf("ma SV:%5s \t ten:%5s \t id:%5s \n",(rs.getString(1)),(rs.getString(2)),(rs.getString(3)));
						}
					
					}	
					break;
					case 2:{
						SinhVien sv = new SinhVien();
						sv.nhap();
						String qr = "insert into students values(\""+ sv.getMaSV() +"\",\""+ sv.getHoTenSV() +"\", \""+ sv.getMaSV() +"\" )";
						stmt.executeUpdate(qr);
					}
						break;
					case 3:{
						
					
						String hoTen;
						Scanner sc1 = new Scanner (System.in);
						System.out.println("nhap mssv can sua:");
						hoTen = sc1.nextLine();
						rs = stmt.executeQuery("select * from students");
//						rs.first();
						while(rs.next()) {
						if(hoTen.equals(rs.getString(1))) {
							SinhVien sv = new SinhVien();
							sv.nhap();
							stmt.executeUpdate("UPDATE students SET (\""+ sv.getMaSV() +"\",\""+ sv.getHoTenSV() +"\", \""+ sv.getMaSV() +"\" )");
						}
					}}
					case 4:{
						String mssv;
						System.out.println("nhap mssv can xoa:");
						mssv =sc.nextLine();
						String qr = ("DELETE FROM students WHERE maSV="+mssv);
						stmt.executeQuery(qr);
					}break;
					}
				
				}

			} else if (chucnang.equalsIgnoreCase("giang vien")) {
				System.out.println("Xin chao giang vien:\t"+ten);
				System.out.println("Danh sach sinh vien:");
				rs = stmt.executeQuery("select * from students");
				while (rs.next()) {
					System.out.printf("ma SV:%5s \t ten:%5s \t id:%5s \n",(rs.getString(1)),(rs.getString(2)),(rs.getString(3)));
				}
			} else {
				System.out.println("Nhap khong dung vui long nhap lai!");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
