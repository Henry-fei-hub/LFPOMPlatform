package com.pomplatform.client.plateIntegralSends.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSPlateIntegralSend extends DBDataSource
{


	public static DSPlateIntegralSend instance = null;

	public static DSPlateIntegralSend getInstance() {
		if(instance == null) {
			instance = new DSPlateIntegralSend("DSPlateIntegralSend");
		}
		return instance;
	}

	private final DataSourceIntegerField plateIntegralSendIdField;
	private final DataSourceIntegerField plateIdField;
	private final DataSourceFloatField sendIntegralField;
	private final DataSourceIntegerField employeeIdField;
	private final DataSourceDateField sendDateField;
	private final DataSourceTextField remarkField;

	public DSPlateIntegralSend(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_TABLE);
		setActionName("PlateIntegralSend");


		plateIntegralSendIdField = new DataSourceIntegerField("plateIntegralSendId", "主键编码");
		plateIntegralSendIdField.setLength(11);
		plateIntegralSendIdField.setPrimaryKey(true);
		plateIntegralSendIdField.setRequired(true);
		plateIntegralSendIdField.setHidden(true);


		plateIdField = new DataSourceIntegerField("plateId", "业务部门");
		plateIdField.setLength(11);
		plateIdField.setRequired(false);
		plateIdField.setHidden(false);
		plateIdField.setValueMap(KeyValueManager.getValueMap("system_dictionary_1"));


		sendIntegralField = new DataSourceFloatField("sendIntegral", "补贴积分");
		sendIntegralField.setLength(10);
		sendIntegralField.setDecimalPad(2);
		sendIntegralField.setFormat("##,###,##0.00");
		sendIntegralField.setRequired(false);
		sendIntegralField.setHidden(false);


		employeeIdField = new DataSourceIntegerField("employeeId", "操作人");
		employeeIdField.setLength(11);
		employeeIdField.setRequired(false);
		employeeIdField.setHidden(false);
//		employeeIdField.setValueMap(KeyValueManager.getValueMap("employees"));
		KeyValueManager.loadValueMap("employees",employeeIdField);

		sendDateField = new DataSourceDateField("sendDate", "补贴日期");
		sendDateField.setRequired(false);
		sendDateField.setHidden(false);


		remarkField = new DataSourceTextField("remark", "备注");
		remarkField.setLength(512);
		remarkField.setRequired(false);
		remarkField.setHidden(false);


		setFields(plateIntegralSendIdField, plateIdField, sendIntegralField, employeeIdField, sendDateField, remarkField);
	}


}

