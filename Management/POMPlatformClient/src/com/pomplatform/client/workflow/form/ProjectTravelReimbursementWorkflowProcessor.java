package com.pomplatform.client.workflow.form;

import com.delicacy.client.ui.WorkflowProcessor;
import com.delicacy.client.ui.AbstractProcessPanel;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.delicacy.client.ui.AbstractPrint;

public class ProjectTravelReimbursementWorkflowProcessor implements WorkflowProcessor {
	@Override
	public AbstractProcessPanel getNewCreatePanel() {
		return new NewProjectTravelReimbursementWorkflow();
	}

	@Override
	public AbstractProcessPanel getProcessPanel(String processName) {
		return new UpdateProjectTravelReimbursementWorkflow();
	}

	@Override
	public AbstractDetailViewer getViewPanel(String processName, Integer processType) {
		return new ProjectTravelReimbursementViewer();
	}

	@Override
	public AbstractPrint getPrintProcessor() {
		// TODO Auto-generated method stub
		return null;
	}

}
