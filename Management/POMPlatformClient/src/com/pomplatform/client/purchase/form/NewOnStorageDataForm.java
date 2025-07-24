package com.pomplatform.client.purchase.form;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.ui.AbstractWizadPage;
import com.delicacy.client.ui.GenericWizadWindow;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;

public class NewOnStorageDataForm extends GenericWizadWindow
{
	Map valueMap = new HashMap<>();

	@Override
	public String getActionName(){
		// 需要根据实际业务修改
		return "ST_Storage";
	}

	@Override
	public boolean checkData(Map data){
		valueMap = data;
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
				//保存成功后，更新地区序列值
				if(dsResponse.getStatus() >= 0) {
					int storageAreaId = BaseHelpUtils.getIntValue(valueMap.get("storageAreaId"));
					int serialNumber  = BaseHelpUtils.getIntValue(valueMap.get("serialNumber"));
					if(storageAreaId > 0 && serialNumber > 0) {
						//获取序列号
						Map<String,Object> params = new HashMap<>();
						params.put("storageAreaId",storageAreaId);
						params.put("serialNumber",serialNumber);
						DBDataSource.callOperation("ST_StorageArea","update",params, new DSCallback() {
							@Override
							public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
							}
						});
					}
				}
			}
		});
		List<AbstractWizadPage> res = new ArrayList<>();
		res.add(new OnStorageDataNewForm());
		return res;
	}


}

