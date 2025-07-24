package com.pomplatform.client.workflow.personnel.form;

import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.IPickTreeItem;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.TextItem;

public class MyAuditListOfPersonnelSearchForm extends SearchForm
{


	private final SelectItem processTypeItem;
	private final SelectItem employeeIdItem;
	private final SelectItem companyIdItem;
	private final TextItem employeeNameItem;
	private final TextItem employeeNoItem;
	private final IPickTreeItem departmentIdItem;
	private final SelectItem statusItem;

	public MyAuditListOfPersonnelSearchForm() {
		setWidth100();
		setHeight100();
		
		processTypeItem = new SelectItem("processType", "流程类型");
		processTypeItem.hide();
		
		employeeIdItem = new SelectItem("employeeId", "处理人");
		employeeIdItem.hide();
		
		companyIdItem = new SelectItem("companyId", "归属公司");
		companyIdItem.hide();
		
		employeeNameItem = new TextItem("employeeName", "员工姓名");
		employeeNameItem.setWidth("*");
		employeeNoItem = new TextItem("employeeNo", "工号");
		employeeNoItem.setWidth("*");
		
		departmentIdItem = new IPickTreeItem("departmentId", "部门");
		departmentIdItem.setCanSelectParentItems(true);
		departmentIdItem.setWidth("*");
		departmentIdItem.setValueField("treeId");
		departmentIdItem.setValueTree(KeyValueManager.getTree("departments"));
		
		statusItem = new SelectItem("status", "状态");
		statusItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_38"));
		statusItem.setWidth("*");

		setItems(processTypeItem, employeeIdItem, companyIdItem, employeeNameItem, employeeNoItem, departmentIdItem, statusItem);

		setNumCols(9);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
