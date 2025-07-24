package com.pomplatform.client.preprojectreimbursementnumber.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.preprojectreimbursementnumber.datasource.CDPreProjectReimbursementNumbers;

public class PreProjectReimbursementNumbersSearchForm extends SearchForm
{


	private final TextItem projectNameItem;
	private final TextItem operatorItem;
	private final TextItem customNumberItem;
	private final TextItem remarkItem;

	public PreProjectReimbursementNumbersSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDPreProjectReimbursementNumbers.getInstance());
		projectNameItem = new TextItem("projectName", "项目名称");
		projectNameItem.setHidden(true);
		operatorItem = new TextItem("operator", "操作人");
		operatorItem.setHidden(true);
		customNumberItem = new TextItem("customNumber", "前期项目信息编号");
		customNumberItem.setWidth("*");
		remarkItem = new TextItem("remark", "备注");
		remarkItem.setWidth("*");
		setItems(projectNameItem, operatorItem, customNumberItem, remarkItem);

		setNumCols(4);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
