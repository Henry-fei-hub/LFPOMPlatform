package com.pomplatform.client.employeeaward.panel;

import java.util.logging.Logger;

import com.delicacy.client.DelicacyPanel;
import com.delicacy.client.PanelFactory;
import com.smartgwt.client.widgets.Canvas;

/**
 *
 * @author lxf
 */
public class OnEmployeeIntegralBusinessAllPanel extends DelicacyPanel {

	private static Logger __logger = Logger.getLogger("");
	protected OnEmployeeIntegralBusinessDesignPanel detailForm;

	@Override
	public Canvas getViewPanel() {
		detailForm = new OnEmployeeIntegralBusinessDesignPanel();
		detailForm.setKeepInParentRect(true);
		return detailForm;
	}

	public static class Factory implements PanelFactory {

		private String id;

		@Override
		public Canvas create() {
			OnEmployeeIntegralBusinessAllPanel cm = new OnEmployeeIntegralBusinessAllPanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "OnEmployeeIntegralBusinessAllPanel";
		}

	}

}
