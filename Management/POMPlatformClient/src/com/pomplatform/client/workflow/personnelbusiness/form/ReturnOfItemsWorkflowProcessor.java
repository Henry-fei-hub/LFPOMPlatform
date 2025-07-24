package com.pomplatform.client.workflow.personnelbusiness.form;

import com.delicacy.client.ui.WorkflowProcessor;
import com.delicacy.client.ui.AbstractProcessPanel;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.delicacy.client.ui.AbstractPrint;

public class ReturnOfItemsWorkflowProcessor implements WorkflowProcessor {
	@Override
	public AbstractProcessPanel getNewCreatePanel() {
		return new NewReturnOfItemsWorkflow();
	}

	@Override
	public AbstractProcessPanel getProcessPanel(String processName) {
		return new UpdateReturnOfItemsWorkflow();
	}

	@Override
	public AbstractDetailViewer getViewPanel(String processName, Integer processType) {
		return new ReturnOfItemsViewer();
	}

	@Override
	public AbstractPrint getPrintProcessor() {
		return new ReturnOfItemsPrintProcessor();
	}

}
