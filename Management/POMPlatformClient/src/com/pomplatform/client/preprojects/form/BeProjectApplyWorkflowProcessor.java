package com.pomplatform.client.preprojects.form;

import com.delicacy.client.ui.WorkflowProcessor;
import com.delicacy.client.ui.AbstractProcessPanel;

import java.util.logging.Logger;

import com.delicacy.client.ui.AbstractDetailViewer;
import com.delicacy.client.ui.AbstractPrint;

public class BeProjectApplyWorkflowProcessor implements WorkflowProcessor {
	private static final Logger __logger = Logger.getLogger("");
	
	@Override
	public AbstractProcessPanel getNewCreatePanel() {
		return new NewBeProjectApplyWorkflow();
	}

	@Override
	public AbstractProcessPanel getProcessPanel(String processName) {
		return new UpdateBeProjectApplyWorkflow();
	}

	@Override
	public AbstractDetailViewer getViewPanel(String processName, Integer processType) {
//		return new BeProjectApplyViewer();
		return new BeAndCloseProjectViewer();
	}

	@Override
	public AbstractPrint getPrintProcessor() {
//		return new BeProjectApplyPrintProcessor();
		return null;
	}

}
