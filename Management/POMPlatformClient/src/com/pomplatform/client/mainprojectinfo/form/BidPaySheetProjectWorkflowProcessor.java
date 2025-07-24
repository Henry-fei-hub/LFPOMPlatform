package com.pomplatform.client.mainprojectinfo.form;

import com.delicacy.client.ui.WorkflowProcessor;
import com.delicacy.client.ui.AbstractProcessPanel;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.delicacy.client.ui.AbstractPrint;

public class BidPaySheetProjectWorkflowProcessor implements WorkflowProcessor {
	@Override
	public AbstractProcessPanel getNewCreatePanel() {
		return new NewBidPaySheetProjectWorkflow();
	}

	@Override
	public AbstractProcessPanel getProcessPanel(String processName) {
		return new UpdateBidPaySheetProjectWorkflow();
	}

	@Override
	public AbstractDetailViewer getViewPanel(String processName, Integer processType) {
		return new BidPaySheetProjectViewer();
	}

	@Override
	public AbstractPrint getPrintProcessor() {
//		return new BidPaySheetProjectPrintProcessor();
		return null;
	}

}
