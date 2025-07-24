package com.pomplatform.client.leavetype.panel;

import java.util.logging.Logger;

import com.delicacy.client.DelicacyPanel;
import com.delicacy.client.PanelFactory;
import com.smartgwt.client.widgets.Canvas;

public class LeaveTypeLinkProvincePanel extends DelicacyPanel {

	private static Logger __logger = Logger.getLogger("");
	protected LeaveTypeLinkProvinceDetailPanel detailForm;

	@Override
	public Canvas getViewPanel() {
		detailForm = new LeaveTypeLinkProvinceDetailPanel();
		detailForm.setKeepInParentRect(true);
		detailForm.startEdit();
		return detailForm;
	}

	public static class Factory implements PanelFactory {

		private String id;

		@Override
		public Canvas create() {
			LeaveTypeLinkProvincePanel cm = new LeaveTypeLinkProvincePanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "LeaveTypeLinkProvince";
		}

	}

}
