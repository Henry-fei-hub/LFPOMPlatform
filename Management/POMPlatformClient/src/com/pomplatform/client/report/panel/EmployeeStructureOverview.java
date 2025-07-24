package com.pomplatform.client.report.panel;

import com.delicacy.client.DelicacyPanel;
import com.delicacy.client.PanelFactory;
import com.pomplatform.client.report.form.EmployeeStructureOverviewDesign;
import com.pomplatform.client.shift.form.MyAttendanceDesign;
import com.smartgwt.client.widgets.Canvas;

import java.util.logging.Logger;

public class EmployeeStructureOverview extends DelicacyPanel {

	private static Logger __logger = Logger.getLogger("");
	protected EmployeeStructureOverviewDesign detailForm;

	public EmployeeStructureOverview() {
	}

	@Override
	public Canvas getViewPanel() {
		detailForm = new EmployeeStructureOverviewDesign();
		detailForm.setKeepInParentRect(true);
		detailForm.startEdit();
		detailForm.loadCheckTime();
		return detailForm;
	}

	public static class Factory implements PanelFactory {

		private String id;

		@Override
		public Canvas create() {
			EmployeeStructureOverview cm = new EmployeeStructureOverview();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "EmployeeStructureOverview";
		}

	}
	

}
