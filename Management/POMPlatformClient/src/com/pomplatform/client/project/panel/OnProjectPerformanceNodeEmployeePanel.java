package com.pomplatform.client.project.panel;

import com.delicacy.client.DelicacyPanel;
import com.delicacy.client.PanelFactory;
import com.smartgwt.client.widgets.Canvas;

public class OnProjectPerformanceNodeEmployeePanel extends DelicacyPanel {

	protected OnProjectPerformanceNodeEmployeeDesignPanel detailForm;

	@Override
	public Canvas getViewPanel() {
		detailForm = new OnProjectPerformanceNodeEmployeeDesignPanel();
		detailForm.setKeepInParentRect(true);
		return detailForm;
	}

	public static class Factory implements PanelFactory {

		private String id;

		@Override
		public Canvas create() {
			OnProjectPerformanceNodeEmployeePanel cm = new OnProjectPerformanceNodeEmployeePanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "OnProjectPerformanceNodeEmployeePanel";
		}

	}

}
