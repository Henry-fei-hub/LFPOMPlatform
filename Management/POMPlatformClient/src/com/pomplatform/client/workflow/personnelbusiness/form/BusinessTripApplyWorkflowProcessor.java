package com.pomplatform.client.workflow.personnelbusiness.form;

import com.delicacy.client.ui.AbstractDetailViewer;
import com.delicacy.client.ui.AbstractPrint;
import com.delicacy.client.ui.AbstractProcessPanel;
import com.delicacy.client.ui.WorkflowProcessor;

public class BusinessTripApplyWorkflowProcessor implements WorkflowProcessor {
	@Override
	public AbstractProcessPanel getNewCreatePanel() {
		NewBusinessTripApplyWorkflow panel = new NewBusinessTripApplyWorkflow();
		panel.setProcessType(14);
		return panel;
	}

	@Override
	public AbstractProcessPanel getProcessPanel(String processName) {
		UpdateBusinessTripApplyWorkflow panel = new UpdateBusinessTripApplyWorkflow();
		panel.setProcessType(14);
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
