package com.pomplatform.client.workflow.operation.form;

import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.workflow.operation.datasource.CDOnLoadTaskListOfCostAllocation;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.TextItem;

public class OnLoadTaskListOfCostAllocationSearchForm extends SearchForm
{


	private final SelectItem statusItem;
	private final SelectItem processTypeItem;
	private final SelectItem employeeIdItem;
	private final SelectItem costTypeItem;
	private final TextItem costItem;
	private final TextItem codeItem;
	private final TextItem nameItem;

	public OnLoadTaskListOfCostAllocationSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDOnLoadTaskListOfCostAllocation.getInstance());
		statusItem = new SelectItem("status", "状态");
		statusItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_16"));
		statusItem.hide();
		processTypeItem = new SelectItem("processType", "流程类型");
		processTypeItem.setValueMap(KeyValueManager.getValueMap("system_process_types"));
		processTypeItem.hide();
		employeeIdItem = new SelectItem("employeeId", "处理人");
		employeeIdItem.setValueMap(KeyValueManager.getValueMap("employees"));
		employeeIdItem.hide();
		costTypeItem = new SelectItem("costType", "原成本类型");
		costTypeItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_121"));
		costTypeItem.setWidth("*");
		costItem = new TextItem("cost", "成本");
		costItem.setWidth("*");
		codeItem = new TextItem("code", "编号");
		codeItem.setWidth("*");
		nameItem = new TextItem("name", "费用承担主体");
		nameItem.setWidth("*");

		setItems(statusItem, processTypeItem, employeeIdItem, costTypeItem, costItem, codeItem, nameItem);

		setNumCols(4);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
