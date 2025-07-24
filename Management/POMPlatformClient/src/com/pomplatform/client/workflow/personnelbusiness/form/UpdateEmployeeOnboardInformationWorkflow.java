package com.pomplatform.client.workflow.personnelbusiness.form;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.ui.AbstractProcessPanel;
import com.delicacy.client.ui.AbstractWizadPage;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;

public class UpdateEmployeeOnboardInformationWorkflow extends AbstractProcessPanel
{
	private static final Logger logger = Logger.getLogger("");
	@Override
	public void load() {
		if(getBusinessId() == null) return;
		Map params = new HashMap();
		params.put("employeeId", getBusinessId());
		DBDataSource.callOperation("NQ_EmployeeOnboardInformation", "find", new DSCallback() {
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
		__pageMode = PAGE_DISPLAY_NAV;
		setCallback(new DSCallback() {
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				// 请在此编写成功保存后要做的工作
			}
		});
		List<AbstractWizadPage> res = new ArrayList<>();
		res.add(new EmployeeOnboardInformationBasicinfoUpdate(processName));
		res.add(new EmployeeOnboardInformationContactinfoUpdate());
		return res;
	}
	
	private String processName;
	public String getProcessName() {
		return processName;
	}

	public void setProcessName(String processName) {
		this.processName = processName;
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
			Object educationList = map.get("detailEmployeeEducationInformation");
			Object familyList = map.get("detailEmployeeFamilyInformation");
			Object rewardList = map.get("detailEmployeeRewardExperience");
			Object technicalList = map.get("detailEmployeeTechnicalTitle");
			Object workList = map.get("detailEmployeeWorkExperience");
			if(!BaseHelpUtils.isNullOrEmpty(educationList)){
				values.put("detailEmployeeEducationInformation", educationList);
			}
			if(!BaseHelpUtils.isNullOrEmpty(familyList)){
				values.put("detailEmployeeFamilyInformation", familyList);
			}
			if(!BaseHelpUtils.isNullOrEmpty(rewardList)){
				values.put("detailEmployeeRewardExperience", rewardList);
			}
			if(!BaseHelpUtils.isNullOrEmpty(technicalList)){
				values.put("detailEmployeeTechnicalTitle", technicalList);
			}
			if(!BaseHelpUtils.isNullOrEmpty(workList)){
				values.put("detailEmployeeWorkExperience", workList);
			}
			
		}
		return values;
	}
}

