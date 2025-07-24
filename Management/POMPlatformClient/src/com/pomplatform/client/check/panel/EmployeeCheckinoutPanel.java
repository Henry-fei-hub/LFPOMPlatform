package com.pomplatform.client.check.panel;

import java.util.logging.Logger;

import com.delicacy.client.DelicacyPanel;
import com.delicacy.client.PanelFactory;
import com.smartgwt.client.widgets.Canvas;

/**
 *
 * @author 
 */
public class EmployeeCheckinoutPanel extends DelicacyPanel {

	private static Logger __logger = Logger.getLogger("");
	protected EmployeeCheckinoutForm detailForm;

	@Override
	public Canvas getViewPanel() {
		detailForm = new EmployeeCheckinoutForm();
		detailForm.setKeepInParentRect(true);
		detailForm.startEdit();
		return detailForm;
	}

	public static class Factory implements PanelFactory {

		private String id;

		@Override
		public Canvas create() {
			EmployeeCheckinoutPanel cm = new EmployeeCheckinoutPanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "CompanyReportIntegral";
		}

	}

}
