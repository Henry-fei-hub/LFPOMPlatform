package com.pomplatform.client.workflow.panel;

import java.util.logging.Logger;

import com.delicacy.client.DelicacyPanel;
import com.delicacy.client.PanelFactory;
import com.smartgwt.client.widgets.Canvas;

/**
 *
 * @author lxf
 */
public class MyTaskPanel extends DelicacyPanel {

	private static Logger __logger = Logger.getLogger("");
	protected MyTaskDesignPanel detailForm;

	@Override
	public Canvas getViewPanel() {
		detailForm = new MyTaskDesignPanel();
		detailForm.setKeepInParentRect(true);
		return detailForm;
	}

	public static class Factory implements PanelFactory {

		private String id;

		@Override
		public Canvas create() {
			MyTaskPanel cm = new MyTaskPanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "MyWorkflowPanel";
		}

	}

}
