package com.pomplatform.client.reimbursement.datasource;

import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.smartgwt.client.data.fields.DataSourceDateField;
import com.smartgwt.client.data.fields.DataSourceDateTimeField;
import com.smartgwt.client.data.fields.DataSourceFloatField;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;

public class DSSearchReimbursementInfo extends DBDataSource {

	public static DSSearchReimbursementInfo instance = null;

	public static DSSearchReimbursementInfo getInstance() {
		if (instance == null) {
			instance = new DSSearchReimbursementInfo("DSSearchReimbursementInfo");
		}
		return instance;
	}

	private final DataSourceIntegerField processTypeField;
	private final DataSourceIntegerField businessIdField;
	private final DataSourceIntegerField processIdField;
	private final DataSourceIntegerField processInstanceIdField;
	private final DataSourceIntegerField bearFeeIdField;
	private final DataSourceTextField bearFeeCodeField;
	private final DataSourceTextField bearFeeNameField;
	private final DataSourceTextField codeField;
	private final DataSourceIntegerField employeeIdField;
	private final DataSourceDateTimeField createTimeField;
	private final DataSourceIntegerField processStatusField;
	private final DataSourceFloatField amountField;
	private final DataSourceFloatField inputTaxField;
	private final DataSourceFloatField finalAmountField;
	private final DataSourceIntegerField plateIdField;
	private final DataSourceDateTimeField completeTimeField;
	private final DataSourceIntegerField subTableIdField;
	private final DataSourceTextField packageCodeField;
	private final DataSourceIntegerField currencyField;
	private final DataSourceIntegerField companyIdField;
	private final DataSourceIntegerField departmentIdField;
	private final DataSourceTextField remarkField;
	private final DataSourceTextField backViewNameField;
	private final DataSourceDateField instanceActivityStartTimeField;
	private final DataSourceIntegerField outDayField;
	private final DataSourceTextField bdCodeField;

	public DSSearchReimbursementInfo(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("SearchReimbursementInfo");

		processTypeField = new DataSourceIntegerField("processType", "流程类型");
		processTypeField.setLength(11);
		processTypeField.setRequired(false);
		processTypeField.setHidden(false);
		processTypeField.setValueMap(KeyValueManager.getValueMap("system_process_types"));

		businessIdField = new DataSourceIntegerField("businessId", "业务Id");
		businessIdField.setLength(11);
		businessIdField.setRequired(false);
		businessIdField.setHidden(true);
		businessIdField.setValueMap(KeyValueManager.getValueMap("system_dictionary_26"));

		processIdField = new DataSourceIntegerField("processId", "流程编码");
		processIdField.setLength(11);
		processIdField.setRequired(false);
		processIdField.setHidden(true);

		processInstanceIdField = new DataSourceIntegerField("processInstanceId", "流程实例编码");
		processInstanceIdField.setLength(11);
		processInstanceIdField.setRequired(false);
		processInstanceIdField.setHidden(true);

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

		packageCodeField = new DataSourceTextField("packageCode", "打包汇总编号");
		packageCodeField.setLength(128);
		packageCodeField.setRequired(true);
		packageCodeField.setHidden(false);

		currencyField = new DataSourceIntegerField("currency", "货币种类");
		currencyField.setLength(11);
		currencyField.setRequired(false);
		currencyField.setHidden(false);
		currencyField.setValueMap(KeyValueManager.getValueMap("system_dictionary_40"));

		remarkField = new DataSourceTextField("remark", "备注");
		remarkField.setLength(1024);
		remarkField.setRequired(true);
		remarkField.setHidden(false);

		companyIdField = new DataSourceIntegerField("companyId", "归属公司");
		companyIdField.setLength(11);
		companyIdField.setRequired(false);
		companyIdField.setHidden(false);
		companyIdField.setValueMap(KeyValueManager.getValueMap("company_records"));

		departmentIdField = new DataSourceIntegerField("departmentId", "所在部门");
		departmentIdField.setLength(11);
		departmentIdField.setRequired(false);
		departmentIdField.setHidden(false);
		departmentIdField.setValueMap(KeyValueManager.getValueMap("departments"));
		
		backViewNameField = new DataSourceTextField("backViewName", "节点名称");
		backViewNameField.setLength(64);
		backViewNameField.setRequired(false);
		
		instanceActivityStartTimeField = new DataSourceDateField("instanceActivityStartTime", "开始审批时间");
		instanceActivityStartTimeField.setLength(11);
		instanceActivityStartTimeField.setRequired(false);
		
		outDayField = new DataSourceIntegerField("outDay", "超出时间(天)");
		outDayField.setLength(11);
		
		bdCodeField = new DataSourceTextField("bdCode", "预算编号");
		bdCodeField.setLength(64);
		bdCodeField.setRequired(false);

		setFields(processTypeField, businessIdField, processIdField, processInstanceIdField, bearFeeIdField,
				bearFeeCodeField, bearFeeNameField, codeField, employeeIdField, remarkField, createTimeField,
				processStatusField, amountField, inputTaxField, finalAmountField, plateIdField, completeTimeField,
				subTableIdField, packageCodeField, currencyField, companyIdField, departmentIdField, backViewNameField,
				instanceActivityStartTimeField, outDayField, bdCodeField);
	}

}
