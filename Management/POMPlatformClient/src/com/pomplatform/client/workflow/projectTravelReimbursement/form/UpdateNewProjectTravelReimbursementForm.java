package com.pomplatform.client.workflow.projectTravelReimbursement.form;

import com.delicacy.client.ui.AbstractWizadPage;
import com.delicacy.client.ui.GenericWizadWindow;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;

public class UpdateNewProjectTravelReimbursementForm extends GenericWizadWindow
{


	@Override
	public String getActionName(){
		// 需要根据实际业务修改
		return "ST_TravelReimbursementWithTt";
	}

	@Override
	public boolean checkData(Map data){
		return true;
	}

	@Override
	public int getPageCount(){
		return 2;
	}

	@Override
	public List<AbstractWizadPage> getPages(){
		setCallback(new DSCallback() {
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				// 请在此编写成功保存后要做的工作
			}
		});
		setSubaction("update");
		List<AbstractWizadPage> res = new ArrayList<>();
		res.add(new NewProjectTravelReimbursementUpdateForm());
		TravelReimbursementDetail travelReimbursementDetail = new TravelReimbursementDetail();
		travelReimbursementDetail.setPageMode(AbstractWizadPage.PAGE_MODE_UPDATE);
		res.add(travelReimbursementDetail);
		TravelReimbursementLinkProjectDetail travelReimbursementLinkProjectDetail = new TravelReimbursementLinkProjectDetail();
		travelReimbursementLinkProjectDetail.setPageMode(AbstractWizadPage.PAGE_MODE_UPDATE);
		res.add(travelReimbursementLinkProjectDetail);
		return res;
	}


}

