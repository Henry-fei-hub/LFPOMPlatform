package com.pomplatform.client.newcontractppcor.form;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.ui.AbstractWizadPage;
import com.delicacy.client.ui.GenericWizadWindow;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.naming.spi.DirStateFactory.Result;

import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.util.SC;

public class UpdateScontractppcorForm extends GenericWizadWindow
{


	@Override
	public String getActionName(){
		// 需要根据实际业务修改
		return "ST_CustomContract";
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
		setCallback(new DSCallback() {
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if(dsResponse.getStatus()>=0) {
					SC.say("补录成功！");
				}else{
					String errorsMsg = BaseHelpUtils.getString(dsResponse.getErrors().get("errorMsg"));
					SC.say("提示("+errorsMsg+")");
				}
				
			}
		});
		setSubaction("update");
		List<AbstractWizadPage> res = new ArrayList<AbstractWizadPage>();
		res.add(new ScontractppcorUpdateForm1());
		//res.add(new ScontractppcorUpdateForm2());
		return res;
	}


}

