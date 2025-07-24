package com.pomplatform.client.supplierworkflow.form;

import com.delicacy.client.ui.WorkflowProcessor;
import com.delicacy.client.ui.AbstractProcessPanel;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.delicacy.client.ui.AbstractPrint;

public class SupplierWorkflowWorkflowProcessor implements WorkflowProcessor {
	@Override
	public AbstractProcessPanel getNewCreatePanel() {
		return new NewSupplierWorkflowWorkflow();
	}

	@Override
	public AbstractProcessPanel getProcessPanel(String processName) {
		return new UpdateSupplierWorkflowWorkflow();
	}

	@Override
	public AbstractDetailViewer getViewPanel(String processName, Integer processType) {
		return new SupplierWorkflowViewer();
	}

	@Override
	public AbstractPrint getPrintProcessor() {
		return new SupplierWorkflowPrintProcessor();
	}

}
