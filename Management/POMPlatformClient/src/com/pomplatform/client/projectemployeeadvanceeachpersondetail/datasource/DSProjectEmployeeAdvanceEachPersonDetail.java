package com.pomplatform.client.projectemployeeadvanceeachpersondetail.datasource;

import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.smartgwt.client.data.fields.DataSourceDateField;
import com.smartgwt.client.data.fields.DataSourceFloatField;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;

public class DSProjectEmployeeAdvanceEachPersonDetail extends DBDataSource {

	public static DSProjectEmployeeAdvanceEachPersonDetail instance = null;

	public static DSProjectEmployeeAdvanceEachPersonDetail getInstance() {
		if (instance == null) {
			instance = new DSProjectEmployeeAdvanceEachPersonDetail("DSProjectEmployeeAdvanceEachPersonDetail");
		}
		return instance;
	}

	private final DataSourceIntegerField projectIdField;
	private final DataSourceIntegerField employeeIdField;
	private final DataSourceFloatField advanceIntegralField;
	private final DataSourceDateField advanceDateField;
	private final DataSourceIntegerField operateEmployeeIdField;
	private final DataSourceTextField remarkField;

	public DSProjectEmployeeAdvanceEachPersonDetail(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("ProjectEmployeeAdvanceEachPersonDetail");

		projectIdField = new DataSourceIntegerField("projectId", "项目名称");
		projectIdField.setLength(11);
		projectIdField.setRequired(false);
		projectIdField.setHidden(false);
//		KeyValueManager.loadValueMap("projects",projectIdField);
		KeyValueManager.loadValueMap("projects", projectIdField);

		employeeIdField = new DataSourceIntegerField("employeeId", "员工姓名");
		employeeIdField.setLength(11);
		employeeIdField.setRequired(false);
		employeeIdField.setHidden(false);
		employeeIdField.setValueMap(KeyValueManager.getValueMap("employees"));

		advanceIntegralField = new DataSourceFloatField("advanceIntegral", "补贴积分");
		advanceIntegralField.setLength(10);
		advanceIntegralField.setDecimalPad(2);
		advanceIntegralField.setFormat("##,###,##0.00");
		advanceIntegralField.setRequired(false);
		advanceIntegralField.setHidden(false);

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

		setFields(projectIdField, employeeIdField, advanceIntegralField, advanceDateField, operateEmployeeIdField,
				remarkField);
	}

}
