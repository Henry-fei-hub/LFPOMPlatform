package com.pomplatform.client.projectstageauditinfo.form;

import com.delicacy.client.ui.WorkflowProcessor;
import com.delicacy.client.ui.AbstractProcessPanel;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.delicacy.client.ui.AbstractPrint;

public class ProjectStageAuditInfoWorkflowProcessor implements WorkflowProcessor {
	@Override
	public AbstractProcessPanel getNewCreatePanel() {
		return new NewProjectStageAuditInfoWorkflow();
	}

	@Override
	public AbstractProcessPanel getProcessPanel(String processName) {
		return new UpdateProjectStageAuditInfoWorkflow();
	}

	@Override
	public AbstractDetailViewer getViewPanel(String processName, Integer processType) {
		return new ProjectStageAuditInfoViewer();
	}

	@Override
	public AbstractPrint getPrintProcessor() {
		return new ProjectStageAuditInfoPrintProcessor();
	}

}
