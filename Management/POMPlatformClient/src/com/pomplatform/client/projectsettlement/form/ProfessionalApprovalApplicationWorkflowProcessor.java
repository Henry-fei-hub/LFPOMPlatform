package com.pomplatform.client.projectsettlement.form;

import com.delicacy.client.ui.WorkflowProcessor;
import com.delicacy.client.ui.AbstractProcessPanel;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.delicacy.client.ui.AbstractPrint;

public class ProfessionalApprovalApplicationWorkflowProcessor implements WorkflowProcessor {
	@Override
	public AbstractProcessPanel getNewCreatePanel() {
		return new NewProfessionalApprovalApplicationWorkflow();
	}

	@Override
	public AbstractProcessPanel getProcessPanel(String processName) {
		return new UpdateProfessionalApprovalApplicationWorkflow();
	}

	@Override
	public AbstractDetailViewer getViewPanel(String processName, Integer processType) {
		return new ProfessionalApprovalApplicationViewer();
	}

	@Override
	public AbstractPrint getPrintProcessor() {
		return new ProfessionalApprovalApplicationPrintProcessor();
	}

}
