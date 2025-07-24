package com.pomplatform.client.workflow.panel;

import java.util.logging.Logger;

import com.delicacy.client.DelicacyPanel;
import com.delicacy.client.PanelFactory;
import com.smartgwt.client.widgets.Canvas;

/**
 *
 * @author lxf
 */
public class MyWorkPanel extends DelicacyPanel {

	private static Logger __logger = Logger.getLogger("");
	protected MyWorkDesignPanel detailForm;

	@Override
	public Canvas getViewPanel() {
		detailForm = new MyWorkDesignPanel();
		detailForm.setKeepInParentRect(true);
		setWidth("99%");
		return detailForm;
	}

	public static class Factory implements PanelFactory {

		private String id;

		@Override
		public Canvas create() {
			MyWorkPanel cm = new MyWorkPanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "MyWorkPanel";
		}

	}

}
