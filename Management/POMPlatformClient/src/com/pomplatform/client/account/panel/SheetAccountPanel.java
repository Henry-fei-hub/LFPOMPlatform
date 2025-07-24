package com.pomplatform.client.account.panel;

import com.delicacy.client.DelicacyPanel;
import com.delicacy.client.PanelFactory;
import com.smartgwt.client.widgets.Canvas;  
  
public class SheetAccountPanel extends DelicacyPanel {

	@Override
	public Canvas getViewPanel() {
		SheetAccountAllPanel panel = new SheetAccountAllPanel();
		return panel;
	}

	public static class Factory implements PanelFactory {

		private String id;

		@Override
		public Canvas create() {
			SheetAccountPanel cm = new SheetAccountPanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "SheetAccountPanel";
		}

	}

}