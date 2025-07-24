package com.pomplatform.client.account.datasource;

import com.delicacy.client.data.DBDataSource;
import com.smartgwt.client.data.fields.DataSourceFloatField;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;

public class DSProjectAccountAll extends DBDataSource {

	public static DSProjectAccountAll instance = null;

	public static DSProjectAccountAll getInstance() {
		if (instance == null) {
			instance = new DSProjectAccountAll("DSProjectAccountAll");
		}
		return instance;
	}

	private final DataSourceIntegerField contractIdField;
	private final DataSourceTextField contractCodeField;
	private final DataSourceTextField contractNameField;
	private final DataSourceFloatField leftIntegralField;
	private final DataSourceFloatField pmPerformanceAwardField;
	private final DataSourceFloatField pmPerformanceDeductField;
	private final DataSourceFloatField projectPerformanceRemainField;

	public DSProjectAccountAll(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_CUSTOM);
		setActionName("AccountManageProcess");

		contractIdField = new DataSourceIntegerField("contractId", "合同ID");
		contractIdField.setLength(11);
		contractIdField.setRequired(false);
		contractIdField.setHidden(true);

		contractCodeField = new DataSourceTextField("contractCode", "合同编号");
		contractCodeField.setLength(64);
		contractCodeField.setRequired(false);
		contractCodeField.setHidden(false);

		contractNameField = new DataSourceTextField("contractName", "合同名称");
		contractNameField.setLength(64);
		contractNameField.setRequired(false);
		contractNameField.setHidden(false);

		leftIntegralField = new DataSourceFloatField("leftIntegral", "积分余额");
		leftIntegralField.setLength(18);
		leftIntegralField.setDecimalPad(2);
		leftIntegralField.setFormat("#,###,###,###,###,##0.00");
		leftIntegralField.setRequired(false);
		leftIntegralField.setHidden(false);
		
		pmPerformanceAwardField = new DataSourceFloatField("pmPerformanceAward", "项目经理绩效奖励");
		pmPerformanceAwardField.setLength(18);
		pmPerformanceAwardField.setDecimalPad(2);
		pmPerformanceAwardField.setFormat("#,###,###,###,###,##0.00");
		pmPerformanceAwardField.setRequired(false);
		pmPerformanceAwardField.setHidden(false);
		
		pmPerformanceDeductField = new DataSourceFloatField("pmPerformanceDeduct", "项目经理绩效扣除");
		pmPerformanceDeductField.setLength(18);
		pmPerformanceDeductField.setDecimalPad(2);
		pmPerformanceDeductField.setFormat("#,###,###,###,###,##0.00");
		pmPerformanceDeductField.setRequired(false);
		pmPerformanceDeductField.setHidden(false);
		
		projectPerformanceRemainField = new DataSourceFloatField("projectPerformanceRemain", "项目绩效结余");
		projectPerformanceRemainField.setLength(18);
		projectPerformanceRemainField.setDecimalPad(2);
		projectPerformanceRemainField.setFormat("#,###,###,###,###,##0.00");
		projectPerformanceRemainField.setRequired(false);
		projectPerformanceRemainField.setHidden(false);
		
		setFields(contractIdField, contractCodeField, contractNameField,leftIntegralField,pmPerformanceAwardField,pmPerformanceDeductField,projectPerformanceRemainField);
	}

}
