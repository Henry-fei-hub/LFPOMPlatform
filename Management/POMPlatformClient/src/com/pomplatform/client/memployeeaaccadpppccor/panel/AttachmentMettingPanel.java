package com.pomplatform.client.memployeeaaccadpppccor.panel;

import java.util.logging.Logger;

import com.delicacy.client.DelicacyPanel;
import com.delicacy.client.PanelFactory;
import com.pomplatform.client.attachment.panel.ViewContractAttachmentDetailPanel;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.layout.HLayout;

public class AttachmentMettingPanel extends DelicacyPanel {

	private static Logger __logger = Logger.getLogger("");
	
	
	private MemployeeaaccadpppccorPanel emPanel;
	
	private ViewContractAttachmentDetailPanel detailPanel ;

	@Override
	public Canvas getViewPanel() {
		detailPanel = new ViewContractAttachmentDetailPanel();
		emPanel = new MemployeeaaccadpppccorPanel();
		emPanel.setViewDetailPanel(detailPanel);
		HLayout mainLayout = new HLayout();
		mainLayout.setHeight100();
		mainLayout.setWidth100();
		emPanel.setWidth("60%");
		emPanel.setHeight100();
		
		detailPanel.setWidth("40%");
		detailPanel.setHeight100();
		mainLayout.addMember(emPanel);
		mainLayout.addMember(detailPanel);
		return mainLayout;
	}

	public static class Factory implements PanelFactory {

		private String id;

		@Override
		public Canvas create() {
			AttachmentMettingPanel cm = new AttachmentMettingPanel();
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

