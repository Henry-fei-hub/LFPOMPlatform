package com.pomplatform.client.account.panel;

import com.delicacy.client.DelicacyPanel;
import com.delicacy.client.PanelFactory;
import com.smartgwt.client.widgets.Canvas;  
  
public class ProjectAccountPanel extends DelicacyPanel {

	@Override
	public Canvas getViewPanel() {
		ProjectAccountAllPanel panel = new ProjectAccountAllPanel();
		return panel;
	}

	public static class Factory implements PanelFactory {

		private String id;

		@Override
		public Canvas create() {
			ProjectAccountPanel cm = new ProjectAccountPanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "ProjectAccountPanel";
		}

	}

}