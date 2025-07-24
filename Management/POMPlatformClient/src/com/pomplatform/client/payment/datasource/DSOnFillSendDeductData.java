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

public class DSOnFillSendDeductData extends DBDataSource
{


	public static DSOnFillSendDeductData instance = null;

	public static DSOnFillSendDeductData getInstance() {
		if(instance == null) {
			instance = new DSOnFillSendDeductData("DSOnFillSendDeductData");
		}
		return instance;
	}

	private final DataSourceIntegerField salaryFillSendDeductIdField;
	private final DataSourceTextField employeeIdField;
	private final DataSourceTextField employeeNoField;
	private final DataSourceTextField employeeNameField;
	private final DataSourceTextField companyIdField;
	private final DataSourceTextField plateIdField;
	private final DataSourceTextField departmentIdField;
	private final DataSourceDateField recordDateField;
	private final DataSourceFloatField fillFiveInsuranceOneGoldsField;
	private final DataSourceFloatField moreDeductTaxField;
	private final DataSourceFloatField fillTaxField;
	private final DataSourceFloatField totalAmountField;
	private final DataSourceBooleanField isSendedField;
	private final DataSourceTextField remarkField;

	public DSOnFillSendDeductData(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("OnFillSendDeductData");

		salaryFillSendDeductIdField = new DataSourceIntegerField("salaryFillSendDeductId", "主键编码");
		salaryFillSendDeductIdField.setLength(11);
		salaryFillSendDeductIdField.setPrimaryKey(true);
		salaryFillSendDeductIdField.setRequired(true);
		salaryFillSendDeductIdField.setHidden(true);


		employeeNoField = new DataSourceTextField("employeeNo", "员工编号");
		employeeNoField.setLength(64);
		employeeNoField.setHidden(false);
		employeeNoField.setCanEdit(false);
		
		employeeIdField = new DataSourceTextField("employeeId", "员工姓名");
		employeeIdField.setLength(11);
		employeeIdField.setRequired(true);
		employeeIdField.setHidden(false);
		ComboBoxItem employeeIdItem = new ComboBoxItem("employeeId");
		employeeIdItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		employeeIdItem.setChangeOnKeypress(false);
		employeeIdField.setEditorProperties(employeeIdItem);
		employeeIdField.setValueMap(KeyValueManager.getValueMap("employees"));

		employeeNameField = new DataSourceTextField("employeeName", "员工姓名");
		employeeNameField.setLength(64);
		employeeNameField.setHidden(true);
		employeeNameField.setCanEdit(true);

		companyIdField = new DataSourceTextField("companyId", "归属公司");
		companyIdField.setLength(11);
		companyIdField.setHidden(false);
		companyIdField.setValueMap(KeyValueManager.getValueMap("company_records"));
		companyIdField.setCanEdit(false);

		plateIdField = new DataSourceTextField("plateId", "业务部门");
		plateIdField.setLength(11);
		plateIdField.setHidden(false);
		plateIdField.setValueMap(KeyValueManager.getValueMap("system_dictionary_1"));
		plateIdField.setCanEdit(false);


		departmentIdField = new DataSourceTextField("departmentId", "归属部门");
		departmentIdField.setLength(11);
		departmentIdField.setHidden(false);
		departmentIdField.setValueMap(KeyValueManager.getValueMap("departments"));
		departmentIdField.setCanEdit(false);

		recordDateField = new DataSourceDateField("recordDate", "日期");
		recordDateField.setHidden(false);
		recordDateField.setCanEdit(true);
		recordDateField.setRequired(true);

		fillFiveInsuranceOneGoldsField = new DataSourceFloatField("fillFiveInsuranceOneGolds", "填平五险一金");
		fillFiveInsuranceOneGoldsField.setLength(18);
		fillFiveInsuranceOneGoldsField.setDecimalPad(2);
		fillFiveInsuranceOneGoldsField.setFormat("#,###,###,###,###,##0.00");
		fillFiveInsuranceOneGoldsField.setRequired(true);
		fillFiveInsuranceOneGoldsField.setHidden(false);


		moreDeductTaxField = new DataSourceFloatField("moreDeductTax", "多扣个税");
		moreDeductTaxField.setLength(18);
		moreDeductTaxField.setDecimalPad(2);
		moreDeductTaxField.setFormat("#,###,###,###,###,##0.00");
		moreDeductTaxField.setRequired(true);
		moreDeductTaxField.setHidden(false);


		fillTaxField = new DataSourceFloatField("fillTax", "填平个税");
		fillTaxField.setLength(18);
		fillTaxField.setDecimalPad(2);
		fillTaxField.setFormat("#,###,###,###,###,##0.00");
		fillTaxField.setRequired(true);
		fillTaxField.setHidden(false);


		totalAmountField = new DataSourceFloatField("totalAmount", "合计");
		totalAmountField.setLength(18);
		totalAmountField.setDecimalPad(2);
		totalAmountField.setFormat("#,###,###,###,###,##0.00");
		totalAmountField.setHidden(false);

		isSendedField = new DataSourceBooleanField("isSended", "是否发放");
		isSendedField.setRequired(false);
		isSendedField.setHidden(false);
		isSendedField.setCanEdit(false);
		
		remarkField = new DataSourceTextField("remark", "备注");
		remarkField.setLength(64);
		remarkField.setHidden(false);
		remarkField.setCanEdit(true);
		

		setFields(salaryFillSendDeductIdField, employeeNoField,employeeIdField, employeeNameField, companyIdField, plateIdField, departmentIdField, recordDateField, fillFiveInsuranceOneGoldsField, moreDeductTaxField, fillTaxField, totalAmountField, isSendedField,remarkField);
	}


}

