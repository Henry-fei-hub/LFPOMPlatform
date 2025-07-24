package com.pomplatform.client.annoucement.panel;

import java.util.logging.Logger;

import com.delicacy.client.DelicacyPanel;
import com.delicacy.client.PanelFactory;
import com.smartgwt.client.widgets.Canvas;

public class AnnoucementManagePanel extends DelicacyPanel{
	private static Logger __logger = Logger.getLogger("");
	protected AnnoucementManageDesignPanel detailForm;
	@Override
	public Canvas getViewPanel() {
		detailForm = new AnnoucementManageDesignPanel();
		detailForm.setKeepInParentRect(true);
		return detailForm;
	}
	public static class Factory implements PanelFactory{

		private String id;

		@Override
		public Canvas create() {
			AnnoucementManagePanel cm = new AnnoucementManagePanel();
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
