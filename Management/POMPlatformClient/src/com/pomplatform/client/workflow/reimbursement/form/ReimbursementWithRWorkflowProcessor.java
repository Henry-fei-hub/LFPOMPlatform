package com.pomplatform.client.workflow.reimbursement.form;

import com.delicacy.client.ui.WorkflowProcessor;
import com.delicacy.client.ui.AbstractProcessPanel;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.delicacy.client.ui.AbstractPrint;

public class ReimbursementWithRWorkflowProcessor implements WorkflowProcessor {

    @Override
    public AbstractProcessPanel getNewCreatePanel() {
        return new NewReimbursementWithRWorkflow();
    }

    @Override
    public AbstractProcessPanel getProcessPanel(String processName) {
        return new UpdateReimbursementWithRWorkflow();
    }

    @Override
    public AbstractDetailViewer getViewPanel(String processName, Integer processType) {
        return new ReimbursementWithRViewer();
    }

	@Override
	public AbstractPrint getPrintProcessor() {
		// TODO Auto-generated method stub
		return null;
	}

}
