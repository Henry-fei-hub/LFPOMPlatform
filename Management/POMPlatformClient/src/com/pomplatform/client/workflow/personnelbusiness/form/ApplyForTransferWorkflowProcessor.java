package com.pomplatform.client.workflow.personnelbusiness.form;

import com.delicacy.client.ui.AbstractDetailViewer;
import com.delicacy.client.ui.AbstractPrint;
import com.delicacy.client.ui.AbstractProcessPanel;
import com.delicacy.client.ui.WorkflowProcessor;

public class ApplyForTransferWorkflowProcessor implements WorkflowProcessor {
	@Override
	public AbstractProcessPanel getNewCreatePanel() {
		NewApplyForTransferWorkflow panel = new NewApplyForTransferWorkflow();
		return panel;
	}

	@Override
	public AbstractProcessPanel getProcessPanel(String processName) {
		UpdateApplyForTransferWorkflow panel = new UpdateApplyForTransferWorkflow();
		panel.setProcessName(null == processName ? "" : processName);
		return panel;
	}

	@Override
	public AbstractDetailViewer getViewPanel(String processName, Integer processType) {
		ApplyForTransferViewer view = new ApplyForTransferViewer();
		view.setProcessName(null == processName ? "" : processName);
		return view;
	}

	@Override
	public AbstractPrint getPrintProcessor() {
		// TODO Auto-generated method stub
		return null;
	}

}
