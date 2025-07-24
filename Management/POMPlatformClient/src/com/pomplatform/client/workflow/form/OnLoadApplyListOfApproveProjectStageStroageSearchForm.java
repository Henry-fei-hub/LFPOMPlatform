package com.pomplatform.client.workflow.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.workflow.datasource.CDOnLoadApplyListOfApproveProjectStageStroage;

public class OnLoadApplyListOfApproveProjectStageStroageSearchForm extends SearchForm
{


	private final TextItem employeeIdItem;
	private final TextItem processTypeItem;
	private final TextItem projectIdItem;
	private final TextItem departmentManagerIdItem;
	private final TextItem projectManageIdItem;
	private final TextItem plateIdItem;
	private final TextItem projectNameItem;
	private final TextItem employeeNameItem;
	private final TextItem employeeNoItem;

	public OnLoadApplyListOfApproveProjectStageStroageSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDOnLoadApplyListOfApproveProjectStageStroage.getInstance());
		employeeIdItem = new TextItem("employeeId", "创建人");
		employeeIdItem.hide();
		processTypeItem = new TextItem("processType", "流程类型");
		processTypeItem.hide();
		projectIdItem = new TextItem("projectId", "项目主键");
		projectIdItem.hide();
		departmentManagerIdItem = new TextItem("departmentManagerId", "部门经理");
		departmentManagerIdItem.hide();
		projectManageIdItem = new TextItem("projectManageId", "专业负责人");
		projectManageIdItem.hide();
		plateIdItem = new TextItem("plateId", "业务部门");
		plateIdItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_1"));
		projectNameItem = new TextItem("projectName", "项目名称");
		employeeNameItem = new TextItem("employeeName", "员工姓名");
		employeeNameItem.hide();
		employeeNoItem = new TextItem("employeeNo", "员工编号");
		employeeNoItem.hide();

		setItems(employeeIdItem, processTypeItem, projectIdItem, departmentManagerIdItem, projectManageIdItem, plateIdItem, projectNameItem, employeeNameItem, employeeNoItem);

		setNumCols(7);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
