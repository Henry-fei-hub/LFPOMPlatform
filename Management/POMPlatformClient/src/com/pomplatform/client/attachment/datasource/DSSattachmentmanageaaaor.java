package com.pomplatform.client.attachment.datasource;

import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.smartgwt.client.data.fields.DataSourceBooleanField;
import com.smartgwt.client.data.fields.DataSourceDateField;
import com.smartgwt.client.data.fields.DataSourceDateTimeField;
import com.smartgwt.client.data.fields.DataSourceFloatField;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceLinkField;
import com.smartgwt.client.data.fields.DataSourceTextField;

public class DSSattachmentmanageaaaor extends DBDataSource {

	public static DSSattachmentmanageaaaor instance = null;

	public static DSSattachmentmanageaaaor getInstance() {
		if (instance == null) {
			instance = new DSSattachmentmanageaaaor("DSSattachmentmanageaaaor");
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
	private final DataSourceIntegerField projectManageIdField;
	private final DataSourceIntegerField departmentIdField;
	private final DataSourceIntegerField superProjectManageIdField;

	public DSSattachmentmanageaaaor(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("Sattachmentmanageaaaor");

		attachmentManageIdField = new DataSourceIntegerField("attachmentManageId", "主键编码");
		attachmentManageIdField.setLength(11);
		attachmentManageIdField.setRequired(true);
		attachmentManageIdField.setHidden(true);

		contractIdField = new DataSourceIntegerField("contractId", "合同编码");
		contractIdField.setLength(11);
		contractIdField.setRequired(false);
		contractIdField.setHidden(true);

		attachmentCodeField = new DataSourceTextField("attachmentCode", "编号");
		attachmentCodeField.setLength(64);
		attachmentCodeField.setRequired(false);
		attachmentCodeField.setHidden(false);

		attachmentNameField = new DataSourceTextField("attachmentName", "附件名称");
		attachmentNameField.setLength(128);
		attachmentNameField.setRequired(false);
		attachmentNameField.setHidden(false);

		attachmentAddressField = new DataSourceLinkField("attachmentAddress", "附件路径");
		attachmentAddressField.setLength(128);
		attachmentAddressField.setRequired(false);
		attachmentAddressField.setHidden(false);

		perfessionRemarkField = new DataSourceTextField("perfessionRemark", "专业备注");
		perfessionRemarkField.setLength(128);
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

		serialNumberField = new DataSourceIntegerField("serialNumber", "序列号");
		serialNumberField.setLength(11);
		serialNumberField.setRequired(false);
		serialNumberField.setHidden(false);

		recordDateField = new DataSourceDateField("recordDate", "记录日期");
		recordDateField.setRequired(false);
		recordDateField.setHidden(false);

		operateEmployeeIdField = new DataSourceIntegerField("operateEmployeeId", "操作人");
		operateEmployeeIdField.setLength(11);
		operateEmployeeIdField.setRequired(false);
		operateEmployeeIdField.setHidden(true);
		operateEmployeeIdField.setValueMap(KeyValueManager.getValueMap("employees"));

		operateTimeField = new DataSourceDateTimeField("operateTime", "操作时间");
		operateTimeField.setRequired(false);
		operateTimeField.setHidden(true);

		remarkField = new DataSourceTextField("remark", "备注");
		remarkField.setLength(1024);
		remarkField.setRequired(false);
		remarkField.setHidden(false);

		projectManageIdField = new DataSourceIntegerField("projectManageId", "项目负责人");
		projectManageIdField.setLength(11);
		projectManageIdField.setValueMap(KeyValueManager.getValueMap("employees"));
		projectManageIdField.setRequired(false);
		projectManageIdField.setHidden(false);

		departmentIdField = new DataSourceIntegerField("departmentId", "部门");
		departmentIdField.setLength(11);
		departmentIdField.setValueMap(KeyValueManager.getValueMap("departments"));
		departmentIdField.setRequired(false);
		departmentIdField.setHidden(false);

		superProjectManageIdField = new DataSourceIntegerField("superProjectManageId", "大项目负责人");
		superProjectManageIdField.setLength(11);
		superProjectManageIdField.setValueMap(KeyValueManager.getValueMap("employees"));
		superProjectManageIdField.setRequired(false);
		superProjectManageIdField.setHidden(false);

		setFields(attachmentManageIdField, contractIdField, attachmentCodeField, attachmentNameField,
				attachmentAddressField, perfessionRemarkField, amountField, returnAmountField, paymentSureField,
				paymentGradeDescriptionField, serialNumberField, recordDateField, projectManageIdField,
				departmentIdField, superProjectManageIdField, operateEmployeeIdField, operateTimeField, remarkField);
	}

}
