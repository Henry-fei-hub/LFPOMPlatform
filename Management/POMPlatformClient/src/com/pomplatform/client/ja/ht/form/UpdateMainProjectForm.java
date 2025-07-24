package com.pomplatform.client.ja.ht.form;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.MapUtils;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.ui.AbstractWizadPage;
import com.delicacy.client.ui.GenericWizadWindow;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;

public class UpdateMainProjectForm extends GenericWizadWindow
{


	@Override
	public String getActionName(){
		// 需要根据实际业务修改
		return "EP_MainProjectProcessor";
	}

	@Override
	public boolean checkData(Map data) {
		boolean flag = true;
		List<AbstractWizadPage> pageList = __pages;
		for (AbstractWizadPage abstractWizadPage : pageList) {
			if (!abstractWizadPage.checkData()) {
				flag = false;
				break;
			}
		}
		return flag;
	}

	@Override
	public int getPageCount(){
		return 2;
	}

	@Override
	public List<AbstractWizadPage> getPages(){
		setCallback(new DSCallback() {
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				// 请在此编写成功保存后要做的工作
			}
		});
		setSubaction("update");
		List<AbstractWizadPage> res = new ArrayList<AbstractWizadPage>();
		res.add(new MainProjectUpdateForm());
		res.add(new EditMainProjectEmployeeInfoUpdate());
		return res;
	}
	
	
	
	@Override
	public Map getValues() {
		Map<String, Object> values = new HashMap<>();
		values.put("optType", "updateMainProject");
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
			Object projectManageReocrd = map.get("projectManageReocrd");
			Object projectResponsibleRecord = map.get("projectResponsibleRecord");
			Object projectType16Record = map.get("projectType16Record");
			Object specialtyReocrd = map.get("specialtyReocrd");
			if(!BaseHelpUtils.isNullOrEmpty(salePersonReocrd)){
				values.put("salePersonReocrd", salePersonReocrd);
			}
			if(!BaseHelpUtils.isNullOrEmpty(projectManageReocrd)){
				values.put("projectManageReocrd", projectManageReocrd);
			}
			if(!BaseHelpUtils.isNullOrEmpty(projectResponsibleRecord)){
				values.put("projectResponsibleRecord", projectResponsibleRecord);
			}
			if(!BaseHelpUtils.isNullOrEmpty(projectType16Record)){
				values.put("projectType16Record", projectType16Record);
			}
			if(!BaseHelpUtils.isNullOrEmpty(specialtyReocrd)){
				values.put("specialtyReocrd", specialtyReocrd);
			}
		}
		return values;
	}
	
	
}

