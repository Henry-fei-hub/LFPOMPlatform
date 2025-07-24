package com.pomplatform.client.workflow.form;

import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.ui.AbstractWizadPage;
import com.delicacy.client.ui.GenericWizadWindow;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.util.SC;

public class UpdateSealApplicationForm extends GenericWizadWindow
{


	@Override
	public String getActionName(){
		// 需要根据实际业务修改
		return "ST_PersonnelBusines";
	}


	public void reloadData(int employeeId){
		Map<String,Object> param = new HashMap<>();
		param.put("employeeId", employeeId);
		param.put("optType", "onLoadEmployeeEditData");
		param.put("OperateEmployeeId", ClientUtil.getEmployeeId());
		DBDataSource.callOperation("EP_MyPersonnelProcessor", param, new DSCallback() {
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if (dsResponse.getStatus() >= 0) {
					if(__pages == null) __pages = getPages();
					for(AbstractWizadPage wp : __pages) {
						wp.setRecord(dsResponse.getData()[0]);
						wp.startEdit();
					}
				} else {
					Map errors = dsResponse.getErrors();
					SC.say("delete failure" + errors);
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
		return 1;
	}

	@Override
	public List<AbstractWizadPage> getPages(){
		setCallback(new DSCallback() {
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				// Please code the program after save sucessfully.
			}
		});
		setSubaction("update");
		List<AbstractWizadPage> res = new ArrayList<>();
		res.add(new SealApplicationUpdateForm());
		return res;
	}


}

