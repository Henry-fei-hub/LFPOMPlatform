package com.pomplatform.client.minvocieapplydedaocor.datasource;

import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.smartgwt.client.data.fields.DataSourceDateTimeField;
import com.smartgwt.client.data.fields.DataSourceFloatField;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;

public class DSMinvocieapplydedaocor extends DBDataSource
{


	public static DSMinvocieapplydedaocor instance = null;

	public static DSMinvocieapplydedaocor getInstance() {
		if(instance == null) {
			instance = new DSMinvocieapplydedaocor("DSMinvocieapplydedaocor");
		}
		return instance;
	}

	private final DataSourceIntegerField invoiceApplyIdField;
	private final DataSourceIntegerField applicantIdField;
	private final DataSourceTextField applicantNameField;
	private final DataSourceIntegerField applicantDeparmentIdField;
	private final DataSourceTextField departmentNameField;
	private final DataSourceIntegerField contractIdField;
	private final DataSourceTextField contractNameField;
	private final DataSourceTextField contractCodeField;
	private final DataSourceTextField companyNameField;
	private final DataSourceTextField dutyParagraphField;
	private final DataSourceIntegerField invoiceTypeField;
	private final DataSourceTextField customerNameField;
	private final DataSourceTextField customerPhoneField;
	private final DataSourceTextField registeredAddressField;
	private final DataSourceTextField bankNameField;
	private final DataSourceTextField bankAccountField;
	private final DataSourceDateTimeField applyTimeField;
	private final DataSourceFloatField applySumMoneyField;
	private final DataSourceTextField applyRemarkField;
	private final DataSourceIntegerField operatorIdField;
	private final DataSourceTextField operatorRemarkField;
	private final DataSourceTextField operatorNameField;
	private final DataSourceIntegerField invoiceApplyStatusField;
	private final DataSourceDateTimeField operatorTimeField;
	private final DataSourceDateTimeField createTimeField;
	private final DataSourceDateTimeField updateTimeField;
	private final DataSourceTextField landlineField;

