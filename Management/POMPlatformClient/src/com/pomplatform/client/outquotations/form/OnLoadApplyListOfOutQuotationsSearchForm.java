package com.pomplatform.client.outquotations.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.types.TextMatchStyle;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.outquotations.datasource.CDOnLoadApplyListOfOutQuotations;

public class OnLoadApplyListOfOutQuotationsSearchForm extends SearchForm
{


	private final TextItem quotationNumberItem;
	private final TextItem quotationNameItem;
	private final TextItem infoCodeItem;
	private final TextItem projectCodeItem;
	private final SelectItem quotationStatusItem;
	private final ComboBoxItem employeeIdItem;

	public OnLoadApplyListOfOutQuotationsSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDOnLoadApplyListOfOutQuotations.getInstance());
		
		quotationNumberItem = new TextItem("quotationNumber", "报价单编号");
		quotationNumberItem.setWidth("*");
		quotationNameItem = new TextItem("quotationName", "报价单名称");
		quotationNameItem.setWidth("*");
		infoCodeItem = new TextItem("infoCode", "信息编号");
		infoCodeItem.setWidth("*");
		projectCodeItem = new TextItem("projectCode", "项目编号");
		projectCodeItem.setWidth("*");
		quotationStatusItem = new SelectItem("quotationStatus", "报价单的状态");
		quotationStatusItem.setWidth("*");
		java.util.Map<String,String> quotationStatusValues = new java.util.HashMap<String,String>();
		quotationStatusValues.put("1", "成功");
		quotationStatusValues.put("2", "历史版本");
		quotationStatusValues.put("3", "报价中");
		quotationStatusItem.setValueMap(quotationStatusValues);
		employeeIdItem = new ComboBoxItem("employeeId", "申请人");
		employeeIdItem.setWidth("*");
		employeeIdItem.setValueMap(KeyValueManager.getValueMap("employees"));
		employeeIdItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);


		setItems( quotationNumberItem, quotationNameItem, infoCodeItem, projectCodeItem, quotationStatusItem, employeeIdItem);

		setNumCols(14);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
