package com.pomplatform.client.purchase.form;

import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.purchase.datasource.CDOnLoadApplyListOfProductInquiry;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.TextItem;

public class OnLoadApplyListOfProductInquirySearchForm extends SearchForm {

	private final TextItem processTypeItem;
	private final TextItem createEmployeeIdItem;
	private final TextItem majorTitleItem;
	private final TextItem employeeNoItem;
	private final TextItem employeeNameItem;
	private final SelectItem departmentIdItem;

	public OnLoadApplyListOfProductInquirySearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDOnLoadApplyListOfProductInquiry.getInstance());
		processTypeItem = new TextItem("processType", "流程类型");
		processTypeItem.hide();
		createEmployeeIdItem = new TextItem("createEmployeeId", "创建人");
		createEmployeeIdItem.hide();
		majorTitleItem = new TextItem("majorTitle", "主题");
		majorTitleItem.setWidth("*");
		employeeNoItem = new TextItem("employeeNo", "申请人工号");
		employeeNoItem.hide();
		employeeNameItem = new TextItem("employeeName", "员工姓名");
		employeeNameItem.hide();
		departmentIdItem = new SelectItem("departmentId", "申请人部门");
		departmentIdItem.hide();
		departmentIdItem.setValueMap(KeyValueManager.getValueMap("departments"));

		setItems(processTypeItem, createEmployeeIdItem, majorTitleItem, employeeNoItem, employeeNameItem,
				departmentIdItem);

		setNumCols(6);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
