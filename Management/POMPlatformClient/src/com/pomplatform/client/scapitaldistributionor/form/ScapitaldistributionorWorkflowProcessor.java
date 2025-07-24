package com.pomplatform.client.scapitaldistributionor.form;

import com.delicacy.client.ui.AbstractDetailViewer;
import com.delicacy.client.ui.AbstractPrint;
import com.delicacy.client.ui.AbstractProcessPanel;
import com.delicacy.client.ui.WorkflowProcessor;

public class ScapitaldistributionorWorkflowProcessor implements WorkflowProcessor {
	@Override
	public AbstractProcessPanel getNewCreatePanel() {
		return new NewScapitaldistributionorWorkflow();
	}

	@Override
	public AbstractProcessPanel getProcessPanel(String processName) {
		processName = processName == null ? "" : processName;
		UpdateScapitaldistributionorWorkflow panel = new UpdateScapitaldistributionorWorkflow();
		panel.setProcessName(processName);
		return panel;
	}

	@Override
	public AbstractDetailViewer getViewPanel(String processName, Integer processType) {
		return new ScapitaldistributionorViewer();
	}

	@Override
	public AbstractPrint getPrintProcessor() {
		// TODO Auto-generated method stub
		return null;
	}

}
