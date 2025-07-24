package com.pomplatform.client.onrevenue.panel;

import java.util.logging.Logger;

import com.delicacy.client.DelicacyPanel;
import com.delicacy.client.PanelFactory;
import com.smartgwt.client.widgets.Canvas;

/**
 *
 * @author lxf
 */
public class FinishPercentSurePanel extends DelicacyPanel {

	private static Logger __logger = Logger.getLogger("");
	protected FinishPercentSureDesignPanel detailForm;

	@Override
	public Canvas getViewPanel() {
		detailForm = new FinishPercentSureDesignPanel();
		detailForm.setKeepInParentRect(true);
		detailForm.startEdit();
		return detailForm;
	}

	public static class Factory implements PanelFactory {

		private String id;

		@Override
		public Canvas create() {
			FinishPercentSurePanel cm = new FinishPercentSurePanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "FinishPercentSurePanel";
		}

	}

}