	public DSMinvocieapplydedaocor(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("Minvocieapplydedaocor");


		invoiceApplyIdField = new DataSourceIntegerField("invoiceApplyId", "主键");
		invoiceApplyIdField.setLength(11);
		invoiceApplyIdField.setPrimaryKey(true);
		invoiceApplyIdField.setRequired(true);
		invoiceApplyIdField.setHidden(true);


		applicantIdField = new DataSourceIntegerField("applicantId", "申请人");
		applicantIdField.setLength(11);
		applicantIdField.setRequired(false);
		applicantIdField.setHidden(true);


		applicantNameField = new DataSourceTextField("applicantName", "申请人名称");
		applicantNameField.setLength(64);
		applicantNameField.setRequired(true);
		applicantNameField.setHidden(true);


		applicantDeparmentIdField = new DataSourceIntegerField("applicantDeparmentId", "申请人部门ID");
		applicantDeparmentIdField.setLength(11);
		applicantDeparmentIdField.setRequired(false);
		applicantDeparmentIdField.setHidden(true);


		departmentNameField = new DataSourceTextField("departmentName", "部门名称");
		departmentNameField.setLength(64);
		departmentNameField.setRequired(true);
		departmentNameField.setHidden(true);


		contractIdField = new DataSourceIntegerField("contractId", "合同主键");
		contractIdField.setLength(11);
		contractIdField.setRequired(false);
		contractIdField.setHidden(true);
		contractIdField.setForeignKey("DSMcontracticcccsprfiiibaadicrbbior.contractId");


		contractNameField = new DataSourceTextField("contractName", "合同名称");
		contractNameField.setLength(512);
		contractNameField.setRequired(false);
		contractNameField.setHidden(true);


		contractCodeField = new DataSourceTextField("contractCode", "合同编号");
		contractCodeField.setLength(64);
		contractCodeField.setRequired(false);
		contractCodeField.setHidden(true);


		companyNameField = new DataSourceTextField("companyName", "单位名称");
		companyNameField.setLength(255);
		companyNameField.setRequired(false);
		companyNameField.setHidden(false);


		dutyParagraphField = new DataSourceTextField("dutyParagraph", "税号");
		dutyParagraphField.setLength(255);
		dutyParagraphField.setRequired(false);
		dutyParagraphField.setHidden(false);


		invoiceTypeField = new DataSourceIntegerField("invoiceType", "发票类型");
		invoiceTypeField.setLength(11);
		invoiceTypeField.setRequired(false);
		invoiceTypeField.setHidden(true);
		invoiceTypeField.setValueMap(KeyValueManager.getValueMap("system_dictionary_52"));


		customerNameField = new DataSourceTextField("customerName", "邮寄人名称");
		customerNameField.setLength(255);
		customerNameField.setRequired(false);
		customerNameField.setHidden(false);


		customerPhoneField = new DataSourceTextField("customerPhone", "邮寄人电话");
		customerPhoneField.setLength(255);
		customerPhoneField.setRequired(false);
		customerPhoneField.setHidden(false);
		
		landlineField = new DataSourceTextField("landline", "固定电话");
		landlineField.setLength(255);
		landlineField.setRequired(false);
		landlineField.setHidden(false);

		registeredAddressField = new DataSourceTextField("registeredAddress", "注册地址");
		registeredAddressField.setLength(255);
		registeredAddressField.setRequired(false);
		registeredAddressField.setHidden(false);


		bankNameField = new DataSourceTextField("bankName", "开户银行");
		bankNameField.setLength(255);
		bankNameField.setRequired(false);
		bankNameField.setHidden(false);


		bankAccountField = new DataSourceTextField("bankAccount", "银行账号");
		bankAccountField.setLength(255);
		bankAccountField.setRequired(false);
		bankAccountField.setHidden(false);


		applyTimeField = new DataSourceDateTimeField("applyTime", "申请日期");
		applyTimeField.setRequired(false);
		applyTimeField.setHidden(true);


		applySumMoneyField = new DataSourceFloatField("applySumMoney", "申请总金额");
		applySumMoneyField.setLength(0);
		applySumMoneyField.setDecimalPad(0);
		applySumMoneyField.setFormat("");
		applySumMoneyField.setRequired(false);
		applySumMoneyField.setHidden(true);


		applyRemarkField = new DataSourceTextField("applyRemark", "邮寄人地址");
		applyRemarkField.setLength(255);
		applyRemarkField.setRequired(false);
		applyRemarkField.setHidden(false);


		operatorIdField = new DataSourceIntegerField("operatorId", "操作人Id");
		operatorIdField.setLength(11);
		operatorIdField.setRequired(false);
		operatorIdField.setHidden(true);


		operatorRemarkField = new DataSourceTextField("operatorRemark", "驳回理由");
		operatorRemarkField.setLength(255);
		operatorRemarkField.setRequired(false);
		operatorRemarkField.setHidden(true);


		operatorNameField = new DataSourceTextField("operatorName", "操作人");
		operatorNameField.setLength(64);
		operatorNameField.setRequired(true);
		operatorNameField.setHidden(true);


		invoiceApplyStatusField = new DataSourceIntegerField("invoiceApplyStatus", "申请状态");
		invoiceApplyStatusField.setLength(11);
		invoiceApplyStatusField.setRequired(false);
		invoiceApplyStatusField.setHidden(true);
		invoiceApplyStatusField.setValueMap(KeyValueManager.getValueMap("system_dictionary_61"));

		operatorTimeField = new DataSourceDateTimeField("operatorTime", "操作时间");
		operatorTimeField.setRequired(false);
		operatorTimeField.setHidden(true);


		createTimeField = new DataSourceDateTimeField("createTime", "创建时间");
		createTimeField.setRequired(false);
		createTimeField.setHidden(true);


		updateTimeField = new DataSourceDateTimeField("updateTime", "修改时间");
		updateTimeField.setRequired(false);
		updateTimeField.setHidden(true);


		setFields(invoiceApplyIdField, applicantIdField, applicantNameField, applicantDeparmentIdField, departmentNameField, contractIdField, contractNameField, contractCodeField, companyNameField, dutyParagraphField, invoiceTypeField, customerNameField, customerPhoneField, landlineField, registeredAddressField, bankNameField, bankAccountField, applyTimeField, applySumMoneyField, applyRemarkField, operatorIdField, operatorRemarkField, operatorNameField, invoiceApplyStatusField, operatorTimeField, createTimeField, updateTimeField);
	}


}

