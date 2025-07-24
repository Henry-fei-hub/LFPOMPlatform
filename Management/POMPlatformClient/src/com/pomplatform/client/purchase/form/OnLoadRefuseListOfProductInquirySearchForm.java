package com.pomplatform.client.purchase.form;

import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.purchase.datasource.CDOnLoadRefuseListOfProductInquiry;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.IPickTreeItem;
import com.smartgwt.client.widgets.form.fields.TextItem;

public class OnLoadRefuseListOfProductInquirySearchForm extends SearchForm {

	private final TextItem processTypeItem;
	private final TextItem processStatusItem;
	private final TextItem createEmployeeIdItem;
	private final TextItem majorTitleItem;
	private final TextItem employeeNoItem;
	private final TextItem employeeNameItem;
	private final IPickTreeItem departmentIdItem;

	public OnLoadRefuseListOfProductInquirySearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDOnLoadRefuseListOfProductInquiry.getInstance());

		processTypeItem = new TextItem("processType", "流程类型");
		processTypeItem.hide();
		processStatusItem = new TextItem("processStatus", "流程状态");
		processStatusItem.hide();

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
		setItems(processTypeItem, processStatusItem, createEmployeeIdItem, majorTitleItem, employeeNoItem,
				employeeNameItem, departmentIdItem);

		setNumCols(6);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
