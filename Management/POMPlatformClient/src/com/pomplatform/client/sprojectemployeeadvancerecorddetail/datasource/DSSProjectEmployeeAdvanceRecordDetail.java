package com.pomplatform.client.sprojectemployeeadvancerecorddetail.datasource;

import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.smartgwt.client.data.fields.DataSourceDateField;
import com.smartgwt.client.data.fields.DataSourceFloatField;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;

public class DSSProjectEmployeeAdvanceRecordDetail extends DBDataSource {

	public static DSSProjectEmployeeAdvanceRecordDetail instance = null;

	public static DSSProjectEmployeeAdvanceRecordDetail getInstance() {
		if (instance == null) {
			instance = new DSSProjectEmployeeAdvanceRecordDetail("DSSProjectEmployeeAdvanceRecordDetail");
		}
		return instance;
	}

	private final DataSourceIntegerField employeeIdField;
	private final DataSourceTextField projectIdField;
	private final DataSourceFloatField advancedIntegralField;
	private final DataSourceDateField advanceDateField;
	private final DataSourceIntegerField operateEmployeeIdField;
	private final DataSourceTextField remarkField;

	public DSSProjectEmployeeAdvanceRecordDetail(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("SProjectEmployeeAdvanceRecordDetail");

		employeeIdField = new DataSourceIntegerField("employeeId", "补贴员工");
		employeeIdField.setLength(11);
		employeeIdField.setRequired(false);
		employeeIdField.setHidden(true);
		employeeIdField.setValueMap(KeyValueManager.getValueMap("employees"));

		projectIdField = new DataSourceTextField("projectId", "补贴项目");
		projectIdField.setLength(11);
		projectIdField.setRequired(false);
		projectIdField.setHidden(false);
//		KeyValueManager.loadValueMap("projects",projectIdField);
		KeyValueManager.loadValueMap("projects",projectIdField);

		advancedIntegralField = new DataSourceFloatField("advancedIntegral", "补贴积分");
		advancedIntegralField.setLength(10);
		advancedIntegralField.setDecimalPad(2);
		advancedIntegralField.setFormat("##,###,##0.00");
		advancedIntegralField.setRequired(false);
		advancedIntegralField.setHidden(false);

		advanceDateField = new DataSourceDateField("advanceDate", "补贴日期");
		advanceDateField.setRequired(false);
		advanceDateField.setHidden(false);

		operateEmployeeIdField = new DataSourceIntegerField("operateEmployeeId", "操作人");
		operateEmployeeIdField.setLength(11);
		operateEmployeeIdField.setRequired(false);
		operateEmployeeIdField.setHidden(false);
		operateEmployeeIdField.setValueMap(KeyValueManager.getValueMap("employees"));

		remarkField = new DataSourceTextField("remark", "备注");
		remarkField.setLength(512);
		remarkField.setRequired(false);
		remarkField.setHidden(false);

		setFields(employeeIdField, projectIdField, advancedIntegralField, advanceDateField, operateEmployeeIdField,
				remarkField);
	}

}
