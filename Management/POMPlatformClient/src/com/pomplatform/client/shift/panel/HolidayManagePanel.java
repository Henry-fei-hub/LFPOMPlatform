package com.pomplatform.client.shift.panel;

import java.util.logging.Logger;

import com.delicacy.client.DelicacyPanel;
import com.delicacy.client.PanelFactory;
import com.smartgwt.client.widgets.Canvas;

/**
 *
 * @author lxf
 */
public class HolidayManagePanel extends DelicacyPanel {

	private static Logger __logger = Logger.getLogger("");
	protected HolidayManageDesignPanel detailForm;

	@Override
	public Canvas getViewPanel() {
		detailForm = new HolidayManageDesignPanel();
		detailForm.setKeepInParentRect(true);
		return detailForm;
	}

	public static class Factory implements PanelFactory {

		private String id;

		@Override
		public Canvas create() {
			HolidayManagePanel cm = new HolidayManagePanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "HolidayManagePanel";
		}

	}

}
