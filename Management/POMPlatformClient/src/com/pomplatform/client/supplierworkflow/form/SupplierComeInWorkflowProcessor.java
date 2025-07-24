package com.pomplatform.client.supplierworkflow.form;

import com.delicacy.client.ui.AbstractDetailViewer;
import com.delicacy.client.ui.AbstractPrint;
import com.delicacy.client.ui.AbstractProcessPanel;
import com.delicacy.client.ui.WorkflowProcessor;
import com.pomplatform.client.onsupplierinfo.form.OnSupplierInfoViewer;
import com.smartgwt.client.util.SC;

public class SupplierComeInWorkflowProcessor implements WorkflowProcessor {
	@Override
	public AbstractProcessPanel getNewCreatePanel() {
		return new NewSupplierComeInWorkflow();
	}

	@Override
	public AbstractProcessPanel getProcessPanel(String processName) {
		return new UpdateSupplierComeInWorkflow();
	}

	@Override
	public AbstractDetailViewer getViewPanel(String processName, Integer processType) {
		return new SupplierComeInViewer();
	}

	@Override
	public AbstractPrint getPrintProcessor() {
		return new SupplierComeInPrintProcessor();
	}

}
