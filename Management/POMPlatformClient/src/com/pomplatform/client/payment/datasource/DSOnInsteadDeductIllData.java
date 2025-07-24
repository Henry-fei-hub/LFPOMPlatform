package com.pomplatform.client.payment.datasource;

import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.smartgwt.client.data.fields.DataSourceBooleanField;
import com.smartgwt.client.data.fields.DataSourceDateField;
import com.smartgwt.client.data.fields.DataSourceFloatField;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;
import com.smartgwt.client.types.TextMatchStyle;
import com.smartgwt.client.widgets.form.fields.ComboBoxItem;

public class DSOnInsteadDeductIllData extends DBDataSource
{


	public static DSOnInsteadDeductIllData instance = null;

	public static DSOnInsteadDeductIllData getInstance() {
		if(instance == null) {
			instance = new DSOnInsteadDeductIllData("DSOnInsteadDeductIllData");
		}
		return instance;
	}

	private final DataSourceIntegerField salaryInsteadDeductIllIdField;
	private final DataSourceTextField employeeIdField;
	private final DataSourceTextField employeeNoField;
	private final DataSourceTextField employeeNameField;
	private final DataSourceTextField companyIdField;
	private final DataSourceTextField plateIdField;
	private final DataSourceTextField departmentIdField;
	private final DataSourceDateField recordDateField;
	private final DataSourceFloatField insteadDeductIllField;
	private final DataSourceBooleanField isSendedField;

	public DSOnInsteadDeductIllData(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("OnInsteadDeductIllData");


		salaryInsteadDeductIllIdField = new DataSourceIntegerField("salaryInsteadDeductIllId", "主键编码");
		salaryInsteadDeductIllIdField.setLength(11);
		salaryInsteadDeductIllIdField.setPrimaryKey(true);
		salaryInsteadDeductIllIdField.setRequired(true);
		salaryInsteadDeductIllIdField.setHidden(true);


		employeeIdField = new DataSourceTextField("employeeId", "员工姓名");
		employeeIdField.setLength(11);
		employeeIdField.setRequired(true);
		employeeIdField.setHidden(false);
		ComboBoxItem employeeIdItem = new ComboBoxItem("employeeId");
		employeeIdItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		employeeIdItem.setChangeOnKeypress(false);
		employeeIdField.setEditorProperties(employeeIdItem);
		employeeIdField.setValueMap(KeyValueManager.getValueMap("employees"));


		employeeNoField = new DataSourceTextField("employeeNo", "员工编号");
		employeeNoField.setLength(64);
		employeeNoField.setRequired(false);
		employeeNoField.setHidden(false);
		employeeNoField.setCanEdit(false);


		employeeNameField = new DataSourceTextField("employeeName", "员工姓名");
		employeeNameField.setLength(64);
		employeeNameField.setRequired(false);
		employeeNameField.setHidden(true);


		companyIdField = new DataSourceTextField("companyId", "归属公司");
		companyIdField.setLength(11);
		companyIdField.setRequired(false);
		companyIdField.setHidden(false);
		companyIdField.setCanEdit(false);
		companyIdField.setValueMap(KeyValueManager.getValueMap("company_records"));


		plateIdField = new DataSourceTextField("plateId", "业务部门");
		plateIdField.setLength(11);
		plateIdField.setRequired(false);
		plateIdField.setHidden(false);
		plateIdField.setCanEdit(false);
		plateIdField.setValueMap(KeyValueManager.getValueMap("system_dictionary_1"));


		departmentIdField = new DataSourceTextField("departmentId", "归属部门");
		departmentIdField.setLength(11);
		departmentIdField.setRequired(false);
		departmentIdField.setHidden(false);
		departmentIdField.setCanEdit(false);
		departmentIdField.setValueMap(KeyValueManager.getValueMap("departments"));


		recordDateField = new DataSourceDateField("recordDate", "日期");
		recordDateField.setHidden(false);
		recordDateField.setCanEdit(true);
		recordDateField.setRequired(true);


		insteadDeductIllField = new DataSourceFloatField("insteadDeductIll", "代扣重疾");
		insteadDeductIllField.setLength(18);
		insteadDeductIllField.setDecimalPad(2);
		insteadDeductIllField.setFormat("#,###,###,###,###,##0.00");
		insteadDeductIllField.setRequired(true);
		insteadDeductIllField.setHidden(false);


		isSendedField = new DataSourceBooleanField("isSended", "是否发放");
		isSendedField.setRequired(false);
		isSendedField.setHidden(false);
		isSendedField.setCanEdit(false);


		setFields(salaryInsteadDeductIllIdField, employeeNoField, employeeIdField, employeeNameField, companyIdField, plateIdField, departmentIdField, recordDateField, insteadDeductIllField, isSendedField);
	}


}

