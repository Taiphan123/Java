package View;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.table.DefaultTableModel;

import model.LopHoc;
import model.SinhVien;
import model.dao.DsDiemConnect;
import model.dao.LopHocConnect;
import model.dao.SinhVienConnect;

import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;
import javax.swing.tree.DefaultMutableTreeNode;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Main {
	LopHocConnect lh = new LopHocConnect();
	DsDiemConnect diemConnect = new DsDiemConnect();
	LopHocConnect lopConnect = new LopHocConnect();
	SinhVienConnect sv = new SinhVienConnect();
	SinhVienPanel svpanel = new SinhVienPanel();
	DiemPanel diempanel = new DiemPanel();
	MonHocPanel monhocpanel = new MonHocPanel();
	LopHocPanel loppanel = new LopHocPanel();
	ThongKePanel thongKePanel = new ThongKePanel();
	private String node1;
	private JFrame frame;
	private DefaultMutableTreeNode node;
	private JTree tree;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Main() {
		initialize();
		svpanel.loadDataSV(node1);
		diempanel.loadDataDiem();
		monhocpanel.loadDataSV();
		loppanel.loadDataLop();
		thongKePanel.loadDataNam(thongKePanel.nam);
		loadData();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		lh.connect();
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setSize(902, 692);

		JSplitPane splitPane = new JSplitPane();
		splitPane.setBounds(10, 11, 866, 631);
		frame.getContentPane().add(splitPane);

		JScrollPane scrollPane = new JScrollPane();
		splitPane.setRightComponent(scrollPane);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		scrollPane.setViewportView(tabbedPane);
		
		//Pane Sinh Vien
		tabbedPane.add(svpanel);
		tabbedPane.addTab("SinhVien", null, svpanel, null);
		
		//Panel Diem
		tabbedPane.add(diempanel);
		tabbedPane.addTab("Diem", null, diempanel, null);
		
		tabbedPane.add(monhocpanel);
		tabbedPane.addTab("MonHoc", null, monhocpanel, null);
		
		tabbedPane.add(loppanel);
		tabbedPane.addTab("LopHoc", null, loppanel, null);
		
		tabbedPane.add(thongKePanel);
		tabbedPane.addTab("Thong Ke", null, thongKePanel, null);

		JScrollPane scrollPane_1 = new JScrollPane();
		splitPane.setLeftComponent(scrollPane_1);
		scrollPane_1.setViewportView(Cay());

	}

	private JTree Cay() {
		tree = new JTree();
		tree.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				 Object o=tree.getLastSelectedPathComponent();   
				 DefaultMutableTreeNode 
				 node=(DefaultMutableTreeNode)o;
				 node1 = node.toString();
				 svpanel.loadDataSV(node1);
			}
		});
		loadData();
		return tree;
	}
	
	private void loadData() {
		tree.setModel(new DefaultTreeModel(new DefaultMutableTreeNode("Danh Sach") {
			{
				DefaultMutableTreeNode node_1;
				node_1 = new DefaultMutableTreeNode("Lop");
				try {
					ResultSet rs = lh.getDataLop1();
					while (rs.next()) {
						node_1.add(new DefaultMutableTreeNode(rs.getString(1)));
					}
				}

				catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				add(node_1);
			}
		}));
	}
	private class LopHocPanel extends JPanel {
		LopHocConnect lopHocConnect = new LopHocConnect();
//		private String[] titleColumn = {"MSV","TenSV","DiaChi","Phuong","Quan","ThanhPho","SDT","Email","Mlop" };   
		private JTable table_1;
		private boolean isUpdate;
		private JTextField tfMlop;
		private JTextField tfTenLop;
		private JTextField tfNamHoc;
		private JButton btnOK;
		private JButton btnCancel;

		public LopHocPanel() {
			setLayout(null);
			add(createMainPanel());
			// set display

			lopHocConnect.connect();
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

				JLabel lblNewLabel = new JLabel("MLop\r\n");
				lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
				lblNewLabel.setBounds(158, 8, 46, 14);
				panel_2.add(lblNewLabel);

				JLabel lblNewLabel_1 = new JLabel("TenLop\r\n");
				lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
				lblNewLabel_1.setBounds(158, 33, 46, 14);
				panel_2.add(lblNewLabel_1);

				JLabel lblNewLabel_2 = new JLabel("NamHoc");
				lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));
				lblNewLabel_2.setBounds(158, 58, 63, 14);
				panel_2.add(lblNewLabel_2);


				tfMlop = new JTextField();
				tfMlop.setEnabled(false);
				tfMlop.setBounds(263, 5, 262, 20);
				panel_2.add(tfMlop);
				tfMlop.setColumns(10);

				tfTenLop = new JTextField();
				tfTenLop.setEnabled(false);
				tfTenLop.setBounds(263, 30, 262, 20);
				panel_2.add(tfTenLop);
				tfTenLop.setColumns(10);

				tfNamHoc = new JTextField();
				tfNamHoc.setEnabled(false);
				tfNamHoc.setBounds(263, 55, 262, 20);
				panel_2.add(tfNamHoc);
				tfNamHoc.setColumns(10);


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
						Input(false, false, false);
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
						String msg = JOptionPane.showInputDialog(null, "moi nhap ma lop", "thong bao", JOptionPane.OK_CANCEL_OPTION);
						System.out.println(msg);
						if(msg==null) {
							loadDataLop();
						}
						else search(msg);
					}
				});
				btnSearch.setFont(new Font("Sylfaen", Font.BOLD, 12));
				btnSearch.setForeground(Color.RED);
				btnSearch.setBounds(573, 200, 89, 23);
				panel_2.add(btnSearch);
			}
			return panel;
		}

		// tieu de
		private JPanel createTitlePanel() {
			JPanel panel = new JPanel();
			panel.setBounds(10, 0, 741, 24);
			{
				JLabel lblTh = new JLabel("Thông Tin Lop Hoc");
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
				lopHocConnect.deleteId((String) table_1.getValueAt(row, 0));
				loadDataLop();
				loadData();
			}
		}

		// Sinh vine class
		private LopHoc getLopHoc() {
			String MaLop = tfMlop.getText().trim().toUpperCase();
			String tenLop = tfTenLop.getText().trim();
			int namHoc = Integer.parseInt(tfNamHoc.getText().trim());
			if (tenLop.equals("")) {
				return null;
			}
//			if(mlop != lop) {
//				JOptionPane.showMessageDialog(null, "vui long nhap dung ma lop","Thong bao", JOptionPane.ERROR_MESSAGE);
//			}
			LopHoc lopHoc = new LopHoc(MaLop, tenLop, namHoc);
			return lopHoc;
		}

		// update
		private void update() {
			if (Input(true, true,false)) {
				isUpdate = true;
			} else {
				JOptionPane.showMessageDialog(null, "Chon cot can update", "update that bai", JOptionPane.ERROR_MESSAGE);
			}
		}

		// add
		private void add() {
			Input(true, false , true);

		}

		// kiem tra la update hay add
		private void updateAndAdd() {
			LopHoc lopHoc = getLopHoc();
			if (lopHoc != null) {
				if (isUpdate) {
					lopHocConnect.updateID(lopHoc.getMaLop(),lopHoc);
					loadDataLop();
					loadData();
					isUpdate = false;
				} else {
					lopHocConnect.insert(lopHoc);
					loadDataLop();
					loadData();
				}
				clearData();
				Input(false, false, false);
			} else {
				JOptionPane.showMessageDialog(null, "Du lieu rong", "THong Bao!", JOptionPane.ERROR_MESSAGE);
			}
		}

		// xoa trang sau khi update hoac add
		public void clearData() {
			tfMlop.setText("");
			tfTenLop.setText("");
			tfNamHoc.setText("");

		}
		
		public void search(String Mlop){
			DefaultTableModel model = new DefaultTableModel();
			ResultSet rs = lopConnect.getDataLop(Mlop);
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
				}} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				table_1.setModel(model);
			}
		// du lieu bang
		public void loadDataLop() {
			DefaultTableModel model = new DefaultTableModel();
			ResultSet rs = lopHocConnect.getDataLop2();
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
		private boolean Input(boolean check, boolean update,boolean chon) {
			if (update && table_1.getSelectedRow() < 0) {
				return false;
			} else if (update) {
				int row = table_1.getSelectedRow();
				tfMlop.setText((String) table_1.getValueAt(row, 0));
				tfTenLop.setText((String) table_1.getValueAt(row, 1));
				tfNamHoc.setText((String) table_1.getValueAt(row, 2));
			}
			tfMlop.setEnabled(chon);
			tfTenLop.setEnabled(check);
			tfNamHoc.setEnabled(check);
			btnOK.setEnabled(check);
			btnCancel.setEnabled(check);
			return true;
		}	

	}
	public class SinhVienPanel extends JPanel {
		SinhVienConnect sv = new SinhVienConnect();
//		private String[] titleColumn = {"MSV","TenSV","DiaChi","Phuong","Quan","ThanhPho","SDT","Email","Mlop" };  
		private ArrayList<SinhVien> listsv;
		private JTable table_1;
		private boolean isUpdate;
		private JTextField tfMSV;
		private JTextField tfTenSV;
		private JTextField tfDiaChi;
		private JTextField tfPhuong;
		private JTextField tfQuan;
		private JTextField tfThanhPho;
		private JTextField tfSDT;
		private JTextField tfEmail;
		private JTextField tfMlop;
		private JButton btnOK;
		private JButton btnCancel;

		public SinhVienPanel() {
			setLayout(null);
			add(createMainPanel());
			// set display

			sv.connect();
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

				JLabel lblNewLabel = new JLabel("MSV\r\n");
				lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
				lblNewLabel.setBounds(158, 8, 46, 14);
				panel_2.add(lblNewLabel);

				JLabel lblNewLabel_1 = new JLabel("TenSV\r\n");
				lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
				lblNewLabel_1.setBounds(158, 33, 46, 14);
				panel_2.add(lblNewLabel_1);

				JLabel lblNewLabel_2 = new JLabel("DiaChi");
				lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));
				lblNewLabel_2.setBounds(158, 58, 46, 14);
				panel_2.add(lblNewLabel_2);

				JLabel lblNewLabel_3 = new JLabel("Phuong");
				lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 12));
				lblNewLabel_3.setBounds(158, 83, 63, 14);
				panel_2.add(lblNewLabel_3);

				JLabel lblNewLabel_4 = new JLabel("Quan\r\n");
				lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 12));
				lblNewLabel_4.setBounds(158, 108, 46, 14);
				panel_2.add(lblNewLabel_4);

				JLabel lblNewLabel_5 = new JLabel("ThanhPho");
				lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 12));
				lblNewLabel_5.setBounds(158, 133, 89, 14);
				panel_2.add(lblNewLabel_5);

				JLabel lblNewLabel_6 = new JLabel("SDT");
				lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 12));
				lblNewLabel_6.setBounds(158, 158, 46, 14);
				panel_2.add(lblNewLabel_6);

				JLabel lblNewLabel_7 = new JLabel("Email\r\n");
				lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 12));
				lblNewLabel_7.setBounds(158, 183, 46, 14);
				panel_2.add(lblNewLabel_7);

				JLabel lblNewLabel_8 = new JLabel("Mlop");
				lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 12));
				lblNewLabel_8.setBackground(Color.WHITE);
				lblNewLabel_8.setBounds(158, 208, 46, 14);
				panel_2.add(lblNewLabel_8);

				tfMSV = new JTextField();
				tfMSV.setEnabled(false);
				tfMSV.setBounds(263, 5, 262, 20);
				panel_2.add(tfMSV);
				tfMSV.setColumns(10);

				tfTenSV = new JTextField();
				tfTenSV.setEnabled(false);
				tfTenSV.setBounds(263, 30, 262, 20);
				panel_2.add(tfTenSV);
				tfTenSV.setColumns(10);

				tfDiaChi = new JTextField();
				tfDiaChi.setEnabled(false);
				tfDiaChi.setBounds(263, 55, 262, 20);
				panel_2.add(tfDiaChi);
				tfDiaChi.setColumns(10);

				tfPhuong = new JTextField();
				tfPhuong.setEnabled(false);
				tfPhuong.setBounds(263, 80, 262, 20);
				panel_2.add(tfPhuong);
				tfPhuong.setColumns(10);

				tfQuan = new JTextField();
				tfQuan.setEnabled(false);
				tfQuan.setBounds(263, 105, 262, 20);
				panel_2.add(tfQuan);
				tfQuan.setColumns(10);

				tfThanhPho = new JTextField();
				tfThanhPho.setEnabled(false);
				tfThanhPho.setBounds(263, 130, 262, 20);
				panel_2.add(tfThanhPho);
				tfThanhPho.setColumns(10);

				tfSDT = new JTextField();
				tfSDT.setEnabled(false);
				tfSDT.setBounds(263, 155, 262, 20);
				panel_2.add(tfSDT);
				tfSDT.setColumns(10);

				tfEmail = new JTextField();
				tfEmail.setEnabled(false);
				tfEmail.setBounds(263, 180, 262, 20);
				panel_2.add(tfEmail);
				tfEmail.setColumns(10);

				tfMlop = new JTextField();
				tfMlop.setEnabled(false);
				tfMlop.setBounds(263, 205, 262, 20);
				panel_2.add(tfMlop);
				tfMlop.setColumns(10);

				btnOK = new JButton("OK");
				btnOK.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						updateAndAdd();
					}
				});
				btnOK.setEnabled(false);
				btnOK.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
				btnOK.setForeground(Color.BLACK);
				btnOK.setBounds(263, 236, 89, 23);
				panel_2.add(btnOK);

				btnCancel = new JButton("CANCEL");
				btnCancel.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						clearData();
						Input(false, false,false);
					}
				});
				btnCancel.setEnabled(false);
				btnCancel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
				btnCancel.setForeground(Color.BLACK);
				btnCancel.setBounds(436, 236, 89, 23);
				panel_2.add(btnCancel);

				JButton btnAdd = new JButton("ADD");
				btnAdd.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						add();
					}
				});
				btnAdd.setFont(new Font("Sylfaen", Font.BOLD, 12));
				btnAdd.setForeground(Color.RED);
				btnAdd.setBounds(130, 275, 89, 23);
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
				btnUpdate.setBounds(273, 275, 89, 23);
				panel_2.add(btnUpdate);

				JButton btnDelete = new JButton("DELETE");
				btnDelete.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						delete();
					}
				});
				btnDelete.setFont(new Font("Sylfaen", Font.BOLD, 12));
				btnDelete.setForeground(Color.RED);
				btnDelete.setBounds(423, 275, 89, 23);
				panel_2.add(btnDelete);

				JButton btnSearch = new JButton("SEARCH");
				btnSearch.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
							String msg = JOptionPane.showInputDialog(null, "moi nhap ma sv", "thong bao", JOptionPane.OK_OPTION);
							if(msg==null) {
								loadDataSV(node1);
							}
							else search(msg);
					}
				});
				btnSearch.setFont(new Font("Sylfaen", Font.BOLD, 12));
				btnSearch.setForeground(Color.RED);
				btnSearch.setBounds(573, 275, 89, 23);
				panel_2.add(btnSearch);
			}
			return panel;
		}

		// tieu de
		private JPanel createTitlePanel() {
			JPanel panel = new JPanel();
			panel.setBounds(10, 0, 741, 24);
			{
				JLabel lblTh = new JLabel("Th\u00F4ng tin sinh vi\u00EAn");
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
				sv.deleteId((String) table_1.getValueAt(row, 0));
				loadDataSV(node1);
			}
		}

		// Sinh vine class
		private SinhVien getSinhVien() {
			String MSV = tfMSV.getText().trim().toUpperCase();
			String tenSV = tfTenSV.getText().trim();
			String diaChi = tfDiaChi.getText().trim();
			String phuong = tfPhuong.getText().trim();
			String quan = tfQuan.getText().trim();
			String thanhPho = tfThanhPho.getText().trim();
			String sdt = tfSDT.getText().trim();
			String email = tfEmail.getText().trim();
			String mlop = tfMlop.getText().trim();
			if (MSV.equals("") || tenSV.equals("")) {
				return null;
			}
//			if(mlop != lop) {
//				JOptionPane.showMessageDialog(null, "vui long nhap dung ma lop","Thong bao", JOptionPane.ERROR_MESSAGE);
//			}
			
			SinhVien student = new SinhVien(MSV, tenSV, diaChi, phuong, quan, thanhPho, sdt, email, mlop);
			return student;
		}
		


		// update
		private void update() {
			if (Input(true, true,false)) {
				isUpdate = true;
			} else {
				JOptionPane.showMessageDialog(null, "Chon cot can update", "update that bai", JOptionPane.ERROR_MESSAGE);
			}
		}

		// add
		private void add() {
			Input(true, false,true);

		}
		
		public void search(String MSV) {	
			DefaultTableModel model = new DefaultTableModel();
			ResultSet rs = sv.getDataMSV(MSV); // test thu 1 lop
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
		// kiem tra la update hay add
		private void updateAndAdd() {
			SinhVien student = getSinhVien();
			if (student != null) {
				if (isUpdate) {
					sv.updateID(student.getMSV(), student);
					loadDataSV(node1);
					isUpdate = false;
				} else {
					sv.insert(student);
					loadDataSV(node1);
				}
				clearData();
				Input(false, false, false);
			} else {
				JOptionPane.showMessageDialog(null, "Du lieu rong", "THong Bao!", JOptionPane.ERROR_MESSAGE);
			}
		}

		// xoa trang sau khi update hoac add
		public void clearData() {
			tfMSV.setText("");
			tfTenSV.setText("");
			tfDiaChi.setText("");
			tfPhuong.setText("");
			tfQuan.setText("");
			tfThanhPho.setText("");
			tfSDT.setText("");
			tfEmail.setText("");
			tfMlop.setText("");

		}

		// du lieu bang
		public void loadDataSV(String lop) {
			DefaultTableModel model = new DefaultTableModel();
			ResultSet rs = sv.getDataLop(lop); // test thu 1 lop
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
		private boolean Input(boolean check, boolean update,boolean n) {
			if (update && table_1.getSelectedRow() < 0) {
				return false;
			} else if (update) {
				int row = table_1.getSelectedRow();
				tfMSV.setText((String) table_1.getValueAt(row, 0));
				tfTenSV.setText((String) table_1.getValueAt(row, 1));
				tfDiaChi.setText((String) table_1.getValueAt(row, 2));
				tfPhuong.setText((String) table_1.getValueAt(row, 3));
				tfQuan.setText((String) table_1.getValueAt(row, 4));
				tfThanhPho.setText((String) table_1.getValueAt(row, 5));
				tfSDT.setText((String) table_1.getValueAt(row, 6));
				tfEmail.setText((String) table_1.getValueAt(row, 7));
				tfMlop.setText((String) table_1.getValueAt(row, 8));
			}
			tfMSV.setEnabled(n);
			tfTenSV.setEnabled(check);
			tfDiaChi.setEnabled(check);
			tfPhuong.setEnabled(check);
			tfQuan.setEnabled(check);
			tfThanhPho.setEnabled(check);
			tfSDT.setEnabled(check);
			tfEmail.setEnabled(check);
			tfMlop.setEnabled(n);
			btnOK.setEnabled(check);
			btnCancel.setEnabled(check);
			return true;
		}

	}

}
