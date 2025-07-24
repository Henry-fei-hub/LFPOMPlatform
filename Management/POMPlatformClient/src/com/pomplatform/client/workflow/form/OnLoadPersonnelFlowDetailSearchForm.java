package com.pomplatform.client.workflow.form;

import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.workflow.datasource.CDOnLoadPersonnelFlowDetail;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.IPickTreeItem;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.TextItem;

public class OnLoadPersonnelFlowDetailSearchForm extends SearchForm
{


	private final SelectItem employeeIdItem;
	private final TextItem parentProcessTypeIdItem;
	private final TextItem activityTypeItem;
	private final TextItem processTypeItem;
	private final TextItem employeeNameItem;
	private final TextItem employeeNoItem;
	private final IPickTreeItem departmentIdItem;

	public OnLoadPersonnelFlowDetailSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDOnLoadPersonnelFlowDetail.getInstance());
		employeeIdItem = new SelectItem("employeeId", "人员");
		employeeIdItem.hide();
		employeeIdItem.setValueMap(KeyValueManager.getValueMap("employees"));
		parentProcessTypeIdItem = new TextItem("parentProcessTypeId", "父级类型");
		parentProcessTypeIdItem.hide();
		activityTypeItem = new TextItem("activityType", "事件类型");
		activityTypeItem.hide();
		processTypeItem = new TextItem("processType", "流程类型");
		processTypeItem.hide();
		
		employeeNameItem = new TextItem("employeeName", "员工姓名");
		employeeNameItem.setWidth("*");
		employeeNoItem = new TextItem("employeeNo", "工号");
		employeeNoItem.setWidth("*");
		departmentIdItem = new IPickTreeItem("departmentId", "部门");
		departmentIdItem.setCanSelectParentItems(true);
		departmentIdItem.setWidth("*");
		departmentIdItem.setValueField("treeId");
		departmentIdItem.setValueTree(KeyValueManager.getTree("departments"));

		setItems(employeeIdItem, parentProcessTypeIdItem, activityTypeItem, processTypeItem, employeeNameItem, employeeNoItem, departmentIdItem);

		setNumCols(7);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
