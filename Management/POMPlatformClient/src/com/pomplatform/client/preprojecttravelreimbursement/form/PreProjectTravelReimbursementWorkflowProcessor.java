package com.pomplatform.client.preprojecttravelreimbursement.form;

import com.delicacy.client.ui.AbstractDetailViewer;
import com.delicacy.client.ui.AbstractPrint;
import com.delicacy.client.ui.AbstractProcessPanel;
import com.delicacy.client.ui.WorkflowProcessor;
import com.pomplatform.client.workflow.panel.TravelReimbursementsPrePrintPanel;

public class PreProjectTravelReimbursementWorkflowProcessor implements WorkflowProcessor {
	@Override
	public AbstractProcessPanel getNewCreatePanel() {
		return new NewPreProjectTravelReimbursementWorkflow();
	}

	@Override
	public AbstractProcessPanel getProcessPanel(String processName) {
		UpdatePreProjectTravelReimbursementWorkflow panel = new UpdatePreProjectTravelReimbursementWorkflow();
		panel.setProcessName(processName);
		return panel;
	}

	@Override
	public AbstractDetailViewer getViewPanel(String processName, Integer processType) {
		PreProjectTravelReimbursementViewer panel = new PreProjectTravelReimbursementViewer();
		panel.setProcessName(processName);
		panel.setProcessType(processType);
		return panel;
	}

	@Override
	public AbstractPrint getPrintProcessor() {
		return new TravelReimbursementsPrePrintPanel();
	}

}
