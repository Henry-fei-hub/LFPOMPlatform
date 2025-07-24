package com.pomplatform.client.leavetype.datasource;

import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.smartgwt.client.data.fields.DataSourceBooleanField;
import com.smartgwt.client.data.fields.DataSourceFloatField;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;

public class DSLinkOfLeaveTypeAndProvince extends DBDataSource
{


	public static DSLinkOfLeaveTypeAndProvince instance = null;

	public static DSLinkOfLeaveTypeAndProvince getInstance() {
		if(instance == null) {
			instance = new DSLinkOfLeaveTypeAndProvince("DSLinkOfLeaveTypeAndProvince");
		}
		return instance;
	}

	private final DataSourceIntegerField leaveTypeLinkProvinceIdField;
	private final DataSourceIntegerField leaveTypeIdField;
	private final DataSourceIntegerField provinceIdField;
	private final DataSourceFloatField daysField;
	private final DataSourceTextField remarkField;
	private final DataSourceBooleanField isEnableField;

	public DSLinkOfLeaveTypeAndProvince(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("LinkOfLeaveTypeAndProvince");


		leaveTypeLinkProvinceIdField = new DataSourceIntegerField("leaveTypeLinkProvinceId", "请假类型省份关联表");
		leaveTypeLinkProvinceIdField.setLength(11);
		leaveTypeLinkProvinceIdField.setPrimaryKey(true);
		leaveTypeLinkProvinceIdField.setRequired(true);
		leaveTypeLinkProvinceIdField.setHidden(true);


		leaveTypeIdField = new DataSourceIntegerField("leaveTypeId", "请假类型");
		leaveTypeIdField.setLength(11);
		leaveTypeIdField.setRequired(false);
		leaveTypeIdField.setHidden(false);
//		leaveTypeIdField.setValueMap(KeyValueManager.getValueMap("leave_types"));


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

