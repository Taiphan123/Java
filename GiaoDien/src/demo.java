import java.awt.EventQueue;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;
import javax.swing.UIManager;

public class demo {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					demo window = new demo();
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
	public demo() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel MSV = new JLabel("Mã Sinh Viên:");
		MSV.setBounds(31, 11, 93, 14);
		panel.add(MSV);
		
		JLabel lblNewLabel = new JLabel("T\u00EAn Sinh Vi\u00EAn");
		lblNewLabel.setBounds(31, 36, 93, 14);
		panel.add(lblNewLabel);
		
		JLabel lblTui = new JLabel("Tu\u1ED5i:");
		lblTui.setBounds(31, 61, 46, 14);
		panel.add(lblTui);
		
		textField = new JTextField();
		textField.setBounds(181, 8, 150, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(181, 33, 150, 20);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(181, 58, 150, 20);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnNewButton = new JButton("Ti\u1EBFp");
		btnNewButton.setBounds(10, 105, 63, 23);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("L\u01B0u");
		btnNewButton_1.setBounds(97, 105, 63, 23);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("X\u00F3a");
		btnNewButton_2.setBounds(181, 105, 63, 23);
		panel.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Tho\u00E1t");
		btnNewButton_3.setBounds(262, 105, 69, 23);
		panel.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Sau");
		btnNewButton_4.setBounds(349, 105, 63, 23);
		panel.add(btnNewButton_4);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 132, 414, 118);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		 DefaultTableModel dm=new DefaultTableModel();
		 dm.addColumn("Mã");
		 dm.addColumn("Tên");
		 dm.addColumn("Tuổi");
		 final JTable tbl=new JTable(dm);
//		while (rs.next()) {
//			dm.addRow(new String[] {rs.getString(1),rs.getString(2),rs.getString(4)});
//		}
//		 dm.addRow(new String[]{"112","Ngô văn Bắp","21"});
//		 try {
//	            while (rs.next()) {
//        		dm.addRow(new String[] {rs.getString(1),rs.getString(2),rs.getString(4)});
//        		}
//	        } catch (SQLException e) {
//	            e.printStackTrace();
//	        }
		 
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
		 panel_1.add(sc);
	}
}
