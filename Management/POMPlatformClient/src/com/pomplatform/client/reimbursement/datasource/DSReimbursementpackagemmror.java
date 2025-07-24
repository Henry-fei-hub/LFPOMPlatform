package com.pomplatform.client.reimbursement.datasource;

import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.smartgwt.client.data.fields.DataSourceBooleanField;
import com.smartgwt.client.data.fields.DataSourceDateTimeField;
import com.smartgwt.client.data.fields.DataSourceFloatField;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;

public class DSReimbursementpackagemmror extends DBDataSource {

	public static DSReimbursementpackagemmror instance = null;

	public static DSReimbursementpackagemmror getInstance() {
		if (instance == null) {
			instance = new DSReimbursementpackagemmror("DSReimbursementpackagemmror");
		}
		return instance;
	}

	private final DataSourceIntegerField reimbursementPackageIdField;
	private final DataSourceIntegerField companyIdField;
	private final DataSourceFloatField amountField;
	private final DataSourceFloatField paymentAmountField;
	private final DataSourceFloatField strikeABalanceAmountField;
	private final DataSourceBooleanField isCompletedField;
	private final DataSourceTextField remarkField;
	private final DataSourceIntegerField employeeIdField;
	private final DataSourceIntegerField roleIdField;
	private final DataSourceIntegerField operatorIdField;
	private final DataSourceDateTimeField createTimeField;
	private final DataSourceDateTimeField updateTimeField;
	private final DataSourceTextField codeField;


	public DSReimbursementpackagemmror(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("Reimbursementpackagemmror");

		reimbursementPackageIdField = new DataSourceIntegerField("reimbursementPackageId", "编号");
		reimbursementPackageIdField.setLength(11);
		reimbursementPackageIdField.setPrimaryKey(true);
		reimbursementPackageIdField.setRequired(true);
		reimbursementPackageIdField.setHidden(false);

		companyIdField = new DataSourceIntegerField("companyId", "归属公司");
		companyIdField.setLength(11);
		companyIdField.setRequired(false);
		companyIdField.setHidden(false);
		companyIdField.setValueMap(KeyValueManager.getValueMap("system_dictionary_26"));

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

		isCompletedField = new DataSourceBooleanField("isCompleted", "是否通过审批");
		isCompletedField.setRequired(false);
		isCompletedField.setHidden(false);

		remarkField = new DataSourceTextField("remark", "备注");
		remarkField.setLength(255);
		remarkField.setRequired(false);
		remarkField.setHidden(false);

		employeeIdField = new DataSourceIntegerField("employeeId", "可操作人编码");
		employeeIdField.setLength(11);
		employeeIdField.setRequired(false);
		employeeIdField.setHidden(true);

		roleIdField = new DataSourceIntegerField("roleId", "打包接收角色");
		roleIdField.setLength(11);
		roleIdField.setRequired(false);
		roleIdField.setHidden(false);
//		roleIdField.setValueMap(KeyValueManager.getValueMap("roles"));
		KeyValueManager.loadValueMap("roles",roleIdField);

		operatorIdField = new DataSourceIntegerField("operatorId", "操作人Id");
		operatorIdField.setLength(11);
		operatorIdField.setRequired(false);
		operatorIdField.setHidden(true);
		
		codeField = new DataSourceTextField("code", "汇总单号");
		codeField.setLength(100);
		codeField.setRequired(false);
		codeField.setHidden(false);

		createTimeField = new DataSourceDateTimeField("createTime", "创建时间");
		createTimeField.setRequired(false);
		createTimeField.setHidden(false);

		updateTimeField = new DataSourceDateTimeField("updateTime", "修改时间");
		updateTimeField.setRequired(false);
		updateTimeField.setHidden(true);

		setFields(reimbursementPackageIdField, codeField, companyIdField, amountField, paymentAmountField,
				strikeABalanceAmountField, isCompletedField, remarkField, employeeIdField, roleIdField, operatorIdField,
				createTimeField, updateTimeField);
	}

}
