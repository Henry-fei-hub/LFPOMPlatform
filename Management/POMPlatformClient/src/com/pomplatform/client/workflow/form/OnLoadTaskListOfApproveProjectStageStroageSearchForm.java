package com.pomplatform.client.workflow.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.workflow.datasource.CDOnLoadTaskListOfApproveProjectStageStroage;

public class OnLoadTaskListOfApproveProjectStageStroageSearchForm extends SearchForm
{


	private final TextItem statusItem;
	private final TextItem processTypeItem;
	private final TextItem employeeIdItem;
	private final TextItem employeeNameItem;
	private final TextItem employeeNoItem;

	public OnLoadTaskListOfApproveProjectStageStroageSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDOnLoadTaskListOfApproveProjectStageStroage.getInstance());
		statusItem = new TextItem("status", "状态");
		statusItem.hide();
		processTypeItem = new TextItem("processType", "流程类型");
		processTypeItem.hide();
		employeeIdItem = new TextItem("employeeId", "处理人");
		employeeIdItem.hide();
		employeeNameItem = new TextItem("employeeName", "员工姓名");
		employeeNoItem = new TextItem("employeeNo", "员工编号");

		setItems(statusItem, processTypeItem, employeeIdItem, employeeNameItem, employeeNoItem);

		setNumCols(10);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
