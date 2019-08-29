import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.xml.ws.handler.MessageContext;
	public class MyWindow extends JFrame{
		protected static final String frame = null;
		Statement stmt;
		 public MyWindow(){
			 
		 super("Demo Windows");
		 stmt = this.getStatement();
		 JPanel pnBorder=new JPanel();
		 pnBorder.setLayout(new BorderLayout());
		 JPanel pnTren=new JPanel();
		// pnBorder.add(pnTren,BorderLayout.NORTH);
		 JLabel jlbtitle = new JLabel("Chương Trình Quản Lý Sinh Viên");
		 pnTren.add(jlbtitle);
		 
		 JPanel pnCenter=new JPanel();
		 pnCenter.setLayout(new GridLayout(3, 2));
		 pnCenter.setBackground(Color.WHITE);
//		 pnBorder.add(pnCenter,BorderLayout.CENTER);

		 JLabel jlbMSV = new JLabel("Mã Sinh Viên:");
		 JTextField jtfMSV = new JTextField(10);
		 pnCenter.add(jlbMSV);
		 pnCenter.add(jtfMSV);
		 
		 JLabel jlbName = new JLabel("Tên Sinh Viên:");
		 JTextField jtfName = new JTextField(10);
		 pnCenter.add(jlbName);
		 pnCenter.add(jtfName);
		 JLabel jlbTuoi = new JLabel("Tuổi:");
		 JTextField jtfTuoi = new JTextField(10);
		 pnCenter.add(jlbTuoi);
		 pnCenter.add(jtfTuoi);


		
		 JPanel pnDuoi=new JPanel();
//		 pnBorder.add(pnDuoi,BorderLayout.SOUTH);
		 JButton jbttiep = new JButton("Tiếp");
		 pnDuoi.add(jbttiep);
		 
		 JButton jbtluu = new JButton("Lưu");
		 pnDuoi.add(jbtluu);
		 
		 JButton jbtmoi = new JButton("Mới");
		 pnDuoi.add(jbtmoi);
		 
		 JButton jbtxoa = new JButton("Xóa");
		 pnDuoi.add(jbtxoa);
		 
		 JButton jbtthoat = new JButton("Thoát");
		 pnDuoi.add(jbtthoat);
		 
		 JButton jbtsau = new JButton("Sau");
		 pnDuoi.add(jbtsau);
		 
		 try {
				Class.forName("com.mysql.cj.jdbc.Driver");

				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/quanlydaotao", "root", "");
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery("select * from students");
				 jbttiep.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							try {
								if(rs.next()) {
									jtfMSV.setText(rs.getString(1));
									jtfName.setText(rs.getString(2));
									jtfTuoi.setText(rs.getString(4));
								}
							} catch (Exception e2) {
								// TODO: handle exception
							}
							
						}
					});
				 
				 jbtsau.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							try {
								if(rs.previous()) {
									jtfMSV.setText(rs.getString(1));
									jtfName.setText(rs.getString(2));
									jtfTuoi.setText(rs.getString(4));
								}
							} catch (Exception e2) {
								// TODO: handle exception
							}
							
						}
					});
				 
				 jbtmoi.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							try {
								
									jtfMSV.setText("");
									jtfName.setText("");
									jtfTuoi.setText("");
							} catch (Exception e2) {
								// TODO: handle exception
							}
							
						}
					});
				 
				 
				 jbtluu.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							try {
								String nhap = "INSERT INTO students(maSV, hoTenSV,idLop,Tuoi) VALUES ('"+jtfMSV.getText()+"','"+jtfName.getText()+"','',"+Integer.parseInt(jtfTuoi.getText())+")";
								stmt.executeUpdate(nhap);
								JOptionPane.showMessageDialog(null, "Thêm thành công!");
							} catch (Exception e2) {
								System.out.println(e2);
							}
							
						}
					});
				 
				 
				 jbtxoa.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							try {
								if(jtfMSV.getText().equals("")) {
									JOptionPane.showMessageDialog(null, "Rỗng!");
								}else {
								String xoa = "DELETE FROM students WHERE maSV=\""+jtfMSV.getText()+"\"";
								stmt.executeUpdate(xoa);
								JOptionPane.showMessageDialog(null, "Xóa thành công!");
								}
					
							} catch (Exception e3) {
								System.out.println(e3);
							}
							
						}
					});
				 
				 
				 jbtthoat.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							try {
								System.exit(0);
							} catch (Exception e4) {
								System.out.println(e4);
							}
							
						}
					});
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 JPanel pn=new JPanel();
		 pn.setLayout(new BorderLayout());
		 pn.add(pnCenter,BorderLayout.CENTER);
		 pn.add(pnDuoi,BorderLayout.SOUTH);
		 pnBorder.add(pn,BorderLayout.NORTH);
		 
		 
		 JPanel pnCuoi = new JPanel();
		 pnCuoi.setLayout(new BorderLayout());
		 TitledBorder table = new TitledBorder("Danh Sach");
		 pnCuoi.setBorder(table);
		
		 DefaultTableModel dm=new DefaultTableModel();
		 dm.addColumn("Mã");
		 dm.addColumn("Tên");
		 dm.addColumn("Tuổi");
		 final JTable tbl=new JTable(dm);
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
		 
		 tbl.addMouseListener(new MouseListener() {
			 public void mouseReleased(MouseEvent e) {}
			 public void mousePressed(MouseEvent e) {}
			 public void mouseExited(MouseEvent e) {}
			 public void mouseEntered(MouseEvent e) {}
			 public void mouseClicked(MouseEvent e) {
			 int row=tbl.getSelectedRow();
			 int col=tbl.getSelectedColumn();
			 String s=(String)tbl.getValueAt(row, col);
			
				
			 }});


		 JScrollPane sc=new JScrollPane(tbl);
		 
		 sc.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		 sc.setMaximumSize(new Dimension(150, 50));
		 sc.setPreferredSize(new Dimension(150, 50));
         
         
		 pnCuoi.add(sc,BorderLayout.CENTER);
		 pnBorder.add(pnCuoi,BorderLayout.CENTER);
		 
		 
		 
		 getContentPane().add(pnBorder);
		 setDefaultCloseOperation(EXIT_ON_CLOSE);
		 
		 
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
			 MyWindow ui=new MyWindow();
			 ui.setSize(500, 300);
			 ui.setLocationRelativeTo(null);
			 ui.setVisible(true);
		}
		}
