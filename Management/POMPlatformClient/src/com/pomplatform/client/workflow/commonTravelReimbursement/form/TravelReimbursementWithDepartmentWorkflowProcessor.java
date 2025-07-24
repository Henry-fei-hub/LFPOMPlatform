package com.pomplatform.client.workflow.commonTravelReimbursement.form;

import com.delicacy.client.ui.WorkflowProcessor;
import com.pomplatform.client.workflow.panel.TravelReimbursementsPrintPanel;
import com.delicacy.client.ui.AbstractProcessPanel;

import java.util.logging.Logger;

import com.delicacy.client.ui.AbstractDetailViewer;
import com.delicacy.client.ui.AbstractPrint;

public class TravelReimbursementWithDepartmentWorkflowProcessor implements WorkflowProcessor {
	private static final Logger logger = Logger.getLogger("");
	@Override
	public AbstractProcessPanel getNewCreatePanel() {
		return new NewTravelReimbursementWithDepartmentWorkflow();
	}

	@Override
	public AbstractProcessPanel getProcessPanel(String processName) {
		UpdateTravelReimbursementWithDepartmentWorkflow panel = new UpdateTravelReimbursementWithDepartmentWorkflow();
		panel.setProcessName(processName);
		return panel;
	}

	@Override
	public AbstractDetailViewer getViewPanel(String processName, Integer processType) {
		TravelReimbursementWithDepartmentViewer panel = new TravelReimbursementWithDepartmentViewer();
		panel.setProcessName(processName);
		panel.setProcessType(processType);
		return panel;
	}
	
	@Override
	public AbstractPrint getPrintProcessor() {
		return new TravelReimbursementsPrintPanel();
	}
}
