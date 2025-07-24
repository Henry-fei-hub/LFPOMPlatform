package com.pomplatform.client.reimbursement.form;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.delicacy.client.ui.AbstractWizadPage;
import com.delicacy.client.ui.GenericWizadWindow;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.Record;

public class NewK3VoucherListForm extends GenericWizadWindow
{


	@Override
	public String getActionName(){
		// 需要根据实际业务修改
//		return "ST_K3Voucher";
		return "EP_K3VoucherProcess";
	}

	@Override
	public boolean checkData(Map data){
		data.put("optType", "saveK3Voucher");
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
				// 请在此编写成功保存后要做的工作
			}
		});
		List<AbstractWizadPage> res = new ArrayList<>();
		K3VoucherListNewForm form = new K3VoucherListNewForm();
		form.setRecord(record);
		form.startEdit();
		res.add(form);
		return res;
	}

}

