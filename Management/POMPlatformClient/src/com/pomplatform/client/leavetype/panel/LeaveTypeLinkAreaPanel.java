package com.pomplatform.client.leavetype.panel;

import java.util.logging.Logger;

import com.delicacy.client.DelicacyPanel;
import com.delicacy.client.PanelFactory;
import com.smartgwt.client.widgets.Canvas;

public class LeaveTypeLinkAreaPanel extends DelicacyPanel {

	private static Logger __logger = Logger.getLogger("");
	protected LeaveTypeLinkAreaDetailPanel detailForm;

	@Override
	public Canvas getViewPanel() {
		detailForm = new LeaveTypeLinkAreaDetailPanel();
		detailForm.setKeepInParentRect(true);
		detailForm.startEdit();
		return detailForm;
	}

	public static class Factory implements PanelFactory {

		private String id;

		@Override
		public Canvas create() {
			LeaveTypeLinkAreaPanel cm = new LeaveTypeLinkAreaPanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "LeaveTypeLinkArea";
		}

	}

}
