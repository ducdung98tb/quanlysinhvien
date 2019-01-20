package com.hello.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Hello implements EntryPoint {
	@Override
	public void onModuleLoad() {
		RootPanel.get("test").add(new LoginServiceUsageExample());	
	}	
}
