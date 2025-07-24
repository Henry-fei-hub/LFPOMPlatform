package com.pomplatform.client.workflow.personnelbusiness.form;

import com.delicacy.client.ui.AbstractDetailViewer;
import com.delicacy.client.ui.AbstractPrint;
import com.delicacy.client.ui.AbstractProcessPanel;
import com.delicacy.client.ui.WorkflowProcessor;

public class ReceiveUnitRepaymentWorkflowProcessor implements WorkflowProcessor {
	@Override
	public AbstractProcessPanel getNewCreatePanel() {
		NewReceiveUnitRepaymentWorkflow panel = new NewReceiveUnitRepaymentWorkflow();
		panel.setCustomWidth("60%");
		panel.setCustomHeight("65%");
		return panel;
	}

	@Override
	public AbstractProcessPanel getProcessPanel(String processName) {
		UpdateReceiveUnitRepaymentWorkflow panel = new UpdateReceiveUnitRepaymentWorkflow();
		panel.setCustomWidth("60%");
		panel.setCustomHeight("80%");
		panel.setProcessName(null == processName ? "" : processName);
		return panel;
	}

	@Override
	public AbstractDetailViewer getViewPanel(String processName, Integer processType) {
		return new ReceiveUnitRepaymentViewer();
	}

	@Override
	public AbstractPrint getPrintProcessor() {
		return null;
	}

}
