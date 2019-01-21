package com.hello.server;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.hello.client.RootService;
import com.hello.client.User;

import com.hello.client.Student;

public class RootServiceImpl extends RemoteServiceServlet implements RootService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ConnectDB connection = new ConnectDB();
	ResultSet rs = null;

	// Đăng kí cho học sinh
	public static boolean registerStudent(String studentName, String studentId) {
		Student student = new Student(studentId, studentName);
		try {
			ConnectDB conn = new ConnectDB();
			ResultSet rs = conn.getData("select * from student");
			while (rs.next()) {
				if (student.getStudentId().equals(rs.getObject("studentId")))
					return false;
			}
			if (studentId.isEmpty() != true && studentName.isEmpty() != true) {
				conn.activeSQL("insert into student(studentId, studentName) values('" + student.getStudentId() + "','"
						+ student.getStudentName() + "')");
				return true;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Lỗi  aaaa:" + e.getMessage());
		}
		return false;
	}

	// Đăng kí vào bảng user
	public static boolean registerUser(String userName, String userId, String password, int role) {
		User user = new User(userId, userName, password, role);
		try {
			ConnectDB conn = new ConnectDB();
			ResultSet rs = conn.getData("select * from user");
			while (rs.next()) {
				if (user.getUserId().equals(rs.getObject("userId")))
					return false;
			}
			if (userId.isEmpty() != true && userName.isEmpty() != true && password.isEmpty() != true) {
				conn.activeSQL("insert into user values('" + user.getUserId() + "','" + user.getUserName() + "','"
						+ user.getPassword() + "'," + user.getRole() + ")");
				return true;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Lỗi bbb :" + e.getMessage());
		}
		return false;
	}

	public List<User> getStudentByRoot() {
		List<User> users = new ArrayList<User>();
		User user = new User();
		try {
			rs = new ConnectDB().getData("select * from user where role = 1");
			while (rs.next()) {
				String userId = rs.getNString("userId");
				String userName = rs.getNString("userName");
				String passWord = rs.getNString("password");
				int role = rs.getInt("role");
				user = new User(userId, userName, passWord, role);
				System.out.print("xxxxx" + user.getUserId());
				users.add(user);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.print("aaa" + e.getMessage());
		}
		System.out.print(users.get(0).getUserName());
		return users;
	}

	@Override
	public boolean addStudent(String userId, String userName, String password) {
		if (registerStudent(userName, userId) && registerUser(userName, userId, password, 1) && userId.isEmpty() != true
				&& userName.isEmpty() != true && password.isEmpty() != true)
			return true;
		return false;
	}

	// Xóa ở user
	public boolean deleteAccount(String userId) {
		ConnectDB conn = new ConnectDB();
		try {
			conn.activeSQL("delete from user where userId = '" + userId + "'");
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Lỗi");
		}
		return false;
	}

	// Xóa ở student
	public boolean deleteStudent(String studentId) {
		ConnectDB conn = new ConnectDB();
		try {
			conn.activeSQL("delete from student where studentId = '" + studentId + "'");
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Lỗi");
		}
		return false;
	}

	@Override
	public boolean deleteUser(String userId) {
		if (deleteAccount(userId) && deleteStudent(userId))
			return true;
		return false;
	}

}
