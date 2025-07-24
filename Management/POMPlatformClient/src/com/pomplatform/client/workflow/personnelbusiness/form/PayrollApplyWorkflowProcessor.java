package com.pomplatform.client.workflow.personnelbusiness.form;

import com.delicacy.client.ui.AbstractDetailViewer;
import com.delicacy.client.ui.AbstractPrint;
import com.delicacy.client.ui.AbstractProcessPanel;
import com.delicacy.client.ui.WorkflowProcessor;

public class PayrollApplyWorkflowProcessor implements WorkflowProcessor {
	@Override
	public AbstractProcessPanel getNewCreatePanel() {
		NewPayrollApplyWorkflow panel = new NewPayrollApplyWorkflow();
		return panel;
	}

	@Override
	public AbstractProcessPanel getProcessPanel(String processName) {
		UpdatePayrollApplyWorkflow panel = new UpdatePayrollApplyWorkflow();
		panel.setProcessName(null == processName ? "" : processName);
		return panel;
	}

	@Override
	public AbstractDetailViewer getViewPanel(String processName, Integer processType) {
		PayrollApplyViewer panel = new PayrollApplyViewer();
		panel.setProcessName(processName);
		return panel;
	}

	@Override
	public AbstractPrint getPrintProcessor() {
		return null;
	}

}
