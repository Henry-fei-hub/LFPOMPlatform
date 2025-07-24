package com.pomplatform.client.purchase.form;

import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.purchase.datasource.CDOnLoadAttentionListOfProductInquiry;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.IPickTreeItem;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.TextItem;

public class OnLoadAttentionListOfProductInquirySearchForm extends SearchForm {

	private final SelectItem statusItem;
	private final TextItem processTypeItem;
	private final SelectItem employeeIdItem;
	private final TextItem createEmployeeIdItem;
	private final TextItem majorTitleItem;
	private final TextItem employeeNoItem;
	private final TextItem employeeNameItem;
	private final IPickTreeItem departmentIdItem;

	public OnLoadAttentionListOfProductInquirySearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDOnLoadAttentionListOfProductInquiry.getInstance());
		statusItem = new SelectItem("status", "状态");
		statusItem.hide();
		statusItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_39"));
		processTypeItem = new TextItem("processType", "流程类型");
		processTypeItem.hide();
		employeeIdItem = new SelectItem("employeeId", "处理人");
		employeeIdItem.hide();
		employeeIdItem.setValueMap(KeyValueManager.getValueMap("employees"));

		createEmployeeIdItem = new TextItem("createEmployeeId", "创建人");
		createEmployeeIdItem.hide();

		majorTitleItem = new TextItem("majorTitle", "主题");
		majorTitleItem.setWidth("*");

		employeeNoItem = new TextItem("employeeNo", "申请人工号");
		employeeNoItem.setWidth("*");

		employeeNameItem = new TextItem("employeeName", "员工姓名");
		employeeNameItem.setWidth("*");

		departmentIdItem = new IPickTreeItem("departmentId", "部门");
		departmentIdItem.setCanSelectParentItems(true);
		departmentIdItem.setWidth("*");
		departmentIdItem.setValueField("treeId");
		departmentIdItem.setValueTree(KeyValueManager.getTree("departments"));

		setItems(statusItem, processTypeItem, employeeIdItem, createEmployeeIdItem, majorTitleItem, employeeNoItem,
				employeeNameItem, departmentIdItem);

		setNumCols(6);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
