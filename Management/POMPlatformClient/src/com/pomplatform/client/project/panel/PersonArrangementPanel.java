package com.pomplatform.client.project.panel;

import java.util.logging.Logger;

import com.delicacy.client.DelicacyPanel;
import com.delicacy.client.PanelFactory;
import com.smartgwt.client.widgets.Canvas;

/**
 *
 * @author lxf
 */
public class PersonArrangementPanel extends DelicacyPanel {

	private static Logger __logger = Logger.getLogger("");
	protected PersonArrangementDesignPanel detailForm;

	@Override
	public Canvas getViewPanel() {
		detailForm = new PersonArrangementDesignPanel();
		detailForm.setKeepInParentRect(true);
		return detailForm;
	}

	public static class Factory implements PanelFactory {

		private String id;

		@Override
		public Canvas create() {
			PersonArrangementPanel cm = new PersonArrangementPanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "PersonArrangementPanel";
		}

	}

}
