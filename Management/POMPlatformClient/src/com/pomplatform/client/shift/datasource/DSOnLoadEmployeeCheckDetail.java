package com.pomplatform.client.shift.datasource;

import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.smartgwt.client.data.fields.DataSourceDateField;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;

public class DSOnLoadEmployeeCheckDetail extends DBDataSource
{


	public static DSOnLoadEmployeeCheckDetail instance = null;

	public static DSOnLoadEmployeeCheckDetail getInstance() {
		if(instance == null) {
			instance = new DSOnLoadEmployeeCheckDetail("DSOnLoadEmployeeCheckDetail");
		}
		return instance;
	}

	private final DataSourceIntegerField employeeIdField;
	private final DataSourceTextField employeeNoField;
	private final DataSourceTextField employeeNameField;
	private final DataSourceIntegerField departmentIdField;
	private final DataSourceDateField checkDateField;
	private final DataSourceTextField checkTimeDetailsField;

	public DSOnLoadEmployeeCheckDetail(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("OnLoadEmployeeCheckDetail");


		employeeIdField = new DataSourceIntegerField("employeeId", "职员编码");
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


		departmentIdField = new DataSourceIntegerField("departmentId", "部门");
		departmentIdField.setLength(11);
		departmentIdField.setRequired(false);
		departmentIdField.setHidden(false);
		departmentIdField.setValueMap(KeyValueManager.getValueMap("departments"));


		checkDateField = new DataSourceDateField("checkDate", "打卡日期");
		checkDateField.setRequired(false);
		checkDateField.setHidden(false);


		checkTimeDetailsField = new DataSourceTextField("checkTimeDetails", "打卡明细");
		checkTimeDetailsField.setLength(128);
		checkTimeDetailsField.setRequired(true);
		checkTimeDetailsField.setHidden(false);


		setFields(employeeIdField, employeeNoField, employeeNameField, departmentIdField, checkDateField, checkTimeDetailsField);
	}


}

