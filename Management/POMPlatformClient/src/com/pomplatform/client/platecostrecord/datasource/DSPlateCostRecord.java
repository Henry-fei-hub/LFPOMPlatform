package com.pomplatform.client.platecostrecord.datasource;

import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.smartgwt.client.data.fields.DataSourceBooleanField;
import com.smartgwt.client.data.fields.DataSourceDateField;
import com.smartgwt.client.data.fields.DataSourceFloatField;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;

public class DSPlateCostRecord extends DBDataSource
{


	public static DSPlateCostRecord instance = null;

	public static DSPlateCostRecord getInstance() {
		if(instance == null) {
			instance = new DSPlateCostRecord("DSPlateCostRecord");
		}
		return instance;
	}

	private final DataSourceIntegerField plateCostRecordIdField;
	private final DataSourceIntegerField plateIdField;
	private final DataSourceFloatField costIntegralField;
	private final DataSourceFloatField salaryIntegralField;
	private final DataSourceTextField remarkField;
	private final DataSourceBooleanField isSettlementField;
	private final DataSourceDateField costDateField;
	private final DataSourceIntegerField processIdField;
	private final DataSourceIntegerField processTypeField;
	private final DataSourceIntegerField processInstanceIdField;
	private final DataSourceIntegerField businessIdField;

	public DSPlateCostRecord(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("PlateCostRecord");


		plateCostRecordIdField = new DataSourceIntegerField("plateCostRecordId", "主键编码");
		plateCostRecordIdField.setLength(11);
		plateCostRecordIdField.setPrimaryKey(true);
		plateCostRecordIdField.setRequired(true);
		plateCostRecordIdField.setHidden(true);


		plateIdField = new DataSourceIntegerField("plateId", "业务部门");
		plateIdField.setLength(11);
		plateIdField.setRequired(false);
		plateIdField.setHidden(false);
		plateIdField.setValueMap(KeyValueManager.getValueMap("system_dictionary_1"));


		costIntegralField = new DataSourceFloatField("costIntegral", "运营成本");
		costIntegralField.setLength(10);
		costIntegralField.setDecimalPad(2);
		costIntegralField.setFormat("##,###,##0.00");
		costIntegralField.setRequired(false);
		costIntegralField.setHidden(false);


		salaryIntegralField = new DataSourceFloatField("salaryIntegral", "人工成本");
		salaryIntegralField.setLength(10);
		salaryIntegralField.setDecimalPad(2);
		salaryIntegralField.setFormat("##,###,##0.00");
		salaryIntegralField.setRequired(false);
		salaryIntegralField.setHidden(true);


		remarkField = new DataSourceTextField("remark", "备注");
		remarkField.setLength(512);
		remarkField.setRequired(false);
		remarkField.setHidden(false);


		isSettlementField = new DataSourceBooleanField("isSettlement", "是否结算");
		isSettlementField.setRequired(false);
		isSettlementField.setHidden(true);


		costDateField = new DataSourceDateField("costDate", "日期");
		costDateField.setRequired(false);
		costDateField.setHidden(false);
		
		
		processIdField = new DataSourceIntegerField("processId", "流程定义ID");
		processIdField.setLength(11);
		processIdField.setRequired(false);
		processIdField.setHidden(true);
		
		
		processTypeField = new DataSourceIntegerField("processType", "流程类型");
		processTypeField.setLength(11);
		processTypeField.setRequired(false);
		processTypeField.setHidden(true);
		
		
		processInstanceIdField = new DataSourceIntegerField("processInstanceId", "流程实例ID");
		processInstanceIdField.setLength(11);
		processInstanceIdField.setRequired(false);
		processInstanceIdField.setHidden(true);
		
		
		businessIdField = new DataSourceIntegerField("businessId", "业务ID");
		businessIdField.setLength(11);
		businessIdField.setRequired(false);
		businessIdField.setHidden(true);

		
		setFields(plateCostRecordIdField, plateIdField, costIntegralField, salaryIntegralField, remarkField, isSettlementField, costDateField, processIdField, processTypeField, processInstanceIdField, businessIdField);
	}


}

