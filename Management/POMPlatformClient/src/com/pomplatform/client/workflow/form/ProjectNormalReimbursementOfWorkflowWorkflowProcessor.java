package com.pomplatform.client.workflow.form;

import com.delicacy.client.ui.WorkflowProcessor;
import com.delicacy.client.ui.AbstractProcessPanel;

import java.util.logging.Logger;

import com.delicacy.client.ui.AbstractDetailViewer;
import com.delicacy.client.ui.AbstractPrint;

public class ProjectNormalReimbursementOfWorkflowWorkflowProcessor implements WorkflowProcessor {
	private static final Logger logger = Logger.getLogger("");
	@Override
	public AbstractProcessPanel getNewCreatePanel() {
		return new NewProjectNormalReimbursementOfWorkflowWorkflow();
	}

	@Override
	public AbstractProcessPanel getProcessPanel(String processName) {
		return new UpdateProjectNormalReimbursementOfWorkflowWorkflow();
	}

	@Override
	public AbstractDetailViewer getViewPanel(String processName, Integer processType) {
		return new ProjectNormalReimbursementOfWorkflowViewer();
	}

	@Override
	public AbstractPrint getPrintProcessor() {
		// TODO Auto-generated method stub
		return null;
	}

}
