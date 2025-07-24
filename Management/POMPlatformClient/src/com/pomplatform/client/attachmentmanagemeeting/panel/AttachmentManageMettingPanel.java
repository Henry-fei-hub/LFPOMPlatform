package com.pomplatform.client.attachmentmanagemeeting.panel;

import java.util.logging.Logger;

import com.delicacy.client.DelicacyPanel;
import com.delicacy.client.PanelFactory;
import com.pomplatform.client.attachment.panel.ViewContractAttachmentDetailPanel;
import com.pomplatform.client.memployeeaaccadpppccor.panel.MemployeeaaccadpppccorPanel;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.layout.HLayout;

public class AttachmentManageMettingPanel extends DelicacyPanel {

	private static Logger __logger = Logger.getLogger("");
	
	
	private AttachmentManageMeetingTorPanel leftPanel;
	
	private RightAttachmentManageMeetingTorPanel rightPanel ;

	@Override
	public Canvas getViewPanel() {
		rightPanel = new RightAttachmentManageMeetingTorPanel();
		leftPanel = new AttachmentManageMeetingTorPanel();
		leftPanel.setRightPanel(rightPanel);
		HLayout mainLayout = new HLayout();
		mainLayout.setHeight100();
		mainLayout.setWidth100();
		leftPanel.setWidth("70%");
		leftPanel.setHeight100();
		
		rightPanel.setWidth("30%");
		rightPanel.setHeight100();
		mainLayout.addMember(leftPanel);
		mainLayout.addMember(rightPanel);
		return mainLayout;
	}

	public static class Factory implements PanelFactory {

		private String id;

		@Override
		public Canvas create() {
			AttachmentManageMettingPanel cm = new AttachmentManageMettingPanel();
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

