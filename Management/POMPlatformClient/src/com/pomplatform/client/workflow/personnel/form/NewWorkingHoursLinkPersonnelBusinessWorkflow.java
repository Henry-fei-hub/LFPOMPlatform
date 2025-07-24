package com.pomplatform.client.workflow.personnel.form;

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
import com.pomplatform.client.workflow.personnel.datasource.DSWorkingHoursLinkPersonnelBusiness;

public class NewWorkingHoursLinkPersonnelBusinessWorkflow extends AbstractProcessPanel
{
	private WorkingHoursLinkPersonnelBusinessNewForm mainPanel;
	private WorkHourdetailForm workHourdetailForm;

	@Override
	public void load() {
		if(getBusinessId() == null) return;
		Map params = new HashMap();
		params.put("personnelBusinessId", getBusinessId());
		DBDataSource.callOperation("NQ_WorkingHoursLinkPersonnelBusiness", "find", new DSCallback() {
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
		return workHourdetailForm.checkData();
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

		mainPanel = new WorkingHoursLinkPersonnelBusinessNewForm(true);
		workHourdetailForm = new WorkHourdetailForm(true);
		List<AbstractWizadPage> res = new ArrayList<>();
		res.add(mainPanel);
		res.add(workHourdetailForm);
		return res;
	}

	/**
	 * @author liubin
	 * @description //TODO 封装数据
	 * @date 14:29 2020/2/24
	 * @param
	 * @return
	 **/
	@Override
	public Map getValues() {
		Map map = mainPanel.getValuesAsMap();
		Map valuesAsMap = workHourdetailForm.getValuesAsMap();
		if (null != valuesAsMap) {
			map.put("workHoursDetails", valuesAsMap.get("workHoursDetails"));
		}
		return map;
	}
}

