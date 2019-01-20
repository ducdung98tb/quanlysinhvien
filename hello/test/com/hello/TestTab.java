package com.hello;

import com.google.gwt.i18n.client.Constants;
import com.google.gwt.user.client.ui.DecoratorPanel;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.FlexTable.FlexCellFormatter;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

public class TestTab {
	/**
	 * The constants used in this Content Widget.
	 */
	public static interface CwConstants extends Constants {
		@DefaultStringValue("Add rounded corners to any Widget using the Decorator Panel")
		String cwDecoratorPanelDescription();

		@DefaultStringValue("Description:")
		String cwDecoratorPanelFormDescription();

		@DefaultStringValue("Name:")
		String cwDecoratorPanelFormName();

		@DefaultStringValue("Enter Search Criteria")
		String cwDecoratorPanelFormTitle();

		@DefaultStringValue("Decorator Panel")
		String cwDecoratorPanelName();
	}

	/**
	 * An instance of the constants.
	 */
	private  CwConstants constants;

	/**
	 * Initialize this example.
	 */
	public Widget onInitialize() {
		// Create a table to layout the form options
		FlexTable layout = new FlexTable();
		layout.setCellSpacing(6);
		FlexCellFormatter cellFormatter = layout.getFlexCellFormatter();

		// Add a title to the form
		layout.setHTML(0, 0, constants.cwDecoratorPanelFormTitle());
		cellFormatter.setColSpan(0, 0, 2);
		cellFormatter.setHorizontalAlignment(0, 0, HasHorizontalAlignment.ALIGN_CENTER);

		// Add some standard form options
		layout.setHTML(1, 0, "Name");
		layout.setWidget(1, 1, new TextBox());
		layout.setHTML(2, 0, "Description");
		layout.setWidget(2, 1, new TextBox());

		// Wrap the content in a DecoratorPanel
		DecoratorPanel decPanel = new DecoratorPanel();
		decPanel.setWidget(layout);
		return decPanel;
	}

}
