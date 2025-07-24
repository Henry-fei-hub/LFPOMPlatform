package com.pomplatform.client.employee.datasource;

import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.smartgwt.client.data.fields.DataSourceDateField;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;

public class DSResignEmployeeEachMonthDetail extends DBDataSource
{


	public static DSResignEmployeeEachMonthDetail instance = null;

	public static DSResignEmployeeEachMonthDetail getInstance() {
		if(instance == null) {
			instance = new DSResignEmployeeEachMonthDetail("DSResignEmployeeEachMonthDetail");
		}
		return instance;
	}

	private final DataSourceIntegerField departmentIdField;
	private final DataSourceIntegerField employeeIdField;
	private final DataSourceDateField resignDateField;
	private final DataSourceTextField reasonField;
	private final DataSourceIntegerField processIdField;
	private final DataSourceIntegerField businessIdField;
	private final DataSourceIntegerField processTypeField;
	private final DataSourceIntegerField processInstanceIdField;
	private final DataSourceIntegerField plateIdField;
	private final DataSourceIntegerField dutyIdField;

	public DSResignEmployeeEachMonthDetail(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("ResignEmployeeEachMonthDetail");


		plateIdField = new DataSourceIntegerField("plateId", "业务部门");
		plateIdField.setLength(11);
		plateIdField.setRequired(false);
		plateIdField.setHidden(false);
		plateIdField.setValueMap(KeyValueManager.getValueMap("plate_records"));
		
		
		departmentIdField = new DataSourceIntegerField("departmentId", "归属部门");
		departmentIdField.setLength(11);
		departmentIdField.setRequired(false);
		departmentIdField.setHidden(false);
		departmentIdField.setValueMap(KeyValueManager.getValueMap("all_departments"));


		employeeIdField = new DataSourceIntegerField("employeeId", "离职员工");
		employeeIdField.setLength(11);
		employeeIdField.setPrimaryKey(true);
		employeeIdField.setRequired(true);
		employeeIdField.setHidden(false);
		employeeIdField.setValueMap(KeyValueManager.getValueMap("employees"));
		
		
		dutyIdField = new DataSourceIntegerField("dutyId", "岗位");
		dutyIdField.setLength(11);
		dutyIdField.setRequired(false);
		dutyIdField.setHidden(false);
		dutyIdField.setValueMap(KeyValueManager.getValueMap("duties"));


		resignDateField = new DataSourceDateField("resignDate", "离职日期");
		resignDateField.setRequired(true);
		resignDateField.setHidden(false);


		reasonField = new DataSourceTextField("reason", "离职原因");
		reasonField.setLength(1024);
		reasonField.setRequired(false);
		reasonField.setHidden(false);


		processIdField = new DataSourceIntegerField("processId", "流程编码");
		processIdField.setLength(11);
		processIdField.setRequired(false);
		processIdField.setHidden(true);


		businessIdField = new DataSourceIntegerField("businessId", "业务编码");
		businessIdField.setLength(11);
		businessIdField.setRequired(false);
		businessIdField.setHidden(true);
		businessIdField.setValueMap(KeyValueManager.getValueMap("system_dictionary_26"));


		processTypeField = new DataSourceIntegerField("processType", "类型 13请假  14出差  15打卡  16外出  17加班");
		processTypeField.setLength(11);
		processTypeField.setRequired(false);
		processTypeField.setHidden(true);
		processTypeField.setValueMap(KeyValueManager.getValueMap("system_process_types"));


		processInstanceIdField = new DataSourceIntegerField("processInstanceId", "主键编码");
		processInstanceIdField.setLength(11);
		processInstanceIdField.setPrimaryKey(true);
		processInstanceIdField.setRequired(true);
		processInstanceIdField.setHidden(true);


		setFields(plateIdField, departmentIdField, processInstanceIdField, employeeIdField, dutyIdField, resignDateField, reasonField, processIdField, businessIdField, processTypeField);
	}


}

