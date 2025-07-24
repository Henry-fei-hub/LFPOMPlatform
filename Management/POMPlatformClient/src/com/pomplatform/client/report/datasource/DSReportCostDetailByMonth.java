package com.pomplatform.client.report.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSReportCostDetailByMonth extends DBDataSource
{


	public static DSReportCostDetailByMonth instance = null;

	public static DSReportCostDetailByMonth getInstance() {
		if(instance == null) {
			instance = new DSReportCostDetailByMonth("DSReportCostDetailByMonth");
		}
		return instance;
	}

	private final DataSourceIntegerField processTypeField;
	private final DataSourceIntegerField businessIdField;
	private final DataSourceIntegerField processIdField;
	private final DataSourceIntegerField processInstanceIdField;
	private final DataSourceIntegerField feeTypeField;
	private final DataSourceIntegerField bearFeeIdField;
	private final DataSourceTextField bearFeeCodeField;
	private final DataSourceTextField bearFeeNameField;
	private final DataSourceTextField codeField;
	private final DataSourceIntegerField employeeIdField;
	private final DataSourceDateTimeField createTimeField;
	private final DataSourceIntegerField processStatusField;
	private final DataSourceIntegerField costStatusField;
	private final DataSourceFloatField amountField;
	private final DataSourceFloatField inputTaxField;
	private final DataSourceFloatField finalAmountField;
	private final DataSourceIntegerField plateIdField;
	private final DataSourceDateTimeField completeTimeField;
	private final DataSourceIntegerField subTableIdField;

	public DSReportCostDetailByMonth(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("ReportCostDetailByMonth");


		processTypeField = new DataSourceIntegerField("processType", "流程类型");
		processTypeField.setLength(11);
		processTypeField.setRequired(false);
		processTypeField.setHidden(false);
		processTypeField.setValueMap(KeyValueManager.getValueMap("system_process_types"));


		businessIdField = new DataSourceIntegerField("businessId", "业务编码");
		businessIdField.setLength(11);
		businessIdField.setRequired(false);
		businessIdField.setHidden(true);
		businessIdField.setValueMap(KeyValueManager.getValueMap("system_dictionary_26"));


		processIdField = new DataSourceIntegerField("processId", "流程编码");
		processIdField.setLength(11);
		processIdField.setRequired(false);
		processIdField.setHidden(true);


		processInstanceIdField = new DataSourceIntegerField("processInstanceId", "流程编码");
		processInstanceIdField.setLength(11);
		processInstanceIdField.setRequired(false);
		processInstanceIdField.setHidden(true);


		feeTypeField = new DataSourceIntegerField("feeType", "费用类型");
		feeTypeField.setLength(11);
		feeTypeField.setRequired(false);
		feeTypeField.setHidden(false);
		feeTypeField.setValueMap(KeyValueManager.getValueMap("system_dictionary_121"));


		bearFeeIdField = new DataSourceIntegerField("bearFeeId", "");
		bearFeeIdField.setLength(11);
		bearFeeIdField.setRequired(true);
		bearFeeIdField.setHidden(true);


		bearFeeCodeField = new DataSourceTextField("bearFeeCode", "编号");
		bearFeeCodeField.setLength(-1);
		bearFeeCodeField.setRequired(true);
		bearFeeCodeField.setHidden(false);


		bearFeeNameField = new DataSourceTextField("bearFeeName", "费用承担主体");
		bearFeeNameField.setLength(-1);
		bearFeeNameField.setRequired(true);
		bearFeeNameField.setHidden(false);


		codeField = new DataSourceTextField("code", "报销编号");
		codeField.setLength(64);
		codeField.setRequired(false);
		codeField.setHidden(false);


		employeeIdField = new DataSourceIntegerField("employeeId", "申请人");
		employeeIdField.setLength(11);
		employeeIdField.setRequired(false);
		employeeIdField.setHidden(false);
		employeeIdField.setValueMap(KeyValueManager.getValueMap("employees"));


		createTimeField = new DataSourceDateTimeField("createTime", "申请时间");
		createTimeField.setRequired(false);
		createTimeField.setHidden(false);


		processStatusField = new DataSourceIntegerField("processStatus", "流程状态");
		processStatusField.setLength(11);
		processStatusField.setRequired(false);
		processStatusField.setHidden(false);
		processStatusField.setValueMap(KeyValueManager.getValueMap("system_dictionary_120"));


		costStatusField = new DataSourceIntegerField("costStatus", "结算状态");
		costStatusField.setLength(11);
		costStatusField.setRequired(true);
		costStatusField.setHidden(false);
		costStatusField.setValueMap(KeyValueManager.getValueMap("system_dictionary_16"));


		amountField = new DataSourceFloatField("amount", "报销金额");
		amountField.setLength(15);
		amountField.setDecimalPad(2);
		amountField.setFormat("#,###,###,###,##0.00");
		amountField.setRequired(false);
		amountField.setHidden(false);


		inputTaxField = new DataSourceFloatField("inputTax", "进项税");
		inputTaxField.setLength(15);
		inputTaxField.setDecimalPad(2);
		inputTaxField.setFormat("#,###,###,###,##0.00");
		inputTaxField.setRequired(false);
		inputTaxField.setHidden(false);


		finalAmountField = new DataSourceFloatField("finalAmount", "成本");
		finalAmountField.setLength(15);
		finalAmountField.setDecimalPad(2);
		finalAmountField.setFormat("#,###,###,###,##0.00");
		finalAmountField.setRequired(false);
		finalAmountField.setHidden(false);


		plateIdField = new DataSourceIntegerField("plateId", "业务部门");
		plateIdField.setLength(11);
		plateIdField.setRequired(false);
		plateIdField.setHidden(false);
		plateIdField.setValueMap(KeyValueManager.getValueMap("system_dictionary_1"));


		completeTimeField = new DataSourceDateTimeField("completeTime", "完成时间");
		completeTimeField.setRequired(false);
		completeTimeField.setHidden(false);


		subTableIdField = new DataSourceIntegerField("subTableId", "子表ID");
		subTableIdField.setLength(11);
		subTableIdField.setRequired(true);
		subTableIdField.setHidden(true);


		setFields(processTypeField, businessIdField, processIdField, processInstanceIdField, feeTypeField, bearFeeIdField, bearFeeCodeField, bearFeeNameField, codeField, employeeIdField, createTimeField, processStatusField, costStatusField, amountField, inputTaxField, finalAmountField, plateIdField, completeTimeField, subTableIdField);
	}


}

