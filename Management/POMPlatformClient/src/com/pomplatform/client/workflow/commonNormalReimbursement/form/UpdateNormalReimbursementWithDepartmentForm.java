package com.pomplatform.client.workflow.commonNormalReimbursement.form;

import com.delicacy.client.ui.AbstractWizadPage;
import com.delicacy.client.ui.GenericWizadWindow;
import com.pomplatform.client.workflow.projectNormalReimbursement.form.ProjectNormalReimbursementDetailPanel;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;

public class UpdateNormalReimbursementWithDepartmentForm extends GenericWizadWindow
{


	@Override
	public String getActionName(){
		// 需要根据实际业务修改
		return "ST_ProjectNormalReimbursementWithPn";
	}

	@Override
	public boolean checkData(Map data){
		return true;
	}

	@Override
	public int getPageCount(){
		return 3;
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
		res.add(new NormalReimbursementWithDepartmentUpdateForm());
		ProjectNormalReimbursementDetailPanel projectnormalreimbursementdetail = new ProjectNormalReimbursementDetailPanel();
		projectnormalreimbursementdetail.setPageMode(AbstractWizadPage.PAGE_MODE_UPDATE);
		res.add(projectnormalreimbursementdetail);
		NormalReimbursementLinkDepartmentPanel normalreimbursementlinkdepartment = new NormalReimbursementLinkDepartmentPanel();
		normalreimbursementlinkdepartment.setPageMode(AbstractWizadPage.PAGE_MODE_UPDATE);
		res.add(normalreimbursementlinkdepartment);
		return res;
	}


}

