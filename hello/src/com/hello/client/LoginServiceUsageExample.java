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


public class LoginServiceUsageExample extends Composite {
	User user = new User();
	LoginServiceAsync loginAsy = GWT.create(LoginService.class);
	Button login = new Button("Đăng nhập");
	public Button signUp = new Button("SignUp");
	TextBox userName = new TextBox();
	PasswordTextBox password = new PasswordTextBox();
	VerticalPanel container;
	final DialogBox dialogBox = new DialogBox();
	final VerticalPanel rootLogin = new VerticalPanel();

	public LoginServiceUsageExample() {
		dialogBox.setText("Please login");
		initWidget(rootLogin);
		container = new VerticalPanel();
		container.setSpacing(4);
		container.add(new Label("Tài khoản : "));
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
		buttons.addStyleName("buttonLogin");
		login.addStyleName("buttonLogin");
		pass.addStyleName("lablePass");
		// Create an asynchronous callback to handle the result
		final AsyncCallback<User> callback = new AsyncCallback<User>() {

			@Override
			public void onFailure(Throwable caught) {
				Window.alert("Login error, try again");
				
			}

			@Override
			public void onSuccess(User result) {
				user = result;
				if (result.getUserId() != null) {
					if(result.getRole() == 10) {
						rootLogin.clear();
						rootLogin.add(new RootPage(user));
					}
					else if(result.getRole() == 7) {
						rootLogin.clear();
						rootLogin.add(new TeacherPage(user));
					}
					else {
						rootLogin.clear();
						rootLogin.add(new StudentPage(user));
					}
					
					
				} else {
					Window.alert("Login error, try again");
				}
				
			}
			
		};
		login.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				loginAsy.getUser(userName.getText(), password.getText(), callback);
			}

		});
		password.addKeyDownHandler(new KeyDownHandler() {

			@Override
			public void onKeyDown(KeyDownEvent event) {
				if (event.getNativeKeyCode() == KeyCodes.KEY_ENTER) {
					loginAsy.getUser(userName.getText(), password.getText(), callback);
				}

			}
		});

		dialogBox.setWidget(container);
		rootLogin.add(dialogBox);
	}
}
