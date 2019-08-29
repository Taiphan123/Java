import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;


public class Myconnection {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/quanlysinhvien","root","");
			Statement stmt = con.createStatement();		
//			stmt.executeUpdate("insert into lop values(\"17CT\", \"asbdak\", \"12\", \"NN\")");
			//them du lieu vao csdl cho cac bang
			ResultSet rs = stmt.executeQuery("select hoTen, ngaySinh, tenLop from lop inner join sv where lop.maLop = sv.maLop");
//			ResultSet rs = stmt.executeQuery("select * from lop");
			while (rs.next()) {
			System.out.print(rs.getString(1)+":");
			System.out.println(rs.getString(2));
			System.out.print(rs.getString(3));
			}
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
			} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
	}
	
}
