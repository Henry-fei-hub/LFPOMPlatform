package com.pomplatform.client.workflow.form;

import com.delicacy.client.ui.WorkflowProcessor;
import com.pomplatform.client.workflow.panel.EmployeeMoneyPrintPanel;
import com.smartgwt.client.util.SC;
import com.delicacy.client.ui.AbstractProcessPanel;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.delicacy.client.ui.AbstractPrint;

public class EmployeeBorrowMoneyByWorkflowWorkflowProcessor implements WorkflowProcessor {
	@Override
	public AbstractProcessPanel getNewCreatePanel() {
		NewEmployeeBorrowMoneyByWorkflowWorkflow panel = new NewEmployeeBorrowMoneyByWorkflowWorkflow();
		panel.setCustomWidth("90%");
		panel.setCustomHeight("60%");
		return panel;
	}

	@Override
	public AbstractProcessPanel getProcessPanel(String processName) {
		UpdateEmployeeBorrowMoneyByWorkflowWorkflow panel = new UpdateEmployeeBorrowMoneyByWorkflowWorkflow();
		panel.setProcessName(processName);
		panel.setCustomWidth("90%");
		panel.setCustomHeight("70%");
		return panel;
	}

	@Override
	public AbstractDetailViewer getViewPanel(String processName, Integer processType) {
		EmployeeBorrowMoneyByWorkflowViewer panel = new EmployeeBorrowMoneyByWorkflowViewer();
		panel.setProcessName(processName);
		panel.setProcessType(processType);
		return panel;
	}

	@Override
	public AbstractPrint getPrintProcessor() {
		return new EmployeeMoneyPrintPanel();
	}

}
