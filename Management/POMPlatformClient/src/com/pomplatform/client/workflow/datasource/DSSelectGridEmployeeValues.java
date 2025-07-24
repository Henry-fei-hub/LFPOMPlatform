package com.pomplatform.client.workflow.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSSelectGridEmployeeValues extends DBDataSource
{


	public static DSSelectGridEmployeeValues instance = null;

	public static DSSelectGridEmployeeValues getInstance() {
		if(instance == null) {
			instance = new DSSelectGridEmployeeValues("DSSelectGridEmployeeValues");
		}
		return instance;
	}

	private final DataSourceIntegerField employeeIdField;
	private final DataSourceTextField employeeNoField;
	private final DataSourceTextField employeeNameField;
	private final DataSourceIntegerField departmentIdField;
	private final DataSourceIntegerField roleIdField;
	private final DataSourceTextField mobileField;
	private final DataSourceTextField phoneField;
	private final DataSourceTextField qqField;
	private final DataSourceTextField emailField;
	private final DataSourceTextField photoField;
	private final DataSourceTextField cardField;
	private final DataSourceTextField userAcctField;
	private final DataSourceTextField employeeNameEnField;
	private final DataSourceTextField workAddressField;

	public DSSelectGridEmployeeValues(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("SelectGridEmployeeValues");


		employeeIdField = new DataSourceIntegerField("employeeId", "处理人");
		employeeIdField.setLength(11);
		employeeIdField.setRequired(false);
		employeeIdField.setHidden(false);


		employeeNoField = new DataSourceTextField("employeeNo", "员工编号");
		employeeNoField.setLength(32);
		employeeNoField.setRequired(false);
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

		roleIdField = new DataSourceIntegerField("roleId", "角色");
		roleIdField.setLength(11);
		roleIdField.setRequired(false);
		roleIdField.setHidden(false);


		mobileField = new DataSourceTextField("mobile", "手机");
		mobileField.setLength(64);
		mobileField.setRequired(false);
		mobileField.setHidden(false);


		phoneField = new DataSourceTextField("phone", "电话");
		phoneField.setLength(64);
		phoneField.setRequired(false);
		phoneField.setHidden(false);


		qqField = new DataSourceTextField("qq", "QQ");
		qqField.setLength(64);
		qqField.setRequired(false);
		qqField.setHidden(false);


		emailField = new DataSourceTextField("email", "邮箱");
		emailField.setLength(64);
		emailField.setRequired(false);
		emailField.setHidden(false);


		photoField = new DataSourceTextField("photo", "头像");
		photoField.setLength(512);
		photoField.setRequired(false);
		photoField.setHidden(false);


		cardField = new DataSourceTextField("card", "身份证号");
		cardField.setLength(64);
		cardField.setRequired(false);
		cardField.setHidden(false);


		userAcctField = new DataSourceTextField("userAcct", "上级领导");
		userAcctField.setLength(64);
		userAcctField.setRequired(false);
		userAcctField.setHidden(false);


		employeeNameEnField = new DataSourceTextField("employeeNameEn", "英文名");
		employeeNameEnField.setLength(64);
		employeeNameEnField.setRequired(false);
		employeeNameEnField.setHidden(false);


		workAddressField = new DataSourceTextField("workAddress", "工作地");
		workAddressField.setLength(128);
		workAddressField.setRequired(false);
		workAddressField.setHidden(false);


		setFields(employeeIdField, employeeNoField, employeeNameField, departmentIdField, roleIdField, mobileField, phoneField, qqField, emailField, photoField, cardField, userAcctField, employeeNameEnField, workAddressField);
	}


}

