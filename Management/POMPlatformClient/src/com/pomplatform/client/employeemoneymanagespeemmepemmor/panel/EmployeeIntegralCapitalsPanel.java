package com.pomplatform.client.employeemoneymanagespeemmepemmor.panel;

import java.util.logging.Logger;

import com.delicacy.client.DelicacyPanel;
import com.delicacy.client.PanelFactory;
import com.pomplatform.client.capitaldsitributionemployee.panel.CapitalDsitributionemployeePanel;
import com.pomplatform.client.capitaldsitributionemployee.panel.MemployeeaccountrecordespemmorPanel;
import com.pomplatform.client.employeeaccountrecordeeppccmmpebor.panel.MemployeeaccountrecordeeppccmmpeborPanel;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

public class EmployeeIntegralCapitalsPanel extends DelicacyPanel {

	private static Logger __logger = Logger.getLogger("");
	
	
	private CapitalDsitributionemployeePanel emPanel;
	
	private MemployeeaccountrecordeeppccmmpeborPanel cpPanel ;
	
	private MemployeeaccountrecordespemmorPanel allIntegralPanel;

	@Override
	public Canvas getViewPanel() {
		allIntegralPanel = new MemployeeaccountrecordespemmorPanel();
		cpPanel = new MemployeeaccountrecordeeppccmmpeborPanel();
		emPanel = new CapitalDsitributionemployeePanel();
		emPanel.setCpPanel(cpPanel);
		cpPanel.setMiPanel(allIntegralPanel);
		
		allIntegralPanel.setWidth100();
		allIntegralPanel.setHeight("30%");
//		emPanel.setCpPanel(cpPanel);
		HLayout mainLayout = new HLayout();
		mainLayout.setHeight100();
		mainLayout.setWidth100();
		emPanel.setWidth("40%");
		emPanel.setHeight100();
		
		cpPanel.setWidth100();
		cpPanel.setHeight("70%");
		mainLayout.addMember(emPanel);
		VLayout rightLayout = new VLayout();
		rightLayout.setWidth("60%");
		rightLayout.setHeight100();
		rightLayout.addMember(cpPanel);
		rightLayout.addMember(allIntegralPanel);
		mainLayout.addMember(rightLayout);
		return mainLayout;
	}

	public static class Factory implements PanelFactory {

		private String id;

		@Override
		public Canvas create() {
			EmployeeIntegralCapitalsPanel cm = new EmployeeIntegralCapitalsPanel();
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

