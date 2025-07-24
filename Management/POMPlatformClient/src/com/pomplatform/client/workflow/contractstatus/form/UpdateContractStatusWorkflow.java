package com.pomplatform.client.workflow.contractstatus.form;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.ui.AbstractProcessPanel;
import com.delicacy.client.ui.AbstractWizadPage;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;

public class UpdateContractStatusWorkflow extends AbstractProcessPanel
{
	private String processName;

	@Override
	public void load() {
		if(getBusinessId() == null) return;
		Map params = new HashMap();
		params.put("contractLogId", getBusinessId());
		DBDataSource.callOperation("NQ_ContractStatus", "find", new DSCallback() {
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
    public boolean checkData(Map data) {
		boolean status = true;
		for(AbstractWizadPage wp : __pages){
			if(!wp.checkData()){
				status = false;
			}
		}
		return status;
    }

	@Override
	public int getPageCount(){
		return 1;
	}

	@Override
	public List<AbstractWizadPage> getPages(){
		setCallback(new DSCallback() {
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				// Please code the program after save sucessfully.
			}
		});
		List<AbstractWizadPage> res = new ArrayList<>();
		ContractStatusUpdateForm page = new ContractStatusUpdateForm();
		page.setProcessName(processName);
		res.add(page);
		return res;
	}

	public String getProcessName() {
		return processName;
	}

	public void setProcessName(String processName) {
		this.processName = processName;
	}

}

