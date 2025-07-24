package com.pomplatform.client.workflow.form;

import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.ui.AbstractWizadPage;
import com.delicacy.client.ui.AbstractProcessPanel;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

import com.pomplatform.client.contractinfo.panel.CustomAddSubContractMainTwoDisposePanel;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.util.SC;

public class UpdateOrderPlacementWorkflow extends AbstractProcessPanel
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
		return true;
	}

	@Override
	public int getPageCount(){
		return 2;
	}

	@Override
	public List<AbstractWizadPage> getPages(){
		SC.debugger();
		setCallback(new DSCallback() {
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				// Please code the program after save sucessfully.
			}
		});
		Map<String, String> map = new HashMap<>();
		List<AbstractWizadPage> res = new ArrayList<>();
		Record instanceData = get__instanceData();
		contractId = ClientUtil.checkAndGetIntValue(instanceData.getAttribute("contractId"));
		int orderinfoId = ClientUtil.checkAndGetIntValue(instanceData.getAttribute("orderInfoId"));
		CustomAddSubContractMainTwoDisposePanel panel = new CustomAddSubContractMainTwoDisposePanel(contractId,orderinfoId,instanceData , flowStatus, map);
		res.add(panel);
//		OrderPlacementDetailOrderInfoChild orderinfochild = new OrderPlacementDetailOrderInfoChild();
//		orderinfochild.setPageMode(AbstractWizadPage.PAGE_MODE_UPDATE);
//		res.add(orderinfochild);
		return res;
	}

	int flowStatus = 0;
	int contractId;

	public int getFlowStatus() {
		return flowStatus;
	}

	public void setFlowStatus(int flowStatus) {
		this.flowStatus = flowStatus;
	}

	public int getContractId() {
		return contractId;
	}

	public void setContractId(int contractId) {
		this.contractId = contractId;
	}
}

