package com.pomplatform.client.workflow.contractstatus.form;

import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.management.datasource.DSSelectGridEmployeeValue;
import com.pomplatform.client.workflow.contractstatus.datasource.CDAttentionListOfChangeContractStatus;
import com.smartgwt.client.types.TextMatchStyle;
import com.smartgwt.client.types.TitleOrientation;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.ComboBoxItem;
import com.smartgwt.client.widgets.form.fields.FormItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.grid.ListGridField;

public class AttentionListOfChangeContractStatusSearchForm extends SearchForm
{


	private final TextItem statusItem;
	private final TextItem processTypeItem;
	private final TextItem employeeIdItem;
	private final ComboBoxItem operatorItem;
	private final TextItem contentItem;
	private final TextItem contractCodeItem;
	private final TextItem contractNameItem;

	public AttentionListOfChangeContractStatusSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDAttentionListOfChangeContractStatus.getInstance());
		statusItem = new TextItem("status", "状态");
		statusItem.hide();
		
		processTypeItem = new TextItem("processType", "流程类型");
		processTypeItem.hide();
		
		employeeIdItem = new TextItem("employeeId", "处理人");
		employeeIdItem.hide();
		
		ListGridField employeeIdField = new ListGridField("employeeId");
		ListGridField employeeNoField = new ListGridField("employeeNo");
		ListGridField employeeNameField = new ListGridField("employeeName");
		ListGridField departmentIdField = new ListGridField("departmentId");
		KeyValueManager.loadValueMap("all_departments",departmentIdField);
		
        operatorItem = new ComboBoxItem("operator", "发起者");
        operatorItem.setTitleOrientation(TitleOrientation.TOP);
        operatorItem.setOptionDataSource(DSSelectGridEmployeeValue.getInstance());
        operatorItem.setChangeOnKeypress(false);
        operatorItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
        operatorItem.setValueField(employeeIdField.getName());
        operatorItem.setDisplayField(employeeNameField.getName());
        operatorItem.setPickListFields(departmentIdField, employeeNoField, employeeNameField);
        operatorItem.setPickListWidth(500);
		
		contentItem = new TextItem("content", "原因");
		
		contractCodeItem = new TextItem("contractCode", "合同编号");
		
		contractNameItem = new TextItem("contractName", "合同名称");

		setItems(statusItem, processTypeItem, employeeIdItem, contractCodeItem, contractNameItem, operatorItem, contentItem);

		setNumCols(4);
		
		FormItem[] items = getFields();
		for(FormItem item : items) {
			item.setWidth("*");
		}
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
