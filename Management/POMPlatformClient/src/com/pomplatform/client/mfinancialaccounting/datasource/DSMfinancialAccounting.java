package com.pomplatform.client.mfinancialaccounting.datasource;

import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.smartgwt.client.data.fields.DataSourceBooleanField;
import com.smartgwt.client.data.fields.DataSourceDateField;
import com.smartgwt.client.data.fields.DataSourceDateTimeField;
import com.smartgwt.client.data.fields.DataSourceFloatField;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;

public class DSMfinancialAccounting extends DBDataSource
{


	public static DSMfinancialAccounting instance = null;

	public static DSMfinancialAccounting getInstance() {
		if(instance == null) {
			instance = new DSMfinancialAccounting("DSMfinancialAccounting");
		}
		return instance;
	}

	private final DataSourceIntegerField processInstanceIdField;
	private final DataSourceIntegerField businessIdField;
	private final DataSourceIntegerField processTypeField;
	private final DataSourceDateTimeField createTimeField;
	private final DataSourceDateTimeField completeTimeField;
	private final DataSourceIntegerField employeeIdField;
	private final DataSourceTextField codeField;
	private final DataSourceFloatField amountField;
	private final DataSourceFloatField payMoneyField;
	private final DataSourceFloatField balanceAmountField;
	private final DataSourceIntegerField departmentIdField;
	private final DataSourceIntegerField companyIdField;
	private final DataSourceTextField remarkField;
	private final DataSourceTextField titleField;
	private final DataSourceTextField voucherNoField;
	private final DataSourceDateField postingDateField;
	private final DataSourceBooleanField bePackedField;

	public DSMfinancialAccounting(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("MfinancialAccounting");


		processInstanceIdField = new DataSourceIntegerField("processInstanceId", "主键编码");
		processInstanceIdField.setLength(11);
		processInstanceIdField.setPrimaryKey(true);
		processInstanceIdField.setRequired(true);
		processInstanceIdField.setHidden(true);


		businessIdField = new DataSourceIntegerField("businessId", "业务编码");
		businessIdField.setLength(11);
		businessIdField.setRequired(false);
		businessIdField.setHidden(true);


		processTypeField = new DataSourceIntegerField("processType", "流程类型");
		processTypeField.setLength(11);
		processTypeField.setRequired(false);
		processTypeField.setHidden(false);
		processTypeField.setValueMap(KeyValueManager.getValueMap("system_process_types"));


		createTimeField = new DataSourceDateTimeField("createTime", "创建时间");
		createTimeField.setRequired(false);
		createTimeField.setHidden(true);


		completeTimeField = new DataSourceDateTimeField("completeTime", "完成时间");
		completeTimeField.setRequired(false);
		completeTimeField.setHidden(false);


		employeeIdField = new DataSourceIntegerField("employeeId", "起草人");
		employeeIdField.setLength(11);
		employeeIdField.setRequired(false);
		employeeIdField.setHidden(false);
		employeeIdField.setValueMap(KeyValueManager.getValueMap("employees"));


		codeField = new DataSourceTextField("code", "报销编号");
		codeField.setLength(64);
		codeField.setRequired(false);
		codeField.setHidden(false);


		amountField = new DataSourceFloatField("amount", "报销总金额");
		amountField.setLength(18);
		amountField.setDecimalPad(5);
		amountField.setFormat("#,###,###,###,##0.00");
		amountField.setRequired(false);
		amountField.setHidden(false);


		payMoneyField = new DataSourceFloatField("payMoney", "付款金额");
		payMoneyField.setLength(16);
		payMoneyField.setDecimalPad(2);
		payMoneyField.setFormat("##,###,###,###,##0.00");
		payMoneyField.setRequired(false);
		payMoneyField.setHidden(false);


		balanceAmountField = new DataSourceFloatField("balanceAmount", "冲账金额");
		balanceAmountField.setLength(16);
		balanceAmountField.setDecimalPad(2);
		balanceAmountField.setFormat("##,###,###,###,##0.00");
		balanceAmountField.setRequired(false);
		balanceAmountField.setHidden(false);


		departmentIdField = new DataSourceIntegerField("departmentId", "归属部门");
		departmentIdField.setLength(11);
		departmentIdField.setRequired(false);
		departmentIdField.setHidden(false);
		departmentIdField.setValueMap(KeyValueManager.getValueMap("departments"));

		companyIdField = new DataSourceIntegerField("companyId", "归属公司");
		companyIdField.setLength(11);
		companyIdField.setRequired(false);
		companyIdField.setHidden(false);
		companyIdField.setValueMap(KeyValueManager.getValueMap("system_dictionary_26"));


		remarkField = new DataSourceTextField("remark", "备注");
		remarkField.setLength(60000);
		remarkField.setRequired(false);
		remarkField.setHidden(false);


		titleField = new DataSourceTextField("title", "主题");
		titleField.setLength(256);
		titleField.setRequired(false);
		titleField.setHidden(false);


		voucherNoField = new DataSourceTextField("voucherNo", "凭证号");
		voucherNoField.setLength(64);
		voucherNoField.setRequired(false);
		voucherNoField.setHidden(false);


		postingDateField = new DataSourceDateField("postingDate", "入账日期");
		postingDateField.setRequired(false);
		postingDateField.setHidden(false);
		
		bePackedField = new DataSourceBooleanField("bePacked", "是否被打包");
		bePackedField.setRequired(false);
		bePackedField.setHidden(false);

		setFields(processInstanceIdField, businessIdField, processTypeField, codeField, titleField, amountField, payMoneyField, balanceAmountField, employeeIdField, departmentIdField, companyIdField, createTimeField, voucherNoField, postingDateField, completeTimeField, bePackedField, remarkField);
	}


}

