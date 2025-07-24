package com.pomplatform.client.workflow.form;

import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.ui.AbstractWizadPage;
import com.pomplatform.client.projectteambuild.form.SprojectteambuildDetailProjectEmployee;
import com.delicacy.client.ui.AbstractProcessPanel;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;

public class UpdateProjectEmployeeProcessApplicationWorkflow extends AbstractProcessPanel
{


	@Override
	public void load() {
		if(getBusinessId() == null) return;
		Map params = new HashMap();
		params.put("personnelBusinessId", getBusinessId());
		DBDataSource.callOperation("NQ_ProjectEmployeeProcessApplication", "find", new DSCallback() {
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
//		res.add(new ProjectEmployeeProcessApplicationUpdateForm());
//		ProjectEmployeeProcessApplicationDetailProjectEmployee projectemployee = new ProjectEmployeeProcessApplicationDetailProjectEmployee();
//		projectemployee.setPageMode(AbstractWizadPage.PAGE_MODE_UPDATE);
//		res.add(projectemployee);
		SprojectteambuildDetailProjectEmployee projectemployee = new SprojectteambuildDetailProjectEmployee();
		projectemployee.setPageMode(AbstractWizadPage.PAGE_MODE_UPDATE);
		projectemployee.setRecord(getData());
		res.add(projectemployee);
		return res;
	}


}

