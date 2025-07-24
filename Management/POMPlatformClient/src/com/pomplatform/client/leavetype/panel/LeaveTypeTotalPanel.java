package com.pomplatform.client.leavetype.panel;

import java.util.logging.Logger;

import com.delicacy.client.DelicacyPanel;
import com.delicacy.client.PanelFactory;
import com.smartgwt.client.widgets.Canvas;

public class LeaveTypeTotalPanel extends DelicacyPanel {

	private static Logger __logger = Logger.getLogger("");
	protected LeaveTypeTotalDesignPanel detailForm;

	@Override
	public Canvas getViewPanel() {
		detailForm = new LeaveTypeTotalDesignPanel();
		detailForm.setKeepInParentRect(true);
		return detailForm;
	}

	public static class Factory implements PanelFactory {

		private String id;

		@Override
		public Canvas create() {
			LeaveTypeTotalPanel cm = new LeaveTypeTotalPanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "";
		}

	}

}
