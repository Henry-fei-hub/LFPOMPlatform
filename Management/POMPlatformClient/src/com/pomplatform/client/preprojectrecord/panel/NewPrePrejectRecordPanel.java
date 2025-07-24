package com.pomplatform.client.preprojectrecord.panel;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.delicacy.client.ui.AbstractWizadPage;
import com.delicacy.client.ui.GenericWizadWindow;
import com.pomplatform.client.preprojects.panel.PreProjectBasicInformationNew;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.util.SC;


public class NewPrePrejectRecordPanel  extends GenericWizadWindow{

	@Override
	public int getPageCount() {
		return 1;
	}

	@Override
	public String getActionName() {
		// 需要根据实际业务修改
		return "EP_AddPreProjectRecordProcess";
	}

	@Override
	public List<AbstractWizadPage> getPages() {
		setCallback(new DSCallback() {
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if(dsResponse.getStatus() >= 0){
					SC.say("保存成功");
				}
			}
		});
		List<AbstractWizadPage> res = new ArrayList<>();
		Record record = getRecord();
		PreProjectRecordNewForm preProjectRecordNewForm = new PreProjectRecordNewForm(isContract);
		preProjectRecordNewForm.setRecord(record);
		res.add(preProjectRecordNewForm);
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
	
	private Boolean isContract;

	public Boolean getIsContract() {
		return isContract;
	}

	public void setIsContract(Boolean isContract) {
		this.isContract = isContract;
	}
	
	


}
