package com.pomplatform.client.attachmentmanagemeeting.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.smartgwt.client.types.TextMatchStyle;
import com.smartgwt.client.widgets.form.fields.ComboBoxItem;
import com.delicacy.client.data.KeyValueManager;

import java.util.LinkedHashMap;
import java.util.Map;

import com.delicacy.client.data.DBDataSource;

public class DSAttachmentManageMeetingTor extends DBDataSource
{


	public static DSAttachmentManageMeetingTor instance = null;

	public static DSAttachmentManageMeetingTor getInstance() {
		if(instance == null) {
			instance = new DSAttachmentManageMeetingTor("DSAttachmentManageMeetingTor");
		}
		return instance;
	}

	private final DataSourceIntegerField attachmentManageMeetingIdField;
	private final DataSourceIntegerField contractIdField;
	private final DataSourceDateField expectReturnDateField;
	private final DataSourceFloatField needReturnAmountField;
	private final DataSourceTextField remarkField;
	private final DataSourceDateField publishDateField;
	private final DataSourceDateField submitDateField;
	private final DataSourceDateField endDateField;
	private final DataSourceIntegerField mettingStatusField;
	private final DataSourceIntegerField operatorStatusField;
	private final DataSourceIntegerField yearField;
	private final DataSourceIntegerField workNumField;
	private final DataSourceIntegerField operatorField;
	private final DataSourceDateTimeField createTimeField;
	private final DataSourceIntegerField attachmentManageIdField;
	private final DataSourceIntegerField projectManageIdField;
	private final DataSourceTextField contractNameField;
	private final DataSourceTextField contractCodeField;
	private final DataSourceTextField attachmentCodeField;
	private final DataSourceTextField attachmentNameField;
	private final DataSourceTextField attachmentAddressField;
	private final DataSourceTextField perfessionRemarkField;
	private final DataSourceFloatField amountField;
	private final DataSourceFloatField returnAmountField;
	private final DataSourceBooleanField paymentSureField;
	private final DataSourceTextField paymentGradeDescriptionField;
	private final DataSourceIntegerField serialNumberField;
	private final DataSourceDateField recordDateField;
	private final DataSourceIntegerField operateEmployeeIdField;
	private final DataSourceDateTimeField operateTimeField;
	private final DataSourceIntegerField deleteFlagField;
	private final DataSourceIntegerField departmentIdField;
	private final DataSourceIntegerField superProjectManageIdField;
	private final DataSourceIntegerField personnelBusinessIdField;
	private final DataSourceBooleanField haveVoucherField;
	private final DataSourceTextField employeeNameStrField;
	private final DataSourceFloatField invoiceAmountField;
	public DSAttachmentManageMeetingTor(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("AttachmentManageMeetingTor");


		attachmentManageMeetingIdField = new DataSourceIntegerField("attachmentManageMeetingId", "attachment_manage_meeting_id");
		attachmentManageMeetingIdField.setLength(11);
		attachmentManageMeetingIdField.setPrimaryKey(true);
		attachmentManageMeetingIdField.setRequired(true);
		attachmentManageMeetingIdField.setHidden(true);


		contractCodeField = new DataSourceTextField("contractCode", "合同编号");
		contractCodeField.setLength(64);
		contractCodeField.setRequired(false);
		contractCodeField.setHidden(true);


		contractNameField = new DataSourceTextField("contractName", "合同名称");
		contractNameField.setLength(512);
		contractNameField.setRequired(false);
		contractNameField.setHidden(true);


		amountField = new DataSourceFloatField("amount", "金额");
		amountField.setLength(18);
		amountField.setDecimalPad(2);
		amountField.setFormat("#,###,###,###,###,##0.00");
		amountField.setRequired(false);
		amountField.setHidden(false);
		
		invoiceAmountField = new DataSourceFloatField("invoiceAmount", "绑定发票金额");
		invoiceAmountField.setLength(18);
		invoiceAmountField.setDecimalPad(2);
		invoiceAmountField.setFormat("#,###,###,###,###,##0.00");
		invoiceAmountField.setRequired(false);
		invoiceAmountField.setHidden(false);

		returnAmountField = new DataSourceFloatField("returnAmount", "回款金额");
		returnAmountField.setLength(18);
		returnAmountField.setDecimalPad(2);
		returnAmountField.setFormat("#,###,###,###,###,##0.00");
		returnAmountField.setRequired(false);
		returnAmountField.setHidden(false);
		
		
		contractIdField = new DataSourceIntegerField("contractId", "合同编码");
		contractIdField.setLength(11);
		contractIdField.setRequired(false);
		contractIdField.setHidden(true);


		projectManageIdField = new DataSourceIntegerField("projectManageId", "项目负责人");
		projectManageIdField.setLength(11);
		projectManageIdField.setRequired(false);
		projectManageIdField.setHidden(false);
		ComboBoxItem employeeIdItem = new ComboBoxItem("projectManageId");
		employeeIdItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		employeeIdItem.setChangeOnKeypress(false);
		projectManageIdField.setEditorProperties(employeeIdItem);
		projectManageIdField.setValueMap(KeyValueManager.getValueMap("employees"));
		


		expectReturnDateField = new DataSourceDateField("expectReturnDate", "预期回款时间");
		expectReturnDateField.setRequired(false);
		expectReturnDateField.setHidden(false);


		needReturnAmountField = new DataSourceFloatField("needReturnAmount", "预期回款金额");//需回款金额（金额-回款金额）
		needReturnAmountField.setLength(18);
		needReturnAmountField.setDecimalPad(2);
		needReturnAmountField.setFormat("#,###,###,###,###,##0.00");
		needReturnAmountField.setRequired(false);
		needReturnAmountField.setHidden(false);


		remarkField = new DataSourceTextField("remark", "备注");
		remarkField.setLength(1024);
		remarkField.setRequired(false);
		remarkField.setHidden(false);


		publishDateField = new DataSourceDateField("publishDate", "发布日期");
		publishDateField.setRequired(false);
		publishDateField.setHidden(true);


		submitDateField = new DataSourceDateField("submitDate", "本次提交日期");
		submitDateField.setRequired(false);
		submitDateField.setHidden(true);


		endDateField = new DataSourceDateField("endDate", "定稿日期");
		endDateField.setRequired(false);
		endDateField.setHidden(true);


		mettingStatusField = new DataSourceIntegerField("mettingStatus", "确认函状态");//1新建 2发布 3定稿
		mettingStatusField.setLength(11);
		mettingStatusField.setRequired(false);
		mettingStatusField.setHidden(true);
		mettingStatusField.setValueMap(KeyValueManager.getValueMap("system_dictionary_141"));


		operatorStatusField = new DataSourceIntegerField("operatorStatus", "操作状态");//1 待提交 2已提交  3未答复
		operatorStatusField.setLength(11);
		operatorStatusField.setRequired(false);
		operatorStatusField.setHidden(true);
//		Map<Integer, String> operatorStatusMap= new LinkedHashMap<Integer, String>();
//		operatorStatusMap.put(1, "待提交");
//		operatorStatusMap.put(2, "已提交");
//		operatorStatusMap.put(3, "未答复");
//		operatorStatusField.setValueMap(operatorStatusMap);
		operatorStatusField.setValueMap(KeyValueManager.getValueMap("system_dictionary_142"));

		yearField = new DataSourceIntegerField("year", "年份");
		yearField.setLength(11);
		yearField.setRequired(false);
		yearField.setHidden(true);


		workNumField = new DataSourceIntegerField("workNum", "第几周");
		workNumField.setLength(11);
		workNumField.setRequired(false);
		workNumField.setHidden(true);


		operatorField = new DataSourceIntegerField("operator", "操作人");
		operatorField.setLength(11);
		operatorField.setRequired(false);
		operatorField.setHidden(true);


		createTimeField = new DataSourceDateTimeField("createTime", "创建时间");
		createTimeField.setRequired(false);
		createTimeField.setHidden(true);


		attachmentManageIdField = new DataSourceIntegerField("attachmentManageId", "确认函主键");
		attachmentManageIdField.setLength(11);
		attachmentManageIdField.setRequired(false);
		attachmentManageIdField.setHidden(true);


		attachmentCodeField = new DataSourceTextField("attachmentCode", "编号");
		attachmentCodeField.setLength(64);
		attachmentCodeField.setRequired(false);
		attachmentCodeField.setHidden(true);


		attachmentNameField = new DataSourceTextField("attachmentName", "附件名称");
		attachmentNameField.setLength(128);
		attachmentNameField.setRequired(false);
		attachmentNameField.setHidden(true);


		attachmentAddressField = new DataSourceTextField("attachmentAddress", "附件路径");
		attachmentAddressField.setLength(128);
		attachmentAddressField.setRequired(false);
		attachmentAddressField.setHidden(true);


		perfessionRemarkField = new DataSourceTextField("perfessionRemark", "专业备注");
		perfessionRemarkField.setLength(1024);
		perfessionRemarkField.setRequired(false);
		perfessionRemarkField.setHidden(true);


		paymentSureField = new DataSourceBooleanField("paymentSure", "收款确认");
		paymentSureField.setRequired(false);
		paymentSureField.setHidden(true);


		paymentGradeDescriptionField = new DataSourceTextField("paymentGradeDescription", "收款阶段描述");
		paymentGradeDescriptionField.setLength(512);
		paymentGradeDescriptionField.setRequired(false);
		paymentGradeDescriptionField.setHidden(true);


		serialNumberField = new DataSourceIntegerField("serialNumber", "序列号(生成编号的序号)");
		serialNumberField.setLength(11);
		serialNumberField.setRequired(false);
		serialNumberField.setHidden(true);


		recordDateField = new DataSourceDateField("recordDate", "记录日期");
		recordDateField.setRequired(false);
		recordDateField.setHidden(true);


		operateEmployeeIdField = new DataSourceIntegerField("operateEmployeeId", "操作人");
		operateEmployeeIdField.setLength(11);
		operateEmployeeIdField.setRequired(false);
		operateEmployeeIdField.setHidden(true);


		operateTimeField = new DataSourceDateTimeField("operateTime", "操作时间");
		operateTimeField.setRequired(false);
		operateTimeField.setHidden(true);


		deleteFlagField = new DataSourceIntegerField("deleteFlag", "0/1 是/否删除");
		deleteFlagField.setLength(11);
		deleteFlagField.setRequired(false);
		deleteFlagField.setHidden(true);


		departmentIdField = new DataSourceIntegerField("departmentId", "部门");
		departmentIdField.setLength(11);
		departmentIdField.setRequired(false);
		departmentIdField.setHidden(true);


		superProjectManageIdField = new DataSourceIntegerField("superProjectManageId", "大项目负责人");
		superProjectManageIdField.setLength(11);
		superProjectManageIdField.setRequired(false);
		superProjectManageIdField.setHidden(true);


		personnelBusinessIdField = new DataSourceIntegerField("personnelBusinessId", "流程主表编码");
		personnelBusinessIdField.setLength(11);
		personnelBusinessIdField.setRequired(false);
		personnelBusinessIdField.setHidden(true);


		haveVoucherField = new DataSourceBooleanField("haveVoucher", "是否有凭证");
		haveVoucherField.setRequired(false);
		haveVoucherField.setHidden(true);


		employeeNameStrField = new DataSourceTextField("employeeNameStr", "employeeNameStr");
		employeeNameStrField.setLength(-1);
		employeeNameStrField.setRequired(true);
		employeeNameStrField.setHidden(true);


		setFields(attachmentManageMeetingIdField, contractCodeField, contractNameField, amountField, invoiceAmountField, returnAmountField, projectManageIdField, contractIdField, expectReturnDateField, needReturnAmountField, remarkField, publishDateField, submitDateField, endDateField, mettingStatusField, operatorStatusField, yearField, workNumField, operatorField, createTimeField, attachmentManageIdField, attachmentCodeField, attachmentNameField, attachmentAddressField, perfessionRemarkField, paymentSureField, paymentGradeDescriptionField, serialNumberField, recordDateField, operateEmployeeIdField, operateTimeField, deleteFlagField, departmentIdField, superProjectManageIdField, personnelBusinessIdField, haveVoucherField, employeeNameStrField);
	}


}

