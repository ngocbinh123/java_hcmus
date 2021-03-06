package com.maven.weektwo;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JListFrm extends JFrame {

	private JPanel contentPane;
	private JTextField txtHoTen;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JListFrm frame = new JListFrm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public JListFrm() {
		setTitle("Thêm xoá Trên Jlist - Bai Tap 2");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		final DefaultListModel model = new DefaultListModel();
		final JList jlistDanhSach = new JList(model);
		jlistDanhSach.setBounds(6, 6, 154, 266);
		contentPane.add(jlistDanhSach);
		
		JLabel lblHVTn = new JLabel("Họ và tên: ");
		lblHVTn.setBounds(172, 16, 68, 16);
		contentPane.add(lblHVTn);
		
		txtHoTen = new JTextField();
		txtHoTen.setBounds(252, 10, 192, 28);
		contentPane.add(txtHoTen);
		txtHoTen.setColumns(10);
		
		JButton btnThem = new JButton("Thêm");
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sHoTen = txtHoTen.getText();
				if(!sHoTen.isEmpty()){
					model.addElement(sHoTen);
				}
			}
		});
		btnThem.setBounds(172, 50, 117, 29);
		contentPane.add(btnThem);
		
		JButton btnXoa = new JButton("Xoá");
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(model.size() > 0){
					model.removeElementAt(jlistDanhSach.getSelectedIndex());
				}
			}
		});
		btnXoa.setBounds(327, 50, 117, 29);
		contentPane.add(btnXoa);
	}
}
