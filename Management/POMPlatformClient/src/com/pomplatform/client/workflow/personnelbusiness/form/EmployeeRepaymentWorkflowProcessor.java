package com.pomplatform.client.workflow.personnelbusiness.form;

import com.delicacy.client.ui.AbstractDetailViewer;
import com.delicacy.client.ui.AbstractPrint;
import com.delicacy.client.ui.AbstractProcessPanel;
import com.delicacy.client.ui.WorkflowProcessor;

public class EmployeeRepaymentWorkflowProcessor implements WorkflowProcessor {
	@Override
	public AbstractProcessPanel getNewCreatePanel() {
		NewEmployeeRepaymentWorkflow panel = new NewEmployeeRepaymentWorkflow();
		panel.setCustomWidth("80%");
		panel.setCustomHeight("80%");
		return panel;
	}

	@Override
	public AbstractProcessPanel getProcessPanel(String processName) {
		UpdateEmployeeRepaymentWorkflow panel = new UpdateEmployeeRepaymentWorkflow();
		panel.setCustomWidth("60%");
		panel.setCustomHeight("80%");
		panel.setProcessName(null == processName ? "" : processName);
		return panel;
	}

	@Override
	public AbstractDetailViewer getViewPanel(String processName, Integer processType) {
		return new EmployeeRepaymentViewer();
	}

	@Override
	public AbstractPrint getPrintProcessor() {
		// TODO Auto-generated method stub
		return null;
	}

}
