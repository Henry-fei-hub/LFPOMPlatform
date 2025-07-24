package com.pomplatform.client.workflow.personnelbusiness.form;

import com.delicacy.client.ui.AbstractWizadPage;
import com.delicacy.client.ui.GenericWizadWindow;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.pomplatform.client.workflow.personnelbusiness.datasource.DSEmployeeOnboardInformation;
import com.pomplatform.client.workflow.personnelbusiness.datasource.DSEmployeeEducationInformation;
import com.pomplatform.client.workflow.personnelbusiness.datasource.DSEmployeeFamilyInformation;
import com.pomplatform.client.workflow.personnelbusiness.datasource.DSEmployeeRewardExperience;
import com.pomplatform.client.workflow.personnelbusiness.datasource.DSEmployeeWorkExperience;
import com.pomplatform.client.workflow.personnelbusiness.datasource.DSEmployeeTechnicalTitle;

public class NewEmployeeOnboardInformationForm extends GenericWizadWindow
{


	@Override
	public String getActionName(){
		// 需要根据实际业务修改
		return "ST_EmployeeWithEeeee";
	}

	@Override
	public boolean checkData(Map data){
		return true;
	}

	@Override
	public int getPageCount(){
		return 9;
	}

	@Override
	public List<AbstractWizadPage> getPages(){
		setCallback(new DSCallback() {
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				// 请在此编写成功保存后要做的工作
			}
		});
		List<AbstractWizadPage> res = new ArrayList<>();
		EmployeeOnboardInformationContactinfoNew nextPanel = new EmployeeOnboardInformationContactinfoNew();
		res.add(new EmployeeOnboardInformationBasicinfoNew(nextPanel));
		return res;
	}


}

