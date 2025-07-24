package com.pomplatform.client.scapitaldistributionor.datasource;

import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.smartgwt.client.data.fields.DataSourceDateTimeField;
import com.smartgwt.client.data.fields.DataSourceFloatField;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;

public class DSCapitalDistributionsApplyOfWorkflow extends DBDataSource {

	public static DSCapitalDistributionsApplyOfWorkflow instance = null;

	public static DSCapitalDistributionsApplyOfWorkflow getInstance() {
		if (instance == null) {
			instance = new DSCapitalDistributionsApplyOfWorkflow("DSCapitalDistributionsApplyOfWorkflow");
		}
		return instance;
	}

	private final DataSourceIntegerField processInstanceIdField;
	private final DataSourceIntegerField processTypeField;
	private final DataSourceIntegerField businessIdField;
	private final DataSourceTextField businessNameField;
	private final DataSourceIntegerField processIdField;
	private final DataSourceIntegerField processInstanceActivityIdField;
	private final DataSourceIntegerField processStatusField;
	private final DataSourceDateTimeField createTimeField;
	private final DataSourceDateTimeField completeTimeField;
	private final DataSourceIntegerField departmentIdField;
	private final DataSourceIntegerField employeeIdField;
	private final DataSourceTextField codeField;
	private final DataSourceIntegerField companyIdField;
	private final DataSourceTextField titleField;
	private final DataSourceFloatField contractChangeAmountField;
	private final DataSourceIntegerField mainProfessionalField;
	private final DataSourceTextField remarkField;
	private final DataSourceTextField contractCodeField;
	private final DataSourceFloatField signingMoneySumField;
	private final DataSourceTextField contractNameField;
	private final DataSourceTextField customerNameField;
	private final DataSourceDateTimeField happenDateField;
	private final DataSourceTextField otherNameField;
	private final DataSourceFloatField borrowMoneyField;
	private final DataSourceFloatField allBorrowMoneyField;

