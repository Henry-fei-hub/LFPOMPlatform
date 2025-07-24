package com.pomplatform.client.subjecttype.panel;

import java.util.logging.Logger;

import com.delicacy.client.DelicacyPanel;
import com.delicacy.client.PanelFactory;
import com.smartgwt.client.widgets.Canvas;

/**
 *
 * @author lxf
 */
public class SubjectTypeLinkDepartmentPanel extends DelicacyPanel {

	private static Logger __logger = Logger.getLogger("");
	protected SubjectTypeLinkDepartmentDesignPanel detailForm;

	@Override
	public Canvas getViewPanel() {
		detailForm = new SubjectTypeLinkDepartmentDesignPanel();
		detailForm.setKeepInParentRect(true);
		detailForm.startEdit();
		return detailForm;
	}

	public static class Factory implements PanelFactory {

		private String id;

		@Override
		public Canvas create() {
			SubjectTypeLinkDepartmentPanel cm = new SubjectTypeLinkDepartmentPanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "SubjectTypeLinkDepartment";
		}

	}

}
