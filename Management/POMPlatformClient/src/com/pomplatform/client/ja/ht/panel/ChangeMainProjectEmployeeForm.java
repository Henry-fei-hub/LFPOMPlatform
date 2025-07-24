package com.pomplatform.client.ja.ht.panel;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.ui.AbstractWizadPage;
import com.delicacy.client.ui.GenericWizadWindow;
import com.pomplatform.client.project.form.ChangeMainProjectEmployeeDetail;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.util.SC;

public class ChangeMainProjectEmployeeForm extends GenericWizadWindow
{
	@Override
	public String getActionName(){
		// 需要根据实际业务修改
		return "EP_OnProjectCommonProcess";
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public boolean checkData(Map data){
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
				SC.say("提示","保存成功");
			}
		});
		List<AbstractWizadPage> res = new ArrayList<>();
		res.add(new ChangeMainProjectEmployeeDetail());
		return res;
	}


}

