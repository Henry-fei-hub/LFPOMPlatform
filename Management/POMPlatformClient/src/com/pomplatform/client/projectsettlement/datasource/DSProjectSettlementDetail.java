package com.pomplatform.client.projectsettlement.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSProjectSettlementDetail extends DBDataSource
{


	public static DSProjectSettlementDetail instance = null;

	public static DSProjectSettlementDetail getInstance() {
		if(instance == null) {
			instance = new DSProjectSettlementDetail("DSProjectSettlementDetail");
		}
		return instance;
	}

	private final DataSourceIntegerField settlementDetailIdField;
	private final DataSourceIntegerField settlementIdField;
	private final DataSourceIntegerField projectIdField;
	private final DataSourceIntegerField employeeIdField;
	private final DataSourceTextField workContentField;
	private final DataSourceDateField settlementDateField;
	private final DataSourceFloatField planAmountField;
	private final DataSourceFloatField realAmountField;
	private final DataSourceFloatField projectCostField;
	private final DataSourceFloatField finalAmountField;
	private final DataSourceIntegerField statusField;
	private final DataSourceFloatField finishPercentField;
	private final DataSourceBooleanField isReturnField;
	private final DataSourceFloatField adjustedAmountField;
	private final DataSourceIntegerField settlementStatusField;

	public DSProjectSettlementDetail(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_TABLE);
		setActionName("ProjectSettlementDetail");


		settlementDetailIdField = new DataSourceIntegerField("settlementDetailId", "结算详细代码");
		settlementDetailIdField.setLength(11);
		settlementDetailIdField.setPrimaryKey(true);
		settlementDetailIdField.setRequired(true);
		settlementDetailIdField.setHidden(true);


		settlementIdField = new DataSourceIntegerField("settlementId", "结算代码");
		settlementIdField.setLength(11);
		settlementIdField.setRequired(true);
		settlementIdField.setHidden(true);


		projectIdField = new DataSourceIntegerField("projectId", "项目代码");
		projectIdField.setLength(11);
		projectIdField.setRequired(true);
		projectIdField.setHidden(true);


		employeeIdField = new DataSourceIntegerField("employeeId", "员工名称");
		employeeIdField.setLength(11);
		employeeIdField.setRequired(false);
		employeeIdField.setHidden(false);
		employeeIdField.setValueMap(KeyValueManager.getValueMap("employees"));

		workContentField = new DataSourceTextField("workContent", "工作内容");
		workContentField.setLength(1024);
		workContentField.setRequired(false);
		workContentField.setHidden(false);


		settlementDateField = new DataSourceDateField("settlementDate", "结算日期");
		settlementDateField.setRequired(false);
		settlementDateField.setHidden(false);


		planAmountField = new DataSourceFloatField("planAmount", "计划分配");
		planAmountField.setLength(18);
		planAmountField.setDecimalPad(2);
		planAmountField.setFormat("#,###,###,###,##0.00");
		planAmountField.setRequired(false);
		planAmountField.setHidden(true);


		realAmountField = new DataSourceFloatField("realAmount", "实际分配");
		realAmountField.setLength(18);
		realAmountField.setDecimalPad(2);
		realAmountField.setFormat("#,###,###,###,##0.00");
		realAmountField.setRequired(false);
		realAmountField.setHidden(false);


		projectCostField = new DataSourceFloatField("projectCost", "分摊费用");
		projectCostField.setLength(18);
		projectCostField.setDecimalPad(2);
		projectCostField.setFormat("#,###,###,###,##0.00");
		projectCostField.setRequired(false);
		projectCostField.setHidden(false);


		finalAmountField = new DataSourceFloatField("finalAmount", "最终获得");
		finalAmountField.setLength(18);
		finalAmountField.setDecimalPad(2);
		finalAmountField.setFormat("#,###,###,###,##0.00");
		finalAmountField.setRequired(false);
		finalAmountField.setHidden(false);


		statusField = new DataSourceIntegerField("status", "结算状态system_dictionary_97");
		statusField.setLength(11);
		statusField.setRequired(false);
		statusField.setHidden(true);


		finishPercentField = new DataSourceFloatField("finishPercent", "本次确认比例占比");
		finishPercentField.setLength(10);
		finishPercentField.setDecimalPad(2);
		finishPercentField.setFormat("##,###,##0.00");
		finishPercentField.setRequired(false);
		finishPercentField.setHidden(false);


		isReturnField = new DataSourceBooleanField("isReturn", "该记录的积分是否回收的标识，true回收； false不回收");
		isReturnField.setRequired(false);
		isReturnField.setHidden(true);


		adjustedAmountField = new DataSourceFloatField("adjustedAmount", "调整后的积分");
		adjustedAmountField.setLength(18);
		adjustedAmountField.setDecimalPad(2);
		adjustedAmountField.setFormat("#,###,###,###,##0.00");
		adjustedAmountField.setRequired(false);
		adjustedAmountField.setHidden(true);


		settlementStatusField = new DataSourceIntegerField("settlementStatus", "3已驳回");
		settlementStatusField.setLength(11);
		settlementStatusField.setRequired(false);
		settlementStatusField.setHidden(true);


		setFields(settlementDetailIdField, settlementIdField, projectIdField, employeeIdField, settlementDateField, planAmountField, finalAmountField, realAmountField, projectCostField, statusField, finishPercentField, isReturnField, adjustedAmountField, settlementStatusField, workContentField);
	}


}

