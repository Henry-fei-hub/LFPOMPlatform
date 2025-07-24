package com.pomplatform.client.scapitaldistributionor.form;

import com.delicacy.client.ui.AbstractWizadPage;
import com.delicacy.client.ui.GenericWizadWindow;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;

public class UpdateScapitaldistributionorForm extends GenericWizadWindow
{


	@Override
	public String getActionName(){
		// 需要根据实际业务修改
		return "ST_CapitalDistributionWithCc";
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
		res.add(new ScapitaldistributionorUpdateForm(""));
		CapitalDistributionDetailCapitalDistributionLinkDepartment capitaldistributionlinkdepartment = new CapitalDistributionDetailCapitalDistributionLinkDepartment();
		capitaldistributionlinkdepartment.setPageMode(AbstractWizadPage.PAGE_MODE_UPDATE);
		res.add(capitaldistributionlinkdepartment);
		CapitalDistributionDetailCapitalDistributionLinkSubContract capitaldistributionlinksubcontract = new CapitalDistributionDetailCapitalDistributionLinkSubContract("");
		capitaldistributionlinksubcontract.setPageMode(AbstractWizadPage.PAGE_MODE_UPDATE);
		res.add(capitaldistributionlinksubcontract);
		return res;
	}


}

