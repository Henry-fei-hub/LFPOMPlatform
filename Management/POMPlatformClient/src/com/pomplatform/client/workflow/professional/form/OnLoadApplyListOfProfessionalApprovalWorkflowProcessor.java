package com.pomplatform.client.workflow.professional.form;

import com.delicacy.client.ui.WorkflowProcessor;
import com.delicacy.client.ui.AbstractProcessPanel;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.delicacy.client.ui.AbstractPrint;

public class OnLoadApplyListOfProfessionalApprovalWorkflowProcessor implements WorkflowProcessor {
	@Override
	public AbstractProcessPanel getNewCreatePanel() {
		return new NewOnLoadApplyListOfProfessionalApprovalWorkflow();
	}

	@Override
	public AbstractProcessPanel getProcessPanel(String processName) {
		return new UpdateOnLoadApplyListOfProfessionalApprovalWorkflow();
	}

	@Override
	public AbstractDetailViewer getViewPanel(String processName, Integer processType) {
		return new OnLoadApplyListOfProfessionalApprovalViewer();
	}

	@Override
	public AbstractPrint getPrintProcessor() {
		return new OnLoadApplyListOfProfessionalApprovalPrintProcessor();
	}

}
