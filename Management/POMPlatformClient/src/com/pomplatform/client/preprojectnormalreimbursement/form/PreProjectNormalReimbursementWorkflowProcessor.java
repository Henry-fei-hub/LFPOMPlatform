package com.pomplatform.client.preprojectnormalreimbursement.form;

import com.delicacy.client.ui.WorkflowProcessor;
import com.pomplatform.client.workflow.panel.NormalReimbursementsPrintPanel;
import com.delicacy.client.ui.AbstractProcessPanel;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.delicacy.client.ui.AbstractPrint;

public class PreProjectNormalReimbursementWorkflowProcessor implements WorkflowProcessor {
	@Override
	public AbstractProcessPanel getNewCreatePanel() {
		return new NewPreProjectNormalReimbursementWorkflow();
	}

	@Override
	public AbstractProcessPanel getProcessPanel(String processName) {
		UpdatePreProjectNormalReimbursementWorkflow panel = new UpdatePreProjectNormalReimbursementWorkflow();
		panel.setProcessName(processName);
		return panel;
	}

	@Override
	public AbstractDetailViewer getViewPanel(String processName, Integer processType) {
		PreProjectNormalReimbursementViewer panel = new PreProjectNormalReimbursementViewer();
		panel.setProcessName(processName);
		panel.setProcessType(processType);
		return panel;
	}

	@Override
	public AbstractPrint getPrintProcessor() {
		return new NormalReimbursementsPrintPanel();
	}

}
