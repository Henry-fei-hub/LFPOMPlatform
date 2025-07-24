package com.pomplatform.client.employeeaward.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSOnEmployeeIntegralBusiness extends DBDataSource
{


	public static DSOnEmployeeIntegralBusiness instance = null;

	public static DSOnEmployeeIntegralBusiness getInstance() {
		if(instance == null) {
			instance = new DSOnEmployeeIntegralBusiness("DSOnEmployeeIntegralBusiness");
		}
		return instance;
	}

	private final DataSourceIntegerField employeeIntegralBusinessIdField;
	private final DataSourceIntegerField businessTypeIdField;
	private final DataSourceTextField businessTypeNameField;
	private final DataSourceIntegerField employeeIdField;
	private final DataSourceFloatField integralField;
	private final DataSourceDateField recordDateField;
	private final DataSourceIntegerField statusField;
	private final DataSourceDateTimeField operateTimeField;
	private final DataSourceIntegerField operateEmployeeIdField;
	private final DataSourceTextField remarkField;
	private final DataSourceIntegerField businessIdField;

	public DSOnEmployeeIntegralBusiness(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("OnEmployeeIntegralBusiness");


		employeeIntegralBusinessIdField = new DataSourceIntegerField("employeeIntegralBusinessId", "主键编码");
		employeeIntegralBusinessIdField.setLength(11);
		employeeIntegralBusinessIdField.setPrimaryKey(true);
		employeeIntegralBusinessIdField.setRequired(true);
		employeeIntegralBusinessIdField.setHidden(true);


		businessTypeIdField = new DataSourceIntegerField("businessTypeId", "业务功能id");
		businessTypeIdField.setLength(11);
		businessTypeIdField.setRequired(false);
		businessTypeIdField.setHidden(true);


		businessTypeNameField = new DataSourceTextField("businessTypeName", "业务功能名称");
		businessTypeNameField.setLength(64);
		businessTypeNameField.setRequired(false);
		businessTypeNameField.setHidden(false);


		employeeIdField = new DataSourceIntegerField("employeeId", "职员姓名");
		employeeIdField.setLength(11);
		employeeIdField.setRequired(false);
		employeeIdField.setHidden(false);
		employeeIdField.setValueMap(KeyValueManager.getValueMap("employees"));


		integralField = new DataSourceFloatField("integral", "积分");
		integralField.setLength(18);
		integralField.setDecimalPad(2);
		integralField.setFormat("#,###,###,###,###,##0.00");
		integralField.setRequired(false);
		integralField.setHidden(false);


		recordDateField = new DataSourceDateField("recordDate", "日期");
		recordDateField.setRequired(false);
		recordDateField.setHidden(false);


		statusField = new DataSourceIntegerField("status", "状态");
		statusField.setLength(11);
		statusField.setRequired(false);
		statusField.setHidden(false);
		statusField.setValueMap(KeyValueManager.getValueMap("system_dictionary_118"));


		operateTimeField = new DataSourceDateTimeField("operateTime", "操作时间");
		operateTimeField.setRequired(false);
		operateTimeField.setHidden(true);


		operateEmployeeIdField = new DataSourceIntegerField("operateEmployeeId", "操作人");
		operateEmployeeIdField.setLength(11);
		operateEmployeeIdField.setRequired(false);
		operateEmployeeIdField.setHidden(true);


		remarkField = new DataSourceTextField("remark", "备注");
		remarkField.setLength(512);
		remarkField.setRequired(false);
		remarkField.setHidden(false);

		businessIdField = new DataSourceIntegerField("businessId","业务id");
		businessIdField.setHidden(true);

		setFields(employeeIntegralBusinessIdField, businessTypeIdField, businessTypeNameField, employeeIdField, integralField, recordDateField, operateTimeField, operateEmployeeIdField, remarkField, statusField,businessIdField);
	}


}

