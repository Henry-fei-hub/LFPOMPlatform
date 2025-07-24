package com.pomplatform.client.workflow.form;

import com.delicacy.client.ui.AbstractDetailViewer;
import com.delicacy.client.ui.AbstractPrint;
import com.delicacy.client.ui.AbstractProcessPanel;
import com.delicacy.client.ui.WorkflowProcessor;
import com.pomplatform.client.workflow.panel.PayMoneyPrintPanel;
import com.smartgwt.client.util.SC;

public class PayMoneyManageOfWorkflowWorkflowProcessor implements WorkflowProcessor {
	@Override
	public AbstractProcessPanel getNewCreatePanel() {
		NewPayMoneyManageOfWorkflowWorkflow panel = new NewPayMoneyManageOfWorkflowWorkflow();
		panel.setCustomHeight("90%");
		panel.setCustomWidth("90%");
		return panel;
	}

	@Override
	public AbstractProcessPanel getProcessPanel(String processName) {
		UpdatePayMoneyManageOfWorkflowWorkflow panel = new UpdatePayMoneyManageOfWorkflowWorkflow();
		panel.setProcessName(processName);
		panel.setCustomHeight("90%");
		panel.setCustomWidth("90%");
		return panel;
	}

	@Override
	public AbstractDetailViewer getViewPanel(String processName, Integer processType) {
		PayMoneyManageOfWorkflowViewer panel = new PayMoneyManageOfWorkflowViewer();
		panel.setProcessName(processName);
		panel.setProcessType(processType);
		return panel;
	}

	@Override
	public AbstractPrint getPrintProcessor() {
		return new PayMoneyPrintPanel();
	}

}
