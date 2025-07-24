package com.pomplatform.client.minvocieapplydedaocor.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDMcontracticcccsprfiiibaadicrbbior extends DataSource
{


	public static CDMcontracticcccsprfiiibaadicrbbior instance = null;

	public static CDMcontracticcccsprfiiibaadicrbbior getInstance() {
		if(instance == null) {
			instance = new CDMcontracticcccsprfiiibaadicrbbior("CDMcontracticcccsprfiiibaadicrbbior");
		}
		return instance;
	}

	private final DataSourceIntegerField contractIdField;
	private final DataSourceTextField contractCodeField;
	private final DataSourceTextField contractNameField;
	private final DataSourceTextField customerNameField;
	private final DataSourceIntegerField statusField;
	private final DataSourceTextField projectCodeField;
	private final DataSourceTextField remarkField;
	private final DataSourceIntegerField flowStatusField;
	private final DataSourceTextField infoCodeField;
	private final DataSourceBooleanField isSystemAddField;
	private final DataSourceBooleanField isFinishField;
	private final DataSourceTextField businessTypeField;
	private final DataSourceTextField applyRemarkField;
	private final DataSourceIntegerField applicantIdField;
	private final DataSourceTextField dutyParagraphField;
	private final DataSourceTextField iaCustomerNameField;
	private final DataSourceTextField customerPhoneField;
	private final DataSourceTextField registeredAddressField;
	private final DataSourceTextField bankNameField;
	private final DataSourceTextField bankAccountField;
	private final DataSourceIntegerField invoiceApplyStatusField;

	public CDMcontracticcccsprfiiibaadicrbbior(String dataSourceID) {

		setID(dataSourceID);
		contractIdField = new DataSourceIntegerField("contractId", "主订单编码");
		contractIdField.setRequired(true);
		contractIdField.setLength(11);
		contractIdField.setPrimaryKey(true);
		contractIdField.setHidden(true);

		contractCodeField = new DataSourceTextField("contractCode", "主订单编号");
		contractCodeField.setRequired(false);
		contractCodeField.setLength(64);
		contractCodeField.setHidden(false);

		contractNameField = new DataSourceTextField("contractName", "主订单名称");
		contractNameField.setRequired(false);
		contractNameField.setLength(512);
		contractNameField.setHidden(false);

		customerNameField = new DataSourceTextField("customerName", "客户名称");
		customerNameField.setRequired(false);
		customerNameField.setLength(512);
		customerNameField.setHidden(false);

		statusField = new DataSourceIntegerField("status", "结算状态");
		statusField.setRequired(false);
		statusField.setLength(11);
		statusField.setHidden(false);
		statusField.setValueMap(KeyValueManager.getValueMap("system_dictionary"));

		projectCodeField = new DataSourceTextField("projectCode", "项目编号");
		projectCodeField.setRequired(false);
		projectCodeField.setLength(64);
		projectCodeField.setHidden(false);

		remarkField = new DataSourceTextField("remark", "备注");
		remarkField.setRequired(false);
		remarkField.setLength(512);
		remarkField.setHidden(false);

		flowStatusField = new DataSourceIntegerField("flowStatus", "流转状态，默认为0表示可以提交到运营管理修改承接部门1表示可以提交到运营管理运营价格2表示可以提交到运营管理运营价格审核3表示审核完成");
		flowStatusField.setRequired(false);
		flowStatusField.setLength(11);
		flowStatusField.setHidden(false);

		infoCodeField = new DataSourceTextField("infoCode", "信息编号");
		infoCodeField.setRequired(false);
		infoCodeField.setLength(32);
		infoCodeField.setHidden(false);

		isSystemAddField = new DataSourceBooleanField("isSystemAdd", "是否为erp系统添加  true 为系统添加  false 为数据导入");
		isSystemAddField.setRequired(false);
		isSystemAddField.setHidden(false);

		isFinishField = new DataSourceBooleanField("isFinish", "合同是否完成");
		isFinishField.setRequired(false);
		isFinishField.setHidden(false);

		businessTypeField = new DataSourceTextField("businessType", "业务类别");
		businessTypeField.setRequired(false);
		businessTypeField.setLength(120);
		businessTypeField.setHidden(false);

		applyRemarkField = new DataSourceTextField("applyRemark", "申请备注");
		applyRemarkField.setRequired(false);
		applyRemarkField.setLength(255);
		applyRemarkField.setHidden(false);

		applicantIdField = new DataSourceIntegerField("applicantId", "申请人");
		applicantIdField.setRequired(false);
		applicantIdField.setLength(11);
		applicantIdField.setHidden(false);

		dutyParagraphField = new DataSourceTextField("dutyParagraph", "税号");
		dutyParagraphField.setRequired(false);
		dutyParagraphField.setLength(255);
		dutyParagraphField.setHidden(false);

		iaCustomerNameField = new DataSourceTextField("iaCustomerName", "联系人");
		iaCustomerNameField.setRequired(false);
		iaCustomerNameField.setLength(255);
		iaCustomerNameField.setHidden(false);

		customerPhoneField = new DataSourceTextField("customerPhone", "联系电话");
		customerPhoneField.setRequired(false);
		customerPhoneField.setLength(255);
		customerPhoneField.setHidden(false);

		registeredAddressField = new DataSourceTextField("registeredAddress", "注册地址");
		registeredAddressField.setRequired(false);
		registeredAddressField.setLength(255);
		registeredAddressField.setHidden(false);

		bankNameField = new DataSourceTextField("bankName", "bank_name");
		bankNameField.setRequired(false);
		bankNameField.setLength(255);
		bankNameField.setHidden(false);

		bankAccountField = new DataSourceTextField("bankAccount", "bank_account");
		bankAccountField.setRequired(false);
		bankAccountField.setLength(255);
		bankAccountField.setHidden(false);

		invoiceApplyStatusField = new DataSourceIntegerField("invoiceApplyStatus", "申请状态  1申请中 2已处理 3已驳回");
		invoiceApplyStatusField.setRequired(false);
		invoiceApplyStatusField.setLength(11);
		invoiceApplyStatusField.setHidden(false);

		DataSourceIntegerField currentPageField
			= new DataSourceIntegerField("currentPage", "当前页");
		currentPageField.setRequired(true);
		currentPageField.setLength(10);
		currentPageField.setHidden(true);

		DataSourceIntegerField pageLinesField
			= new DataSourceIntegerField("pageLines", "每页行数");
		pageLinesField.setRequired(true);
		pageLinesField.setLength(10);
		pageLinesField.setHidden(true);


		setFields(contractIdField, contractCodeField, contractNameField, customerNameField, statusField, projectCodeField, remarkField, flowStatusField, infoCodeField, isSystemAddField, isFinishField, businessTypeField, applyRemarkField, applicantIdField, dutyParagraphField, iaCustomerNameField, customerPhoneField, registeredAddressField, bankNameField, bankAccountField, invoiceApplyStatusField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

