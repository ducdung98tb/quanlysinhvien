package com.hello.client;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.VerticalPanel;



public class ListStudent extends Composite {
	final VerticalPanel rootDetailStudent = new VerticalPanel();
	private VerticalPanel contentPanel;
	public ListStudent() {
		initWidget(this.rootDetailStudent);
		this.contentPanel = new VerticalPanel();
		this.rootDetailStudent.add(contentPanel);
		this.contentPanel.add(new DetailListStudent(this));
	}
	public void openAddStudent() {
		this.contentPanel.clear();
		AddStudent page1 = new AddStudent(this);
		this.contentPanel.add(page1);
	}
	public void openDetailListStudent() {
		this.contentPanel.clear();
		DetailListStudent page2 = new DetailListStudent(this);
		this.contentPanel.add(page2);
	}
	
}
