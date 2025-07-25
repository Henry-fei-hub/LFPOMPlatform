package com.pomplatform.client.workflow.personnelbusiness.form;

import java.util.*;
import java.util.logging.Logger;

import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.fields.events.*;
import com.smartgwt.client.widgets.form.validator.*;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.form.*;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractWizadPage;
import com.pomplatform.client.workflow.personnelbusiness.datasource.DSEmployeeOnboardInformation;

public class EmployeeOnboardInformationPayinfoUpdate extends AbstractWizadPage
{


	private final TextItem tryTimePayItem;
	private final TextItem positivePayItem;
	private final TextItem annualPerformanceItem;
	private final TextItem annualBonusItem;
	private final SelectItem costAttributionItem;
	private String shouldNotBeNull = "<font style=\"color:red;font-weight:bold;font-size:13px;\">＊</font>";

	public EmployeeOnboardInformationPayinfoUpdate() {
		DSEmployeeOnboardInformation ds = DSEmployeeOnboardInformation.getInstance();
		__form.setWidth100();
		__form.setHeight100();
		
		tryTimePayItem = new TextItem("tryTimePay", shouldNotBeNull + "试用期工资");
		tryTimePayItem.setWidth("*");
		tryTimePayItem.setRequired(true);
		__formItems.add(tryTimePayItem);
		
		positivePayItem = new TextItem("positivePay", shouldNotBeNull + "转正工资");
		positivePayItem.setWidth("*");
		positivePayItem.setRequired(true);
		__formItems.add(positivePayItem);
		
		annualPerformanceItem = new TextItem("annualPerformance", "年度绩效");
		annualPerformanceItem.setWidth("*");
		__formItems.add(annualPerformanceItem);
		
		annualBonusItem = new TextItem("annualBonus", "年度奖金");
		annualBonusItem.setWidth("*");
		__formItems.add(annualBonusItem);

		costAttributionItem = new SelectItem("costAttribution",shouldNotBeNull + "费用归属");
		costAttributionItem.setWidth("*");
		costAttributionItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_114"));
		costAttributionItem.setRequired(true);
		__formItems.add(costAttributionItem);
		
		__form.setItems(getFormItemArray());
		__form.setDataSource(ds);
		__form.setNumCols(4);
		ClientUtil.DynamicFormProcessAccordingToDevice(__form);
		setPageMode(PAGE_MODE_UPDATE);
		setName("薪酬信息");
		addMember(__form);
	}

	@Override
	public void setValueManage(ValuesManager manager) {
		manager.setDataSource(DSEmployeeOnboardInformation.getInstance());
		manager.addMember(__form);
	}

	@Override
	public boolean checkData() {
		return true;
	}
	private static final Logger __logger = Logger.getLogger("");
	@Override
	public void startEdit() {
		if(getRecord() != null) __form.editRecord(getRecord());
	}

	@Override
	public java.util.Map getValuesAsMap() {
		Map<String,Object> value = new HashMap<>();
		value.put("tryTimePay", tryTimePayItem.getValue());
		value.put("positivePay", positivePayItem.getValue());
		value.put("annualPerformance", annualPerformanceItem.getValue());
		value.put("annualBonus", annualBonusItem.getValue());
		value.put("costAttribution", costAttributionItem.getValue());
		return value;
	}


}
