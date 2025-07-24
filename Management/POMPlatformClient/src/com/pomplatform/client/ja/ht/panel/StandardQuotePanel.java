package com.pomplatform.client.ja.ht.panel;

import java.util.logging.Logger;

import com.delicacy.client.DelicacyPanel;
import com.delicacy.client.PanelFactory;
import com.smartgwt.client.widgets.Canvas;

/**
 *
 * @author lxf
 */
public class StandardQuotePanel extends DelicacyPanel {

	private static Logger __logger = Logger.getLogger("");
	protected StandardQuoteDesignPanel detailForm;

	@Override
	public Canvas getViewPanel() {
		detailForm = new StandardQuoteDesignPanel();
		detailForm.setKeepInParentRect(true);
		return detailForm;
	}

	public static class Factory implements PanelFactory {

		private String id;

		@Override
		public Canvas create() {
			StandardQuotePanel cm = new StandardQuotePanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "StandardQuotePanel";
		}

	}

}
