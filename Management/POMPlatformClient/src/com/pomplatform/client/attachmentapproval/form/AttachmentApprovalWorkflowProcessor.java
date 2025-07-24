package com.pomplatform.client.attachmentapproval.form;

import com.delicacy.client.ui.WorkflowProcessor;
import com.delicacy.client.ui.AbstractProcessPanel;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.delicacy.client.ui.AbstractPrint;

public class AttachmentApprovalWorkflowProcessor implements WorkflowProcessor {
	@Override
	public AbstractProcessPanel getNewCreatePanel() {
		return new NewAttachmentApprovalWorkflow();
	}

	@Override
	public AbstractProcessPanel getProcessPanel(String processName) {
		return new UpdateAttachmentApprovalWorkflow();
	}

	@Override
	public AbstractDetailViewer getViewPanel(String processName, Integer processType) {
		return new AttachmentApprovalViewer();
	}

	@Override
	public AbstractPrint getPrintProcessor() {
		return new AttachmentApprovalPrintProcessor();
	}

}
