package com.pomplatform.client.costallocation.form;

import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.ui.AbstractWizadPage;
import com.delicacy.client.ui.AbstractProcessPanel;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;
import java.util.HashMap;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.pomplatform.client.costallocation.datasource.DSCostAllocationApply;
import com.pomplatform.client.costallocation.datasource.DSCostAllocation;

public class NewCostAllocationApplyWorkflow extends AbstractProcessPanel
{


	@Override
	public void load() {
		if(getBusinessId() == null) return;
		Map params = new HashMap();
		params.put("resetCostId", getBusinessId());
		DBDataSource.callOperation("NQ_CostAllocationApply", "find", new DSCallback() {
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
		CostAllocationApplyNewForm panel1 = new CostAllocationApplyNewForm();
		panel1.setRecord(getData());
		ResetCostDetailCostAllocation panel2 = new ResetCostDetailCostAllocation();
		panel1.setPanel(panel2);
		res.add(panel1);
		res.add(panel2);
		return res;
	}

}

