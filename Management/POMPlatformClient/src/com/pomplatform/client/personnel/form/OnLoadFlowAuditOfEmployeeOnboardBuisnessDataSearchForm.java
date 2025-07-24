package com.pomplatform.client.personnel.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.personnel.datasource.CDOnLoadFlowAuditOfEmployeeOnboardBuisnessData;

public class OnLoadFlowAuditOfEmployeeOnboardBuisnessDataSearchForm extends SearchForm
{


	private final TextItem processStatusItem;
	private final TextItem employeeIdItem;
	private final TextItem processTypeItem;
	private final TextItem companyIdItem;
	private final TextItem employeeNameItem;
	private final TextItem departmentIdItem;
	private final TextItem statusItem;

	public OnLoadFlowAuditOfEmployeeOnboardBuisnessDataSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDOnLoadFlowAuditOfEmployeeOnboardBuisnessData.getInstance());
		processStatusItem = new TextItem("processStatus", "流程状态");
		employeeIdItem = new TextItem("employeeId", "处理人");
		processTypeItem = new TextItem("processType", "流程类型");
		companyIdItem = new TextItem("companyId", "归属公司");
		employeeNameItem = new TextItem("employeeName", "员工姓名");
		departmentIdItem = new TextItem("departmentId", "部门");
		statusItem = new TextItem("status", "状态");

		setItems(processStatusItem, employeeIdItem, processTypeItem, companyIdItem, employeeNameItem, departmentIdItem, statusItem);

		setNumCols(14);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
