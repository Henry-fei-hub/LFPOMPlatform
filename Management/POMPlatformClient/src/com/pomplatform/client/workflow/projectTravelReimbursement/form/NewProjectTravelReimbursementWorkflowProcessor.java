package com.pomplatform.client.workflow.projectTravelReimbursement.form;

import java.util.logging.Logger;

import com.delicacy.client.ui.AbstractDetailViewer;
import com.delicacy.client.ui.AbstractPrint;
import com.delicacy.client.ui.AbstractProcessPanel;
import com.delicacy.client.ui.WorkflowProcessor;
import com.pomplatform.client.workflow.projectTravelReimbursement.panel.NewProjectTravelReimbursementPrintPanel;

public class NewProjectTravelReimbursementWorkflowProcessor implements WorkflowProcessor {
	private static final Logger logger = Logger.getLogger("");
	@Override
	public AbstractProcessPanel getNewCreatePanel() {
		return new NewNewProjectTravelReimbursementWorkflow();
	}

	@Override
	public AbstractProcessPanel getProcessPanel(String processName) {
		UpdateNewProjectTravelReimbursementWorkflow panel = new UpdateNewProjectTravelReimbursementWorkflow();
		panel.setProcessName(processName);
		return panel;
	}

	@Override
	public AbstractDetailViewer getViewPanel(String processName, Integer processType) {
		NewProjectTravelReimbursementViewer panel = new NewProjectTravelReimbursementViewer();
		panel.setProcessName(processName);
		panel.setProcessType(processType);
		return panel;
	}

	@Override
	public AbstractPrint getPrintProcessor() {
		return new NewProjectTravelReimbursementPrintPanel();
	}

}
