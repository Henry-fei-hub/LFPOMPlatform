package com.pomplatform.client.employeemoneymanagespeemmepemmor.panel;

import java.util.logging.Logger;

import com.delicacy.client.DelicacyPanel;
import com.delicacy.client.PanelFactory;
import com.pomplatform.client.receiveunit.panel.MemployeeProcessbilllistsmmeorPanel;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.layout.HLayout;

public class ReceiveUnitEmployeeCapitalsPanel extends DelicacyPanel {

	private static Logger __logger = Logger.getLogger("");

	private MemployeepsrreereeedporPanel rmPanel;

	private MemployeeProcessbilllistsmmeorPanel pblPanel;

	@Override
	public Canvas getViewPanel() {
		pblPanel = new MemployeeProcessbilllistsmmeorPanel();
		rmPanel = new MemployeepsrreereeedporPanel();
		rmPanel.setPblPanel(pblPanel);
		HLayout mainLayout = new HLayout();
		mainLayout.setHeight100();
		mainLayout.setWidth100();
		rmPanel.setWidth("50%");
		rmPanel.setHeight100();

		pblPanel.setWidth("50%");
		pblPanel.setHeight100();
		mainLayout.addMember(rmPanel);
		mainLayout.addMember(pblPanel);
		return mainLayout;
	}

	public static class Factory implements PanelFactory {

		private String id;

		@Override
		public Canvas create() {
			ReceiveUnitEmployeeCapitalsPanel cm = new ReceiveUnitEmployeeCapitalsPanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "ReceiveUnitEmployeeCapitalsPanel";
		}

	}

}
