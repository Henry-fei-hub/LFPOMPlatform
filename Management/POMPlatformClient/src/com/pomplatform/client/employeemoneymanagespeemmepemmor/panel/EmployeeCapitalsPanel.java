package com.pomplatform.client.employeemoneymanagespeemmepemmor.panel;

import java.util.logging.Logger;

import com.delicacy.client.DelicacyPanel;
import com.delicacy.client.PanelFactory;
import com.delicacy.client.data.ClientUtil;
import com.pomplatform.client.ERPPermissionStatic;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.layout.HLayout;

public class EmployeeCapitalsPanel extends DelicacyPanel {

	private static Logger __logger = Logger.getLogger("");
	
	
	private EmployeeCaptionInfoSearchPanel emPanel;
	
	private MemployeemoneymanagespeemmepemmorPanel cpPanel ;

	@Override
	public Canvas getViewPanel() {
		cpPanel = new MemployeemoneymanagespeemmepemmorPanel();
		emPanel = new EmployeeCaptionInfoSearchPanel();
		if(ClientUtil.checkIsHavePermission(ERPPermissionStatic.EC_SHOW_ALL)){
			
		}else if(ClientUtil.checkIsHavePermission(ERPPermissionStatic.EC_SHOW_OWN)){
			emPanel.hide();
			cpPanel.setEmployeeId(ClientUtil.getEmployeeId());
			cpPanel.commonQuery();
		}else{
			emPanel.hide();
			cpPanel.setEmployeeId(ClientUtil.getEmployeeId());
			cpPanel.commonQuery();
		}
		emPanel.setCpPanel(cpPanel);
		HLayout mainLayout = new HLayout();
		mainLayout.setHeight100();
		mainLayout.setWidth100();
		emPanel.setWidth("50%");
		emPanel.setHeight100();
		
		cpPanel.setWidth("50%");
		cpPanel.setHeight100();
		mainLayout.addMember(emPanel);
		mainLayout.addMember(cpPanel);
		return mainLayout;
	}

	public static class Factory implements PanelFactory {

		private String id;

		@Override
		public Canvas create() {
			EmployeeCapitalsPanel cm = new EmployeeCapitalsPanel();
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

