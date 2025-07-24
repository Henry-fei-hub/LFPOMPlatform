package com.pomplatform.client.reimbursement.datasource;

import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.smartgwt.client.data.fields.DataSourceBooleanField;
import com.smartgwt.client.data.fields.DataSourceDateField;
import com.smartgwt.client.data.fields.DataSourceDateTimeField;
import com.smartgwt.client.data.fields.DataSourceFloatField;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;

public class DSK3VoucherList extends DBDataSource
{


	public static DSK3VoucherList instance = null;

	public static DSK3VoucherList getInstance() {
		if(instance == null) {
			instance = new DSK3VoucherList("DSK3VoucherList");
		}
		return instance;
	}

	private final DataSourceIntegerField k3VoucherIdField;
	private final DataSourceIntegerField projectIdField;
	private final DataSourceIntegerField companyIdField;
	private final DataSourceIntegerField sequenceNumberField;
	private final DataSourceIntegerField internalSequenceNumberField;
	private final DataSourceIntegerField codeTypeField;
	private final DataSourceIntegerField codeIdField;
	private final DataSourceTextField codeField;
	private final DataSourceTextField nameField;
	private final DataSourceIntegerField secondaryCodeTypeField;
	private final DataSourceIntegerField secondaryCodeIdField;
	private final DataSourceTextField secondaryCodeField;
	private final DataSourceTextField secondaryNameField;
	private final DataSourceTextField remarkField;
	private final DataSourceTextField simplifyRemarkField;
	private final DataSourceFloatField debitSideField;
	private final DataSourceFloatField creditSideField;
	private final DataSourceTextField reimbursementPackageCodeField;
	private final DataSourceFloatField amountOfReimbursementField;
	private final DataSourceFloatField inputTaxField;
	private final DataSourceFloatField inputTaxRebateField;
	private final DataSourceTextField selfBankAccountField;
	private final DataSourceTextField otherBankAccountField;
	private final DataSourceBooleanField needToChangeField;
	private final DataSourceDateField vestingDateField;
	private final DataSourceBooleanField lockedField;
	private final DataSourceDateTimeField createTimeField;
	private final DataSourceDateTimeField updateTimeField;
	private final DataSourceDateTimeField lockedTimeField;
	private final DataSourceIntegerField processIdField;
	private final DataSourceIntegerField processInstanceIdField;
	private final DataSourceIntegerField processTypeField;
	private final DataSourceIntegerField businessIdField;

