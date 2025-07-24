package com.pomplatform.client.plateintegralassignrecord.datasource;

import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.smartgwt.client.data.fields.DataSourceDateField;
import com.smartgwt.client.data.fields.DataSourceFloatField;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;

public class DSPlateIntegralAssignRecord extends DBDataSource
{


	public static DSPlateIntegralAssignRecord instance = null;

	public static DSPlateIntegralAssignRecord getInstance() {
		if(instance == null) {
			instance = new DSPlateIntegralAssignRecord("DSPlateIntegralAssignRecord");
		}
		return instance;
	}

	private final DataSourceIntegerField plateIntegralAssignRecordIdField;
	private final DataSourceIntegerField plateIdField;
	private final DataSourceTextField employeeNoField;
	private final DataSourceIntegerField employeeIdField;
	private final DataSourceFloatField assignIntegralField;
	private final DataSourceDateField assignDateField;
	private final DataSourceIntegerField plateEmployeeIdField;
	private final DataSourceTextField remarkField;

	public DSPlateIntegralAssignRecord(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("PlateIntegralAssignRecord");


		plateIntegralAssignRecordIdField = new DataSourceIntegerField("plateIntegralAssignRecordId", "主键编码");
		plateIntegralAssignRecordIdField.setLength(11);
		plateIntegralAssignRecordIdField.setPrimaryKey(true);
		plateIntegralAssignRecordIdField.setRequired(true);
		plateIntegralAssignRecordIdField.setHidden(true);


		plateIdField = new DataSourceIntegerField("plateId", "板块");
		plateIdField.setLength(11);
		plateIdField.setRequired(false);
		plateIdField.setHidden(true);
		plateIdField.setValueMap(KeyValueManager.getValueMap("system_dictionary_1"));


		employeeNoField = new DataSourceTextField("employeeNo", "工号");
		employeeNoField.setLength(64);
		employeeNoField.setRequired(true);
		employeeNoField.setHidden(false);


		employeeIdField = new DataSourceIntegerField("employeeId", "姓名");
		employeeIdField.setLength(11);
		employeeIdField.setRequired(false);
		employeeIdField.setHidden(false);
		employeeIdField.setValueMap(KeyValueManager.getValueMap("employees"));


		assignIntegralField = new DataSourceFloatField("assignIntegral", "发放积分");
		assignIntegralField.setLength(10);
		assignIntegralField.setDecimalPad(2);
		assignIntegralField.setFormat("##,###,##0.00");
		assignIntegralField.setRequired(false);
		assignIntegralField.setHidden(false);


		assignDateField = new DataSourceDateField("assignDate", "发放日期");
		assignDateField.setRequired(false);
		assignDateField.setHidden(false);


		plateEmployeeIdField = new DataSourceIntegerField("plateEmployeeId", "事业部负责人");
		plateEmployeeIdField.setLength(11);
		plateEmployeeIdField.setRequired(false);
		plateEmployeeIdField.setHidden(true);


		remarkField = new DataSourceTextField("remark", "备注");
		remarkField.setLength(512);
		remarkField.setRequired(false);
		remarkField.setHidden(false);


		setFields(plateIntegralAssignRecordIdField, plateIdField, employeeIdField, employeeNoField, assignIntegralField, assignDateField, plateEmployeeIdField, remarkField);
	}


}

