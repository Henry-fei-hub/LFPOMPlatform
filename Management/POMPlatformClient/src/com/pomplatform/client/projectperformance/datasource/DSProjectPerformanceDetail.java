package com.pomplatform.client.projectperformance.datasource;

import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.smartgwt.client.data.fields.DataSourceBooleanField;
import com.smartgwt.client.data.fields.DataSourceDateField;
import com.smartgwt.client.data.fields.DataSourceDateTimeField;
import com.smartgwt.client.data.fields.DataSourceFloatField;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;

public class DSProjectPerformanceDetail extends DBDataSource
{


	public static DSProjectPerformanceDetail instance = null;

	public static DSProjectPerformanceDetail getInstance() {
		if(instance == null) {
			instance = new DSProjectPerformanceDetail("DSProjectPerformanceDetail");
		}
		return instance;
	}

	private final DataSourceIntegerField projectPerformanceIdField;
	private final DataSourceIntegerField contractIdField;
	private final DataSourceIntegerField projectIdField;
	private final DataSourceFloatField integralField;
	private final DataSourceFloatField percentField;
	private final DataSourceFloatField performanceIntegralField;
	private final DataSourceIntegerField employeeIdField;
	private final DataSourceDateField recordDateField;
	private final DataSourceTextField clientComplaintField;
	private final DataSourceTextField reasonField;
	private final DataSourceBooleanField isSubmitField;
	private final DataSourceIntegerField performanceFlagField;
	private final DataSourceIntegerField businessTypeField;
	private final DataSourceIntegerField operateEmployeeIdField;
	private final DataSourceDateTimeField operateTimeField;
	private final DataSourceTextField remarkField;
	private final DataSourceIntegerField typeField;
	
	public DSProjectPerformanceDetail(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("ProjectPerformanceDetail");


		projectPerformanceIdField = new DataSourceIntegerField("projectPerformanceId", "主键编码");
		projectPerformanceIdField.setLength(11);
		projectPerformanceIdField.setPrimaryKey(true);
		projectPerformanceIdField.setRequired(true);
		projectPerformanceIdField.setHidden(true);


		contractIdField = new DataSourceIntegerField("contractId", "合同编码");
		contractIdField.setLength(11);
		contractIdField.setRequired(false);
		contractIdField.setHidden(true);
//		contractIdField.setValueMap(KeyValueManager.getValueMap("contracts"));
		KeyValueManager.loadValueMap("contracts",contractIdField);


		projectIdField = new DataSourceIntegerField("projectId", "项目编码");
		projectIdField.setLength(11);
		projectIdField.setRequired(false);
		projectIdField.setHidden(true);
		KeyValueManager.loadValueMap("projects",projectIdField);


		integralField = new DataSourceFloatField("integral", "积分");
		integralField.setLength(18);
		integralField.setDecimalPad(2);
		integralField.setFormat("#,###,###,###,###,##0.00");
		integralField.setRequired(false);
		integralField.setHidden(true);


		percentField = new DataSourceFloatField("percent", "比例");
		percentField.setLength(18);
		percentField.setDecimalPad(4);
		percentField.setFormat("##,###,###,###,##0.0000");
		percentField.setRequired(false);
		percentField.setHidden(false);


		performanceIntegralField = new DataSourceFloatField("performanceIntegral", "扣除/奖励积分");
		performanceIntegralField.setLength(18);
		performanceIntegralField.setDecimalPad(2);
		performanceIntegralField.setFormat("#,###,###,###,###,##0.00");
		performanceIntegralField.setRequired(false);
		performanceIntegralField.setHidden(false);


		employeeIdField = new DataSourceIntegerField("employeeId", "职员");
		employeeIdField.setLength(11);
		employeeIdField.setRequired(false);
		employeeIdField.setHidden(false);
//		employeeIdField.setValueMap(KeyValueManager.getValueMap("employees"));
		KeyValueManager.loadValueMap("employees",employeeIdField);

		recordDateField = new DataSourceDateField("recordDate", "日期");
		recordDateField.setRequired(false);
		recordDateField.setHidden(false);


		clientComplaintField = new DataSourceTextField("clientComplaint", "客户投诉");
		clientComplaintField.setLength(128);
		clientComplaintField.setRequired(false);
		clientComplaintField.setHidden(true);


		reasonField = new DataSourceTextField("reason", "原因");
		reasonField.setLength(256);
		reasonField.setRequired(false);
		reasonField.setValueMap(KeyValueManager.getValueMap("system_dictionary_84"));
		reasonField.setHidden(false);


		isSubmitField = new DataSourceBooleanField("isSubmit", "是否提交");
		isSubmitField.setRequired(false);
		isSubmitField.setHidden(true);


		performanceFlagField = new DataSourceIntegerField("performanceFlag", "绩效类型");
		performanceFlagField.setLength(11);
		performanceFlagField.setRequired(false);
		performanceFlagField.setHidden(true);


		businessTypeField = new DataSourceIntegerField("businessType", "业务类型");
		businessTypeField.setLength(11);
		businessTypeField.setRequired(false);
		businessTypeField.setHidden(true);
		businessTypeField.setValueMap(KeyValueManager.getValueMap("production_value_coefficient_type"));


		operateEmployeeIdField = new DataSourceIntegerField("operateEmployeeId", "操作人");
		operateEmployeeIdField.setLength(11);
		operateEmployeeIdField.setRequired(false);
		operateEmployeeIdField.setHidden(false);
//		operateEmployeeIdField.setValueMap(KeyValueManager.getValueMap("employees"));
		KeyValueManager.loadValueMap("employees",operateEmployeeIdField);

		operateTimeField = new DataSourceDateTimeField("operateTime", "操作时间");
		operateTimeField.setRequired(false);
		operateTimeField.setHidden(true);


		remarkField = new DataSourceTextField("remark", "备注");
		remarkField.setLength(1024);
		remarkField.setRequired(false);
		remarkField.setHidden(false);
		
		
		typeField = new DataSourceIntegerField("type", "类型");
		typeField.setLength(11);
		typeField.setRequired(false);
		typeField.setHidden(true);


		setFields(projectPerformanceIdField, contractIdField, projectIdField, integralField, typeField, percentField, performanceIntegralField, employeeIdField, clientComplaintField, reasonField, isSubmitField, performanceFlagField, businessTypeField, operateEmployeeIdField, recordDateField, operateTimeField, remarkField);
	}


}

