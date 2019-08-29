package View;

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

import model.MonHoc;
import model.dao.MonHocConnect;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MonHocPanel extends JPanel {
	MonHocConnect monHocConnect = new MonHocConnect();
//	private String[] titleColumn = {"MSV","TenSV","DiaChi","Phuong","Quan","ThanhPho","SDT","Email","Mlop" };   
	private JTable table_1;
	private boolean isUpdate;
	private JTextField tfMaMH;
	private JTextField tfTenMH;
	private JTextField tfSoTinChi;
	private JTextField tfThoiLuong;
	private JButton btnOK;
	private JButton btnCancel;

	public MonHocPanel() {
		setLayout(null);
		add(createMainPanel());
		// set display

		monHocConnect.connect();
		setVisible(true);
	}

	// giao diem chinh
	private JPanel createMainPanel() {
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 761, 849);
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
			panel_1.setBounds(10, 242, 741, 427);
			panel.add(panel_1);
			panel_1.setLayout(null);

			JPanel panel_2 = new JPanel();
			panel_2.setBounds(10, 11, 721, 331);
			panel_1.add(panel_2);
			panel_2.setLayout(null);

			JLabel lblNewLabel = new JLabel("MaMH\r\n");
			lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
			lblNewLabel.setBounds(158, 8, 46, 14);
			panel_2.add(lblNewLabel);

			JLabel lblNewLabel_1 = new JLabel("TenMH\r\n");
			lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
			lblNewLabel_1.setBounds(158, 33, 46, 14);
			panel_2.add(lblNewLabel_1);

			JLabel lblNewLabel_2 = new JLabel("SoTinChi");
			lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));
			lblNewLabel_2.setBounds(158, 58, 63, 14);
			panel_2.add(lblNewLabel_2);

			JLabel lblNewLabel_3 = new JLabel("ThoiLuong");
			lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 12));
			lblNewLabel_3.setBounds(158, 83, 95, 14);
			panel_2.add(lblNewLabel_3);


			tfMaMH = new JTextField();
			tfMaMH.setEnabled(false);
			tfMaMH.setBounds(263, 5, 262, 20);
			panel_2.add(tfMaMH);
			tfMaMH.setColumns(10);

			tfTenMH = new JTextField();
			tfTenMH.setEnabled(false);
			tfTenMH.setBounds(263, 30, 262, 20);
			panel_2.add(tfTenMH);
			tfTenMH.setColumns(10);

			tfSoTinChi = new JTextField();
			tfSoTinChi.setEnabled(false);
			tfSoTinChi.setBounds(263, 55, 262, 20);
			panel_2.add(tfSoTinChi);
			tfSoTinChi.setColumns(10);

			tfThoiLuong = new JTextField();
			tfThoiLuong.setEnabled(false);
			tfThoiLuong.setBounds(263, 80, 262, 20);
			panel_2.add(tfThoiLuong);
			tfThoiLuong.setColumns(10);


			btnOK = new JButton("OK");
			btnOK.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					updateAndAdd();
				}
			});
			btnOK.setEnabled(false);
			btnOK.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
			btnOK.setForeground(Color.BLACK);
			btnOK.setBounds(263, 120, 89, 23);
			panel_2.add(btnOK);

			btnCancel = new JButton("CANCEL");
			btnCancel.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					clearData();
					Input(false, false);
				}
			});
			btnCancel.setEnabled(false);
			btnCancel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
			btnCancel.setForeground(Color.BLACK);
			btnCancel.setBounds(436, 120, 89, 23);
			panel_2.add(btnCancel);

			JButton btnAdd = new JButton("ADD");
			btnAdd.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					add();
				}
			});
			btnAdd.setFont(new Font("Sylfaen", Font.BOLD, 12));
			btnAdd.setForeground(Color.RED);
			btnAdd.setBounds(130, 200, 89, 23);
			panel_2.add(btnAdd);

			JButton btnUpdate = new JButton("UPDATE");
			btnUpdate.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					isUpdate = true;
					update();
				}
			});
			btnUpdate.setFont(new Font("Sylfaen", Font.BOLD, 12));
			btnUpdate.setForeground(Color.RED);
			btnUpdate.setBounds(273, 200, 89, 23);
			panel_2.add(btnUpdate);

			JButton btnDelete = new JButton("DELETE");
			btnDelete.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					delete();
				}
			});
			btnDelete.setFont(new Font("Sylfaen", Font.BOLD, 12));
			btnDelete.setForeground(Color.RED);
			btnDelete.setBounds(423, 200, 89, 23);
			panel_2.add(btnDelete);

			JButton btnSearch = new JButton("SEARCH");
			btnSearch.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String msg = JOptionPane.showInputDialog(null, "moi nhap ma mon hoc", "thong bao", JOptionPane.OK_CANCEL_OPTION);
					if(msg==null) {
						loadDataSV();
					}
					else search(msg);
				}
			});
			btnSearch.setFont(new Font("Sylfaen", Font.BOLD, 12));
			btnSearch.setForeground(Color.RED);
			btnSearch.setBounds(573, 200, 89, 23);
			panel_2.add(btnSearch);
			
			//load lai du lieu
			JButton btnNew = new JButton("RESET");
			btnNew.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					loadDataSV();
				}
			});
			btnNew.setFont(new Font("Sylfaen", Font.BOLD, 12));
			btnNew.setForeground(Color.RED);
			btnNew.setBounds(340, 250, 89, 23);
			panel_2.add(btnNew);
		}
		return panel;
	}
	public void search(String MaMH){
		DefaultTableModel model = new DefaultTableModel();
		ResultSet rs = monHocConnect.getDataMaMH(MaMH);
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

	// tieu de
	private JPanel createTitlePanel() {
		JPanel panel = new JPanel();
		panel.setBounds(10, 0, 741, 24);
		{
			JLabel lblTh = new JLabel("Thông Tin Môn Hoc");
			lblTh.setForeground(Color.RED);
			lblTh.setFont(new Font("Sylfaen", Font.BOLD, 14));
			panel.add(lblTh);
		}
		return panel;
	}

	// delete
	private void delete() {
		int row = table_1.getSelectedRow();
		if (row < 0) {
			JOptionPane.showMessageDialog(null, "Chon cot can xoa", "Xoa that bai", JOptionPane.ERROR_MESSAGE);
			return;
		}
		int select = JOptionPane.showOptionDialog(null, "Ban muon xoa khong", "Xoa", 0, JOptionPane.YES_NO_OPTION, null,
				null, 1);
		if (select == 0) {
			monHocConnect.deleteId((String) table_1.getValueAt(row, 0));
			loadDataSV();
		}
	}

	// Sinh vine class
	private MonHoc getMonHoc() {
		String MaMH = tfMaMH.getText().trim().toUpperCase();
		String tenMH = tfTenMH.getText().trim();
		int stc = Integer.parseInt(tfSoTinChi.getText().trim());
		int thoiluong = Integer.parseInt(tfThoiLuong.getText().trim());
		if (tenMH.equals("")) {
			return null;
		}
//		if(mlop != lop) {
//			JOptionPane.showMessageDialog(null, "vui long nhap dung ma lop","Thong bao", JOptionPane.ERROR_MESSAGE);
//		}
		MonHoc monhoc = new MonHoc(MaMH,tenMH,stc,thoiluong);
		return monhoc;
	}

	// update
	private void update() {
		if (Input(true, true)) {
			isUpdate = true;
		} else {
			JOptionPane.showMessageDialog(null, "Chon cot can update", "update that bai", JOptionPane.ERROR_MESSAGE);
		}
	}

	// add
	private void add() {
		Input(true, false);

	}

	// kiem tra la update hay add
	private void updateAndAdd() {
		MonHoc monhoc = getMonHoc();
		if (monhoc != null) {
			if (isUpdate) {
				monHocConnect.updateID(monhoc.getMonHoc(),monhoc);
				loadDataSV();
				isUpdate = false;
			} else {
				monHocConnect.insert(monhoc);
				loadDataSV();
			}
			clearData();
			Input(false, false);
		} else {
			JOptionPane.showMessageDialog(null, "Du lieu rong", "THong Bao!", JOptionPane.ERROR_MESSAGE);
		}
	}

	// xoa trang sau khi update hoac add
	public void clearData() {
		tfMaMH.setText("");
		tfTenMH.setText("");
		tfSoTinChi.setText("");
		tfThoiLuong.setText("");

	}

	// du lieu bang
	public void loadDataSV() {
		DefaultTableModel model = new DefaultTableModel();
		ResultSet rs = monHocConnect.getDataLop(); // test thu 1 lop
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

	// xu ly
	private boolean Input(boolean check, boolean update) {
		if (update && table_1.getSelectedRow() < 0) {
			return false;
		} else if (update) {
			int row = table_1.getSelectedRow();
			tfMaMH.setText((String) table_1.getValueAt(row, 0));
			tfTenMH.setText((String) table_1.getValueAt(row, 1));
			tfSoTinChi.setText((String) table_1.getValueAt(row, 2));
			tfThoiLuong.setText((String) table_1.getValueAt(row, 3));
		}
		tfMaMH.setEnabled(check);
		tfTenMH.setEnabled(check);
		tfSoTinChi.setEnabled(check);
		tfThoiLuong.setEnabled(check);
		btnOK.setEnabled(check);
		btnCancel.setEnabled(check);
		return true;
	}

}
