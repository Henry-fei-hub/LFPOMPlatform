package com.pomplatform.client.workflow.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.types.TextMatchStyle;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.workflow.datasource.CDOnLoadRefuseListOfApproveProjectStageStroage;

public class OnLoadRefuseListOfApproveProjectStageStroageSearchForm extends SearchForm
{


	private final TextItem processTypeItem;
	private final TextItem processStatusItem;
	private final TextItem employeeNameItem;
	private final TextItem employeeNoItem;
	private final TextItem projectNameItem;
	private final ComboBoxItem plateIdItem;

	public OnLoadRefuseListOfApproveProjectStageStroageSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDOnLoadRefuseListOfApproveProjectStageStroage.getInstance());
		processTypeItem = new TextItem("processType", "流程类型");
		processTypeItem.hide();
		processStatusItem = new TextItem("processStatus", "流程状态");
		processStatusItem.hide();
		employeeNameItem = new TextItem("employeeName", "员工姓名");
		employeeNameItem.hide();
		employeeNoItem = new TextItem("employeeNo", "员工编号");
		employeeNoItem.hide();
		projectNameItem = new TextItem("projectName", "项目名称");
		plateIdItem = new ComboBoxItem("plateId", "业务部门");
		plateIdItem.setWidth("*");
		plateIdItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		plateIdItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_32"));	

		setItems(processTypeItem, projectNameItem, plateIdItem, processStatusItem, employeeNameItem, employeeNoItem);

		setNumCols(8);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
