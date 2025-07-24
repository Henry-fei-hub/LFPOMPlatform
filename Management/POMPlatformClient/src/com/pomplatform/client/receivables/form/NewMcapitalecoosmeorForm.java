package com.pomplatform.client.receivables.form;

import com.delicacy.client.BaseHelpUtils;
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
import com.smartgwt.client.util.SC;
import com.pomplatform.client.receivables.datasource.DSMcapitalecoosmeor;

public class NewMcapitalecoosmeorForm extends GenericWizadWindow
{


	@Override
	public String getActionName(){
		// 需要根据实际业务修改
//		return "ST_Capital";
		return "EP_CapitalAndInvoiceProcessor";
	}

	@Override
	public boolean checkData(Map data){
		int moneyAttribute=BaseHelpUtils.getIntValue(data,"moneyAttribute");
		int contractId=BaseHelpUtils.getIntValue(data,"contractId");
		String remark =  BaseHelpUtils.getStringValue(data, "remark");
		if(moneyAttribute<=0){
			SC.say("选择款项属性");
			return false;
		}
		if(BaseHelpUtils.isNullOrEmpty(remark)) {
			SC.say("请填写备注");
			return false;
		}
		return true;
	}

	@Override
	public int getPageCount(){
		return 3;
	}

	@Override
	public List<AbstractWizadPage> getPages(){
		setCallback(new DSCallback() {
			@Override
			public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
				// 请在此编写成功保存后要做的工作
			}
		});
		List<AbstractWizadPage> res = new ArrayList<AbstractWizadPage>();
		McapitalecoosmeorGroupname1New panel1 = new McapitalecoosmeorGroupname1New();
		McapitalecoosmeorGroupname2New panel2 = new McapitalecoosmeorGroupname2New();
		McapitalecoosmeorGroupname3New panel3 = new McapitalecoosmeorGroupname3New();
		panel1.setPanel2(panel2);
		panel1.setPanel3(panel3);
		res.add(panel1);
		res.add(panel2);
		res.add(panel3);
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
		}
		values.put("employeeId", ClientUtil.getUserId());
		values.put("optType", "saveCapitalAndAutoApplyStages");
		return values;
	}
}

