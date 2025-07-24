package com.pomplatform.client.workflow.contractstatus.form;

import com.delicacy.client.ui.AbstractDetailViewer;
import com.delicacy.client.ui.AbstractPrint;
import com.delicacy.client.ui.AbstractProcessPanel;
import com.delicacy.client.ui.WorkflowProcessor;
import com.pomplatform.client.workflow.panel.MyCostAllocationDesignPanel;

public class ContractStatusWorkflowProcessor implements WorkflowProcessor {
	@Override
	public AbstractProcessPanel getNewCreatePanel() {
		NewContractStatusWorkflow panel = new NewContractStatusWorkflow();
		return panel;
	}

	@Override
	public AbstractProcessPanel getProcessPanel(String processName) {
		UpdateContractStatusWorkflow panel = new UpdateContractStatusWorkflow();
		panel.setProcessName(processName);
		return panel;
	}

	@Override
	public AbstractDetailViewer getViewPanel(String processName, Integer processType) {
		return new ContractStatusViewer();
	}

	@Override
	public AbstractPrint getPrintProcessor() {
		return new ContractStatusPrintProcessor();
	}

}
