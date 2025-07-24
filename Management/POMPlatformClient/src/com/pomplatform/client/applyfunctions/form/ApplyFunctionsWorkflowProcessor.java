package com.pomplatform.client.applyfunctions.form;

import com.delicacy.client.ui.WorkflowProcessor;
import com.delicacy.client.ui.AbstractProcessPanel;

import java.util.logging.Logger;

import com.delicacy.client.ui.AbstractDetailViewer;
import com.delicacy.client.ui.AbstractPrint;

public class ApplyFunctionsWorkflowProcessor implements WorkflowProcessor {

    private static Logger __logger = Logger.getLogger("");

    @Override
    public AbstractProcessPanel getNewCreatePanel() {
        return new NewApplyFunctionsWorkflow();
    }

    @Override
    public AbstractProcessPanel getProcessPanel(String processName) {
        UpdateApplyFunctionsWorkflow panel = new UpdateApplyFunctionsWorkflow();
        panel.setProcessName(processName);
        return panel;
    }

    @Override
    public AbstractDetailViewer getViewPanel(String processName, Integer processType) {
        ApplyFunctionsViewer panel = new ApplyFunctionsViewer();
        panel.setProcessName(processName);
        return panel;
    }

    @Override
    public AbstractPrint getPrintProcessor() {
        return new ApplyFunctionsPrintProcessor();
    }

}
