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
	private JTextField txtSearchId;
	private JTextField txtSearchName;
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
		ArrayList<StaffTypeModel> poslist = getStaffTypeList();
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
		
		JPanel panel = new JPanel();
		panel.setBounds(292, 109, 389, 168);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblId_1 = new JLabel("ID: ");
		lblId_1.setBounds(6, 11, 27, 16);
		panel.add(lblId_1);
		
		txtSearchId = new JTextField();
		txtSearchId.setBounds(30, 5, 65, 28);
		txtSearchId.setColumns(10);
		panel.add(txtSearchId);
		
		JLabel label = new JLabel("Name:");
		label.setBounds(114, 11, 45, 16);
		panel.add(label);
		
		txtSearchName = new JTextField();
		txtSearchName.setColumns(10);
		txtSearchName.setBounds(162, 5, 222, 28);
		panel.add(txtSearchName);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String txtId = txtSearchId.getText().trim();
				String name = txtSearchName.getText().trim();
				
				System.out.println(txtId);
				int id = Integer.parseInt(txtId);
				StaffTypeModel staffType = new StaffTypeModel(id, name);
				ArrayList<StaffTypeModel> poslist = null;
				try {
					poslist = searchStaffType(staffType);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				if(poslist != null){
					model.removeAllElements();
					for (StaffTypeModel staffPositionModel : poslist) {
						if(!staffPositionModel.getName().trim().isEmpty()){
							String elem = staffPositionModel.getId() + " - "+staffPositionModel.getName();
							model.addElement(elem);
						}
					}
				}
			}
		});
		btnSearch.setBounds(6, 45, 117, 29);
		panel.add(btnSearch);
		
		JButton btnSearchById = new JButton("Search By Id");
		btnSearchById.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String txtId = txtSearchId.getText().trim();
	
				System.out.println(txtId);
				int id = Integer.parseInt(txtId);
				StaffTypeModel staffType = null;
				try {
					staffType = getStaffTypeById(id);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
					
				if(staffType != null){
					model.removeAllElements();
					String elem = staffType.getId() + " - "+staffType.getName();
					model.addElement(elem);
				}
			}
		});
		btnSearchById.setBounds(267, 45, 117, 29);
		panel.add(btnSearchById);
		
	}
	
	/**
	 * check the text is numeric 
	 * return boolean
	 * */
	public Boolean isNumeric(String s){
		return s.matches("[-+]?\\d*\\.?\\d+");
	}
	
	/**
	 * get all staff position in the table 
	 * return ArrayList<StaffTypeModel>
	 * */
	public ArrayList<StaffTypeModel> getStaffTypeList() throws Exception{
		ArrayList<StaffTypeModel> postList = StaffTypeModel.getInstancce().getAll();
		return postList;
	}
	
	/**
	 * get staff position by param in the table 
	 * return ArrayList<StaffTypeModel>
	 * */
	public ArrayList<StaffTypeModel> searchStaffType(StaffTypeModel staffType) throws Exception{
		ArrayList<StaffTypeModel> postList = StaffTypeModel.getInstancce().search(staffType);
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
	
	/**
	 * get staff type by id
	 * return StaffTypeModel
	 * */
	public StaffTypeModel getStaffTypeById(int id) throws Exception{
		return StaffTypeModel.getInstancce().getById(id);
	}
}
