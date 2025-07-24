package com.pomplatform.client.projectsettlement.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSProjectSettlementProcessApplication extends DBDataSource
{


	public static DSProjectSettlementProcessApplication instance = null;

	public static DSProjectSettlementProcessApplication getInstance() {
		if(instance == null) {
			instance = new DSProjectSettlementProcessApplication("DSProjectSettlementProcessApplication");
		}
		return instance;
	}

	private final DataSourceIntegerField settlementIdField;
	private final DataSourceIntegerField projectIdField;
	private final DataSourceIntegerField employeeIdField;
	private final DataSourceTextField remarkField;
	private final DataSourceDateField settlementDateField;
	private final DataSourceFloatField totalAmountField;
	private final DataSourceFloatField totalCostField;
	private final DataSourceFloatField projectAmountField;
	private final DataSourceFloatField leftAmountField;
	private final DataSourceIntegerField statusField;
	private final DataSourceIntegerField stageIdField;
	private final DataSourceIntegerField settlementStatusField;
	private final DataSourceIntegerField flagField;
	private final DataSourceField detailProjectSettlementDetail;

	public DSProjectSettlementProcessApplication(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("ProjectSettlementProcessApplication");


		settlementIdField = new DataSourceIntegerField("settlementId", "结算代码");
		settlementIdField.setLength(11);
		settlementIdField.setPrimaryKey(true);
		settlementIdField.setRequired(true);
		settlementIdField.setHidden(true);


		projectIdField = new DataSourceIntegerField("projectId", "项目代码");
		projectIdField.setLength(11);
		projectIdField.setRequired(true);
		projectIdField.setHidden(true);


		employeeIdField = new DataSourceIntegerField("employeeId", "申请人");
		employeeIdField.setLength(11);
		employeeIdField.setRequired(false);
		employeeIdField.setHidden(false);
		employeeIdField.setValueMap(KeyValueManager.getValueMap("employees"));

		remarkField = new DataSourceTextField("remark", "结算原因");
		remarkField.setLength(1024);
		remarkField.setRequired(false);
		remarkField.setHidden(false);


		settlementDateField = new DataSourceDateField("settlementDate", "结算日期");
		settlementDateField.setRequired(false);
		settlementDateField.setHidden(false);


		totalAmountField = new DataSourceFloatField("totalAmount", "确认积分");
		totalAmountField.setLength(18);
		totalAmountField.setDecimalPad(2);
		totalAmountField.setFormat("#,###,###,###,##0.00");
		totalAmountField.setRequired(false);
		totalAmountField.setHidden(false);


		totalCostField = new DataSourceFloatField("totalCost", "项目成本");
		totalCostField.setLength(18);
		totalCostField.setDecimalPad(2);
		totalCostField.setFormat("#,###,###,###,##0.00");
		totalCostField.setRequired(false);
		totalCostField.setHidden(false);


		projectAmountField = new DataSourceFloatField("projectAmount", "项目积分");
		projectAmountField.setLength(18);
		projectAmountField.setDecimalPad(2);
		projectAmountField.setFormat("#,###,###,###,##0.00");
		projectAmountField.setRequired(false);
		projectAmountField.setHidden(false);


		leftAmountField = new DataSourceFloatField("leftAmount", "项目结余积分");
		leftAmountField.setLength(18);
		leftAmountField.setDecimalPad(2);
		leftAmountField.setFormat("#,###,###,###,##0.00");
		leftAmountField.setRequired(false);
		leftAmountField.setHidden(false);


		statusField = new DataSourceIntegerField("status", "结算状态");
		statusField.setLength(11);
		statusField.setRequired(false);
		statusField.setHidden(true);


		stageIdField = new DataSourceIntegerField("stageId", "项目阶段");
		stageIdField.setLength(11);
		stageIdField.setRequired(false);
		stageIdField.setHidden(true);


		settlementStatusField = new DataSourceIntegerField("settlementStatus", "3已驳回");
		settlementStatusField.setLength(11);
		settlementStatusField.setRequired(false);
		settlementStatusField.setHidden(true);


		flagField = new DataSourceIntegerField("flag", "1历史数据结算；2新方式数据结算");
		flagField.setLength(11);
		flagField.setRequired(false);
		flagField.setHidden(true);

		detailProjectSettlementDetail = new DataSourceField("detailProjectSettlementDetail", FieldType.ANY);
		detailProjectSettlementDetail.setChildrenProperty(true);
		detailProjectSettlementDetail.setChildTagName("ProjectSettlementDetail");
		detailProjectSettlementDetail.setRequired(false);
		detailProjectSettlementDetail.setHidden(true);

		setFields(settlementIdField, projectIdField, employeeIdField, remarkField, settlementDateField, totalAmountField, totalCostField, projectAmountField, leftAmountField, statusField, stageIdField, settlementStatusField, flagField, detailProjectSettlementDetail);
	}


}

