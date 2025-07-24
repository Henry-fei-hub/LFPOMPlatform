package com.pomplatform.client.workflow.companyCommonNormalReimbursement.form;

import com.delicacy.client.ui.WorkflowProcessor;
import com.pomplatform.client.workflow.companyCommonNormalReimbursement.panel.CompanyNormalReimbursementPrintPanel;
import com.delicacy.client.ui.AbstractProcessPanel;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.delicacy.client.ui.AbstractPrint;

public class CompanyNormalReimbursementWorkflowProcessor implements WorkflowProcessor {
	@Override
	public AbstractProcessPanel getNewCreatePanel() {
		return new NewCompanyNormalReimbursementWorkflow();
	}

	@Override
	public AbstractProcessPanel getProcessPanel(String processName) {
		UpdateCompanyNormalReimbursementWorkflow panel = new UpdateCompanyNormalReimbursementWorkflow();
		panel.setProcessName(processName);
		return panel;
	}

	@Override
	public AbstractDetailViewer getViewPanel(String processName, Integer processType) {
		CompanyNormalReimbursementViewer panel = new CompanyNormalReimbursementViewer();
		panel.setProcessType(processType);
		panel.setProcessName(processName);
		return panel;
	}

	@Override
	public AbstractPrint getPrintProcessor() {
		return new CompanyNormalReimbursementPrintPanel();
	}

}
