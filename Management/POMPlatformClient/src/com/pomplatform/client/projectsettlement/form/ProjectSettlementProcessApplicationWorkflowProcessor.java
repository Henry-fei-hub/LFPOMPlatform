package com.pomplatform.client.projectsettlement.form;

import com.delicacy.client.ui.WorkflowProcessor;
import com.delicacy.client.ui.AbstractProcessPanel;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.delicacy.client.ui.AbstractPrint;

public class ProjectSettlementProcessApplicationWorkflowProcessor implements WorkflowProcessor {
	@Override
	public AbstractProcessPanel getNewCreatePanel() {
		return new NewProjectSettlementProcessApplicationWorkflow();
	}

	@Override
	public AbstractProcessPanel getProcessPanel(String processName) {
		return new UpdateProjectSettlementProcessApplicationWorkflow();
	}

	@Override
	public AbstractDetailViewer getViewPanel(String processName, Integer processType) {
		return new ProjectSettlementProcessApplicationViewer();
	}

	@Override
	public AbstractPrint getPrintProcessor() {
		return new ProjectSettlementProcessApplicationPrintProcessor();
	}

}
