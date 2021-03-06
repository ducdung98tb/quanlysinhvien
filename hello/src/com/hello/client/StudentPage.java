package com.hello.client;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.event.logical.shared.SelectionEvent;
import com.google.gwt.event.logical.shared.SelectionHandler;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.TabPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

public class StudentPage extends Composite {
	final VerticalPanel root = new VerticalPanel();
	TabPanel tabPanel;
	public StudentPage(User user) {

		
		tabPanel = new TabPanel();
		tabPanel.add(new HTML("<h1>Page 1 Content: Alpacas</h1>"), " Trang chủ ");
		tabPanel.add(new HTML("<h1>Page 1 Content: Alpacas</h1>"), " Thông tin cá nhân ");
		tabPanel.add(new HTML("<h1>Page 2 Content: Camels</h1>"), " Chương trình đào tạo ");
		tabPanel.add(new HTML("<h1>Page 3 Content: Camels</h1>"), " Thời khóa biểu ");
		tabPanel.add(new HTML("<h1>Page 3 Content: Camels</h1>"), " Đăng kí môn học ");
		tabPanel.setWidth("1457px");

		tabPanel.addSelectionHandler(new SelectionHandler<Integer>() {
			public void onSelection(SelectionEvent<Integer> event) {
				History.newItem("page" + event.getSelectedItem());
			}
		});

		History.addValueChangeHandler(new ValueChangeHandler<String>() {
			public void onValueChange(ValueChangeEvent<String> event) {
				String historyToken = event.getValue();

				// Parse the history token
				try {
					if (historyToken.substring(0, 4).equals("page")) {
						String tabIndexToken = historyToken.substring(4, 5);
						int tabIndex = Integer.parseInt(tabIndexToken);
						// Select the specified tab panel
						tabPanel.selectTab(tabIndex);
					} else {
						tabPanel.selectTab(0);
					}

				} catch (IndexOutOfBoundsException e) {
					tabPanel.selectTab(0);
				}
			}
		});

		tabPanel.selectTab(0);
		root.add(new Header(user));
		root.add(tabPanel);
		initWidget(root);
	}
}
