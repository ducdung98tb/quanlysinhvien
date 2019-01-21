package com.hello.client;

import java.util.ArrayList;

import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;

public class ListUser extends Composite {
	final VerticalPanel root = new VerticalPanel();
	FlexTable userFlexTable;
	Label title = new Label("Quản lý sinh viên");
	Button addStudent = new Button("Thêm sinh viên");
	private ArrayList<User> users = new ArrayList<User>();

	public ListUser() {
		userFlexTable = new FlexTable();
		userFlexTable.setText(0, 0, "MSSV");
		userFlexTable.setText(0, 1, "Tên sinh viên");
		userFlexTable.setText(0, 2, "Mật khẩu");
		userFlexTable.setText(0, 3, "Chức năng");

		userFlexTable.setCellPadding(6);

		userFlexTable.getRowFormatter().addStyleName(0, "helloListHeader");

		userFlexTable.addStyleName("userList");
		userFlexTable.getCellFormatter().addStyleName(0, 0, "userListNumericColumn0");
		userFlexTable.getCellFormatter().addStyleName(0, 1, "userListNumericColumn");
		userFlexTable.getCellFormatter().addStyleName(0, 2, "userListNumericColumn");
		userFlexTable.getCellFormatter().addStyleName(0, 3, "userListRemoveColumn");

		userFlexTable.setText(1, 0, "20160656");
		userFlexTable.setText(1, 1, "Lê Đức Dũng");
		userFlexTable.setText(1, 2, "03081998");
		userFlexTable.setText(1, 3, "Chức năng");
		title.addStyleName("titlePage");
		addStudent.addStyleName("addButton");
		root.add(title);
		root.add(addStudent);
		root.add(userFlexTable);
		initWidget(root);
	}
}
