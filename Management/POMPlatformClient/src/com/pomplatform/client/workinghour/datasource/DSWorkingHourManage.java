package com.pomplatform.client.workinghour.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSWorkingHourManage extends DBDataSource
{


	public static DSWorkingHourManage instance = null;

	public static DSWorkingHourManage getInstance() {
		if(instance == null) {
			instance = new DSWorkingHourManage("DSWorkingHourManage");
		}
		return instance;
	}

	private final DataSourceIntegerField workingHourIdField;
	private final DataSourceIntegerField projectIdField;
	private final DataSourceTextField projectCodeField;
	private final DataSourceTextField projectNameField;
	private final DataSourceIntegerField employeeIdField;
	private final DataSourceTextField employeeNoField;
	private final DataSourceTextField employeeNameField;
	private final DataSourceIntegerField departmentIdField;
	private final DataSourceIntegerField plateIdField;
	private final DataSourceIntegerField companyIdField;
	private final DataSourceFloatField workHourField;
	private final DataSourceDateField workDateField;
	private final DataSourceTextField remarkField;
	private final DataSourceDateTimeField createTimeField;
	private final DataSourceBooleanField isLockField;

	public DSWorkingHourManage(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("WorkingHourManage");


		workingHourIdField = new DataSourceIntegerField("workingHourId", "我的工时编码");
		workingHourIdField.setLength(11);
		workingHourIdField.setPrimaryKey(true);
		workingHourIdField.setRequired(true);
		workingHourIdField.setHidden(true);


		projectIdField = new DataSourceIntegerField("projectId", "项目编码");
		projectIdField.setLength(11);
		projectIdField.setRequired(false);
		projectIdField.setHidden(true);


		projectCodeField = new DataSourceTextField("projectCode", "项目编号");
		projectCodeField.setLength(64);
		projectCodeField.setRequired(false);
		projectCodeField.setHidden(false);


		projectNameField = new DataSourceTextField("projectName", "项目名称");
		projectNameField.setLength(512);
		projectNameField.setRequired(false);
		projectNameField.setHidden(false);


		employeeIdField = new DataSourceIntegerField("employeeId", "员工Id");
		employeeIdField.setLength(11);
		employeeIdField.setRequired(false);
		employeeIdField.setValueMap(KeyValueManager.getValueMap("employees"));
		employeeIdField.setHidden(true);

		employeeNameField = new DataSourceTextField("employeeName", "员工姓名");
		employeeNameField.setLength(128);
		employeeNameField.setRequired(false);
		employeeNameField.setHidden(false);

		employeeNoField = new DataSourceTextField("employeeNo", "员工编号");
		employeeNoField.setLength(64);
		employeeNoField.setRequired(false);
		employeeNoField.setHidden(false);


		departmentIdField = new DataSourceIntegerField("departmentId", "归属部门");
		departmentIdField.setLength(11);
		departmentIdField.setRequired(false);
		departmentIdField.setHidden(true);
		departmentIdField.setValueMap(KeyValueManager.getValueMap("departments"));


		plateIdField = new DataSourceIntegerField("plateId", "业务部门");
		plateIdField.setLength(11);
		plateIdField.setRequired(false);
		plateIdField.setHidden(false);
		plateIdField.setValueMap(KeyValueManager.getValueMap("plate_records"));


		companyIdField = new DataSourceIntegerField("companyId", "归属公司");
		companyIdField.setLength(11);
		companyIdField.setRequired(false);
		companyIdField.setHidden(false);
		companyIdField.setValueMap(KeyValueManager.getValueMap("system_dictionary_26"));


		workHourField = new DataSourceFloatField("workHour", "工时");
		workHourField.setLength(10);
		workHourField.setDecimalPad(1);
		workHourField.setFormat("###,###,##0.0");
		workHourField.setRequired(false);
		workHourField.setHidden(false);


		workDateField = new DataSourceDateField("workDate", "日期");
		workDateField.setRequired(false);
		workDateField.setHidden(false);


		remarkField = new DataSourceTextField("remark", "备注");
		remarkField.setLength(512);
		remarkField.setRequired(false);
		remarkField.setHidden(false);


		createTimeField = new DataSourceDateTimeField("createTime", "创建时间");
		createTimeField.setRequired(false);
		createTimeField.setHidden(false);


		isLockField = new DataSourceBooleanField("isLock", "是否锁定");
		isLockField.setRequired(false);
		isLockField.setHidden(true);


		setFields(workingHourIdField, projectIdField, projectCodeField, projectNameField, employeeIdField, employeeNoField, employeeNameField, departmentIdField, plateIdField, companyIdField, workHourField, workDateField, remarkField, createTimeField, isLockField);
	}


}

