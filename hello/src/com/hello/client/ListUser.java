package com.hello.client;

import java.util.ArrayList;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.VerticalPanel;

public class ListUser extends Composite {
	final VerticalPanel root = new VerticalPanel();
	FlexTable userFlexTable;
	private ArrayList<User> users = new ArrayList<User>();
	public ListUser() {
		userFlexTable = new FlexTable();
		userFlexTable.setText(0, 0, "Symbol");
		userFlexTable.setText(0, 1, "Price");
		userFlexTable.setText(0, 2, "Change");
		userFlexTable.setText(0, 3, "Remove");
		
		userFlexTable.setCellPadding(6);
		
		userFlexTable.getRowFormatter().addStyleName(0, "helloListHeader");
		  
		userFlexTable.addStyleName("userList");
		userFlexTable.getCellFormatter().addStyleName(0, 1, "userListNumericColumn");
		userFlexTable.getCellFormatter().addStyleName(0, 2, "userListNumericColumn");
		userFlexTable.getCellFormatter().addStyleName(0, 3, "userListRemoveColumn");
		root.add(userFlexTable);
		
		initWidget(root);
	}
}
