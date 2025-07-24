package com.pomplatform.client.payment.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.smartgwt.client.types.TextMatchStyle;
import com.smartgwt.client.widgets.form.fields.ComboBoxItem;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSOnLeaveSubsidysData extends DBDataSource
{


	public static DSOnLeaveSubsidysData instance = null;

	public static DSOnLeaveSubsidysData getInstance() {
		if(instance == null) {
			instance = new DSOnLeaveSubsidysData("DSOnLeaveSubsidysData");
		}
		return instance;
	}

	private final DataSourceIntegerField salaryLeaveSubsidyIdField;
	private final DataSourceTextField employeeIdField;
	private final DataSourceTextField employeeNoField;
	private final DataSourceTextField employeeNameField;
	private final DataSourceTextField companyIdField;
	private final DataSourceTextField plateIdField;
	private final DataSourceTextField departmentIdField;
	private final DataSourceDateField recordDateField;
	private final DataSourceFloatField noDeductTaxField;
	private final DataSourceFloatField deductTaxField;
	private final DataSourceFloatField totalAmountField;
	private final DataSourceBooleanField isSendedField;

	public DSOnLeaveSubsidysData(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("OnLeaveSubsidysData");


		salaryLeaveSubsidyIdField = new DataSourceIntegerField("salaryLeaveSubsidyId", "主键编码");
		salaryLeaveSubsidyIdField.setLength(11);
		salaryLeaveSubsidyIdField.setPrimaryKey(true);
		salaryLeaveSubsidyIdField.setRequired(true);
		salaryLeaveSubsidyIdField.setHidden(true);


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
		employeeNoField.setCanEdit(false);
		employeeNoField.setHidden(false);


		employeeNameField = new DataSourceTextField("employeeName", "员工姓名");
		employeeNameField.setLength(64);
		employeeNameField.setCanEdit(false);
		employeeNameField.setHidden(true);


		companyIdField = new DataSourceTextField("companyId", "归属公司");
		companyIdField.setLength(11);
		companyIdField.setHidden(false);
		companyIdField.setCanEdit(false);
		companyIdField.setValueMap(KeyValueManager.getValueMap("company_records"));


		plateIdField = new DataSourceTextField("plateId", "业务部门");
		plateIdField.setLength(11);
		plateIdField.setHidden(false);
		plateIdField.setCanEdit(false);
		plateIdField.setValueMap(KeyValueManager.getValueMap("system_dictionary_1"));


		departmentIdField = new DataSourceTextField("departmentId", "归属部门");
		departmentIdField.setLength(11);
		departmentIdField.setHidden(false);
		departmentIdField.setCanEdit(false);
		departmentIdField.setValueMap(KeyValueManager.getValueMap("departments"));


		recordDateField = new DataSourceDateField("recordDate", "日期");
		recordDateField.setHidden(false);
		recordDateField.setCanEdit(true);
		recordDateField.setRequired(true);


		noDeductTaxField = new DataSourceFloatField("noDeductTax", "不扣税");
		noDeductTaxField.setLength(18);
		noDeductTaxField.setDecimalPad(2);
		noDeductTaxField.setFormat("#,###,###,###,###,##0.00");
		noDeductTaxField.setRequired(true);
		noDeductTaxField.setHidden(false);


		deductTaxField = new DataSourceFloatField("deductTax", "扣税");
		deductTaxField.setLength(18);
		deductTaxField.setDecimalPad(2);
		deductTaxField.setFormat("#,###,###,###,###,##0.00");
		deductTaxField.setRequired(true);
		deductTaxField.setHidden(false);


		totalAmountField = new DataSourceFloatField("totalAmount", "合计");
		totalAmountField.setLength(18);
		totalAmountField.setDecimalPad(2);
		totalAmountField.setFormat("#,###,###,###,###,##0.00");
		totalAmountField.setHidden(false);


		isSendedField = new DataSourceBooleanField("isSended", "是否发放");
		isSendedField.setRequired(false);
		isSendedField.setHidden(false);
		isSendedField.setCanEdit(false);
		

		setFields(salaryLeaveSubsidyIdField, employeeNoField, employeeIdField, employeeNameField, companyIdField, plateIdField, departmentIdField, recordDateField, noDeductTaxField, deductTaxField, totalAmountField, isSendedField);
	}


}

