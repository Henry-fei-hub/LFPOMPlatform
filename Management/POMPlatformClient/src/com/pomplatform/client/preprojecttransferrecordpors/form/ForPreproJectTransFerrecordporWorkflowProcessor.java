package com.pomplatform.client.preprojecttransferrecordpors.form;

import com.delicacy.client.ui.WorkflowProcessor;
import com.delicacy.client.ui.AbstractProcessPanel;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.delicacy.client.ui.AbstractPrint;

public class ForPreproJectTransFerrecordporWorkflowProcessor implements WorkflowProcessor {
	@Override
	public AbstractProcessPanel getNewCreatePanel() {
		return new NewForPreproJectTransFerrecordporWorkflow();
	}

	@Override
	public AbstractProcessPanel getProcessPanel(String processName) {
		//处理人节点用到次面板，审核人用不到
		return new UpdateForPreproJectTransFerrecordporWorkflow();
	}

	@Override
	public AbstractDetailViewer getViewPanel(String processName, Integer processType) {
		return new ForPreproJectTransFerrecordporViewer();
	}

	@Override
	public AbstractPrint getPrintProcessor() {
		return new ForPreproJectTransFerrecordporPrintProcessor();
	}

}
