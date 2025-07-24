package com.pomplatform.client.preprojects.form;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.ui.AbstractWizadPage;
import com.pomplatform.client.preprojects.panel.ReportedOfPreProjectsForUpdate;
import com.delicacy.client.ui.AbstractProcessPanel;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;
import java.util.HashMap;
import java.util.LinkedHashMap;

import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.util.SC;

public class UpdatePreProjectReportWorkflow extends AbstractProcessPanel
{

	private final Logger logger = Logger.getLogger("");
	@Override
	public void load() {
		if(getBusinessId() == null) return;
		Map params = new HashMap();
		params.put("mainProjectId", getBusinessId());
		DBDataSource.callOperation("NQ_PreProjectReport", "find", new DSCallback() {
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				if(dsResponse.getStatus() >= 0){
					setData(dsResponse.getData()[0]);
					if(__pages == null) __pages = getPages();
					for(AbstractWizadPage wp : __pages) { wp.setRecord(getData());
					wp.startEdit(); }
				}
			}
		});
	}

	@Override
	public boolean checkData(Map data){
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
				// Please code the program after save sucessfully.
			}
		});
		List<AbstractWizadPage> res = new ArrayList<>();
		ReportedOfPreProjectsForUpdate panel = new ReportedOfPreProjectsForUpdate();
		res.add(panel);
		return res;
	}


}

