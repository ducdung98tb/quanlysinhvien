package com.hello.server;

import java.sql.ResultSet;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.hello.client.LoginService;
import com.hello.client.User;





public class LoginServiceImpl extends RemoteServiceServlet implements LoginService {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ConnectDB connection = new ConnectDB();
	ResultSet rs = null;
	public User getUser(String username, String password) {
		User user = new User();
		try {
			ResultSet rs = new ConnectDB().getData("select * from user where userId='" + username + "' and password = '" + password + "'");
			while (rs.next()) {
				String userId = rs.getNString("userId");
				String userName = rs.getNString("userName");
				String passWord = rs.getNString("password");
				int role = rs.getInt("role");
				user = new User(userId, userName, passWord, role);
				return user;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}
}

