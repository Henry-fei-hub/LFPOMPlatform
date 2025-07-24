package com.pomplatform.client.payment.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.smartgwt.client.types.TextMatchStyle;
import com.smartgwt.client.widgets.form.fields.ComboBoxItem;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSOnReplacementTaxData extends DBDataSource
{


	public static DSOnReplacementTaxData instance = null;

	public static DSOnReplacementTaxData getInstance() {
		if(instance == null) {
			instance = new DSOnReplacementTaxData("DSOnReplacementTaxData");
		}
		return instance;
	}

	private final DataSourceIntegerField replacementTaxIdField;
	private final DataSourceIntegerField employeeIdField;
	private final DataSourceTextField employeeNoField;
	private final DataSourceTextField employeeNameField;
	private final DataSourceIntegerField companyIdField;
	private final DataSourceIntegerField plateIdField;
	private final DataSourceIntegerField departmentIdField;
	private final DataSourceDateField recordDateField;
	private final DataSourceTextField replacementTaxField;
	private final DataSourceBooleanField isSendedField;

	public DSOnReplacementTaxData(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("OnReplacementTaxData");


		replacementTaxIdField = new DataSourceIntegerField("replacementTaxId", "主键编码");
		replacementTaxIdField.setLength(11);
		replacementTaxIdField.setRequired(true);
		replacementTaxIdField.setHidden(true);


		employeeIdField = new DataSourceIntegerField("employeeId", "员工姓名");
		employeeIdField.setLength(11);
		employeeIdField.setRequired(false);
		employeeIdField.setHidden(false);
		ComboBoxItem employeeIdItem = new ComboBoxItem("employeeId");
		employeeIdItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		employeeIdItem.setChangeOnKeypress(false);
		employeeIdField.setEditorProperties(employeeIdItem);
		employeeIdField.setValueMap(KeyValueManager.getValueMap("employees"));


		employeeNoField = new DataSourceTextField("employeeNo", "员工编号");
		employeeNoField.setLength(64);
		employeeNoField.setRequired(true);
		employeeNoField.setHidden(false);


		employeeNameField = new DataSourceTextField("employeeName", "员工姓名");
		employeeNameField.setLength(64);
		employeeNameField.setRequired(true);
		employeeNameField.setHidden(true);


		companyIdField = new DataSourceIntegerField("companyId", "归属公司");
		companyIdField.setLength(11);
		companyIdField.setRequired(false);
		companyIdField.setHidden(false);
		companyIdField.setValueMap(KeyValueManager.getValueMap("company_records"));


		plateIdField = new DataSourceIntegerField("plateId", "业务部门");
		plateIdField.setLength(11);
		plateIdField.setRequired(false);
		plateIdField.setHidden(false);
		plateIdField.setValueMap(KeyValueManager.getValueMap("system_dictionary_1"));


		departmentIdField = new DataSourceIntegerField("departmentId", "部门");
		departmentIdField.setLength(11);
		departmentIdField.setRequired(false);
		departmentIdField.setHidden(false);
		departmentIdField.setValueMap(KeyValueManager.getValueMap("departments"));


		recordDateField = new DataSourceDateField("recordDate", "日期");
		recordDateField.setRequired(false);
		recordDateField.setHidden(false);


		replacementTaxField = new DataSourceTextField("replacementTax", "补发个税");
		replacementTaxField.setLength(18);
		replacementTaxField.setDecimalPad(2);
		replacementTaxField.setFormat("#,###,###,###,###,##0.00");
		replacementTaxField.setRequired(false);
		replacementTaxField.setHidden(false);


		isSendedField = new DataSourceBooleanField("isSended", "是否发放");
		isSendedField.setRequired(false);
		isSendedField.setHidden(false);


		setFields(replacementTaxIdField, employeeIdField, employeeNoField, employeeNameField, companyIdField, plateIdField, departmentIdField, recordDateField, replacementTaxField, isSendedField);
	}


}

