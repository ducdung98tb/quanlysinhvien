package com.hello;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Test {
	static String url = "jdbc:mysql://localhost:3305/project";
	static String username = "root";
	static String password = "anhdung03081998";
	public Test() {
		super();
	}
	
	public static Connection connect(){
		Connection connect = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connect = DriverManager.getConnection(url, username, password);
			System.out.println("ket noi thanh cong");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return connect;
	}
	Connection conn = this.connect();
	public  void activeSQL(String sql) throws Exception{
		PreparedStatement prep = null;
		prep = conn.prepareStatement(sql);
		prep.executeUpdate(sql);
	}
	public ResultSet getData(String sql) throws Exception{
		PreparedStatement prep = null;
		prep = conn.prepareStatement(sql);
		ResultSet rs =	prep.executeQuery(sql);
		return rs;
	}
	public static boolean checkLogin(String username, String password) {
		ResultSet rs = null;
		PreparedStatement prep = null;
		try {
			String sql = "Select * from user where userId = '" + username + "' and password = '" + password + "'";
			Connection conn = connect();
			prep = conn.prepareStatement(sql);
			rs =	prep.executeQuery(sql);
			if(rs.next())
				return true;
			else return false;
			
		} catch (Exception e) {
			e.printStackTrace();
			try {
				if(!rs.isClosed())
					rs.close();
				if(!prep.isClosed())
					prep.close();
			}
			catch (Exception err) {
			}
		}
		return false;
		
	}
	public static void main(String[] args) {
		Connection conn = connect();
		System.out.print(conn);
		
		

	}

}
