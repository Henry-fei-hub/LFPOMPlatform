package com.pomplatform.client.clocks.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSEmployeeFingers extends DBDataSource
{


	public static DSEmployeeFingers instance = null;

	public static DSEmployeeFingers getInstance() {
		if(instance == null) {
			instance = new DSEmployeeFingers("DSemployeeFingers");
		}
		return instance;
	}

	private final DataSourceIntegerField hrEmpFingerIdField;
	private final DataSourceIntegerField employeeIdField;
	private final DataSourceTextField snField;
	private final DataSourceTextField empCodeField;
	private final DataSourceTextField templateField;
	private final DataSourceIntegerField fpversionField;
	private final DataSourceIntegerField fingerTypeField;
	private final DataSourceIntegerField sizeField;
	private final DataSourceIntegerField validField;
	private final DataSourceIntegerField isActiveField;
	private final DataSourceIntegerField fidField;
	private final DataSourceDateTimeField utimeField;
	private final DataSourceTextField employeeNoField;
	private final DataSourceTextField employeeNameField;
	private final DataSourceIntegerField departmentIdField;

	public DSEmployeeFingers(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("EmployeeFingers");


		hrEmpFingerIdField = new DataSourceIntegerField("hrEmpFingerId", "主键编码");
		hrEmpFingerIdField.setLength(11);
		hrEmpFingerIdField.setPrimaryKey(true);
		hrEmpFingerIdField.setRequired(true);
		hrEmpFingerIdField.setHidden(true);


		employeeIdField = new DataSourceIntegerField("employeeId", "考勤编码");
		employeeIdField.setLength(11);
		employeeIdField.setRequired(false);
		employeeIdField.setHidden(false);


		snField = new DataSourceTextField("sn", "序列号");
		snField.setLength(32);
		snField.setRequired(false);
		snField.setHidden(false);


		empCodeField = new DataSourceTextField("empCode", "考勤号码");
		empCodeField.setLength(64);
		empCodeField.setRequired(false);
		empCodeField.setHidden(false);


		templateField = new DataSourceTextField("template", "指纹");
		templateField.setLength(12048);
		templateField.setRequired(false);
		templateField.setHidden(false);


		fpversionField = new DataSourceIntegerField("fpversion", "指纹版本");
		fpversionField.setLength(11);
		fpversionField.setRequired(false);
		fpversionField.setHidden(false);


		fingerTypeField = new DataSourceIntegerField("fingerType", "指纹类型");
		fingerTypeField.setLength(11);
		fingerTypeField.setRequired(false);
		fingerTypeField.setHidden(false);


		sizeField = new DataSourceIntegerField("size", "大小");
		sizeField.setLength(11);
		sizeField.setRequired(false);
		sizeField.setHidden(false);


		validField = new DataSourceIntegerField("valid", "有效日期");
		validField.setLength(11);
		validField.setRequired(false);
		validField.setHidden(false);


		isActiveField = new DataSourceIntegerField("isActive", "是否可用");
		isActiveField.setLength(11);
		isActiveField.setRequired(false);
		isActiveField.setHidden(false);


		fidField = new DataSourceIntegerField("fid", "指纹序号");
		fidField.setLength(11);
		fidField.setRequired(false);
		fidField.setHidden(false);


		utimeField = new DataSourceDateTimeField("utime", "时区");
		utimeField.setRequired(false);
		utimeField.setHidden(false);


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


		setFields(employeeIdField,hrEmpFingerIdField, employeeNoField, employeeNameField, departmentIdField, snField, empCodeField, templateField, fpversionField, fingerTypeField, sizeField, validField, isActiveField, fidField, utimeField);
	}


}

