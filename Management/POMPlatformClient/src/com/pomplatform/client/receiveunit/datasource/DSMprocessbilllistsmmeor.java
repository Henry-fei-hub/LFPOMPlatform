package com.pomplatform.client.receiveunit.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSMprocessbilllistsmmeor extends DBDataSource
{


	public static DSMprocessbilllistsmmeor instance = null;

	public static DSMprocessbilllistsmmeor getInstance() {
		if(instance == null) {
			instance = new DSMprocessbilllistsmmeor("DSMprocessbilllistsmmeor");
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
	private final DataSourceTextField equivalentNumberField;
	private final DataSourceDateTimeField completeTimeField;
	private final DataSourceIntegerField employeeIdField;

	public DSMprocessbilllistsmmeor(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("Mprocessbilllistsmmeor");


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


		payForField = new DataSourceIntegerField("payFor", "1 员工  2收款单位");
		payForField.setLength(11);
		payForField.setRequired(false);
		payForField.setHidden(true);


		employeeOrCompanyIdField = new DataSourceIntegerField("employeeOrCompanyId", "员工或者收款单位Id");
		employeeOrCompanyIdField.setLength(11);
		employeeOrCompanyIdField.setRequired(false);
		employeeOrCompanyIdField.setHidden(true);


		moneyAttributeField = new DataSourceIntegerField("moneyAttribute", "款项属性  项目报销款  公司报销款  等等");
		moneyAttributeField.setLength(11);
		moneyAttributeField.setRequired(false);
		moneyAttributeField.setHidden(true);


		payeeNameField = new DataSourceTextField("payeeName", "收款单位");
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


		otherNameField = new DataSourceIntegerField("otherName", "付款公司");
		otherNameField.setLength(11);
		otherNameField.setRequired(false);
		otherNameField.setHidden(false);
		otherNameField.setValueMap(KeyValueManager.getValueMap("system_dictionary_69"));


		otherBankNameField = new DataSourceTextField("otherBankName", "银行名称(付款方)");
		otherBankNameField.setLength(128);
		otherBankNameField.setRequired(false);
		otherBankNameField.setHidden(true);


		otherBankAccountField = new DataSourceTextField("otherBankAccount", "银行账号(付款方)");
		otherBankAccountField.setLength(128);
		otherBankAccountField.setRequired(false);
		otherBankAccountField.setHidden(true);


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


		isCompleteField = new DataSourceBooleanField("isComplete", "是否完成申请  false  没有  true  已经插入到资金流水表");
		isCompleteField.setRequired(false);
		isCompleteField.setHidden(true);


		remarkField = new DataSourceTextField("remark", "备注");
		remarkField.setLength(255);
		remarkField.setRequired(false);
		remarkField.setHidden(true);


		createTimeField = new DataSourceDateTimeField("createTime", "操作时间");
		createTimeField.setRequired(false);
		createTimeField.setHidden(true);


		operatorField = new DataSourceIntegerField("operator", "操作人");
		operatorField.setLength(11);
		operatorField.setRequired(false);
		operatorField.setHidden(true);


		equivalentNumberField = new DataSourceTextField("equivalentNumber", "对等号  借款/预付款与  冲账结合实现 借款与冲账");
		equivalentNumberField.setLength(64);
		equivalentNumberField.setRequired(false);
		equivalentNumberField.setHidden(true);


		completeTimeField = new DataSourceDateTimeField("completeTime", "付款时间");
		completeTimeField.setRequired(false);
		completeTimeField.setHidden(false);


		employeeIdField = new DataSourceIntegerField("employeeId", "申请人");
		employeeIdField.setLength(11);
		employeeIdField.setRequired(false);
		employeeIdField.setHidden(false);
		employeeIdField.setValueMap(KeyValueManager.getValueMap("employees"));


		setFields(processBillListIdField, processInstanceIdField, processTypeField, businessIdField, payForField, employeeOrCompanyIdField, moneyAttributeField, payeeNameField, selfBankNameField, selfBankAccountField, otherNameField, otherBankNameField, otherBankAccountField, payMoneyField, balanceAmountField, isCompleteField, remarkField, createTimeField, operatorField, equivalentNumberField, completeTimeField, employeeIdField);
	}


}

