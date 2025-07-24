package com.pomplatform.client.employeechangeplaterecord.form;

import java.util.logging.Logger;

import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractWizadPage;
import com.pomplatform.client.employeechangeplaterecord.datasource.DSMemployeechangeplaterecordeeepyseor;
import com.smartgwt.client.types.TextMatchStyle;
import com.smartgwt.client.widgets.form.ValuesManager;
import com.smartgwt.client.widgets.form.fields.ComboBoxItem;
import com.smartgwt.client.widgets.form.fields.IPickTreeItem;
import com.smartgwt.client.widgets.form.fields.IntegerItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.form.validator.IsIntegerValidator;

public class EmployeeChangePlateUpdateForm extends AbstractWizadPage
{

	private final Logger __logger = Logger.getLogger("");
	private final IntegerItem employeeChangePlateRecordIdItem;
	private final TextItem employeeNoItem;
	private final ComboBoxItem employeeIdItem;
	private final IntegerItem yearItem;
	private final IntegerItem monthItem;
	private final ComboBoxItem plateIdItem;
	private final IPickTreeItem departmentIdItem;

	public EmployeeChangePlateUpdateForm() {
		DSMemployeechangeplaterecordeeepyseor ds = DSMemployeechangeplaterecordeeepyseor.getInstance();
		__form.setWidth100();
		__form.setHeight100();
		__form.setPadding(1);
		__form.setMargin(1);
		
		employeeChangePlateRecordIdItem = new IntegerItem("employeeChangePlateRecordId", "主键编码");
		employeeChangePlateRecordIdItem.setDisabled(true);
		employeeChangePlateRecordIdItem.setRequired(true);
		employeeChangePlateRecordIdItem.hide();
		IsIntegerValidator employeeChangePlateRecordIdValidator = new IsIntegerValidator();
		employeeChangePlateRecordIdItem.setValidators(employeeChangePlateRecordIdValidator);
		__formItems.add(employeeChangePlateRecordIdItem);
		
		employeeNoItem = new TextItem("employeeNo", "工号");
		employeeNoItem.setDisabled(true);
		employeeNoItem.setWidth("*");
		__formItems.add(employeeNoItem);
		
		employeeIdItem = new ComboBoxItem("employeeId", "姓名");
		employeeIdItem.setWidth("*");
		employeeIdItem.setDisabled(true);
		employeeIdItem.setDefaultValue(ClientUtil.getEmployeeId());
		employeeIdItem.setValueMap(KeyValueManager.getValueMap("employees"));
		__formItems.add(employeeIdItem);
		
		yearItem = new IntegerItem("year","年份");
		yearItem.setWidth("*");
		yearItem.setDisabled(true);
		__formItems.add(yearItem);
		
		monthItem = new IntegerItem("month","月份");
		monthItem.setWidth("*");
		monthItem.setDisabled(true);
		__formItems.add(monthItem);
		
		plateIdItem = new ComboBoxItem("plateId", "业务部门");
		plateIdItem.setWidth("*");
		plateIdItem.setColSpan(4);
		plateIdItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		plateIdItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_1"));
		__formItems.add(plateIdItem);
		
		departmentIdItem = new IPickTreeItem("departmentId", "当前归属部门");
        departmentIdItem.setWidth("*");
        departmentIdItem.setValueField("treeId");
        departmentIdItem.setCanSelectParentItems(true);
        departmentIdItem.setValueTree(KeyValueManager.getTree("departments"));
		__formItems.add(departmentIdItem);
		
		
		__form.setItems(getFormItemArray());
		__form.setDataSource(ds);
		__form.setNumCols(4);
		__form.setBackgroundColor("#e2e2e2");
		ClientUtil.DynamicFormProcessAccordingToDevice(__form);
		addMember(__form);
	}

	@Override
	public boolean checkData() {
		return true;
	}

	@Override
	public void startEdit() {
		if(getRecord() != null) __form.editRecord(getRecord());
		else __form.editNewRecord();
	}

	@Override
	public void setValueManage(ValuesManager manager) {
		manager.setDataSource(DSMemployeechangeplaterecordeeepyseor.getInstance());
		manager.addMember(__form);
	}

	@Override
	public java.util.Map getValuesAsMap() {
		return __form.getValues();
	}
	
}