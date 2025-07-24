package com.pomplatform.client.workflow.personnelbusiness.form;

import com.delicacy.client.ui.WorkflowProcessor;
import com.delicacy.client.ui.AbstractProcessPanel;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.delicacy.client.ui.AbstractPrint;

public class RegularEmployeeApplyWorkflowProcessor implements WorkflowProcessor {
	@Override
	public AbstractProcessPanel getNewCreatePanel() {
		return new NewRegularEmployeeApplyWorkflow();
	}

	@Override
	public AbstractProcessPanel getProcessPanel(String processName) {
		UpdateRegularEmployeeApplyWorkflow panel = new UpdateRegularEmployeeApplyWorkflow();
		panel.setProcessName(processName);
		return panel;
	}

	@Override
	public AbstractDetailViewer getViewPanel(String processName, Integer processType) {
		RegularEmployeeApplyViewer panel = new RegularEmployeeApplyViewer();
		panel.setProcessName(processName);
		return panel;
	}

	@Override
	public AbstractPrint getPrintProcessor() {
		return null;
	}
}
