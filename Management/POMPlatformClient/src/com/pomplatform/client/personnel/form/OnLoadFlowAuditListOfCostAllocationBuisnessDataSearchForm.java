package com.pomplatform.client.personnel.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.personnel.datasource.CDOnLoadFlowAuditListOfCostAllocationBuisnessData;
import com.pomplatform.client.workflow.operation.datasource.CDOnLoadAuditListOfCostAllocation;

public class OnLoadFlowAuditListOfCostAllocationBuisnessDataSearchForm extends SearchForm
{


	private final TextItem processStatusItem;
	private final SelectItem employeeIdItem;
	private final SelectItem processTypeItem;
//	private final TextItem companyIdItem;
//	private final TextItem departmentIdItem;
	private final SelectItem statusItem;
	private final TextItem codeItem;
	private final TextItem nameItem;
	private final TextItem costItem;
	private final SelectItem costTypeItem;

	public OnLoadFlowAuditListOfCostAllocationBuisnessDataSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDOnLoadFlowAuditListOfCostAllocationBuisnessData.getInstance());
		
		processStatusItem = new TextItem("processStatus", "");
		processStatusItem.hide();
		
		processTypeItem = new SelectItem("processType", "流程类型");
		processTypeItem.setValueMap(KeyValueManager.getValueMap("system_process_types"));
		processTypeItem.hide();
		statusItem = new SelectItem("status", "状态");
		statusItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_16"));
		statusItem.hide();
		employeeIdItem = new SelectItem("employeeId", "处理人");
		employeeIdItem.setValueMap(KeyValueManager.getValueMap("employees"));
		employeeIdItem.hide();
		codeItem = new TextItem("code", "编号");
		codeItem.setWidth("*");
		nameItem = new TextItem("name", "费用承担主体");
		nameItem.setWidth("*");
		costItem = new TextItem("cost", "成本");
		costItem.setWidth("*");
		costTypeItem = new SelectItem("costType", "原成本类型");
		costTypeItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_121"));
		costTypeItem.setWidth("*");

		setItems(processTypeItem, statusItem, employeeIdItem, costTypeItem, costItem, codeItem, nameItem);

		setNumCols(4);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
