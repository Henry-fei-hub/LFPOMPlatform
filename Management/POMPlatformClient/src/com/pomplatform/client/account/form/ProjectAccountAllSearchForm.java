package com.pomplatform.client.account.form;

import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.ERPPermissionStatic;
import com.pomplatform.client.common.PomPlatformClientUtil;
import com.pomplatform.client.data.RoleDefinition;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.DateItem;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.TextItem;

public class ProjectAccountAllSearchForm extends SearchForm {

	private final TextItem contractCodeItem;
	private final TextItem contractNameItem;
	private final DateItem startDateItem;
	private final DateItem endDateItem;

	public ProjectAccountAllSearchForm() {
		setWidth100();
		setHeight100();
		contractCodeItem = new TextItem("contractCode", "合同编号");
		contractCodeItem.setWidth("*");
		contractNameItem = new TextItem("contractName", "合同名称");
		contractNameItem.setWidth("*");
		startDateItem = new DateItem("startDate", "开始时间");
		startDateItem.setWidth("*");
		startDateItem.setUseTextField(true);  
		endDateItem = new DateItem("endDate", "截止时间");
		endDateItem.setWidth("*");
		endDateItem.setUseTextField(true);  

		setItems(contractCodeItem, contractNameItem,startDateItem, endDateItem);
		setNumCols(9);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
