package com.maven.weekThree;


import java.sql.*;
import java.util.*;
public class PostgreSQLJDBC {
	private static PostgreSQLJDBC postgresql;
	private Connection connection;
	
	private void connected(){
		try{
			  Driver driver = new org.postgresql.Driver();
			  DriverManager.registerDriver(driver);
			  String conString= "jdbc:postgresql://localhost:5432/cookingmanagement_v1";
			  Properties info = new Properties();
			  info.setProperty("characterEncoding", "utf8");
			  info.setProperty("user", "postgres");
			  info.setProperty("password", "123456");
			  this.connection = DriverManager.getConnection(conString, info);
			  System.out.println("Opened database successfully");
		  }catch(Exception e){
			  e.printStackTrace();  
			  System.err.println(e.getClass().getName()+": "+e.getMessage());
			  System.exit(0);
		  }
	}
	
	private void closeConnection() throws Exception{
		connection.close();
	}

	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}
	
	/**
	 * run query that needed returned data
	 * return ResultSet
	 * */
	public ResultSet executeQuery(String sql) throws Exception{
		Statement statement = connection.createStatement();
		ResultSet rs = statement.executeQuery(sql);
		return rs;
	}
	
	public boolean executeUpdate(String sql){
		try{
			Statement statement = connection.createStatement();
			statement.executeUpdate(sql);
			return true;
		}catch(Exception e){
			System.out.println(e);
		}
		return false;
	}
	
	public static PostgreSQLJDBC getInstancce(){
		if(postgresql == null){
			postgresql = new PostgreSQLJDBC();
		}
		return postgresql;
	}

	/**
	 * 
	 */
	public PostgreSQLJDBC() {
		super();
		connected();
	}
	
}
