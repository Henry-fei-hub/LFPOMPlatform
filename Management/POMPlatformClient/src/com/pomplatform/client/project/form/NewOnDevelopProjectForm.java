package com.pomplatform.client.project.form;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.ui.AbstractWizadPage;
import com.delicacy.client.ui.GenericWizadWindow;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.util.SC;

public class NewOnDevelopProjectForm extends GenericWizadWindow
{


	@Override
	public String getActionName(){
		// 需要根据实际业务修改
		return "EP_OnProjectCommonProcess";
	}

	@Override
	public boolean checkData(Map data){
		data.put("optType","onDevelopProjectSave");
		//获取部门
		int departmentId = BaseHelpUtils.getIntValue(data.get("departmentId"));
		//获取项目积分
		BigDecimal projectIntegral = BaseHelpUtils.getBigDecimalValue(data.get("projectIntegral"));
		if(departmentId == 0){
			SC.say("提示","归属部门不能为空");
			return false;
		}else if(projectIntegral.compareTo(BigDecimal.ZERO) <= 0){
			SC.say("提示","项目积分不能小于0");
			return false;
		}else{
			return true;
		}
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
				Record record = getRecord();
				Map<String,Object> param = new HashMap<>();
				param.put("optType","onSaveOrUpdateProjectCode");
				param.putAll(record.toMap());
				//加载项目编码
				DBDataSource.callOperation("EP_OnProjectCommonProcess", "load",param, new DSCallback() {
					@Override
					public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
						if (dsResponse.getStatus() < 0) {
							ClientUtil.displayErrorMessage(dsResponse);
						} else {
							SC.say("提示","保存成功");
						}
					}
				});
			}
		});
		List<AbstractWizadPage> res = new ArrayList<>();
		res.add(new OnDevelopProjectNewForm());
		return res;
	}


}

