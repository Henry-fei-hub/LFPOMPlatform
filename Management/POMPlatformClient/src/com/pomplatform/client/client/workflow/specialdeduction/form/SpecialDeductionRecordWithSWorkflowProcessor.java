package com.pomplatform.client.client.workflow.specialdeduction.form;

import com.delicacy.client.ui.WorkflowProcessor;
import com.delicacy.client.ui.AbstractProcessPanel;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.delicacy.client.ui.AbstractPrint;

public class SpecialDeductionRecordWithSWorkflowProcessor implements WorkflowProcessor {
	@Override
	public AbstractProcessPanel getNewCreatePanel() {
		return new NewSpecialDeductionRecordWithSWorkflow();
	}

	@Override
	public AbstractProcessPanel getProcessPanel(String processName) {
		return new UpdateSpecialDeductionRecordWithSWorkflow();
	}

	@Override
	public AbstractDetailViewer getViewPanel(String processName, Integer processType) {
		return new SpecialDeductionRecordWithSViewer();
	}

	@Override
	public AbstractPrint getPrintProcessor() {
		return new SpecialDeductionRecordWithSPrintProcessor();
	}

}
