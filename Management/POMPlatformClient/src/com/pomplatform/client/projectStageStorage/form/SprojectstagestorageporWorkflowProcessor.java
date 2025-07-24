package com.pomplatform.client.projectStageStorage.form;

import com.delicacy.client.ui.WorkflowProcessor;
import com.delicacy.client.ui.AbstractProcessPanel;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.delicacy.client.ui.AbstractPrint;

public class SprojectstagestorageporWorkflowProcessor implements WorkflowProcessor {
	@Override
	public AbstractProcessPanel getNewCreatePanel() {
		return new NewSprojectstagestorageporWorkflow();
	}

	@Override
	public AbstractProcessPanel getProcessPanel(String processName) {
		return new UpdateSprojectstagestorageporWorkflow();
	}

	public AbstractDetailViewer getViewPanel() {
		return new SprojectstagestorageporViewer();
	}

	@Override
	public AbstractPrint getPrintProcessor() {
		return new SprojectstagestorageporPrintProcessor();
	}

	@Override
	public AbstractDetailViewer getViewPanel(String processName, Integer processType) {
		// TODO Auto-generated method stub
		return null;
	}

}
