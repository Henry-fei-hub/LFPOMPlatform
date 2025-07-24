package com.pomplatform.client.sprojectemployeeadvancerecordpor.datasource;

import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.smartgwt.client.data.fields.DataSourceFloatField;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;

public class DSSProjectEmployeeAdvanceRecordpor extends DBDataSource {

	public static DSSProjectEmployeeAdvanceRecordpor instance = null;

	public static DSSProjectEmployeeAdvanceRecordpor getInstance() {
		if (instance == null) {
			instance = new DSSProjectEmployeeAdvanceRecordpor("DSSProjectEmployeeAdvanceRecordpor");
		}
		return instance;
	}

	private final DataSourceTextField projectIdField;
	private final DataSourceIntegerField employeeIdField;
	private final DataSourceFloatField advanceIntegralField;

	public DSSProjectEmployeeAdvanceRecordpor(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("SProjectEmployeeAdvanceRecordpor");

		projectIdField = new DataSourceTextField("projectId", "项目名称");
		projectIdField.setLength(11);
		projectIdField.setRequired(false);
		projectIdField.setHidden(false);
		KeyValueManager.loadValueMap("projects",projectIdField);

		employeeIdField = new DataSourceIntegerField("employeeId", "员工姓名");
		employeeIdField.setLength(32);
		employeeIdField.setRequired(false);
		employeeIdField.setHidden(false);
		employeeIdField.setValueMap(KeyValueManager.getValueMap("employees"));

		advanceIntegralField = new DataSourceFloatField("advanceIntegral", "补贴积分");
		advanceIntegralField.setLength(10);
		advanceIntegralField.setDecimalPad(2);
		advanceIntegralField.setFormat("##,###,##0.00");
		advanceIntegralField.setRequired(false);
		advanceIntegralField.setHidden(false);

		setFields(projectIdField, employeeIdField, advanceIntegralField);
	}

}
