package com.pomplatform.client.scapitaldistributionor.datasource;

import com.delicacy.client.data.DBDataSource;
import com.smartgwt.client.data.fields.DataSourceDateTimeField;
import com.smartgwt.client.data.fields.DataSourceFloatField;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;

public class DSCapitalDistributionsAttentionOfWorkflowPanel extends DBDataSource {

	public static DSCapitalDistributionsAttentionOfWorkflowPanel instance = null;

	public static DSCapitalDistributionsAttentionOfWorkflowPanel getInstance() {
		if (instance == null) {
			instance = new DSCapitalDistributionsAttentionOfWorkflowPanel(
					"DSCapitalDistributionsAttentionOfWorkflowPanel");
		}
		return instance;
	}

	private final DataSourceIntegerField systemProcessAttentionIdField;
	private final DataSourceIntegerField businessIdField;
	private final DataSourceTextField businessNameField;
	private final DataSourceIntegerField processActivityIdField;
	private final DataSourceIntegerField processIdField;
	private final DataSourceIntegerField processInstanceIdField;
	private final DataSourceTextField backViewNameField;
	private final DataSourceIntegerField instanceActivityIdField;
	private final DataSourceDateTimeField instanceActivityCreateTimeField;
	private final DataSourceDateTimeField instanceActivityStartTimeField;
	private final DataSourceIntegerField statusField;
	private final DataSourceIntegerField processTypeField;
	private final DataSourceDateTimeField operateTimeField;
	private final DataSourceTextField processCommentField;
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

	public DSCapitalDistributionsAttentionOfWorkflowPanel(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("CapitalDistributionsAttentionOfWorkflowPanel");

		systemProcessAttentionIdField = new DataSourceIntegerField("systemProcessAttentionId", "主键编码");
		systemProcessAttentionIdField.setLength(11);
		systemProcessAttentionIdField.setPrimaryKey(true);
		systemProcessAttentionIdField.setRequired(true);
		systemProcessAttentionIdField.setHidden(true);

		businessIdField = new DataSourceIntegerField("businessId", "业务编码");
		businessIdField.setLength(11);
		businessIdField.setRequired(false);
		businessIdField.setHidden(true);

		businessNameField = new DataSourceTextField("businessName", "业务名称");
		businessNameField.setLength(256);
		businessNameField.setRequired(false);
		businessNameField.setHidden(true);

		processActivityIdField = new DataSourceIntegerField("processActivityId", "活动编码");
		processActivityIdField.setLength(11);
		processActivityIdField.setRequired(false);
		processActivityIdField.setHidden(true);

		processIdField = new DataSourceIntegerField("processId", "流程编码");
		processIdField.setLength(11);
		processIdField.setRequired(false);
		processIdField.setHidden(true);

		processInstanceIdField = new DataSourceIntegerField("processInstanceId", "流程实列编码");
		processInstanceIdField.setLength(11);
		processInstanceIdField.setRequired(false);
		processInstanceIdField.setHidden(true);

		backViewNameField = new DataSourceTextField("backViewName", "返回数据集");
		backViewNameField.setLength(64);
		backViewNameField.setRequired(false);
		backViewNameField.setHidden(true);

		instanceActivityIdField = new DataSourceIntegerField("instanceActivityId", "流程实例节点编码");
		instanceActivityIdField.setLength(11);
		instanceActivityIdField.setRequired(false);
		instanceActivityIdField.setHidden(true);

		instanceActivityCreateTimeField = new DataSourceDateTimeField("instanceActivityCreateTime", "流程实例节点创建时间");
		instanceActivityCreateTimeField.setRequired(false);
		instanceActivityCreateTimeField.setHidden(true);

		instanceActivityStartTimeField = new DataSourceDateTimeField("instanceActivityStartTime", "流程实例节点开始处于活动时间");
		instanceActivityStartTimeField.setRequired(false);
		instanceActivityStartTimeField.setHidden(true);

		statusField = new DataSourceIntegerField("status", "状态");
		statusField.setLength(11);
		statusField.setRequired(false);
		statusField.setHidden(true);

		processTypeField = new DataSourceIntegerField("processType", "流程类型");
		processTypeField.setLength(11);
		processTypeField.setRequired(false);
		processTypeField.setHidden(true);

		operateTimeField = new DataSourceDateTimeField("operateTime", "操作时间");
		operateTimeField.setRequired(false);
		operateTimeField.setHidden(false);

		processCommentField = new DataSourceTextField("processComment", "提交意见");
		processCommentField.setLength(512);
		processCommentField.setRequired(false);
		processCommentField.setHidden(false);

		departmentIdField = new DataSourceIntegerField("departmentId", "报销部门");
		departmentIdField.setLength(11);
		departmentIdField.setRequired(false);
		departmentIdField.setHidden(true);

		employeeIdField = new DataSourceIntegerField("employeeId", "处理人");
		employeeIdField.setLength(11);
		employeeIdField.setRequired(false);
		employeeIdField.setHidden(true);

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

		remarkField = new DataSourceTextField("remark", "备注");
		remarkField.setLength(60000);
		remarkField.setRequired(false);
		remarkField.setHidden(false);

		contractCodeField = new DataSourceTextField("contractCode", "合同编号");
		contractCodeField.setLength(64);
		contractCodeField.setRequired(false);
		contractCodeField.setHidden(false);

		signingMoneySumField = new DataSourceFloatField("signingMoneySum", "签约总金额");
		signingMoneySumField.setLength(16);
		signingMoneySumField.setDecimalPad(2);
		signingMoneySumField.setFormat("##,###,###,###,##0.00");
		signingMoneySumField.setRequired(false);
		signingMoneySumField.setHidden(false);

		contractNameField = new DataSourceTextField("contractName", "合同名称");
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

		borrowMoneyField = new DataSourceFloatField("borrowMoney", "本次回款金额");
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

		setFields(systemProcessAttentionIdField, businessIdField, businessNameField, processActivityIdField,
				processIdField, processInstanceIdField, backViewNameField, instanceActivityIdField,
				instanceActivityCreateTimeField, instanceActivityStartTimeField, statusField, processTypeField,
				operateTimeField, processCommentField, departmentIdField, employeeIdField, codeField, companyIdField,
				titleField, contractChangeAmountField, mainProfessionalField, remarkField, contractCodeField,
				contractNameField, customerNameField, happenDateField, otherNameField, signingMoneySumField,
				borrowMoneyField, allBorrowMoneyField);
	}

}
