package com.pomplatform.client.client.workflow.specialdeduction.form;

import com.delicacy.client.ui.WorkflowProcessor;
import com.delicacy.client.ui.AbstractProcessPanel;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.delicacy.client.ui.AbstractPrint;

public class SpecialDeductionInformationWorkflowProcessor implements WorkflowProcessor {
	@Override
	public AbstractProcessPanel getNewCreatePanel() {
		return new NewSpecialDeductionInformationWorkflow();
	}

	@Override
	public AbstractProcessPanel getProcessPanel(String processName) {
		return new UpdateSpecialDeductionInformationWorkflow();
	}

	@Override
	public AbstractDetailViewer getViewPanel(String processName, Integer processType) {
		return new SpecialDeductionInformationViewer();
	}

	@Override
	public AbstractPrint getPrintProcessor() {
		return new SpecialDeductionInformationPrintProcessor();
	}

}
