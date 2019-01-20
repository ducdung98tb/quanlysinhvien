package com.hello.server;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ConnectDB {
	String url = "jdbc:mysql://localhost:3305/project";
	String username = "root";
	String password = "anhdung03081998";
	public ConnectDB() {
		super();
	}
	public Connection connect(){
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
	public void activeSQL(String sql) throws Exception{
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
}
