package com.hello.client;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;

public class Header extends Composite {
	private Label link;
	final HorizontalPanel horiPanel = new HorizontalPanel();
	User user = new User();
	public Header(User user)  {
		link = new Label("[Thoát đăng nhập]");
		HTML label = new HTML("Xin chào " + user.getUserName());
		label.addStyleName("label");
		link.addStyleName("link");
		horiPanel.add(label);
		horiPanel.add(link);
		horiPanel.addStyleName("horiStyleName");
		initWidget(horiPanel);
		link.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				Window.Location.assign("http://localhost:8080/hello");
			}
		});
	}
	

}
