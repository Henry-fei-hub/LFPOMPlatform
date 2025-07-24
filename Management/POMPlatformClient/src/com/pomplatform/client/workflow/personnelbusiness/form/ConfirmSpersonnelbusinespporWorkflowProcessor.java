package com.pomplatform.client.workflow.personnelbusiness.form;

import com.delicacy.client.ui.AbstractDetailViewer;
import com.delicacy.client.ui.AbstractPrint;
import com.delicacy.client.ui.AbstractProcessPanel;
import com.delicacy.client.ui.WorkflowProcessor;

public class ConfirmSpersonnelbusinespporWorkflowProcessor implements WorkflowProcessor {
	@Override
	public AbstractProcessPanel getNewCreatePanel() {
		DelayNewSpersonnelbusinespporWorkflow panel = new DelayNewSpersonnelbusinespporWorkflow();
		panel.setProcessType(23);
		return panel;
	}

	@Override
	public AbstractProcessPanel getProcessPanel(String processName) {
		DelayUpdateSpersonnelbusinespporWorkflow panel = new DelayUpdateSpersonnelbusinespporWorkflow();
		panel.setProcessType(23);
		panel.setProcessName(null == processName ? "" : processName);
		return panel;
	}

	@Override
	public AbstractDetailViewer getViewPanel(String processName, Integer processType) {
		DelaySpersonnelbusinespporViewer panel = new DelaySpersonnelbusinespporViewer();
		panel.setProcessType(processType);
		return panel;
	}

	@Override
	public AbstractPrint getPrintProcessor() {
		// TODO Auto-generated method stub
		return null;
	}

}
