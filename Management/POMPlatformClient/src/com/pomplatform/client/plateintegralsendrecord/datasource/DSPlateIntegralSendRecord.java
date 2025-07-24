package com.pomplatform.client.plateintegralsendrecord.datasource;

import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.smartgwt.client.data.fields.DataSourceDateField;
import com.smartgwt.client.data.fields.DataSourceFloatField;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;

public class DSPlateIntegralSendRecord extends DBDataSource {

	public static DSPlateIntegralSendRecord instance = null;

	public static DSPlateIntegralSendRecord getInstance() {
		if (instance == null) {
			instance = new DSPlateIntegralSendRecord("DSPlateIntegralSendRecord");
		}
		return instance;
	}

	private final DataSourceIntegerField plateIntegralSendIdField;
	private final DataSourceIntegerField plateIdField;
	private final DataSourceIntegerField employeeIdField;
	private final DataSourceTextField employeeNoField;
	private final DataSourceFloatField sendIntegralField;
	private final DataSourceDateField sendDateField;
	private final DataSourceTextField remarkField;

	public DSPlateIntegralSendRecord(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("PlateIntegralSendRecord");

		plateIntegralSendIdField = new DataSourceIntegerField("plateIntegralSendId", "主键编码");
		plateIntegralSendIdField.setLength(11);
		plateIntegralSendIdField.setPrimaryKey(true);
		plateIntegralSendIdField.setRequired(true);
		plateIntegralSendIdField.setHidden(true);

		plateIdField = new DataSourceIntegerField("plateId", "业务部门");
		plateIdField.setLength(11);
		plateIdField.setRequired(false);
		plateIdField.setHidden(true);
		plateIdField.setValueMap(KeyValueManager.getValueMap("system_dictionary_1"));

		employeeIdField = new DataSourceIntegerField("employeeId", "操作人");
		employeeIdField.setLength(11);
		employeeIdField.setRequired(false);
		employeeIdField.setHidden(false);
		employeeIdField.setValueMap(KeyValueManager.getValueMap("employees"));

		employeeNoField = new DataSourceTextField("employeeNo", "操作人工号");
		employeeNoField.setLength(64);
		employeeNoField.setRequired(true);
		employeeNoField.setHidden(false);

		sendIntegralField = new DataSourceFloatField("sendIntegral", "补贴积分");
		sendIntegralField.setLength(10);
		sendIntegralField.setDecimalPad(2);
		sendIntegralField.setFormat("##,###,##0.00");
		sendIntegralField.setRequired(false);
		sendIntegralField.setHidden(false);

		sendDateField = new DataSourceDateField("sendDate", "补贴日期");
		sendDateField.setRequired(false);
		sendDateField.setHidden(false);

		remarkField = new DataSourceTextField("remark", "备注");
		remarkField.setLength(512);
		remarkField.setRequired(false);
		remarkField.setHidden(false);

		setFields(plateIntegralSendIdField, plateIdField, employeeIdField, employeeNoField, sendIntegralField,
				sendDateField, remarkField);
	}

}
