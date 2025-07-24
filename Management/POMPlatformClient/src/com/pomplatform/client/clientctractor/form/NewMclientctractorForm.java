package com.pomplatform.client.clientctractor.form;

import com.delicacy.client.ui.AbstractWizadPage;
import com.delicacy.client.ui.GenericWizadWindow;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.pomplatform.client.clientctractor.datasource.DSMclientctractor;

public class NewMclientctractorForm extends GenericWizadWindow {
	
	private MclientctractorNewForm mclientctractorNewForm;
	
	@Override
	public String getActionName() {
		// 需要根据实际业务修改
		return "ST_CustomContractClient";
	}

	@Override
	public boolean checkData(Map data) {
		data.put("contractId", contractId);
		return mclientctractorNewForm.checkData();
	}

	@Override
	public int getPageCount() {
		return 1;
	}

	@Override
	public List<AbstractWizadPage> getPages() {
		setCallback(new DSCallback() {
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				// 请在此编写成功保存后要做的工作
			}
		});
		List<AbstractWizadPage> res = new ArrayList<>();
		mclientctractorNewForm = new MclientctractorNewForm();
		res.add(mclientctractorNewForm);
		return res;
	}

	private Integer contractId;

	public Integer getContractId() {
		return contractId;
	}

	public void setContractId(Integer contractId) {
		this.contractId = contractId;
	}

}
