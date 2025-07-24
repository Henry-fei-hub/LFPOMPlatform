package com.pomplatform.client.workflow.form;

import com.delicacy.client.ui.WorkflowProcessor;
import com.delicacy.client.ui.AbstractProcessPanel;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.delicacy.client.ui.AbstractPrint;

public class ProjectEmployeeProcessApplicationWorkflowProcessor implements WorkflowProcessor {
	@Override
	public AbstractProcessPanel getNewCreatePanel() {
		return new NewProjectEmployeeProcessApplicationWorkflow();
	}

	@Override
	public AbstractProcessPanel getProcessPanel(String processName) {
		return new UpdateProjectEmployeeProcessApplicationWorkflow();
	}

	@Override
	public AbstractDetailViewer getViewPanel(String processName, Integer processType) {
		return new ProjectEmployeeProcessApplicationViewer();
	}

	@Override
	public AbstractPrint getPrintProcessor() {
		return new ProjectEmployeeProcessApplicationPrintProcessor();
	}

}