	public DSCapitalDistributionsApplyOfWorkflow(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("CapitalDistributionsApplyOfWorkflow");

		processInstanceIdField = new DataSourceIntegerField("processInstanceId", "主键编码");
		processInstanceIdField.setLength(11);
		processInstanceIdField.setPrimaryKey(true);
		processInstanceIdField.setRequired(true);
		processInstanceIdField.setHidden(true);

		processTypeField = new DataSourceIntegerField("processType", "流程类型");
		processTypeField.setLength(11);
		processTypeField.setRequired(false);
		processTypeField.setHidden(true);

		businessIdField = new DataSourceIntegerField("businessId", "业务编码");
		businessIdField.setLength(11);
		businessIdField.setRequired(false);
		businessIdField.setHidden(true);

		businessNameField = new DataSourceTextField("businessName", "业务名称");
		businessNameField.setLength(256);
		businessNameField.setRequired(false);
		businessNameField.setHidden(true);

		processIdField = new DataSourceIntegerField("processId", "流程编码");
		processIdField.setLength(11);
		processIdField.setRequired(false);
		processIdField.setHidden(true);

		processInstanceActivityIdField = new DataSourceIntegerField("processInstanceActivityId", "活动实列编码");
		processInstanceActivityIdField.setLength(11);
		processInstanceActivityIdField.setRequired(false);
		processInstanceActivityIdField.setHidden(true);

		processStatusField = new DataSourceIntegerField("processStatus", "流程状态");
		processStatusField.setLength(11);
		processStatusField.setRequired(false);
		processStatusField.setHidden(true);

		createTimeField = new DataSourceDateTimeField("createTime", "申请时间");
		createTimeField.setRequired(false);
		createTimeField.setHidden(false);

		completeTimeField = new DataSourceDateTimeField("completeTime", "完成时间");
		completeTimeField.setRequired(false);
		completeTimeField.setHidden(false);

		departmentIdField = new DataSourceIntegerField("departmentId", "报销部门");
		departmentIdField.setLength(11);
		departmentIdField.setRequired(false);
		departmentIdField.setHidden(true);

		employeeIdField = new DataSourceIntegerField("employeeId", "起草人");
		employeeIdField.setLength(11);
		employeeIdField.setRequired(false);
		employeeIdField.setHidden(false);
		employeeIdField.setValueMap(KeyValueManager.getValueMap("employees"));

		codeField = new DataSourceTextField("code", "报销编号");
		codeField.setLength(64);
		codeField.setRequired(false);
		codeField.setHidden(false);

		companyIdField = new DataSourceIntegerField("companyId", "归属公司");
		companyIdField.setLength(11);
		companyIdField.setRequired(false);
		companyIdField.setHidden(true);

		titleField = new DataSourceTextField("title", "主题");
		titleField.setLength(255);
		titleField.setRequired(false);
		titleField.setHidden(false);

		contractChangeAmountField = new DataSourceFloatField("contractChangeAmount", "合同变更金额");
		contractChangeAmountField.setLength(16);
		contractChangeAmountField.setDecimalPad(2);
		contractChangeAmountField.setFormat("##,###,###,###,##0.00");
		contractChangeAmountField.setRequired(false);
		contractChangeAmountField.setHidden(false);

		mainProfessionalField = new DataSourceIntegerField("mainProfessional", "主专业");
		mainProfessionalField.setLength(11);
		mainProfessionalField.setRequired(false);
		mainProfessionalField.setHidden(false);
		mainProfessionalField.setValueMap(KeyValueManager.getValueMap("plate_records"));

		remarkField = new DataSourceTextField("remark", "备注");
		remarkField.setLength(60000);
		remarkField.setRequired(false);
		remarkField.setHidden(true);

		contractCodeField = new DataSourceTextField("contractCode", "主订单编号");
		contractCodeField.setLength(64);
		contractCodeField.setRequired(false);
		contractCodeField.setHidden(false);

		signingMoneySumField = new DataSourceFloatField("signingMoneySum", "签约总金额");
		signingMoneySumField.setLength(16);
		signingMoneySumField.setDecimalPad(2);
		signingMoneySumField.setFormat("##,###,###,###,##0.00");
		signingMoneySumField.setRequired(false);
		signingMoneySumField.setHidden(false);

		contractNameField = new DataSourceTextField("contractName", "主订单名称");
		contractNameField.setLength(512);
		contractNameField.setRequired(false);
		contractNameField.setHidden(false);

		customerNameField = new DataSourceTextField("customerName", "客户名称");
		customerNameField.setLength(512);
		customerNameField.setRequired(false);
		customerNameField.setHidden(false);

		happenDateField = new DataSourceDateTimeField("happenDate", "回款日期");
		happenDateField.setRequired(false);
		happenDateField.setHidden(false);

		otherNameField = new DataSourceTextField("otherName", "对方名称(付款方)");
		otherNameField.setLength(128);
		otherNameField.setRequired(false);
		otherNameField.setHidden(false);

		borrowMoneyField = new DataSourceFloatField("borrowMoney", "本次回款");
		borrowMoneyField.setLength(16);
		borrowMoneyField.setDecimalPad(2);
		borrowMoneyField.setFormat("##,###,###,###,##0.00");
		borrowMoneyField.setRequired(false);
		borrowMoneyField.setHidden(false);

		allBorrowMoneyField = new DataSourceFloatField("allBorrowMoney", "累计回款");
		allBorrowMoneyField.setLength(18);
		allBorrowMoneyField.setDecimalPad(2);
		allBorrowMoneyField.setFormat("#,###,###,###,###,##0.00");
		allBorrowMoneyField.setRequired(true);
		allBorrowMoneyField.setHidden(false);

		setFields(processInstanceIdField, processTypeField, businessIdField, businessNameField, processIdField,
				processInstanceActivityIdField, processStatusField, departmentIdField, employeeIdField, codeField, 
				companyIdField, titleField, contractChangeAmountField, mainProfessionalField, remarkField, contractCodeField, 
				 contractNameField, customerNameField,  otherNameField, signingMoneySumField, borrowMoneyField, 
				allBorrowMoneyField, happenDateField, createTimeField, completeTimeField);
	}

}
