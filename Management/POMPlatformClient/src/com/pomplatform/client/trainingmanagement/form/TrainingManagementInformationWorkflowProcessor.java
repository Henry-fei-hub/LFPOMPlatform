package com.pomplatform.client.trainingmanagement.form;

import com.delicacy.client.ui.WorkflowProcessor;
import com.delicacy.client.ui.AbstractProcessPanel;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.delicacy.client.ui.AbstractPrint;

public class TrainingManagementInformationWorkflowProcessor implements WorkflowProcessor {
	@Override
	public AbstractProcessPanel getNewCreatePanel() {
		return new NewTrainingManagementInformationWorkflow();
	}

	@Override
	public AbstractProcessPanel getProcessPanel(String processName) {
		return new UpdateTrainingManagementInformationWorkflow();
	}

	@Override
	public AbstractDetailViewer getViewPanel(String processName, Integer processType) {
		return new TrainingManagementInformationViewer();
	}

	@Override
	public AbstractPrint getPrintProcessor() {
		return new TrainingManagementInformationPrintProcessor();
	}

}
