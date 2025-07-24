package com.pomplatform.client.workflow.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.types.TextMatchStyle;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.workflow.datasource.CDOnLoadAttentionListOfApproveProjectStageStroage;

public class OnLoadAttentionListOfApproveProjectStageStroageSearchForm extends SearchForm
{


	private final TextItem statusItem;
	private final TextItem processTypeItem;
	private final SelectItem employeeIdItem;
	private final TextItem employeeNameItem;
	private final TextItem employeeNoItem;
	private final TextItem projectNameItem;
	private final ComboBoxItem plateIdItem;

	public OnLoadAttentionListOfApproveProjectStageStroageSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDOnLoadAttentionListOfApproveProjectStageStroage.getInstance());
		statusItem = new TextItem("status", "状态");
		statusItem.hide();
		statusItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_39"));
		processTypeItem = new TextItem("processType", "流程类型");
		processTypeItem.hide();
		employeeIdItem = new SelectItem("employeeId", "申请人");
		employeeIdItem.hide();
		employeeIdItem.setValueMap(KeyValueManager.getValueMap("employees"));
		employeeNameItem = new TextItem("employeeName", "员工姓名");
		employeeNameItem.setWidth("*");
		employeeNameItem.hide();
		employeeNoItem = new TextItem("employeeNo", "员工编号");
		employeeNoItem.setWidth("*");
		employeeNoItem.hide();
		projectNameItem = new TextItem("projectName", "项目名称");
		projectNameItem.setWidth("*");
		plateIdItem = new ComboBoxItem("plateId", "业务部门");
		plateIdItem.setWidth("*");
		plateIdItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		plateIdItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_1"));	

		setItems(statusItem, processTypeItem, employeeIdItem, projectNameItem, plateIdItem, employeeNameItem, employeeNoItem);


		setNumCols(10);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
