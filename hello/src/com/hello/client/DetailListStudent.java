package com.hello.client;

import java.util.List;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

public class DetailListStudent extends Composite {
	final VerticalPanel root = new VerticalPanel();
	FlexTable userFlexTable;
	Label title = new Label("Quản lý sinh viên");
	Button addStudent = new Button("Thêm sinh viên");
	RootServiceAsync rootAsync = GWT.create(RootService.class);
	ListStudent lisetStudent;

	public DetailListStudent(ListStudent listStudent) {
		this.lisetStudent = listStudent;
		userFlexTable = new FlexTable();
		final AsyncCallback<List<User>> callback = new AsyncCallback<List<User>>() {

			@Override
			public void onFailure(Throwable caught) {
				Window.alert("có lỗi xảy ra");

			}

			@Override
			public void onSuccess(List<User> result) {
				for (int i = 1; i <= result.size() + 1; i++) {
					userFlexTable.setText(i, 0, result.get(i - 1).getUserId());
					userFlexTable.setText(i, 1, result.get(i - 1).getUserName());
					userFlexTable.setText(i, 2, result.get(i - 1).getPassword());
					userFlexTable.setWidget(i, 3, this.horPanel(userFlexTable.getText(i, 0)));
				}

			}

			private Widget horPanel(String studentId) {
				Button editStudent = new Button("Sửa");
				Button deleteStudent = new Button("Xóa");
				HorizontalPanel horPanel = new HorizontalPanel();
				horPanel.add(editStudent);
				horPanel.add(deleteStudent);
				editStudent.addStyleName("editStudent");
				final AsyncCallback<Boolean> callback = new AsyncCallback<Boolean>() {

					@Override
					public void onFailure(Throwable caught) {
						listStudent.openDetailListStudent();
						Window.alert("delete error, try again");

					}

					@Override
					public void onSuccess(Boolean result) {
						if (result) {
							listStudent.openDetailListStudent();
							Window.alert("delete successfull");
						} else {
							listStudent.openDetailListStudent();
							Window.alert("delete error, try again");
						}

					}

				};
				deleteStudent.addClickHandler(new ClickHandler() {

					@Override
					public void onClick(ClickEvent event) {
						// TODO Auto-generated method stub
						rootAsync.deleteUser(studentId, callback);
					}
				});
				editStudent.addClickHandler(new ClickHandler() {

					@Override
					public void onClick(ClickEvent event) {
						// TODO Auto-generated method stub

					}
				});
				return horPanel;
			}

		};

		rootAsync.getStudentByRoot(callback);
		;
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

		title.addStyleName("titlePage");
		addStudent.addStyleName("addButton");
		root.add(title);
		root.add(addStudent);
		root.add(userFlexTable);
		initWidget(root);

		addStudent.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				listStudent.openAddStudent();
			}

		});
	}
}
