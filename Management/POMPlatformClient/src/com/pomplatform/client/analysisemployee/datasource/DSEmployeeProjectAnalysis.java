package com.pomplatform.client.analysisemployee.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSEmployeeProjectAnalysis extends DBDataSource
{


	public static DSEmployeeProjectAnalysis instance = null;

	public static DSEmployeeProjectAnalysis getInstance() {
		if(instance == null) {
			instance = new DSEmployeeProjectAnalysis("DSEmployeeProjectAnalysis");
		}
		return instance;
	}

	private final DataSourceIntegerField employeeIdField;
	private final DataSourceTextField employeeNoField;
	private final DataSourceTextField employeeNameField;
	private final DataSourceIntegerField plateIdField;
	private final DataSourceIntegerField departmentIdField;
	private final DataSourceFloatField leftIntegralField;
	private final DataSourceIntegerField numField;
	private final DataSourceIntegerField isbusyField;

	public DSEmployeeProjectAnalysis(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("EmployeeProjectAnalysis");


		employeeIdField = new DataSourceIntegerField("employeeId", "员工编码");
		employeeIdField.setLength(11);
		employeeIdField.setRequired(false);
		employeeIdField.setHidden(true);
		employeeIdField.setValueMap(KeyValueManager.getValueMap("employees"));


		employeeNoField = new DataSourceTextField("employeeNo", "员工编号");
		employeeNoField.setLength(64);
		employeeNoField.setRequired(true);
		employeeNoField.setHidden(false);


		employeeNameField = new DataSourceTextField("employeeName", "员工姓名");
		employeeNameField.setLength(64);
		employeeNameField.setRequired(true);
		employeeNameField.setHidden(false);


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


		leftIntegralField = new DataSourceFloatField("leftIntegral", "剩余积分");
		leftIntegralField.setLength(18);
		leftIntegralField.setDecimalPad(2);
		leftIntegralField.setFormat("#,###,###,###,###,##0.00");
		leftIntegralField.setRequired(true);
		leftIntegralField.setHidden(false);


		numField = new DataSourceIntegerField("num", "参与项目数量");
		numField.setLength(8);
		numField.setRequired(true);
		numField.setHidden(false);


		isbusyField = new DataSourceIntegerField("isbusy", "状态");
		isbusyField.setLength(11);
		isbusyField.setRequired(false);
		isbusyField.setHidden(false);
		isbusyField.setValueMap(KeyValueManager.getValueMap("system_dictionary_140"));


		setFields(employeeIdField, employeeNoField, employeeNameField, plateIdField, departmentIdField, leftIntegralField, numField, isbusyField);
	}


}

