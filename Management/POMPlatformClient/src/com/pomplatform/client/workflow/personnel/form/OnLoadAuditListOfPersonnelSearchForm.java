package com.pomplatform.client.workflow.personnel.form;

import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.IPickTreeItem;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.TextItem;

public class OnLoadAuditListOfPersonnelSearchForm extends SearchForm
{


	private final TextItem processTypeItem;
	private final SelectItem statusItem;
	private final SelectItem employeeIdItem;
	private final SelectItem companyIdItem;
	private final TextItem employeeNameItem;
	private final TextItem employeeNoItem;
	private final IPickTreeItem departmentIdItem;

	public OnLoadAuditListOfPersonnelSearchForm() {
		setWidth100();
		setHeight100();
		processTypeItem = new TextItem("processType", "流程类型");
		processTypeItem.hide();
		statusItem = new SelectItem("status", "状态");
		statusItem.hide();
		statusItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_39"));
		employeeIdItem = new SelectItem("employeeId", "申请人");
		employeeIdItem.hide();
		employeeIdItem.setValueMap(KeyValueManager.getValueMap("employees"));
		companyIdItem = new SelectItem("companyId", "归属公司");
		companyIdItem.hide();
		companyIdItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_26"));
		employeeNameItem = new TextItem("employeeName", "职员姓名");
		employeeNameItem.setWidth("*");
		employeeNoItem = new TextItem("employeeNo", "职员编号");
		employeeNoItem.setWidth("*");
		departmentIdItem = new IPickTreeItem("departmentId", "部门");
		departmentIdItem.setCanSelectParentItems(true);
		departmentIdItem.setWidth("*");
		departmentIdItem.setValueField("treeId");
		departmentIdItem.setValueTree(KeyValueManager.getTree("departments"));

		setItems(processTypeItem, statusItem, employeeIdItem, companyIdItem, employeeNameItem, employeeNoItem, departmentIdItem);

		setNumCols(9);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
