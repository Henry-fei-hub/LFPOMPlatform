package com.pomplatform.client.workflow.personnelbusiness.form;

import com.delicacy.client.ui.AbstractDetailViewer;
import com.delicacy.client.ui.AbstractPrint;
import com.delicacy.client.ui.AbstractProcessPanel;
import com.delicacy.client.ui.WorkflowProcessor;

public class NetworkPrivilegesWorkflowProcessor implements WorkflowProcessor {
	@Override
	public AbstractProcessPanel getNewCreatePanel() {
		return new NetworkPrivilegesWorkflow();
	}

	@Override
	public AbstractProcessPanel getProcessPanel(String processName) {
		return new UpdateNetworkPrivilegesWorkflow();
	}

	@Override
	public AbstractDetailViewer getViewPanel(String processName, Integer processType) {
		return new NetworkPrivilegesViewer();
	}

	@Override
	public AbstractPrint getPrintProcessor() {
		return null;
	}
}
