package com.pomplatform.client.memployeeaaccadpppccor.datasource;

import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.smartgwt.client.data.fields.DataSourceBooleanField;
import com.smartgwt.client.data.fields.DataSourceDateField;
import com.smartgwt.client.data.fields.DataSourceDateTimeField;
import com.smartgwt.client.data.fields.DataSourceFloatField;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceLinkField;
import com.smartgwt.client.data.fields.DataSourceTextField;

public class DSMemployeeaaccadpppccor extends DBDataSource {

	public static DSMemployeeaaccadpppccor instance = null;

	public static DSMemployeeaaccadpppccor getInstance() {
		if (instance == null) {
			instance = new DSMemployeeaaccadpppccor("DSMemployeeaaccadpppccor");
		}
		return instance;
	}

	private final DataSourceIntegerField attachmentManageIdField;
	private final DataSourceIntegerField contractIdField;
	private final DataSourceTextField attachmentCodeField;
	private final DataSourceTextField attachmentNameField;
	private final DataSourceLinkField attachmentAddressField;
	private final DataSourceTextField perfessionRemarkField;
	private final DataSourceFloatField amountField;
	private final DataSourceFloatField returnAmountField;
	private final DataSourceBooleanField paymentSureField;
	private final DataSourceTextField paymentGradeDescriptionField;
	private final DataSourceIntegerField serialNumberField;
	private final DataSourceDateField recordDateField;
	private final DataSourceIntegerField operateEmployeeIdField;
	private final DataSourceDateTimeField operateTimeField;
	private final DataSourceTextField remarkField;
	private final DataSourceIntegerField deleteFlagField;
	private final DataSourceIntegerField projectManageIdField;
	private final DataSourceIntegerField departmentIdField;
	private final DataSourceIntegerField superProjectManageIdField;
	private final DataSourceIntegerField personnelBusinessIdField;
	private final DataSourceBooleanField haveVoucherField;
	private final DataSourceTextField contractNameField;
	private final DataSourceTextField contractCodeField;
	private final DataSourceTextField employeeNameStrField;
	private final DataSourceTextField financeRemarkField;
	private final DataSourceBooleanField canReceivedPaymentField;
	private final DataSourceFloatField residualReceiptsField;

