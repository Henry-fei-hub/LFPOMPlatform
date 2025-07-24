package com.pomplatform.client.workflow.form;

import java.util.Date;

import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.management.datasource.DSSelectGridEmployeeValue;
import com.pomplatform.client.workflow.datasource.CDUpdateActivityEmployee;
import com.smartgwt.client.data.Criteria;
import com.smartgwt.client.types.TextMatchStyle;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.ComboBoxItem;
import com.smartgwt.client.widgets.form.fields.DateTimeItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.smartgwt.client.widgets.grid.ListGridField;

public class UpdateActivityEmployeeSearchForm extends SearchForm
{


	private final ComboBoxItem processTypeItem;
	private final ComboBoxItem drafterItem;
	private final ComboBoxItem employeeIdItem;
	private final TextItem businessNameItem;
	private final DateTimeItem createTimeStartItem;
	private final DateTimeItem createTimeEndItem;

	public UpdateActivityEmployeeSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDUpdateActivityEmployee.getInstance());
		
		processTypeItem = new ComboBoxItem("processType", "流程类型");
		processTypeItem.setValueMap(KeyValueManager.getValueMap("system_process_types"));
		processTypeItem.setChangeOnKeypress(false);
		processTypeItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		processTypeItem.setWidth("*");
		
		ListGridField employeeIdField = new ListGridField("employeeId");
		ListGridField employeeNoField = new ListGridField("employeeNo");
		ListGridField employeeNameField = new ListGridField("employeeName");
		ListGridField departmentIdField = new ListGridField("departmentId");
		KeyValueManager.loadValueMap("all_departments",departmentIdField);
        
		drafterItem = new ComboBoxItem("drafter", "发起人");
		drafterItem.setValueMap(KeyValueManager.getValueMap("employees"));
		drafterItem.setOptionDataSource(DSSelectGridEmployeeValue.getInstance());
        drafterItem.setChangeOnKeypress(false);
        drafterItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
        drafterItem.setValueField(employeeIdField.getName());
        drafterItem.setDisplayField(employeeNameField.getName());
        drafterItem.setPickListFields(departmentIdField, employeeNoField, employeeNameField);
        drafterItem.setPickListWidth(500);
        drafterItem.setWidth("*");
        
        employeeIdItem = new ComboBoxItem("employeeId", "节点审批人");
        employeeIdItem.setValueMap(KeyValueManager.getValueMap("employees"));
        employeeIdItem.setOptionDataSource(DSSelectGridEmployeeValue.getInstance());
        employeeIdItem.setChangeOnKeypress(false);
        employeeIdItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
        employeeIdItem.setValueField(employeeIdField.getName());
        employeeIdItem.setDisplayField(employeeNameField.getName());
        employeeIdItem.setPickListFields(departmentIdField, employeeNoField, employeeNameField);
        employeeIdItem.setPickListWidth(500);
        employeeIdItem.setWidth("*");
		
		businessNameItem = new TextItem("businessName", "摘要");
		businessNameItem.setWidth("*");
		
		createTimeStartItem = new DateTimeItem("createTimeStart", "创建时间（开始）");
		createTimeStartItem.setWidth("*");
		createTimeStartItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				Date val = (Date) event.getValue();
				ClientUtil.searchDateFormat(val, createTimeStartItem);
			}
		});
		
		createTimeEndItem = new DateTimeItem("createTimeEnd", "创建时间（截止）");
		createTimeEndItem.setWidth("*");
		createTimeEndItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				Date val = (Date) event.getValue();
				ClientUtil.searchDateFormat(val, createTimeEndItem);
			}
		});

		setItems(processTypeItem, drafterItem, employeeIdItem, businessNameItem, createTimeStartItem, createTimeEndItem);

		setNumCols(6);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
