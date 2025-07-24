package com.pomplatform.client.project.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSOnLoadProjectOverview extends DBDataSource
{


	public static DSOnLoadProjectOverview instance = null;

	public static DSOnLoadProjectOverview getInstance() {
		if(instance == null) {
			instance = new DSOnLoadProjectOverview("DSOnLoadProjectOverview");
		}
		return instance;
	}

	private final DataSourceIntegerField contractIdField;
	private final DataSourceIntegerField projectIdField;
	private final DataSourceFloatField totalIntegralField;
	private final DataSourceFloatField reserveIntegralField;
	private final DataSourceFloatField projectIntegralField;
	private final DataSourceFloatField percentField;
	private final DataSourceIntegerField totalCountField;
	private final DataSourceFloatField totalAmountField;
	private final DataSourceFloatField finalAmountField;
	private final DataSourceFloatField totalCostField;
	private final DataSourceFloatField projectAmountField;
	private final DataSourceFloatField leftAmountField;
	private final DataSourceFloatField reserveAmountField;
	private final DataSourceFloatField sureAmountField;

	public DSOnLoadProjectOverview(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("OnLoadProjectOverview");


		contractIdField = new DataSourceIntegerField("contractId", "合同id");
		contractIdField.setLength(11);
		contractIdField.setRequired(false);
		contractIdField.setHidden(false);


		projectIdField = new DataSourceIntegerField("projectId", "项目编码");
		projectIdField.setLength(11);
		projectIdField.setRequired(false);
		projectIdField.setHidden(false);


		totalIntegralField = new DataSourceFloatField("totalIntegral", "项目总积分");
		totalIntegralField.setLength(18);
		totalIntegralField.setDecimalPad(2);
		totalIntegralField.setFormat("#,###,###,###,###,##0.00");
		totalIntegralField.setRequired(false);
		totalIntegralField.setHidden(false);


		reserveIntegralField = new DataSourceFloatField("reserveIntegral", "预留积分");
		reserveIntegralField.setLength(18);
		reserveIntegralField.setDecimalPad(2);
		reserveIntegralField.setFormat("#,###,###,###,###,##0.00");
		reserveIntegralField.setRequired(false);
		reserveIntegralField.setHidden(false);


		projectIntegralField = new DataSourceFloatField("projectIntegral", "项目积分");
		projectIntegralField.setLength(18);
		projectIntegralField.setDecimalPad(2);
		projectIntegralField.setFormat("#,###,###,###,###,##0.00");
		projectIntegralField.setRequired(false);
		projectIntegralField.setHidden(false);


		percentField = new DataSourceFloatField("percent", "");
		percentField.setLength(12);
		percentField.setDecimalPad(2);
		percentField.setFormat("#,###,###,##0.00");
		percentField.setRequired(true);
		percentField.setHidden(false);


		totalCountField = new DataSourceIntegerField("totalCount", "");
		totalCountField.setLength(11);
		totalCountField.setRequired(true);
		totalCountField.setHidden(false);


		totalAmountField = new DataSourceFloatField("totalAmount", "本次结算积分");
		totalAmountField.setLength(18);
		totalAmountField.setDecimalPad(2);
		totalAmountField.setFormat("#,###,###,###,###,##0.00");
		totalAmountField.setRequired(false);
		totalAmountField.setHidden(false);


		finalAmountField = new DataSourceFloatField("finalAmount", "未结算项目成本");
		finalAmountField.setLength(12);
		finalAmountField.setDecimalPad(2);
		finalAmountField.setFormat("#,###,###,##0.00");
		finalAmountField.setRequired(false);
		finalAmountField.setHidden(false);


		totalCostField = new DataSourceFloatField("totalCost", "已结算项目成本");
		totalCostField.setLength(18);
		totalCostField.setDecimalPad(2);
		totalCostField.setFormat("#,###,###,###,###,##0.00");
		totalCostField.setRequired(false);
		totalCostField.setHidden(false);


		projectAmountField = new DataSourceFloatField("projectAmount", "");
		projectAmountField.setLength(12);
		projectAmountField.setDecimalPad(2);
		projectAmountField.setFormat("#,###,###,##0.00");
		projectAmountField.setRequired(true);
		projectAmountField.setHidden(false);


		leftAmountField = new DataSourceFloatField("leftAmount", "");
		leftAmountField.setLength(12);
		leftAmountField.setDecimalPad(2);
		leftAmountField.setFormat("#,###,###,##0.00");
		leftAmountField.setRequired(true);
		leftAmountField.setHidden(false);


		reserveAmountField = new DataSourceFloatField("reserveAmount", "");
		reserveAmountField.setLength(12);
		reserveAmountField.setDecimalPad(2);
		reserveAmountField.setFormat("#,###,###,##0.00");
		reserveAmountField.setRequired(true);
		reserveAmountField.setHidden(false);


		sureAmountField = new DataSourceFloatField("sureAmount", "");
		sureAmountField.setLength(12);
		sureAmountField.setDecimalPad(2);
		sureAmountField.setFormat("#,###,###,##0.00");
		sureAmountField.setRequired(true);
		sureAmountField.setHidden(false);


		setFields(contractIdField, projectIdField, totalIntegralField, reserveIntegralField, projectIntegralField, percentField, totalCountField, totalAmountField, finalAmountField, totalCostField, projectAmountField, leftAmountField, reserveAmountField, sureAmountField);
	}


}

