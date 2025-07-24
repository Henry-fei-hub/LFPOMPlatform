package com.pomplatform.client.payment.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSOnOtherDeductionData extends DBDataSource
{


	public static DSOnOtherDeductionData instance = null;

	public static DSOnOtherDeductionData getInstance() {
		if(instance == null) {
			instance = new DSOnOtherDeductionData("DSOnOtherDeductionData");
		}
		return instance;
	}

	private final DataSourceIntegerField otherDeductionIdField;
	private final DataSourceIntegerField employeeIdField;
	private final DataSourceTextField employeeNoField;
	private final DataSourceTextField employeeNameField;
	private final DataSourceIntegerField companyIdField;
	private final DataSourceIntegerField plateIdField;
	private final DataSourceIntegerField departmentIdField;
	private final DataSourceDateField recordDateField;
	private final DataSourceTextField otherDeductionField;
	private final DataSourceBooleanField isSendedField;

	public DSOnOtherDeductionData(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("OnOtherDeductionData");


		otherDeductionIdField = new DataSourceIntegerField("otherDeductionId", "主键编码");
		otherDeductionIdField.setLength(11);
		otherDeductionIdField.setPrimaryKey(true);
		otherDeductionIdField.setRequired(true);
		otherDeductionIdField.setHidden(true);


		employeeIdField = new DataSourceIntegerField("employeeId", "员工id");
		employeeIdField.setLength(11);
		employeeIdField.setRequired(false);
		employeeIdField.setHidden(true);


		employeeNoField = new DataSourceTextField("employeeNo", "员工编号");
		employeeNoField.setLength(64);
		employeeNoField.setRequired(true);
		employeeNoField.setHidden(false);


		employeeNameField = new DataSourceTextField("employeeName", "员工姓名");
		employeeNameField.setLength(64);
		employeeNameField.setRequired(true);
		employeeNameField.setHidden(false);


		companyIdField = new DataSourceIntegerField("companyId", "归属公司");
		companyIdField.setLength(11);
		companyIdField.setRequired(false);
		companyIdField.setHidden(false);
		companyIdField.setValueMap(KeyValueManager.getValueMap("company_records"));


		plateIdField = new DataSourceIntegerField("plateId", "业务部门");
		plateIdField.setLength(11);
		plateIdField.setRequired(false);
		plateIdField.setHidden(false);
		plateIdField.setValueMap(KeyValueManager.getValueMap("plate_records"));


		departmentIdField = new DataSourceIntegerField("departmentId", "归属部门");
		departmentIdField.setLength(11);
		departmentIdField.setRequired(false);
		departmentIdField.setHidden(false);
		departmentIdField.setValueMap(KeyValueManager.getValueMap("departments"));

		recordDateField = new DataSourceDateField("recordDate", "日期");
		recordDateField.setRequired(false);
		recordDateField.setHidden(false);


		otherDeductionField = new DataSourceTextField("otherDeduction", "其他扣除");
		otherDeductionField.setLength(256);
		otherDeductionField.setRequired(false);
		otherDeductionField.setHidden(false);


		isSendedField = new DataSourceBooleanField("isSended", "是否发放");
		isSendedField.setRequired(false);
		isSendedField.setHidden(false);


		setFields(otherDeductionIdField, employeeIdField, employeeNoField, employeeNameField, companyIdField, plateIdField, departmentIdField, recordDateField, otherDeductionField, isSendedField);
	}


}

