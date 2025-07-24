package com.pomplatform.client.account.datasource;

import com.delicacy.client.data.DBDataSource;
import com.smartgwt.client.data.fields.DataSourceFloatField;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;

public class DSSheetAccountAll extends DBDataSource {

	public static DSSheetAccountAll instance = null;

	public static DSSheetAccountAll getInstance() {
		if (instance == null) {
			instance = new DSSheetAccountAll("DSSheetAccountAll");
		}
		return instance;
	}

	private final DataSourceIntegerField projectIdField;
	private final DataSourceTextField contractCodeField;
	private final DataSourceTextField projectNameField;
	private final DataSourceFloatField leftIntegralField;
	private final DataSourceFloatField projectPerformanceAwardField;
	private final DataSourceFloatField projectPerformanceAchieveField;
	private final DataSourceFloatField projectPerformanceDeductField;
	private final DataSourceFloatField projectPerformanceField;

	public DSSheetAccountAll(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_CUSTOM);
		setActionName("AccountManageProcess");

		projectIdField = new DataSourceIntegerField("projectId", "订单ID");
		projectIdField.setLength(11);
		projectIdField.setRequired(false);
		projectIdField.setHidden(true);

		contractCodeField = new DataSourceTextField("contractCode", "订单编号");
		contractCodeField.setLength(64);
		contractCodeField.setRequired(false);
		contractCodeField.setHidden(false);

		projectNameField = new DataSourceTextField("projectName", "订单名称");
		projectNameField.setLength(64);
		projectNameField.setRequired(false);
		projectNameField.setHidden(false);

		leftIntegralField = new DataSourceFloatField("leftIntegral", "积分余额");
		leftIntegralField.setLength(18);
		leftIntegralField.setDecimalPad(2);
		leftIntegralField.setFormat("#,###,###,###,###,##0.00");
		leftIntegralField.setRequired(false);
		leftIntegralField.setHidden(false);
		
		projectPerformanceAwardField = new DataSourceFloatField("projectPerformanceAward", "项目绩效奖励");
		projectPerformanceAwardField.setLength(18);
		projectPerformanceAwardField.setDecimalPad(2);
		projectPerformanceAwardField.setFormat("#,###,###,###,###,##0.00");
		projectPerformanceAwardField.setRequired(false);
		projectPerformanceAwardField.setHidden(false);
		
		projectPerformanceAchieveField = new DataSourceFloatField("projectPerformanceAchieve", "项目绩效收入");
		projectPerformanceAchieveField.setLength(18);
		projectPerformanceAchieveField.setDecimalPad(2);
		projectPerformanceAchieveField.setFormat("#,###,###,###,###,##0.00");
		projectPerformanceAchieveField.setRequired(false);
		projectPerformanceAchieveField.setHidden(false);
		
		projectPerformanceDeductField = new DataSourceFloatField("projectPerformanceDeduct", "项目绩效扣除");
		projectPerformanceDeductField.setLength(18);
		projectPerformanceDeductField.setDecimalPad(2);
		projectPerformanceDeductField.setFormat("#,###,###,###,###,##0.00");
		projectPerformanceDeductField.setRequired(false);
		projectPerformanceDeductField.setHidden(false);
		
		projectPerformanceField = new DataSourceFloatField("projectPerformance", "项目绩效");
		projectPerformanceField.setLength(18);
		projectPerformanceField.setDecimalPad(2);
		projectPerformanceField.setFormat("#,###,###,###,###,##0.00");
		projectPerformanceField.setRequired(false);
		projectPerformanceField.setHidden(false);
		
		setFields(projectIdField, contractCodeField, projectNameField,leftIntegralField,projectPerformanceAwardField,projectPerformanceAchieveField,projectPerformanceDeductField,projectPerformanceField);
	}

}
