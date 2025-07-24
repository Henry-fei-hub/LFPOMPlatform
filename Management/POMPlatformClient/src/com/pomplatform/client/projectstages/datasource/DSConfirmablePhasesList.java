package com.pomplatform.client.projectstages.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSConfirmablePhasesList extends DBDataSource
{


	public static DSConfirmablePhasesList instance = null;

	public static DSConfirmablePhasesList getInstance() {
		if(instance == null) {
			instance = new DSConfirmablePhasesList("DSConfirmablePhasesList");
		}
		return instance;
	}

	private final DataSourceIntegerField contractIdField;
	private final DataSourceTextField projectCodeField;
	private final DataSourceTextField projectNameField;
	private final DataSourceTextField infoCodeField;
	private final DataSourceFloatField projectAmountSumField;
	private final DataSourceFloatField percentSumField;
	private final DataSourceFloatField borrowMoneySumField;
	private final DataSourceFloatField percentField;
	private final DataSourceFloatField noBorrowMoneySumField;
	private final DataSourceFloatField noPercentField;

	public DSConfirmablePhasesList(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("ConfirmablePhasesList");


		contractIdField = new DataSourceIntegerField("contractId", "主订单编码");
		contractIdField.setLength(11);
		contractIdField.setPrimaryKey(true);
		contractIdField.setRequired(true);
		contractIdField.setHidden(true);


		projectCodeField = new DataSourceTextField("projectCode", "合同编号");
		projectCodeField.setLength(64);
		projectCodeField.setRequired(false);
		projectCodeField.setHidden(false);


		projectNameField = new DataSourceTextField("projectName", "合同名称");
		projectNameField.setLength(512);
		projectNameField.setRequired(false);
		projectNameField.setHidden(false);


		infoCodeField = new DataSourceTextField("infoCode", "信息编号");
		infoCodeField.setLength(32);
		infoCodeField.setRequired(false);
		infoCodeField.setHidden(false);


		projectAmountSumField = new DataSourceFloatField("projectAmountSum", "产值");
		projectAmountSumField.setLength(18);
		projectAmountSumField.setDecimalPad(2);
		projectAmountSumField.setFormat("#,###,###,###,###,##0.00");
		projectAmountSumField.setRequired(true);
		projectAmountSumField.setHidden(false);
		
		
		percentSumField = new DataSourceFloatField("percentSum", "设计阶段比例(%)");
		percentSumField.setLength(18);
		percentSumField.setDecimalPad(2);
		percentSumField.setFormat("#,###,###,###,###,##0.00");
		percentSumField.setRequired(true);
		percentSumField.setHidden(false);
		
		borrowMoneySumField = new DataSourceFloatField("borrowMoneySum", "已收款");
		borrowMoneySumField.setLength(18);
		borrowMoneySumField.setDecimalPad(2);
		borrowMoneySumField.setFormat("#,###,###,###,###,##0.00");
		borrowMoneySumField.setRequired(false);
		borrowMoneySumField.setHidden(false);


		percentField = new DataSourceFloatField("percent", "已收款比例");
		percentField.setLength(18);
		percentField.setDecimalPad(2);
		percentField.setFormat("#,###,###,###,###,##0.00%");
		percentField.setRequired(false);
		percentField.setHidden(false);


		noBorrowMoneySumField = new DataSourceFloatField("noBorrowMoneySum", "未收款");
		noBorrowMoneySumField.setLength(18);
		noBorrowMoneySumField.setDecimalPad(2);
		noBorrowMoneySumField.setFormat("#,###,###,###,###,##0.00");
		noBorrowMoneySumField.setRequired(false);
		noBorrowMoneySumField.setHidden(false);


		noPercentField = new DataSourceFloatField("noPercent", "未收款比例");
		noPercentField.setLength(18);
		noPercentField.setDecimalPad(2);
		noPercentField.setFormat("#,###,###,###,###,##0.00%");
		noPercentField.setRequired(false);
		noPercentField.setHidden(false);


		setFields(contractIdField, projectCodeField, projectNameField, infoCodeField, projectAmountSumField,percentSumField, borrowMoneySumField, percentField, noBorrowMoneySumField, noPercentField);
	}


}

