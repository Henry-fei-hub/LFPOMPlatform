package com.pomplatform.client.salary.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.smartgwt.client.types.TextMatchStyle;
import com.smartgwt.client.widgets.form.fields.ComboBoxItem;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSSalaryOfOtherBonus extends DBDataSource
{


	public static DSSalaryOfOtherBonus instance = null;

	public static DSSalaryOfOtherBonus getInstance() {
		if(instance == null) {
			instance = new DSSalaryOfOtherBonus("DSSalaryOfOtherBonus");
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
	private final DataSourceTextField onboardStatusField;
	private final DataSourceDateField recordDateField;
	private final DataSourceFloatField otherBonusField;
	private final DataSourceIntegerField flagField;
	private final DataSourceBooleanField isSendedField;
	private final DataSourceTextField remarkField;

	public DSSalaryOfOtherBonus(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("SalaryOfOtherBonus");


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
		employeeNameField.setRequired(true);
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


		onboardStatusField = new DataSourceTextField("onboardStatus", "职员状态");
		onboardStatusField.setLength(11);
		onboardStatusField.setRequired(false);
		onboardStatusField.setHidden(false);
		onboardStatusField.setValueMap(KeyValueManager.getValueMap("system_dictionary_96"));
		onboardStatusField.setCanEdit(false);

		recordDateField = new DataSourceDateField("recordDate", "日期");
		recordDateField.setRequired(true);
		recordDateField.setHidden(false);


		otherBonusField = new DataSourceFloatField("otherBonus", "其他奖金");
		otherBonusField.setLength(18);
		otherBonusField.setDecimalPad(2);
		otherBonusField.setFormat("#,###,###,###,###,##0.00");
		otherBonusField.setRequired(true);
		otherBonusField.setHidden(false);


		flagField = new DataSourceIntegerField("flag", "标识（1应发，2已发，3其他）");
		flagField.setLength(11);
		flagField.setRequired(false);
		flagField.setHidden(true);

		isSendedField = new DataSourceBooleanField("isSended","是否发放");
		isSendedField.setHidden(false);
		isSendedField.setRequired(false);

		remarkField = new DataSourceTextField("remark","备注");
		remarkField.setLength(512);
		remarkField.setRequired(false);
		remarkField.setHidden(false);
		remarkField.setCanEdit(true);
		
		setFields(salaryOfBonusIdField, employeeNoField, employeeIdField, employeeNameField, ownedCompanyField, plateIdField, departmentIdField, onboardStatusField, recordDateField, otherBonusField, flagField,remarkField,isSendedField);
	}


}

