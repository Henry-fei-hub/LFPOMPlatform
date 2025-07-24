package com.pomplatform.client.workflow.personnelbusiness.form;

import com.delicacy.client.ui.WorkflowProcessor;
import com.delicacy.client.ui.AbstractProcessPanel;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.delicacy.client.ui.AbstractPrint;

public class BusinessProjectTripApplyWorkflowProcessor implements WorkflowProcessor {
	@Override
	public AbstractProcessPanel getNewCreatePanel() {
		NewBusinessTripApplyWorkflow panel = new NewBusinessTripApplyWorkflow();
		panel.setProcessType(18);
		return panel;
	}

	@Override
	public AbstractProcessPanel getProcessPanel(String processName) {
		UpdateBusinessTripApplyWorkflow panel = new UpdateBusinessTripApplyWorkflow();
		panel.setProcessType(18);
		return panel;
	}

	@Override
	public AbstractDetailViewer getViewPanel(String processName, Integer processType) {
		return new BusinessTripApplyViewer();
	}

	@Override
	public AbstractPrint getPrintProcessor() {
		return null;
	}

}
