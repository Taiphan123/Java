package View;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import model.Diem;
import model.LopHoc;
import model.dao.LopHocConnect;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

class ThongKePanel extends JPanel {
		LopHocConnect lopHocConnect = new LopHocConnect();
//		private String[] titleColumn = {"MSV","TenSV","DiaChi","Phuong","Quan","ThanhPho","SDT","Email","Mlop" };   
		private JTable table_1;
		private boolean isUpdate;
		private JComboBox box1;
		private String combobox;
		public int nam;

		public ThongKePanel() {
			setLayout(null);
			add(createMainPanel());
			// set display

			lopHocConnect.connect();
			setVisible(true);
		}

		// giao diem chinh
		private JPanel createMainPanel() {
			JPanel panel = new JPanel();
			panel.setBounds(0, 0, 761, 605);
			panel.setLayout(null);
			panel.add(createTitlePanel());
			{
				JPanel panel_1 = new JPanel();
				panel_1.setBounds(0, 35, 761, 196);
				panel.add(panel_1);
				panel_1.setLayout(null);
				{
					JScrollPane scrollPane = new JScrollPane();
					scrollPane.setBounds(10, 11, 741, 181);
					panel_1.add(scrollPane);
					{
						table_1 = new JTable();
						scrollPane.setViewportView(table_1);
					}
				}
			}
			{
				JPanel panel_1 = new JPanel();
				panel_1.setBounds(10, 242, 741, 352);
				panel.add(panel_1);
				panel_1.setLayout(null);

				JPanel panel_2 = new JPanel();
				panel_2.setBounds(10, 11, 721, 331);
				panel_1.add(panel_2);
				panel_2.setLayout(null);
				
				box1 = new JComboBox();
				box1.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent arg0) {
						combobox = box1.getSelectedItem().toString();
						nam = Integer.parseInt(combobox);
						System.out.println(nam);
					}
				});
				box1.setModel(new DefaultComboBoxModel(new String[] {"2015", "2016", "2017", "2018", "2019", "2020"}));
				box1.setBounds(28, 11, 153, 20);
				panel_2.add(box1);
				
				JLabel lblNewLabel = new JLabel("S\u1ED1 l\u1EDBp\r\n");
				lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
				lblNewLabel.setBounds(217, 79, 112, 20);
				panel_2.add(lblNewLabel);
				{
					JLabel lblsolop = new JLabel("");
					lblsolop.setBounds(355, 79, 76, 19);
					panel_2.add(lblsolop);
				}
				{
					JLabel lblSSinhvin = new JLabel("S\u1ED1 SinhVi\u00EAn");
					lblSSinhvin.setFont(new Font("Tahoma", Font.PLAIN, 15));
					lblSSinhvin.setBounds(217, 115, 90, 20);
					panel_2.add(lblSSinhvin);
				}
				{
					JLabel sosinhvien = new JLabel("");
					sosinhvien.setBounds(355, 109, 76, 19);
					panel_2.add(sosinhvien);
				}
			}
			return panel;
		}

		// tieu de
		private JPanel createTitlePanel() {
			JPanel panel = new JPanel();
			panel.setBounds(10, 0, 741, 24);
			{
				JLabel lblTh = new JLabel("Thong Ke");
				lblTh.setForeground(Color.RED);
				lblTh.setFont(new Font("Sylfaen", Font.BOLD, 14));
				panel.add(lblTh);
			}
			return panel;
		}
		
		
//		private LopHoc getNam() {
//			int nam = Integer.parseInt(combobox);
//			LopHoc lophoc = new LopHoc(nam);
//			return lophoc;
//		}
		
		public void loadDataNam(int nam) {
			DefaultTableModel model = new DefaultTableModel();
//			ResultSet rs = sv.getDataLop("16CT"); // test thu 1 lop
			ResultSet rs = lopHocConnect.getDataNam1(nam);
			try {
				// lay ten cot
				java.sql.ResultSetMetaData rsMD = rs.getMetaData();
				int colNumber = rsMD.getColumnCount();
				String[] arr = new String[colNumber];
				for (int i = 0; i < colNumber; i++) {
					arr[i] = rsMD.getColumnName(i + 1);
				}
				model.setColumnIdentifiers(arr);
				// lay du lieu
				while (rs.next()) {
					for (int i = 0; i < colNumber; i++) {
						arr[i] = rs.getString(i + 1);
					}
					model.addRow(arr);
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			table_1.setModel(model);
		}
	
	}