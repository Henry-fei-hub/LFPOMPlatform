package com.pomplatform.client.employeereportrecorddetail.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSPlateGetViolationChargesMonthlyDetail extends DBDataSource
{


	public static DSPlateGetViolationChargesMonthlyDetail instance = null;

	public static DSPlateGetViolationChargesMonthlyDetail getInstance() {
		if(instance == null) {
			instance = new DSPlateGetViolationChargesMonthlyDetail("DSPlateGetViolationChargesMonthlyDetail");
		}
		return instance;
	}

	private final DataSourceIntegerField employeeViolationChargesIdField;
	private final DataSourceIntegerField employeeIdField;
	private final DataSourceIntegerField plateIdField;
	private final DataSourceFloatField violationChargesField;
	private final DataSourceDateField violationDateField;
	private final DataSourceIntegerField operatorField;
	private final DataSourceDateTimeField operateTimeField;
	private final DataSourceTextField remarkField;

	public DSPlateGetViolationChargesMonthlyDetail(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("PlateGetViolationChargesMonthlyDetail");


		employeeViolationChargesIdField = new DataSourceIntegerField("employeeViolationChargesId", "employee_violation_charges_id");
		employeeViolationChargesIdField.setLength(11);
		employeeViolationChargesIdField.setPrimaryKey(true);
		employeeViolationChargesIdField.setRequired(true);
		employeeViolationChargesIdField.setHidden(true);


		employeeIdField = new DataSourceIntegerField("employeeId", "员工");
		employeeIdField.setLength(11);
		employeeIdField.setRequired(false);
		employeeIdField.setHidden(false);
		employeeIdField.setValueMap(KeyValueManager.getValueMap("employees"));


		plateIdField = new DataSourceIntegerField("plateId", "业务部门");
		plateIdField.setLength(11);
		plateIdField.setRequired(false);
		plateIdField.setHidden(false);
		plateIdField.setValueMap(KeyValueManager.getValueMap("system_dictionary_1"));


		violationChargesField = new DataSourceFloatField("violationCharges", "项目违规金");
		violationChargesField.setLength(18);
		violationChargesField.setDecimalPad(2);
		violationChargesField.setFormat("#,###,###,###,###,##0.00");
		violationChargesField.setRequired(false);
		violationChargesField.setHidden(false);


		violationDateField = new DataSourceDateField("violationDate", "违规日期");
		violationDateField.setRequired(false);
		violationDateField.setHidden(false);


		operatorField = new DataSourceIntegerField("operator", "操作者");
		operatorField.setLength(11);
		operatorField.setRequired(false);
		operatorField.setHidden(false);
		operatorField.setValueMap(KeyValueManager.getValueMap("employees"));


		operateTimeField = new DataSourceDateTimeField("operateTime", "操作时间");
		operateTimeField.setRequired(false);
		operateTimeField.setHidden(false);


		remarkField = new DataSourceTextField("remark", "备注");
		remarkField.setLength(1024);
		remarkField.setRequired(false);
		remarkField.setHidden(false);


		setFields(employeeViolationChargesIdField, employeeIdField, plateIdField, violationChargesField, violationDateField, operatorField, operateTimeField, remarkField);
	}


}

