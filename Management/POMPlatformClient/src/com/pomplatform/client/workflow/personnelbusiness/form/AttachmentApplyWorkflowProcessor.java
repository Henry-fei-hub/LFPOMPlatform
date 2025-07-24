package com.pomplatform.client.workflow.personnelbusiness.form;

import com.delicacy.client.ui.AbstractDetailViewer;
import com.delicacy.client.ui.AbstractPrint;
import com.delicacy.client.ui.AbstractProcessPanel;
import com.delicacy.client.ui.WorkflowProcessor;

public class AttachmentApplyWorkflowProcessor implements WorkflowProcessor {
	@Override
	public AbstractProcessPanel getNewCreatePanel() {
		NewAttachmentApplyWorkflow panel = new NewAttachmentApplyWorkflow();
		panel.setProcessType(27);
		return panel;
	}

	@Override
	public AbstractProcessPanel getProcessPanel(String processName) {
		UpdateAttachmentApplyWorkflow panel = new UpdateAttachmentApplyWorkflow();
		panel.setProcessName(null == processName ? "" : processName);
		panel.setProcessType(27);
		return panel;
	}

	@Override
	public AbstractDetailViewer getViewPanel(String processName, Integer processType) {
		return new AttachmentApplyViewer();
	}

	@Override
	public AbstractPrint getPrintProcessor() {
		return null;
	}

}
