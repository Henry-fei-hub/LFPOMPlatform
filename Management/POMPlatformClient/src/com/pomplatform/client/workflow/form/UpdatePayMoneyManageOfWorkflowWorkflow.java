package com.pomplatform.client.workflow.form;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.ui.AbstractProcessPanel;
import com.delicacy.client.ui.AbstractWizadPage;
import com.pomplatform.client.workflow.panel.ProcessBillListApplyBorrowMoneyPanel;
import com.pomplatform.client.workflow.panel.ProcessBillListApplyPanel;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.util.SC;

public class UpdatePayMoneyManageOfWorkflowWorkflow extends AbstractProcessPanel
{

	private final Logger __logger = Logger.getLogger("");
	@Override
	public void load() {
		if(getBusinessId() == null) return;
		Map<String,Object> params = new HashMap<>();
		params.put("payMoneyManageId", getBusinessId());
		DBDataSource.callOperation("NQ_PayMoneyManageOfWorkflow", "find", new DSCallback() {
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if(dsResponse.getStatus() >= 0){
					setData(dsResponse.getData()[0]);
					if(__pages == null) __pages = getPages();
					for(AbstractWizadPage wp : __pages) { wp.setRecord(getData()); wp.startEdit(); }
				}
			}
		});
	}

	@Override
	public boolean checkData(Map data){
		boolean flag =  true;
		List<AbstractWizadPage> pageList = __pages;
		for (AbstractWizadPage abstractWizadPage : pageList) {
			if(!abstractWizadPage.checkData()){
				flag = false;
				break;
			}
		}
		return flag;
	}

	@Override
	public int getPageCount(){
		return 2;
	}

	@Override
	public List<AbstractWizadPage> getPages(){
		setCallback(new DSCallback() {
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				// 请在此编写成功保存后要做的工作
			}
		});
		List<AbstractWizadPage> res = new ArrayList<>();
		PayMoneyManageOfWorkflowUpdateForm panel = new PayMoneyManageOfWorkflowUpdateForm();
		panel.setProcessId(getProcessId());
		res.add(panel);
		final ProcessBillListApplyPanel pblPanel = new ProcessBillListApplyPanel(getProcessName(), 7);
		pblPanel.setProcessType(7);
		pblPanel.setMainInfoPage(panel);
		pblPanel.setPageMode(AbstractWizadPage.PAGE_MODE_UPDATE);
		pblPanel.setTitle("账单流水");
		res.add(pblPanel);
		panel.setPblPanel(pblPanel);
		return res;
	}
	
	private String processName;
	
	public String getProcessName() {
		return processName;
	}

	public void setProcessName(String processName) {
		this.processName = processName;
	}
}

