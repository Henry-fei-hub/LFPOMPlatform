package com.pomplatform.client.bonuspayment.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSMemployeeaccountrecordeeeor extends DBDataSource
{


	public static DSMemployeeaccountrecordeeeor instance = null;

	public static DSMemployeeaccountrecordeeeor getInstance() {
		if(instance == null) {
			instance = new DSMemployeeaccountrecordeeeor("DSMemployeeaccountrecordeeeor");
		}
		return instance;
	}

	private final DataSourceIntegerField employeeAccountRecordIdField;
	private final DataSourceIntegerField employeeIdField;
	private final DataSourceIntegerField plateIdField;
	private final DataSourceIntegerField businessIdField;
	private final DataSourceIntegerField businessTypeIdField;
	private final DataSourceFloatField integralField;
	private final DataSourceDateField recordDateField;
	private final DataSourceBooleanField isLockField;
	private final DataSourceIntegerField operateEmployeeIdField;
	private final DataSourceDateTimeField operateTimeField;
	private final DataSourceTextField remarkField;

	public DSMemployeeaccountrecordeeeor(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("Memployeeaccountrecordeeeor");


		employeeAccountRecordIdField = new DataSourceIntegerField("employeeAccountRecordId", "主键编码");
		employeeAccountRecordIdField.setLength(11);
		employeeAccountRecordIdField.setPrimaryKey(true);
		employeeAccountRecordIdField.setRequired(true);
		employeeAccountRecordIdField.setHidden(false);


		employeeIdField = new DataSourceIntegerField("employeeId", "职员编码");
		employeeIdField.setLength(11);
		employeeIdField.setRequired(false);
		employeeIdField.setHidden(false);


		plateIdField = new DataSourceIntegerField("plateId", "业务部门");
		plateIdField.setLength(11);
		plateIdField.setRequired(false);
		plateIdField.setHidden(false);


		businessIdField = new DataSourceIntegerField("businessId", "业务功能编码");
		businessIdField.setLength(11);
		businessIdField.setRequired(false);
		businessIdField.setHidden(false);


		businessTypeIdField = new DataSourceIntegerField("businessTypeId", "10绩效奖金)");
		businessTypeIdField.setLength(11);
		businessTypeIdField.setRequired(false);
		businessTypeIdField.setHidden(false);


		integralField = new DataSourceFloatField("integral", "积分");
		integralField.setLength(18);
		integralField.setDecimalPad(2);
		integralField.setFormat("#,###,###,###,###,##0.00");
		integralField.setRequired(false);
		integralField.setHidden(false);


		recordDateField = new DataSourceDateField("recordDate", "日期");
		recordDateField.setRequired(false);
		recordDateField.setHidden(false);


		isLockField = new DataSourceBooleanField("isLock", "是否加锁");
		isLockField.setRequired(false);
		isLockField.setHidden(false);


		operateEmployeeIdField = new DataSourceIntegerField("operateEmployeeId", "操作人");
		operateEmployeeIdField.setLength(11);
		operateEmployeeIdField.setRequired(false);
		operateEmployeeIdField.setHidden(false);


		operateTimeField = new DataSourceDateTimeField("operateTime", "操作时间");
		operateTimeField.setRequired(false);
		operateTimeField.setHidden(false);


		remarkField = new DataSourceTextField("remark", "备注");
		remarkField.setLength(1024);
		remarkField.setRequired(false);
		remarkField.setHidden(false);


		setFields(employeeAccountRecordIdField, employeeIdField, plateIdField, businessIdField, businessTypeIdField, integralField, recordDateField, isLockField, operateEmployeeIdField, operateTimeField, remarkField);
	}


}

