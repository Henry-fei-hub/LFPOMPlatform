package com.pomplatform.client.preprojects.form;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.ui.AbstractProcessPanel;
import com.delicacy.client.ui.AbstractWizadPage;
import com.delicacy.client.ui.GenericWizadWindow;
import com.pomplatform.client.preprojects.panel.PreProjectBasicInformationUpdate;
import com.pomplatform.client.preprojects.panel.PreProjectDetailInformationUpdate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;

import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.util.SC;

public class NewCloseProjectApplyWorkflow extends AbstractProcessPanel {

	private static final Logger __logger = Logger.getLogger("");
	
	@Override
	public void load() {
		if(getBusinessId() == null) return;
		Map params = new HashMap();
		params.put("preProjectId", getBusinessId());
		DBDataSource.callOperation("NQ_CloseProjectApply", "find", new DSCallback() {
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
    public boolean checkData(Map data) {
		boolean status = true;
		for(AbstractWizadPage wp : __pages){
			if(!wp.checkData()){
				status = false;
			}
		}
		return status;
    }

	@Override
	public int getPageCount() {
		return 2;
	}

	@Override
	public List<AbstractWizadPage> getPages() {
		__pageMode = PAGE_DISPLAY_NAV;
		setCallback(new DSCallback() {
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
			}
		});
		List<AbstractWizadPage> res = new ArrayList<>();
		PreProjectBasicInformationUpdate basic = new PreProjectBasicInformationUpdate();
		PreProjectDetailInformationUpdate detail = new PreProjectDetailInformationUpdate();
		basic.setRecord(getData());
		detail.setRecord(getData());
		res.add(basic);
		res.add(detail);
		return res;
	}
	
	@Override
	public Map getValues() {
		Map<String, Object> values = new HashMap<>();
		for (AbstractWizadPage p : __pages) {
			@SuppressWarnings("unchecked")
			Map<String, Object> map = p.getValuesAsMap();
			Set<String> set = p.getItemNames();
			if (!BaseHelpUtils.isNullOrEmpty(map) && map.size() > 0) {
				if (!BaseHelpUtils.isNullOrEmpty(set) && set.size() > 0) {
					for (String key : map.keySet()) {
						if (set.contains(key)) {
							values.put(key, map.get(key));
						}
					}
				}
			}
			//获取每一页的列表数据集，并重新封装
			Object salePersonReocrd = map.get("salePersonReocrd");
			Object saleLeaderReocrd = map.get("saleLeaderReocrd");
			Object projectManageReocrd = map.get("projectManageReocrd");
			Object projectLeaderReocrd = map.get("projectLeaderReocrd");
			Object businessTypeReocrd = map.get("businessTypeReocrd");
			Object specialtyReocrd = map.get("specialtyReocrd");
			Object competitionUnitRecord = map.get("competitionUnitRecord");
			if(!BaseHelpUtils.isNullOrEmpty(salePersonReocrd)){
				values.put("salePersonReocrd", salePersonReocrd);
			}
			if(!BaseHelpUtils.isNullOrEmpty(saleLeaderReocrd)){
				values.put("saleLeaderReocrd", saleLeaderReocrd);
			}
			if(!BaseHelpUtils.isNullOrEmpty(projectManageReocrd)){
				values.put("projectManageReocrd", projectManageReocrd);
			}
			if(!BaseHelpUtils.isNullOrEmpty(projectLeaderReocrd)){
				values.put("projectLeaderReocrd", projectLeaderReocrd);
			}
			if(!BaseHelpUtils.isNullOrEmpty(businessTypeReocrd)){
				values.put("businessTypeReocrd", businessTypeReocrd);
			}
			if(!BaseHelpUtils.isNullOrEmpty(specialtyReocrd)){
				values.put("specialtyReocrd", specialtyReocrd);
			}
			if(!BaseHelpUtils.isNullOrEmpty(competitionUnitRecord)){
				values.put("competitionUnitRecord", competitionUnitRecord);
			}
		}
		return values;
	}

}
