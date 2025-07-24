package com.pomplatform.client.leavetype.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSLeaveTypeLinkProvinceDetail extends DBDataSource
{


	public static DSLeaveTypeLinkProvinceDetail instance = null;

	public static DSLeaveTypeLinkProvinceDetail getInstance() {
		if(instance == null) {
			instance = new DSLeaveTypeLinkProvinceDetail("DSLeaveTypeLinkProvinceDetail");
		}
		return instance;
	}

	private final DataSourceIntegerField leaveTypeLinkProvinceIdField;
	private final DataSourceIntegerField leaveTypeIdField;
	private final DataSourceIntegerField provinceIdField;
	private final DataSourceFloatField daysField;
	private final DataSourceTextField remarkField;
	private final DataSourceBooleanField isEnableField;

	public DSLeaveTypeLinkProvinceDetail(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("LeaveTypeLinkProvinceDetail");


		leaveTypeLinkProvinceIdField = new DataSourceIntegerField("leaveTypeLinkProvinceId", "请假类型省份关联表");
		leaveTypeLinkProvinceIdField.setLength(11);
		leaveTypeLinkProvinceIdField.setPrimaryKey(true);
		leaveTypeLinkProvinceIdField.setRequired(true);
		leaveTypeLinkProvinceIdField.setHidden(true);


		leaveTypeIdField = new DataSourceIntegerField("leaveTypeId", "请假类型");
		leaveTypeIdField.setLength(11);
		leaveTypeIdField.setRequired(false);
		leaveTypeIdField.setHidden(false);


		provinceIdField = new DataSourceIntegerField("provinceId", "适用省份");
		provinceIdField.setLength(11);
		provinceIdField.setRequired(false);
		provinceIdField.setHidden(false);
		provinceIdField.setValueMap(KeyValueManager.getValueMap("provinces"));


		daysField = new DataSourceFloatField("days", "天数");
		daysField.setLength(5);
		daysField.setDecimalPad(2);
		daysField.setFormat("##0.00");
		daysField.setRequired(false);
		daysField.setHidden(false);


		remarkField = new DataSourceTextField("remark", "备注");
		remarkField.setLength(255);
		remarkField.setRequired(false);
		remarkField.setHidden(false);


		isEnableField = new DataSourceBooleanField("isEnable", "是否启用");
		isEnableField.setRequired(false);
		isEnableField.setHidden(false);


		setFields(leaveTypeLinkProvinceIdField, leaveTypeIdField, provinceIdField, daysField, remarkField, isEnableField);
	}


}

