package com.pomplatform.client.sprocessbilllistpppor.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSSprocessbilllistpppor extends DBDataSource {

	public static DSSprocessbilllistpppor instance = null;

	public static DSSprocessbilllistpppor getInstance() {
		if (instance == null) {
			instance = new DSSprocessbilllistpppor("DSSprocessbilllistpppor");
		}
		return instance;
	}

	private final DataSourceIntegerField processBillListIdField;
	private final DataSourceIntegerField processInstanceIdField;
	private final DataSourceIntegerField processTypeField;
	private final DataSourceIntegerField businessIdField;
	private final DataSourceIntegerField payForField;
	private final DataSourceIntegerField employeeOrCompanyIdField;
	private final DataSourceIntegerField moneyAttributeField;
	private final DataSourceTextField payeeNameField;
	private final DataSourceTextField selfBankNameField;
	private final DataSourceTextField selfBankAccountField;
	private final DataSourceIntegerField otherNameField;
	private final DataSourceTextField otherBankNameField;
	private final DataSourceTextField otherBankAccountField;
	private final DataSourceFloatField payMoneyField;
	private final DataSourceFloatField balanceAmountField;
	private final DataSourceBooleanField isCompleteField;
	private final DataSourceTextField remarkField;
	private final DataSourceDateTimeField createTimeField;
	private final DataSourceIntegerField operatorField;
	private final DataSourceIntegerField companyIdField;
	private final DataSourceIntegerField yearField;
	private final DataSourceIntegerField monthField;
	private final DataSourceIntegerField payTypeField;
	private final DataSourceIntegerField personnelBusinessIdField;
	private final DataSourceIntegerField fundraisingProjectTypeIdField;
	private final DataSourceIntegerField employeeFundIssuanceIdField;

	public DSSprocessbilllistpppor(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("Sprocessbilllistpppor");

		processBillListIdField = new DataSourceIntegerField("processBillListId", "主键");
		processBillListIdField.setLength(11);
		processBillListIdField.setPrimaryKey(true);
		processBillListIdField.setRequired(true);
		processBillListIdField.setHidden(true);

		processInstanceIdField = new DataSourceIntegerField("processInstanceId", "流程实例编码");
		processInstanceIdField.setLength(11);
		processInstanceIdField.setRequired(false);
		processInstanceIdField.setHidden(true);

		processTypeField = new DataSourceIntegerField("processType", "流程类型");
		processTypeField.setLength(11);
		processTypeField.setRequired(false);
		processTypeField.setHidden(true);

		businessIdField = new DataSourceIntegerField("businessId", "业务Id");
		businessIdField.setLength(11);
		businessIdField.setRequired(false);
		businessIdField.setHidden(true);

		payForField = new DataSourceIntegerField("payFor", "收款人类型");
		payForField.setLength(11);
		payForField.setRequired(false);
		payForField.setHidden(true);
		payForField.setValueMap(KeyValueManager.getValueMap("system_dictionary_67"));

		employeeOrCompanyIdField = new DataSourceIntegerField("employeeOrCompanyId", "员工或者收款单位Id");
		employeeOrCompanyIdField.setLength(11);
		employeeOrCompanyIdField.setRequired(false);
		employeeOrCompanyIdField.setHidden(true);

		moneyAttributeField = new DataSourceIntegerField("moneyAttribute", "款项属性  项目报销款  公司报销款  等等");
		moneyAttributeField.setLength(11);
		moneyAttributeField.setRequired(false);
		moneyAttributeField.setHidden(true);

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

		otherNameField = new DataSourceIntegerField("otherName", "付款方");
		otherNameField.setLength(11);
		otherNameField.setRequired(false);
		otherNameField.setHidden(false);
		otherNameField.setValueMap(KeyValueManager.getValueMap("system_dictionary_69"));

		otherBankNameField = new DataSourceTextField("otherBankName", "银行名称(付款方)");
		otherBankNameField.setLength(128);
		otherBankNameField.setRequired(false);
		otherBankNameField.setHidden(false);

		otherBankAccountField = new DataSourceTextField("otherBankAccount", "银行账号(付款方)");
		otherBankAccountField.setLength(128);
		otherBankAccountField.setRequired(false);
		otherBankAccountField.setHidden(false);

		payMoneyField = new DataSourceFloatField("payMoney", "付款金额(实付金额)");
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

		isCompleteField = new DataSourceBooleanField("isComplete", "是否完成申请  false  没有  true  已经插入到资金流水表");
		isCompleteField.setRequired(false);
		isCompleteField.setHidden(true);

		remarkField = new DataSourceTextField("remark", "备注");
		remarkField.setLength(255);
		remarkField.setRequired(false);
		remarkField.setHidden(false);

		createTimeField = new DataSourceDateTimeField("createTime", "操作时间");
		createTimeField.setRequired(false);
		createTimeField.setHidden(true);

		operatorField = new DataSourceIntegerField("operator", "操作人");
		operatorField.setLength(11);
		operatorField.setRequired(false);
		operatorField.setHidden(true);

		companyIdField = new DataSourceIntegerField("companyId", "归属公司");
		companyIdField.setLength(11);
		companyIdField.setRequired(false);
		companyIdField.setHidden(true);

		yearField = new DataSourceIntegerField("year", "年");
		yearField.setLength(11);
		yearField.setRequired(false);
		yearField.setHidden(true);

		monthField = new DataSourceIntegerField("month", "月");
		monthField.setLength(11);
		monthField.setRequired(false);
		monthField.setHidden(true);

		payTypeField = new DataSourceIntegerField("payType", "付款类型");
		payTypeField.setLength(11);
		payTypeField.setRequired(false);
		payTypeField.setHidden(true);
		
		personnelBusinessIdField = new DataSourceIntegerField("personnelBusinessId", "业务流程ID");
		personnelBusinessIdField.setLength(11);
		personnelBusinessIdField.setRequired(false);
		personnelBusinessIdField.setHidden(true);
		
		fundraisingProjectTypeIdField = new DataSourceIntegerField("fundraisingProjectTypeId", "募投项目ID");
		fundraisingProjectTypeIdField.setLength(11);
		fundraisingProjectTypeIdField.setRequired(false);
		fundraisingProjectTypeIdField.setHidden(true);
		
		employeeFundIssuanceIdField = new DataSourceIntegerField("employeeFundIssuanceId", "员工资金发放主表ID");
		employeeFundIssuanceIdField.setLength(11);
		employeeFundIssuanceIdField.setRequired(false);
		employeeFundIssuanceIdField.setHidden(true);

		setFields(processBillListIdField, processInstanceIdField, processTypeField, businessIdField, payForField,
				employeeOrCompanyIdField, moneyAttributeField, payeeNameField, selfBankNameField, selfBankAccountField,
				otherNameField, otherBankNameField, otherBankAccountField, payMoneyField, balanceAmountField,
				isCompleteField, remarkField, createTimeField, operatorField, companyIdField, yearField, monthField,
				payTypeField, personnelBusinessIdField, fundraisingProjectTypeIdField, employeeFundIssuanceIdField);
	}

}
