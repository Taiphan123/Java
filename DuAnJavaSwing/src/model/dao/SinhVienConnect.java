package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.mysql.cj.MysqlConnection;

import model.Diem;
import model.SinhVien;

public class SinhVienConnect {
	// khai bao bien connect
	private final String className = "com.mysql.cj.jdbc.Driver";
	private final String url = "jdbc:mysql://localhost:3306/qlth";
	private final String user = "root";
	private final String pass = "";

	private final String table = "sinhvien";

	private Connection connection;

	// ket noi
	public void connect() {
		try {
			Class.forName(className);
			connection = DriverManager.getConnection(url, user, "");
			System.out.println("ket noi thanh cong!");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	// lay du lieu
	public ResultSet getDataLop(String lop) {
		ResultSet rs = null;
		String sql = "Select * from " + table + " where Mlop= ?";
		PreparedStatement pst = null;
		try {
			pst = connection.prepareStatement(sql);
			pst.setString(1, lop); // chon dau ? dau tien
			rs = pst.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}

	// xoa
	public void deleteId(String ID) {
		String sql = "delete from " + table + " where MSV= ?";
		PreparedStatement pst = null;
		try {
			pst = connection.prepareStatement(sql);
			pst.setString(1, ID);
			if (pst.executeUpdate() > 0) {
				System.out.println("xoa thanh cong!");
			} else
				System.out.println("that bai");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
//Tim theo MSV
	public ResultSet getDataMSV(String MSV) {
		ResultSet rs = null;
		String sql = "Select * from " + table + " where MSV LIKE  ?";
		//SELECT * FROM `sinhvien` WHERE `MSV` LIKE 'MSV01'
		PreparedStatement pst = null;
		try {
			pst = connection.prepareStatement(sql);
			pst.setString(1, MSV); // chon dau ? dau tien
			rs = pst.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
	// them

	public void insert(SinhVien students) {
		String sql = "insert into " + table + " value (?,?,?,?,?,?,?,?,?)";
		PreparedStatement pst = null;
		try {
			pst = connection.prepareStatement(sql);

			pst.setString(1, students.getMSV());
			pst.setString(2, students.getTenSV());
			pst.setString(3, students.getDiaChi());
			pst.setString(4, students.getPhuong());
			pst.setString(5, students.getQuan());
			pst.setString(6, students.getThanhPho());
			pst.setString(7, students.getDienThoai());
			pst.setString(8, students.getEmail());
			pst.setString(9, students.getMlop());
//			pst.setString(10, students);
			if (pst.executeUpdate() > 0) {
				System.out.println("them thanh cong!");
			} else
				System.out.println("them that bai");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	// sua

	public void updateID(String ID,SinhVien students) {
		String sql ="update " + table 
				+" set TenSV=?,DiaChi=?,Phuong=?,Quan=?,ThanhPho=?,SDT=?,Email=?,Mlop=? where MSV=?";
		PreparedStatement pst =null; 
		try {
			pst = connection.prepareStatement(sql);
			
			pst.setString(1, students.getTenSV());
			
			pst.setString(2, students.getDiaChi());
			
			pst.setString(3, students.getPhuong());
			pst.setString(4, students.getQuan());
			pst.setString(5, students.getThanhPho());
			pst.setString(6, students.getDienThoai());
			pst.setString(7, students.getEmail());
			pst.setString(8, students.getMlop());
			pst.setString(9, students.getMSV());
//			pst.setString(10, students);
			if(pst.executeUpdate()>0) {
				System.out.println("update thanh cong!");
				}
				else System.out.println("update that bai");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		SinhVienConnect sv = new SinhVienConnect();
		sv.connect();
		// sv.deleteId("MSV03");
		sv.getDataLop("16CT");
		sv.updateID("MSV01",new SinhVien("MSV01","Phan Văn ajd", " sdlhas", "dá", "Hđá", "Đà Nd", "37555985",
				"hungphan@gmail.com", "17NN"));
	}
}
