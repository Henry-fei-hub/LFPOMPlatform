package com.pomplatform.client.account.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSPlateDeployDetail extends DBDataSource
{


	public static DSPlateDeployDetail instance = null;

	public static DSPlateDeployDetail getInstance() {
		if(instance == null) {
			instance = new DSPlateDeployDetail("DSPlateDeployDetail");
		}
		return instance;
	}

	private final DataSourceIntegerField plateDeployDetailIdField;
	private final DataSourceIntegerField plateDeployRecordIdField;
	private final DataSourceIntegerField employeeIdField;
	private final DataSourceTextField plateIdField;
	private final DataSourceFloatField advanceIntegralField;
	private final DataSourceDateField advanceDateField;
	private final DataSourceDateTimeField operateTimeField;
	private final DataSourceIntegerField operateEmployeeIdField;
	private final DataSourceTextField remarkField;

	public DSPlateDeployDetail(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("PlateDeployDetails");


		plateDeployDetailIdField = new DataSourceIntegerField("plateDeployDetailId", "主键编码");
		plateDeployDetailIdField.setLength(11);
		plateDeployDetailIdField.setPrimaryKey(true);
		plateDeployDetailIdField.setRequired(true);
		plateDeployDetailIdField.setHidden(true);


		plateDeployRecordIdField = new DataSourceIntegerField("plateDeployRecordId", "总表id");
		plateDeployRecordIdField.setLength(11);
		plateDeployRecordIdField.setRequired(false);
		plateDeployRecordIdField.setHidden(true);


		employeeIdField = new DataSourceIntegerField("employeeId", "调配成员");
		employeeIdField.setLength(11);
		employeeIdField.setRequired(false);
		employeeIdField.setHidden(false);
		employeeIdField.setValueMap(KeyValueManager.getValueMap("employees"));


		plateIdField = new DataSourceTextField("plateName", "调配成员部门");
		plateIdField.setLength(11);
		plateIdField.setRequired(false);
		plateIdField.setHidden(false);
		plateIdField.setValueMap(KeyValueManager.getValueMap("plate_records"));


		advanceIntegralField = new DataSourceFloatField("advanceIntegral", "调配积分");
		advanceIntegralField.setLength(10);
		advanceIntegralField.setDecimalPad(2);
		advanceIntegralField.setFormat("##,###,##0.00");
		advanceIntegralField.setRequired(false);
		advanceIntegralField.setHidden(false);


		advanceDateField = new DataSourceDateField("advanceDate", "调配日期");
		advanceDateField.setRequired(false);
		advanceDateField.setHidden(false);


		operateTimeField = new DataSourceDateTimeField("operateTime", "操作时间");
		operateTimeField.setRequired(false);
		operateTimeField.setHidden(false);


		operateEmployeeIdField = new DataSourceIntegerField("operateEmployeeId", "操作人");
		operateEmployeeIdField.setLength(11);
		operateEmployeeIdField.setRequired(false);
		operateEmployeeIdField.setHidden(false);
		employeeIdField.setValueMap(KeyValueManager.getValueMap("employees"));


		remarkField = new DataSourceTextField("remark", "备注");
		remarkField.setLength(512);
		remarkField.setRequired(false);
		remarkField.setHidden(false);


		setFields(plateDeployDetailIdField, plateDeployRecordIdField, employeeIdField, plateIdField, advanceIntegralField, advanceDateField, operateTimeField, operateEmployeeIdField, remarkField);
	}


}

