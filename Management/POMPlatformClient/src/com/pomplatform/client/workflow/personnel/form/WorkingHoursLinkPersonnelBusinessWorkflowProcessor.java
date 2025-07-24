package com.pomplatform.client.workflow.personnel.form;

import com.delicacy.client.ui.WorkflowProcessor;
import com.delicacy.client.ui.AbstractProcessPanel;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.delicacy.client.ui.AbstractPrint;

public class WorkingHoursLinkPersonnelBusinessWorkflowProcessor implements WorkflowProcessor {
	@Override
	public AbstractProcessPanel getNewCreatePanel() {
		return new NewWorkingHoursLinkPersonnelBusinessWorkflow();
	}

	@Override
	public AbstractProcessPanel getProcessPanel(String processName) {
		return new UpdateWorkingHoursLinkPersonnelBusinessWorkflow();
	}

	@Override
	public AbstractDetailViewer getViewPanel(String processName, Integer processType) {
		return new WorkingHoursLinkPersonnelBusinessViewer();
	}

	@Override
	public AbstractPrint getPrintProcessor() {
		return new WorkingHoursLinkPersonnelBusinessPrintProcessor();
	}

}
