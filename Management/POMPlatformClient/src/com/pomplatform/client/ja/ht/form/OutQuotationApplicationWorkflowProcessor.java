package com.pomplatform.client.ja.ht.form;

import com.delicacy.client.ui.WorkflowProcessor;
import com.delicacy.client.ui.AbstractProcessPanel;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.delicacy.client.ui.AbstractPrint;

public class OutQuotationApplicationWorkflowProcessor implements WorkflowProcessor {
	@Override
	public AbstractProcessPanel getNewCreatePanel() {
		return new NewOutQuotationApplicationWorkflow();
	}

	@Override
	public AbstractProcessPanel getProcessPanel(String processName) {
		return new UpdateOutQuotationApplicationWorkflow();
	}

	@Override
	public AbstractDetailViewer getViewPanel(String processName, Integer processType) {
		return new OutQuotationApplicationViewer();
	}

	@Override
	public AbstractPrint getPrintProcessor() {
		return new OutQuotationApplicationPrintProcessor();
	}

}
