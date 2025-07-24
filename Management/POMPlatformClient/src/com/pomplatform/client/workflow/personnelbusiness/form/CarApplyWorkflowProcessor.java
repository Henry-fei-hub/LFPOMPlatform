package com.pomplatform.client.workflow.personnelbusiness.form;

import com.delicacy.client.ui.WorkflowProcessor;
import com.delicacy.client.ui.AbstractProcessPanel;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.delicacy.client.ui.AbstractPrint;

public class CarApplyWorkflowProcessor implements WorkflowProcessor {
	@Override
	public AbstractProcessPanel getNewCreatePanel() {
		return new NewCarApplyWorkflow();
	}

	@Override
	public AbstractProcessPanel getProcessPanel(String processName) {
		UpdateCarApplyWorkflow panel = new UpdateCarApplyWorkflow();
		panel.setProcessName(processName);
		return panel;
	}

	@Override
	public AbstractDetailViewer getViewPanel(String processName, Integer processType) {
		return new CarApplyViewer();
	}

	@Override
	public AbstractPrint getPrintProcessor() {
		return null;
	}
}
