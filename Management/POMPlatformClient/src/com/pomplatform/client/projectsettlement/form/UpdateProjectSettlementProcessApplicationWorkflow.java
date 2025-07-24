package com.pomplatform.client.projectsettlement.form;

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

public class UpdateProjectSettlementProcessApplicationWorkflow extends AbstractProcessPanel
{


	@Override
	public void load() {
		if(getBusinessId() == null) return;
		Map params = new HashMap();
		params.put("settlementId", getBusinessId());
		DBDataSource.callOperation("NQ_ProjectSettlementProcessApplication", "find", new DSCallback() {
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
		List<AbstractWizadPage> res = new ArrayList<>();
		ProjectSettlementProcessApplicationDetailProjectSettlementDetail detail = new ProjectSettlementProcessApplicationDetailProjectSettlementDetail();
		detail.setPageMode(AbstractWizadPage.PAGE_MODE_UPDATE);
		res.add(detail);
//		res.add(new ProjectSettlementProcessApplicationUpdateForm());
//		ProjectSettlementProcessApplicationDetailProjectSettlementDetail projectsettlementdetail = new ProjectSettlementProcessApplicationDetailProjectSettlementDetail();
//		projectsettlementdetail.setPageMode(AbstractWizadPage.PAGE_MODE_UPDATE);
//		res.add(projectsettlementdetail);
		return res;
	}


}

