package com.pomplatform.client.preprojects.form;

import com.delicacy.client.BaseHelpUtils;
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
import com.smartgwt.client.data.Record;
import com.smartgwt.client.util.SC;
import com.pomplatform.client.preprojects.datasource.DSPreProjectReport;
import com.pomplatform.client.preprojects.panel.ReportedOfPreProjectsForComfirm;

public class NewPreProjectReportWorkflow extends AbstractProcessPanel
{


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
				// 请在此编写成功保存后要做的工作
			}
		});
		List<AbstractWizadPage> res = new ArrayList<>();
		Record record = getData();
		Boolean hasSimilar = BaseHelpUtils.getBoolean(record.getAttribute("hasSimilar"));
		int similarDataSize = BaseHelpUtils.getIntValue(record.getAttribute("similarDataSize"));
		ReportedOfPreProjectsForComfirm panel = new ReportedOfPreProjectsForComfirm(hasSimilar, similarDataSize);
		panel.setRecord(record);
		res.add(panel);
		return res;
	}
	
}

