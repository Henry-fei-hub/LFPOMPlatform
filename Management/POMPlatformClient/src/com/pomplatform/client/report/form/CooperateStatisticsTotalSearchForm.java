package com.pomplatform.client.report.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.report.datasource.CDCooperateStatisticsTotal;

public class CooperateStatisticsTotalSearchForm extends SearchForm
{


	private final TextItem projectCodeItem;
	private final TextItem projectNameItem;
	private final ComboBoxItem departmentIdItem;
	private final ComboBoxItem typeItem;

	public CooperateStatisticsTotalSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDCooperateStatisticsTotal.getInstance());
		projectCodeItem = new TextItem("projectCode", "项目编号");
		projectCodeItem.setWidth("*");
		projectNameItem = new TextItem("projectName", "项目名称");
		projectNameItem.setWidth("*");
		departmentIdItem = new ComboBoxItem("departmentId", "部门");
		departmentIdItem.setValueMap(KeyValueManager.getValueMap("departments"));
		departmentIdItem.setWidth("*");
		typeItem = new ComboBoxItem("type", "配合部门");
		typeItem.setValueMap(KeyValueManager.getValueMap("departments"));
		setItems(projectCodeItem, projectNameItem, departmentIdItem, typeItem);

		setNumCols(8);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
