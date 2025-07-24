package com.pomplatform.client.workflow.commonNormalReimbursement.form;

import java.util.logging.Logger;

import com.delicacy.client.ui.AbstractDetailViewer;
import com.delicacy.client.ui.AbstractPrint;
import com.delicacy.client.ui.AbstractProcessPanel;
import com.delicacy.client.ui.WorkflowProcessor;
import com.pomplatform.client.workflow.commonNormalReimbursement.panel.NormalReimbursementWithDepartmentPrintPanel;

public class NormalReimbursementWithDepartmentWorkflowProcessor implements WorkflowProcessor {
	private static final Logger logger = Logger.getLogger("");
	@Override
	public AbstractProcessPanel getNewCreatePanel() {
		return new NewNormalReimbursementWithDepartmentWorkflow();
	}

	@Override
	public AbstractProcessPanel getProcessPanel(String processName) {
		UpdateNormalReimbursementWithDepartmentWorkflow panel = new UpdateNormalReimbursementWithDepartmentWorkflow();
		panel.setProcessName(processName);
		return panel;
	}

	@Override
	public AbstractDetailViewer getViewPanel(String processName, Integer processType) {
		NormalReimbursementWithDepartmentViewer panel = new NormalReimbursementWithDepartmentViewer();
		panel.setProcessName(processName);
		panel.setProcessType(processType);
		return panel;
	}
	
	@Override
	public AbstractPrint getPrintProcessor() {
		return new NormalReimbursementWithDepartmentPrintPanel();
	}

}
