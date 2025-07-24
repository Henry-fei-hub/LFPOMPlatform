package com.pomplatform.client.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.datasource.CDSettlementApplicationProject;

public class SettlementApplicationProjectSearchForm extends SearchForm
{


	private final TextItem departmentIdItem;
	private final TextItem projectCodeItem;
	private final TextItem projectNameItem;

	public SettlementApplicationProjectSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDSettlementApplicationProject.getInstance());
		departmentIdItem = new TextItem("departmentId", "部门");
		projectCodeItem = new TextItem("projectCode", "项目编号");
		projectNameItem = new TextItem("projectName", "项目名称");

		setItems(departmentIdItem, projectCodeItem, projectNameItem);

		setNumCols(6);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
