package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.LopHoc;

public class LopHocConnect {
	// khai bao bien connect
	private final String className = "com.mysql.cj.jdbc.Driver";
	private final String url = "jdbc:mysql://localhost:3306/qlth";
	private final String user = "root";
	private final String pass = "";

	private final String table = "lophoc";

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
	
	//lay ten lop
	public ResultSet getDataLop(String Mlop) {
		ResultSet rs = null;
		String sql = "Select * from " + table + " where Mlop LIKE  ?";
	//	SELECT * FROM `lophoc` WHERE `MLop` LIKE '16CT'
		PreparedStatement pst = null;
		try {
			pst = connection.prepareStatement(sql);	
			pst.setString(1, Mlop);
			rs = pst.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
	
	public ResultSet getDataNam() {
		ResultSet rs = null;
		String sql = "Select NamHoc from " + table;
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
	
	public ResultSet getDataNam1(int nam) {
		ResultSet rs = null;
		String sql = "Select * from " + table+ " WHERE Mlop = ?";	
		PreparedStatement pst = null;
		try {
			pst = connection.prepareStatement(sql);
			pst.setInt(1, nam);
			rs = pst.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
	
	public ResultSet getDataLop2() {
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

	// lay du lieu
	public ResultSet getDataLop1() {
		ResultSet rs = null;
		String sql = "Select Mlop from " + table;
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

	// xoa
	public void deleteId(String ID) {
		String sql = "delete from " + table + " where MLop= ?";
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

	// them

	public void insert(LopHoc lh) {
		String sql = "insert into " + table + " value (?,?,?)";
		PreparedStatement pst = null;
		try {
			pst = connection.prepareStatement(sql);

			pst.setString(1, lh.getMaLop());
			pst.setString(2, lh.getTenLop());
			pst.setInt(3, lh.getNamHoc());
			
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

	public void updateID(String ID,LopHoc lh) {
		String sql ="update " + table 
				+" set TenLop=?,NamHoc=? where Mlop=?";
		PreparedStatement pst =null; 
		try {
			pst = connection.prepareStatement(sql);
			
			pst.setString(3, lh.getMaLop());
			
			pst.setString(1, lh.getTenLop());
			
			pst.setInt(2, lh.getNamHoc());
	
			if(pst.executeUpdate()>0) {
				System.out.println("update thanh cong!");
				}
				else System.out.println("update that bai");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	//test du lieu
//	public static void main(String[] args) {
//		LopHocConnect lh = new LopHocConnect();
//		lh.connect();
//		lh.deleteId("13NH");
//		lh.insert(new LopHoc("17DD","dien tu",2018));
//		lh.updateID("17DD",new LopHoc("17DD","dien luc",2018));
//	}
}