	public DSMemployeeaaccadpppccor(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("Memployeeaaccadpppccor");

		attachmentManageIdField = new DataSourceIntegerField("attachmentManageId", "确认函主键");
		attachmentManageIdField.setLength(11);
		attachmentManageIdField.setRequired(false);
		attachmentManageIdField.setHidden(true);

		contractIdField = new DataSourceIntegerField("contractId", "合同编码");
		contractIdField.setLength(11);
		contractIdField.setRequired(false);
		contractIdField.setHidden(false);
//		contractIdField.setValueMap(KeyValueManager.getValueMap("contracts"));
		KeyValueManager.loadValueMap("contracts",contractIdField);

		attachmentCodeField = new DataSourceTextField("attachmentCode", "编号");
		attachmentCodeField.setLength(64);
		attachmentCodeField.setRequired(false);
		attachmentCodeField.setHidden(false);

		attachmentNameField = new DataSourceTextField("attachmentName", "确认函名称");
		attachmentNameField.setLength(128);
		attachmentNameField.setRequired(false);
		attachmentNameField.setHidden(false);

		attachmentAddressField = new DataSourceLinkField("attachmentAddress", "确认函路径");
		attachmentAddressField.setLength(128);
		attachmentAddressField.setRequired(false);
		attachmentAddressField.setHidden(false);

		perfessionRemarkField = new DataSourceTextField("perfessionRemark", "专业备注");
		perfessionRemarkField.setLength(1024);
		perfessionRemarkField.setRequired(false);
		perfessionRemarkField.setHidden(false);

		amountField = new DataSourceFloatField("amount", "金额");
		amountField.setLength(18);
		amountField.setDecimalPad(2);
		amountField.setFormat("#,###,###,###,###,##0.00");
		amountField.setRequired(false);
		amountField.setHidden(false);

		returnAmountField = new DataSourceFloatField("returnAmount", "回款金额");
		returnAmountField.setLength(18);
		returnAmountField.setDecimalPad(2);
		returnAmountField.setFormat("#,###,###,###,###,##0.00");
		returnAmountField.setRequired(false);
		returnAmountField.setHidden(false);

		paymentSureField = new DataSourceBooleanField("paymentSure", "收款确认");
		paymentSureField.setRequired(false);
		paymentSureField.setHidden(false);

		paymentGradeDescriptionField = new DataSourceTextField("paymentGradeDescription", "收款阶段描述");
		paymentGradeDescriptionField.setLength(512);
		paymentGradeDescriptionField.setRequired(false);
		paymentGradeDescriptionField.setHidden(false);

		serialNumberField = new DataSourceIntegerField("serialNumber", "序列号(生成编号的序号)");
		serialNumberField.setLength(11);
		serialNumberField.setRequired(false);
		serialNumberField.setHidden(false);

		recordDateField = new DataSourceDateField("recordDate", "记录日期");
		recordDateField.setRequired(false);
		recordDateField.setHidden(false);

		operateEmployeeIdField = new DataSourceIntegerField("operateEmployeeId", "操作人");
		operateEmployeeIdField.setLength(11);
		operateEmployeeIdField.setRequired(false);
		operateEmployeeIdField.setHidden(false);

		operateTimeField = new DataSourceDateTimeField("operateTime", "操作时间");
		operateTimeField.setRequired(false);
		operateTimeField.setHidden(false);

		remarkField = new DataSourceTextField("remark", "备注");
		remarkField.setLength(1024);
		remarkField.setRequired(false);
		remarkField.setHidden(false);

		deleteFlagField = new DataSourceIntegerField("deleteFlag", "0/1 是/否删除");
		deleteFlagField.setLength(11);
		deleteFlagField.setRequired(false);
		deleteFlagField.setHidden(true);

		projectManageIdField = new DataSourceIntegerField("projectManageId", "项目负责人");
		projectManageIdField.setLength(11);
		projectManageIdField.setRequired(false);
		projectManageIdField.setHidden(true);
		projectManageIdField.setValueMap(KeyValueManager.getValueMap("employees"));

		departmentIdField = new DataSourceIntegerField("departmentId", "部门");
		departmentIdField.setLength(11);
		departmentIdField.setRequired(false);
		departmentIdField.setHidden(true);
		departmentIdField.setValueMap(KeyValueManager.getValueMap("departments"));

		superProjectManageIdField = new DataSourceIntegerField("superProjectManageId", "大项目负责人");
		superProjectManageIdField.setLength(11);
		superProjectManageIdField.setRequired(false);
		superProjectManageIdField.setHidden(true);
		superProjectManageIdField.setValueMap(KeyValueManager.getValueMap("employees"));

		personnelBusinessIdField = new DataSourceIntegerField("personnelBusinessId", "流程主表编码");
		personnelBusinessIdField.setLength(11);
		personnelBusinessIdField.setRequired(false);
		personnelBusinessIdField.setHidden(true);

		haveVoucherField = new DataSourceBooleanField("haveVoucher", "是否有凭证");
		haveVoucherField.setRequired(false);
		haveVoucherField.setHidden(true);

		contractNameField = new DataSourceTextField("contractName", "合同名称");
		contractNameField.setLength(512);
		contractNameField.setRequired(false);
		contractNameField.setHidden(true);

		contractCodeField = new DataSourceTextField("contractCode", "合同编号");
		contractCodeField.setLength(64);
		contractCodeField.setRequired(false);
		contractCodeField.setHidden(true);

		employeeNameStrField = new DataSourceTextField("employeeNameStr", "负责总监");
		employeeNameStrField.setLength(-1);
		employeeNameStrField.setRequired(true);
		employeeNameStrField.setHidden(true);

		financeRemarkField = new DataSourceTextField("financeRemark", "会议备注");
		financeRemarkField.setLength(1024);
		financeRemarkField.setRequired(false);
		financeRemarkField.setHidden(true);

		canReceivedPaymentField = new DataSourceBooleanField("canReceivedPayment", "本月能否收款");
		canReceivedPaymentField.setRequired(false);
		canReceivedPaymentField.setHidden(true);
		
		
		residualReceiptsField = new DataSourceFloatField("residualReceipts", "本月回款金额(预测)");
		residualReceiptsField.setLength(18);
		residualReceiptsField.setDecimalPad(2);
		residualReceiptsField.setFormat("#,###,###,###,###,##0.00");
		residualReceiptsField.setRequired(false);
		residualReceiptsField.setHidden(false);

		setFields(attachmentManageIdField, contractIdField, attachmentCodeField, attachmentNameField,
				attachmentAddressField, perfessionRemarkField, amountField, returnAmountField, financeRemarkField,
				canReceivedPaymentField, paymentSureField, residualReceiptsField, paymentGradeDescriptionField, serialNumberField,
				recordDateField, operateEmployeeIdField, operateTimeField, remarkField, deleteFlagField,
				projectManageIdField, departmentIdField, superProjectManageIdField, personnelBusinessIdField,
				haveVoucherField, contractNameField, contractCodeField, employeeNameStrField);
	}

}
