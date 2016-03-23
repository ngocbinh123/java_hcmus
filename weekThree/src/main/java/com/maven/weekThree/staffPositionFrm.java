package com.maven.weekThree;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class staffPositionFrm extends JFrame {

	private JPanel contentPane;
	private JTextField txtName;
	private Connection connection;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					staffPositionFrm frame = new staffPositionFrm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws Exception 
	 */
	public staffPositionFrm() throws Exception {
		connection = PostgreSQLJDBC.getInstancce().getConnection();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 687, 305);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		final JLabel lblId = new JLabel("");
		lblId.setBounds(292, 12, 61, 16);
		contentPane.add(lblId);
		
		final JLabel lblError = new JLabel("");
		lblError.setBounds(292, 87, 378, 16);
		contentPane.add(lblError);
		
		final DefaultListModel model = new DefaultListModel();
		final JList list = new JList(model);
		list.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String selectedItem = list.getSelectedValue().toString();
				String[] arrInfo = selectedItem.split(" - ");
				String seItemId = arrInfo[0];
				String seItemName = arrInfo[1];
				lblId.setText("ID: "+seItemId);
				txtName.setText(seItemName);
			}
		});
		list.setBounds(6, 6, 274, 266);
		contentPane.add(list);
		
		// add positionList into model of jlist 
		ArrayList<StaffTypeModel> poslist = getStaffPositionList();
		for (StaffTypeModel staffPositionModel : poslist) {
			if(!staffPositionModel.getName().trim().isEmpty()){
				String elem = staffPositionModel.getId() + " - "+staffPositionModel.getName();
				model.addElement(elem);
			}
		}
		txtName = new JTextField();
		txtName.setBounds(421, 6, 260, 28);
		contentPane.add(txtName);
		txtName.setColumns(10);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setBounds(374, 12, 45, 16);
		contentPane.add(lblName);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = txtName.getText().trim();
				if(name.isEmpty()){
					lblError.setText("Please choose item!");
					return;
				}
				StaffTypeModel staffType = new StaffTypeModel(name);
				Boolean isInserted = insertStaffType(staffType);
				if(isInserted){
					//insert on UI 
					StaffTypeModel staffTypeModel = null;
					try {
						staffTypeModel = getStaffTypeByName(name);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					if(staffTypeModel != null){
						staffType.setId(staffTypeModel.getId());
					}else{
						staffType.setId(-1);
					}
					String elem = staffType.getId() + " - "+ name;
					model.addElement(elem);
					
					// write log
					lblError.setText("Successfully");
					System.out.println("added data successfully");
				}else{
					lblError.setText("Fail");
					System.out.println("added data was wrong.");
				}
			}
		});
		btnAdd.setBounds(292, 46, 117, 29);
		contentPane.add(btnAdd);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String textId = lblId.getText().replace("ID: ", "");
				String name = txtName.getText().trim();
				if(textId == ""){
					lblError.setText("Please choose item!");
					return;
				}
				int id = Integer.parseInt(textId);
				StaffTypeModel staffType = new StaffTypeModel(id,name);
				Boolean isUpdated = updateStaffType(staffType);
				if (isUpdated) {
					// update ON UI 
					int selectedIndex = list.getSelectedIndex();
					String elem = id + " - "+ name;
					model.set(selectedIndex, elem);
					
					// write log
					lblError.setText("Successfully");
					System.out.println("Updated data successfully");
				}else{
					lblError.setText("Fail");
					System.out.println("Updated data was wrong.");
				}
			}
		});
		btnUpdate.setBounds(421, 46, 117, 29);
		contentPane.add(btnUpdate);
		
		JButton btnDel = new JButton("Delete");
		btnDel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String textId = lblId.getText().replace("ID: ", "");
				if(textId == ""){
					lblError.setText("Please choose item!");
					return;
				}
				int id = Integer.parseInt(textId);
				StaffTypeModel staffType = new StaffTypeModel(id,""); // deleted the object by id, so name value is unnecessary;
				Boolean isInserted = deleteStaffType(staffType);
				if(isInserted){
					//delete on UI 
					model.remove(list.getSelectedIndex());
					
					// update label and text view
					txtName.setText("");
					lblId.setText("");
					
					// write log
					lblError.setText("Successfully");
					System.out.println("deleted data successfully");
				}else{
					lblError.setText("Fail");
					System.out.println("deleted data was wrong.");
				}
			}
		});
		btnDel.setBounds(564, 46, 117, 29);
		contentPane.add(btnDel);
		
	}
	/**
	 * get all staff position in the table 
	 * return ArrayList<StaffTypeModel>
	 * */
	public ArrayList<StaffTypeModel> getStaffPositionList() throws Exception{
		ArrayList<StaffTypeModel> postList = StaffTypeModel.getInstancce().getAll();
		return postList;
	}
	
	/**
	 * update staff type information (only update name)
	 * return Boolean
	 * */
	public Boolean updateStaffType(StaffTypeModel staffType){
		return StaffTypeModel.getInstancce().update(staffType);
	}
	
	/**
	 * insert staff type information (only update name)
	 * return Boolean
	 * */
	public Boolean insertStaffType(StaffTypeModel staffType){
		return StaffTypeModel.getInstancce().insert(staffType);
	}
	
	/**
	 * insert staff type information (only update name)
	 * return Boolean
	 * */
	public Boolean deleteStaffType(StaffTypeModel staffType){
		return StaffTypeModel.getInstancce().delete(staffType);
	}
	
	/**
	 * get staff type by name
	 * return StaffTypeModel
	 * */
	public StaffTypeModel getStaffTypeByName(String name) throws Exception{
		return StaffTypeModel.getInstancce().getByName(name);
	}
}
