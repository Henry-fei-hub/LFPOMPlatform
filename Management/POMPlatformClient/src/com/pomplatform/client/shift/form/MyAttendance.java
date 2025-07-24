package com.pomplatform.client.shift.form;

import java.util.logging.Logger;

import com.delicacy.client.DelicacyPanel;
import com.delicacy.client.PanelFactory;
import com.smartgwt.client.widgets.Canvas;

public class MyAttendance extends DelicacyPanel {

	private static Logger __logger = Logger.getLogger("");
	protected MyAttendanceDesign detailForm;
	
	public MyAttendance() {
	}

	@Override
	public Canvas getViewPanel() {
		detailForm = new MyAttendanceDesign();
		detailForm.setKeepInParentRect(true);
		detailForm.startEdit();
		detailForm.loadCheckTime();
		return detailForm;
	}

	public static class Factory implements PanelFactory {

		private String id;

		@Override
		public Canvas create() {
			MyAttendance cm = new MyAttendance();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "SemployeeNew";
		}

	}
	

}
