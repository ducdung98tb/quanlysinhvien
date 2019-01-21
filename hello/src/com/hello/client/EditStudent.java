package com.hello.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyDownEvent;
import com.google.gwt.event.dom.client.KeyDownHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

public class EditStudent extends Composite {
	User user = new User();
	RootServiceAsync rootAsync = GWT.create(RootService.class);
	Button login = new Button("Xác nhận");
	TextBox userId = new TextBox();
	TextBox userName = new TextBox();
	PasswordTextBox password = new PasswordTextBox();
	VerticalPanel container;
	ListStudent listStudent;
	final DialogBox dialogBox = new DialogBox();
	final VerticalPanel rootAddStudent = new VerticalPanel();

	public EditStudent(ListStudent listStudent) {
		dialogBox.setText("Thêm sinh viên");
		initWidget(rootAddStudent);
		container = new VerticalPanel();
		container.setSpacing(4);
		container.add(new Label("Mã số sinh viên : "));
		container.add(userId);
		Label usName = new Label("Tên sinh viên : ");
		container.add(usName);
		container.add(userName);
		Label pass = new Label("Mật khẩu : ");
		container.add(pass);
		container.add(password);
		HorizontalPanel buttons = new HorizontalPanel();
		buttons.add(login);
		dialogBox.addStyleName("dialogBox");
		container.add(buttons);
		container.addStyleName("cont");
		userName.addStyleName("input");
		password.addStyleName("input");
		userId.addStyleName("input");

		buttons.addStyleName("buttonLogin");
		login.addStyleName("buttonLogin");
		pass.addStyleName("lablePass");
		usName.addStyleName("lablePass");
		// Create an asynchronous callback to handle the result
		final AsyncCallback<Boolean> callback = new AsyncCallback<Boolean>() {

			@Override
			public void onFailure(Throwable caught) {
				listStudent.openDetailListStudent();
				Window.alert("add student error, try again");

			}

			@Override
			public void onSuccess(Boolean result) {
				if (result) {
					listStudent.openDetailListStudent();
					Window.alert("add student successfull");
				} else {
					listStudent.openDetailListStudent();
					Window.alert("add student error, try again");
				}

			}

		};
		login.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				rootAsync.addStudent(userId.getText(), userName.getText(), password.getText(), callback);
			}

		});
		password.addKeyDownHandler(new KeyDownHandler() {

			@Override
			public void onKeyDown(KeyDownEvent event) {
				if (event.getNativeKeyCode() == KeyCodes.KEY_ENTER) {
					rootAsync.addStudent(userId.getText(), userName.getText(), password.getText(), callback);
				}

			}
		});

		dialogBox.setWidget(container);
		rootAddStudent.add(dialogBox);
	}
}
