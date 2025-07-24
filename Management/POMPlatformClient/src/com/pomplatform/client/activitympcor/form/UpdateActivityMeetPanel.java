package com.pomplatform.client.activitympcor.form;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.delicacy.client.ui.AbstractWizadPage;
import com.delicacy.client.ui.GenericWizadWindow;
import com.pomplatform.client.preprojects.panel.PreProjectBasicInformationNew;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;


public class UpdateActivityMeetPanel  extends GenericWizadWindow{

	@Override
	public int getPageCount() {
		return 1;
	}

	@Override
	public String getActionName() {
		// 需要根据实际业务修改
		return "ST_Activity";
	}

	@Override
	public List<AbstractWizadPage> getPages() {
		setSubaction("update");
		setCallback(new DSCallback() {
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				// 请在此编写成功保存后要做的工作
			}
		});
		List<AbstractWizadPage> res = new ArrayList<>();
		res.add(new ActivityMeetUpdateForm());
		return res;
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

}
