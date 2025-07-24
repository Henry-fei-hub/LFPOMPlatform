package com.pomplatform.client.preprojects.form;

import com.delicacy.client.ui.WorkflowProcessor;
import com.delicacy.client.ui.AbstractProcessPanel;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.delicacy.client.ui.AbstractPrint;

public class CloseProjectApplyWorkflowProcessor implements WorkflowProcessor {
	@Override
	public AbstractProcessPanel getNewCreatePanel() {
		return new NewCloseProjectApplyWorkflow();
	}

	@Override
	public AbstractProcessPanel getProcessPanel(String processName) {
		return new UpdateCloseProjectApplyWorkflow();
	}

	@Override
	public AbstractDetailViewer getViewPanel(String processName, Integer processType) {
//		return new CloseProjectApplyViewer();
		return new BeAndCloseProjectViewer();
	}

	@Override
	public AbstractPrint getPrintProcessor() {
//		return new CloseProjectApplyPrintProcessor();
		return null;
	}

}
