package com.pomplatform.client.operation.form;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.ui.AbstractWizadPage;
import com.delicacy.client.ui.GenericWizadWindow;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.util.SC;

public class UpdateProjectManagerForm extends GenericWizadWindow {
	
	@Override
	public String getActionName() {
		// 需要根据实际业务修改
		return "EP_ProjectUpdate";
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
//        return RoleDefinition.checkProjectValidaion(data);
    }

	@Override
	public int getPageCount() {
		return 1;
	}

	@Override
	public List<AbstractWizadPage> getPages() {
		setCallback(new DSCallback() {
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				// 请在此编写成功保存后要做的工作
				if (dsResponse.getStatus() < 0) {
            		SC.say(dsResponse.getErrors().toString());
            	}else {
            		SC.say("提交成功");
            	}
			}
		});
		setSubaction("update");
		List<AbstractWizadPage> res = new ArrayList<>();
		boolean isAuto = getRecord().getAttributeAsBoolean("isAuto");
		res.add(new ProjectManagerProjectbasicUpdate(isAuto));
//		res.add(new ProjectManagerOtherinfoUpdate());
		return res;
	}

}
