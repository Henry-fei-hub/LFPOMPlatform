package com.pomplatform.client.client.workflow.specialdeduction.form;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.ui.AbstractWizadPage;
import com.pomplatform.client.specialdeduction.datasource.SpecialDeductionInformation1;
import com.delicacy.client.ui.AbstractProcessPanel;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.util.SC;

public class UpdateSpecialDeductionInformationWorkflow extends AbstractProcessPanel
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
				// Please code the program after save sucessfully.
			}
		});
		List<AbstractWizadPage> res = new ArrayList<>();
		SpecialDeductionInformationUpdateForm specialDeductionInformationUpdateForm = new SpecialDeductionInformationUpdateForm();
		SpecialDeductionInformation1 specialDeductionInformation1 = new SpecialDeductionInformation1();
		specialDeductionInformation1.setPageMode(AbstractWizadPage.PAGE_MODE_UPDATE);	
		specialDeductionInformationUpdateForm.setHeight("10%");
		res.add(specialDeductionInformationUpdateForm);
		res.add(specialDeductionInformation1);
		return res;
	}


}

