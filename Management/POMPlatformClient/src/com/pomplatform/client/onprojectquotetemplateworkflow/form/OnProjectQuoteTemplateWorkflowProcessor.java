package com.pomplatform.client.onprojectquotetemplateworkflow.form;

import com.delicacy.client.ui.WorkflowProcessor;
import com.delicacy.client.ui.AbstractProcessPanel;
import com.delicacy.client.ui.AbstractDetailViewer;
import com.delicacy.client.ui.AbstractPrint;

public class OnProjectQuoteTemplateWorkflowProcessor implements WorkflowProcessor {
	@Override
	public AbstractProcessPanel getNewCreatePanel() {
		return new NewOnProjectQuoteTemplateWorkflow();
	}

	@Override
	public AbstractProcessPanel getProcessPanel(String processName) {
		return new UpdateOnProjectQuoteTemplateWorkflow();
	}

	@Override
	public AbstractDetailViewer getViewPanel(String processName, Integer processType) {
		return new OnProjectQuoteTemplateViewer();
	}

	@Override
	public AbstractPrint getPrintProcessor() {
		return new OnProjectQuoteTemplatePrintProcessor();
	}

}
