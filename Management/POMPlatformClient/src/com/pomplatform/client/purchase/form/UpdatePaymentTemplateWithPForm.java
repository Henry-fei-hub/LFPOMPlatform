package com.pomplatform.client.purchase.form;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.delicacy.client.ui.AbstractWizadPage;
import com.delicacy.client.ui.GenericWizadWindow;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;

public class UpdatePaymentTemplateWithPForm extends GenericWizadWindow
{


	@Override
	public String getActionName(){
		// 需要根据实际业务修改
		return "ST_PaymentTemplateWithP";
	}

	@Override
	public boolean checkData(Map data) {
		boolean flag = true;
		for (AbstractWizadPage abstractWizadPage : __pages) {
			flag = abstractWizadPage.checkData();
			if(!flag) {
				break;
			}
		}
		return flag;
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
				// Please code the program after save sucessfully.
			}
		});
		setSubaction("update");
		List<AbstractWizadPage> res = new ArrayList<>();
		res.add(new PaymentTemplateWithPUpdateForm());
		PaymentTemplateWithPDetailPaymentTemplateDetail paymenttemplatedetail = new PaymentTemplateWithPDetailPaymentTemplateDetail();
		paymenttemplatedetail.setPageMode(AbstractWizadPage.PAGE_MODE_UPDATE);
		res.add(paymenttemplatedetail);
		return res;
	}


}

