package com.pomplatform.client.leavetype.datasource;

import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.smartgwt.client.data.fields.DataSourceBooleanField;
import com.smartgwt.client.data.fields.DataSourceFloatField;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;

public class DSLinkOfLeaveTypeAndArea extends DBDataSource
{


	public static DSLinkOfLeaveTypeAndArea instance = null;

	public static DSLinkOfLeaveTypeAndArea getInstance() {
		if(instance == null) {
			instance = new DSLinkOfLeaveTypeAndArea("DSLinkOfLeaveTypeAndArea");
		}
		return instance;
	}

	private final DataSourceIntegerField leaveTypeLinkAreaIdField;
	private final DataSourceIntegerField leaveTypeIdField;
	private final DataSourceIntegerField areaIdField;
	private final DataSourceFloatField daysField;
	private final DataSourceTextField remarkField;
	private final DataSourceBooleanField isEnableField;

	public DSLinkOfLeaveTypeAndArea(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("LinkOfLeaveTypeAndArea");


		leaveTypeLinkAreaIdField = new DataSourceIntegerField("leaveTypeLinkAreaId", "请假类型区域关联表");
		leaveTypeLinkAreaIdField.setLength(11);
		leaveTypeLinkAreaIdField.setPrimaryKey(true);
		leaveTypeLinkAreaIdField.setRequired(true);
		leaveTypeLinkAreaIdField.setHidden(true);


		leaveTypeIdField = new DataSourceIntegerField("leaveTypeId", "请假类型");
		leaveTypeIdField.setLength(11);
		leaveTypeIdField.setRequired(false);
		leaveTypeIdField.setHidden(false);
//		leaveTypeIdField.setValueMap(KeyValueManager.getValueMap("leave_types"));
		KeyValueManager.loadValueMap("leave_types",leaveTypeIdField);

		areaIdField = new DataSourceIntegerField("areaId", "适用区域");
		areaIdField.setLength(11);
		areaIdField.setRequired(false);
		areaIdField.setHidden(false);
		areaIdField.setValueMap(KeyValueManager.getValueMap("areas"));


		daysField = new DataSourceFloatField("days", "天数");
		daysField.setLength(18);
		daysField.setDecimalPad(2);
		daysField.setFormat("#,###,###,###,###,##0.00");
		daysField.setRequired(false);
		daysField.setHidden(false);


		remarkField = new DataSourceTextField("remark", "备注");
		remarkField.setLength(255);
		remarkField.setRequired(false);
		remarkField.setHidden(false);


		isEnableField = new DataSourceBooleanField("isEnable", "是否启用");
		isEnableField.setRequired(false);
		isEnableField.setHidden(false);


		setFields(leaveTypeLinkAreaIdField, leaveTypeIdField, areaIdField, daysField, remarkField, isEnableField);
	}


}

