package com.pomplatform.client.employeemoneymanagespeemmepemmor.panel;

import java.util.logging.Logger;

import com.delicacy.client.DelicacyPanel;
import com.delicacy.client.PanelFactory;
import com.delicacy.client.data.ClientUtil;
import com.pomplatform.client.ERPPermissionStatic;
import com.pomplatform.client.receiveunit.panel.MprocessbilllistsmmeorPanel;
import com.pomplatform.client.receiveunit.panel.MreceiveunitmanagepsrbborPanel;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.layout.HLayout;

public class ReceiveUnitCapitalsPanel extends DelicacyPanel {

	private static Logger __logger = Logger.getLogger("");
	
	
	private MreceiveunitmanagepsrbborPanel rmPanel;
	
	private MprocessbilllistsmmeorPanel pblPanel ;

	@Override
	public Canvas getViewPanel() {
		pblPanel = new MprocessbilllistsmmeorPanel();
		rmPanel = new MreceiveunitmanagepsrbborPanel();
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
			ReceiveUnitCapitalsPanel cm = new ReceiveUnitCapitalsPanel();
			id = cm.getID();
			return cm;
		}

		@Override
		public String getID() {
			return id;
		}

		@Override
		public String getDescription() {
			return "EmployeeCapitalsPanel";
		}

	}


}

