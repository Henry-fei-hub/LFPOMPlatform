package com.pomplatform.client.selectgrid.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.selectgrid.datasource.CDSelectGridMyProjectValue;

public class SelectGridMyProjectValueSearchForm extends SearchForm
{


	private final SelectItem employeeIdItem;
	private final TextItem contractCodeItem;
	private final TextItem projectCodeItem;
	private final TextItem projectNameItem;
	private final TextItem projectIdItem;
	private final TextItem projectTypeItem;
	private final TextItem plateIdItem;
	private final SelectItem statusItem;
	private final TextItem contractIdItem;
	private final TextItem projectSetupFlagItem;

	public SelectGridMyProjectValueSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDSelectGridMyProjectValue.getInstance());
		employeeIdItem = new SelectItem("employeeId", "员工编码");
		employeeIdItem.setValueMap(KeyValueManager.getValueMap("employees"));
		contractCodeItem = new TextItem("contractCode", "合同编号");
		projectCodeItem = new TextItem("projectCode", "项目编号");
		projectNameItem = new TextItem("projectName", "项目名称");
		projectIdItem = new TextItem("projectId", "项目编码");
		projectTypeItem = new TextItem("projectType", "项目类别");
		plateIdItem = new TextItem("plateId", "板块");
		statusItem = new SelectItem("status", "项目状态");
		statusItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_39"));
		contractIdItem = new TextItem("contractId", "合同编码");
		projectSetupFlagItem = new TextItem("projectSetupFlag", ")");

		setItems(employeeIdItem, contractCodeItem, projectCodeItem, projectNameItem, projectIdItem, projectTypeItem, plateIdItem, statusItem, contractIdItem, projectSetupFlagItem);

		setNumCols(20);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
