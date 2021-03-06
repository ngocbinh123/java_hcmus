package com.maven.weektwo;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CalculatorFrm extends JFrame {

	private JPanel contentPane;
	private JTextField txtSoThuNhat;
	private JTextField txtSoThuHai;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CalculatorFrm frame = new CalculatorFrm();
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
	public CalculatorFrm() {
		setTitle("Tinh Toan 2 So - Bai Tap 01");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSThNht = new JLabel("Số thứ hai");
		lblSThNht.setBounds(193, 16, 101, 16);
		contentPane.add(lblSThNht);
		
		txtSoThuNhat = new JTextField();
		txtSoThuNhat.setBounds(6, 44, 112, 28);
		contentPane.add(txtSoThuNhat);
		txtSoThuNhat.setColumns(10);
		
		JLabel label = new JLabel("Số thứ nhất ");
		label.setBounds(17, 16, 101, 16);
		contentPane.add(label);
		
		txtSoThuHai = new JTextField();
		txtSoThuHai.setColumns(10);
		txtSoThuHai.setBounds(193, 44, 112, 28);
		contentPane.add(txtSoThuHai);
		
		final JLabel lblKetQua = new JLabel("= ???");
		lblKetQua.setBounds(317, 50, 61, 16);
		contentPane.add(lblKetQua);
		
		final JLabel lblThongBaoLoi = new JLabel("");
		lblThongBaoLoi.setBounds(0, 205, 450, 73);
		contentPane.add(lblThongBaoLoi);
		
		JButton btnTru = new JButton("-");
		btnTru.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 String soThuNhat = txtSoThuNhat.getText();
				 String soThuHai = txtSoThuHai.getText();
				 if(isNumeric(soThuNhat) && isNumeric(soThuHai)){ 
					 float num1 = Float.parseFloat(soThuNhat);
					 float num2 = Float.parseFloat(soThuHai);
					 float kq = num1-num2;
					 lblKetQua.setText(String.valueOf(kq));
				 }else{
					 lblThongBaoLoi.setText("Gia tri nhap vao khong dung. Xin hay nhap lai!");
				 }
			}
		});
		btnTru.setBounds(130, 44, 51, 29);
		contentPane.add(btnTru);
		
		JButton btnCong = new JButton("+");
		btnCong.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 String soThuNhat = txtSoThuNhat.getText();
				 String soThuHai = txtSoThuHai.getText();
				 if(isNumeric(soThuNhat) && isNumeric(soThuHai)){ 
					 float num1 = Float.parseFloat(soThuNhat);
					 float num2 = Float.parseFloat(soThuHai);
					 float kq = num1+num2;
					 lblKetQua.setText(String.valueOf(kq));
				 }else{
					 lblThongBaoLoi.setText("Gia tri nhap vao khong dung. Xin hay nhap lai!");
				 }
			}
		});
		btnCong.setBounds(130, 11, 51, 29);
		contentPane.add(btnCong);
		
		JButton btnNhan = new JButton("x");
		btnNhan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 String soThuNhat = txtSoThuNhat.getText();
				 String soThuHai = txtSoThuHai.getText();
				 if(isNumeric(soThuNhat) && isNumeric(soThuHai)){ 
					 float num1 = Float.parseFloat(soThuNhat);
					 float num2 = Float.parseFloat(soThuHai);
					 float kq = num1*num2;
					 lblKetQua.setText(String.valueOf(kq));
				 }else{
					 lblThongBaoLoi.setText("Gia tri nhap vao khong dung. Xin hay nhap lai!");
				 }
			}
		});
		btnNhan.setBounds(130, 79, 51, 29);
		contentPane.add(btnNhan);
		
		JButton btnChia = new JButton(":");
		btnChia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 String soThuNhat = txtSoThuNhat.getText();
				 String soThuHai = txtSoThuHai.getText();
				 if(isNumeric(soThuNhat) && isNumeric(soThuHai)){ 
					 float num1 = Float.parseFloat(soThuNhat);
					 float num2 = Float.parseFloat(soThuHai);
					 float kq = num1/num2;
					 lblKetQua.setText(String.valueOf(kq));
				 }else{
					 lblThongBaoLoi.setText("Gia tri nhap vao khong dung. Xin hay nhap lai!");
				 }
			}
		});
		btnChia.setBounds(130, 119, 51, 29);
		contentPane.add(btnChia);
		
	}
	
	public boolean isNumeric(String s){
		return s.matches("[-+]?\\d*\\.?\\d+");
	}
}
