package com.pomplatform.client.workflow.personnelbusiness.form;

import com.delicacy.client.ui.AbstractDetailViewer;
import com.delicacy.client.ui.AbstractPrint;
import com.delicacy.client.ui.AbstractProcessPanel;
import com.delicacy.client.ui.WorkflowProcessor;
import com.smartgwt.client.util.SC;

public class DelayBusinessTripApplyWorkflowProcessor implements WorkflowProcessor {
	@Override
	public AbstractProcessPanel getNewCreatePanel() {
		DelayNewBusinessTripApplyWorkflow panel = new DelayNewBusinessTripApplyWorkflow();
		panel.setProcessType(19);
		return panel;
	}

	@Override
	public AbstractProcessPanel getProcessPanel(String processName) {
		DelayUpdateBusinessTripApplyWorkflow panel = new DelayUpdateBusinessTripApplyWorkflow();
		panel.setProcessType(19);
		return panel;
	}

	@Override
	public AbstractDetailViewer getViewPanel(String processName, Integer processType) {
		DelayBusinessTripApplyViewer panel = new DelayBusinessTripApplyViewer();
		panel.setProcessType(processType);
		return panel;
	}

	@Override
	public AbstractPrint getPrintProcessor() {
		return null;
	}

}
