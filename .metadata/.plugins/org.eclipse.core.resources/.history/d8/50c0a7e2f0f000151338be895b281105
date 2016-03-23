package com.maven.weekThree;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class StaffTypeModel {
	private int id; 
	private String name;
	
	private final static String mTableName = "stafftype";
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	private static StaffTypeModel mPosModel;
	
	/**
	 * get all data in the table 
	 * return ArrayList<StaffTypeModel>
	 */
	public ArrayList<StaffTypeModel> getAll() throws Exception{
		ArrayList<StaffTypeModel> res = new ArrayList<StaffTypeModel>();
		String sql ="select * from "+mTableName;
		ResultSet rs = PostgreSQLJDBC.getInstancce().executeQuery(sql);
	
		//Handle returned data 
		while(rs.next()){
			int id = rs.getInt("id"); // id column
			String name = rs.getString("name"); // name column 
			StaffTypeModel posModel = new StaffTypeModel(id,name);
			res.add(posModel);
		}
		return res;
	}
	
	public StaffTypeModel getByName(String name) throws Exception{
		
		String sql = String.format("SELECT * FROM %s WHERE name='%s'", mTableName, name);
		System.out.println(sql);
		ResultSet rs = PostgreSQLJDBC.getInstancce().executeQuery(sql);
	
		//Handle returned data 
		while(rs.next()){
			int id = rs.getInt("id"); // id column
			System.out.println(id);
			StaffTypeModel posModel = new StaffTypeModel(id,name);
			return posModel;
		}
		return null;
	}
	
	public Boolean update(StaffTypeModel staffType){  
		String sql = String.format("UPDATE %s SET name='%s' WHERE id=%d", mTableName,staffType.name, staffType.id);
		System.out.println(sql);
		return PostgreSQLJDBC.getInstancce().executeUpdate(sql);
	}
	
	public Boolean insert(StaffTypeModel staffType){  
		String sql = String.format("INSERT INTO  %s(name) VALUES('%s')", mTableName,staffType.name);
		System.out.println(sql);
		return PostgreSQLJDBC.getInstancce().executeUpdate(sql);
	}
	
	public Boolean delete(StaffTypeModel staffType){  
		//DELETE FROM public.stafftypeWHERE id=16;
		String sql = String.format("DELETE FROM  %s WHERE id=%d", mTableName,staffType.id);
		System.out.println(sql);
		return PostgreSQLJDBC.getInstancce().executeUpdate(sql);
	}
	
	/**
	 * @param name
	 */
	public StaffTypeModel(String name) {
		super();
		this.name = name;
	}
	
	/**
	 * @param id
	 * @param name
	 */
	public StaffTypeModel(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	/**
	 * 
	 */
	public StaffTypeModel() {
		super();
	}
	
	public static StaffTypeModel getInstancce(){
		if(mPosModel == null){
			mPosModel = new StaffTypeModel();
		}
		return mPosModel;
	}
}
