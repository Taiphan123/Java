
	import java.awt.BorderLayout;
	import java.awt.GridLayout;
	import java.awt.HeadlessException;
	import java.sql.*;

	import javax.swing.*;
	import javax.swing.table.DefaultTableModel;


	public class test extends JFrame {
		Statement stmt;
		public test() {
			
			super("test Layout");
			stmt = this.getStatement();
			setDefaultCloseOperation(EXIT_ON_CLOSE);
			 
			 JPanel pnMain = new JPanel();
			 pnMain.setLayout(new BorderLayout());
			 
			 JPanel topPanel = new JPanel(new BorderLayout());
			// topPanel.setLayout(new SpringLayout());
			 
			 JPanel top1 = new JPanel();
			 top1.add(new JLabel("Chuong trinh quan ly"));
			 topPanel.add(top1, BorderLayout.NORTH);
			 
			 
			 JPanel top2 = new JPanel();
			 top2.setLayout(new GridLayout(3,2));
			 JLabel jlMasv = new JLabel("Ma sinh vien");
			 top2.add(jlMasv);
			 
			 JTextField jtxtMasv = new JTextField(10);
			 top2.add(jtxtMasv );
			
			 JLabel jlbTensv = new JLabel("Ten sinh vien");
			 top2.add(jlbTensv);
			 
			 JTextField jtxtTensv = new JTextField(10);
			 top2.add(jtxtTensv);
			 
			 JLabel jlbTuoi = new JLabel("Tuoi sinh vien");
			 top2.add(jlbTuoi);
			 
			 JTextField jtxtTuoi = new JTextField(10);
			 top2.add(jtxtTuoi);
			 
			 topPanel.add(top2, BorderLayout.CENTER);
			 
			 JPanel top3 = new JPanel();
			 JButton jbtNext = new JButton("Next");
			 top3.add(jbtNext);
			 
			 JButton jbtAdd = new JButton("Add");
			 top3.add(jbtAdd);
			 
			 JButton jbtBack = new JButton("Back");
			 top3.add(jbtBack);
			 
			 
			 topPanel.add(top3, BorderLayout.SOUTH);
			 
			
			 DefaultTableModel dm=new DefaultTableModel();
			 dm.addColumn("Mã SV");
			 dm.addColumn("Tên");
			 dm.addColumn("Tuổi");
			 dm.addColumn("Diem TB");
			 
			 
			 final JTable tbl=new JTable(dm);
			 /*dm.addRow(new String[]{"112","Ngô văn Bắp","21"});
			 dm.addRow(new String[]{"113","Nguyễn Thị Tý","18"});
			 dm.addRow(new String[]{"114","Trần Văn Tèo","22"});*/
			 
			 String sqlString = "select * from students";
			 ResultSet rs;
			 try {
				rs = stmt.executeQuery(sqlString);
			
				 while (rs.next()) {
					 dm.addRow(new String[]{rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4)});
				 }
			 } catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
			}
			 JScrollPane bottomPanel=new JScrollPane(tbl);
			 
			 
			 pnMain.add(topPanel, BorderLayout.NORTH);
			 pnMain.add(bottomPanel, BorderLayout.CENTER);
			 
			 getContentPane().add(pnMain);

			 
		}
		Statement getStatement() {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
		
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/quanlydaotao","root","");
				return con.createStatement();
			}catch(Exception ex) {
					System.out.println(ex);
			}
			return null;
		}
		
		ResultSet getResulSet(String sqlString, Statement stmt) {
			 try {
				return stmt.executeQuery(sqlString);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;

		}
		public static void main(String[] args) {
			test ui=new test();
			ui.setSize(400, 300);
			 
			ui.setLocationRelativeTo(null);
			ui.setVisible(true);//  fale ko hiển thi
		}

	}

