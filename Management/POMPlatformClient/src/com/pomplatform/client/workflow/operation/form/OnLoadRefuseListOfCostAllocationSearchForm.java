package com.pomplatform.client.workflow.operation.form;

import java.util.LinkedHashMap;

import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.workflow.operation.datasource.CDOnLoadRefuseListOfCostAllocation;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.TextItem;

public class OnLoadRefuseListOfCostAllocationSearchForm extends SearchForm
{


	private final SelectItem processTypeItem;
	private final SelectItem processStatusItem;
	private final SelectItem employeeIdItem;
	private final SelectItem costTypeItem;
	private final TextItem costItem;
	private final TextItem codeItem;
	private final TextItem nameItem;

	public OnLoadRefuseListOfCostAllocationSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDOnLoadRefuseListOfCostAllocation.getInstance());
		processTypeItem = new SelectItem("processType", "流程类型");
		processTypeItem.hide();
		processTypeItem.setValueMap(KeyValueManager.getValueMap("system_process_types"));
		processStatusItem = new SelectItem("processStatus", "流程状态");
		processStatusItem.hide();
		processStatusItem.setValueMap((LinkedHashMap)getDataSource().getField("processStatus").getValueMap());
		employeeIdItem = new SelectItem("employeeId", "起草人");
		employeeIdItem.hide();
		employeeIdItem.setValueMap(KeyValueManager.getValueMap("employees"));
		costTypeItem = new SelectItem("costType", "原成本类型");
		costTypeItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_121"));
		costTypeItem.setWidth("*");
		costItem = new TextItem("cost", "成本");
		costItem.setWidth("*");
		codeItem = new TextItem("code", "编号");
		codeItem.setWidth("*");
		nameItem = new TextItem("name", "费用承担主体");
		nameItem.setWidth("*");

		setItems(processTypeItem, processStatusItem, employeeIdItem, costTypeItem, costItem, codeItem, nameItem);

		setNumCols(4);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
