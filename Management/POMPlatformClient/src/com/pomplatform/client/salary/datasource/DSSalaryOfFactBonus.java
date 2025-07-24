package com.pomplatform.client.salary.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.smartgwt.client.types.TextMatchStyle;
import com.smartgwt.client.widgets.form.fields.ComboBoxItem;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSSalaryOfFactBonus extends DBDataSource
{


	public static DSSalaryOfFactBonus instance = null;

	public static DSSalaryOfFactBonus getInstance() {
		if(instance == null) {
			instance = new DSSalaryOfFactBonus("DSSalaryOfFactBonus");
		}
		return instance;
	}

	private final DataSourceIntegerField salaryOfBonusIdField;
	private final DataSourceTextField employeeIdField;
	private final DataSourceTextField employeeNoField;
	private final DataSourceTextField employeeNameField;
	private final DataSourceTextField ownedCompanyField;
	private final DataSourceTextField plateIdField;
	private final DataSourceTextField departmentIdField;
	private final DataSourceTextField statusField;
	private final DataSourceTextField onboardStatusField;
	private final DataSourceDateField recordDateField;
	private final DataSourceFloatField shouldBonusField;
	private final DataSourceFloatField shouldTaxField;
	private final DataSourceFloatField factBonusField;
	private final DataSourceIntegerField flagField;
	private final DataSourceBooleanField isSendedField;
	private final DataSourceDateField onboardDateField;
	private final DataSourceDateField resignationDateField;

	public DSSalaryOfFactBonus(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("SalaryOfFactBonus");


		salaryOfBonusIdField = new DataSourceIntegerField("salaryOfBonusId", "主键编码");
		salaryOfBonusIdField.setLength(11);
		salaryOfBonusIdField.setPrimaryKey(true);
		salaryOfBonusIdField.setRequired(true);
		salaryOfBonusIdField.setHidden(true);


		employeeNoField = new DataSourceTextField("employeeNo", "员工编号");
		employeeNoField.setLength(64);
		employeeNoField.setRequired(false);
		employeeNoField.setHidden(false);
		employeeNoField.setCanEdit(false);

		
		employeeIdField = new DataSourceTextField("employeeId", "员工姓名");
		employeeIdField.setLength(11);
		employeeIdField.setPrimaryKey(true);
		employeeIdField.setRequired(true);
		employeeIdField.setHidden(false);
		ComboBoxItem employeeIdItem = new ComboBoxItem("employeeId");
		employeeIdItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		employeeIdItem.setChangeOnKeypress(false);
		employeeIdField.setEditorProperties(employeeIdItem);
		employeeIdField.setValueMap(KeyValueManager.getValueMap("employees"));


		employeeNameField = new DataSourceTextField("employeeName", "员工姓名");
		employeeNameField.setLength(64);
		employeeNameField.setRequired(false);
		employeeNameField.setHidden(true);
		employeeNameField.setCanEdit(false);


		ownedCompanyField = new DataSourceTextField("companyId", "所属公司");
		ownedCompanyField.setLength(64);
		ownedCompanyField.setRequired(false);
		ownedCompanyField.setHidden(false);
		ownedCompanyField.setValueMap(KeyValueManager.getValueMap("company_records"));
		ownedCompanyField.setCanEdit(false);


		plateIdField = new DataSourceTextField("plateId", "业务部门");
		plateIdField.setLength(11);
		plateIdField.setRequired(false);
		plateIdField.setHidden(false);
		plateIdField.setValueMap(KeyValueManager.getValueMap("plate_records"));
		plateIdField.setCanEdit(false);


		departmentIdField = new DataSourceTextField("departmentId", "所属部门");
		departmentIdField.setLength(11);
		departmentIdField.setRequired(false);
		departmentIdField.setHidden(false);
		departmentIdField.setValueMap(KeyValueManager.getValueMap("departments"));
		departmentIdField.setCanEdit(false);


		statusField = new DataSourceTextField("status", "在职状态");
		statusField.setLength(11);
		statusField.setRequired(false);
		statusField.setHidden(false);
		statusField.setValueMap(KeyValueManager.getValueMap("system_dictionary_11"));
		statusField.setCanEdit(false);
		
		
		onboardStatusField = new DataSourceTextField("onboardStatus", "职员状态");
		onboardStatusField.setLength(11);
		onboardStatusField.setRequired(false);
		onboardStatusField.setHidden(false);
		onboardStatusField.setValueMap(KeyValueManager.getValueMap("system_dictionary_96"));
		onboardStatusField.setCanEdit(false);

		recordDateField = new DataSourceDateField("recordDate", "日期");
		recordDateField.setRequired(true);
		recordDateField.setHidden(false);
		recordDateField.setCanEdit(true);

		onboardDateField = new DataSourceDateField("onboardDate", "入职日期");
		onboardDateField.setRequired(true);
		onboardDateField.setHidden(false);
		onboardDateField.setCanEdit(true);
		
		resignationDateField = new DataSourceDateField("resignationDate", "离职日期");
		resignationDateField.setRequired(true);
		resignationDateField.setHidden(false);
		resignationDateField.setCanEdit(true);


		shouldBonusField = new DataSourceFloatField("shouldBonus", "应发奖金");
		shouldBonusField.setLength(18);
		shouldBonusField.setDecimalPad(2);
		shouldBonusField.setFormat("#,###,###,###,###,##0.00");
		shouldBonusField.setRequired(false);
		shouldBonusField.setHidden(false);
		shouldBonusField.setCanEdit(true);

		shouldTaxField = new DataSourceFloatField("shouldTax", "应纳个税");
		shouldTaxField.setLength(18);
		shouldTaxField.setDecimalPad(2);
		shouldTaxField.setFormat("#,###,###,###,###,##0.00");
		shouldTaxField.setRequired(false);
		shouldTaxField.setHidden(false);
		shouldTaxField.setCanEdit(true);


		factBonusField = new DataSourceFloatField("factBonus", "实发奖金");
		factBonusField.setLength(18);
		factBonusField.setDecimalPad(2);
		factBonusField.setFormat("#,###,###,###,###,##0.00");
		factBonusField.setRequired(false);
		factBonusField.setHidden(false);
		factBonusField.setCanEdit(false);


		flagField = new DataSourceIntegerField("flag", "标识（1应发，2已发，3其他）");
		flagField.setLength(11);
		flagField.setRequired(false);
		flagField.setHidden(true);

		isSendedField = new DataSourceBooleanField("isSended","是否发放");
		isSendedField.setHidden(false);
		isSendedField.setRequired(false);
		
		setFields(salaryOfBonusIdField, employeeNoField, employeeIdField, employeeNameField, ownedCompanyField, plateIdField, departmentIdField,statusField,onboardDateField,resignationDateField, onboardStatusField, recordDateField, shouldBonusField, shouldTaxField, factBonusField, flagField,isSendedField);
	}


}