	public DSK3VoucherList(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("K3VoucherList");


		k3VoucherIdField = new DataSourceIntegerField("k3VoucherId", "主键编码");
		k3VoucherIdField.setLength(11);
		k3VoucherIdField.setPrimaryKey(true);
		k3VoucherIdField.setRequired(true);
		k3VoucherIdField.setHidden(true);


		projectIdField = new DataSourceIntegerField("projectId", "项目");
		projectIdField.setLength(11);
		projectIdField.setRequired(false);
		projectIdField.setHidden(true);
//		KeyValueManager.loadValueMap("projects",projectIdField);
		KeyValueManager.loadValueMap("projects",projectIdField);


		companyIdField = new DataSourceIntegerField("companyId", "归属公司");
		companyIdField.setLength(11);
		companyIdField.setRequired(false);
		companyIdField.setHidden(false);
		companyIdField.setValueMap(KeyValueManager.getValueMap("system_dictionary_26"));


		sequenceNumberField = new DataSourceIntegerField("sequenceNumber", "凭证号");
		sequenceNumberField.setLength(11);
		sequenceNumberField.setRequired(false);
		sequenceNumberField.setHidden(false);


		internalSequenceNumberField = new DataSourceIntegerField("internalSequenceNumber", "凭证内序号");
		internalSequenceNumberField.setLength(11);
		internalSequenceNumberField.setRequired(false);
		internalSequenceNumberField.setHidden(false);


		codeTypeField = new DataSourceIntegerField("codeType", "科目类型");
		codeTypeField.setLength(11);
		codeTypeField.setRequired(false);
		codeTypeField.setHidden(true);
		
		
		codeIdField = new DataSourceIntegerField("codeId", "科目ID");
		codeIdField.setLength(11);
		codeIdField.setRequired(false);
		codeIdField.setHidden(true);
		
		
		codeField = new DataSourceTextField("code", "科目代码");
		codeField.setLength(64);
		codeField.setRequired(false);
		codeField.setHidden(false);


		nameField = new DataSourceTextField("name", "科目名称");
		nameField.setLength(128);
		nameField.setRequired(false);
		nameField.setHidden(false);
		
		
		secondaryCodeTypeField = new DataSourceIntegerField("secondaryCodeType", "辅助核算类型");
		secondaryCodeTypeField.setLength(11);
		secondaryCodeTypeField.setRequired(false);
		secondaryCodeTypeField.setHidden(true);
		
		
		secondaryCodeIdField = new DataSourceIntegerField("secondaryCodeId", "辅助核算ID");
		secondaryCodeIdField.setLength(11);
		secondaryCodeIdField.setRequired(false);
		secondaryCodeIdField.setHidden(true);


		secondaryCodeField = new DataSourceTextField("secondaryCode", "辅助核算代码");
		secondaryCodeField.setLength(64);
		secondaryCodeField.setRequired(false);
		secondaryCodeField.setHidden(false);


		secondaryNameField = new DataSourceTextField("secondaryName", "辅助核算名称");
		secondaryNameField.setLength(128);
		secondaryNameField.setRequired(false);
		secondaryNameField.setHidden(false);


		remarkField = new DataSourceTextField("remark", "备注");
		remarkField.setLength(255);
		remarkField.setRequired(false);
		remarkField.setHidden(false);


		simplifyRemarkField = new DataSourceTextField("simplifyRemark", "简化备注");
		simplifyRemarkField.setLength(50);
		simplifyRemarkField.setRequired(false);
		simplifyRemarkField.setHidden(false);


		debitSideField = new DataSourceFloatField("debitSide", "借方");
		debitSideField.setLength(18);
		debitSideField.setDecimalPad(2);
		debitSideField.setFormat("#,###,###,###,###,##0.00");
		debitSideField.setRequired(false);
		debitSideField.setHidden(false);


		creditSideField = new DataSourceFloatField("creditSide", "贷方");
		creditSideField.setLength(18);
		creditSideField.setDecimalPad(2);
		creditSideField.setFormat("#,###,###,###,###,##0.00");
		creditSideField.setRequired(false);
		creditSideField.setHidden(false);


		reimbursementPackageCodeField = new DataSourceTextField("reimbursementPackageCode", "报销汇总编号");
		reimbursementPackageCodeField.setLength(64);
		reimbursementPackageCodeField.setRequired(false);
		reimbursementPackageCodeField.setHidden(false);


		amountOfReimbursementField = new DataSourceFloatField("amountOfReimbursement", "报销金额");
		amountOfReimbursementField.setLength(18);
		amountOfReimbursementField.setDecimalPad(2);
		amountOfReimbursementField.setFormat("#,###,###,###,###,##0.00");
		amountOfReimbursementField.setRequired(false);
		amountOfReimbursementField.setHidden(false);


		inputTaxField = new DataSourceFloatField("inputTax", "进项税");
		inputTaxField.setLength(18);
		inputTaxField.setDecimalPad(2);
		inputTaxField.setFormat("#,###,###,###,##0.00");
		inputTaxField.setRequired(false);
		inputTaxField.setHidden(false);
		
		
		inputTaxRebateField = new DataSourceFloatField("inputTaxRebate", "进项税转出金额");
		inputTaxRebateField.setLength(18);
		inputTaxRebateField.setDecimalPad(2);
		inputTaxRebateField.setFormat("#,###,###,###,##0.00");
		inputTaxRebateField.setRequired(false);
		inputTaxRebateField.setHidden(false);


		selfBankAccountField = new DataSourceTextField("selfBankAccount", "我方银行账号");
		selfBankAccountField.setLength(128);
		selfBankAccountField.setRequired(false);
		selfBankAccountField.setHidden(false);


		otherBankAccountField = new DataSourceTextField("otherBankAccount", "对方银行账号");
		otherBankAccountField.setLength(128);
		otherBankAccountField.setRequired(false);
		otherBankAccountField.setHidden(false);


		needToChangeField = new DataSourceBooleanField("needToChange", "需要调整");
		needToChangeField.setRequired(false);
		needToChangeField.setHidden(false);


		vestingDateField = new DataSourceDateField("vestingDate", "归属日期");
		vestingDateField.setRequired(false);
		vestingDateField.setHidden(false);


		lockedField = new DataSourceBooleanField("locked", "是否定稿");
		lockedField.setRequired(false);
		lockedField.setHidden(false);


		createTimeField = new DataSourceDateTimeField("createTime", "创建时间");
		createTimeField.setRequired(false);
		createTimeField.setHidden(true);


		updateTimeField = new DataSourceDateTimeField("updateTime", "修改时间");
		updateTimeField.setRequired(false);
		updateTimeField.setHidden(true);


		lockedTimeField = new DataSourceDateTimeField("lockedTime", "定稿时间");
		lockedTimeField.setRequired(false);
		lockedTimeField.setHidden(true);


		processIdField = new DataSourceIntegerField("processId", "流程ID");
		processIdField.setLength(11);
		processIdField.setRequired(false);
		processIdField.setHidden(true);
		
		
		processInstanceIdField = new DataSourceIntegerField("processInstanceId", "流程实例ID");
		processInstanceIdField.setLength(11);
		processInstanceIdField.setRequired(false);
		processInstanceIdField.setHidden(true);
		
		
		processTypeField = new DataSourceIntegerField("processType", "流程类型");
		processTypeField.setLength(11);
		processTypeField.setRequired(false);
		processTypeField.setHidden(true);
		
		
		businessIdField = new DataSourceIntegerField("businessId", "流程实例业务ID");
		businessIdField.setLength(11);
		businessIdField.setRequired(false);
		businessIdField.setHidden(true);
		
		
		
		setFields(k3VoucherIdField, projectIdField, companyIdField, sequenceNumberField, internalSequenceNumberField, codeTypeField, codeIdField, codeField, nameField, secondaryCodeTypeField, secondaryCodeIdField, secondaryCodeField, secondaryNameField, remarkField, simplifyRemarkField, debitSideField, creditSideField, reimbursementPackageCodeField, amountOfReimbursementField, inputTaxField, inputTaxRebateField, selfBankAccountField, otherBankAccountField, needToChangeField, vestingDateField, lockedField, createTimeField, updateTimeField, lockedTimeField);
	}


}

