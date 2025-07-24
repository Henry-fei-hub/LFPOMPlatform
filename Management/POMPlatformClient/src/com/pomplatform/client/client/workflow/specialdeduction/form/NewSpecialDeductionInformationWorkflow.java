package com.pomplatform.client.client.workflow.specialdeduction.form;

import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.ui.AbstractWizadPage;
import com.delicacy.client.ui.AbstractProcessPanel;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.pomplatform.client.client.workflow.specialdeduction.datasource.DSSpecialDeductionInformation;
import com.pomplatform.client.specialdeduction.datasource.SpecialDeductionInformation1;
import com.pomplatform.client.specialdeduction.datasource.SpecialDeductionInformation7;

public class NewSpecialDeductionInformationWorkflow extends AbstractProcessPanel
{


	@Override
	public void load() {
		if(getBusinessId() == null) return;
		Map params = new HashMap();
		params.put("specialDeductionRecordId", getBusinessId());
		DBDataSource.callOperation("NQ_SpecialDeductionInformation", "find", new DSCallback() {
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if(dsResponse.getStatus() >= 0){
					setData(dsResponse.getData()[0]);
					if(__pages == null) __pages = getPages();
					for(AbstractWizadPage wp : __pages) { wp.setRecord(getData()); wp.startEdit(); }
				}
			}
		});
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
		return 2;
	}

	@Override
	public List<AbstractWizadPage> getPages(){
		__layoutMode=LAYOUT_TOPBOTTOM;
		setCallback(new DSCallback() {
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				// 请在此编写成功保存后要做的工作
			}
		});
		List<AbstractWizadPage> res = new ArrayList<>();
		SpecialDeductionInformationNewForm specialDeductionInformationNewForm = new SpecialDeductionInformationNewForm();
		specialDeductionInformationNewForm.setHeight("10%");
		SpecialDeductionInformation1 specialDeductionInformation1 = new SpecialDeductionInformation1();
//		specialDeductionInformation1.setSpecialDeductionInformationNewForm(specialDeductionInformationNewForm);
		specialDeductionInformationNewForm.setSpecialDeductionInformation1(specialDeductionInformation1);
		res.add(specialDeductionInformationNewForm);
		res.add(specialDeductionInformation1);
		return res;
	}


}

