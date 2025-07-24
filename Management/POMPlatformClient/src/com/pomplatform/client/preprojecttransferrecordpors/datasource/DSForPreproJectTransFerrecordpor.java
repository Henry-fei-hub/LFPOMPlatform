package com.pomplatform.client.preprojecttransferrecordpors.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSForPreproJectTransFerrecordpor extends DBDataSource
{


	public static DSForPreproJectTransFerrecordpor instance = null;

	public static DSForPreproJectTransFerrecordpor getInstance() {
		if(instance == null) {
			instance = new DSForPreproJectTransFerrecordpor("DSForPreproJectTransFerrecordpor");
		}
		return instance;
	}

	private final DataSourceIntegerField preProjectTransferRecordIdField;
	private final DataSourceIntegerField preProjectIdField;
	private final DataSourceIntegerField employeeIdField;
	private final DataSourceIntegerField transferEmployeeIdField;
	private final DataSourceIntegerField operateEmployeeIdField;
	private final DataSourceDateTimeField operateTimeField;

	public DSForPreproJectTransFerrecordpor(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("ForPreproJectTransFerrecordpor");


		preProjectTransferRecordIdField = new DataSourceIntegerField("preProjectTransferRecordId", "主键编码");
		preProjectTransferRecordIdField.setLength(11);
		preProjectTransferRecordIdField.setPrimaryKey(true);
		preProjectTransferRecordIdField.setRequired(true);
		preProjectTransferRecordIdField.setHidden(false);
		preProjectTransferRecordIdField.setHidden(true);


		preProjectIdField = new DataSourceIntegerField("preProjectId", "项目id");
		preProjectIdField.setLength(11);
		preProjectIdField.setRequired(false);
		preProjectIdField.setHidden(false);
		KeyValueManager.loadValueMap("projects", preProjectIdField);
//		preProjectIdField.setValueMap(KeyValueManager.getValueMap("projects"));


		employeeIdField = new DataSourceIntegerField("employeeId", "原报备人");
		employeeIdField.setLength(11);
		employeeIdField.setRequired(false);
		employeeIdField.setHidden(false);
		employeeIdField.setValueMap(KeyValueManager.getValueMap("employees"));


		transferEmployeeIdField = new DataSourceIntegerField("transferEmployeeId", "转交人");
		transferEmployeeIdField.setLength(11);
		transferEmployeeIdField.setRequired(false);
		transferEmployeeIdField.setHidden(false);
		transferEmployeeIdField.setValueMap(KeyValueManager.getValueMap("employees"));


		operateEmployeeIdField = new DataSourceIntegerField("operateEmployeeId", "操作人");
		operateEmployeeIdField.setLength(11);
		operateEmployeeIdField.setRequired(false);
		operateEmployeeIdField.setHidden(false);
		operateEmployeeIdField.setValueMap(KeyValueManager.getValueMap("employees"));

		operateTimeField = new DataSourceDateTimeField("operateTime", "操作时间");
		operateTimeField.setRequired(false);
		operateTimeField.setHidden(false);


		setFields(preProjectTransferRecordIdField, preProjectIdField, employeeIdField, transferEmployeeIdField, operateEmployeeIdField, operateTimeField);
	}


}

