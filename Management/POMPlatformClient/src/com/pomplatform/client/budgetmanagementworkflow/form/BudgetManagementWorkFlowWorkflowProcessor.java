package com.pomplatform.client.budgetmanagementworkflow.form;

import com.delicacy.client.ui.WorkflowProcessor;
import com.delicacy.client.ui.AbstractProcessPanel;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.delicacy.client.ui.AbstractPrint;

public class BudgetManagementWorkFlowWorkflowProcessor implements WorkflowProcessor {
	@Override
	public AbstractProcessPanel getNewCreatePanel() {
		return new NewBudgetManagementWorkFlowWorkflow();
	}

	@Override
	public AbstractProcessPanel getProcessPanel(String processName) {
		return new UpdateBudgetManagementWorkFlowWorkflow();
	}

	@Override
	public AbstractDetailViewer getViewPanel(String processName, Integer processType) {
		return new BudgetManagementWorkFlowViewer();
	}

	@Override
	public AbstractPrint getPrintProcessor() {
		return new BudgetManagementWorkFlowPrintProcessor();
	}

}
