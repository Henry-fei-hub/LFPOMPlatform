package com.pomplatform.client.workflow.projectNormalReimbursement.form;

import java.util.logging.Logger;

import com.delicacy.client.ui.AbstractDetailViewer;
import com.delicacy.client.ui.AbstractPrint;
import com.delicacy.client.ui.AbstractProcessPanel;
import com.delicacy.client.ui.WorkflowProcessor;
import com.pomplatform.client.workflow.projectNormalReimbursement.panel.NormalReimbursementWithProjectPrintPanel;

public class NormalReimbursementWithProjectWorkflowProcessor implements WorkflowProcessor {
	private static final Logger logger = Logger.getLogger("");
	@Override
	public AbstractProcessPanel getNewCreatePanel() {
		return new NewNormalReimbursementWithProjectWorkflow();
	}

	@Override
	public AbstractProcessPanel getProcessPanel(String processName) {
		UpdateNormalReimbursementWithProjectWorkflow panel = new UpdateNormalReimbursementWithProjectWorkflow();
		panel.setProcessName(processName);
		return panel;
	}

	@Override
	public AbstractDetailViewer getViewPanel(String processName, Integer processType) {
		NormalReimbursementWithProjectViewer panel = new NormalReimbursementWithProjectViewer();
		panel.setProcessName(processName);
		panel.setProcessType(processType);
		return panel;
	}

	@Override
	public AbstractPrint getPrintProcessor() {
		return new NormalReimbursementWithProjectPrintPanel();
	}

}
