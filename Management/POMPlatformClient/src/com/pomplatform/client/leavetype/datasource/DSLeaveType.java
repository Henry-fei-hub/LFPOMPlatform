package com.pomplatform.client.leavetype.datasource;

import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.smartgwt.client.data.fields.DataSourceBooleanField;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;

public class DSLeaveType extends DBDataSource
{


	public static DSLeaveType instance = null;

	public static DSLeaveType getInstance() {
		if(instance == null) {
			instance = new DSLeaveType("DSLeaveType");
		}
		return instance;
	}

	private final DataSourceIntegerField leaveTypeIdField;
	private final DataSourceIntegerField parentIdField;
	private final DataSourceTextField leaveTypeNameField;
	private final DataSourceBooleanField isEnableField;
	private final DataSourceIntegerField genderField;

	public DSLeaveType(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_TABLE);
		setActionName("LeaveType");


		leaveTypeIdField = new DataSourceIntegerField("leaveTypeId", "主键编码");
		leaveTypeIdField.setLength(11);
		leaveTypeIdField.setPrimaryKey(true);
		leaveTypeIdField.setRequired(true);
		leaveTypeIdField.setHidden(true);


		parentIdField = new DataSourceIntegerField("parentId", "父级编码");
		parentIdField.setLength(11);
		parentIdField.setRequired(false);
		parentIdField.setForeignKey(dataSourceID+".leaveTypeId");
		parentIdField.setRootValue("0");
		parentIdField.setHidden(true);


		leaveTypeNameField = new DataSourceTextField("leaveTypeName", "请假类型");
		leaveTypeNameField.setLength(64);
		leaveTypeNameField.setRequired(false);
		leaveTypeNameField.setHidden(false);

		genderField = new DataSourceIntegerField("gender", "适用性别");
		genderField.setValueMap(KeyValueManager.getValueMap("system_dictionary_75"));
		genderField.setLength(11);
		genderField.setHidden(false);
		
		isEnableField = new DataSourceBooleanField("isEnable", "是否启用");
		isEnableField.setRequired(false);
		isEnableField.setHidden(false);


		setFields(leaveTypeIdField, parentIdField, leaveTypeNameField, genderField, isEnableField);
	}


}

