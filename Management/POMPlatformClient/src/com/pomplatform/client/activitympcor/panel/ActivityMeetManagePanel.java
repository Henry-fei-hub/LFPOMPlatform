package com.pomplatform.client.activitympcor.panel;

import java.util.logging.Logger;

import com.delicacy.client.DelicacyPanel;
import com.delicacy.client.PanelFactory;
import com.smartgwt.client.widgets.Canvas;

public class ActivityMeetManagePanel extends DelicacyPanel{
	private static Logger __logger = Logger.getLogger("");
	protected ActivityMeetManageDesignPanel detailForm;
	@Override
	public Canvas getViewPanel() {
		detailForm = new ActivityMeetManageDesignPanel();
		detailForm.setKeepInParentRect(true);
		return detailForm;
	}
	public static class Factory implements PanelFactory{

		private String id;

		@Override
		public Canvas create() {
			ActivityMeetManagePanel cm = new ActivityMeetManagePanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "ActivityMeetManagePanel";
		}

	}

}
