package com.pomplatform.client.workflow.personnelbusiness.form;

import com.delicacy.client.ui.WorkflowProcessor;
import com.delicacy.client.ui.AbstractProcessPanel;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.delicacy.client.ui.AbstractPrint;

/**
 * 请假流程方法
 */
public class LeaveApplyWorkflowProcessor implements WorkflowProcessor {
	@Override
	public AbstractProcessPanel getNewCreatePanel() {
		return new NewLeaveApplyWorkflow();
	}

	@Override
	public AbstractProcessPanel getProcessPanel(String processName) {
		return new UpdateLeaveApplyWorkflow();
	}

	@Override
	public AbstractDetailViewer getViewPanel(String processName, Integer processType) {
		return new LeaveApplyViewer();
	}
	
	@Override
	public AbstractPrint getPrintProcessor() {
		return null;
	}

}
