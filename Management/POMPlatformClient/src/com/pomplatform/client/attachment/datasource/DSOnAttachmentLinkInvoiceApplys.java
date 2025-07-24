package com.pomplatform.client.attachment.datasource;

import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;

public class DSOnAttachmentLinkInvoiceApplys extends DBDataSource
{


	public static DSOnAttachmentLinkInvoiceApplys instance = null;

	public static DSOnAttachmentLinkInvoiceApplys getInstance() {
		if(instance == null) {
			instance = new DSOnAttachmentLinkInvoiceApplys("DSOnAttachmentLinkInvoiceApplys");
		}
		return instance;
	}

	private final DataSourceIntegerField invoiceApplyIdField;
	private final DataSourceIntegerField applicantIdField;
	private final DataSourceIntegerField invoiceTypeField;
	private final DataSourceTextField companyNameField;
	private final DataSourceTextField dutyParagraphField;
	private final DataSourceTextField customerNameField;
	private final DataSourceTextField customerPhoneField;
	private final DataSourceTextField applyRemarkField;
	private final DataSourceTextField operatorRemarkField;
	private final DataSourceIntegerField flagTypeField;
	private final DataSourceIntegerField bindAmountField;
	private final DataSourceIntegerField deleteFlagField;
	private final DataSourceTextField registeredAddressField;
	private final DataSourceTextField bankNameField;
	private final DataSourceTextField bankAccountField;
	private final DataSourceTextField landlineField;

	public DSOnAttachmentLinkInvoiceApplys(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("OnAttachmentLinkInvoiceApplys");


		invoiceApplyIdField = new DataSourceIntegerField("invoiceApplyId", "发票联系人编码");
		invoiceApplyIdField.setLength(11);
		invoiceApplyIdField.setRequired(false);
		invoiceApplyIdField.setHidden(true);


		applicantIdField = new DataSourceIntegerField("applicantId", "申请人");
		applicantIdField.setLength(11);
		applicantIdField.setRequired(false);
		applicantIdField.setHidden(false);
		applicantIdField.setValueMap(KeyValueManager.getValueMap("employees"));

		invoiceTypeField = new DataSourceIntegerField("invoiceType", "开票类型");
		invoiceTypeField.setLength(11);
		invoiceTypeField.setRequired(false);
		invoiceTypeField.setHidden(false);
		invoiceTypeField.setValueMap(KeyValueManager.getValueMap("system_dictionary_52"));

		companyNameField = new DataSourceTextField("companyName", "单位名称");
		companyNameField.setLength(255);
		companyNameField.setRequired(false);
		companyNameField.setHidden(false);

		dutyParagraphField = new DataSourceTextField("dutyParagraph", "税号");
		dutyParagraphField.setLength(255);
		dutyParagraphField.setRequired(false);
		dutyParagraphField.setHidden(false);


		customerNameField = new DataSourceTextField("customerName", "邮寄人名称");
		customerNameField.setLength(512);
		customerNameField.setRequired(false);
		customerNameField.setHidden(false);


		customerPhoneField = new DataSourceTextField("customerPhone", "邮寄人电话");
		customerPhoneField.setLength(255);
		customerPhoneField.setRequired(false);
		customerPhoneField.setHidden(false);


		applyRemarkField = new DataSourceTextField("applyRemark", "邮寄人地址");
		applyRemarkField.setLength(255);
		applyRemarkField.setRequired(false);
		applyRemarkField.setHidden(false);


		operatorRemarkField = new DataSourceTextField("operatorRemark", "操作备注");
		operatorRemarkField.setLength(255);
		operatorRemarkField.setRequired(false);
		operatorRemarkField.setHidden(false);


		flagTypeField = new DataSourceIntegerField("flagType", "绑定状态");
		flagTypeField.setLength(11);
		flagTypeField.setRequired(true);
		flagTypeField.setHidden(false);

		java.util.Map<String,String> flagTypeValues = new java.util.HashMap<String,String>();
		flagTypeValues.put("1", "未绑定");
		flagTypeValues.put("2", "已绑定");
		flagTypeField.setValueMap(flagTypeValues);
		
		bindAmountField = new DataSourceIntegerField("bindAmount", "绑定确认函");
		bindAmountField.setLength(11);
		bindAmountField.setRequired(true);
		bindAmountField.setHidden(false);
		
		deleteFlagField = new DataSourceIntegerField("deleteFlag", "删除状态");
		deleteFlagField.setLength(11);
		deleteFlagField.setRequired(true);
		deleteFlagField.setHidden(false);
		
		java.util.Map<String,String> deleteFlagValues = new java.util.HashMap<String,String>();
		deleteFlagValues.put("0", "未删除");
		deleteFlagValues.put("1", "已删除");
		deleteFlagField.setValueMap(deleteFlagValues);
		
		registeredAddressField = new DataSourceTextField("registeredAddress", "注册地址");
		registeredAddressField.setLength(255);
		registeredAddressField.setRequired(false);
		registeredAddressField.setHidden(false);
		
		bankNameField = new DataSourceTextField("bankName", "银行名称");
		bankNameField.setLength(255);
		bankNameField.setRequired(false);
		bankNameField.setHidden(false);
		
		bankAccountField = new DataSourceTextField("bankAccount", "银行账号");
		bankAccountField.setLength(255);
		bankAccountField.setRequired(false);
		bankAccountField.setHidden(false);
		
		landlineField = new DataSourceTextField("landline", "固定电话");
		landlineField.setLength(255);
		landlineField.setRequired(false);
		landlineField.setHidden(false);

		setFields(invoiceApplyIdField, applicantIdField, invoiceTypeField, companyNameField, dutyParagraphField, customerNameField, customerPhoneField, registeredAddressField, bankNameField, bankAccountField, applyRemarkField, operatorRemarkField, flagTypeField, bindAmountField, deleteFlagField, landlineField);
	}


}

