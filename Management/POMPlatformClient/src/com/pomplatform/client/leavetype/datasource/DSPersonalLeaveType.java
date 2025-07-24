package com.pomplatform.client.leavetype.datasource;

import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;

public class DSPersonalLeaveType extends DBDataSource
{


	public static DSPersonalLeaveType instance = null;

	public static DSPersonalLeaveType getInstance() {
		if(instance == null) {
			instance = new DSPersonalLeaveType("DSPersonalLeaveType");
		}
		return instance;
	}

	private final DataSourceIntegerField leaveTypeIdField;
	private final DataSourceTextField leaveTypeNameField;
	private final DataSourceIntegerField areaIdField;
	private final DataSourceTextField areaNameField;
	private final DataSourceTextField daysField;
	private final DataSourceTextField remarkField;
	private final DataSourceIntegerField parentIdField;

	public DSPersonalLeaveType(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("PersonalLeaveType");


		leaveTypeIdField = new DataSourceIntegerField("leaveTypeId", "请假类型");
		leaveTypeIdField.setLength(11);
		leaveTypeIdField.setPrimaryKey(true);
		leaveTypeIdField.setRequired(true);
		leaveTypeIdField.setHidden(true);


		leaveTypeNameField = new DataSourceTextField("leaveTypeName", "请假类型");
		leaveTypeNameField.setLength(128);
		leaveTypeNameField.setRequired(false);
		leaveTypeNameField.setHidden(false);


		areaIdField = new DataSourceIntegerField("areaId", "适用区域");
		areaIdField.setLength(11);
		areaIdField.setRequired(false);
		areaIdField.setHidden(true);
		areaIdField.setValueMap(KeyValueManager.getValueMap("areas"));


		areaNameField = new DataSourceTextField("areaName", "适用区域");
		areaNameField.setLength(128);
		areaNameField.setRequired(false);
		areaNameField.setHidden(false);


		daysField = new DataSourceTextField("days", "天数上限");
		daysField.setLength(-1);
		daysField.setRequired(true);
		daysField.setHidden(false);


		remarkField = new DataSourceTextField("remark", "备注");
		remarkField.setLength(255);
		remarkField.setRequired(false);
		remarkField.setHidden(false);


		parentIdField = new DataSourceIntegerField("parentId", "父级编码");
		parentIdField.setLength(11);
		parentIdField.setRequired(false);
		parentIdField.setHidden(true);
		parentIdField.setForeignKey(dataSourceID+".leaveTypeId");
		parentIdField.setRootValue("0");


		setFields(leaveTypeIdField, leaveTypeNameField, areaIdField, areaNameField, daysField, remarkField, parentIdField);
	}


}

