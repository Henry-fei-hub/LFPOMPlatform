package com.pomplatform.client.workflow.form;

import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.ui.AbstractWizadPage;
import com.delicacy.client.ui.AbstractProcessPanel;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

import com.pomplatform.client.contractinfo.panel.CustomAddSubContractMainTwoStartPanel;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.util.SC;

public class NewOrderPlacementWorkflow extends AbstractProcessPanel
{


	@Override
	public void load() {
		if(getBusinessId() == null) return;
		Map params = new HashMap();
		params.put("orderInfoId", getBusinessId());
		DBDataSource.callOperation("NQ_OrderPlacement", "find", new DSCallback() {
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
		return 1;
	}

	@Override
	public List<AbstractWizadPage> getPages(){
		Map<String, String> map = new HashMap<>();
		setCallback(new DSCallback() {
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				// 请在此编写成功保存后要做的工作
				if (dsResponse.getStatus() >= 0) {
					SC.say("提交审核成功");
				}
			}
		});
		if (getData() == null) {
			SC.say("获取数据失败！");
			return null;
		}
		List<AbstractWizadPage> res = new ArrayList<>();
		int contractId = ClientUtil.checkAndGetIntValue(getData().getAttribute("contractId"));
		int flowStatus = getData().getAttributeAsInt("flowStatus");
		CustomAddSubContractMainTwoStartPanel panel = new CustomAddSubContractMainTwoStartPanel(contractId, getData(), flowStatus, map);
		res.add(panel);
		return res;
	}


}

