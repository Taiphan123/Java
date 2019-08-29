package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.MonHoc;



public class MonHocConnect {
	// khai bao bien connect
	private final String className = "com.mysql.cj.jdbc.Driver";
	private final String url = "jdbc:mysql://localhost:3306/qlth";
	private final String user = "root";
	private final String pass = "";

	private final String table = "monhoc";

	private Connection connection;

	// ket noi
	public void connect() {
		try {
			Class.forName(className);
			connection = DriverManager.getConnection(url, user, pass);
			System.out.println("ket noi thanh cong!");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// lay du lieu
	public ResultSet getDataLop() {
		ResultSet rs = null;
		String sql = "Select * from " + table;
		PreparedStatement pst = null;
		try {
			pst = connection.prepareStatement(sql);
			rs = pst.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
	//tim kiem
	public ResultSet getDataMaMH(String MaMH) {
		ResultSet rs = null;
		String sql = "Select * from " + table + " where MaMH LIKE  ?";
		//SELECT * FROM `monhoc` WHERE `MaMH` LIKE 'JV'
		PreparedStatement pst = null;
		try {
			pst = connection.prepareStatement(sql);
			pst.setString(1, MaMH); // chon dau ? dau tien
			rs = pst.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}

	
	// xoa
	public void deleteId(String MaMH) {
		String sql = "delete from " + table + " where MaMH= ?";
		PreparedStatement pst = null;
		try {
			pst = connection.prepareStatement(sql);
			pst.setString(1, MaMH);
			if (pst.executeUpdate() > 0) {
				System.out.println("xoa thanh cong!");
			} else
				System.out.println("that bai");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// them

	public void insert(MonHoc monhoc) {
		String sql = "insert into " + table + " value (?,?,?,?)";
		PreparedStatement pst = null;
		try {
			pst = connection.prepareStatement(sql);

			pst.setString(1, monhoc.getMonHoc());
			pst.setString(2, monhoc.getTenMH());
			pst.setInt(3, monhoc.getSoTinChi());
			pst.setInt(4, monhoc.getGioHoc());
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

	public void updateID(String MaMH,MonHoc monhoc) {
		String sql ="update " + table 
				+" set TenMH = ? , SoTinChi = ? , ThoiLuong = ?  where MaMH=?";
		PreparedStatement pst =null; 
		try {
			pst = connection.prepareStatement(sql);
			
			pst.setString(1, monhoc.getTenMH());			
			pst.setInt(2, monhoc.getSoTinChi());		
			pst.setInt(3, monhoc.getGioHoc());
			pst.setString(4, monhoc.getMonHoc());
			
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

//	public static void main(String[] args) {
//		SinhVienConnect sv = new SinhVienConnect();
//		sv.connect();
//		// sv.deleteId("MSV03");
//		sv.getDataLop("16CT");
//		sv.updateID("MSV01",new SinhVien("MSV01","Phan Văn ajd", " sdlhas", "dá", "Hđá", "Đà Nd", "37555985",
//				"hungphan@gmail.com", "17NN"));
//	}
}
