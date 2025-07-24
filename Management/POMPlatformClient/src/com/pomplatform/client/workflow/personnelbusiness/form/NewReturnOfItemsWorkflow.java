package com.pomplatform.client.workflow.personnelbusiness.form;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.ui.AbstractWizadPage;
import com.delicacy.client.ui.AbstractProcessPanel;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.logging.Logger;

import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.pomplatform.client.workflow.personnelbusiness.datasource.DSReturnOfItems;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.grid.ListGridRecord;

public class NewReturnOfItemsWorkflow extends AbstractProcessPanel
{

	private Logger logger = Logger.getLogger("");
	List<AbstractWizadPage> res = new ArrayList<>();
	private ReturnOfItemsNewForm returnOfItemsNewForm = new ReturnOfItemsNewForm();
	private ReturnOfItemDetail returnOfItemDetail = new ReturnOfItemDetail();

	@Override
	public void load() {
		if(getBusinessId() == null) return;
		Map params = new HashMap();
		params.put("personnelBusinessId", getBusinessId());
		DBDataSource.callOperation("NQ_ReturnOfItems", "find", new DSCallback() {
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if(dsResponse.getStatus() >= 0){
					setData(dsResponse.getData()[0]);
					if(res == null) res = getPages();
					for(AbstractWizadPage wp : res) { wp.setRecord(getData()); wp.startEdit(); }
				}
			}
		});
	}

	@Override
	public Map getValues() {
		SC.debugger();
		List<Map> returnOfItemDetailList = new ArrayList<>();
		Map<String, Object> params = new HashMap<>();
		//获取流程业务表的数据
		params = returnOfItemsNewForm.getValuesAsMap();
		//获取归还的详情数据
		Map returnOfItemDetailMap = returnOfItemDetail.getValuesAsMap();

		returnOfItemDetailList = (List<Map>) returnOfItemDetailMap.get("returnOfItemDetail");

		params.put("returnOfItemDetail", returnOfItemDetailList);
		params.put("processType", 83);
		logger.info("--------------------------- params:" + params );
		return params;
	}

	@Override
	public boolean checkData(Map data){
		SC.debugger();
		List<Map> returnOfItemDetailList = new ArrayList<>();
		Map returnOfItemDetailMap = returnOfItemDetail.getValuesAsMap();

		returnOfItemDetailList = (List<Map>) returnOfItemDetailMap.get("returnOfItemDetail");

		if(returnOfItemDetailList.size()<=0){
			SC.say("请勾选要归还的物品!");
			return false;
		}
		for (Map r :returnOfItemDetailList){
			if(BaseHelpUtils.getIntValue(r.get("returnAmount"))<=0){
				SC.say("归还数量不能为0!");
				return false;
			}
		}
		return true;
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
				// 请在此编写成功保存后要做的工作
			}
		});

		res.add(returnOfItemsNewForm);
		res.add(returnOfItemDetail);
		return res;
	}


}

