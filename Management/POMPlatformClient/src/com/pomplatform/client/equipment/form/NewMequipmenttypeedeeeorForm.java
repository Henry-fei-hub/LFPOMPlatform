package com.pomplatform.client.equipment.form;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractWizadPage;
import com.delicacy.client.ui.GenericWizadWindow;

import java.util.*;

import com.smartgwt.client.data.*;
import com.pomplatform.client.equipment.datasource.DSMequipmenttypeedeeeor;
import com.pomplatform.client.equipment.datasource.DSMequipmentrecordedeor;
import com.smartgwt.client.util.SC;

public class NewMequipmenttypeedeeeorForm extends GenericWizadWindow
{


	@Override
	public String getActionName(){
		// 需要根据实际业务修改
		return "EP_AddEquipmentProcess";
	}



	@Override
	public boolean checkData(Map data){
		if(BaseHelpUtils.isNullOrEmpty(data.get("name"))){
			SC.say("请输入物品名称！");
			return false;
		}
		if(BaseHelpUtils.isNullOrEmpty(data.get("type"))){
			SC.say("请选择物品类型！");
			return false;
		}
		if(BaseHelpUtils.isNullOrEmpty(data.get("count"))){
			SC.say("请输入物品数量！");
			return false;
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

			}
		});
		List<AbstractWizadPage> res = new ArrayList<>();
		res.add(new MequipmenttypeedeeeorNewForm());
		return res;
	}


}

