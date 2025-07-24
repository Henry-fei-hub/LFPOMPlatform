package com.pomplatform.client.sreimbursementpackagedetailrror.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSSreimbursementpackagedetailrror extends DBDataSource
{


	public static DSSreimbursementpackagedetailrror instance = null;

	public static DSSreimbursementpackagedetailrror getInstance() {
		if(instance == null) {
			instance = new DSSreimbursementpackagedetailrror("DSSreimbursementpackagedetailrror");
		}
		return instance;
	}

	private final DataSourceIntegerField reimbursementPackageDetailIdField;
	private final DataSourceIntegerField reimbursementPackageIdField;
	private final DataSourceIntegerField processTypeIdField;
	private final DataSourceIntegerField processIdField;
	private final DataSourceIntegerField businessIdField;
	private final DataSourceIntegerField processInstanceIdField;
	private final DataSourceTextField codeField;
	private final DataSourceIntegerField drafterField;
	private final DataSourceIntegerField payForField;
	private final DataSourceIntegerField employeeOrCompanyIdField;
	private final DataSourceTextField payeeNameField;
	private final DataSourceTextField selfBankNameField;
	private final DataSourceTextField selfBankAccountField;
	private final DataSourceFloatField amountField;
	private final DataSourceFloatField paymentAmountField;
	private final DataSourceFloatField strikeABalanceAmountField;
	private final DataSourceIntegerField processBillListIdField;
	private final DataSourceDateTimeField createTimeField;
	private final DataSourceDateTimeField updateTimeField;

	public DSSreimbursementpackagedetailrror(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("Sreimbursementpackagedetailrror");


		reimbursementPackageDetailIdField = new DataSourceIntegerField("reimbursementPackageDetailId", "报销打包汇总详情表编码");
		reimbursementPackageDetailIdField.setLength(11);
		reimbursementPackageDetailIdField.setPrimaryKey(true);
		reimbursementPackageDetailIdField.setRequired(true);
		reimbursementPackageDetailIdField.setHidden(false);


		reimbursementPackageIdField = new DataSourceIntegerField("reimbursementPackageId", "报销打包表编码");
		reimbursementPackageIdField.setLength(11);
		reimbursementPackageIdField.setRequired(false);
		reimbursementPackageIdField.setHidden(false);


		processTypeIdField = new DataSourceIntegerField("processTypeId", "流程类型");
		processTypeIdField.setLength(11);
		processTypeIdField.setRequired(false);
		processTypeIdField.setHidden(false);
		processTypeIdField.setValueMap(KeyValueManager.getValueMap("system_process_types"));


		processIdField = new DataSourceIntegerField("processId", "流程");
		processIdField.setLength(11);
		processIdField.setRequired(false);
		processIdField.setHidden(false);


		businessIdField = new DataSourceIntegerField("businessId", "业务编码");
		businessIdField.setLength(11);
		businessIdField.setRequired(false);
		businessIdField.setHidden(false);


		processInstanceIdField = new DataSourceIntegerField("processInstanceId", "流程实例编码");
		processInstanceIdField.setLength(11);
		processInstanceIdField.setRequired(false);
		processInstanceIdField.setHidden(false);


		codeField = new DataSourceTextField("code", "编号");
		codeField.setLength(64);
		codeField.setRequired(false);
		codeField.setHidden(false);


		drafterField = new DataSourceIntegerField("drafter", "起草人");
		drafterField.setLength(11);
		drafterField.setRequired(false);
		drafterField.setHidden(false);
		drafterField.setValueMap(KeyValueManager.getValueMap("employees"));


		payForField = new DataSourceIntegerField("payFor", "收款类型");
		payForField.setLength(11);
		payForField.setRequired(false);
		payForField.setHidden(false);


		employeeOrCompanyIdField = new DataSourceIntegerField("employeeOrCompanyId", "员工或者收款单位Id");
		employeeOrCompanyIdField.setLength(11);
		employeeOrCompanyIdField.setRequired(false);
		employeeOrCompanyIdField.setHidden(false);


		payeeNameField = new DataSourceTextField("payeeName", "收款方");
		payeeNameField.setLength(128);
		payeeNameField.setRequired(false);
		payeeNameField.setHidden(false);


		selfBankNameField = new DataSourceTextField("selfBankName", "银行名称(收款方)");
		selfBankNameField.setLength(128);
		selfBankNameField.setRequired(false);
		selfBankNameField.setHidden(false);


		selfBankAccountField = new DataSourceTextField("selfBankAccount", "银行账号(收款方)");
		selfBankAccountField.setLength(128);
		selfBankAccountField.setRequired(false);
		selfBankAccountField.setHidden(false);


		amountField = new DataSourceFloatField("amount", "总金额");
		amountField.setLength(18);
		amountField.setDecimalPad(5);
		amountField.setFormat("#,###,###,###,##0.00");
		amountField.setRequired(false);
		amountField.setHidden(false);


		paymentAmountField = new DataSourceFloatField("paymentAmount", "付款金额");
		paymentAmountField.setLength(18);
		paymentAmountField.setDecimalPad(5);
		paymentAmountField.setFormat("#,###,###,###,##0.00");
		paymentAmountField.setRequired(false);
		paymentAmountField.setHidden(false);


		strikeABalanceAmountField = new DataSourceFloatField("strikeABalanceAmount", "冲账金额");
		strikeABalanceAmountField.setLength(18);
		strikeABalanceAmountField.setDecimalPad(5);
		strikeABalanceAmountField.setFormat("#,###,###,###,##0.00");
		strikeABalanceAmountField.setRequired(false);
		strikeABalanceAmountField.setHidden(false);


		processBillListIdField = new DataSourceIntegerField("processBillListId", "账单流水Id");
		processBillListIdField.setLength(11);
		processBillListIdField.setRequired(false);
		processBillListIdField.setHidden(true);


		createTimeField = new DataSourceDateTimeField("createTime", "开始时间");
		createTimeField.setRequired(false);
		createTimeField.setHidden(true);


		updateTimeField = new DataSourceDateTimeField("updateTime", "修改时间");
		updateTimeField.setRequired(false);
		updateTimeField.setHidden(true);


		setFields(reimbursementPackageDetailIdField, reimbursementPackageIdField, processTypeIdField, processIdField, businessIdField, processInstanceIdField, codeField, drafterField, payForField, employeeOrCompanyIdField, payeeNameField, selfBankNameField, selfBankAccountField, amountField, paymentAmountField, strikeABalanceAmountField, processBillListIdField, createTimeField, updateTimeField);
	}


}

