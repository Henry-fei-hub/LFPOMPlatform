package com.pomplatform.client.payment.form;

import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.payment.datasource.CDResidualwageData;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.PickTreeItem;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.TextItem;

public class ResidualwageDataSearchForm extends SearchForm
{


	private final SelectItem yearItem;
	private final SelectItem monthItem;
	private final SelectItem companyIdItem;
	private final TextItem employeeNoItem;
	private final PickTreeItem employeeNameItem;

	public ResidualwageDataSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDResidualwageData.getInstance());
		yearItem = new SelectItem("year", "年份");
		yearItem.setWidth("*");
		yearItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_18"));

		monthItem = new SelectItem("month", "月份");
		monthItem.setWidth("*");
		monthItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_19"));

		companyIdItem = new SelectItem("companyId", "归属公司");
		companyIdItem.setWidth("*");
		companyIdItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_26"));

		employeeNoItem = new TextItem("employeeNo", "员工编号");
		employeeNoItem.setWidth("*");
		employeeNoItem.setHidden(true);

		employeeNameItem = new PickTreeItem("employeeName", "undefined");
		employeeNameItem.setCanSelectParentItems(true);
		employeeNameItem.setValueField("treeId");
		employeeNameItem.setValueTree(KeyValueManager.getTree("departments", ""));
		employeeNameItem.setHidden(true);

		setItems(yearItem, monthItem, companyIdItem, employeeNoItem, employeeNameItem);

		setNumCols(6);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
