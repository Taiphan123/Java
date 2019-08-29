package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Diem;
import model.LopHoc;
import model.SinhVien;

public class DsDiemConnect {
	private final String className = "com.mysql.cj.jdbc.Driver";
	private final String url = "jdbc:mysql://localhost:3306/qlth";
	private final String user = "root";
	private final String pass = "";

	private final String table = "dsthi";
	private final String select = "SELECT t1.MSV,t1.TenSV,t2.Diem,t2.MaMH\r\n" + 
						"FROM sinhvien t1 INNER JOIN dsthi t2 ON t1.MSV = t2.MSV";

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
	public ResultSet getDataDiem() {
		ResultSet rs = null;
//		String sql = "Select * from " + table;
		PreparedStatement pst = null;
		try {
			pst = connection.prepareStatement(select);
//			pst.setString(1, lop); // chon dau ? dau tien
			rs = pst.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}

	// xoa msv
	public void deleteId(String ID) {
		String sql = "delete from " + table + " where MSV= ?";
		PreparedStatement pst = null;
		try {
			pst = connection.prepareStatement(sql);
			pst.setString(1, ID);
			if (pst.executeUpdate() > 0) {
				System.out.println("xoa thanh cong!");
			} else
				System.out.println("xoa that bai");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//xoa theo MaMH
	public void deleteMH(String MSV,String MaMH) {
		String sql = "delete from " + table + " where MSV=? AND MaMH=?";
		PreparedStatement pst = null;
		try {
			pst = connection.prepareStatement(sql);
			pst.setString(1, MSV);
			pst.setString(2, MaMH);
			if (pst.executeUpdate() > 0) {
				System.out.println("xoa thanh cong!");
			} else
				System.out.println("xoa that bai");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	// them

	public void insert(Diem diem) {
		String sql = "insert into " + table + " value (?,?,?)";
		PreparedStatement pst = null;
		try {
			pst = connection.prepareStatement(sql);

			pst.setString(1, diem.getMSV());
			pst.setString(2, diem.getMaMH());
			pst.setFloat(3, diem.getDiem());
			
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

	public void updateID(String ID,Diem diem) {
		String sql ="update " + table 
				+" set Diem=? where MSV=? AND MaMH = ?";
		PreparedStatement pst =null; 
		try {
			pst = connection.prepareStatement(sql);
			
			pst.setString(2, diem.getMSV());
			
			pst.setFloat(1, diem.getDiem());
			
			pst.setString(3, diem.getMaMH());
	
			if(pst.executeUpdate()>0) {
				System.out.println("update thanh cong!");
				}
				else System.out.println("update that bai");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	// TIM theo MSV
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
	
	public static void main(String[] args) {
		DsDiemConnect ds = new DsDiemConnect();
		ds.connect();
//		ds.getDataDiem();
		ds.deleteMH("MSV03","HT");
//		ds.insert(new Diem("MSV03","JV",9));
//		ds.insert(new Diem("MSV03","HT",10));
		// sv.deleteId("MSV03");
//		sv.getDataLop("16CT");
//		sv.updateID("MSV01",new SinhVien("MSV01","Phan Văn ajd", " sdlhas", "dá", "Hđá", "Đà Nd", "37555985",
//				"hungphan@gmail.com", "17NN"));
	}
}