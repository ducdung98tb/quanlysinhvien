//package com.hello.client;
//
//import com.google.gwt.core.client.EntryPoint;
//import com.google.gwt.user.client.ui.RootPanel;
//
///**
// * Entry point classes define <code>onModuleLoad()</code>.
// */
//public class Hello implements EntryPoint {
//	@Override
//	public void onModuleLoad() {
//		RootPanel.get("login").add(new LoginServiceUsageExample());	
//	}
//}
package com.hello.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.logical.shared.SelectionEvent;
import com.google.gwt.event.logical.shared.SelectionHandler;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Hyperlink;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TabPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Hello implements EntryPoint, ValueChangeHandler<String> {

	TabPanel tabPanel;

	/**
	 * This is the entry point method.
	 */
//	 public void onModuleLoad() {
//	 tabPanel = new TabPanel();
//	 VerticalPanel vertPanel = new VerticalPanel();
//	 tabPanel.add(new LoginServiceUsageExample(), " Page 0 ");
//	 tabPanel.add(new HTML("<h1>Page 1 Content: Alpacas</h1>"), " Page 1 ");
//	 tabPanel.add(new HTML("<h1>Page 2 Content: Camels</h1>"), " Page 2 ");
//	 tabPanel.add(new HTML("<h1>Page 3 Content: Camels</h1>"), " Page 3 ");
//	
//	 tabPanel.addSelectionHandler(new SelectionHandler<Integer>() {
//	 public void onSelection(SelectionEvent<Integer> event) {
//	 History.newItem("page" + event.getSelectedItem());
//	 }
//	 });
//	
//	 History.addValueChangeHandler(new ValueChangeHandler<String>() {
//	 public void onValueChange(ValueChangeEvent<String> event) {
//	 String historyToken = event.getValue();
//	
//	 // Parse the history token
//	 try {
//	 if (historyToken.substring(0, 4).equals("page")) {
//	 String tabIndexToken = historyToken.substring(4, 5);
//	 int tabIndex = Integer.parseInt(tabIndexToken);
//	 // Select the specified tab panel
//	 tabPanel.selectTab(tabIndex);
//	 } else {
//	 tabPanel.selectTab(0);
//	 }
//	
//	 } catch (IndexOutOfBoundsException e) {
//	 tabPanel.selectTab(0);
//	 }
//	 }
//	 });
//	
//	 tabPanel.selectTab(0);
//	 RootPanel.get("test").add(tabPanel);
//	 }
	private Label lbl = new Label();
	private VerticalPanel panel = new VerticalPanel();
	private Hyperlink link0;
	private Hyperlink link1;
	private Hyperlink link2;
	private int id = 1;
	public void onModuleLoad() {
		// Create three hyperlinks that change the application's history.
		link0 = new Hyperlink("link to too", "id=" + id);
		link1 = new Hyperlink("link to bar", "id=2");
		link2 = new Hyperlink("link to baz", "id=3");

		// If the application starts with no history token, redirect to a new
		// 'baz' state.
		String initToken = History.getToken();
		if (initToken.length() == 0) {
			History.newItem("baz");
		}

		// Add widgets to the root panel.
		
		panel.add(lbl);
		panel.add(link0);
		panel.add(link1);
		panel.add(link2);
		RootPanel.get("test").add(panel);

		// Add history listener
		History.addValueChangeHandler((ValueChangeHandler<String>) this);

		// Now that we've setup our listener, fire the initial history state.
		History.fireCurrentHistoryState();
	}

	public void onValueChange(ValueChangeEvent<String> event) {
		System.out.print(event);
		if(event.getValue().equals("id="+id)) {
			panel.clear();

			panel.add(lbl);
			panel.add(link0);
			panel.add(link1);
			panel.add(link2);
			panel.add(new LoginServiceUsageExample());
		}
		else {
			panel.clear();

			panel.add(lbl);
			panel.add(link0);
			panel.add(link1);
			panel.add(link2);
		}
		// This method is called whenever the application's history changes. Set
		// the label to reflect the current history token.
		lbl.setText("The current history token is: " + event.getValue());
	}

	
}
