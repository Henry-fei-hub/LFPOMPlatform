package com.pomplatform.client.salaryexceptions.form;

import com.delicacy.client.ui.WorkflowProcessor;
import com.delicacy.client.ui.AbstractProcessPanel;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.delicacy.client.ui.AbstractPrint;

public class OnSalaryExceptionsWorkflowProcessor implements WorkflowProcessor {
	@Override
	public AbstractProcessPanel getNewCreatePanel() {
		return new NewOnSalaryExceptionsWorkflow();
	}

	@Override
	public AbstractProcessPanel getProcessPanel(String processName) {
		//审批，修改
		return new UpdateOnSalaryExceptionsWorkflow();
	}

	@Override
	public AbstractDetailViewer getViewPanel(String processName, Integer processType) {
		//查看详情
		return new OnSalaryExceptionsViewer();
	}

	@Override
	public AbstractPrint getPrintProcessor() {
		return new OnSalaryExceptionsPrintProcessor();
	}

}
